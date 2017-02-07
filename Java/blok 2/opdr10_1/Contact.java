package opdr10_1;

public class Contact {
	private String voornaam, achternaam, email;

	public Contact(String voornaam, String achternaam, String email) {
		
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String nwEm) {
		email = nwEm;
	}
	
	public String toString(){
		return voornaam + " " + achternaam + " heeft email-adres: " + email ;
	}
	
	
	
	

}
