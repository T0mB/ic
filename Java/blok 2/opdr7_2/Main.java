package opdr7_2;


import java.util.Calendar;


public class Main {
	public static void main(String[] args) {
		
		int huidigJaar = Calendar.getInstance().get(Calendar.YEAR);
		int bouwJaarG1 = huidigJaar - 4; // g1 is 4 jaar oud
		int bouwJaarG2 = huidigJaar - 3; // g2 is 3 jaar oud
		int bouwJaarG3 = huidigJaar - 4;
		int bouwJaarG4 = huidigJaar - 3;
		int bouwJaarG5 = huidigJaar - 13;
		int bouwJaarG6 = huidigJaar - 6; // g6 is 6 jaar oud
		Goed g1 = new Auto("Citroen", 25000,bouwJaarG1,"26 GR" + "NJ");
		Goed g2 = new Auto("Renault", 30000,bouwJaarG2,"71 JHKD");
		Goed g3 = new Computer("Medion", 2000, bouwJaarG3,"Super");
		Goed g4 = new Computer("Dell", 1500, bouwJaarG4, "Home");
		Goed g5 = new Huis("Starters Woning", 210000.00, bouwJaarG5, 85);
		Goed g6 = new Huis("Villa", 975000.00, bouwJaarG6, 315);
		System.out.println(g1);
		System.out.println(g2);
		System.out.println(g3);
		System.out.println(g4);
		System.out.println(g5);
		System.out.println(g6);
		}
}