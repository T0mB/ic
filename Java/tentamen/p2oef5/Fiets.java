package p2oef5;

public class Fiets extends Transportmiddel {

	private int aantalWielen;

	public Fiets(String naam, int aantWiel) {
		super(naam);
		aantalWielen = aantWiel;
	}

	public int getAantalWielen() {
		return aantalWielen;
	}

	public String toString() {
		return "Dit is een " + naam + " met " + aantalWielen + " wielen"
				+ " aandgedreven door " + aandrijving;
	}
}
