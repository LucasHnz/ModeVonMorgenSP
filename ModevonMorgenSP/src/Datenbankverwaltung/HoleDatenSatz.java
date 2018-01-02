package Datenbankverwaltung;

import java.sql.Statement;

import AdministratorVerwaltung.Administrator;
import KundenVerwaltung.Bestandskunde;
import MitarbeiterVerwaltung.Mitarbeiter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 
 * @author julian
 *
 */
public class HoleDatenSatz {
	
	/**
	 * Holt Daten f�r die Admnin Auswahl im MA erstellen Prozess
	 * @return ResultSet
	 */
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
	
	/**
	 * Holt sich genau einen Administrator aus der Datenbank
	 * @param nutzernr
	 * @return Administrator
	 */
	public static Administrator holeAdmin(int nutzernr) {
		
		Administrator admin = null;
		
		try {
			Connection con = VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select * from Administrator where nutzernr = '"+nutzernr+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			rs.next();
			
			admin = new Administrator(rs.getInt("Nutzernr"),rs.getString("Nachname"), rs.getString("Vorname"),rs.getString("Email"), rs.getString("Stra�e"), rs.getString("Ort"), rs.getInt("PLZ"),rs.getString("IBAN"),rs.getInt("Gehalt"),rs.getInt("Berechtigung"),rs.getString("Passwort"));
		
			rs.close();
		}
		catch (SQLException e) {
			e.getMessage();
		}
		return admin;
		
		
		
	}
	
	/**
	 * Holt sich genau einen Mitarbetier aus der Datenbank
	 * @param nutzernr
	 * @return Mitarbeiter
	 */
	public static Mitarbeiter holeMitarbeiter(int nutzernr) {
		
		Mitarbeiter ma = null;
		
		try {
			Connection con = VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select * from Mitarbeiter where nutzernr = '"+nutzernr+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			rs.next();
			
			ma = new Mitarbeiter(rs.getInt("Nutzernr"),rs.getInt("Admin"),rs.getString("Nachname"), rs.getString("Vorname"),rs.getString("Email"), rs.getString("Stra�e"), rs.getString("Ort"), rs.getInt("PLZ"),rs.getString("IBAN"),rs.getInt("Gehalt"),rs.getInt("Berechtigung"),rs.getString("Passwort"));
		
			rs.close();
		}
		catch (SQLException e) {
			e.getMessage();
		}
		
		return ma;
		
	}
	
	/**
	 * Holt sich genau einen Bestandskunden aus der Datenbank
	 * @param nutzernr
	 * @return Bestandskunde
	 */
public static Bestandskunde holeKunde(int nutzernr) {
		
		Bestandskunde bk = null;
		
		try {
			Connection con = VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select * from Bestandskunde where nutzernr = '"+nutzernr+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			rs.next();
			
			bk= new Bestandskunde(rs.getInt("nutzernr"), rs.getString("nachname"),rs.getString("vorname") ,rs.getString("email"),rs.getString("stra�e"), rs.getString("ort"),rs.getInt("plz"), rs.getString("iban"),rs.getInt("berechtigung"),rs.getString("passwort"), rs.getInt("pss"));
		
			rs.close();
		}
		catch (SQLException e) {
			e.getMessage();
		}
		
		return bk;
		
	}


	
	
	

}
