package homeautomationsystem;

public class DimbareLamp extends Lamp {
	private int helderheid;
	
	/**
	 * set the brightness of the light
	 * @param helderheid int
	 */
	public void setHelderheid(int helderheid) {
		this.helderheid = helderheid;
	}
	
	/**
	 * @return the brightness of the light
	 */
	public int getHelderheid(){
		return this.helderheid;
	}
	
	/**
	 * @return the status of the light
	 */
	public String toString(){
		if (super.isAan()){
			return "aan, met helderheid " + this.helderheid;
		}else{
			return "uit";
		}
	}
}
