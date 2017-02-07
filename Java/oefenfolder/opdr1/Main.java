package opdr1;

public class Main {
	public static void main(String[] arg) {
		Bank b = new Bank("HU-bank");
		Rekening r1 = new Rekening(12345678);
		b.voegRekeningToe(r1);
		Rekening r2 = new Rekening(13578642);
		b.voegRekeningToe(r2);
		b.voegRekeningToe(new Rekening(33444555));
		System.out.println(b);
		Rekening r4 = new Rekening(12345678);
		r4.stort(600.00);
		if (b.heeftRekening(r4.getNummer())) {
			System.out.println("Nummer bestaat al");
		} else {
			b.voegRekeningToe(r4);
		}
		Rekening mijne = b.zoekRekening(12345678);
		mijne.stort(150.00);
		System.out.println("Saldo: " + mijne.getSaldo());
		b.verwijderRekening(r2);
		System.out.println(b);
	}
}