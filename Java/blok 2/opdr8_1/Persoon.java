package opdr8_1;

public class Persoon {
	private String naam;
	private int leeftijd;
	

	public Persoon(String nm, int lft) {
		naam = nm;
		leeftijd = lft;

	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	
	

	public int getLeeftijd() {
		return leeftijd;
	}

	public void setLeeftijd(int leeftijd) {
		this.leeftijd = leeftijd;
	}

	public String toString(){
		return naam + " is " + leeftijd + " oud";
	}
}
