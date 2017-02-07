package opdr1;

import java.util.ArrayList;

public class Bank {

	private String naam;
	private ArrayList<Rekening> rekeningen = new ArrayList<Rekening>();

	public Bank(String naam) {
		this.naam = naam;

	}

	public void voegRekeningToe(Rekening rekening) {
		if (rekening != null && !heeftRekening(rekening.getNummer())) {
			rekeningen.add(rekening);
		}

	}

	public boolean heeftRekening(int nummer) {
		return zoekRekening(nummer) != null;
	}

	public Rekening zoekRekening(int nummer) {
		for (int i = 0; i < rekeningen.size(); i++) {
			if (rekeningen.get(i).getNummer() == nummer) {
				return rekeningen.get(i);
			}
		}
		return null;
	}

	public void verwijderRekening(Rekening r2) {
		if (heeftRekening(r2.getNummer())) {
			rekeningen.remove(r2);
		}
	}

}
