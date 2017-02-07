package opdr8_3;

public class Scooter {
	private String merk;
	private double nieuwPrijs;
	
	public Scooter(String mk, double nP){
		merk = mk;
		nieuwPrijs = nP;
	}

	public String getMerk() {
		return merk;
	}

	public void setMerk(String merk) {
		this.merk = merk;
	}

	public double getNieuwPrijs() {
		return nieuwPrijs;
	}

	public void setNieuwPrijs(double nieuwPrijs) {
		this.nieuwPrijs = nieuwPrijs;
	}
	
	public String toString(){
		return "Deze " + merk + " kost " + nieuwPrijs + "Euro (aanschafprijs)";
	}
	

}
