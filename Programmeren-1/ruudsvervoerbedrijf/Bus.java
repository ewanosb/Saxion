package ruudsvervoerbedrijf;

public class Bus extends Personenvervoer {
	private String name;
	
	public Bus(int aantalPersonen, String gekeurd, String name) {
		super(aantalPersonen, gekeurd);
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String toString(){
		return "Bus. Aantal personen: " + super.getAantalPersonen() + ". Banner: " + this.name + ". Gekeurd: " + super.getDatumGekeurd();
	}

}
