package ruudsvervoerbedrijf;

public class Vrachtvervoer {
	private double maxLaadvermogen;
	
	public Vrachtvervoer(double maxLaadvermogen){
		this.maxLaadvermogen = maxLaadvermogen;
	}
	
	public double getLaadvermogen(){
		return this.maxLaadvermogen;
	}
}
