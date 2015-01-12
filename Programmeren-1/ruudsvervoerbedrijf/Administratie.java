package ruudsvervoerbedrijf;

import java.util.ArrayList;

public class Administratie {
	//personenvervoer
	private ArrayList<Trein> treinen = new ArrayList<Trein>();
	private ArrayList<Bus> bussen = new ArrayList<Bus>();
	private ArrayList<Boot> boten = new ArrayList<Boot>();
	
	//vrachtvervoer
	private ArrayList<Vrachtwagen> vrachtwagens = new ArrayList<Vrachtwagen>();
	private ArrayList<Containerschip> containerschepen = new ArrayList<Containerschip>();
	
	public void voegTreinToe(int aantalPersonen, int aantalWagons, double totaleLengte, String gekeurd) {
		this.treinen.add(new Trein(aantalPersonen, aantalWagons, totaleLengte, gekeurd));
	}
	
	public void voegBusToe(int aantalPersonen, String gekeurd, String name){
		this.bussen.add(new Bus(aantalPersonen, gekeurd, name));
	}
		
	public void voegBootToe(int aantalPersonen, String gekeurd, String name, int volgnummer, int aantalZwemvesten, boolean koelkastAanBoord){
		this.boten.add(new Boot(aantalPersonen, gekeurd, name, volgnummer, aantalZwemvesten, koelkastAanBoord));
	}
	
	public void voegVrachtwagenToe(double maxLaadvermogen, double diepte, double breedte, double hoogte, boolean ladingAfkoppelen){
		this.vrachtwagens.add(new Vrachtwagen(maxLaadvermogen, diepte, breedte, hoogte, ladingAfkoppelen));
	}
	
	public void voegContainerschipToe(double maxLaadvermogen){
		this.containerschepen.add(new Containerschip(maxLaadvermogen));
	}

	public void printPersonenvoertuigenVoorAantalPersonen(int aantalPersonen) {
		System.out.println("Personenvoertuigen: ");
		System.out.println("----------------------------------------------------------------------------------------");
		for (Trein trein : this.treinen) {
			if (trein.getAantalPersonen() >= aantalPersonen){
				System.out.println(trein);
			}
		}
		for (Boot boot : this.boten) {
			if (boot.getAantalPersonen() >= aantalPersonen){
				System.out.println(boot);
			}
		}
		for (Bus bus : this.bussen) {
			if (bus.getAantalPersonen() >= aantalPersonen){
				System.out.println(bus);
			}
		}
		System.out.println("----------------------------------------------------------------------------------------");
	}

	public void printAlleRijdendeVoertuigen() {
		System.out.println("Rijdende voertuigen: ");
		System.out.println("----------------------------------------------------------------------------------------");
		for (Trein trein : this.treinen) {
			System.out.println(trein);
		}
		for (Bus bus : this.bussen) {
			System.out.println(bus);
		}
		for (Vrachtwagen vrachtwagen : this.vrachtwagens) {
			System.out.println(vrachtwagen);
		}
		System.out.println("----------------------------------------------------------------------------------------");
	}

	public void printVoertuigen() {
		System.out.println("Alle voertuigen: ");
		System.out.println("----------------------------------------------------------------------------------------");
		for (Trein trein : this.treinen) {
			System.out.println(trein);
		}
		for (Bus bus : this.bussen) {
			System.out.println(bus);
		}
		for (Boot boot : this.boten) {
			System.out.println(boot);
		}
		for (Vrachtwagen vrachtwagen : this.vrachtwagens) {
			System.out.println(vrachtwagen);
		}
		for (Containerschip containerschip : this.containerschepen) {
			System.out.println(containerschip);
		}
		System.out.println("----------------------------------------------------------------------------------------");
	}
	
	
}
