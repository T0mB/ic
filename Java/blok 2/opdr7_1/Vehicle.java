package opdr7_1;

public abstract class Vehicle {
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
	
	public abstract void accelerate();
	
	public abstract void slowDown();
	
}
