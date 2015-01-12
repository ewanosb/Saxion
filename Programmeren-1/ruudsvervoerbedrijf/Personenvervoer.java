package ruudsvervoerbedrijf;

public class Personenvervoer {
	private int aantalPersonen;
	private int gekeurdJaar, gekeurdMaand, gekeurdDag;
	
	public Personenvervoer(int aantalPersonen, String gekeurd){
		this.aantalPersonen = aantalPersonen;
		String[] dateSplitted = gekeurd.split("/");
		this.gekeurdJaar = Integer.parseInt(dateSplitted[0]);
		this.gekeurdMaand = Integer.parseInt(dateSplitted[1]);
		this.gekeurdDag = Integer.parseInt(dateSplitted[2]);
	}
	
	public int getAantalPersonen(){
		return this.aantalPersonen;
	}
	
	public String getDatumGekeurd(){
		return this.gekeurdJaar + "/" + this.gekeurdMaand + "/" + this.gekeurdDag;
	}
	
}
