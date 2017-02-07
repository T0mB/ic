package prac2_2;

public class Main {
	public static void main(String[] args) {
		Voetbalclub ajx = new Voetbalclub("Ajax ", 0, 0, 0, 0);
		System.out.println(ajx);
		Voetbalclub feij = new Voetbalclub("Feijenoord ", 0, 0, 0, 0);
		feij.verwerkResultaat('w');
		feij.verwerkResultaat('w');
		feij.verwerkResultaat('w');
		feij.verwerkResultaat('g');
		System.out.println(feij);
		}

}
