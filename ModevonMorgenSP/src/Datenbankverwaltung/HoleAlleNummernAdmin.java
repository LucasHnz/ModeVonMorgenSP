package Datenbankverwaltung;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HoleAlleNummernAdmin {
	
	
	public static ResultSet AdminNummern() {
		
		ResultSet rs = null;
		
		try {
			
			Connection con = VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			
			String sql = "select nutzernr from Administrator";
			
			rs = stmt.executeQuery(sql);
			
		}catch (SQLException e) {
			e.getMessage();
		}
		
		return rs;
		
	}

}
