package BestellungVerwaltungAlt;

import java.sql.Connection;

/**
 * @author julian, annag
 * 
 */
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.HashMap;

import Bestellverwaltung.Bestellposition;
import Bestellverwaltung.BestellpositionSammlung;
import Logverwaltung.LogStrg;
import Warenkorbverwaltung.Warenkorb;

public class BestellungSammlung {

	public static HashMap<Integer, Bestellung> BestellungSammlung = new HashMap<Integer, Bestellung>();
	
	/**
	 * f�llt die HashMap BestellungSammlung mit Values aus der Datenbank
	 *///Julian
	public static void f�llenBestellungSammlung(){
		
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

	/**
	 * 
	 * @return BestellungSammlung
	 *///Julian
	public static HashMap<Integer, Bestellung> getBestellungSammlung(){
		return BestellungSammlung;
	}
	//Julian
	public static Bestellung getBestellung(int bestellnr) {
		return BestellungSammlung.get(bestellnr);
	}
	public static HashMap<Integer, Bestellung> getBestellungSammlung(int nutzernummer){
		HashMap<Integer, Bestellung> BestellungSammlungNR = new HashMap<Integer, Bestellung>();
		
		try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select * from RECHNUNGBESTELLUNG where Nutzernrbestandsk = " + nutzernummer;
			
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
				
				BestellungSammlungNR.put(b.getRechnungsnr(), b);
				
			}
			
		}catch (SQLException e ) {
			e.printStackTrace();
		}
	return BestellungSammlungNR;
	}
	
	public static void erstelleBestellungAusWarenkorb(int bestellnr1) {
		try{
			
			int nutzernr=LogStrg.getNutzerNr();
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select * from Bestandskunde where Nutzernr = " + nutzernr;
			
			ResultSet rs = stmt.executeQuery(sql);
			
			
			while (rs.next()){
				
				int rechnungsnr=Datenbankverwaltung.holeN�chsteNummer.n�chsteRechnungsNr();
				
				for(int bestellnr: BestellpositionSammlung.getBestellpositionsSammlung().keySet()) {
					int bestellnummer=bestellnr;
					
				}
				int nutzernrgk=0;
				String iban=rs.getString("Iban");
				String nachname = rs.getString("Nachname");
				String vorname = rs.getString("Vorname");
				double preis= Warenkorb.getGesamtpreis();
				int erabatt=0;
				Date datum= 12.12.2017 ;   //aktuelles Datum 
				String vstatus="Wird bearbeitet";
				String rechnungsort = rs.getString("Ort");
				String rechnungsstrasse = rs.getString("Strasse");
				int rechnungsplz = rs.getInt("Plz");
				
				Connection con1 = Datenbankverwaltung.VerbindungDB.erstelleConnection();
				Statement stmt1 = con1.createStatement();
				String sql1 = "insert into RECHNUNGBESTELLUNG values ('"+rechnungsnr+"','"+bestellnr1+"','"+ nutzernr+"','"+ nutzernrgk+"','"+ iban+"','"+nachname+"','"+vorname+"','"+preis+"','"+erabatt+"','"+datum+"','"+vstatus+"','"+rechnungsort+"','"+rechnungsstrasse+"','"+rechnungsplz+",)";
				ResultSet rs1 = stmt.executeQuery(sql);
				
				Bestellung b= new Bestellung(rechnungsnr, bestellnr, nutzernr, nutzernrgk, iban, nachname, vorname, preis, erabatt, datum, vstatus, rechnungsort, rechnungsstrasse, rechnungsplz);
				BestellungSammlung.put(b.getBestellnr(), b);
				
				rs1.close();
				Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con1, stmt1);
				
			}
			rs.close();
			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
			
		}	
		catch( SQLException e ){
			e.printStackTrace();
			
		}
		
		
		
		
	}
	
}
