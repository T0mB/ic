package opdr2;

import java.util.LinkedHashMap;
import java.util.Map;

public class Romein {
	public static void romanToDecimal(String romanNumber) {
		int decimal = 0;
		int lastNumber = 0;
		String romanNumeral = romanNumber.toUpperCase();
		LinkedHashMap<String, Integer> tabel = new LinkedHashMap<String, Integer>();
		String[] woorden = romanNumeral.split("");
		for (String woord : woorden) {
			if (tabel.containsKey(woord)) {
				tabel.put(woord, tabel.get(woord) + 1);
			} else {
				tabel.put(woord, 1);
			}
		}
		for (Map.Entry<String, Integer> entry : tabel.entrySet()) {
			String woord = entry.getKey();
			if (entry.getValue() > 3) {
				System.out.println(woord + "\t komt " + entry.getValue()
						+ " keer voor, en dat is te veel!");
			}
		}

		for (int x = romanNumeral.length() - 1; x >= 0; x--) {
			char convertToDecimal = romanNumeral.charAt(x);

			switch (convertToDecimal) {
			case 'M':
				decimal = processDecimal(1000, lastNumber, decimal);
				lastNumber = 1000;
				break;

			case 'D':
				decimal = processDecimal(500, lastNumber, decimal);
				lastNumber = 500;
				break;

			case 'C':
				decimal = processDecimal(100, lastNumber, decimal);
				lastNumber = 100;
				break;

			case 'L':
				decimal = processDecimal(50, lastNumber, decimal);
				lastNumber = 50;
				break;

			case 'X':
				decimal = processDecimal(10, lastNumber, decimal);
				lastNumber = 10;
				break;

			case 'V':
				decimal = processDecimal(5, lastNumber, decimal);
				lastNumber = 5;
				break;

			case 'I':
				decimal = processDecimal(1, lastNumber, decimal);
				lastNumber = 1;
				break;
			}
		}
		
		if (romanNumeral.length() < 8) 
			romanNumeral += "\t"; // maakt een tab
		
		
		
		System.out.println(romanNumeral + "\t" + "  " + decimal);
	}

	public static int processDecimal(int decimal, int lastNumber,int lastDecimal) {
		
		if (lastNumber > decimal) {
			return lastDecimal - decimal;
		} else {
			return lastDecimal + decimal;
		}
	}
}
