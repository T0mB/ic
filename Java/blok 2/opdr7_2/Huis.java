package opdr7_2;

import java.text.NumberFormat;
import java.util.Calendar;

public class Huis extends Goed {
	
	@SuppressWarnings("unused")
	private int oppervlakte;
	
	public Huis (String merk, double nieuwPrijs, int bouwJaar, int opp){
		super(merk, nieuwPrijs, bouwJaar);
		oppervlakte = opp;
	}
	
	public double huidigeWaarde(){
		int huidigJaar = Calendar.getInstance().get(Calendar.YEAR);
		int aantalJaar = huidigJaar - bouwJaar;
		double huidigePrijs = nieuwPrijs;
		for (int index = 0; index < aantalJaar; index += 1) {
			huidigePrijs *= 1.05;
		}
		return huidigePrijs;
	}
	
	public String toString() {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
		return "Huis: " + merk + "; nieuwPrijs: " + nieuwPrijs + "; bouwjaar: " + bouwJaar + "; met huidige waarde: " + nf.format(huidigeWaarde());
	}
	

}
