package Nutzerverwaltung;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class AdministratorenSammlung {
	
	HashMap<Integer, Administrator> AdministratorSammlung = new HashMap<Integer, Administrator>();
	
	public AdministratorenSammlung (ResultSet rs) throws SQLException {
		
		while (rs.next()) {
			int nutzernr = rs.getInt("Nutzernr");
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
			
			Administrator admin = new Administrator(nutzernr, nachname, vorname, email, straße, ort, plz, iban, gehalt, berechtigung, passwort);
			
			AdministratorSammlung.put(admin.getNutzernr(), admin);
		
		}
	}
}
