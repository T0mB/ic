package opdr2_1;

public class Piloot 
{
	private String naam;
	private int vliegUren;
	private double salaris;
	private int verhoogVliegurenMet;
	
	public Piloot (String nm){
		naam = nm;
	}
	
	public Piloot (String nm, int vlur, double sal, int Vhvumet){
		naam = nm;
		vliegUren = vlur;
		salaris = sal;
		verhoogVliegurenMet = Vhvumet;
	}
	
	public String getNaam(){
		return naam;
	}
	
	public int getVliegUren(){
		return vliegUren;
	}
	
	public double getSalaris(){
		return salaris;
	}
	public void setSalaris(double nwSal){
		salaris = nwSal;
	}
	
	public void setVerhoogVliegurenMet(int nwVhvumet){
		verhoogVliegurenMet = nwVhvumet;
	}
	
	public String toString(){
		String s= naam + "heeft" + vliegUren + " gemaakt en verdient " + salaris + verhoogVliegurenMet;
		return s;
	}

}
