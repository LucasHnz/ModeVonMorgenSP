package Rechnungsverwaltung;

/**
 * 
 * author Bastian Walter
 * 
 */


import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class RechnungStrg {
	
	
	public static  void erstelleRechnung(String pwd, String email, String[]anmeldenCbList) {
		try
		//Abfrage nach BenutzerID ob Bestands- und Gastkunden.
		{
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@aix1.fh-bielefeld.de:1521:d2");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select Rechnungsnummer and IBAN and Name and Nachname from Bestandskunde"
					+ "(Mitarbeiter, Kunden, Bestandskunden, Administrator)");
			
			rs.next();
			
			String Rechnungsnummer = rs.getString("rechNr");
			String IBAN = rs.getString("iban");
			String Name = rs.getString("name");
			String Nachname = rs.getString("nachname");
			
			
			
			
			
			rs.close();
			stmt.close();
			con.close();
			
		}catch(SQLException e) {
                          
			e.getMessage();
			
		}
		
		//Zusammenrechnen des Warenkorbbetrags und Aufzählung der Artikelnamen und ID.
		
		
		// Erzeugen einer Rechnungseite und versand per e-mail.

}}
