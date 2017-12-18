package Tests;

public class rndmshittest {

	public static void main(String[] args) {

		//String klasse = this.getClass().getName();
		String klasse = "Artikelverwaltung.Accessoires";
		klasse = klasse.substring(18);
		System.out.println(klasse);
		String befehl = "select Bild from " +klasse+ " where Artikelnr= ";
		System.out.println(befehl);;
	}
}
