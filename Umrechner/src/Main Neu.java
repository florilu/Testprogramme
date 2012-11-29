import java.io.*;
import java.util.*;

public class Main
{	
	static void leer(int par1)
	{
		for(int a = 1; a <= par1; a++)
		{
			println("");
		}
	}
	
	@SuppressWarnings("resource")
	static void toHex() throws Exception
	{
		Scanner scanner = new Scanner(System.in);
		
		print("Bitte geben sie die Dezimalzahl ein: ");
		int a = scanner.nextInt();
		String d = (Integer.toHexString(a));
		println("Die Hexadezimalzahl: "+d);
		leer(1);
	}
	
	static void random()
	{
		for(int a = 0; a <= 1; a++)
		{
			a = (a - 1);
			int b;
			String c;
			String d;
			b = (int) (Math.random()*1000000);
			c =  (Integer.toBinaryString(b));
			d = (Integer.toHexString(b));
			println("Dezimal: "+b);
			println("Binaer: "+c);
			println("Hex: "+d);
			leer(1);
			sleep(2);
		}
	}
	
	static void print(String a)
	{
		System.out.print(a);
	}
	
	static void println(String a)
	{
		System.out.println(a);
	}
	
	static void sleep(long par1)
	{
		par1 = (par1 * 1000);
		try
		{
			Thread.sleep(par1);
		}catch(InterruptedException e){
			
		}
	}
	
	static void header()
	{
		println("===========");
		println("==Eingabe==");
		println("===========");
		println("");
	}
	
	static void hex() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		print("Hexadezimalzahl: ");
		String hex = br.readLine();
		println("Die Dezimalzahl ist: "+Integer.parseInt(hex, 16));
		leer(1);
	}
	
	static void decimal()
	{
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		int a;
		
		print("Dezimalzahl: ");
		a = scanner.nextInt();
		println("Bitte warten sie auf das Ergebnis!");
		sleep(1);
		leer(1);
		println("Die Binaerzahl ist: "+Integer.toBinaryString(a));
		leer(1);
	}
	
	static void binary() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		print("Binearzahl: ");
		String s = br.readLine();
		sleep(1);
		println("Die Dezimalzahl ist: "+Integer.parseInt(s, 2));
		leer(1);
	}
	
	public static void main(String[] args) throws Exception
	{
		{
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			
			header();
			println("Bitte geben sie die gewuenschte Option ein.");
			println("1 = Dezimal zu Binaer; 2 = Binaer zu Dezimal.");
			println("3 = Hexadezimal zu Dezimal; 4 = Random Bullshit.");
			println("5 = Dezimal zu Hexadezimal.");
			print("Option: ");
		    int b = scanner.nextInt();
			if(b == 1){
				decimal();
			}else if(b == 2){
				binary();
			}else if(b == 3){
				hex();
			}else if(b == 4){
				random();
			}else if(b == 5){
				toHex();
			}else{
				println("Ungueltige Eingabe!");
			}
			println("Wollen sie noch einmal starten? ja/nein");
			print("Antwort: ");
		    String an = scanner.next().toLowerCase();
			if(an.equals("ja"))
			{
				main(args);
			}else if(an.equals("nein"))
			{
				println("Sind sie sicher? ja/nein");
				String i = scanner.next().toLowerCase();
				if(i.equals("ja"))
				{
					System.exit(b);
				}else if(i.equals("nein"))
				{
					main(args);
				}else
				{
					println("Ungueltige Eingabe!");
					sleep(3);
				}
			}else
			{
				println("Falsche Eingabe!");
			}
		}
	}
}