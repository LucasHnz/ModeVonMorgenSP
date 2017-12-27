package AdministratorVerwaltung;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import MitarbeiterVerwaltung.Mitarbeiter;
import MitarbeiterVerwaltung.MitarbeiterSammlung;

public class AdministratorStrg {
	

	public static void entferneAdmin(int i) {
		
	try {
		
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		
		Statement stmt = con.createStatement();
		
		String sqlbefehel ="delete from Administrator where nutzernr = '"+i+"'";
		
		stmt.executeQuery(sqlbefehel);
		

		
	}catch (SQLException e) {
		e.getMessage();
	}
}
	
public static void aktualisiereName(String name, int nutzernr){
		
	Administrator a = AdministratorSammlung.getAdmin(nutzernr);
		try {
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Administrator set nachname ='"+name+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
		a.setNachname(name);
		}catch(SQLException e) {
			e.getMessage();
		}
		
	}
	
	public static void aktualisiereEmail(String email, int nutzernr) {
		Administrator a = AdministratorSammlung.getAdmin(nutzernr);
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Administrator set email ='"+email+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
		a.setEmail(email);
		}catch (SQLException e) {
			e.getMessage();
		}
	}
	
	public static void aktualisiereStra�e(String stra�e, int nutzernr) {
		Administrator a = AdministratorSammlung.getAdmin(nutzernr);
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Administrator set Stra�e ='"+stra�e+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
		a.setStra�e(stra�e);
		}catch (SQLException e) {
			e.getMessage();
		}
		
	}
	
	public static void aktualisiereOrt(String ort, int nutzernr) {
		Administrator a = AdministratorSammlung.getAdmin(nutzernr);
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Administrator set ort ='"+ort+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
		a.setOrt(ort);
		}catch (SQLException e) {
			e.getMessage();
		}
	}
	
	public static void aktualisierePLZ(String plz, int nutzernr) {
		Administrator a = AdministratorSammlung.getAdmin(nutzernr);
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Administrator set PLZ ='"+plz+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
		a.setPlz(Integer.parseInt(plz));
		}catch (SQLException e) {
			e.getMessage();
		}
		
	}

	public static void aktualisiereIBAN(String iban, int nutzernr) {
		Administrator a = AdministratorSammlung.getAdmin(nutzernr);
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Administrator set IBAN ='"+iban+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
		a.setIban(iban);
		}catch (SQLException e) {
			e.getMessage();
		}
	}

	public static void aktualisiereGehalt(String gehalt, int nutzernr) {
		Administrator a = AdministratorSammlung.getAdmin(nutzernr);
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Administrator set Gehalt ='"+gehalt+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
		a.setGehalt(Integer.parseInt(gehalt));
		}catch (SQLException e) {
			e.getMessage();
		}
	}

	public static void aktualisierePasswort(String passwort, int nutzernr) {
		Administrator a = AdministratorSammlung.getAdmin(nutzernr);
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Administrator set Passwort ='"+passwort+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
		a.setPasswort(passwort);
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
