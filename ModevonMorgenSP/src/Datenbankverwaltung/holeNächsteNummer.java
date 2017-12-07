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
	
	public static int n�chsteMaNr(){
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(nutzernr) from Mitarbeiter";
			
			ResultSet rs = stmt.executeQuery(sqlbefehl);
			while (rs.next()) {
				i = rs.getInt("Nutzernr");
				i = i++;
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
	}
	
	public static int n�chsteAdminNr() {
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(nutzernr) from Administrator";
			
			ResultSet rs = stmt.executeQuery(sqlbefehl);
			while (rs.next()) {
				i = rs.getInt("Nutzernr");
				i = i++;
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
	}
	
	public static int n�chsteBKundenNr() {
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(nutzernr) from Bestandskunde";
			
			ResultSet rs = stmt.executeQuery(sqlbefehl);
			while (rs.next()) {
				i = rs.getInt("Nutzernr");
				i = i++;
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
	}
	
	public static int n�chsteGKundenNr() {
		
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(nutzernr) from Gastkunde";
			
			ResultSet rs = stmt.executeQuery(sqlbefehl);
			while (rs.next()) {
				i = rs.getInt("Nutzernr");
				i = i++;
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
}
	
	public static int n�chsteSchuhNr() {
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(artikelnr) from Schuhe";
			
			ResultSet rs = stmt.executeQuery(sqlbefehl);
			while (rs.next()) {
				i = rs.getInt("artikelnr");
				i = i++;
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
	}
		
	public static int n�chsteKleidungNr() {
	
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(artikelnr) from Kleidung";
			
			ResultSet rs = stmt.executeQuery(sqlbefehl);
			while (rs.next()) {
				i = rs.getInt("artikelnr");
				i = i++;
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
	}

	public static int n�chsteAccessNr() {
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(artikelnr) from Accessoires";
			
			ResultSet rs = stmt.executeQuery(sqlbefehl);
			while (rs.next()) {
				i = rs.getInt("artikelnr");
				i = i++;
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
	
	}

	public static int n�chsteBestellPosNr() {
		
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(bestellposnr) from Bestellposition";
			
			ResultSet rs = stmt.executeQuery(sqlbefehl);
			while (rs.next()) {
				i = rs.getInt("bestellposnr");
				i = i++;
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
	}

	public static int n�chsteRechnungsNr() {
		
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(rechnungsnr) from RechnungBestellung";
			
			ResultSet rs = stmt.executeQuery(sqlbefehl);
			while (rs.next()) {
				i = rs.getInt("Rechnungsnr");
				i = i++;
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
	}
		
	public static int n�chsteBestellNr() {
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(bestellnr) from RechnungBestellung";
			
			ResultSet rs = stmt.executeQuery(sqlbefehl);
			while (rs.next()) {
				i = rs.getInt("Bestellnr");
				i = i++;
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
	}
	
}

	


