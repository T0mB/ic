package opdracht_6;

public class Kaart {

	private String soort;
	private String waarde;

	public Kaart() {

	}

	public Kaart(String wrd, String srt) {
		waarde = wrd;
		soort = srt;

	}

	public void setSoort(String srt) {
		soort = srt;
	}

	public void setWaarde(String wrd) {
		waarde = wrd;
	}

	public String getWaarde() {
		return waarde;
	}

	public String getSoort() {
		return soort;
	}

	public String toString() {
		return "" + soort + " " + waarde + " \n";
	}

}