package bootverhuur;

abstract public class Boot {
	private String bootCode;
	private int maxPassagiers;
	
	public Boot(String bootCode, int maxPassagiers){
		this.bootCode = bootCode;
		this.maxPassagiers = maxPassagiers;
	}
	
	public String getBootCode(){
		return this.bootCode;
	}
	
	public int getMaxPassagiers(){
		return this.maxPassagiers;
	}
}