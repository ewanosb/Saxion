package ruudsvervoerbedrijf;

public class Boot extends Personenvervoer {
	private String name;
	private int volgnummer;
	private int aantalZwemvesten;
	private boolean koelkastAanBoord;
	
	public Boot(int aantalPersonen, String gekeurd, String name, int volgnummer, int aantalZwemvesten, boolean koelkastAanBoord) {
		super(aantalPersonen, gekeurd);
		this.name = name;
		this.volgnummer = volgnummer;
		this.aantalZwemvesten = aantalZwemvesten;
		this.koelkastAanBoord = koelkastAanBoord;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getVolgnummer(){
		return this.volgnummer;
	}
	
	public int aantalZwemvesten(){
		return this.aantalZwemvesten;
	}
	
	public boolean koelkastAanBoord(){
		return this.koelkastAanBoord;
	}
	
	public String toString() {
		if (this.koelkastAanBoord){
			return "Boot. Aantal Personen: " + super.getAantalPersonen() + ". Gekeurd: " + super.getDatumGekeurd() + ". Name: " + this.name + ". Volgnummer: " + this.volgnummer + ". Zwemvesten: " + this.aantalZwemvesten + ". Met koelkast";
		}else{
			return "Boot. Aantal Personen: " + super.getAantalPersonen() + ". Gekeurd: " + super.getDatumGekeurd() + ". Name: " + this.name + ". Volgnummer: " + this.volgnummer + ". Zwemvesten: " + this.aantalZwemvesten + ".";
		}
	}

}
