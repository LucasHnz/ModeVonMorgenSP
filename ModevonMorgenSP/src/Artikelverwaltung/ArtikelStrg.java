package Artikelverwaltung;

/**
 * 
 * @author maoro
 *
 */
public class ArtikelStrg {

	public ArtikelStrg() {
		
		
	}
	/**
	 * 
	 * @param Artikelnummer
	 */
	public static void EditiereArtikel(int Artikelnummer) {
		Artikel artikel = Artikelsammlung.getArtikel(Artikelnummer);
		//if(artikel.getKategorie() == "Accessoires")
			//GUIArtikelFormular.editiereArtikel(Artikelnummer, artikel.getKategorie());
		//else if(artikel.getKategorie() == "Schuhe")
			//GUIArtikelFormular.editiereArtikel(Artikelnummer, artikel.getKategorie());
		//else if(artikel.getKategorie() == "Kleidung")
			//GUIArtikelFormular.editiereArtikel(Artikelnummer, artikel.getKategorie());		
		
	}
	/**
	 * Fordert die Artikelsammlung auf, einen neuen Artikel mit den übergebenen Parametern hinzuzufügen.
	 * @param kateg Eine der drei Artikelkategorien: Schuhe, Accessoires und Kleidung.
	 * 
	 */
	public static void NeuerArtikel(String kateg, int Artikelnummer, int Bestand, String Bezeichnung, String Art, String Geschlecht,
			String Hersteller, String Verfügbarkeit, String Notiz, String[] Lieferanten, double Preis,
			double Rabatt, int Schuhgröße, String Farbe, String Größe) {
		Artikelsammlung.hinzufügenArtikel(kateg, Artikelnummer, Bestand, Bezeichnung, Art, Geschlecht, 
				Hersteller, Verfügbarkeit, Notiz, Lieferanten, Preis, Rabatt, Schuhgröße, Farbe, Größe);
		
	}
}
