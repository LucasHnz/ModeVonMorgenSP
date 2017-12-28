package Artikelverwaltung;

/**
 * 
 * @author maoro
 *
 */
public class Schuhe extends Artikel {

	public int Schuhgröße;
	/**
	 * Konstruktor.
	 * @param Schuhgröße Die Schuhgröße.
	 * @see Artikelverwaltung.Artikel
	 */
	public Schuhe(int artnr, int bestand, String Bezeichnung, String Art, String Geschlecht,
			String Hersteller, String Verfügbarkeit, String Notiz, String[]  Lieferanten, 
			double Preis, int Rabatt, int Schuhgröße) {
		super(artnr, bestand, Bezeichnung, Art, Geschlecht, Hersteller, Verfügbarkeit,
				Notiz, Lieferanten, Preis, Rabatt);
		this.Schuhgröße=Schuhgröße;
		Kategorie = "Schuhe";
	}
	/**
	 * Gibt die Schuhgröße des Schuhs zurück.
	 * @return Schuhgröße.
	 */
	public int getSchuhgröße() {
		return Schuhgröße;
	}
	/**
	 * Legt die Schuhgröße des Schuhs fest.
	 * @param schuhgröße Schuhgröße des Artikels.
	 */
	public void setSchuhgröße(int schuhgröße) {
		Schuhgröße = schuhgröße;
	}
}
