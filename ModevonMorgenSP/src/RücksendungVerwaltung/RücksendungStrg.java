package R�cksendungVerwaltung;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class R�cksendungStrg {
	
	public static String aktuellesDatum() {
		
		LocalDate date = LocalDate.now();
		
		DateTimeFormatter df;
		
		df = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		
		
		
		String datum = String.valueOf(date.format(df));
		
		return datum ;
		
	}
	
	public static void erstelleR�cksendung(int i) {
		String datum = aktuellesDatum();
		System.out.println(datum);
		int r�cksendenr = Datenbankverwaltung.holeN�chsteNummer.n�chsteR�ccksendeNr();
		System.out.println(r�cksendenr);
		int bestellnr = 0;
		try {
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Connection con2 = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		Statement stmt2 = con.createStatement();
		String SQL = "select bestellnr from bestellposition where bestellposnr ="+i;
		
		ResultSet rs= stmt.executeQuery(SQL);
		
		while(rs.next()) {
			bestellnr = rs.getInt("Bestellnr");
		}
		
		String SQL2 = "insert into R�cksendung values ('"+r�cksendenr+"','"+i+"','"+bestellnr+"','"+datum+"')";
		
		stmt2.executeQuery(SQL2);
		
		R�cksendung r = new R�cksendung(r�cksendenr, i, bestellnr, datum);
		
		
		R�cksendungSammlung.hinzuf�genR�cksendung(r�cksendenr, i, bestellnr, datum);
		
		Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
		
		Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con2, stmt2);
		
		
	} catch(SQLException e) {
		e.printStackTrace();
	}
	}
	
	public static void main(String [] args) {
		
	}
	
}
