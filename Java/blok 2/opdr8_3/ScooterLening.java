package opdr8_3;

public class ScooterLening {

	private int maxAantalMaanden, aantalMaandenBetaald;
	private double bedragPerMaand, aanbetaling;
	private Scooter hetKarretje;
	private Lener deBetaler;

	public ScooterLening(int mAM, double bPM) {
		maxAantalMaanden = mAM;
		bedragPerMaand = bPM;
	}

	public void verwerkMaandBetaling() {
		if (aantalMaandenBetaald < maxAantalMaanden){
			aantalMaandenBetaald +=1;
		}
	}

	public double totNuToeBetaald() {
		double betaald = 0.0;
		if (hetKarretje != null && deBetaler != null) {
			betaald = (aantalMaandenBetaald * bedragPerMaand + aanbetaling);
		}
		return betaald;
	}

	public int getMaxAantalMaanden() {
		return maxAantalMaanden;
	}

	public void setMaxAantalMaanden(int maxAantalMaanden) {
		this.maxAantalMaanden = maxAantalMaanden;
	}

	public double getAanbetaling() {
		return aanbetaling;
	}

	public void setAanbetaling(double aanbetaling) {
		this.aanbetaling = aanbetaling;
	}

	public Scooter getHetKarretje() {
		return hetKarretje;
	}

	public void setHetKarretje(Scooter hetKarretje) {
		this.hetKarretje = hetKarretje;
	}

	public Lener getDeBetaler() {
		return deBetaler;
	}

	public void setDeBetaler(Lener deBetaler) {
		this.deBetaler = deBetaler;
	}

	public int getAantalMaandenBetaald() {
		return aantalMaandenBetaald;
	}

	public void setAantalMaandenBetaald(int aantalMaandenBetaald) {
		this.aantalMaandenBetaald = aantalMaandenBetaald;
	}

	public double getBedragPerMaand() {
		return bedragPerMaand;
	}

	public void setBedragPerMaand(double bedragPerMaand) {
		this.bedragPerMaand = bedragPerMaand;
	}

	public String toString() {
		if (deBetaler == null) {
			return hetKarretje + "\n Deze lening kost " + bedragPerMaand + " per maand en er is " + aantalMaandenBetaald + " van de " + maxAantalMaanden + " maanden betaald\nDeze lening wordt betaald door: de lener is nog onbekend.";
		} else {
			return hetKarretje + "\n Deze lening kost " + bedragPerMaand + " per maand en er is " + aantalMaandenBetaald + " van de " + maxAantalMaanden + " maanden betaald\nDeze lening wordt betaald door: " + deBetaler + "\n";
		}
	}
}
