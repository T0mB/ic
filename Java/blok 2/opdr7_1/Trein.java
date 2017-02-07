package opdr7_1;

public class Trein extends Vehicle {
	
	private boolean ATB_ok;
	
	public Trein (int maxGears, boolean ATB_ok){
		super(maxGears);
		ATB_ok = false;
	}
	
	public void setATB_ok(boolean atbk){
		ATB_ok = atbk;
		
	}
	
	public String toString(){
		return "Trein met huidige versnelling " + gearNow + " en max: " + maxGears;
	}
	
	public void accelerate(){
		if(ATB_ok == true && gearNow < maxGears){
			gearNow = gearNow + 1;
		}
	}
	
	public void slowDown(){
		if(ATB_ok == true && gearNow > 0){
			gearNow = gearNow - 1;
		}
		else{
			gearNow = 0;
		}
	}
	

}
