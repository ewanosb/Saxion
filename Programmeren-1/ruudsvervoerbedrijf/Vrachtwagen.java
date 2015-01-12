package ruudsvervoerbedrijf;

public class Vrachtwagen extends Vrachtvervoer {
	private double diepte, breedte, hoogte;
	private boolean ladingAfkoppelen;
	
	public Vrachtwagen(double maxLaadvermogen, double diepte, double breedte, double hoogte, boolean ladingAfkoppelen) {
		super(maxLaadvermogen);
		this.diepte = diepte;
		this.breedte = breedte;
		this.hoogte = hoogte;
		this.ladingAfkoppelen = ladingAfkoppelen;
	}
	
	public String toString(){
		if (ladingAfkoppelen){
			return "Vrachtwagen. Laadvermogen: " + super.getLaadvermogen() + ". Diepte: " + this.diepte + ". Breedte: " + this.breedte + ". Hoogte: " + this.hoogte + ". Lading kan afkoppelen.";
		}else{
			return "Vrachtwagen. Laadvermogen: " + super.getLaadvermogen() + ". Diepte: " + this.diepte + ". Breedte: " + this.breedte + ". Hoogte: " + this.hoogte + ".";
		}
	}

}
