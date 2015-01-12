package bootverhuur;


import java.util.ArrayList;

public class Administratie {
	
	private String naam;
	private ArrayList<Boot> boten = new ArrayList<Boot>();
	private ArrayList<Klant> klanten = new ArrayList<Klant>();
	private ArrayList<Reservering> reserveringen = new ArrayList<Reservering>();

	public Administratie(String naam) {
		this.naam = naam;
	}

	public String getNaam(){
		return this.naam;
	}
	
	public boolean voegKlantToe(String klantNaam, int klantNummer) {
		for (Klant klant : klanten){
			if (klant.getKlantNummer() == klantNummer){
				return false;
			}
		}
		
		klanten.add(new Klant(klantNummer, klantNaam));
		return true;
	}

	public int aantalKlanten() {
		return klanten.size();
	}
	
	public boolean voegFluisterbootToe(String bootCode, int maxPassagiers) {
		for (Boot boot : boten){
			if (boot.getBootCode().equals(bootCode)){
				return false;
			}
		}
		
		boten.add(new Fluisterboot(bootCode, maxPassagiers));
		return true;
	}

	public boolean voegMotorbootToe(String bootCode, int maxPassagiers, int vermogen) {
		for (Boot boot : boten){
			if (boot.getBootCode().equals(bootCode)){
				return false;
			}
		}
		
		boten.add(new Motorboot(bootCode, maxPassagiers, vermogen));
		return true;
	}

	public int voegReserveringToe(int klantNummer, String bootCode, String datum, String beginTijd, String eindTijd) {
		for (Reservering reservering : reserveringen){
			if (reservering.getDatum().equals(datum) && 
					((Integer.valueOf(beginTijd) >= Integer.valueOf(reservering.getBeginTijd()) && Integer.valueOf(beginTijd) <= Integer.valueOf(reservering.getEindTijd()))
					|| (Integer.valueOf(eindTijd) <= Integer.valueOf(reservering.getEindTijd()) && Integer.valueOf(eindTijd) >= Integer.valueOf(reservering.getBeginTijd())))){
				return -1;
			}
		}
		Boot bootToevoegen = null;
		for (Boot boot : boten){
			if (boot.getBootCode().equals(bootCode)){
				bootToevoegen = boot;
			}
		}
		
		Klant klantToevoegen = null;
		for (Klant klant : klanten){
			if (klant.getKlantNummer() == klantNummer){
				klantToevoegen = klant;
			}
		}
		
		if (bootToevoegen == null || klantToevoegen == null){
			return -1;
		}else {
			reserveringen.add(new Reservering(klantToevoegen, bootToevoegen, datum, beginTijd, eindTijd));
			return reserveringen.size();
		}
		
	}
	
	public int aantalFluisterboten() {
		int counter = 0;
		for (Boot boot : boten){
			if (boot instanceof Fluisterboot){
				counter++;
			}
		}
		return counter;
	}
	
	public int totaalAantalBoten() {
		return boten.size();
	}

	public void printReserveringen() {
		System.out.println("\n-----------------------------RESERVERINGEN---------------------------");
		for (Reservering reservering : reserveringen){
			System.out.println("Datum: " + reservering.getDatum() + " - Begintijd: " + reservering.getBeginTijd() + " - Eindtijd: " + reservering.getEindTijd());
			System.out.println("Boot gereserveerd: " + reservering.getBoot().getBootCode());
			System.out.println("Gereserveerd door: " + reservering.getKlant().getKlantNaam());
			System.out.println();
		}
		System.out.println("-----------------------EINDE RESERVERINGEN---------------------------\n");
	}
	
	public ArrayList<Boot> beschikbareBoten(String datum, String beginTijd, String eindTijd) {
		ArrayList<Boot> beschikbareBoten = new ArrayList<Boot>(this.boten);
		
		for (Reservering reservering : reserveringen){
			if (datum.equals(reservering.getDatum())){
				if ((Integer.valueOf(beginTijd) >= Integer.valueOf(reservering.getBeginTijd()) && Integer.valueOf(beginTijd) <= Integer.valueOf(reservering.getEindTijd())) || 
					(Integer.valueOf(eindTijd) >= Integer.valueOf(reservering.getBeginTijd()) && Integer.valueOf(eindTijd) <= Integer.valueOf(reservering.getEindTijd()))){
					beschikbareBoten.remove(reservering.getBoot());
				}
			}
		}
		
		return beschikbareBoten;
	}

	public ArrayList<Boot> botenVoorBoeking(int aantalPassagiers, String datum, String beginTijd, String eindTijd) {
		ArrayList<Boot> botenVoorBoeking = new ArrayList<Boot>(this.boten);
		
		for (Reservering reservering : reserveringen){
			if (datum.equals(reservering.getDatum())){
				if ((Integer.valueOf(beginTijd) >= Integer.valueOf(reservering.getBeginTijd()) && Integer.valueOf(beginTijd) <= Integer.valueOf(reservering.getEindTijd())) || 
					(Integer.valueOf(eindTijd) >= Integer.valueOf(reservering.getBeginTijd()) && Integer.valueOf(eindTijd) <= Integer.valueOf(reservering.getEindTijd()))){
					botenVoorBoeking.remove(reservering.getBoot());
				}
			}
		}
		
		for (Boot boot : this.boten){
			if (boot.getMaxPassagiers() < aantalPassagiers){
				botenVoorBoeking.remove(boot);
			}
		}
		
		return botenVoorBoeking;
	}
	
	public void printBotenVoorBoeking(int aantalPassagiers, String datum, String beginTijd, String eindTijd){
		ArrayList<Boot> botenVoorBoeking = botenVoorBoeking(aantalPassagiers, datum, beginTijd, eindTijd);
		printBotenVoorBoeking(botenVoorBoeking);
	}
	
	public void printBotenVoorBoeking(ArrayList<Boot> botenVoorBoeking){
		System.out.println("\n-----------------BOTEN VOOR BOEKING-------------------");
		for (Boot boot : botenVoorBoeking) {
			System.out.println("Boot: " + boot.getBootCode() + " - Max. passagiers: " + boot.getMaxPassagiers());
		}
		System.out.println("\n-----------EINDE BOTEN VOOR BOEKING-------------------");
	}
	
}
