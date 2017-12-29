package RechnungVerwaltung;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Bestellverwaltung.Bestellposition;
import MitarbeiterVerwaltung.Mitarbeiter;
import MitarbeiterVerwaltung.MitarbeiterSammlung;

public class BestellStrg {
	
	protected Bestellung bBestellung;
	
	public static void storniereBestellung(int bestellnr) {
		int bnr=bestellnr;
		try{
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			
			String sqlbefehl = "delete from Rechungbestellung where bestellNr "+ bnr;
			
			stmt.execute(sqlbefehl)	;
			
			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
			
			}catch (SQLException e) {
				e.getMessage();
			}
		}
	

	/*public static String �ndereVersandstatus(String versandStatus, int bestellNr) {
		try{
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			
			String sqlbefehl = "update RechnungBestellung set versandStatus ='"+versandStatus+"' where bestellNr ="+bestellNr;
			
			stmt.execute(sqlbefehl)	;
			
			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
			
			}catch (SQLException e) {
				e.getMessage();
			}
		return sqlbefehl ;
		}*/

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
	
	public static void erstelleRechnung () {
		//mit email versenden 
	}
	
	public static void aktualisiereVStatus(int i){
		
			Bestellung b = BestellungSammlung.BestellungSammlung.get(i);
		
			try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			
			String sqlbefehl = "update RechnungBestellung set versandStatus ='Versand' where bestellnr ="+i;
			
			stmt.executeQuery(sqlbefehl);
			
			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
			
			b.setVersandstatus("Zugestellt");
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
}


