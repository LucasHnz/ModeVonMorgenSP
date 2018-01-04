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
	 * F�llt die Artikelsammlung mit einem �bergebenen ResultSet.
	 * @param rs Das ResultSet, das die zu vorhandenen Artikel enth�lt.
	 * @param kateg	Legt  fest, ob das ResultSet aus Schuhen, Accessoires oder Kleidung besteht.
	 * @see Artikelverwaltung.Artikel
	 */
	public static void f�llenSammlung(ResultSet rs, String kateg) {
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
				String Verf�gbarkeit = rs.getString("Verf�gbarkeit");
				String Notiz = rs.getString("Notiz");
				if(rs.wasNull())
						Notiz = null;
				double Preis = rs.getDouble("Preis");
				int Rabatt = rs.getInt("Rabatt");
				int Schuhgr��e;
				String Farbe, Gr��e;
				
				
				if(kateg == "Schuhe") {
					Schuhgr��e = rs.getInt("Schuhgr��e");
					Artikelsammlung.put(Artikelnummer, new Schuhe(Artikelnummer, Bestand, Bezeichnung, Art, Geschlecht, Hersteller, Verf�gbarkeit, Notiz, Lieferanten, Preis, Rabatt, Schuhgr��e));
					bis = new BufferedInputStream( rs.getBinaryStream("Bild") );
					bild = ImageIO.read(bis);
					Artikelsammlung.get(Artikelnummer).setImage(bild);
					
				}else if(kateg == "Accessoires") {
					Farbe = rs.getString("Farbe");
					Artikelsammlung.put(Artikelnummer, new Accessoires(Artikelnummer, Bestand, Bezeichnung, Art, Geschlecht, Hersteller, Verf�gbarkeit, Notiz, Lieferanten, Preis, Rabatt, Farbe));
					bis = new BufferedInputStream( rs.getBinaryStream("Bild") );
					bild = ImageIO.read(bis);
					Artikelsammlung.get(Artikelnummer).setImage(bild);
				
				}else if(kateg == "Kleidung") {
					Gr��e = rs.getString("Gr��e");
					Artikelsammlung.put(Artikelnummer, new Kleidung(Artikelnummer, Bestand, Bezeichnung, Art, Geschlecht, Hersteller, Verf�gbarkeit, Notiz, Lieferanten, Preis, Rabatt, Gr��e));
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
	 * Gibt die in einer HashMap gespeicherte Artikelsammlung zur�ck.
	 * @return Artikelsammlung.
	 */
	public static HashMap<Integer, Artikel> getArtikelsammlung(){
		return Artikelsammlung;
	}
	/**
	 * Entfernt einen Artikel aus der Artikelsammlung.
	 * @param Artikelnummer Die Artikelnummer des zu l�schenden Artikels.
	 * @see Artikelverwaltung.Artikel
	 */
	public static void removeArtikel(int Artikelnummer) {
		Artikelsammlung.remove(Artikelnummer);
	}
	/**
	 * Gibt das Artkelobjekt zur�ck.
	 * @param Artikelnummer Die Artikelnummer.
	 * @return Das Artikelobjekt mit der �bergebenen Artikelnummer.
	 * @see @see Artikelverwaltung.Artikel
	 */
	public static Artikel getArtikel(int Artikelnummer) {
		return Artikelsammlung.get(Artikelnummer);
	}
	/**
	 * F�gt der Artikelsammlung einen neuen Artikel hinzu.
	 * @param kateg Die Kategorie des Artikels. Also Schuhe, Accessoires oder Kleidung.
	 * @param Artikelnummer 
	 * @param Bestand
	 * @param Bezeichnung
	 * @param Geschlecht
	 * @param Hersteller
	 * @param Verf�gbarkeit
	 * @param Notiz
	 * @param Lieferanten
	 * @param Preis
	 * @param Rabatt
	 * @param Schuhgr��e
	 * @param Farbe
	 * @param Gr��e
	 * @see Artikelverwaltung.Artikel   
	 */
	public static void hinzuf�genArtikel(String kateg, int Artikelnummer, int Bestand, String Bezeichnung, String Art, String Geschlecht,
			String Hersteller, String Verf�gbarkeit, String Notiz, String[] Lieferanten, double Preis,
			int Rabatt, int Schuhgr��e, String Farbe, String Gr��e) {
		Artikel artikel;
		if(kateg == "Schuhe")
			artikel = new Schuhe(Artikelnummer, Bestand, Bezeichnung, Art, Geschlecht, Hersteller, Verf�gbarkeit, Notiz, Lieferanten, Preis, Rabatt, Schuhgr��e);
		else if(kateg == "Accessoires")
			artikel = new Accessoires(Artikelnummer, Bestand, Bezeichnung, Art, Geschlecht, Hersteller, Verf�gbarkeit, Notiz, Lieferanten, Preis, Rabatt, Farbe);
		else 
			artikel = new Kleidung(Artikelnummer, Bestand, Bezeichnung, Art, Geschlecht, Hersteller, Verf�gbarkeit, Notiz, Lieferanten, Preis, Rabatt, Gr��e);
		Artikelsammlung.put(Artikelnummer, artikel);
	}
	 
}

