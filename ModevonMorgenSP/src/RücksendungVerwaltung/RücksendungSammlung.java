package RücksendungVerwaltung;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class RücksendungSammlung {
	
static HashMap<Integer, Rücksendung> RücksendungListe = new HashMap<Integer, Rücksendung>();
	
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
	
	public static HashMap<Integer,Rücksendung> getRücksendungListe(){
		return RücksendungListe;
	}
	
	public static void hinzufügenRücksendung(int rücksendenr, int bestellposnr, int bestellnr, String datum ) {
		Rücksendung r = new Rücksendung(rücksendenr, bestellposnr, bestellnr, datum);
		RücksendungListe.put(rücksendenr, r);
	}
	public static Rücksendung getRücksendung(int Rücksendenr) {
		return RücksendungListe.get(Rücksendenr);
	}
}





