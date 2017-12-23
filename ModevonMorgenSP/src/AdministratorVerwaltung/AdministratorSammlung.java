package AdministratorVerwaltung;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import Artikelverwaltung.Artikel;


public class AdministratorSammlung {
	
	static HashMap<Integer, Administrator> AdministratorListe = new HashMap<Integer, Administrator>();
	
	public static void f¸lleAdministratorListe()  {
		
		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String befehl = "Select * from Administrator";
		
			ResultSet rs = stmt.executeQuery(befehl);
		
		
		
			while (rs.next()) {
				int nutzernr = rs.getInt("Nutzernr");
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
			
				Administrator admin = new Administrator(nutzernr, nachname, vorname, email, straﬂe, ort, plz, iban, gehalt, berechtigung, passwort);
			
				AdministratorListe.put(admin.getNutzernr(), admin);
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static HashMap<Integer,Administrator> getAdminSammlung(){
		return AdministratorListe;
	}
	
	public static Administrator[] getAdminArray(String Filter) {
		Administrator[] AdminList = new Administrator[AdministratorListe.size()];
		AdminList = (Administrator[]) AdministratorListe.values().toArray();
		return AdminList; 
	}
	
	public static Administrator getAdmin(int Adminnr) {
		return AdministratorListe.get(Adminnr);
	}
	
	public static void hinzuf¸genAdmin(int nutzernr, String nachname , String vorname, String email, String straﬂe, String ort, int plz, String iban, int gehalt, int berechtigung, String passwort) {
		
		
		
		Administrator admin = new Administrator(nutzernr,nachname,  vorname,email, straﬂe,  ort,plz,  iban, gehalt, berechtigung, passwort);
		AdministratorListe.put(nutzernr, admin);
		
	}

}
