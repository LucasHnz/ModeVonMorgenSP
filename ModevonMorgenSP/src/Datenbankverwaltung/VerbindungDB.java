package Datenbankverwaltung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author julian
 *
 */

public class VerbindungDB {
	
public static Connection erstelleConnection() {
		
		Connection con = null;
		String Verbindung = "jdbc:oracle:thin:@aix1.fh-bielefeld.de:1521:d2";
		
		try {
			
			con = DriverManager.getConnection(Verbindung, "dvi515", "fh6482");
			
		}catch ( SQLException e ) {
			e.getMessage();
		}
		
		return con;
	}

public static void schließeVerbindung (Connection con, Statement stmt) {
	
	try {
		con.close();
		stmt.close();
	}catch (SQLException e){
		e.getMessage();
	}
	
	}
}
