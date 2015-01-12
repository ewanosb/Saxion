package ruudsvervoerbedrijf;

public class Trein extends Personenvervoer {
	private int aantalWagons;
	private double totaleLengte;
	
	public Trein(int aantalPersonen, int aantalWagons, double totaleLengte, String gekeurd) {
		super(aantalPersonen, gekeurd);
		this.aantalWagons = aantalWagons;
		this.totaleLengte = totaleLengte;
	}
	
	public int aantalWagons(){
		return this.aantalWagons;
	}
	
	public double totaleLengte(){
		return this.totaleLengte;
	}
	
	public String toString(){
		return "Trein. Aantal Personen: " + super.getAantalPersonen() + ". Aantal Wagons: " + this.aantalWagons + ". Totale lengte: " + this.totaleLengte + ". Gekeurd: " + super.getDatumGekeurd();
	}

}
