package Artikelverwaltung;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
/**
 * 
 * @author maoro
 *
 */



public class Artikelsammlung {

	static HashMap<Integer,Artikel> Artikelsammlung = new HashMap<Integer,Artikel>();	
	
	public static void füllenSammlung(ResultSet rs, String kateg) {
		try{
			while(rs.next()){
		
				int Artikelnummer = rs.getInt("Artikelnr");
				int Bestand = rs.getInt("Bestand");
				String[] Lieferanten = rs.getString("Lieferant").split(";");
				String Bezeichnung = rs.getString("Bezeichnung");
				String Art = rs.getString("Art");
				String Geschlecht = rs.getString("Geschlecht");
				String Hersteller = rs.getString("Hersteller");
				String Verfügbarkeit = rs.getString("Verfügbarkeit");
				String Notiz = rs.getString("Notiz");
				if(rs.wasNull())
						Notiz = null;
				double Preis = rs.getDouble("Preis");
				int Rabatt = rs.getInt("Rabatt");
				int Schuhgröße;
				String Farbe, Größe;
				
				if(kateg == "Schuhe") {
					Schuhgröße = rs.getInt("Schuhgröße");
					Artikelsammlung.put(Artikelnummer, new Schuhe(Artikelnummer, Bestand, Bezeichnung, Art, Geschlecht, Hersteller, Verfügbarkeit, Notiz, Lieferanten, Preis, Rabatt, Schuhgröße));
				}else if(kateg == "Accessoires") {
					Farbe = rs.getString("Farbe");
					Artikelsammlung.put(Artikelnummer, new Accessoires(Artikelnummer, Bestand, Bezeichnung, Art, Geschlecht, Hersteller, Verfügbarkeit, Notiz, Lieferanten, Preis, Rabatt, Farbe));
				}else if(kateg == "Kleidung") {
					Größe = rs.getString("Größe");
					Artikelsammlung.put(Artikelnummer, new Kleidung(Artikelnummer, Bestand, Bezeichnung, Art, Geschlecht, Hersteller, Verfügbarkeit, Notiz, Lieferanten, Preis, Rabatt, Größe));
				}	
			
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static HashMap<Integer, Artikel> getArtikelsammlung(){
		return Artikelsammlung;
	}
	public static void removeArtikel(int Artikelnummer) {
		Artikelsammlung.remove(Artikelnummer);
	}
		
	public static Artikel getArtikel(int Artikelnummer) {
		return Artikelsammlung.get(Artikelnummer);
	}
	/**
	 * Fügt der Artikelsammlung einen neuen Artikel hinzu.
	 * @param kateg Die Kategorie des Artikels. Also Schuhe, Accessoires oder Kleidung
	 * @param Artikelnummer 
	 * @param Bestand
	 * @param Bezeichnung
	 * @param Geschlecht
	 * @param Hersteller
	 * @param Verfügbarkeit
	 * @param Notiz
	 * @param Lieferanten
	 * @param Preis
	 * @param Rabatt
	 * @param Schuhgröße
	 * @param Farbe
	 * @param Größe
	 * @see Model.Artikel Artikel 
	 * @return 
	 */
	public static void hinzufügenArtikel(String kateg, int Artikelnummer, int Bestand, String Bezeichnung, String Art, String Geschlecht,
			String Hersteller, String Verfügbarkeit, String Notiz, String[] Lieferanten, double Preis,
			int Rabatt, int Schuhgröße, String Farbe, String Größe) {
		Artikel artikel;
		if(kateg == "Schuhe")
			artikel = new Schuhe(Artikelnummer, Bestand, Bezeichnung, Art, Geschlecht, Hersteller, Verfügbarkeit, Notiz, Lieferanten, Preis, Rabatt, Schuhgröße);
		else if(kateg == "Accessoires")
			artikel = new Accessoires(Artikelnummer, Bestand, Bezeichnung, Art, Geschlecht, Hersteller, Verfügbarkeit, Notiz, Lieferanten, Preis, Rabatt, Farbe);
		else 
			artikel = new Kleidung(Artikelnummer, Bestand, Bezeichnung, Art, Geschlecht, Hersteller, Verfügbarkeit, Notiz, Lieferanten, Preis, Rabatt, Größe);
		Artikelsammlung.put(Artikelnummer, artikel);
	}
	
	 public static void loadImages() {
		 for(Artikel a : Artikelsammlung.values()) {
			 a.downloadImage();
		 }
			 
		 
	 }
}

