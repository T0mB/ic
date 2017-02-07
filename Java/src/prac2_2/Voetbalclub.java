package prac2_2;

public class Voetbalclub {
	private String naam;
	private int verwerkResultaat;
	private int aantalGewonnen;
	private int aantalGelijk;
	private int aantalVerloren;
	
	
	public Voetbalclub (String naam, int vrwRes, int aantG, int aantGl, int aantVerl) {
		
		this.naam = naam;
		verwerkResultaat = vrwRes;
		aantalGewonnen = aantG;
		aantalGelijk = aantGl;
		aantalVerloren = aantVerl;
		
	}
	


	public void verwerkResultaat(char ch) {
		if (ch == 'w')
		aantalGewonnen = aantalGewonnen + 1;
		if (ch == 'g')
		aantalGelijk = aantalGelijk + 1;
		if (ch == 'v')
		aantalVerloren = aantalVerloren + 1;
		}



	public int getVerwerkResultaat() {
		return verwerkResultaat;
	}


	public void setVerwerkResultaat(int verRes) {
		verwerkResultaat = verRes;
	}
	
	public String toString(){
		return naam + " " + aantalGewonnen + " " + aantalGelijk + " " + aantalVerloren;
	}

}
