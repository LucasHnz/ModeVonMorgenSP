package Tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestNächsteNr {
	
	public static void main (String[]args) throws SQLException {
	int i = Datenbankverwaltung.holeNächsteNummer.nächsteKleidungNr();
	
	System.out.println(i);
	}

}
