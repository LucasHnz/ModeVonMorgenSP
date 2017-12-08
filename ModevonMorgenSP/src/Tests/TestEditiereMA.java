package Tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestEditiereMA {

	public static void main(String[] args) throws SQLException {
	
		Datenbankverwaltung.HinzufügenMaAdmin.hinzufügenAdmin("400000002", "Hinz", "Lucas", "lucas.hinz@appleistcooler.de", "Interaktion1", "Bielfeld", "33013", "DE0123456789", "4000", "4", "passwort");
		
		
	}
	

}
