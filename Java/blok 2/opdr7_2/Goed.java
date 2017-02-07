package opdr7_2;

public abstract class Goed {
	
	protected String merk;
	protected double nieuwPrijs;
	protected int bouwJaar;
	
	public Goed(String mk, double prijs	, int jaar){
		merk = mk;
		nieuwPrijs = prijs;
		bouwJaar = jaar;
	}
	
	
	public abstract double huidigeWaarde();
	
	public String toString(){
		return " ";
	}

}
