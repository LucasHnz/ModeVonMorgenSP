package Artikelverwaltung;

/**
 * 
 * @author Falk Maoro
 *
 */
public class Kleidung extends Artikel {

	private String Größe;
	/**
	 * Konstruktor.
	 * @param Größe Die Größe des Artikels. Unterteilt in XS, S, M, L, XL, XXL.
	 * @see Artikelverwaltung.Artikel
	 */
	public Kleidung(int artnr, int bestand, String Bezeichnung, String Art, String Geschlecht,
			String Hersteller, String Verfügbarkeit, String Notiz, String[]  Lieferanten,
			double Preis, int Rabatt, String Größe) {
		super(artnr, bestand, Bezeichnung, Art, Geschlecht, Hersteller, Verfügbarkeit,
				Notiz, Lieferanten, Preis, Rabatt);
		this.Größe=Größe;
		Kategorie = "Kleidung";
	}

	/**
	 * Gibt die Größe des Kleidungsartikels zurück.
	 * @return Größe des Artikels.
	 * @see Artikelverwaltung.Artikel
	 */
	public String getGröße() {
		return Größe;
	}
	/**
	 * Legt die Größe des Kleidungsartikels fest.
	 * @param größe Die Größe des Artikels. Unterteilt in XS, S, M, L, XL, XXL.
	 */
	public void setGröße(String größe) {
		Größe = größe;
	}
	
	
}
