package opdr8_3;

public class Main {
	public static void main(String[] args) {
		Scooter s1 = new Scooter("Aprilia", 1599.00);
		Lener l1 = new Lener("Freek", true);
		ScooterLening sl1 = new ScooterLening(30, 79.00);
		sl1.setAanbetaling(499.00);
		sl1.setHetKarretje(s1);
		sl1.setDeBetaler(l1);
		for (int i = 0; i < 9; i++) {
			sl1.verwerkMaandBetaling();
		}
		System.out.println(sl1);
		System.out.println("\nVoor deze scooter is " + sl1.getAanbetaling()
				+ " aanbetaald");
		System.out.println("Tot nu toe is er " + sl1.totNuToeBetaald()
				+ " betaald\n");
		ScooterLening sl2 = new ScooterLening(24, 49.00);
		Scooter s2 = new Scooter("Yamaha", 2199.00);
		Lener l2 = new Lener("Bram", false);
		for (int i = 0; i < 15; i++) {
			sl2.verwerkMaandBetaling();
		}
		sl2.setAanbetaling(399.00);
		sl2.setDeBetaler(l2);
		sl2.setHetKarretje(s2);
		System.out.println(sl2);
		System.out.println("Lener is: " + sl1.getDeBetaler());
		System.out.println("Scooter is: " + sl2.getHetKarretje());
	}
}
