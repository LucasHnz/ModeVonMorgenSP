package Artikelverwaltung;


import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;

import javax.imageio.ImageIO;
/**
 * 
 * @author Falk Maoro
 *
 */

public class Artikelsammlung {

	static HashMap<Integer,Artikel> Artikelsammlung = new HashMap<Integer,Artikel>();	
	/**
	 * Füllt die Artikelsammlung mit einem übergebenen ResultSet.
	 * @param rs Das ResultSet, das die zu vorhandenen Artikel enthält.
	 * @param kateg	Legt  fest, ob das ResultSet aus Schuhen, Accessoires oder Kleidung besteht.
	 * @see Artikelverwaltung.Artikel
	 */
	public static void füllenSammlung(ResultSet rs, String kateg) {
		BufferedInputStream bis = null;
		BufferedImage bild = null;
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
					bis = new BufferedInputStream( rs.getBinaryStream("Bild") );
					bild = ImageIO.read(bis);
					Artikelsammlung.get(Artikelnummer).setImage(bild);
					
				}else if(kateg == "Accessoires") {
					Farbe = rs.getString("Farbe");
					Artikelsammlung.put(Artikelnummer, new Accessoires(Artikelnummer, Bestand, Bezeichnung, Art, Geschlecht, Hersteller, Verfügbarkeit, Notiz, Lieferanten, Preis, Rabatt, Farbe));
					bis = new BufferedInputStream( rs.getBinaryStream("Bild") );
					bild = ImageIO.read(bis);
					Artikelsammlung.get(Artikelnummer).setImage(bild);
				
				}else if(kateg == "Kleidung") {
					Größe = rs.getString("Größe");
					Artikelsammlung.put(Artikelnummer, new Kleidung(Artikelnummer, Bestand, Bezeichnung, Art, Geschlecht, Hersteller, Verfügbarkeit, Notiz, Lieferanten, Preis, Rabatt, Größe));
					bis = new BufferedInputStream( rs.getBinaryStream("Bild") );
					bild = ImageIO.read(bis);
					Artikelsammlung.get(Artikelnummer).setImage(bild);
				}	
			
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try{
				if(bis != null)
					bis.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}	
	}
	/**
	 * Gibt die in einer HashMap gespeicherte Artikelsammlung zurück.
	 * @return Artikelsammlung.
	 */
	public static HashMap<Integer, Artikel> getArtikelsammlung(){
		return Artikelsammlung;
	}
	/**
	 * Entfernt einen Artikel aus der Artikelsammlung.
	 * @param Artikelnummer Die Artikelnummer des zu löschenden Artikels.
	 * @see Artikelverwaltung.Artikel
	 */
	public static void removeArtikel(int Artikelnummer) {
		Artikelsammlung.remove(Artikelnummer);
	}
	/**
	 * Gibt das Artkelobjekt zurück.
	 * @param Artikelnummer Die Artikelnummer.
	 * @return Das Artikelobjekt mit der übergebenen Artikelnummer.
	 * @see @see Artikelverwaltung.Artikel
	 */
	public static Artikel getArtikel(int Artikelnummer) {
		return Artikelsammlung.get(Artikelnummer);
	}
	/**
	 * Fügt der Artikelsammlung einen neuen Artikel hinzu.
	 * @param kateg Die Kategorie des Artikels. Also Schuhe, Accessoires oder Kleidung.
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
	 * @see Artikelverwaltung.Artikel   
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
	 
}

