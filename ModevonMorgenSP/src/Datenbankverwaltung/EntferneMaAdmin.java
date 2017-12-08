package Datenbankverwaltung;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class EntferneMaAdmin {
	
	public static void entferneMitarbeiter(String nutzernr) {
		int pk = Integer.parseInt(nutzernr);
		
		try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			
			Statement stmt = con.createStatement();
			
			String sqlbefehel ="delete from Mitarbeiter where nutzernr = '"+pk+"'";
			
			stmt.executeQuery(sqlbefehel);
			
			
		}catch (SQLException e) {
			e.getMessage();
		}
	}

	public static void entferneAdmin(String adminnr) {
			int pk = Integer.parseInt(adminnr);
		
		try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			
			Statement stmt = con.createStatement();
			
			String sqlbefehel ="delete from Administrator where nutzernr = '"+pk+"'";
			
			stmt.executeQuery(sqlbefehel);
			
			
		}catch (SQLException e) {
			e.getMessage();
		}
	}
}
