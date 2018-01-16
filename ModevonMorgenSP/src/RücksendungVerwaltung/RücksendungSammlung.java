package RücksendungVerwaltung;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 * 
 * @author julian
 *
 */
public class RücksendungSammlung {
	
static HashMap<Integer, Rücksendung> RücksendungListe = new HashMap<Integer, Rücksendung>();
	
/**
 * Füllt die RücksendungListe mit den akutellen Werten aus der DB
 * @throws SQLException
 */
	public static void füllenRücksendungListe() throws SQLException {
		
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		String befehl = "Select * from Rücksendung";
	
		ResultSet rs = stmt.executeQuery(befehl);
		
		while (rs.next()) {
			
			int rücksendenr = rs.getInt("Rücksendenr");
			int bestellposnr = rs.getInt("Bestellposnr");
			int bestellnr = rs.getInt("Bestellnr");
			String datum = rs.getString("Datum");
			
			Rücksendung r = new Rücksendung (rücksendenr, bestellposnr, bestellnr, datum);
			
			RücksendungListe.put(rücksendenr, r);
		
	}
		
	}
	
	/**
	 * 
	 * @return RücksendungListe
	 */
	public static HashMap<Integer,Rücksendung> getRücksendungListe(){
		return RücksendungListe;
	}
	
	/**
	 * fügt der DB und der Liste eine neue Rücksendung hinzu
	 * @param rücksendenr
	 * @param bestellposnr
	 * @param bestellnr
	 * @param datum
	 */
	public static void hinzufügenRücksendung(int rücksendenr, int bestellposnr, int bestellnr, String datum ) {
		Rücksendung r = new Rücksendung(rücksendenr, bestellposnr, bestellnr, datum);
		RücksendungListe.put(rücksendenr, r);
	}
	
	/**
	 * Liefert genau eine Rücksendung
	 * @param Rücksendenr
	 * @return Rücksendung
	 */
	public static Rücksendung getRücksendung(int Rücksendenr) {
		return RücksendungListe.get(Rücksendenr);
	}
}





