package Datenbankverwaltung;

import java.sql.Statement;

import AdministratorVerwaltung.Administrator;
import MitarbeiterVerwaltung.Mitarbeiter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HoleDatenSatz {
	
	
	public static ResultSet AdminNummern() {
		
		ResultSet rs = null;
		
		try {
			
			Connection con = VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			
			String sql = "select nutzernr from Administrator";
			
			rs = stmt.executeQuery(sql);
			
		}catch (SQLException e) {
			e.getMessage();
		}
		
		return rs;
		
	}
	
	public static Administrator holeAdmin(int nutzernr) {
		
		Administrator admin = null;
		
		try {
			Connection con = VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select * from Administrator where nutzernr = '"+nutzernr+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			rs.next();
			
			admin = new Administrator(rs.getInt("Nutzernr"),rs.getString("Nachname"), rs.getString("Vorname"),rs.getString("Email"), rs.getString("Straﬂe"), rs.getString("Ort"), rs.getInt("PLZ"),rs.getString("IBAN"),rs.getInt("Gehalt"),rs.getInt("Berechtigung"),rs.getString("Passwort"));
		
			rs.close();
		}
		catch (SQLException e) {
			e.getMessage();
		}
		return admin;
		
		
		
	}
	
	public static Mitarbeiter holeMitarbeiter(int nutzernr) {
		
		Mitarbeiter ma = null;
		
		try {
			Connection con = VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select * from Mitarbeiter where nutzernr = '"+nutzernr+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			rs.next();
			
			ma = new Mitarbeiter(rs.getInt("Nutzernr"),rs.getInt("Admin"),rs.getString("Nachname"), rs.getString("Vorname"),rs.getString("Email"), rs.getString("Straﬂe"), rs.getString("Ort"), rs.getInt("PLZ"),rs.getString("IBAN"),rs.getInt("Gehalt"),rs.getInt("Berechtigung"),rs.getString("Passwort"));
		
			rs.close();
		}
		catch (SQLException e) {
			e.getMessage();
		}
		
		return ma;
		
	}

}
