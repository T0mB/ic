package opdr1;

public class Rekening {
	private int nummer; // de 2 attributen
	private double saldo;

	// de constructor
	public Rekening(int nr) {
		nummer = nr;
		saldo = 0.0;
	}

	public int getNummer() {
		return nummer;
	}

	public double getSaldo() {
		return saldo;
	}

	public void stort(double bedrag) {
		saldo = saldo + bedrag;
	}

	public void neemOp(double bedrag) {
		saldo = saldo - bedrag;
	}

	public String toString() {
		String s = "Op rekening " + nummer + " staat " + saldo;
		return s;
	}
}