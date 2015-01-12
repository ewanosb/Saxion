package homeautomationsystem;

public class Apl {

	public static void main(String[] args) {
		//Maak lampen
		Lamp leeslamp = new Lamp();
		DimbareLamp hanglamp = new DimbareLamp();
		PhilipsHUELamp huelamp = new PhilipsHUELamp();
		
		//Print de gegevens van de lampen
		System.out.println("Leeslamp : " + leeslamp);
		System.out.println("Hanglamp : " + hanglamp);
		System.out.println("Philips HUE lamp: " + huelamp);
		System.out.println("---");
		
		//Zet leeslamp aan
		leeslamp.zetAan();
		System.out.println("Leeslamp : " + leeslamp);
		
		//Zet hanglamp aan en stel in op helderheid 50%
		hanglamp.setHelderheid(50);
		hanglamp.zetAan();
		System.out.println("Hanglamp : " + hanglamp);
		
		//Zet huelamp aan en stel in op helderheid van 60% en een
		//roodachtige kleur
		huelamp.setHelderheid(60);
		huelamp.setKleur(255, 10, 10);
		huelamp.zetAan();
		System.out.println("Huelamp : " + huelamp);

	}

}
