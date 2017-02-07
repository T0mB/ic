	package opdr10_2;

import java.util.ArrayList;

public class Persoon {
	private String naam;
	private double budget;
	private ArrayList<Computer> computers = new ArrayList<Computer>();

	public Persoon(String nm, double bud) {
		naam = nm;
		budget = bud;
	}
	
	

	public boolean koop(Computer c) {
		
		if (computers.contains(c)) {
			System.out.println(naam + " heeft niet gekocht " + c.getMerk());
			return false;
		}
		if (bezit(c.getMerk())) {
			System.out.println(naam + " heeft niet gekocht: " + c.getMerk());
			return false;
		}
		if (c.huidigeWaarde() < budget) {
			computers.add(c);
			budget -= c.huidigeWaarde();
			System.out.println(naam + " heeft gekocht: " + c.getMerk());
			return true;
		}
		System.out.println(naam + " heeft niet gekocht: " + c.getMerk());
		return false;
	}

	public boolean bezit(String mk) {
		for (int i = 0; i < computers.size(); i++) {
			if (computers.get(i).getMerk() == mk) {
				return true;
			}
		}
		return false;
	}

	public boolean verkoop(Computer c, Persoon koper) {
		
		if (computers.contains(c)) {
			if (koper.koop(c)) {
				budget += c.huidigeWaarde();
				computers.remove(c);
				System.out.println("verkoper " + naam + " heeft verkocht " + c.getMerk()
						+ " aan koper " + koper.naam);
				return true;
			}
		}
		System.out.println("verkoper " + naam + " heeft niet verkocht " + c.getMerk()
				+ " aan koper " + koper.naam);
		return false;
		
	}

	public void verwijderComputer(String mk) {
		Computer g = zoekComputer(mk);
		if (g != null) {
			computers.remove(g);
		}
	}

	public Computer zoekComputer(String mk) {
		Computer antw = null;
		for (Computer z : computers) {
			if (z.getMerk().equals(mk)) {
				antw = z;
			}

		}
		return antw;
	}

	public double getBudget() {
		return budget;
	}

	public String toString() {
		String uitvoer = naam + " heeft budget: " + budget
				+ " en de bezittingen:\n";
		for (int index = 0; index < computers.size(); index++) {
			uitvoer += computers.get(index) + "\n";
		}
		return uitvoer;

	}
}
