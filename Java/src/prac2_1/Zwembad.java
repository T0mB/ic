package prac2_1;

public class Zwembad {
	private double breedte;
	private double lengte;
	private double diepte;
	private double inhoud;
	
	
	public Zwembad(double br, double lng, double diep){
		breedte = br;
		lengte = lng;
		diepte = diep;
		}
	
	
	

	public double getBreedte(){
		return breedte;
	}
	
	public double getLengte(){
		return lengte;
	}
	
	public double getDiepte(){
		return diepte;
	}
	
	public double inhoud(){
		return breedte * lengte * diepte;
	}
	
	public double getInhoud(){
		return inhoud;
	}

	
	public void setBreedte(double nwBr){
		breedte = nwBr;
	}
	
	public void setLengte(double nwLng){
		lengte = nwLng;
	}
	
	public void setDiepte(double nwDiep){
		diepte = nwDiep;
	}
	
	public void setInhoud(double inh){
		inhoud = inh;
		inhoud = lengte * breedte * diepte;
		
		
	}
	
	public String toString(){
		return "Dit zwembad is " + breedte + "meter breed, " + lengte + "meter lang, en " + diepte + "meter diep.";
		
	}
	
	
	
	

}
