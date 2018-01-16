package R�cksendungVerwaltung;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * 
 * @author julian
 *
 */
public class R�cksendungStrg {
	
	/**
	 * Liefert das aktuelle Datum
	 * @return datum
	 */
	public static String aktuellesDatum() {
		
		LocalDate date = LocalDate.now();
		
		DateTimeFormatter df;
		
		df = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
				
		String datum = String.valueOf(date.format(df));
		
		return datum ;
		
	}
	
	/**
	 * Erstellt eine R�cksendung
	 * @param posNr
	 */
	public static void erstelleR�cksendung(int posNr) {
		
		
		
		String datum = aktuellesDatum();
		int r�cksendenr = Datenbankverwaltung.holeN�chsteNummer.n�chsteR�ccksendeNr();
		int bestellposnr = 0;
		try {
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Connection con2 = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Connection con3 = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		Statement stmt2 = con.createStatement();
		Statement stmt3 = con.createStatement();
		String SQL = "select * from bestellposition where bestellposnr ="+posNr;
		
		ResultSet rs= stmt.executeQuery(SQL);
		
		while(rs.next()) {
			bestellposnr = rs.getInt("Bestellnr");
		}

		String SQL2 = "insert into R�cksendung values ('"+r�cksendenr+"','"+posNr+"','"+bestellposnr+"','"+datum+"')";
		
		stmt2.executeQuery(SQL2);
		
		String SQL3 = "update Bestellposition set R�cksendung = 'R�cksendung' where bestellposnr ="+posNr;
		
		stmt3.executeQuery(SQL3);

		R�cksendungSammlung.hinzuf�genR�cksendung(r�cksendenr, posNr, bestellposnr, datum);
		
		Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
		
		Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con2, stmt2);
		
		Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con3, stmt3);
		
		
	} catch(SQLException e) {
		e.printStackTrace();
		}
	}
	

	
}
