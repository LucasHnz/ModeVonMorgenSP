package Bestellverwaltung;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
/**
 * 
 * @author annag
 *
 */


public class BestellpositionSammlung {
static HashMap<Integer, Bestellposition> BestellpositionsSammlung = new HashMap<Integer, Bestellposition>();
	
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
				
				
				Bestellposition b = new Bestellposition (posNr,bestellNr, artikelnummer, aMenge, preis);
				
				BestellpositionsSammlung.put(b.getPosNr(), b);
				
			}
			
		}catch (SQLException e ) {
			e.printStackTrace();
		}
		
		}

	public static HashMap<Integer, Bestellposition> getBestellpositionsSammlung(){
		return BestellpositionsSammlung;
	}
	
}

	

