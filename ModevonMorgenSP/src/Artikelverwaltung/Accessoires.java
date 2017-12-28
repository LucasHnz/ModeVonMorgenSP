package Artikelverwaltung;

/**
 * 
 * @author maoro
 *
 */
public class Accessoires extends Artikel {

	private String Farbe;
	/**
	 * Konstruktor.
	 * @param Farbe Farbe des Accessoires.
	 * @see Artikelverwaltung.Artikel
	 */
	public Accessoires(int artnr, int bestand, String Bezeichnung, String Art, String Geschlecht,
			String Hersteller, String Verf�gbarkeit, String Notiz, String[]  Lieferanten,
			double Preis, int Rabatt, String Farbe) {
		super(artnr, bestand, Bezeichnung, Art, Geschlecht, Hersteller, Verf�gbarkeit,
				Notiz, Lieferanten, Preis, Rabatt);
		this.Farbe=Farbe;
	}
	/**
	 * Gibt die Farbe des Accessoires zur�ck.
	 * @return	Farbe des Accessoires.
	 */
	public String getFarbe() {
		return Farbe;
	}
	/**
	 * Legt die Variable Farbe fest.
	 * @param farbe Farbe des Accessoires.
	 */
	public void setFarbe(String farbe) {
		Farbe = farbe;
	}
}
