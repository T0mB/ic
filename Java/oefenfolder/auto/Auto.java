package auto;

public class Auto {
	private String kenteken;
	private Klant deKlant;
	
	public Auto(String knt){
		kenteken = knt;
	}

	public String getKenteken() {
		return kenteken;
	}

	public void setKenteken(String kenteken) {
		this.kenteken = kenteken;
	}
	
	public Klant getDeKlant() {
		return deKlant;
	}

	public void setDeKlant(Klant deKlant) {
		this.deKlant = deKlant;
	}

	public String toString(){
		return "Auto met kenteken " + kenteken + " is eigendom van " + deKlant.getNaam();
	}

}
