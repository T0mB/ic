package auto;

public class Main {
	public static void main(String[] args) {
		Auto a1 = new Auto("55-66-PG");
		Klant k1 = new Klant("Jan Jansen");
		a1.setDeKlant(k1);
		System.out.println(a1);
		
		
	}
}