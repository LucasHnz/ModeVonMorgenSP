package R�cksendeverwaltung;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Bastian Walter
 *
 */

//neues Jpanel erzeugen um auszuw�hlen ob man die R�cksendung annimmt oder nicht wird in einer serperraten Klasse erzeugt

public class RuecksendungStrg {
	
	public static void ruecksendungannehmen(int bestellpos, String name, String nachname) {
		
		//wenn angenommen dann soll eine best�tigungsmail an den Kunden geschickt werden und Datenbank aktualisiert, dass die Position ver�ndert wurde
		
		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			
			String sqlbefehl = "delete from R�cksendung where Bestellposition ="+bestellpos;
			
			stmt.execute(sqlbefehl)	;
			
			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
			}catch(SQLException e) {
				e.getMessage();
			}
		
		File ran = new File ("Email_Antwort");
		FileWriter fw = new FileWriter (ran);
		BufferedWriter bw = new BufferedWriter (fw);
		
		bw.write("Sehr geehrte/er Herr/Frau " + name + " " + nachname);
		bw.write("\n");
		bw.write("\n");
		bw.write("aus Ihrer Bestellung wurde folgende Produkte zur�ckgenommen " + +".");
		bw.write("\n");
		bw.write("Mit freundlichen Gr��en");
		bw.write("\n");
		bw.write("Mode von Morgen.");
		
		bw.close();
		fw.close();
		
	}
	
	public static void ruecksendungablhenen(String name, String nachname) {
		
		//wenn abgelehnt dann soll eine mail an den Kunden geschickt werden
		File rab = new File ("Email_Antwort");
		FileWriter fw = new FileWriter (rab);
		BufferedWriter bw = new BufferedWriter (fw);
		
		bw.write("Sehr geehrte/er Herr/Frau " + name + " " + nachname);
		bw.write("\n");
		bw.write("\n");
		bw.write("wir konnten leider keine Ihrer bei uns bestellten Produkte zur�ck nehmen, da diese nicht den Standards entsprachen.");
		bw.write("\n");
		bw.write("Wir hoffen Sie haben Verst�ndnis daf�r.");
		bw.write("\n");
		bw.write("Mit freundlichen Gr��en");
		bw.write("\n");
		bw.write("Mode von Morgen.");
	}

}
