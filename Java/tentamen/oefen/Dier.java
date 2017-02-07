package oefen;

public abstract class Dier {
	  protected int aantalPoten;
	  public Dier() {
	    aantalPoten = 0;
	  }
	  public Dier(int aP) {
	    aantalPoten = aP;
	  }
	  public abstract String speak();	// abstracte methode

	  public String toString() {
	    return "Dier met " + aantalPoten + " poten";
	  }
	  
	  
	}