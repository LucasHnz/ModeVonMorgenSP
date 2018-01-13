package KundenVerwaltung;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
/**
 * 
 * @author annag
 *
 */

public class GastkundenSammlung {
	
	static HashMap<Integer, Gastkunde> GastkundenListe = new HashMap<Integer, Gastkunde>();
	/**
	 * Füllt die Static HashMap GastkundenListe mit den Werten aus der Datenbank
	 * 
	 */
	public static void fülleGastkundenListe()  {
		
		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String befehl = "Select * from Gastkunde";
		
			ResultSet rs = stmt.executeQuery(befehl);
		
		
		
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
			
				Gastkunde gk = new Gastkunde(nutzernr, nachname, vorname, email, straße, ort, plz, berechtigung, iban);
			
				GastkundenListe.put(gk.getNutzernr(), gk);
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @return GastkundenListe
	 */
	public static HashMap<Integer,Gastkunde> getGastkundenSammlung(){
		return GastkundenListe;
	}
	

	
	/**
	 * Holt genau einen Gastkunden aus der Liste
	 * @param Gastkundennr
	 * @return Gastkunde
	 */
	public static Gastkunde getGastkunde(int nutzernr) {
		return GastkundenListe.get(nutzernr);
	}
	/**
	 * Löscht den Gastkunden aus der Liste
	 * @param nr
	 */
	public static void removeGastkunde(int nr) {
		GastkundenListe.remove(nr);
	}
	
	/**
	 * Fügt der Datenbank einen neuen Gastkunde hinzu
	 * 
	 * @param nutzernr
	 * @param nachname
	 * @param vorname
	 * @param email
	 * @param straße
	 * @param ort
	 * @param plz
	 * @param iban
	 * @param berechtigung
	 */
	public static void hinzufügenGastkunde(int nutzernr, String nachname , String vorname, String email, String straße, String ort, int plz,  int berechtigung, String iban) {
		Gastkunde gk = new Gastkunde(nutzernr,nachname,  vorname,email, straße,  ort,plz,berechtigung,iban);
		GastkundenListe.put(nutzernr, gk);
		}
}
