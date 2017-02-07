package opdr7_1;

public class Main {
	public static void main(String[] args) {
		System.out.println("Abstracte superklasse");
		Vehicle v1 = new Bus(10, 46);
		for (int i = 0 ; i < 6 ; i++) {
			v1.accelerate();
			}
		System.out.println("v1: " + v1.toString());
		System.out.println();
		Vehicle v2 = new Trein(29, false);
		for (int i = 0 ; i < 6 ; i++) {
			v2.accelerate();
			}
		System.out.println("v2: " + v2.toString());
		((Trein)v2).setATB_ok(true);
		v2.accelerate();
		System.out.println("huidige gear nummer: "+ v2.getGearNow());
		System.out.println("v2: " + v2);
		System.out.println();
		Vehicle v3 = new Bus(13, 85);
		for (int i = 0 ; i < 6 ; i++) {
			v3.accelerate();
			}
		for (int i = 0 ; i < 2 ; i++) {
			v3.slowDown();
			}System.out.println("v3: " + v3);
			System.out.println("Aantal stoelen van deze bus: "+ ((Bus)v3).getAantalStoelen());
			}
	}

