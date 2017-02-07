package opdr8_2;

public class Auto {
	
	private String type;
	private double prijsPerDag;
	
	public Auto(String tp, double ppd){
		type = tp;
		prijsPerDag = ppd;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrijsPerDag() {
		return prijsPerDag;
	}

	public void setPrijsPerDag(double prijsPerDag) {
		this.prijsPerDag = prijsPerDag;
	}
	
	public String toString(){
		return "autotype: " + type + " met prijs per dag: " + prijsPerDag ;
	}

}
