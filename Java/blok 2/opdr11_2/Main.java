package opdr11_2;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader(
				"C:/Users/Tom/workspace/Java/blok 2/opdr11_2/prices_usd.txt");
		BufferedReader br = new BufferedReader(fr);

		FileWriter fw = new FileWriter(
				"C:/Users/Tom/workspace/Java/blok 2/opdr11_2/prices_euro.txt");
		PrintWriter pw = new PrintWriter(fw);

		double wisselkoers = 0.712809;

		while (true) {
			String s = br.readLine();
			if (s == null) {
				break;
			}

			int start = s.indexOf(" : ") + 3;
			int end = s.length();
			Double price_usd = Double.parseDouble(s.substring(start, end));
			Double price_eur = price_usd * wisselkoers;
			String s2 = s.substring(0, start);
			pw.print(s2 + String.format("%.2f", price_eur) + "\n");
		}

		pw.close();
		br.close();

	}

}
