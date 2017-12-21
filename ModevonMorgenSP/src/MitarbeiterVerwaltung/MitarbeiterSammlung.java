package MitarbeiterVerwaltung;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;


public class MitarbeiterSammlung {
	
 static HashMap<Integer, Mitarbeiter> MitarbeiterSammlung = new HashMap<Integer, Mitarbeiter>();
	
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
			String straﬂe = rs.getString("Straﬂe");
			String ort = rs.getString("Ort");
			int plz = rs.getInt("Plz");
			String iban = rs.getString("IBAN");
			int gehalt = rs.getInt("Gehalt");
			int berechtigung = rs.getInt("Berechtigung");
			String passwort = rs.getString("Passwort");
			
			Mitarbeiter ma = new Mitarbeiter (nutzernr, adminnr, nachname, vorname, email, straﬂe, ort, plz, iban, gehalt, berechtigung, passwort);
			
			MitarbeiterSammlung.put(ma.getNutzernr(), ma);
		
	}
		
	}
	
	public static HashMap<Integer,Mitarbeiter> getMitarbeitersammlung(){
		return MitarbeiterSammlung;
	}
	
	public static void hinzuf¸genMitarbeiter(int nutzernr, int adminnr, String nachname, String vorname, String email, String Straﬂe, String ort, int plz, String iban, int gehalt, int berechtigung, String passwort ) {
		Mitarbeiter ma = new Mitarbeiter(nutzernr, adminnr, nachname, vorname, email, Straﬂe, ort, plz, iban, gehalt, berechtigung, passwort);
		MitarbeiterSammlung.put(nutzernr, ma);
	}
	
}


