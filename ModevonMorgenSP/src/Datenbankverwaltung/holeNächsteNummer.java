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
	
	public static int nächsteMaNr(){
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(nutzernr) from Mitarbeiter";
			
			ResultSet rs = stmt.executeQuery(sqlbefehl);
			while (rs.next()) {
				i = rs.getInt("Nutzernr");
				
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (i+1);
	}
	
	public static int nächsteAdminNr() {
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(nutzernr) from Administrator";
			
			ResultSet rs = stmt.executeQuery(sqlbefehl);
			while (rs.next()) {
				i = rs.getInt("Nutzernr");
				
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (i+1);
	}
	
	public static int nächsteBKundenNr() {
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(nutzernr) from Bestandskunde";
			
			ResultSet rs = stmt.executeQuery(sqlbefehl);
			while (rs.next()) {
				i = rs.getInt("Nutzernr");
				
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (i+1);
	}
	
	public static int nächsteGKundenNr() {
		
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(nutzernr) from Gastkunde";
			
			ResultSet rs = stmt.executeQuery(sqlbefehl);
			while (rs.next()) {
				i = rs.getInt("Nutzernr");
				
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (i+1);
}
	
	public static int nächsteSchuhNr() {
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(artikelnr) from Schuhe";
			
			ResultSet rs = stmt.executeQuery(sqlbefehl);
			while (rs.next()) {
				i = rs.getInt("artikelnr");
				
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		 return (i+1);
	}
		
	public static int nächsteKleidungNr() {
	
		int i = 0;
		
		try {
			
			Connection con = VerbindungDB.erstelleConnection();
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(artikelnr) from kleidung";
			
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

	public static int nächsteAccessNr() {
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(artikelnr) from Accessoires";
			
			ResultSet rs = stmt.executeQuery(sqlbefehl);
			while (rs.next()) {
				i = rs.getInt("artikelnr");
				
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (i+1);
	
	}

	public static int nächsteBestellPosNr() {
		
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(bestellposnr) from Bestellposition";
			
			ResultSet rs = stmt.executeQuery(sqlbefehl);
			while (rs.next()) {
				i = rs.getInt("bestellposnr");
				
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (i+1);
	}

	public static int nächsteRechnungsNr() {
		
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(rechnungsnr) from RechnungBestellung";
			
			ResultSet rs = stmt.executeQuery(sqlbefehl);
			while (rs.next()) {
				i = rs.getInt("Rechnungsnr");
				
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (i+1);
	}
		
	public static int nächsteBestellNr() {
		int i = 0;
		
		Connection con = VerbindungDB.erstelleConnection();
		
		try {
			
			Statement stmt = con.createStatement();
			String sqlbefehl = "select max(bestellnr) from RechnungBestellung";
			
			ResultSet rs = stmt.executeQuery(sqlbefehl);
			while (rs.next()) {
				i = rs.getInt("Bestellnr");
				
			}
			
			stmt.close();
			con.close();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (i+1);
	}
	
}

	


