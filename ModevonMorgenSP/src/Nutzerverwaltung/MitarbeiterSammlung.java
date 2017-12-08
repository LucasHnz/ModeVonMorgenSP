package Nutzerverwaltung;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * 
 * 
 * @author julian
 *
 */
public class MitarbeiterSammlung {
	
	HashMap<Integer, Mitarbeiter> MitarbeiterSammlung = new HashMap<Integer, Mitarbeiter>();
	
	public MitarbeiterSammlung(ResultSet rs) throws SQLException {
		
		while (rs.next()) {
			
			int nutzernr = rs.getInt("Nutzernr");
			int adminnr = rs.getInt("Adminnr");
			String nachname = rs.getString("Nachname");
			String vorname = rs.getString("Vorname");
			String email = rs.getString("Email");
			String straße = rs.getString("Straße");
			String ort = rs.getString("Ort");
			int plz = rs.getInt("Plz");
			String iban = rs.getString("IBAN");
			int gehalt = rs.getInt("Gehalt");
			int berechtigung = rs.getInt("Berechtigung");
			String passwort = rs.getString("Passwort");
			
			Mitarbeiter ma = new Mitarbeiter (nutzernr, adminnr, nachname, vorname, email, straße, ort, plz, iban, gehalt, berechtigung, passwort);
			
			MitarbeiterSammlung.put(ma.getNutzernr(), ma);
		
	}
	
	

}
}