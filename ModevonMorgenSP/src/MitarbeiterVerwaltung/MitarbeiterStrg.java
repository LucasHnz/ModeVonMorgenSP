package MitarbeiterVerwaltung;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import AdministratorVerwaltung.Administrator;

public class MitarbeiterStrg {
	
	public static void entferneMitarbeiter(int nutzernr) {
		
		
		try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			
			Statement stmt = con.createStatement();
			
			String sqlbefehel ="delete from Mitarbeiter where nutzernr = '"+nutzernr+"'";
			
			stmt.executeQuery(sqlbefehel);
			MitarbeiterSammlung.removeMitarbeiter(nutzernr);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
public static void aktualisiereName(String name, int nutzernr){
	Mitarbeiter ma = MitarbeiterSammlung.getMitarbeiter(nutzernr);
	
		try {
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Mitarbeiter set nachname ='"+name+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
		
		ma.setNachname(name);
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void aktualisiereAdminnr(String adminnr, int nutzernr) {
		Mitarbeiter ma = MitarbeiterSammlung.getMitarbeiter(nutzernr);
		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			
			String sqlbefehl = "update Mitarbeiter set adminnr ='"+adminnr+"' where nutzernr ="+nutzernr;
			
			stmt.execute(sqlbefehl)	;
			
			Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
			
			ma.setAdminnr(Integer.parseInt(adminnr));
			}catch(SQLException e) {
				e.getMessage();
			}
	}
	
	public static void aktualisiereEmail(String email, int nutzernr) {
		Mitarbeiter ma = MitarbeiterSammlung.getMitarbeiter(nutzernr);
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Mitarbeiter set email ='"+email+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
		ma.setEmail(email);
		}catch (SQLException e) {
			e.getMessage();
		}
	}
	
	public static void aktualisiereStraﬂe(String straﬂe, int nutzernr) {
		Mitarbeiter ma = MitarbeiterSammlung.getMitarbeiter(nutzernr);
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Mitarbeiter set Straﬂe ='"+straﬂe+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
		ma.setStraﬂe(straﬂe);
		}catch (SQLException e) {
			e.getMessage();
		}
		
	}
	
	public static void aktualisiereOrt(String ort, int nutzernr) {
		Mitarbeiter ma = MitarbeiterSammlung.getMitarbeiter(nutzernr);
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Mitarbeiter set ort ='"+ort+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
		ma.setOrt(ort);
		}catch (SQLException e) {
			e.getMessage();
		}
	}
	
	public static void aktualisierePLZ(String plz, int nutzernr) {
		Mitarbeiter ma = MitarbeiterSammlung.getMitarbeiter(nutzernr);
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Mitarbeiter set PLZ ='"+plz+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
		ma.setPlz(Integer.parseInt(plz));
		}catch (SQLException e) {
			e.getMessage();
		}
		
	}

	public static void aktualisiereIBAN(String iban, int nutzernr) {
		Mitarbeiter ma = MitarbeiterSammlung.getMitarbeiter(nutzernr);
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Mitarbeiter set IBAN ='"+iban+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
		ma.setIban(iban);
		}catch (SQLException e) {
			e.getMessage();
		}
	}

	public static void aktualisiereGehalt(String gehalt, int nutzernr) {
		Mitarbeiter ma = MitarbeiterSammlung.getMitarbeiter(nutzernr);
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Mitarbeiter set Gehalt ='"+gehalt+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
		ma.setGehalt(Integer.parseInt(gehalt));
		}catch (SQLException e) {
			e.getMessage();
		}
	}

	public static void aktualisierePasswort(String passwort, int nutzernr) {
		Mitarbeiter ma = MitarbeiterSammlung.getMitarbeiter(nutzernr);
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Mitarbeiter set Passwort ='"+passwort+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
		ma.setPasswort(passwort);
		}catch (SQLException e) {
			e.getMessage();
		}
	}
	
public static void aktualisiereVorname(String vorname, int nutzernr) {
	Mitarbeiter ma = MitarbeiterSammlung.getMitarbeiter(nutzernr);
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Mitarbeiter set Vorname ='"+vorname+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
		ma.setVorname(vorname);
		}catch (SQLException e) {
			e.getMessage();
		}
	}
	
	public static void hinzuf¸genMA(String nutzernr, String adminnr, String nachname, String vorname, String email, String straﬂe, String ort, String plz, String iban, String gehalt, String berechtigung, String passwort)
	{
		
		int  nutzernr2 = Integer.parseInt(nutzernr);
		int adminnr2 = Integer.parseInt(adminnr);
		int plz2 = Integer.parseInt(plz);
		int gehalt2 = Integer.parseInt(gehalt);
		int berechtigung2 = Integer.parseInt(berechtigung);
		
		Mitarbeiter ma = new Mitarbeiter(nutzernr2,adminnr2, nachname, vorname, email, straﬂe, ort, plz2, iban, gehalt2, berechtigung2, passwort);
		
		
		try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			
			Statement stmt = con.createStatement();
			
			String sqlbefehl = "insert into Mitarbeiter values ('"+nutzernr2+"','"+adminnr2+"','"+nachname+"','"+vorname+"','"+email+"','"+straﬂe+"','"+ort+"','"+plz2+"','"+iban+"','"+gehalt2+"','"+berechtigung2+"','"+passwort+"')";
			
			stmt.executeQuery(sqlbefehl);
			
			Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
			
			
			MitarbeiterSammlung.MitarbeiterSammlung.put(nutzernr2, ma);
			
		}catch (SQLException e) {
			e.getMessage();
		}
	}

}
