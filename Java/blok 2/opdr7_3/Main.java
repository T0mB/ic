package opdr7_3;

public class Main {
	public static void main(String[] args) {
		System.out.println("Nu met interface Movable");
		Movable m1 = new Bus(10, 46);
		for (int i = 0 ; i < 6 ; i++) {
			m1.accelerate();
		}
		System.out.println("m1: " + m1.toString());
		System.out.println();
		Movable m2 = new Trein(29, false);
		for (int i = 0 ; i < 6 ; i++) {
			m2.accelerate();
		}
		System.out.println("m2: " + m2.toString());
		((Trein)m2).setATB_ok(true);
		m2.accelerate();
		System.out.println("huidige gear nummer: " + ((Trein)m2).getGearNow());
		System.out.println("m2: " + m2);
		System.out.println();
		Movable m3 = new Bus(13, 85);
		for (int i = 0 ; i < 6 ; i++) {
			m3.accelerate();
		}
		for (int i = 0 ; i < 2 ; i++) {
			m3.slowDown();
		}
		System.out.println("m3: " + m3.toString());
		System.out.println("Aantal stoelen van deze bus: " + ((Bus)m3).getAantalStoelen());
	}
}