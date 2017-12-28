package Artikelverwaltung;

/**
 * 
 * @author maoro
 *
 */
public class Schuhe extends Artikel {

	public int Schuhgr��e;
	/**
	 * Konstruktor.
	 * @param Schuhgr��e Die Schuhgr��e.
	 * @see Artikelverwaltung.Artikel
	 */
	public Schuhe(int artnr, int bestand, String Bezeichnung, String Art, String Geschlecht,
			String Hersteller, String Verf�gbarkeit, String Notiz, String[]  Lieferanten, 
			double Preis, int Rabatt, int Schuhgr��e) {
		super(artnr, bestand, Bezeichnung, Art, Geschlecht, Hersteller, Verf�gbarkeit,
				Notiz, Lieferanten, Preis, Rabatt);
		this.Schuhgr��e=Schuhgr��e;
		Kategorie = "Schuhe";
	}
	/**
	 * Gibt die Schuhgr��e des Schuhs zur�ck.
	 * @return Schuhgr��e.
	 */
	public int getSchuhgr��e() {
		return Schuhgr��e;
	}
	/**
	 * Legt die Schuhgr��e des Schuhs fest.
	 * @param schuhgr��e Schuhgr��e des Artikels.
	 */
	public void setSchuhgr��e(int schuhgr��e) {
		Schuhgr��e = schuhgr��e;
	}
}
