package bootverhuur;

public class Motorboot extends Boot {
	private int vermogen;
	
	public Motorboot(String bootCode, int maxPassagiers, int vermogen) {
		super(bootCode, maxPassagiers);
		this.vermogen = vermogen;
	}
	
	public int getVermogen(){
		return this.vermogen;
	}
	
}
