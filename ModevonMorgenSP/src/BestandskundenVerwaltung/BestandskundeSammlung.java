package BestandskundenVerwaltung;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class BestandskundeSammlung {
	
	static HashMap<Integer, Bestandskunde> BestandskundenSammlung = new HashMap<Integer,Bestandskunde>();
	
	public BestandskundeSammlung(ResultSet rs) throws SQLException {
		
		while (rs.next()) {
			int nutzernr = rs.getInt("Nutzernr");
			String nachname = rs.getString("Nachname");
			String vorname = rs.getString("Vorname");
			String email = rs.getString("Email");
			String straße = rs.getString("Straße");
			String ort = rs.getString("Ort");
			int plz = rs.getInt("Plz");
			String iban = rs.getString("IBAN");
			int berechtigung = rs.getInt("Berechtigung");
			String passwort = rs.getString("passwort");
			int pss = rs.getInt("PSS");
			
			Bestandskunde bkunde = new Bestandskunde(nutzernr, nachname, vorname, email, straße, ort, plz, iban, berechtigung, passwort, pss);
			BestandskundenSammlung.put(bkunde.getNutzernr(), bkunde);
			
		}
		
	}

}
