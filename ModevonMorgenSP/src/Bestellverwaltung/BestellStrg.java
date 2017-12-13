package Bestellverwaltung;
import Datenbankverwaltung.VerbindungDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BestellStrg {

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
	
	public static void erfasseBestellung() {
		
	}
	public static void einl�senRabatt() { //zs mit erfasse bestellung 
		
	}
	public static void anzeigenBestellungen(int nutzernr) {
		int kdnr=nutzernr;
		try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			
			Statement stmt = con.createStatement();
			
			String sqlbefehl = ("select * from RechnungBestellung where Nutzernr="+kdnr);
			
			stmt.executeQuery(sqlbefehl);
			
			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
			
			
		}catch (SQLException e) {
			e.getMessage();
		}
		}
	
	
	public static void anzeigenBestellungenBK() {
		try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			
			Statement stmt = con.createStatement();
			
			String sqlbefehl = ("select * from RechnungBestellung where nutzerNrBestandsK is not null");
			
			stmt.executeQuery(sqlbefehl);
			
			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
			
			
		}catch (SQLException e) {
			e.getMessage();
		}
		}
	public static void anzeigenBestellungenGK(Connection con) {
		try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			
			Statement stmt = con.createStatement();
			
			String sqlbefehl = ("select * from RechnungBestellung where nutzerNrGastK is not null");
			
			stmt.executeQuery(sqlbefehl);
			
			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
			
			
		}catch (SQLException e) {
			e.getMessage();
		}
		}
	public static void �ndereVersandstatus(String versandStatus, int nutzerNr) {
		try{
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			
			String sqlbefehl = "update RechnungBestellung set versandStatus ='"+versandStatus+"' where nutzernr ="+nutzerNr;
			
			stmt.execute(sqlbefehl)	;
			
			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
			
			}catch (SQLException e) {
				e.getMessage();
			}
		}
}
