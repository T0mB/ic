package oefen;

public class Main 
{
	public static void main(String[] arg){
			Dier h1 = new Hond("Rin tin tin", 95, 4);
			System.out.println(h1.toString());
			System.out.println(h1.speak());
			Hond h2 = new Hond("Joe", 100, 4);
			System.out.println(h2.toString());
			System.out.println(h2.speak());
			System.out.println(h2.speak("blaf"));
			
	}

}
