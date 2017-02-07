package opdr8_3;

public class Lener {
	private String naam;
	private boolean isKredietWaardig;

	public Lener(String nm, boolean iK) {
		naam = nm;
		isKredietWaardig = iK;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public boolean isKredietWaardig() {
		return isKredietWaardig;
	}

	public void setIsKredietWaardig(boolean isKredietWaardig) {
		this.isKredietWaardig = isKredietWaardig;

	}

	public String toString() {
		if (isKredietWaardig) {
			return naam + " is krediet waardig ";

		} else if (!isKredietWaardig) {
			
			return naam + " niet krediet waardig";
		}
		return "";
		

	}
}
