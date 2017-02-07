package opdr10_2;

import java.text.NumberFormat;
import java.util.Calendar;

public class Computer {
	private String merk, type;
	private double aanschafPrijs;
	private int aanschafJaar;

	public Computer(String mk, double prijs, int jaar, String tp) {
		merk = mk;
		aanschafPrijs = prijs;
		aanschafJaar = jaar;
		type = tp;
	}

	public String getMerk() {
		return merk;
	}

	public double huidigeWaarde() {
		int huidigJaar = Calendar.getInstance().get(Calendar.YEAR);
		int aantalJaar = huidigJaar - aanschafJaar;
		double huidigePrijs = aanschafPrijs;
		for (int i = 0; i < aantalJaar; i += 1) {
			huidigePrijs *= 0.6;
		}
		return huidigePrijs;
	}
	
	
		public String toString() {
			NumberFormat nf = NumberFormat.getInstance();
			nf.setMinimumFractionDigits(2);
			nf.setMaximumFractionDigits(2);
			return "Computer " + merk + "; aanschafPrijs: " + aanschafPrijs + "; aanschafjaar: " + aanschafJaar + "; met huidige waarde: " + nf.format(huidigeWaarde());
		
	}

}
