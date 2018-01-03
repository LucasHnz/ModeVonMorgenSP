package KundenVerwaltung;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



public class GastkundenStrg {
	public static void hinzuf�genGK(String nutzernr,String nachname, String vorname, String email, String stra�e, String ort, String plz, String berechtigung,String iban)
	{
		
		int  nutzernr2 = Integer.parseInt(nutzernr);
		int plz2 = Integer.parseInt(plz);
		int berechtigung2 = Integer.parseInt(berechtigung);
		
		Gastkunde gk = new Gastkunde(nutzernr2, nachname, vorname, email, stra�e, ort, plz2,berechtigung2,iban);
		
		
		try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			
			Statement stmt = con.createStatement();
			
			String sqlbefehl = "insert into Gastkunde values ('"+nutzernr2+"','"+nachname+"','"+vorname+"','"+email+"','"+stra�e+"','"+ort+"','"+plz2+"','"+berechtigung2+"','"+iban+"')";
			
			stmt.executeQuery(sqlbefehl);
			
			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
			
			
			GastkundenSammlung.GastkundenSammlung.put(nutzernr2, gk);
			
		}catch (SQLException e) {
			e.getMessage();
		}
	}

}

