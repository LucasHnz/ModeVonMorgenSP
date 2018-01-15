package Logverwaltung;

import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

import Backend.GUIMitarbeiter;
import Frontend.GUI;
import Frontend.GUIAnmelden;
import Frontend.GUIHomepage;

public class LogStrg {

	static int angemeldet = 0;
	static String recht = " ";
	static int nutzerNr = 0;
	static String[] anmeldenCbListAbgemeldet = { "Anmelden" };
	static String[] anmeldenCbListAngemeldet = { "Meine Bestellungen", "Konto verwalten", "Abmelden" };
	static String[] anmeldenCbListMitarbeiter = { "Verwaltung", "Abmelden" };

	/**
	 * Gleicht die Anmeldedaten mit der Datenbank ab und meldet den Benutzer an.
	 * Entsprechende Rechte werden zugeteilt.
	 * @param passwort eingegebenes Passwort des Benutzers
	 * @param email eingegebene Email des Benutzers
	 */
	public static void anmelden(String passwort, String email) {
		try {

			Connection con1 = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Connection con2 = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Connection con3 = Datenbankverwaltung.VerbindungDB.erstelleConnection();

			Statement stmt1 = con1.createStatement();
			Statement stmt2 = con2.createStatement();
			Statement stmt3 = con3.createStatement();
			String sql1 = "select vorname, nachname, nutzernr from Bestandskunde where email ='" + email
					+ "' and passwort = '" + passwort + "'";
			String sql2 = "select vorname, nachname, nutzernr from Mitarbeiter where email ='" + email
					+ "' and passwort = '" + passwort + "'";
			String sql3 = "select vorname, nachname, nutzernr from Administrator where email ='" + email
					+ "' and passwort = '" + passwort + "'";
			ResultSet rs1 = stmt1.executeQuery(sql1);
			ResultSet rs2 = stmt2.executeQuery(sql2);
			ResultSet rs3 = stmt3.executeQuery(sql3);

			if (rs1.next()) {
				setAnmeldeStatus(2);
				setRecht("Angemeldet");
				setNutzerNr(rs1.getInt("nutzernr"));
				GUI.comboBoxAbfrage();
				GUI.getFenster().setRechteAnzeigen(recht);
				GUI.getFenster().removeLogPanel();
				GUI.getFenster().changePanel(GUIHomepage.getHomepage());
			}

			else if (rs2.next()) {
				setAnmeldeStatus(3);
				setRecht("Angemeldet als Mitarbeiter");
				setNutzerNr(rs2.getInt("nutzernr"));
				GUI.comboBoxAbfrage();
				GUI.getFenster().setRechteAnzeigen(recht);
				GUI.getFenster().changePanel(GUIMitarbeiter.getGUIMitarbeiter());
				GUI.getFenster().removeLogPanel();
			}

			else if (rs3.next()) {
				setAnmeldeStatus(4);
				setRecht("Angemeldet als Admin");
				setNutzerNr(rs3.getInt("nutzernr"));
				GUI.comboBoxAbfrage();
				GUI.getFenster().setRechteAnzeigen(recht);
				GUI.getFenster().changePanel(GUIMitarbeiter.getGUIMitarbeiter());
				GUI.getFenster().removeLogPanel();
			}

			else
				GUI.getFenster().anmeldenFehlermeldung();

			rs1.close();
			rs2.close();
			rs3.close();
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con1, stmt1);
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con2, stmt2);
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con3, stmt3);

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}
	/**
	 *  
	 */
	public static void anmeldenGK(int nutzernr) {
		LogStrg.setNutzerNr(nutzernr);
		LogStrg.setAnmeldeStatus(1);
		LogStrg.setRecht("Gastkunde");
		GUI.comboBoxAbfrage();
	}
	/**
	 * Meldet Nutzer vom System ab
	 */
	public static void abmelden() {
		GUI.getFenster().changePanel(GUIHomepage.getHomepage());
		setRecht(" ");
		setAnmeldeStatus(0);
		setNutzerNr(0);
		GUI.comboBoxAbfrage();
		GUI.getFenster().setRechteAnzeigen(recht);
	}
	
	/**
	 *  Gibt Status der Anmeldung zurück(0=Abgemeldet, 2=Bestandskunde, 3=Mitarbeiter, 4=Admin )
	 *  @return angemeldet int-Wert der bestimmt, als was man angemeldet ist
	 */
	public static int getAngemeldetStatus() {
		return angemeldet;
	}
	
	/**
	 *  Gibt als String aus, als was man angemeldet ist
	 *  @return recht String der dem Benutzer anzeigt, als was man angemeldet ist
	 */
	public static String getRechte() {
		return recht;
	}
	
	/**
	 *  Setzt den Text, der dem Benutzer ausgegeben wird und anzeigt, als was man angemeldet ist
	 *  @param neueRechte neuer Text der dem Benutzer angezeigt wird und auskünft gibt, als was man angemeldet ist
	 */
	public static void setRecht(String neueRechte) {
		recht = neueRechte;
	}
	
	/**
	 *  Setzt den int-Wert, der die Rechte und Funktionen für den Benutzer bestimmt
	 *  @param neuerStatus neuer Wert der dem Benutzer neue Rechte gibt
	 */
	public static void setAnmeldeStatus(int neuerStatus) {
		angemeldet = neuerStatus;
	}

	/**
	 *  Gibt die Nutzernummer des angemeldeten Benutzers aus
	 *  @return nutzerNr Nutzernumemr des angemeldeten Nutzers
	 */
	public static int getNutzerNr() {
		return nutzerNr;
	}

	/**
	 *  Setzt eine neue Nutzernummer
	 *  @param nr neue Nutzernummer
	 */
	public static void setNutzerNr(int nr) {
		nutzerNr = nr;
	}

}
