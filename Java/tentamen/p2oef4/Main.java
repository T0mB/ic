package p2oef4;

public class Main {
	public static void main(String[] arg) {
		Huis h1 = new Huis(1956, "Oudenoord 700");
		Persoon p1 = new Persoon("Jan", true);
		p1.setLeeftijd(58);
		System.out.println("Persoon 1: " + p1.toString());
		System.out.println("Huis 1: " + h1.toString());
		System.out.println();
		h1.setHuisbaas(p1);
		System.out.println("Huis 1: " + h1.toString() + "\n");
		Persoon p2 = new Persoon("Else", false);
		p2.setLeeftijd(31);
		System.out.println("Persoon 2: " + p2);
		h1.setHuisbaas(p2);
		System.out.println("Huis 1: " + h1 + "\n");
		Persoon p3 = new Persoon("Cornelis", true);
		p3.setLeeftijd(64);
		Huis h2 = new Huis(1984, "Utenhovenweg 73");
		h2.setHuisbaas(p3);
		System.out.println("Huis 2: " + h2);
	}
}