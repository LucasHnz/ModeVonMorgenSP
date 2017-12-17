package Artikelverwaltung;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
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
	public static void EditiereArtikel(int Artikelnummer, int Bestand, String Bezeichnung, String Art, String Geschlecht, 
			String Hersteller, String Verf�gbarkeit, String Notiz, String[] Lieferanten, Double Preis, int Rabatt, int Schuhgr��e, String Farbe,
			String Gr��e) {
		Statement stmt = null;
		String sqlUpdate = null;
		Artikel artikel = Artikelsammlung.getArtikel(Artikelnummer);
		Accessoires artikel1;
		Schuhe artikel2;
		Kleidung artikel3;
		
		
		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			stmt = con.createStatement(); 
			
			if(artikel.getClass().getName() == "Artikelverwaltung.Accessoires") {
		    	artikel1 = (Accessoires) artikel;
		    	artikel1.setBezeichnung(Bezeichnung);
		    	artikel1.setArt(Art);
		    	artikel1.setGeschlecht(Geschlecht);
		    	artikel1.setHersteller(Hersteller);
		    	artikel1.setLieferanten(Lieferanten);
		    	artikel1.setBestand(Bestand);
		    	artikel1.setPreis(Preis);
		    	artikel1.setRabatt(Rabatt);
		    	artikel1.setVerf�gbarkeit(Verf�gbarkeit);
		    	artikel1.setNotiz(Notiz);
		    	artikel1.setFarbe(Farbe);
		    	
		    	String str = Arrays.toString(Artikelsammlung.getArtikel(Artikelnummer).getLieferanten());
				str = str.replace("[", "");
				str = str.replace("]", "");
				
		    	sqlUpdate = "update Accessoires set Bezeichnung = '" + artikel1.getBezeichnung() 
					+ "', Art = '" + artikel1.getArt()
					+ "', Geschlecht = '" + artikel1.getGeschlecht()
					+ "', Hersteller = '" + artikel1.getHersteller()
					+ "', Lieferant = '" + 	str
					+ "', Bestand =  " + artikel1.getBestand()
					+ " , Preis =  " + artikel1.getPreis()
					+ " , Rabatt =  " + artikel1.getRabatt()
					+ " , Verf�gbarkeit = '" + artikel1.getVerf�gbarkeit()
					+ "', Notiz = '" + artikel1.getNotiz()
					+ "', farbe = '" + artikel1.getFarbe()
					+ "'  where artikelnr =  " + artikel1.getArtikelnummer();  
		    	}
		     else if(artikel.getClass().getName() == "Artikelverwaltung.Schuhe") {
		    	artikel2 = (Schuhe) artikel;
		    	artikel2.setBezeichnung(Bezeichnung);
		    	artikel2.setArt(Art);
		    	artikel2.setGeschlecht(Geschlecht);
		    	artikel2.setHersteller(Hersteller);
		    	artikel2.setLieferanten(Lieferanten);
		    	artikel2.setBestand(Bestand);
		    	artikel2.setPreis(Preis);
		    	artikel2.setRabatt(Rabatt);
		    	artikel2.setVerf�gbarkeit(Verf�gbarkeit);
		    	artikel2.setNotiz(Notiz);
		    	artikel2.setSchuhgr��e(Schuhgr��e);
		    	
		    	String str = Arrays.toString(Artikelsammlung.getArtikel(Artikelnummer).getLieferanten());
				str = str.replace("[", "");
				str = str.replace("]", "");
				
		    	sqlUpdate = "update Schuhe set Bezeichnung = '" + artikel2.getBezeichnung() 
					+ "', Art = '" + artikel2.getArt()
					+ "', Geschlecht = '" + artikel2.getGeschlecht()
					+ "', Hersteller = '" + artikel2.getHersteller()
					+ "', Lieferant = '" + 	str
					+ "', Bestand =  " + artikel2.getBestand()
					+ " , Preis =  " + artikel2.getPreis()
					+ " , Rabatt =  " + artikel2.getRabatt()
					+ " , Verf�gbarkeit = '" + artikel2.getVerf�gbarkeit()
					+ "', Notiz = '" + artikel2.getNotiz()
					+ "', schuhgr��e = " + artikel2.getSchuhgr��e()
					+ "  where artikelnr =  " + artikel2.getArtikelnummer(); 
		    	
		    	}
		    else if(artikel.getClass().getName() == "Artikelverwaltung.Kleidung") {
		    	artikel3 = (Kleidung) artikel;
		    	artikel3.setBezeichnung(Bezeichnung);
		    	artikel3.setArt(Art);
		    	artikel3.setGeschlecht(Geschlecht);
		    	artikel3.setHersteller(Hersteller);
		    	artikel3.setLieferanten(Lieferanten);
		    	artikel3.setBestand(Bestand);
		    	artikel3.setPreis(Preis);
		    	artikel3.setRabatt(Rabatt);
		    	artikel3.setVerf�gbarkeit(Verf�gbarkeit);
		    	artikel3.setNotiz(Notiz);
		    	artikel3.setGr��e(Farbe);
		    	
		    	String str = Arrays.toString(Artikelsammlung.getArtikel(Artikelnummer).getLieferanten());
				str = str.replace("[", "");
				str = str.replace("]", "");
				
		    	sqlUpdate = "update Kleidung set Bezeichnung = '" + artikel3.getBezeichnung() 
					+ "', Art = '" + artikel3.getArt()
					+ "', Geschlecht = '" + artikel3.getGeschlecht()
					+ "', Hersteller = '" + artikel3.getHersteller()
					+ "', Lieferant = '" + 	str
					+ "', Bestand =  " + artikel3.getBestand()
					+ " , Preis =  " + artikel3.getPreis()
					+ " , Rabatt =  " + artikel3.getRabatt()
					+ " , Verf�gbarkeit = '" + artikel3.getVerf�gbarkeit()
					+ "', Notiz = '" + artikel3.getNotiz()
					+ "', gr��e = '" + artikel3.getGr��e()
					+ "'  where artikelnr =  " + artikel3.getArtikelnummer(); 
		    	}
			
			stmt.executeUpdate(sqlUpdate);
			stmt.close();
			con.close();
			}catch(SQLException e) {
		    	e.printStackTrace();
		    }
	}
	public static void main(String[] args) {
		F�lleArtikelsammlung();
		ArtikelDBSichern();
	}
	public static void entferneArtikel(int Artikelnr) {
		int pk = Artikelnr;
		Artikel artikel = Artikelsammlung.getArtikel(Artikelnr);
		String sqlbefehel = null;
		
		try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			
			if(artikel.getClass().getName() == "Artikelverwaltung.Schuhe")
				sqlbefehel ="delete from Schuhe where artikelnr = '"+pk+"'";
			else if(artikel.getClass().getName() == "Artikelverwaltung.Accessoires")
				sqlbefehel ="delete from Accessoires where artikelnr = '"+pk+"'";
			else if(artikel.getClass().getName() == "Artikelverwaltung.Kleidung")
				sqlbefehel ="delete from Kleidung where artikelnr = '"+pk+"'";
			
			stmt.executeQuery(sqlbefehel);
			Artikelsammlung.removeArtikel(Artikelnr);
			stmt.close();
			con.close();
			
		}catch (SQLException e) {
			e.getMessage();
		}
	}
	/**
	 * Fordert die Artikelsammlung auf, einen neuen Artikel mit den �bergebenen Parametern hinzuzuf�gen.
	 * @param kateg Eine der drei Artikelkategorien: Schuhe, Accessoires und Kleidung.
	 * 
	 */
	public static void NeuerArtikel(String kateg, int Artikelnummer, int Bestand, String Bezeichnung, String Art, String Geschlecht,
			String Hersteller, String Verf�gbarkeit, String Notiz, String[] Lieferanten, double Preis,
			int Rabatt, int Schuhgr��e, String Farbe, String Gr��e) {
		
		Artikelsammlung.hinzuf�genArtikel(kateg, Artikelnummer, Bestand, Bezeichnung, Art, Geschlecht, 
				Hersteller, Verf�gbarkeit, Notiz, Lieferanten, Preis, Rabatt, Schuhgr��e, Farbe, Gr��e);
		
		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement(); 
			String sqlInsert = null;
			
			if(kateg == "Accessoires") {
		    	
		    	sqlInsert = "insert into Accessoires  (artikelnr, bezeichnung, Art, Geschlecht, Hersteller, Lieferant, Bestand, Preis, Rabatt, Verf�gbarkeit, Notiz, Farbe) values "
		    			+ "(   " + Artikelnummer
		    			+ " , '" + Bezeichnung
		    			+ "', '" + Art
		    			+ "', '" + Geschlecht
		    			+ "', '" + Hersteller
		    			+ "', '" + Lieferanten
		    			+ "',  " + Bestand
		    			+ " ,  " + Preis
		    			+ " ,  " + Rabatt
		    			+ " , '" + Verf�gbarkeit
		    			+ "', '" + Notiz
		    			+ "', '" + Farbe
		    			+ "')" ; 
		    	}
		     else if(kateg == "Schuhe") {
		    	sqlInsert = "insert into Schuhe  (artikelnr, bezeichnung, Art, Geschlecht, Hersteller, Lieferant, Bestand, Preis, Rabatt, Verf�gbarkeit, Notiz, Schuhgr��e) values "
		    			+ "(   " + Artikelnummer
		    			+ " , '" + Bezeichnung
		    			+ "', '" + Art
		    			+ "', '" + Geschlecht
		    			+ "', '" + Hersteller
		    			+ "', '" + Lieferanten
		    			+ "',  " + Bestand
		    			+ " ,  " + Preis
		    			+ " ,  " + Rabatt
		    			+ " , '" + Verf�gbarkeit
		    			+ "', '" + Notiz
		    			+ "',  " + Schuhgr��e
		    			+ ")" ; 
		    	}
		    else if(kateg == "Kleidung") {
		    	 sqlInsert = "insert into Kleidung  (artikelnr, bezeichnung, Art, Geschlecht, Hersteller, Lieferant, Bestand, Preis, Rabatt, Verf�gbarkeit, Notiz, Gr��e) values "
		    			+ "(   " + Artikelnummer
		    			+ " , '" + Bezeichnung
		    			+ "', '" + Art
		    			+ "', '" + Geschlecht
		    			+ "', '" + Hersteller
		    			+ "', '" + Lieferanten
		    			+ "',  " + Bestand
		    			+ " ,  " + Preis
		    			+ " ,  " + Rabatt
		    			+ " , '" + Verf�gbarkeit
		    			+ "', '" + Notiz
		    			+ "', '" + Gr��e
		    			+ "')" ; 
		    	}
				
		stmt.executeUpdate(sqlInsert);
		
		stmt.close();
		con.close();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void F�lleArtikelsammlung() {
		
		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sqlbefehl1 = "select * from Accessoires";
			ResultSet rs1 = stmt.executeQuery(sqlbefehl1);
			Artikelsammlung.f�llenSammlung(rs1, "Accessoires");
			
			String sqlbefehl2 = "select * from Schuhe";
			ResultSet rs2 = stmt.executeQuery(sqlbefehl2);
			Artikelsammlung.f�llenSammlung(rs2, "Schuhe");
			
			String sqlbefehl3 = "select * from Kleidung";
			ResultSet rs3 = stmt.executeQuery(sqlbefehl3);
			Artikelsammlung.f�llenSammlung(rs3, "Kleidung");
			
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
		// Nur f�r die Sicherung nach Updates. Inserts m�ssen jeweils einzeln gemacht werden.
		HashMap<Integer,Artikel> Sammlung = Artikelsammlung.getArtikelsammlung();
		Statement stmt = null;
		String sqlUpdate = null;
		
		
		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			stmt = con.createStatement(); 
			
			
			for(Map.Entry<Integer, Artikel> entry : Sammlung.entrySet()) {
			
			    Artikel artikel = entry.getValue();
			    Accessoires artikel1;
			    Schuhe artikel2;
			    Kleidung artikel3;
			    			    
			    if(artikel.getClass().getName() == "Artikelverwaltung.Accessoires") {
			    	artikel1 = (Accessoires) entry.getValue();
			    	sqlUpdate = "update Accessoires set Bezeichnung = '" + artikel1.getBezeichnung() 
			    			+ "', Art = '" + artikel1.getArt()
			    			+ "', Geschlecht = '" + artikel1.getGeschlecht()
			    			+ "', Hersteller = '" + artikel1.getHersteller()
			    			+ "', Lieferant = '" + artikel1.getLieferanten()
			    			+ "', Bestand = '" + artikel1.getBestand()
			    			+ "', Preis = '" + artikel1.getPreis()
			    			+ "', Rabatt = '" + artikel1.getRabatt()
			    			+ "', Verf�gbarkeit = '" + artikel1.getVerf�gbarkeit()
			    			+ "', Notiz = '" + artikel1.getNotiz()
			    			+ "', Farbe = '" + artikel1.getFarbe()
			    			+ "  where artikelnr = '" + artikel1.getArtikelnummer() + "'"; 
			    	}
			     else if(artikel.getClass().getName() == "Artikelverwaltung.Schuhe") {
			    	artikel2 = (Schuhe) entry.getValue();
			    	sqlUpdate = "update Accessoires set Bezeichnung = '" + artikel2.getBezeichnung() 
	    				+ "', Art = '" + artikel2.getArt()
	    				+ "', Geschlecht = '" + artikel2.getGeschlecht()
	    				+ "', Hersteller = '" + artikel2.getHersteller()
	    				+ "', Lieferant = '" + artikel2.getLieferanten()
	    				+ "', Bestand = '" + artikel2.getBestand()
	    				+ "', Preis = '" + artikel2.getPreis()
	    				+ "', Rabatt = '" + artikel2.getRabatt()
	    				+ "', Verf�gbarkeit = '" + artikel2.getVerf�gbarkeit()
	    				+ "', Notiz = '" + artikel2.getNotiz()
	    				+ "', Farbe = '" + artikel2.getSchuhgr��e()
	    				+ "  where artikelnr = '" + artikel2.getArtikelnummer() + "'"; 
			    	}
			    else if(artikel.getClass().getName() == "Artikelverwaltung.Schuhe") {
			    	artikel3 = (Kleidung) entry.getValue();
			    	sqlUpdate = "update Accessoires set Bezeichnung = '" + artikel3.getBezeichnung() 
	    				+ "', Art = '" + artikel3.getArt()
	    				+ "', Geschlecht = '" + artikel3.getGeschlecht()
	    				+ "', Hersteller = '" + artikel3.getHersteller()
	    				+ "', Lieferant = '" + artikel3.getLieferanten()
	    				+ "', Bestand = '" + artikel3.getBestand()
	    				+ "', Preis = '" + artikel3.getPreis()
	    				+ "', Rabatt = '" + artikel3.getRabatt()
	    				+ "', Verf�gbarkeit = '" + artikel3.getVerf�gbarkeit()
	    				+ "', Notiz = '" + artikel3.getNotiz()
	    				+ "', Farbe = '" + artikel3.getGr��e()
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
	public static void aktualisiereRabatt(int Rabatt, int Artikelnummer) {
		HashMap<Integer,Artikel> Sammlung = Artikelsammlung.getArtikelsammlung();
		Statement stmt = null;
		String sqlUpdate = null;
		Artikel artikel = Sammlung.get(Artikelnummer);
		try{
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			stmt = con.createStatement();
			
			if(artikel.getClass().getName() == "Artikelverwaltung.Accessoires")
				sqlUpdate = "update Accessoires set rabatt ='"+Rabatt+"' where Artikelnr ="+Artikelnummer;
			else if(artikel.getClass().getName() == "Artikelverwaltung.Kleidung")
				sqlUpdate = "update Kleidung set rabatt ='"+Rabatt+"' where Artikelnr ="+Artikelnummer;
			else if(artikel.getClass().getName() == "Artikelverwaltung.Schuhe")
				sqlUpdate = "update Schuhe set rabatt ='"+Rabatt+"' where Artikelnr ="+Artikelnummer;
			System.out.println(sqlUpdate);
			stmt.execute(sqlUpdate)	;
			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
			artikel.setRabatt(Rabatt);
			
			}catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public static void aktualisiereBestand(int Bestand, int Artikelnummer) {
		HashMap<Integer,Artikel> Sammlung = Artikelsammlung.getArtikelsammlung();
		Statement stmt = null;
		String sqlUpdate = null;
		Artikel artikel = Sammlung.get(Artikelnummer);
		try{
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			stmt = con.createStatement();
			
			if(artikel.getClass().getName() == "Artikelverwaltung.Accessoires")
				sqlUpdate = "update Accessoires set Bestand ='"+Bestand+"' where Artikelnr ="+Artikelnummer;
			else if(artikel.getClass().getName() == "Artikelverwaltung.Kleidung")
				sqlUpdate = "update Kleidung set Bestand ='"+Bestand+"' where Artikelnr ="+Artikelnummer;
			else if(artikel.getClass().getName() == "Artikelverwaltung.Schuhe")
				sqlUpdate = "update Schuhe set Bestand ='"+Bestand+"' where Artikelnr ="+Artikelnummer;
			System.out.println(sqlUpdate);
			stmt.execute(sqlUpdate)	;
			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
			artikel.setBestand(Bestand);
			
			}catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public static void aktualisiereNotiz(String Notiz, int Artikelnummer) {
		HashMap<Integer,Artikel> Sammlung = Artikelsammlung.getArtikelsammlung();
		Statement stmt = null;
		String sqlUpdate = null;
		Artikel artikel = Sammlung.get(Artikelnummer);
		try{
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			stmt = con.createStatement();
			
			if(artikel.getClass().getName() == "Artikelverwaltung.Accessoires")
				sqlUpdate = "update Accessoires set Notiz ='"+Notiz+"' where Artikelnr ="+Artikelnummer;
			else if(artikel.getClass().getName() == "Artikelverwaltung.Kleidung")
				sqlUpdate = "update Kleidung set Notiz ='"+Notiz+"' where Artikelnr ="+Artikelnummer;
			else if(artikel.getClass().getName() == "Artikelverwaltung.Schuhe")
				sqlUpdate = "update Schuhe set Notiz ='"+Notiz+"' where Artikelnr ="+Artikelnummer;
			System.out.println(sqlUpdate);
			stmt.execute(sqlUpdate)	;
			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
			artikel.setNotiz(Notiz);
			
			}catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
