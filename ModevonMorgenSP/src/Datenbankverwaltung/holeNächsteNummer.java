package Datenbankverwaltung;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * 
 * @author julian
 *
 */
public class holeN�chsteNummer {
	
	/**
	 * Holt sich die n�chste Nummer
	 * @return Nutzernr
	 */
	public static int n�chsteMaNr(){
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(nutzernr) from Mitarbeiter";
			
			ResultSet rs = stmt.executeQuery(sqlbefehl);
			while (rs.next()) {
				i = rs.getInt(1);
				
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (i+1);
	}
	
	/**
	 * Holt sich die n�chste AdminNr
	 * @return Admin Nutzer Nummer
	 */
	public static int n�chsteAdminNr() {
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(nutzernr) from Administrator";
			
			ResultSet rs = stmt.executeQuery(sqlbefehl);
			while (rs.next()) {
				i = rs.getInt(1);
				
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (i+1);
	}
	
	/**
	 * holt sich die n�chste Bestandskunden Nummer
	 * @return Bestandskunden nummer
	 */
	public static int n�chsteBKundenNr() {
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(nutzernr) from Bestandskunde";
			
			ResultSet rs = stmt.executeQuery(sqlbefehl);
			while (rs.next()) {
				i = rs.getInt("max(nutzernr)");
				
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (i+1);
	}
	
	/**
	 * Holt sich die n�chste GKunden Nummer
	 * @return Gastkunden Nummer
	 */
	public static int n�chsteGKundenNr() {
		
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(nutzernr) from gastkunde";
			
			ResultSet rs = stmt.executeQuery(sqlbefehl);
			while (rs.next()) {
				i = rs.getInt(1);
				System.out.println(i);
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (i+1);
}
	
	/**
	 * Holt sich die n�chste Schuh Nummer
	 * @return Artikelnummer
	 */
	public static int n�chsteSchuhNr() {
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(artikelnr) from Schuhe";
			
			ResultSet rs = stmt.executeQuery(sqlbefehl);
			while (rs.next()) {
				i = rs.getInt("max(artikelnr)");
				
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		 return (i+1);
	}
		
	/**
	 * Holt sich die N�chste kleidungs Nummer
	 * @return Artikelnummer
	 */
	public static int n�chsteKleidungNr() {
	
		int i = 0;
		
		try {
			
			Connection con = VerbindungDB.erstelleConnection();
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(artikelnr) from kleidung";
			
			ResultSet rs = stmt.executeQuery(sqlbefehl);
			while (rs.next()) {
				i = rs.getInt("max(artikelnr)");
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (i+1);
	}

	/**
	 * Holt sich die n�chste Access. Nummer
	 * @return Artikelnummer
	 */
	public static int n�chsteAccessNr() {
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(artikelnr) from Accessoires";
			
			ResultSet rs = stmt.executeQuery(sqlbefehl);
			while (rs.next()) {
				i = rs.getInt("max(artikelnr)");
				
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (i+1);
	
	}

	/**
	 * Holt sich die n�chste Bestellpos nummer
	 * @return Bestellposnr
	 */
	public static int n�chsteBestellPosNr() {
		
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(bestellposnr) from Bestellposition";
			
			ResultSet rs = stmt.executeQuery(sqlbefehl);
			while (rs.next()) {
				i = rs.getInt(1);
				
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (i+1);
	}

	/**
	 * Holt sich die n�chste Rechnungsnr
	 * @return Rechnungsnr
	 */
	public static int n�chsteRechnungsNr() {
		
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(rechnungsnr) from RechnungBestellung";
			
			ResultSet rs = stmt.executeQuery(sqlbefehl);
			while (rs.next()) {
				i = rs.getInt("max(rechnungsnr)");
				
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (i+1);
	}
		
	/**
	 * Holt sich die n�chste Bestellnummer
	 * @return bestellnr
	 */
	public static int n�chsteBestellNr() {
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(bestellnr) from RechnungBestellung";
			
			ResultSet rs = stmt.executeQuery(sqlbefehl);
			while (rs.next()) {
				i = rs.getInt(1);				
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (i+1);
	}
	
	
	/**
	 * Holt sich die n�chste R�cksendeNr
	 * @return r�cksendenr
	 */
	public static int n�chsteR�ccksendeNr() {
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String s = "select max(r�cksendenr) from R�cksendung";
			
			ResultSet rs = stmt.executeQuery(s);
			
			while(rs.next()) {
				i = rs.getInt(1);
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			System.out.println("HIER");
			e.printStackTrace();
		}
		
		return (i+1);
	}
	
}

	


