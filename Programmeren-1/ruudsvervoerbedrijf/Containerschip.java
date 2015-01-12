package ruudsvervoerbedrijf;

public class Containerschip extends Vrachtvervoer {

	public Containerschip(double maxLaadvermogen) {
		super(maxLaadvermogen);
	}
	
	public String toString(){
		return "Containerschip. Laadvermogen: " + super.getLaadvermogen();
	}

}
