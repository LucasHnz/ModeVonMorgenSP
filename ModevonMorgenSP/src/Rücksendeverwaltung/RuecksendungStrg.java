package Rücksendeverwaltung;

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

//neues Jpanel erzeugen um auszuwählen ob man die Rücksendung annimmt oder nicht wird in einer serperraten Klasse erzeugt

public class RuecksendungStrg {
	
	public static void ruecksendungannehmen(int bestellpos, String name, String nachname) {
		
		//wenn angenommen dann soll eine bestätigungsmail an den Kunden geschickt werden und Datenbank aktualisiert, dass die Position verändert wurde
		
		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			
			String sqlbefehl = "delete from Rücksendung where Bestellposition ="+bestellpos;
			
			stmt.execute(sqlbefehl)	;
			
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
			}catch(SQLException e) {
				e.getMessage();
			}
		
		File ran = new File ("Email_Antwort");
		FileWriter fw = new FileWriter (ran);
		BufferedWriter bw = new BufferedWriter (fw);
		
		bw.write("Sehr geehrte/er Herr/Frau " + name + " " + nachname);
		bw.write("\n");
		bw.write("\n");
		bw.write("aus Ihrer Bestellung wurde folgende Produkte zurückgenommen " + +".");
		bw.write("\n");
		bw.write("Mit freundlichen Grüßen");
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
		bw.write("wir konnten leider keine Ihrer bei uns bestellten Produkte zurück nehmen, da diese nicht den Standards entsprachen.");
		bw.write("\n");
		bw.write("Wir hoffen Sie haben Verständnis dafür.");
		bw.write("\n");
		bw.write("Mit freundlichen Grüßen");
		bw.write("\n");
		bw.write("Mode von Morgen.");
	}

}
