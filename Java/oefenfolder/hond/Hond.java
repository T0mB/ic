package hond;

public class Hond {
	
	private String naam;
	private static int aantalHonden =0;
	
	public Hond (String naam){
		this.naam = naam;
		aantalHonden++;
	}
	
	public static int getAantalHonden(){
		return aantalHonden;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public static void setAantalHonden(int aantalHonden) {
		Hond.aantalHonden = aantalHonden;
	}
	
	public String toString(){
		return "Deze hond heet " + naam;
	}

}
