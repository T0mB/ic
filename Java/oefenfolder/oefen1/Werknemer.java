package oefen1;

public class Werknemer {
	
	private String naam;
	private Adres woonadres;
	
	public Werknemer(String naam, Adres woonadres){
		this.naam = naam;
		
		
	}
	
	public Adres getWoonadres() {
		return woonadres;
	}

	public void setWoonadres(Adres woonadres) {
		this.woonadres = woonadres;
	}



	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	
	
	public String toString(){
		return "deze werknemer heet " + naam + " woont op " + woonadres ;
	}

}
