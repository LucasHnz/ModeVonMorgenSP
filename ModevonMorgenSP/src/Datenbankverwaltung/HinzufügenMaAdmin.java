package Datenbankverwaltung;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Nutzerverwaltung.Administrator;
import Nutzerverwaltung.Mitarbeiter;

public class HinzufügenMaAdmin {
	
	/**
	 * @author Julian
	 * 
	 */
	
	public static void hinzufügenAdmin(String nutzernr, String nachname, String vorname, String email, String straße, String ort, String plz, String iban, String gehalt, String berechtigung, String passwort) {
		
		int  nutzernr2 = Integer.parseInt(nutzernr);
		int plz2 = Integer.parseInt(plz);
		int gehalt2 = Integer.parseInt(gehalt);
		int berechtigung2 = Integer.parseInt(berechtigung);
		
		Administrator admin = new Administrator(nutzernr2, nachname, vorname, email, straße, ort, plz2, iban, gehalt2, berechtigung2, passwort);
		
		
		try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			
			Statement stmt = con.createStatement();
			
			String sqlbefehl = "insert into Mitarbeiter values ('"+nutzernr2+"','"+nachname+"','"+vorname+"','"+email+"','"+straße+"','"+ort+"','"+plz2+"','"+iban+"','"+gehalt2+"','"+berechtigung2+"','"+passwort+"')";
			
			stmt.executeQuery(sqlbefehl);
			
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
			
			
		}catch (SQLException e) {
			e.getMessage();
		}
		
		
		
	}
	
	public static void hinzufügenMA(String nutzernr, String adminnr, String nachname, String vorname, String email, String straße, String ort, String plz, String iban, String gehalt, String berechtigung, String passwort)
	{
		
		int  nutzernr2 = Integer.parseInt(nutzernr);
		int  adminnr2 = Integer.parseInt(adminnr);
		int plz2 = Integer.parseInt(plz);
		int gehalt2 = Integer.parseInt(gehalt);
		int berechtigung2 = Integer.parseInt(berechtigung);
		
		
		Mitarbeiter ma = new Mitarbeiter(nutzernr2, adminnr2, nachname, vorname, email, straße, ort, plz2, iban, gehalt2, berechtigung2, passwort);
		
		
		try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			
			Statement stmt = con.createStatement();
			
			String sqlbefehl = "insert into Mitarbeiter values ('"+nutzernr2+"','"+adminnr2+"','"+nachname+"','"+vorname+"','"+email+"','"+straße+"','"+ort+"','"+plz2+"','"+iban+"','"+gehalt2+"','"+berechtigung2+"','"+passwort+"')";
			
			stmt.executeQuery(sqlbefehl);
			
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
			
			
		}catch (SQLException e) {
			e.getMessage();
		}
		
	}
}

		


