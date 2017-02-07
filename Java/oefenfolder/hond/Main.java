package hond;

public class Main {

	public static void main(String[] args) {
		System.out.println("Er zijn nu " + Hond.getAantalHonden() + " honden");
		Hond h1 = new Hond("Bello");
		Hond h2 = new Hond("kees");
		System.out.println(h1);
		System.out.println(h2);
		System.out.println("Er zijn nu " + Hond.getAantalHonden() + " honden");

	}

}
