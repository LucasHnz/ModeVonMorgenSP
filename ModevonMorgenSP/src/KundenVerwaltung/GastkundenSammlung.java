package KundenVerwaltung;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;


public class GastkundenSammlung {
	
 static HashMap<Integer, Gastkunde> GastkundenSammlung = new HashMap<Integer, Gastkunde>();
	
	public static void gastkundenSammlung() throws SQLException {
		
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		String befehl = "Select * from Gastkunde";
	
		ResultSet rs = stmt.executeQuery(befehl);
		
		while (rs.next()) {
			
			int nutzernr = rs.getInt("Nutzernr");
			String nachname = rs.getString("Nachname");
			String vorname = rs.getString("Vorname");
			String email = rs.getString("Email");
			String stra�e = rs.getString("Stra�e");
			String ort = rs.getString("Ort");
			int plz = rs.getInt("Plz");
			int berechtigung = rs.getInt("Berechtigung");
			String iban =rs.getString("iban");
			
			
			Gastkunde gk = new Gastkunde (nutzernr, nachname, vorname, email, stra�e, ort, plz,berechtigung,iban);
			
			GastkundenSammlung.put(gk.getNutzernr(), gk);
		
	}
		
	}
	
	public static HashMap<Integer,Gastkunde> getGastkundenSammlung(){
		return GastkundenSammlung;
	}
	
	public static void hinzuf�genGastkunde(int nutzernr, String nachname, String vorname, String email, String Stra�e, String ort, int plz, int berechtigung,String iban) {
		Gastkunde gk = new Gastkunde(nutzernr, nachname, vorname, email, Stra�e, ort, plz, berechtigung,iban);
		GastkundenSammlung.put(nutzernr, gk);
	}
	public static Gastkunde getGastkunde(int Nutzernummer) {
		return GastkundenSammlung.get(Nutzernummer);
	}
	public static void removeGastkunde(int Nutzernummer) {    //muss aber nach der Bestellung wieder gel�scht werden bzw nach einer zeit oder gar nicht?
		GastkundenSammlung.remove(Nutzernummer);
	} 
}


