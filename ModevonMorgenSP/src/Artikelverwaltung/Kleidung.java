package Artikelverwaltung;

/**
 * 
 * @author Falk Maoro
 *
 */
public class Kleidung extends Artikel {

	private String Gr��e;
	/**
	 * Konstruktor.
	 * @param Gr��e Die Gr��e des Artikels. Unterteilt in XS, S, M, L, XL, XXL.
	 * @see Artikelverwaltung.Artikel
	 */
	public Kleidung(int artnr, int bestand, String Bezeichnung, String Art, String Geschlecht,
			String Hersteller, String Verf�gbarkeit, String Notiz, String[]  Lieferanten,
			double Preis, int Rabatt, String Gr��e) {
		super(artnr, bestand, Bezeichnung, Art, Geschlecht, Hersteller, Verf�gbarkeit,
				Notiz, Lieferanten, Preis, Rabatt);
		this.Gr��e=Gr��e;
		Kategorie = "Kleidung";
	}

	/**
	 * Gibt die Gr��e des Kleidungsartikels zur�ck.
	 * @return Gr��e des Artikels.
	 * @see Artikelverwaltung.Artikel
	 */
	public String getGr��e() {
		return Gr��e;
	}
	/**
	 * Legt die Gr��e des Kleidungsartikels fest.
	 * @param gr��e Die Gr��e des Artikels. Unterteilt in XS, S, M, L, XL, XXL.
	 */
	public void setGr��e(String gr��e) {
		Gr��e = gr��e;
	}
	
	
}
