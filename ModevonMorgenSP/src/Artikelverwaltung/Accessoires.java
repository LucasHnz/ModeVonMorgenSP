package Artikelverwaltung;

/**
 * 
 * @author maoro
 *
 */
public class Accessoires extends Artikel {

	private String Farbe;
	/**
	 * 
	 * @param Farbe Farbe des Accessoires.
	 * @see Artikel
	 */
	public Accessoires(int artnr, int bestand, String Bezeichnung, String Art, String Geschlecht, String Hersteller, String Verf�gbarkeit, String Notiz, String[]  Lieferanten, double Preis, int Rabatt, String Farbe) {
		super(artnr, bestand, Bezeichnung, Art, Geschlecht, Hersteller, Verf�gbarkeit, Notiz, Lieferanten, Preis, Rabatt);
		this.Farbe=Farbe;
		Kategorie="Accessoires";
	}
	/**
	 * 
	 * @return
	 */
	public String getFarbe() {
		return Farbe;
	}

	public void setFarbe(String farbe) {
		Farbe = farbe;
	}
}
