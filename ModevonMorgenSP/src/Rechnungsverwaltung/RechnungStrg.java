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
			
			
			if (i = 2) {
				
				String sqlbefehlbk = ("select nutzernr, name, nachname, straﬂe, ort, plz from Bestandskunde where ...");
				String sqlbefehlbp = ("bestellposnr, bestellnr, artikelnr, preis from Bestellposition where ...");
				
			}else if (i = 3){
				
				String sqlbefehlmia = ("select nutzernr, name, nachname, straﬂe, ort, plz from Mitarbeiter where ...");
				String sqlbefehlbp = ("bestellposnr, bestellnr, artikelnr, preis from Bestellposition where ...");
				
			}else if (i = 4) {
				
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
}
