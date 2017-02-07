package oefen;

public class Hond extends Dier {
	
	private String naam;
	private int lengte;
	
	public Hond(String nm, int lng, int aantalPoten){
		super(aantalPoten);
		naam = nm;
		lengte = lng;
	}
	
	public String getNaam(){
		return naam;
	}
	
	public void setNaam(String nm){
		naam = nm;
	}
	public String speak(){
		return "woef";
	}
	
	public String speak(String str){
		return str;
	}
	
	
	public String toString(){
		return "heet " + naam + " is " + lengte + " lang" + " heeft " + aantalPoten + " poten";
	}
	

	
}


