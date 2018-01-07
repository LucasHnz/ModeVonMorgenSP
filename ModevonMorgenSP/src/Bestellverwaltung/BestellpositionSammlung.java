package Bestellverwaltung;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 * 
 * @author Julian 
 *
 */
public class BestellpositionSammlung {

public static HashMap<Integer,Bestellposition> BestellpositionsSammlung = new HashMap<Integer, Bestellposition>();
	
	public static void f�llenBestellpositionsSammlung(){
		
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
				String checkR�cksendung = rs.getString("R�cksendung");
				
				
				Bestellposition b = new Bestellposition (posNr,bestellNr, artikelnummer, aMenge, preis, checkR�cksendung);
				
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
	
	public static void hinzuf�genBestellposition(Bestellposition position) {
		BestellpositionsSammlung.put(position.getPosNr(), position);
	}
}
