package p2oef4;

public class Persoon {
	private String naam;
	private int leeftijd;
	private boolean isMan;
	
	
	public Persoon(String naam, boolean isMan) {
	
		this.naam = naam;
		this.isMan = isMan;
		
	
	}
	
	public void setIsMan(boolean ism){
		isMan = ism;
	}


	public String getNaam() {
		return naam;
	}
	
	public boolean isMan(){
		return isMan;
	}


	public void setNaam(String naam) {
		this.naam = naam;
	}


	public int getLeeftijd() {
		return leeftijd;
	}


	public void setLeeftijd(int leeftijd) {
		this.leeftijd = leeftijd;
	}


	
	
	public String toString(){
		if(isMan){
			return naam + " is een man";			
		}
		
		
		return naam + " is een vrouw";
	}
	
	
	
	

}
