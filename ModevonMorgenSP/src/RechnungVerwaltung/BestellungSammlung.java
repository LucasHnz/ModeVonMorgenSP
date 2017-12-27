package RechnungVerwaltung;

import java.sql.Connection;

/**
 * @author julian
 * 
 */
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class BestellungSammlung {

	static HashMap<Integer, Bestellung> BestellungSammlung = new HashMap<Integer, Bestellung>();
	
	public static void füllenBestellungSammlung(){
		
		try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select * from RECHNUNGBESTELLUNG";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int rechnungsnr = rs.getInt("Rechnungsnr");
				int bestellnr = rs.getInt("Bestellnr");
				int nutzernrbk = rs.getInt("Nutzernrbestandsk");
				int nutzernrgk = rs.getInt("Nutzernrgastk");
				String iban = rs.getString("IBAN");
				String nachname = rs.getString("Nachname");
				String vorname = rs.getString("Vorname");
				double gesamtpreis = rs.getDouble("Gesamtpreis");
				int erabatt = rs.getInt("EingesetzterRabatt");
				Date datum = rs.getDate("Datum");
				String vstatus = rs.getString("Versandstatus");
				String rechnungsort = rs.getString("Rechnungsort");
				String rechnungsstrasse = rs.getString("Rechnungsstrasse");
				int rechnungsplz = rs.getInt("Rechnungsplz");
				
				Bestellung b = new Bestellung (rechnungsnr, bestellnr, nutzernrbk, nutzernrgk, iban, nachname, vorname, gesamtpreis, erabatt, datum, vstatus, rechnungsort, rechnungsstrasse, rechnungsplz);
				
				BestellungSammlung.put(b.getRechnungsnr(), b);
				
			}
			
		}catch (SQLException e ) {
			e.printStackTrace();
		}
		
		}

	public static HashMap<Integer, Bestellung> getBestellungSammlung(){
		return BestellungSammlung;
	}
	
}
