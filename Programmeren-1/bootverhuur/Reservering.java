package bootverhuur;

public class Reservering {
	private Klant klant;
	private Boot boot;
	private String datum;
	private String beginTijd;
	private String eindTijd;
	
	public Reservering(Klant klant, Boot boot, String datum, String beginTijd, String eindTijd){
		this.klant = klant;
		this.boot = boot;
		this.datum = datum;
		this.beginTijd = beginTijd;
		this.eindTijd = eindTijd;
	}

	public Klant getKlant() {
		return this.klant;
	}

	public Boot getBoot() {
		return this.boot;
	}
	
	public String getDatum(){
		return this.datum;
	}
	
	public String getBeginTijd(){
		return this.beginTijd;
	}
	
	public String getEindTijd(){
		return this.eindTijd;
	}
	
}
