package AdministratorVerwaltung;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import AdministratorVerwaltung.AdministratorSammlung;

/**
 * 
 * @author julian
 *
 */
public class AdministratorStrg {
	

	/**
	 * entfernt einen Admin aus der Datenbank
	 * @param i
	 * @throws SQLException 
	 */
	public static int entferneAdmin(int i){
		
	try {
		
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		
		Statement stmt = con.createStatement();
		
		String sqlbefehel ="delete from Administrator where nutzernr = '"+i+"'";
		
		stmt.executeQuery(sqlbefehel);
		
		AdministratorSammlung.removeAdmin(i);
		
		return 0;

		
	}catch (SQLException e) {
		e.printStackTrace();
		return 1;
	}
}
	
	/**
	 * Aktualisiert den Namen in der Liste und in der Datenbank
	 * @param name
	 * @param nutzernr
	 */
public static void aktualisiereName(String name, int nutzernr){
		
	Administrator a = AdministratorSammlung.getAdmin(nutzernr);
		try {
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Administrator set nachname ='"+name+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
		a.setNachname(name);
		}catch(SQLException e) {
			e.getMessage();
		}
		
	}

/**
 * Aktualisiert den Vornamen in der Liste und in der Datenbank
 * @param name
 * @param nutzernr
 */
public static void aktualisiereVorName(String name, int nutzernr){
	
	Administrator a = AdministratorSammlung.getAdmin(nutzernr);
		try {
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Administrator set vorname ='"+name+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
		a.setVorname(name);
		}catch(SQLException e) {
			e.getMessage();
		}
		
	}
		
	/**
	 * Aktualisiert die Email in der Lsite und in der Datenbank
	 * @param email
	 * @param nutzernr
	 */
	public static void aktualisiereEmail(String email, int nutzernr) {
		Administrator a = AdministratorSammlung.getAdmin(nutzernr);
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Administrator set email ='"+email+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
		a.setEmail(email);
		}catch (SQLException e) {
			e.getMessage();
		}
	}
	
	/**
	 * Aktualisiert die Straße in der Liste und in der Datenbank
	 * @param straße
	 * @param nutzernr
	 */
	public static void aktualisiereStraße(String straße, int nutzernr) {
		Administrator a = AdministratorSammlung.getAdmin(nutzernr);
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Administrator set Straße ='"+straße+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
		a.setStraße(straße);
		}catch (SQLException e) {
			e.getMessage();
		}
		
	}
	
	/**
	 * Aktualisiert den Ort in der Liste und in der Datenbank
	 * @param ort
	 * @param nutzernr
	 */
	public static void aktualisiereOrt(String ort, int nutzernr) {
		Administrator a = AdministratorSammlung.getAdmin(nutzernr);
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Administrator set ort ='"+ort+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
		a.setOrt(ort);
		}catch (SQLException e) {
			e.getMessage();
		}
	}
	
	/**
	 * Aktualisiert die PLZ in der Liste und in der Datenbank
	 * @param plz
	 * @param nutzernr
	 */
	public static void aktualisierePLZ(String plz, int nutzernr) {
		Administrator a = AdministratorSammlung.getAdmin(nutzernr);
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Administrator set PLZ ='"+plz+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
		a.setPlz(Integer.parseInt(plz));
		}catch (SQLException e) {
			e.getMessage();
		}
		
	}

	/**
	 * Aktualisiert die IBAN in der Liste und in der Datenbank
	 * @param iban
	 * @param nutzernr
	 */
	public static void aktualisiereIBAN(String iban, int nutzernr) {
		Administrator a = AdministratorSammlung.getAdmin(nutzernr);
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Administrator set IBAN ='"+iban+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
		a.setIban(iban);
		}catch (SQLException e) {
			e.getMessage();
		}
	}

	/**
	 * Aktualisiert das Gehalt in der Liste und in der Datenbnak
	 * @param gehalt
	 * @param nutzernr
	 */
	public static void aktualisiereGehalt(String gehalt, int nutzernr) {
		Administrator a = AdministratorSammlung.getAdmin(nutzernr);
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Administrator set Gehalt ='"+gehalt+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
		a.setGehalt(Integer.parseInt(gehalt));
		}catch (SQLException e) {
			e.getMessage();
		}
	}

	/**
	 * Aktualisiert das Passwort in der Liste und in der Datenbank
	 * @param passwort
	 * @param nutzernr
	 */
	public static void aktualisierePasswort(String passwort, int nutzernr) {
		Administrator a = AdministratorSammlung.getAdmin(nutzernr);
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Administrator set Passwort ='"+passwort+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
		a.setPasswort(passwort);
		}catch (SQLException e) {
			e.getMessage();
		}
	}
	
	/**
	 * Fügt der Liste sowie der Datenbank einen neuen Admin hinzu
	 * @param nutzernr
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
	public static void hinzufügenAdmin(String nutzernr, String nachname, String vorname, String email, String straße, String ort, String plz, String iban, String gehalt, String berechtigung, String passwort) {
		
		int  nutzernr2 = Integer.parseInt(nutzernr);
		int plz2 = Integer.parseInt(plz);
		int gehalt2 = Integer.parseInt(gehalt);
		int berechtigung2 = Integer.parseInt(berechtigung);
		
		//Administrator admin = new Administrator(nutzernr2, nachname, vorname, email, straße, ort, plz2, iban, gehalt2, berechtigung2, passwort);
		
		
		try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			
			Statement stmt = con.createStatement();
			
			String sqlbefehl = "insert into Administrator values ('"+nutzernr2+"','"+nachname+"','"+vorname+"','"+email+"','"+straße+"','"+ort+"','"+plz2+"','"+iban+"','"+gehalt2+"','"+berechtigung2+"','"+passwort+"')";
			
			stmt.executeQuery(sqlbefehl);
			
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
			AdministratorSammlung.hinzufügenAdmin(nutzernr2, nachname, vorname, email, straße, ort, plz2, iban, gehalt2, berechtigung2, passwort);
			
		}catch (SQLException e) { 
			e.printStackTrace();
		}
		
		
		
	}

}
