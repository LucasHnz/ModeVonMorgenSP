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
import java.util.ArrayList;

import Bestellverwaltung.Bestellposition;



public class RechnungStrg {
	
	
	public static  void erstelleRechnung(String email) {
		try
		//Abfrage nach BenutzerID ob Bestands- und Gastkunden.
		{
			String befehlMA = "select berechtigung from Mitarbeiter where email ='"+email+"'";
			String befehlAdmin = "select berechtigung from Administrator where email ='"+email+"'";
			String befehlBKunde = "select berechtigung from Bestandskunde where email ='"+email+"'";
			int i = 0;
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			
			ResultSet rs1 = stmt.executeQuery(befehlMA);
			ResultSet rs2 = stmt.executeQuery(befehlBKunde);
			ResultSet rs3 = stmt.executeQuery(befehlAdmin);
			
			if (rs1.next()) {
				i=3;
			}
			if (rs2.next()) {
				i=2;
			}
			
			if (rs3.next()) {
				i=4;
			}
			
			
			if (i == 2) {
				
				String sqlbefehlbk = ("select nutzernr, name, nachname, straﬂe, ort, plz from Bestandskunde where ...");
				String sqlbefehlbp = ("bestellposnr, bestellnr, artikelnr, preis from Bestellposition where ...");
				
			}else if (i == 3){
				
				String sqlbefehlmia = ("select nutzernr, name, nachname, straﬂe, ort, plz from Mitarbeiter where ...");
				String sqlbefehlbp = ("bestellposnr, bestellnr, artikelnr, preis from Bestellposition where ...");
				
			}else if (i == 4) {
				
				String sqlbefehlad = ("select nutzernr, name, nachname, straﬂe, ort, plz from Administrator where ...");
				String sqlbefehlbp = ("bestellposnr, bestellnr, artikelnr, preis from Bestellposition where ...");
				
			}else {
				//JPanelabfrage f¸r Gastkunden
			}
			
			//Warenkorb implementieren
			
			//Rechnung erstellen und verschicken
			
			
			//int rechnungsnummer = rs.getString("rechNr");
			//String iban = rs.getString("iban");
			//String name = rs.getString("name");
			//String nachname = rs.getString("nachname");
			
			
			//stmt.execute(sqlbefehl);
			
			Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
			
		}catch(SQLException e) {
                          
			e.getMessage();
			
		}

	}
	/**
	 * @author annag
	 */
	
	public static void storniereBestellung(int bestellnr) {
		int bnr=bestellnr;
		try{
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			
			String sqlbefehl = "delete from Rechungbestellung where bestellNr "+ bnr;
			
			stmt.execute(sqlbefehl)	;
			
			Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
			
			}catch (SQLException e) {
				e.getMessage();
			}
		}
	
	
	// Was macht diese Methode ?
	public static void anzeigenBestellungen(int nutzerNrBestandsK) {
		int kdnr=nutzerNrBestandsK;
		try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			
			Statement stmt = con.createStatement();
			
			String sqlbefehl = "select * from RechnungBestellung where nutzerNrBestandsK="+kdnr;
			
			stmt.executeQuery(sqlbefehl);
			
			Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
			
			
		}catch (SQLException e) {
			e.getMessage();
		}
		}
	
	
	
	// Diese Methode hat keinen return Value ??
	public static void anzeigenBestellungenBK() {
		try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			
			Statement stmt = con.createStatement();
			
			String sqlbefehl = "select * from RechnungBestellung where nutzerNrBestandsK is not null";
			
			stmt.executeQuery(sqlbefehl);
			
			Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
			
			
			
		}catch (SQLException e) {
			e.getMessage();
		}
	}
	
	// Was macht diese Methode
	public static void anzeigenBestellungenGK() {
		try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			
			Statement stmt = con.createStatement();
			
			String sqlbefehl = "select * from RechnungBestellung where nutzerNrGastK is not null";
			
			stmt.executeQuery(sqlbefehl);
			
			Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
			
			
		}catch (SQLException e) {
			e.getMessage();
		}
		}
	public static void ‰ndereVersandstatus(String versandStatus, int bestellNr) {
		try{
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			
			String sqlbefehl = "update RechnungBestellung set versandStatus ='"+versandStatus+"' where bestellNr ="+bestellNr;
			
			stmt.execute(sqlbefehl)	;
			
			Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
			// RechnungsSammlung.getRechnung(bestellNr);
			
			}catch (SQLException e) {
				e.getMessage();
			}
		}
	public double errechnePreis(ArrayList<Bestellposition> test, int Punkte ) {
		
		double gpreis = 0;
		int multiplikator = 1;
		
		Punkte = (Punkte/100);
		
		multiplikator = 1 - Punkte;
		
		for(int i = 0; i < test.size(); i++) {
			 gpreis = gpreis + test.get(i).getPreis();
		}
		gpreis = gpreis * multiplikator;
		return gpreis;
		
	}

}
