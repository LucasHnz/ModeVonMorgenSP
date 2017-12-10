package Logverwaltung;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class LogStrg {
	
	static String testEmail = "jochen.kuester@fh-bielefeld.de";
	static String testPasswort = "12345678";
	static String testPwMitarbeiter = "123";
	static String testMailMitarbeiter = "test";
	
	public static  void anmelden(String pwd, String email, String[]anmeldenCbList) {
		try 
		{
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select email and passwort from "
					+ "(Mitarbeiter, Kunden, Bestandskunden, Administrator)");
			
			rs.next();
		
			String userEmail = rs.getString("email");
			String userPasswort = rs.getString("passwort");
			String userName = rs.getString("vorname");
			
			if(email.equals(userEmail) && pwd.equals(userPasswort)) {
				View.GUI.fensterSchlieﬂen();
				anmeldenCbList[0] = userName;
				new View.GUI(anmeldenCbList);
				
			}
			if(email.equals(testMailMitarbeiter) && pwd.equals(testPwMitarbeiter)) {
				View.GUI.fensterSchlieﬂen();
				anmeldenCbList[0] = "Mitarbeiter";
				new View.GUIMitarbeiter(anmeldenCbList);
			}
		
			
			rs.close();
			Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
			
		}catch(SQLException e) {
                            			
		}

	
	}
}
