package p2oef4;

public class Huis {
	private int jaar;
	private String adres;
	private Persoon huisbaas;

	public Huis(int jaar, String adres) {

		this.jaar = jaar;
		this.adres = adres;

	}

	public int getJaar() {
		return jaar;
	}

	public void setJaar(int jaar) {
		this.jaar = jaar;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public Persoon getHuisbaas() {
		return huisbaas;
	}

	public void setHuisbaas(Persoon huisbaas) {
		this.huisbaas = huisbaas;
	}

	public String toString() {
		return "Dit huis is gebouwd in: " + jaar + " en het adres is " + adres
				+ "\n En de huisbaas is " + huisbaas;
	}

}
