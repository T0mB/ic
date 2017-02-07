package p2oef5;

public class Transportmiddel {
	protected String naam;
	protected String aandrijving;

	public Transportmiddel(String nm) {
		naam = nm;
	}

	public String getAandrijving() {
		return aandrijving;
	}

	public void setAandrijving(String aandrijving) {
		this.aandrijving = aandrijving;
	}

	public String getNaam() {
		return naam;
	}
	

	public String toString() {
		return "Dit transportmiddel " + naam + " wordt aangedreven door "
				+ aandrijving + "\n";
	}
}
