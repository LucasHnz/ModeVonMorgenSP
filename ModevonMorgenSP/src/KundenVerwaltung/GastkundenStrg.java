package KundenVerwaltung;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



public class GastkundenStrg {
	public static void hinzufügenGK(String nutzernr,String nachname, String vorname, String email, String straße, String ort, String plz, String berechtigung,String iban)
	{
		
		int  nutzernr2 = Integer.parseInt(nutzernr);
		int plz2 = Integer.parseInt(plz);
		int berechtigung2 = Integer.parseInt(berechtigung);
	
		//Gastkunde gk = new Gastkunde( nutzernr2, nachname,  vorname, email, straße, ort,plz2, iban, berechtigung2);
		
		 
		
		
		
		try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			
			Statement stmt = con.createStatement();
			
			String sqlbefehl = "insert into Gastkunde values ('"+nutzernr2+"','"+nachname+"','"+vorname+"','"+email+"','"+straße+"','"+ort+"','"+plz2+"','"+berechtigung2+"','"+iban+"')";
			
			stmt.executeQuery(sqlbefehl);
			
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
			GastkundenSammlung.hinzufügenGastkunde(nutzernr2, nachname, vorname, email, straße, ort, plz2,berechtigung2, iban);
			
		}catch (SQLException e) { 
			e.printStackTrace();
		}
		
		
		
	}
}


