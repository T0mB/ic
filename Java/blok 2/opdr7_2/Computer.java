package opdr7_2;

import java.text.NumberFormat;
import java.util.Calendar;

public class Computer extends Goed {
	
	@SuppressWarnings("unused")
	private String type;
	
	public Computer(String merk, double nieuwPrijs, int bouwJaar, String type){
		super(merk, nieuwPrijs, bouwJaar);
		this.type = type;
	}
	
	
	public double huidigeWaarde() {
		int huidigJaar = Calendar.getInstance().get(Calendar.YEAR);
		int aantalJaar = huidigJaar - bouwJaar;
		double huidigePrijs = nieuwPrijs;
		for (int index = 0; index < aantalJaar; index += 1) {
			huidigePrijs *= 0.6;
		}
		return huidigePrijs;
	}
	
	public String toString() {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
		return "Computer " + merk + "; nieuwPrijs: " + nieuwPrijs + "; bouwjaar: " + bouwJaar + "; met huidige waarde: " + nf.format(huidigeWaarde());
	}

}
