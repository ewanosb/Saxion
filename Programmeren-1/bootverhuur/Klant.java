package bootverhuur;

public class Klant {
	private int klantNummer;
	private String naam;
	
	public Klant(int klantNummer, String naam){
		this.klantNummer = klantNummer;
		this.naam = naam;
	}

	public int getKlantNummer() {
		return this.klantNummer;
	}
	
	public String getKlantNaam(){
		return this.naam;
	}
	
}
