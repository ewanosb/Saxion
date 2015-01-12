package bootverhuur;

import java.util.ArrayList;

/**
 * Deze class maakt een administratieobject en roept een aantal methoden aan op dat object. 
 */
public class Apl {
	public static void main(String[] args) {
		
		Administratie admin = new Administratie("Hier de naam van de administratie");
		
		admin.voegKlantToe("Henk", 1);	// naam en klantnummer
		admin.voegKlantToe("Jaap", 2);
		
		if (admin.aantalKlanten() == 2) {
			System.out.println("Twee klanten succesvol toegevoegd.");
		} else {
			System.err.println("Fout bij het toevoegen van klanten.");
		}
		
		if (admin.voegKlantToe("Ruud", 1)) {
			System.err.println("Ruud had niet toegevoegd moegen worden.");
		} else {
			System.out.println("Ruud is (terecht) niet toegevoegd.");
		}
		
		// Een paar boten toevoegen.
		admin.voegFluisterbootToe("FL-001", 5); //bootCode, maxPassagiers
		admin.voegFluisterbootToe("FL-002", 5);
		admin.voegFluisterbootToe("FL-003", 5);
		if (admin.voegFluisterbootToe("FL-003", 5)) {
			System.err.println("Deze tweede fluisterboot had niet toegevoegd mogen worden");
		}
		admin.voegMotorbootToe("M-001", 40, 200); //bootCode, maxPassagiers, vermogen
		
		if (admin.totaalAantalBoten() != 4) {
			System.err.println("Er zouden 4 boten moeten zijn.");
		} else {
			System.out.println("Er zijn inderdaad 4 boten.");
		}
		
		if (admin.aantalFluisterboten() != 3) {
			System.err.println("Er zouden 3 fluisterboten moeten zijn.");
		} else {
			System.out.println("Er zijn inderdaad 3 fluisterboten.");
		}

		int reserveringsnummer = admin.voegReserveringToe(1, "FL-001", "20131224", "1400", "1530");
		if (reserveringsnummer >= 0) {
			System.out.println("Reservering is toegevoegd met nummer " + reserveringsnummer);
		} else {
			System.err.println("Reservering had wel toegevoegd mogen worden. Code: " + reserveringsnummer);
		}
		admin.printReserveringen();
		
		
		reserveringsnummer = admin.voegReserveringToe(2, "FL-001", "20131224", "1300", "1430");
		if (reserveringsnummer < 0) {
			System.out.println("Reservering is (terecht) niet toegevoegd. Code: " + reserveringsnummer);
		} else {
			System.err.println("Reservering had niet toegevoegd mogen worden.");
		}
	
		ArrayList<Boot> beschikbareBoten = admin.beschikbareBoten("20131224", "1500", "1600");
		if (beschikbareBoten.size() != 3) {
			System.err.println("Er zouden 3 boten beschikbaar moeten zijn.");
		}

		ArrayList<Boot> botenVoorBoeking = admin.botenVoorBoeking(10, "20131224", "1500", "1600");
		admin.printBotenVoorBoeking(botenVoorBoeking);
		
	}
}