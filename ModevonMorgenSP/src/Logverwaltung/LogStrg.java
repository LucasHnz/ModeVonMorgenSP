package Logverwaltung;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

import Frontend.GUIAnmelden;

public class LogStrg {
	
	static String testEmail = "jochen.kuester@fh-bielefeld.de";
	static String testPasswort = "12345678";
	static String testPwMitarbeiter = "123";
	static String testMailMitarbeiter = "test";
	
	public static  void anmelden(String passwort, String email, String[]anmeldenCbList) {
		try 
		{
			Connection con1 = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Connection con2 = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Connection con3 = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			
			Statement stmt1 = con1.createStatement();
			Statement stmt2 = con2.createStatement();
			Statement stmt3 = con3.createStatement();
			String sql1 = "select vorname, nachname, nutzernr from Bestandskunde where email ='"+email+"' and passwort = '"+passwort+"'";
			String sql2 = "select vorname, nachname, nutzernr from Mitarbeiter where email ='"+email+"' and passwort = '"+passwort+"'";
			String sql3 = "select vorname, nachname, nutzernr from Administrator where email ='"+email+"' and passwort = '"+passwort+"'";
			ResultSet rs1 = stmt1.executeQuery(sql1);
			ResultSet rs2 = stmt2.executeQuery(sql2);
			ResultSet rs3 = stmt3.executeQuery(sql3);
			
			if(rs1.next()) {
				System.out.println("1");
				String vorname = rs1.getString("vorname");
				anmeldenCbList[0] = vorname;
				Frontend.GUI.fensterSchlieﬂen();
				
				if(rs1.getString("email") != email) {
					System.out.println("OPT1");
					GUIAnmelden.anmeldenFehlermeldung();
				}
				
			}
			
			if(rs2.next()) {
				System.out.println("2");
				Frontend.GUI.fensterSchlieﬂen();
				anmeldenCbList[0] = "Mitarbeiter";
				new Backend.GUIMitarbeiter(anmeldenCbList);
				System.out.println("MIT");
				if(rs2.getString("email") != email) {
					System.out.println("OPT2");
					GUIAnmelden.anmeldenFehlermeldung();
				}
			}
			
			if(rs3.next()) {
				System.out.println("3");
				Frontend.GUI.fensterSchlieﬂen();
				anmeldenCbList[0] = "Admin";
				new Backend.GUIMitarbeiter(anmeldenCbList);
				
				if(rs3.getString("email") != email) {
					System.out.println("OPT3");
					GUIAnmelden.anmeldenFehlermeldung();
				}
			}
	
		
			
			
			rs1.close();
			rs2.close();
			rs3.close();
			Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con1, stmt1);
			Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con2, stmt2);
			Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con3, stmt3);
			
		}catch(SQLException e) {
			System.out.println("Fehler"+ e.getMessage());
                            			
		}

	
	}
}
