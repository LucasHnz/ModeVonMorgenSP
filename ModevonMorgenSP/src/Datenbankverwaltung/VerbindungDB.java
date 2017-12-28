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
	
	/**
	 * Erstellt die Verbindung zur Datenbank
	 * @return Connection
	 */
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

/**
 * Schlieﬂt die offenen Verbindungen
 * @param con
 * @param stmt
 */
public static void schlieﬂeVerbindung (Connection con, Statement stmt) {
	
	try {
		con.close();
		stmt.close();
	}catch (SQLException e){
		e.getMessage();
	}
	
	}
}
