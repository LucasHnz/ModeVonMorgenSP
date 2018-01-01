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
			//Dadruch, dass die Reihenfolge der querys wichtig ist, wurde auf einen Batch verzichtet, erst wenn die Erste Anfrage erfolg hatte, wird die zweite aufgeführt
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			Statement stmt2 = con.createStatement();
			
			String Sql1 = "delete from bestellposition where bestellnr ="+bestellnr;
			String Sql2 = "delete from RechnungBestellung where bestellnr ="+bnr;
			
			stmt.executeQuery(Sql1);
			
			stmt2.executeQuery(Sql2);
			
			
			BestellungSammlung.BestellungSammlung.remove(bestellnr);
			
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
			
			}catch (SQLException e) {
				e.getMessage();
			}
		}
	

	/*public static String ändereVersandstatus(String versandStatus, int bestellNr) {
		try{
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			
			String sqlbefehl = "update RechnungBestellung set versandStatus ='"+versandStatus+"' where bestellNr ="+bestellNr;
			
			stmt.execute(sqlbefehl)	;
			
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
			
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
		
			Bestellung b = BestellungSammlung.getBestellung(i);
		
			try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			
			String sqlbefehl = "update RechnungBestellung set versandStatus ='Versand' where bestellnr ="+i;
			
			stmt.executeQuery(sqlbefehl);
			
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
			
			b.setVersandstatus("Zugestellt");
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
}


