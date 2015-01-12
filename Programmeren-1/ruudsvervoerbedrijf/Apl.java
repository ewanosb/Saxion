package ruudsvervoerbedrijf;

public class Apl {

	public static void main(String[] args) {
		Administratie admin = new Administratie();
		
		admin.voegTreinToe(400, 5, 100, "2012/01/12");
		admin.voegTreinToe(240, 3, 60, "2012/02/12");
		admin.voegBusToe(60, "2012/01/12", "tante annie");
		admin.voegBootToe(1200, "2014/02/16", "Titanic", 1, 1400, true);
		admin.voegVrachtwagenToe(7000, 1100, 200, 300, true);
		admin.voegContainerschipToe(50000);

		admin.printPersonenvoertuigenVoorAantalPersonen(50);
		
		System.out.println();
		admin.printAlleRijdendeVoertuigen();
		
		System.out.println();
		admin.printVoertuigen();

	}

}
