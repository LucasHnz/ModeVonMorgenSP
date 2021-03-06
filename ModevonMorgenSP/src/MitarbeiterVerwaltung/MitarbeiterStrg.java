package MitarbeiterVerwaltung;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Julian
 *
 */
public class MitarbeiterStrg {
	/**
	 * Methoden dieser Klasse werden hauptsächlich für die MitarbeiterBearbeiten GUI benutzt
	 * Primär werden hier alle Daten verändert
	 */
	
	/**
	 * entfernt einen Mitarbeiter aus der Liste und DB
	 * @param nutzernr
	 */
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
	/**
	 * 
	 * @param name
	 * @param nutzernr
	 */
public static void aktualisiereName(String name, int nutzernr){
	Mitarbeiter ma = MitarbeiterSammlung.getMitarbeiter(nutzernr);
	
		try {
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Mitarbeiter set nachname ='"+name+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
		
		ma.setNachname(name);
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

/**
 * 
 * @param adminnr
 * @param nutzernr
 */
	public static void aktualisiereAdminnr(String adminnr, int nutzernr) {
		Mitarbeiter ma = MitarbeiterSammlung.getMitarbeiter(nutzernr);
		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			
			String sqlbefehl = "update Mitarbeiter set adminnr ='"+adminnr+"' where nutzernr ="+nutzernr;
			
			stmt.execute(sqlbefehl)	;
			
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
			
			ma.setAdminnr(Integer.parseInt(adminnr));
			}catch(SQLException e) {
				e.getMessage();
			}
	}
	
	/**
	 * 
	 * @param email
	 * @param nutzernr
	 */
	public static void aktualisiereEmail(String email, int nutzernr) {
		Mitarbeiter ma = MitarbeiterSammlung.getMitarbeiter(nutzernr);
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Mitarbeiter set email ='"+email+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
		ma.setEmail(email);
		}catch (SQLException e) {
			e.getMessage();
		}
	}
	
	public static void aktualisiereStraße(String straße, int nutzernr) {
		Mitarbeiter ma = MitarbeiterSammlung.getMitarbeiter(nutzernr);
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Mitarbeiter set Straße ='"+straße+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
		ma.setStraße(straße);
		}catch (SQLException e) {
			e.getMessage();
		}
		
	}
	
	/**
	 * 
	 * @param ort
	 * @param nutzernr
	 */
	public static void aktualisiereOrt(String ort, int nutzernr) {
		Mitarbeiter ma = MitarbeiterSammlung.getMitarbeiter(nutzernr);
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Mitarbeiter set ort ='"+ort+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
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
		
		Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
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
		
		Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
		ma.setIban(iban);
		}catch (SQLException e) {
			e.getMessage();
		}
	}

	/**
	 * 
	 * @param gehalt
	 * @param nutzernr
	 */
	public static void aktualisiereGehalt(String gehalt, int nutzernr) {
		Mitarbeiter ma = MitarbeiterSammlung.getMitarbeiter(nutzernr);
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Mitarbeiter set Gehalt ='"+gehalt+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
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
		
		Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
		ma.setPasswort(passwort);
		}catch (SQLException e) {
			e.getMessage();
		}
	}
	
	/**
	 * 
	 * @param vorname
	 * @param nutzernr
	 */
public static void aktualisiereVorname(String vorname, int nutzernr) {
	Mitarbeiter ma = MitarbeiterSammlung.getMitarbeiter(nutzernr);
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Mitarbeiter set Vorname ='"+vorname+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
		ma.setVorname(vorname);
		}catch (SQLException e) {
			e.getMessage();
		}
	}
	
/**
 * 
 * @param nutzernr
 * @param adminnr
 * @param nachname
 * @param vorname
 * @param email
 * @param straße
 * @param ort
 * @param plz
 * @param iban
 * @param gehalt
 * @param berechtigung
 * @param passwort
 */
	public static void hinzufügenMA(String nutzernr, String adminnr, String nachname, String vorname, String email, String straße, String ort, String plz, String iban, String gehalt, String berechtigung, String passwort)
	{
		
		int  nutzernr2 = Integer.parseInt(nutzernr);
		int adminnr2 = Integer.parseInt(adminnr);
		int plz2 = Integer.parseInt(plz);
		int gehalt2 = Integer.parseInt(gehalt);
		int berechtigung2 = Integer.parseInt(berechtigung);
		
		Mitarbeiter ma = new Mitarbeiter(nutzernr2,adminnr2, nachname, vorname, email, straße, ort, plz2, iban, gehalt2, berechtigung2, passwort);
		
		
		try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			
			Statement stmt = con.createStatement();
			
			String sqlbefehl = "insert into Mitarbeiter values ('"+nutzernr2+"','"+adminnr2+"','"+nachname+"','"+vorname+"','"+email+"','"+straße+"','"+ort+"','"+plz2+"','"+iban+"','"+gehalt2+"','"+berechtigung2+"','"+passwort+"')";
			
			stmt.executeQuery(sqlbefehl);
			
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
			
			
			MitarbeiterSammlung.MitarbeiterSammlung.put(nutzernr2, ma);
			
		}catch (SQLException e) {
			e.getMessage();
		}
	}

}
