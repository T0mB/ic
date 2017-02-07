package opdr11_1;

import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] arg) throws IOException {

		double gem = 0.0;

		FileReader fr = new FileReader(
				"C:/Users/Tom/workspace/Java/blok 2/opdr11_1/invoer.txt");
		Scanner sc = new Scanner(fr);
		int aantal = 0;
		while (sc.hasNext()) {
			String s = sc.next();
			double d = Double.parseDouble(s);
			System.out.println(d);
			aantal++;
			gem += d;

		}
		sc.close();
		System.out.println("Er staan " + aantal + " getallen in de file");
		System.out.println("Gemiddelde is: " + (gem / aantal));

	}
}
