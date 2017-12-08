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
			
			String vorname = rs.getString("Vorname");
			String nachname = rs.getString("Name");
			String straße = rs.getString("Stra�e");
			int plz = rs.getInt("PLZ");
			String ort = rs.getString("Ort");
			int berechtigung = rs.getInt("Berechtigung");
			String email = rs.getString("email");
			int nutzernr = rs.getInt("NutzerNr");
			int gehalt = rs.getInt("Gehalt");
			String iban = rs.getString("IBAN");
			String passwort = rs.getString("Passwort");
			
			Mitarbeiter ma = new Mitarbeiter (vorname, nachname, straße, plz, ort, berechtigung, email, nutzernr, gehalt, iban, passwort );
			
			MitarbeiterSammlung.put(ma.getNutzernr(), ma);
			
		}
	}
	
	

}