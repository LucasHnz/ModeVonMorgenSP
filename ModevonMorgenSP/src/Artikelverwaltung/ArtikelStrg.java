package Artikelverwaltung;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
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
	 * �ndert die Attribute eines Artikels in der Datenbank und in der Artikelsammlung.
	 * @param Artikelnummer
	 * @param Bestand
	 * @param Bezeichnung
	 * @param Art
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
			
			String str = "";
			String[] lieferanten = Lieferanten;
			for(int i=0; i< lieferanten.length; i++) {
				if(i == (lieferanten.length -1) )
					str = str + lieferanten[i];
				else
					str = str + lieferanten[i] + ",";
			}
						
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
		    	artikel3.setGr��e(Gr��e);
		    	
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
	/**
	 * Entfernt einen Artikel aus der Datenbank und der Artikelsammlung.
	 * @param Artikelnr Die Artikelnummer des Artikels.
	 * @see Artikelverwaltung.Artikel
	 * @see Artikelverwaltung.Artikelsammlung
	 */
	public static void entferneArtikel(int Artikelnr) {
		int pk = Artikelnr;
		Artikel artikel = Artikelsammlung.getArtikel(Artikelnr);
		String sqlbefehel = null;
		Connection con = null;
		Statement stmt = null;
		try {
			
			con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			stmt = con.createStatement();
			
			if(artikel.getClass().getName() == "Artikelverwaltung.Schuhe")
				sqlbefehel ="delete from Schuhe where artikelnr = '"+pk+"'";
			else if(artikel.getClass().getName() == "Artikelverwaltung.Accessoires")
				sqlbefehel ="delete from Accessoires where artikelnr = '"+pk+"'";
			else if(artikel.getClass().getName() == "Artikelverwaltung.Kleidung")
				sqlbefehel ="delete from Kleidung where artikelnr = '"+pk+"'";
			
			stmt.executeQuery(sqlbefehel);
			Artikelsammlung.removeArtikel(Artikelnr);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt !=null) 
					stmt.close();
				if(con != null)
					con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * Fordert die Artikelsammlung auf, einen neuen Artikel mit den �bergebenen Parametern hinzuzuf�gen.
	 * @param kateg Eine der drei Artikelkategorien: Schuhe, Accessoires und Kleidung.
	 * @see Artikelverwaltung.Artikel
	 * @see Artikelverwaltung.Artikelsammlung
	 */
	public static void NeuerArtikel(String kateg, int Artikelnummer, int Bestand, String Bezeichnung, String Art, String Geschlecht,
			String Hersteller, String Verf�gbarkeit, String Notiz, String[] Lieferanten, double Preis,
			int Rabatt, int Schuhgr��e, String Farbe, String Gr��e) {
		
		Artikelsammlung.hinzuf�genArtikel(kateg, Artikelnummer, Bestand, Bezeichnung, Art, Geschlecht, 
				Hersteller, Verf�gbarkeit, Notiz, Lieferanten, Preis, Rabatt, Schuhgr��e, Farbe, Gr��e);
		Connection con = null;
		Statement stmt = null;
		try {
			con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			stmt = con.createStatement(); 
			String sqlInsert = null;
			String strLieferanten = "";
			String[] lieferanten = Artikelsammlung.getArtikel(Artikelnummer).getLieferanten();
			for(int i=0; i< lieferanten.length; i++) {
				if(i == (lieferanten.length -1) )
					strLieferanten = strLieferanten + lieferanten[i];
				else
					strLieferanten = strLieferanten + lieferanten[i] + ",";
			}
			
			if(kateg == "Accessoires") {
		    	sqlInsert = "insert into Accessoires  (artikelnr, bezeichnung, Art, Geschlecht, Hersteller, Lieferant, Bestand, Preis, Rabatt, Verf�gbarkeit, Farbe) values "
		    			+ "(   " + Artikelnummer
		    			+ " , '" + Bezeichnung
		    			+ "', '" + Art
		    			+ "', '" + Geschlecht
		    			+ "', '" + Hersteller
		    			+ "', '" + strLieferanten
		    			+ "',  " + Bestand
		    			+ " ,  " + Preis
		    			+ " ,  " + Rabatt
		    			+ " , '" + Verf�gbarkeit
		    			+ "', '" + Farbe
		    			+ "')" ; 
		    	}
		     else if(kateg == "Schuhe") {
		    	sqlInsert = "insert into Schuhe  (artikelnr, bezeichnung, Art, Geschlecht, Hersteller, Lieferant, Bestand, Preis, Rabatt, Verf�gbarkeit, Schuhgr��e) values "
		    			+ "(   " + Artikelnummer
		    			+ " , '" + Bezeichnung
		    			+ "', '" + Art
		    			+ "', '" + Geschlecht
		    			+ "', '" + Hersteller
		    			+ "', '" + strLieferanten
		    			+ "',  " + Bestand
		    			+ " ,  " + Preis
		    			+ " ,  " + Rabatt
		    			+ " , '" + Verf�gbarkeit
		    			+ "',  " + Schuhgr��e
		    			+ ")" ; 
		    	}
		    else if(kateg == "Kleidung") {
		    	 sqlInsert = "insert into Kleidung  (artikelnr, bezeichnung, Art, Geschlecht, Hersteller, Lieferant, Bestand, Preis, Rabatt, Verf�gbarkeit, Gr��e) values "
		    			+ "(   " + Artikelnummer
		    			+ " , '" + Bezeichnung
		    			+ "', '" + Art
		    			+ "', '" + Geschlecht
		    			+ "', '" + Hersteller
		    			+ "', '" + strLieferanten
		    			+ "',  " + Bestand
		    			+ " ,  " + Preis
		    			+ " ,  " + Rabatt
		    			+ " , '" + Verf�gbarkeit
		    			+ "', '" + Gr��e
		    			+ "')" ; 
		    	}
				
		stmt.executeUpdate(sqlInsert);
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt !=null) 
					stmt.close();
				if(con != null)
					con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * Ruft alle Artikel aus der Datenbank auf und speichert sie in der Artikelsammlung.
	 * @see Artikelverwaltung.Artikelsammlung
	 */
	public static void F�lleArtikelsammlung() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		
		try {
			con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			stmt = con.createStatement();
			String sqlbefehl1 = "select * from Accessoires";
			rs1 = stmt.executeQuery(sqlbefehl1);
			Artikelsammlung.f�llenSammlung(rs1, "Accessoires");
			
			String sqlbefehl2 = "select * from Schuhe";
			rs2 = stmt.executeQuery(sqlbefehl2);
			Artikelsammlung.f�llenSammlung(rs2, "Schuhe");
			
			String sqlbefehl3 = "select * from Kleidung";
			rs3 = stmt.executeQuery(sqlbefehl3);
			Artikelsammlung.f�llenSammlung(rs3, "Kleidung");
			
			
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}finally {
			try {
				if(stmt !=null) 
					stmt.close();
				if(con != null)
					con.close();
				if(rs1 != null)
					rs1.close();
				if(rs2 != null)
					rs2.close();
				if(rs3 != null)
					rs3.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/** 
	 * �ndert den Rabatt eines Artikels in der Datenbank und der Artikelsammlung.
	 * @param Rabatt Der neue Rabatt
	 * @param Artikelnummer Die Artikelnummer des Artikels
	 * @see Artikelverwaltung.Artikel
	 * @see Artikelverwaltung.Artikelsammlung
	 */
	public static void aktualisiereRabatt(int Rabatt, int Artikelnummer) {
		HashMap<Integer,Artikel> Sammlung = Artikelsammlung.getArtikelsammlung();
		Connection con = null;
		Statement stmt = null;
		String sqlUpdate = null;
		Artikel artikel = Sammlung.get(Artikelnummer);
		
		try{
			con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			stmt = con.createStatement();
			
			if(artikel.getClass().getName() == "Artikelverwaltung.Accessoires")
				sqlUpdate = "update Accessoires set rabatt ='"+Rabatt+"' where Artikelnr ="+Artikelnummer;
			else if(artikel.getClass().getName() == "Artikelverwaltung.Kleidung")
				sqlUpdate = "update Kleidung set rabatt ='"+Rabatt+"' where Artikelnr ="+Artikelnummer;
			else if(artikel.getClass().getName() == "Artikelverwaltung.Schuhe")
				sqlUpdate = "update Schuhe set rabatt ='"+Rabatt+"' where Artikelnr ="+Artikelnummer;
	
			stmt.execute(sqlUpdate)	;
			artikel.setRabatt(Rabatt);
			
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(stmt !=null) 
						stmt.close();
					if(con != null)
						con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
	}
	/** 
	 * �ndert den Bestand eines Artikels in der Datenbank und der Artikelsammlung.
	 * @param Bestand Der neue Bestand
	 * @param Artikelnummer Die Artikelnummer des Artikels
	 * @see Artikelverwaltung.Artikel
	 * @see Artikelverwaltung.Artikelsammlung
	 */
	public static void aktualisiereBestand(int Bestand, int Artikelnummer) {
		HashMap<Integer,Artikel> Sammlung = Artikelsammlung.getArtikelsammlung();
		Statement stmt = null;
		String sqlUpdate = null;
		Artikel artikel = Sammlung.get(Artikelnummer);
		Connection con = null;
		try{
			con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			stmt = con.createStatement();
			
			if(artikel.getClass().getName() == "Artikelverwaltung.Accessoires")
				sqlUpdate = "update Accessoires set Bestand ='"+Bestand+"' where Artikelnr ="+Artikelnummer;
			else if(artikel.getClass().getName() == "Artikelverwaltung.Kleidung")
				sqlUpdate = "update Kleidung set Bestand ='"+Bestand+"' where Artikelnr ="+Artikelnummer;
			else if(artikel.getClass().getName() == "Artikelverwaltung.Schuhe")
				sqlUpdate = "update Schuhe set Bestand ='"+Bestand+"' where Artikelnr ="+Artikelnummer;
			
			stmt.execute(sqlUpdate)	;
			artikel.setBestand(Bestand);
			
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(stmt !=null) 
						stmt.close();
					if(con != null)
						con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
	}
	/** 
	 * �ndert die Notiz eines Artikels in der Datenbank und der Artikelsammlung.
	 * @param Notiz Die neue Notiz
	 * @param Artikelnummer Die Artikelnummer des Artikels
	 * @see Artikelverwaltung.Artikel
	 * @see Artikelverwaltung.Artikelsammlung
	 */
	public static void aktualisiereNotiz(String Notiz, int Artikelnummer) {
		HashMap<Integer,Artikel> Sammlung = Artikelsammlung.getArtikelsammlung();
		Connection con = null;
		Artikel artikel = Sammlung.get(Artikelnummer);
		PreparedStatement ps = null;
		try{
			con = Datenbankverwaltung.VerbindungDB.erstelleConnection();

			if(artikel.getClass().getName() == "Artikelverwaltung.Accessoires")
				ps = con.prepareStatement("update Accessoires set Notiz = ? where Artikelnr = ?");
			else if(artikel.getClass().getName() == "Artikelverwaltung.Kleidung")
				ps = con.prepareStatement("update Kleidung set Notiz = ? where Artikelnr = ?");
			else if(artikel.getClass().getName() == "Artikelverwaltung.Schuhe")
				ps = con.prepareStatement("update Schuhe set Notiz = ? where Artikelnr = ?");
				   	
	    	if(Notiz != null && Notiz != "")
	    		ps.setString(1, Notiz);
	    	else
	    		ps.setNull(1, Types.NULL);
	    	
	    	ps.setInt(2, artikel.getArtikelnummer());
	    	ps.execute();
	    	artikel.setNotiz(Notiz);
			
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(ps !=null) 
						ps.close();
					if(con != null)
						con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
	}
}
