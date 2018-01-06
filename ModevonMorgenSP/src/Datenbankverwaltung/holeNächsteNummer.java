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
public class holeNächsteNummer {
	
	/**
	 * Holt sich die nächste Nummer
	 * @return Nutzernr
	 */
	public static int nächsteMaNr(){
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
	 * Holt sich die nächste AdminNr
	 * @return Admin Nutzer Nummer
	 */
	public static int nächsteAdminNr() {
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
	 * holt sich die nächste Bestandskunden Nummer
	 * @return Bestandskunden nummer
	 */
	public static int nächsteBKundenNr() {
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
	 * Holt sich die nächste GKunden Nummer
	 * @return Gastkunden Nummer
	 */
	public static int nächsteGKundenNr() {
		
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(nutzernr) from Gastkunde";
			
			ResultSet rs = stmt.executeQuery(sqlbefehl);
			while (rs.next()) {
				i = rs.getInt("nutzernr");
				
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (i+1);
}
	
	/**
	 * Holt sich die nächste Schuh Nummer
	 * @return Artikelnummer
	 */
	public static int nächsteSchuhNr() {
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
	 * Holt sich die Nächste kleidungs Nummer
	 * @return Artikelnummer
	 */
	public static int nächsteKleidungNr() {
	
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
	 * Holt sich die nächste Access. Nummer
	 * @return Artikelnummer
	 */
	public static int nächsteAccessNr() {
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
	 * Holt sich die nächste Bestellpos nummer
	 * @return Bestellposnr
	 */
	public static int nächsteBestellPosNr() {
		
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
	 * Holt sich die nächste Rechnungsnr
	 * @return Rechnungsnr
	 */
	public static int nächsteRechnungsNr() {
		
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
	 * Holt sich die nächste Bestellnummer
	 * @return bestellnr
	 */
	public static int nächsteBestellNr() {
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
	 * Holt sich die nächste RücksendeNr
	 * @return rücksendenr
	 */
	public static int nächsteRüccksendeNr() {
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String s = "select max(rücksendenr) from Rücksendung";
			
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

	


