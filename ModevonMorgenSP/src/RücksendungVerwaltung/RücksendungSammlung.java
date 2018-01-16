package R�cksendungVerwaltung;

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
public class R�cksendungSammlung {
	
static HashMap<Integer, R�cksendung> R�cksendungListe = new HashMap<Integer, R�cksendung>();
	
/**
 * F�llt die R�cksendungListe mit den akutellen Werten aus der DB
 * @throws SQLException
 */
	public static void f�llenR�cksendungListe() throws SQLException {
		
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		String befehl = "Select * from R�cksendung";
	
		ResultSet rs = stmt.executeQuery(befehl);
		
		while (rs.next()) {
			
			int r�cksendenr = rs.getInt("R�cksendenr");
			int bestellposnr = rs.getInt("Bestellposnr");
			int bestellnr = rs.getInt("Bestellnr");
			String datum = rs.getString("Datum");
			
			R�cksendung r = new R�cksendung (r�cksendenr, bestellposnr, bestellnr, datum);
			
			R�cksendungListe.put(r�cksendenr, r);
		
	}
		
	}
	
	/**
	 * 
	 * @return R�cksendungListe
	 */
	public static HashMap<Integer,R�cksendung> getR�cksendungListe(){
		return R�cksendungListe;
	}
	
	/**
	 * f�gt der DB und der Liste eine neue R�cksendung hinzu
	 * @param r�cksendenr
	 * @param bestellposnr
	 * @param bestellnr
	 * @param datum
	 */
	public static void hinzuf�genR�cksendung(int r�cksendenr, int bestellposnr, int bestellnr, String datum ) {
		R�cksendung r = new R�cksendung(r�cksendenr, bestellposnr, bestellnr, datum);
		R�cksendungListe.put(r�cksendenr, r);
	}
	
	/**
	 * Liefert genau eine R�cksendung
	 * @param R�cksendenr
	 * @return R�cksendung
	 */
	public static R�cksendung getR�cksendung(int R�cksendenr) {
		return R�cksendungListe.get(R�cksendenr);
	}
}





