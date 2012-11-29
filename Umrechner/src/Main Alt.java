import java.io.*;
import java.util.*;

public class Main
{	
	static void leer()
	{
		System.out.println();
	}
	
	static void sleep(int par1)
	{
		try
		{
			Thread.sleep(par1);
		}catch(InterruptedException e){
			
		}
	}
	
	static void header()
	{
		System.out.println("===========");
		System.out.println("==Eingabe==");
		System.out.println("===========");
		System.out.println();
	}
	
	static void hex() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Hexadezimalzahl: ");
		String hex = br.readLine();
		System.out.println("Die Dezimalzahl ist: "+Integer.parseInt(hex, 16));
	}
	
	static void decimal()
	{
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		int a;
		
		System.out.print("Dezimalzahl: ");
		a = scanner.nextInt();
		System.out.println("Bitte warten sie auf das Ergebnis!");
		leer();
		System.out.println("Die Binaerzahl ist: "+Integer.toBinaryString(a));
	}
	
	static void binary() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Binearzahl: ");
		String s = br.readLine();
		sleep(1000);
		System.out.println("Die Dezimalzahl ist: "+Integer.parseInt(s, 2));
	}
	
	public static void main(String[] args) throws Exception
	{
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		header();
		System.out.println("Bitte geben sie die gewuenschte Option ein.");
		System.out.println("1 = Dezimal zu Binaer; 2 = Binaer zu Dezimal.");
		System.out.println("3 = Hexadezimal zu Dezimal.");
		System.out.print("Option: ");
		int b = scanner.nextInt();
		if(b == 1)
		{
			decimal();
		}else if(b == 2){
			binary();
		}else if(b == 3){
			hex();
		}else{
			System.out.println("Ungueltige Eingabe!");
		}
	}
}