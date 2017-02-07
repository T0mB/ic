package p2oef5;

public class Main {
	public static void main(String[] arg) {
		System.out.println("Opgave over Superklasse en Subklasse");
		Transportmiddel t1 = new Transportmiddel("stoomboot");
		t1.setAandrijving("stoom");
		System.out.println("Eerste transportmiddel: " + t1.toString());
		System.out.println();
		Transportmiddel t2 = new Fiets("mountainbike", 2);
		t2.setAandrijving("beenspierkracht");
		System.out.println("Tweede transportmiddel: " + t2.toString());
	}
}