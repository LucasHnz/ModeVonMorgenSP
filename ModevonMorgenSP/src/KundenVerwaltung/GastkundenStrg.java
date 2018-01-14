package KundenVerwaltung;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Frontend.GUI;
import Frontend.GUIHomepage;
import Logverwaltung.LogStrg;

/**
 * 
 * @author annag
 *
 */


public class GastkundenStrg {
	/**
	 ** Fügt der Liste sowie der Datenbank einen neuen Gastkunden hinzu
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
	public static void hinzufügenGK(int nutzernr,String nachname, String vorname, String email, String straße, String ort, int plz, int berechtigung,String iban)
	{
		
		
	
		//Gastkunde gk = new Gastkunde( nutzernr2, nachname,  vorname, email, straße, ort,plz2, iban, berechtigung2);
	
		try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			
			Statement stmt = con.createStatement();
			
			String sqlbefehl = "insert into Gastkunde values ('"+nutzernr+"','"+nachname+"','"+vorname+"','"+email+"','"+straße+"','"+ort+"','"+plz+"','"+berechtigung+"','"+iban+"')";
			
			stmt.executeQuery(sqlbefehl);
			
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
			GastkundenSammlung.hinzufügenGastkunde(nutzernr, nachname, vorname, email, straße, ort, plz,berechtigung, iban);
			
		}catch (SQLException e) { 
			e.printStackTrace();
		}
		
	}
	
	
}


