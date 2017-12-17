package AdministratorVerwaltung;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import Artikelverwaltung.Artikel;


public class AdministratorSammlung {
	
	static HashMap<Integer, Administrator> AdministratorSammlung = new HashMap<Integer, Administrator>();
	
	public static void f¸lleAdministratorListe() throws SQLException {
		
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
			
			AdministratorSammlung.put(admin.getNutzernr(), admin);
		
		}
	}
	
	public static HashMap<Integer,Administrator> getAdminSammlung(){
		return AdministratorSammlung;
	}
	
	public static Administrator[] getAdminArray(String Filter) {
		Administrator[] AdminList = new Administrator[AdministratorSammlung.size()];
		AdminList = (Administrator[]) AdministratorSammlung.values().toArray();
		return AdminList; 
	}
	
	public static Administrator getAdmin(int Adminnr) {
		return AdministratorSammlung.get(Adminnr);
	}

}
