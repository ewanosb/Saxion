package homeautomationsystem;

public class Lamp {
	protected final int AAN = 1;
	protected final int UIT = 0;
	
	private int status;
	
	/**
	 * Construct a new light
	 */
	public Lamp (){
		this.status = UIT;
	}
	
	/**
	 * Turn light on
	 */
	public void zetAan(){
		this.status = AAN;
	}
	
	/**
	 * Turn light off
	 */
	public void zetUit(){
		this.status = UIT;
	}
	
	/**
	 * return lampstatus
	 */
	public String toString(){
		if (this.status == AAN){
			return "aan";
		}else{
			return "uit";
		}
	}
	
	/**
	 * @return the current light status
	 */
	public int getStatus(){
		return this.status;
	}
	
	public boolean isAan() {
		if (this.status == AAN){
			return true;
		}else{
			return false;
		}
	}
}
