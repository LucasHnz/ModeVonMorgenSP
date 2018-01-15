package Bestellverwaltung;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import Artikelverwaltung.Artikelsammlung;
import Bestellverwaltung.Bestellposition;

/**
 * 
 * @author Julian 
 *
 */
public class BestellpositionSammlung {

public static HashMap<Integer,Bestellposition> BestellpositionsSammlung = new HashMap<Integer, Bestellposition>();
	
	public static void füllenBestellpositionsSammlung(){
		
		try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select * from BESTELLPOSITION";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int posNr = rs.getInt("BestellpositionsNr");
				int bestellNr = rs.getInt("Bestellnr");
				int artikelnummer= rs.getInt("ArtikelNr");
				int aMenge =rs.getInt("Artikel Anzahl");
				double preis = rs.getDouble("Preis");
				String checkRücksendung = rs.getString("Rücksendung");
				
				
				Bestellposition b = new Bestellposition (posNr,bestellNr, artikelnummer, aMenge, preis, checkRücksendung);
				
				BestellpositionsSammlung.put(b.getPosNr(), b);
				
			}
			
		}catch (SQLException e ) {
			e.printStackTrace();
		}
		
		}

	public static HashMap<Integer, Bestellposition> getBestellpositionsSammlung(){
		return BestellpositionsSammlung;
	}
	
	public static Bestellposition getBestellpos(int nummer) {
		return BestellpositionsSammlung.get(nummer);
	}
	
	public static void removeBestellposition(int posNr) {
		BestellpositionsSammlung.remove(posNr);
	}
	
	public static void hinzufügenBestellposition(Bestellposition position) {
		BestellpositionsSammlung.put(position.getPosNr(), position);
	}
	public static void fülleMitSpeziellerNummer(int i) {
	try {
			
			clearListe();
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select * from BESTELLPOSITION where Bestellnr = '"+i+"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int posNr = rs.getInt("Bestellposnr");
				int bestellNr = rs.getInt("Bestellnr");
				int artikelnummer= rs.getInt("ArtikelNr");
				int aMenge =rs.getInt("Menge");
				double preis =Artikelsammlung.getArtikel(artikelnummer).getPreis() * (100 - Artikelsammlung.getArtikel(artikelnummer).getRabatt()  *0.01);
				preis= rs.getDouble("Preis");
				String checkRücksendung = rs.getString("Rücksendung");

				
				Bestellposition b = new Bestellposition (posNr,bestellNr, artikelnummer, aMenge, preis, checkRücksendung);
				
				BestellpositionsSammlung.put(b.getPosNr(), b);
				
			}
			
		}catch (SQLException e ) {
			e.printStackTrace();
		}
		
	}
	public static void clearListe() {
		BestellpositionsSammlung = new HashMap<Integer, Bestellposition>(); 
	}
}
