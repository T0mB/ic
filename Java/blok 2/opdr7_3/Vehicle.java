package opdr7_3;

public abstract class Vehicle implements Movable{
	protected int maxGears;
	protected int gearNow;
	
	
	
	public Vehicle(int mG){
		maxGears = mG;
		
	}
	
	public int getGearNow(){
		return gearNow;		
	}
	
	public String toString(){
		return " ";
	}

	
	
}
