package homeautomationsystem;

public class PhilipsHUELamp extends DimbareLamp {
	private int r, g, b;
	
	/**
	 * set the color of the light
	 * @param r, the red color
	 * @param g, the green color
	 * @param b, the blue color
	 */
	public void setKleur(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	/**
	 * returns the status of the light
	 */
	public String toString(){
		if (super.getStatus() == AAN){
			return "aan, met helderheid " + super.getHelderheid() + " en RGB kleur (" + this.r + "," + this.g + "," + this.b + ")";
		}else{
			return "uit";
		}
	}

}
