package Bestellverwaltung;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import Bestellverwaltung.Bestellung;

/**
 * 
 * @author Julian Hermann, Falk Maoro
 *
 */
public class BestellungSammlung {

public static HashMap<Integer, Bestellung> BestellungSammlung = new HashMap<Integer, Bestellung>();
	
	/**
	 * füllt die HashMap BestellungSammlung mit Values aus der Datenbank
	 */
	//Julian
	public static void füllenBestellungSammlung(){
		
		try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select * from RECHNUNGBESTELLUNG";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
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
				
				Bestellung b = new Bestellung (bestellnr, nutzernrbk, nutzernrgk, iban, nachname, vorname, gesamtpreis, erabatt, datum, vstatus, rechnungsort, rechnungsstrasse, rechnungsplz);
				
				BestellungSammlung.put(b.getBestellnr(), b);
				
			}
			
		}catch (SQLException e ) {
			e.printStackTrace();
		}
		
		}
	//Julian
	public static HashMap<Integer, Bestellung> getBestellungSammlung(){
		return BestellungSammlung;
	}
	
	//Julian
	public static Bestellung getBestellung(int bestellnr) {
		return BestellungSammlung.get(bestellnr);
	}
	/**
	 * Fügt der Bestellungssammlung eine Bestellung hinzu.
	 * @param bestellung Die hinzuzufügende Bestellung.
	 */
	public static void hinzufügenBestellung(Bestellung bestellung) {
		BestellungSammlung.put(bestellung.getBestellnr(), bestellung);
	}
	//Julian
	public static HashMap<Integer, Bestellung> getBestellungSammlung(int nutzernummer){
		HashMap<Integer, Bestellung> BestellungSammlungNR = new HashMap<Integer, Bestellung>();
		
		try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select * from RECHNUNGBESTELLUNG where Nutzernrbestandsk = " + nutzernummer;
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
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
				
				Bestellung b = new Bestellung (bestellnr, nutzernrbk, nutzernrgk, iban, nachname, vorname, gesamtpreis, erabatt, datum, vstatus, rechnungsort, rechnungsstrasse, rechnungsplz);
				
				BestellungSammlungNR.put(b.getBestellnr(), b);
				
			}
			
		}catch (SQLException e ) {
			e.printStackTrace();
		}
	return BestellungSammlungNR;
	}
}
