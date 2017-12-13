package Nutzerverwaltung;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Nutzerverwaltung.Bestandskunde;
/**
 * 
 * @author annag
 *
 */
public class BestandskundnStrg {
	
	public static void neuerKunde(int nutzernr, String nachname, String vorname, String email, String straße, String ort, int plz, String iban, int berechtigung, String passwort, int pss){
		
		Bestandskunde bk = new Bestandskunde( nutzernr, nachname,  vorname, email, straße, ort,plz, iban, berechtigung, passwort,pss);
		
		
		try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			
			Statement stmt = con.createStatement();
			
			String sqlbefehl = "insert into Bestandskunde values ('"+nutzernr+"','"+nachname+"','"+vorname+"','"+email+"','"+straße+"','"+ort+"','"+plz+"','"+iban+"','"+berechtigung+"','"+passwort+"','"+pss+"')";
			
			stmt.executeQuery(sqlbefehl);
			
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
			
			
		}catch (SQLException e) {
			e.getMessage();
		}
		
	}

	public static void löschenAccount(int nutzerNr) {
		try {
			
			int kdnr = nutzerNr;
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			
			Statement stmt = con.createStatement();
			
			String sqlbefehel ="delete from Bestandskunde where nutzerNr = '"+kdnr+"'";
			
			stmt.executeQuery(sqlbefehel);
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
			
			
		}catch (SQLException e) {
			e.getMessage();
		}
	}
	public static void editierenAccountDaten() {
		// sind in der bearbeiteBestandsKunde  Klasse in Datenbankverwltung 
	}
	public static void anzeigenPunktestand(int nutzerNr){
		int kdnr = nutzerNr;
		try {

			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			
			Statement stmt = con.createStatement();
			
			String sqlbefehel ="select PSS from Bestandskunde where nutzerNr = '"+kdnr+"'";
			
			stmt.executeQuery(sqlbefehel);
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
			
		}catch (SQLException e) {
			e.getMessage();
		}
	}
	}

