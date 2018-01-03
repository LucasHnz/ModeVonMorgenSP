package Logverwaltung;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

import Frontend.GUI;
import Frontend.GUIAnmelden;

public class LogStrg {
	
	static int angemeldet = 0;
	static String recht = " ";
	
	
	public static  void anmelden(String passwort, String email) {
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
				System.out.println("Gastkunde");
				Frontend.GUI.fensterSchlieﬂen();
				new GUI();
				setAnmeldeStatus(2);
				setRecht("Angemeldet");
				GUI.setRechteAnzeigen(recht);
		
			}
			
			else if(rs2.next()) {
				System.out.println("MA");
				Frontend.GUI.fensterSchlieﬂen();
				new Backend.GUIMitarbeiter();
				setAnmeldeStatus(3);
				setRecht("Angemeldet als Mitarbeiter");
				GUI.setRechteAnzeigen(recht);
			}
			
			else if(rs3.next()) {
				System.out.println("Admin");
				Frontend.GUI.fensterSchlieﬂen();
				new Backend.GUIMitarbeiter();
				setAnmeldeStatus(4);
				setRecht("Angemeldet als Admin");
				GUI.setRechteAnzeigen(recht);	
			}
			
			else 
				GUI.anmeldenFehlermeldung();
			
	
		
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
	
	public static void abmelden() {
		Frontend.GUI.fensterRestart();
		setRecht(" ");
		setAnmeldeStatus(0);
		GUI.setRechteAnzeigen(recht);
	}
	
	
	public static int getAngemeldetStatus() {
		return angemeldet;
	}
	
	public static String getRechte() {
		return recht;
	}
	
	public static void setRecht(String neueRechte) {
		recht = neueRechte;
	}
	
	public static void setAnmeldeStatus(int neuerStatus){
		angemeldet = neuerStatus;
	}


}
