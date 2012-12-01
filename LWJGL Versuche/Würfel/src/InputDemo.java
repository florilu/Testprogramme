import static org.lwjgl.opengl.GL11.*;

import java.util.ArrayList;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.lwjgl.opengl.GL11.*;

public class InputDemo
{
	private static List<Box> shapes = new ArrayList<Box>(16);
	private static boolean somethingIsSelected = false;
	private static boolean randomColorCooldown = false;
	
	private static synchronized void setRandomColorCooldown(boolean value) {
        randomColorCooldown = value;
    }
	
	private static synchronized boolean getRandomColorCooldown() {
        return randomColorCooldown;
    }
	
	public static void main(String[] args)
	{
		try{
			Display.setDisplayMode(new DisplayMode(640, 480));
			Display.setTitle("Test");
			Display.create();
		}catch(LWJGLException e){
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}
		shapes.add(new Box(15, 15));
		shapes.add(new Box(100, 150));
		
		//Initialisierungscode OpenGL
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 640, 480, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
		while(!Display.isCloseRequested())
		{
			//Render
			
			glClear(GL_COLOR_BUFFER_BIT);
			
			while(Keyboard.next()){
				if(Keyboard.getEventKey() == Keyboard.KEY_C && Keyboard.getEventKeyState()){
					shapes.add(new Box(15, 15));
				}
			}
			
			
			if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
				Display.destroy();
				System.exit(0);
			}
			
			for(final Box box : shapes){
				if(Mouse.isButtonDown(0) && box.inBounds(Mouse.getX(), 480 - Mouse.getY()) && !somethingIsSelected){
					box.selected = true;
					somethingIsSelected = true;
				}else{
					box.selected = false;
					somethingIsSelected = false;
				}
				if(Mouse.isButtonDown(2) && box.inBounds(Mouse.getX(), 480 - Mouse.getY()) && !somethingIsSelected){
					if(getRandomColorCooldown() == false){
						setRandomColorCooldown(true);
					}else{
						new Thread(new Runnable(){

							@Override
							public void run() {
								try{
									Thread.sleep(2000);
								}catch(InterruptedException e){
									e.printStackTrace();
								}
								box.randomizeColors();
								randomColorCooldown = false;
								
							}
							
						}).start();
					}
				}
				if(box.selected){
					box.update(Mouse.getDX(), -Mouse.getDY());
				}
			    box.draw();
			}
			
			/*int mousey = Mouse.getY();
			int mousex = Mouse.getX();
			System.out.println(mousex+", "+mousey);*/
			
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
		System.exit(0);
	}
	
	private static class Box extends InputDemo
	{
		public int x, y;
		public boolean selected = false;
		private float colorRed, colorBlue, colorGreen;
		
		void update(int dx, int dy){
			x += dx;
			y += dy;
		}
		
		boolean inBounds(int mousex, int mousey){
			if(mousex > x && mousex < x + 50 && mousey > y && mousey < y + 50){
				return true;
			}else{
				return false;
			}
		}
		
		Box(int x, int y){
			this.x = x;
			this.y = y;
			
			Random random = new Random();
			colorRed = random.nextFloat();
			colorGreen = random.nextFloat();
			colorBlue = random.nextFloat();
		}
		
		void randomizeColors()
		{
			Random random = new Random();
			colorRed = random.nextFloat();
			colorGreen = random.nextFloat();
			colorBlue = random.nextFloat();
		}
		
		void draw(){
			
			glColor3f(colorRed, colorGreen, colorBlue);
			
			glBegin(GL_QUADS);
			glVertex2f(x, y);
			glVertex2f(x + 50, y);
			glVertex2f(x + 50, y + 50);
			glVertex2f(x, y + 50);
			glEnd();
		}
	}
}