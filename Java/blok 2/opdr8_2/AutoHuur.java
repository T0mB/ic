package opdr8_2;

public class AutoHuur {

	private int aantalDagen = 0;
	private Auto gehuurdeAuto;
	private Klant huurder;
	
	public AutoHuur(Auto auto, Klant huurder){
		gehuurdeAuto =auto;
		this.huurder = huurder;
	}
	
	public AutoHuur(){
		
	}

	

	public Auto getGehuurdeAuto() {
		return gehuurdeAuto;
	}

	public void setGehuurdeAuto(Auto gehuurdeAuto) {
		this.gehuurdeAuto = gehuurdeAuto;
	}

	public Klant getHuurder() {
		return huurder;
	}

	public void setHuurder(Klant huurder) {
		this.huurder = huurder;
	}

	public int getAantalDagen() {
		return aantalDagen;
	}

	public void setAantalDagen(int aantalDagen) {
		this.aantalDagen = aantalDagen;
	}

	public double totaalPrijs() {
		double prijs = 0.0;
		if (gehuurdeAuto != null && huurder != null) {
			prijs = (aantalDagen * gehuurdeAuto.getPrijsPerDag())
					* (1 - (huurder.getKortingsPercentage() / 100));
		}
		return prijs;
	}

	public String toString() {
		String auto = " ";

		if (gehuurdeAuto == null) {
			auto = "er is geen auto";
		}

		else {
			auto = "auto type: " + gehuurdeAuto.getType()
					+ " met prijs per dag: " + gehuurdeAuto.getPrijsPerDag()
					+ "\n";
		}
		

		String huur = " ";
		if (huurder == null) {
			huur = " er is geen persoon ";
		}
		
		else{
			huur = "op naam van: " + huurder.getNaam() + "\n" + " Korting " + huurder.getKortingsPercentage();
		}
		
		String price = " aantal dagen " + aantalDagen + " en dat kost " + totaalPrijs();
	
		
		return auto + huur + price;

	}
}
