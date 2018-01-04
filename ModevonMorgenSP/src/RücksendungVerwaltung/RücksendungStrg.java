package RücksendungVerwaltung;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import Bestellverwaltung.Bestellposition;
import Bestellverwaltung.BestellpositionSammlung;

public class RücksendungStrg {
	
	public static String aktuellesDatum() {
		
		LocalDate date = LocalDate.now();
		
		DateTimeFormatter df;
		
		df = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		
		
		
		String datum = String.valueOf(date.format(df));
		
		return datum ;
		
	}
	
	public static void erstelleRücksendung(int i) {
		
		
		
		String datum = aktuellesDatum();
		System.out.println(datum);
		int rücksendenr = Datenbankverwaltung.holeNächsteNummer.nächsteRüccksendeNr();
		System.out.println(rücksendenr);
		int bestellposnr = 0;
		try {
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Connection con2 = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		Statement stmt2 = con.createStatement();
		String SQL = "select * from bestellposition where bestellposnr ="+i;
		
		ResultSet rs= stmt.executeQuery(SQL);
		
		while(rs.next()) {
			bestellposnr = rs.getInt("Bestellnr");
		}
		
		Bestellposition b = BestellpositionSammlung.getBestellpos(bestellposnr);
		
		
		String SQL2 = "insert into Rücksendung values ('"+rücksendenr+"','"+i+"','"+bestellposnr+"','"+datum+"')";
		
		stmt2.executeQuery(SQL2);
		
		Rücksendung r = new Rücksendung(rücksendenr, i, bestellposnr, datum);
		
		System.out.println(b.getRücksendung());
		
		
		RücksendungSammlung.hinzufügenRücksendung(rücksendenr, i, bestellposnr, datum);
		
		Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
		
		Datenbankverwaltung.VerbindungDB.schließeVerbindung(con2, stmt2);
		
		
	} catch(SQLException e) {
		e.printStackTrace();
	}
	}
	
	public static void main(String [] args) {
		
	}
	
}
