package AdministratorVerwaltung;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AdministratorStrg {
	

	public static void entferneAdmin(String adminnr) {
		int pk = Integer.parseInt(adminnr);
	
	try {
		
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		
		Statement stmt = con.createStatement();
		
		String sqlbefehel ="delete from Administrator where nutzernr = '"+pk+"'";
		
		stmt.executeQuery(sqlbefehel);
		
		
	}catch (SQLException e) {
		e.getMessage();
	}
}
	
public static void aktualisiereName(String name, String nutzernr){
		
		try {
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Administrator set nachname ='"+name+"' where nutzernr ="+nutzernr;
		
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
		
		String sqlbefehl = "update Administrator set email ='"+email+"' where nutzernr ="+nutzernr;
		
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
		
		String sqlbefehl = "update Administrator set Stra�e ='"+stra�e+"' where nutzernr ="+nutzernr;
		
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
		
		String sqlbefehl = "update Administrator set ort ='"+ort+"' where nutzernr ="+nutzernr;
		
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
		
		String sqlbefehl = "update Administrator set PLZ ='"+plz+"' where nutzernr ="+nutzernr;
		
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
		
		String sqlbefehl = "update Administrator set IBAN ='"+iban+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
		
		}catch (SQLException e) {
			e.getMessage();
		}
	}

	public static void aktualisiereGehalt(String gehalt, String nutzernr) {
		
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Administrator set Gehalt ='"+gehalt+"' where nutzernr ="+nutzernr;
		
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
		
		String sqlbefehl = "update Administrator set Passwort ='"+passwort+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
		
		}catch (SQLException e) {
			e.getMessage();
		}
	}
	
	public static void hinzuf�genAdmin(String nutzernr, String nachname, String vorname, String email, String stra�e, String ort, String plz, String iban, String gehalt, String berechtigung, String passwort) {
		
		int  nutzernr2 = Integer.parseInt(nutzernr);
		int plz2 = Integer.parseInt(plz);
		int gehalt2 = Integer.parseInt(gehalt);
		int berechtigung2 = Integer.parseInt(berechtigung);
		
		Administrator admin = new Administrator(nutzernr2, nachname, vorname, email, stra�e, ort, plz2, iban, gehalt2, berechtigung2, passwort);
		
		
		try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			
			Statement stmt = con.createStatement();
			
			String sqlbefehl = "insert into Administrator values ('"+nutzernr2+"','"+nachname+"','"+vorname+"','"+email+"','"+stra�e+"','"+ort+"','"+plz2+"','"+iban+"','"+gehalt2+"','"+berechtigung2+"','"+passwort+"')";
			
			stmt.executeQuery(sqlbefehl);
			
			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
			
			
		}catch (SQLException e) {
			e.getMessage();
		}
		
		
		
	}

}
