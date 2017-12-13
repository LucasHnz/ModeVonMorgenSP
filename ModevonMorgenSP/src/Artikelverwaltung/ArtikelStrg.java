package Artikelverwaltung;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
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
	public static void main(String[] args) {
		FülleArtikelsammlung();
	}
	/**
	 * Fordert die Artikelsammlung auf, einen neuen Artikel mit den übergebenen Parametern hinzuzufügen.
	 * @param kateg Eine der drei Artikelkategorien: Schuhe, Accessoires und Kleidung.
	 * 
	 */
	public static void NeuerArtikel(String kateg, int Artikelnummer, int Bestand, String Bezeichnung, String Art, String Geschlecht,
			String Hersteller, String Verfügbarkeit, String Notiz, String[] Lieferanten, double Preis,
			int Rabatt, int Schuhgröße, String Farbe, String Größe) {
		
		Artikelsammlung.hinzufügenArtikel(kateg, Artikelnummer, Bestand, Bezeichnung, Art, Geschlecht, 
				Hersteller, Verfügbarkeit, Notiz, Lieferanten, Preis, Rabatt, Schuhgröße, Farbe, Größe);
		
		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement(); 
			String sqlInsert = null;
			// Befehl mach ich noch, keine Sorge :D
			if(kateg == "Accessoires") {
		    	
		    	sqlInsert = "update Accessoires set Bezeichnung = '" + Bezeichnung
		    			+ "', Art = '" + Art
		    			+ "', Geschlecht = '" + Geschlecht
		    			+ "', Hersteller = '" + Hersteller
		    			+ "', Lieferant = '" + Lieferanten
		    			+ "', Bestand = '" + Bestand
		    			+ "', Preis = '" + Preis
		    			+ "', Rabatt = '" + Rabatt
		    			+ "', Verügbarkeit = '" + Verfügbarkeit
		    			+ "', Notiz = '" + Notiz
		    			+ "', Farbe = '" + Farbe
		    			+ "  where artikelnr = '" + Artikelnummer + "'"; 
		    	}
		     else if(kateg == "Schuhe") {
		    	sqlInsert = "update Accessoires set Bezeichnung = '" + Bezeichnung
    				+ "', Art = '" + Art
    				+ "', Geschlecht = '" + Geschlecht
    				+ "', Hersteller = '" + Hersteller
    				+ "', Lieferant = '" + Lieferanten
    				+ "', Bestand = '" + Bestand
    				+ "', Preis = '" + Preis
    				+ "', Rabatt = '" + Rabatt
    				+ "', Verügbarkeit = '" + Verfügbarkeit
    				+ "', Notiz = '" + Notiz
    				+ "', Farbe = '" + Schuhgröße
    				+ "  where artikelnr = '" + Artikelnummer + "'"; 
		    	}
		    else if(kateg == "Schuhe") {
		    	sqlInsert = "update Accessoires set Bezeichnung = '" + Bezeichnung 
    				+ "', Art = '" + Art
    				+ "', Geschlecht = '" + Geschlecht
    				+ "', Hersteller = '" + Hersteller
    				+ "', Lieferant = '" + Lieferanten
    				+ "', Bestand = '" + Bestand
    				+ "', Preis = '" + Preis
    				+ "', Rabatt = '" + Rabatt
    				+ "', Verügbarkeit = '" + Verfügbarkeit
    				+ "', Notiz = '" + Notiz
    				+ "', Farbe = '" + Größe
    				+ "  where artikelnr = '" + Artikelnummer + "'"; 
		    	}
		    stmt.addBatch(sqlInsert);
		
		stmt.executeBatch();
		
		stmt.close();
		con.close();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void FülleArtikelsammlung() {
		
		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sqlbefehl1 = "select * from Accessoires";
			ResultSet rs1 = stmt.executeQuery(sqlbefehl1);
			Artikelsammlung.füllenSammlung(rs1, "Accessoires");
			
			String sqlbefehl2 = "select * from Schuhe";
			ResultSet rs2 = stmt.executeQuery(sqlbefehl2);
			Artikelsammlung.füllenSammlung(rs2, "Schuhe");
			
			String sqlbefehl3 = "select * from Kleidung";
			ResultSet rs3 = stmt.executeQuery(sqlbefehl3);
			Artikelsammlung.füllenSammlung(rs3, "Kleidung");
			
			rs1.close();
			rs2.close();
			rs3.close();
			stmt.close();
			con.close();
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
	}
	public static void ArtikelDBSichern() {
		// Nur für die Sicherung nach Updates. Inserts müssen jeweils einzeln gemacht werden.
		HashMap<Integer,Artikel> Sammlung = Artikelsammlung.getArtikelsammlung();
		Statement stmt = null;
		String sqlUpdate = null;
		Artikel test;
		
		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			stmt = con.createStatement(); 
			
			
			for(Map.Entry<Integer, Artikel> entry : Sammlung.entrySet()) {
			    int key = entry.getKey();
			    Artikel artikel = entry.getValue();
			    Accessoires artikel1;
			    Schuhe artikel2;
			    Kleidung artikel3;
			    //System.out.println(key + " " + artikel.getArtikelnummer() + " " + artikel.getClass().toString());
			    
			    if(artikel.getClass().toString() == "Artikelverwaltung.Accessoires") {
			    	artikel1 = (Accessoires) entry.getValue();
			    	sqlUpdate = "update Accessoires set Bezeichnung = '" + artikel1.getBezeichnung() 
			    			+ "', Art = '" + artikel1.getArt()
			    			+ "', Geschlecht = '" + artikel1.getGeschlecht()
			    			+ "', Hersteller = '" + artikel1.getHersteller()
			    			+ "', Lieferant = '" + artikel1.getLieferanten()
			    			+ "', Bestand = '" + artikel1.getBestand()
			    			+ "', Preis = '" + artikel1.getPreis()
			    			+ "', Rabatt = '" + artikel1.getRabatt()
			    			+ "', Verügbarkeit = '" + artikel1.getVerfügbarkeit()
			    			+ "', Notiz = '" + artikel1.getNotiz()
			    			+ "', Farbe = '" + artikel1.getFarbe()
			    			+ "  where artikelnr = '" + artikel1.getArtikelnummer() + "'"; 
			    	}
			     else if(artikel.getClass().toString() == "Artikelverwaltung.Schuhe") {
			    	artikel2 = (Schuhe) entry.getValue();
			    	sqlUpdate = "update Accessoires set Bezeichnung = '" + artikel2.getBezeichnung() 
	    				+ "', Art = '" + artikel2.getArt()
	    				+ "', Geschlecht = '" + artikel2.getGeschlecht()
	    				+ "', Hersteller = '" + artikel2.getHersteller()
	    				+ "', Lieferant = '" + artikel2.getLieferanten()
	    				+ "', Bestand = '" + artikel2.getBestand()
	    				+ "', Preis = '" + artikel2.getPreis()
	    				+ "', Rabatt = '" + artikel2.getRabatt()
	    				+ "', Verügbarkeit = '" + artikel2.getVerfügbarkeit()
	    				+ "', Notiz = '" + artikel2.getNotiz()
	    				+ "', Farbe = '" + artikel2.getSchuhgröße()
	    				+ "  where artikelnr = '" + artikel2.getArtikelnummer() + "'"; 
			    	}
			    else if(artikel.getClass().toString() == "Artikelverwaltung.Schuhe") {
			    	artikel3 = (Kleidung) entry.getValue();
			    	sqlUpdate = "update Accessoires set Bezeichnung = '" + artikel3.getBezeichnung() 
	    				+ "', Art = '" + artikel3.getArt()
	    				+ "', Geschlecht = '" + artikel3.getGeschlecht()
	    				+ "', Hersteller = '" + artikel3.getHersteller()
	    				+ "', Lieferant = '" + artikel3.getLieferanten()
	    				+ "', Bestand = '" + artikel3.getBestand()
	    				+ "', Preis = '" + artikel3.getPreis()
	    				+ "', Rabatt = '" + artikel3.getRabatt()
	    				+ "', Verügbarkeit = '" + artikel3.getVerfügbarkeit()
	    				+ "', Notiz = '" + artikel3.getNotiz()
	    				+ "', Farbe = '" + artikel3.getGröße()
	    				+ "  where artikelnr = '" + artikel3.getArtikelnummer() + "'"; 
			    	}
			    stmt.addBatch(sqlUpdate);
			}
			stmt.executeBatch();
			
			stmt.close();
			con.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
	
	}
}
