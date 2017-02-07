package opdr10_1;

import java.util.ArrayList;

public class Adresboek {
	private String naam;
	private ArrayList<Contact> contacten;

	public Adresboek(String naam) {
		this.naam = naam;
		contacten = new ArrayList<Contact>();
	}

	public void voegContactToe(Contact nwC) {
		if (!heeftContact(nwC.getEmail())) {
			contacten.add(nwC);
		}
	}

	public boolean heeftContact(String em) {
		boolean b = false;
		for (Contact c : contacten) {
			if (c.getEmail().equals(em)) {
				b = true;
			}
		}
		return b;
	}

	public Contact zoekContact(String em) {
		Contact antw = null;
		for (Contact k : contacten) {
			if (k.getEmail().equals(em)) {
				antw = k;
			}
		}
		
		return antw;
		
	}

	public void verwijderContact(Contact exC) {
		if (heeftContact(exC.getEmail())) {
			contacten.remove(exC);
		}
	}

	public int aantalContacten() {
		return contacten.size();
	}

	public ArrayList<Contact> getContacten() {
		return contacten;
	}

	public String toString() {
		String s = "Het aantal contacten is: " + aantalContacten() + "\n"
				+ "deze contacten zijn: \n";
		for (Contact c : contacten){
			s += c + "\n";
		}
		return s;
	}

}
