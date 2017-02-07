package oefen1;

public class Adres {
	
	private String straat, toevoeging;
	private int huisnummer;
	
	public Adres(String straat, int huisnummer, String toevoeging){
		this.straat = straat;
		
		this.huisnummer = huisnummer;
		this.toevoeging = toevoeging;
	}

	public String getStraat() {
		return straat;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	public String getToevoeging() {
		return toevoeging;
	}

	public void setToevoeging(String toevoeging) {
		this.toevoeging = toevoeging;
	}

	public int getHuisnummer() {
		return huisnummer;
	}

	public void setHuisnummer(int huisnummer) {
		this.huisnummer = huisnummer;
	}
	
	public String toString(){
		return straat +" " +  huisnummer + toevoeging;
	}

}
