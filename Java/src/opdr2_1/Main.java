package opdr2_1;

public class Main 
{
	public static void main(String[] arg)
	{
		Piloot p1 = new Piloot("John Travolta");
		p1.setSalaris(123456.78);
		System.out.println("Zonder vlieguren: " + p1.toString());
		p1.setVerhoogVliegurenMet(12);
		System.out.println("Eerste piloot: " + p1);
		System.out.println();
		
		Piloot p2 = new Piloot("Leonardo di Caprio");
		p2.setSalaris(5000.00);
		p2.setVerhoogVliegurenMet(3);
		System.out.println("Aantal vlieguren van tweede piloot: " + p2.getVliegUren());
		System.out.println("Salaris van tweede piloot" + p2.getSalaris());
		System.out.println("Tweede piloot:" + p2);
	}	
		
}
