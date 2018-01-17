package MitarbeiterVerwaltung;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 * 
 * @author Julian
 *
 */

public class MitarbeiterSammlung {
	
 static HashMap<Integer, Mitarbeiter> MitarbeiterSammlung = new HashMap<Integer, Mitarbeiter>();
	
 /**
  * f�llt die HashMap mit den Daten aus der DB
  * @throws SQLException
  */
	public static void mitarbeiterSammlung() throws SQLException {
		
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		String befehl = "Select * from Mitarbeiter";
	
		ResultSet rs = stmt.executeQuery(befehl);
		
		while (rs.next()) {
			
			int nutzernr = rs.getInt("Nutzernr");
			int adminnr = rs.getInt("Admin");
			String nachname = rs.getString("Nachname");
			String vorname = rs.getString("Vorname");
			String email = rs.getString("Email");
			String stra�e = rs.getString("Stra�e");
			String ort = rs.getString("Ort");
			int plz = rs.getInt("Plz");
			String iban = rs.getString("IBAN");
			int gehalt = rs.getInt("Gehalt");
			int berechtigung = rs.getInt("Berechtigung");
			String passwort = rs.getString("Passwort");
			
			Mitarbeiter ma = new Mitarbeiter (nutzernr, adminnr, nachname, vorname, email, stra�e, ort, plz, iban, gehalt, berechtigung, passwort);
			
			MitarbeiterSammlung.put(ma.getNutzernr(), ma);
		
	}
		
	}
	
	/**
	 * 
	 * @return MitarbeiterSammlung
	 */
	public static HashMap<Integer,Mitarbeiter> getMitarbeitersammlung(){
		return MitarbeiterSammlung;
	}
	
	/**
	 * f�gt der Sammlung einen neuen Mitarbeiter hinzu
	 * @param nutzernr
	 * @param adminnr
	 * @param nachname
	 * @param vorname
	 * @param email
	 * @param Stra�e
	 * @param ort
	 * @param plz
	 * @param iban
	 * @param gehalt
	 * @param berechtigung
	 * @param passwort
	 */
	public static void hinzuf�genMitarbeiter(int nutzernr, int adminnr, String nachname, String vorname, String email, String Stra�e, String ort, int plz, String iban, int gehalt, int berechtigung, String passwort ) {
		Mitarbeiter ma = new Mitarbeiter(nutzernr, adminnr, nachname, vorname, email, Stra�e, ort, plz, iban, gehalt, berechtigung, passwort);
		MitarbeiterSammlung.put(nutzernr, ma);
	}
	
	/**
	 * holt sich einen Mitarbeiter
	 * @param Nutzernummer
	 * @return
	 */
	public static Mitarbeiter getMitarbeiter(int Nutzernummer) {
		return MitarbeiterSammlung.get(Nutzernummer);
	}
	
	/**
	 * entfernt einen Mitarbeiter aus der Liste
	 * @param Nutzernummer
	 */
	public static void removeMitarbeiter(int Nutzernummer) {
		MitarbeiterSammlung.remove(Nutzernummer);
	}
}


