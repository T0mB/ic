package opdr7_3;

public class Bus extends Vehicle {

	private int aantalStoelen;

	public Bus(int maxGears, int aantStl) {
		super(maxGears);
		aantalStoelen = aantStl;

	}

	public int getAantalStoelen() {
		return aantalStoelen;
	}

	public String toString() {
		return "Bus met huidige versnelling: " + gearNow + " en max "
				+ maxGears;
	}

	public void accelerate() {
		if (gearNow < maxGears) {
			gearNow = gearNow + 1;
		}
	}

	public void slowDown() {
		if (gearNow > 0) {
			gearNow = gearNow - 1;
		}
	}

}
