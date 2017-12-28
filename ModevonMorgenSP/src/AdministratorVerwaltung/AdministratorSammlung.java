package AdministratorVerwaltung;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import Artikelverwaltung.Artikel;


public class AdministratorSammlung {
	
	static HashMap<Integer, Administrator> AdministratorListe = new HashMap<Integer, Administrator>();
	/**
	 * F�llt die Static HashMap AdministratorListe mit den Values aus der Datenbank
	 * 
	 */
	public static void f�lleAdministratorListe()  {
		
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
				String stra�e = rs.getString("Stra�e");
				String ort = rs.getString("Ort");
				int plz = rs.getInt("Plz");
				String iban = rs.getString("IBAN");
				int gehalt = rs.getInt("Gehalt");
				int berechtigung = rs.getInt("Berechtigung");
				String passwort = rs.getString("Passwort");
			
				Administrator admin = new Administrator(nutzernr, nachname, vorname, email, stra�e, ort, plz, iban, gehalt, berechtigung, passwort);
			
				AdministratorListe.put(admin.getNutzernr(), admin);
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @return AdministratorLsite
	 */
	public static HashMap<Integer,Administrator> getAdminSammlung(){
		return AdministratorListe;
	}
	
	/**
	 * 
	 * @param Filter
	 * @return Administrator Liste
	 */
	public static Administrator[] getAdminArray(String Filter) {
		Administrator[] AdminList = new Administrator[AdministratorListe.size()];
		AdminList = (Administrator[]) AdministratorListe.values().toArray();
		return AdminList; 
	}
	
	/**
	 * Holt genau einen Administrator aus der Liste
	 * @param Adminnr
	 * @return Administrator
	 */
	public static Administrator getAdmin(int Adminnr) {
		return AdministratorListe.get(Adminnr);
	}
	
	/**
	 * F�gt der Datenbank einen neuen Administrator hinzu
	 * 
	 * @param nutzernr
	 * @param nachname
	 * @param vorname
	 * @param email
	 * @param stra�e
	 * @param ort
	 * @param plz
	 * @param iban
	 * @param gehalt
	 * @param berechtigung
	 * @param passwort
	 */
	public static void hinzuf�genAdmin(int nutzernr, String nachname , String vorname, String email, String stra�e, String ort, int plz, String iban, int gehalt, int berechtigung, String passwort) {
		
		
		
		Administrator admin = new Administrator(nutzernr,nachname,  vorname,email, stra�e,  ort,plz,  iban, gehalt, berechtigung, passwort);
		AdministratorListe.put(nutzernr, admin);
		
		
	
	}
}
