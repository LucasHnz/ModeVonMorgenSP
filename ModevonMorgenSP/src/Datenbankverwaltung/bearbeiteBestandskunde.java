package Datenbankverwaltung;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class bearbeiteBestandskunde {
	
	public static void aktualisiereName(String name, String nutzernr){
		
		try {
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Bestandskunde set nachname ='"+name+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
		}catch(SQLException e) {
			e.getMessage();
		}
		
	}
	
	public static void aktualisiereEmail(String email, String nutzernr) {
		
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Bestandskunde set email ='"+email+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
		
		}catch (SQLException e) {
			e.getMessage();
		}
	}
	
	public static void aktualisiereStra�e(String stra�e, String nutzernr) {
		
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Bestandskunde set Stra�e ='"+stra�e+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
		
		}catch (SQLException e) {
			e.getMessage();
		}
		
	}
	
	public static void aktualisiereOrt(String ort, String nutzernr) {
		
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Bestandskunde set ort ='"+ort+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
		
		}catch (SQLException e) {
			e.getMessage();
		}
	}
	
	public static void aktualisierePLZ(String plz, String nutzernr) {
		
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Bestandskunde set PLZ ='"+plz+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
		
		}catch (SQLException e) {
			e.getMessage();
		}
		
	}

	public static void aktualisiereIBAN(String iban, String nutzernr) {
		
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Bestandskunde set IBAN ='"+iban+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
		
		}catch (SQLException e) {
			e.getMessage();
		}
	}

	public static void aktualisierePasswort(String passwort, String nutzernr) {
		
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Bestandskunde set Passwort ='"+passwort+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
		
		}catch (SQLException e) {
			e.getMessage();
		}
	}
}



