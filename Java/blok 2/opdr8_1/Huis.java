package opdr8_1;

public class Huis {
	private String adres;
	private int bouwJaar;
	private Persoon huisbaas;
	
	public Huis(String adr, int bwJr){
		adres = adr;
		bouwJaar = bwJr;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public int getBouwJaar() {
		return bouwJaar;
	}

	public void setBouwJaar(int bouwJaar) {
		this.bouwJaar = bouwJaar;
	}
	
	
	
	public Persoon getHuisbaas() {
		return huisbaas;
	}

	public void setHuisbaas(Persoon huisbaas) {
		this.huisbaas = huisbaas;
	}

	public String toString(){
		return "Huis: " + adres + " gebouwd in: " + bouwJaar + " en heeft huisbaas " + huisbaas;
	}
	
	

}
