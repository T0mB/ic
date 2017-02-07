package opdr3;

public class Main {
	public static void main(String[] args) {
		int i = 18;
		double d = 0.0;
		if (i > 10.0) {
			d = i / 4.0;
		}
		System.out.println("d = " + d);
		i = (int) d;
		System.out.println("i = " + i);

		String s = "1234567890";
		char ch = s.charAt(0);
		if (Character.getNumericValue(ch) == 0 || Character.getNumericValue(ch) == 1) {
			System.out.println("ch = " + ch);
		}

		s = "qwertyuioplkjhgfdsa1234567890";

		int i1 = 0;

		for (i = 0; i < s.length(); i++) {
			i1 = s.indexOf("k");
			
		}
		System.out.println("Index van k in string s is: " + i1);

		
	}
}