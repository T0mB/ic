package opdr8_2;

public class Klant {
	
	private String naam;
	private double kortingsPercentage;
	
	public Klant (String nm){
		naam =nm;
		
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public double getKortingsPercentage() {
		return kortingsPercentage;
	}

	public void setKortingsPercentage(double kortingsPercentage) {
		this.kortingsPercentage = kortingsPercentage;
	}
	
	public String toString(){
		return " ";
	}

}
