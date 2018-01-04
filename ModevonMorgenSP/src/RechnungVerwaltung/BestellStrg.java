package RechnungVerwaltung;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Bestellverwaltung.Bestellposition;


public class BestellStrg {
	
	protected Bestellung bBestellung;
	
	public static void storniereBestellung(int bestellnr) {
		int bnr=bestellnr;
		try{
			//Dadruch, dass die Reihenfolge der querys wichtig ist, wurde auf einen Batch verzichtet, erst wenn die Erste Anfrage erfolg hatte, wird die zweite aufgef�hrt
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			Statement stmt2 = con.createStatement();
			
			String Sql1 = "delete from bestellposition where bestellnr ="+bestellnr;
			String Sql2 = "delete from RechnungBestellung where bestellnr ="+bnr;
			
			stmt.executeQuery(Sql1);
			
			stmt2.executeQuery(Sql2);
			
			
			BestellungSammlung.BestellungSammlung.remove(bestellnr);
			
			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
			
			}catch (SQLException e) {
				e.getMessage();
			}
		}
	

	/*public static String �ndereVersandstatus(String versandStatus, int bestellNr) {
		try{
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			
			String sqlbefehl = "update RechnungBestellung set versandStatus ='"+versandStatus+"' where bestellNr ="+bestellNr;
			
			stmt.execute(sqlbefehl)	;
			
			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
			
			}catch (SQLException e) {
				e.getMessage();
			}
		return sqlbefehl ;
		}*/

	public double errechnePreis(ArrayList<Bestellposition> test, int Punkte ) {
		
		double gpreis = 0;
		int multiplikator = 1;
		
		Punkte = (Punkte/100);
		
		multiplikator = 1 - Punkte;
		
		for(int i = 0; i < test.size(); i++) {
			 gpreis = gpreis + test.get(i).getPreis();
		}
		gpreis = gpreis * multiplikator;
		return gpreis;
		}
	
	public static void erstelleRechnung () {
		
		int nutzernrb=; //noch irgendwie die nutzernr aus der Bestellungholen
		
		try {
			
			Connection con= Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			
			String sqlbefehl = "select* from RECHNUNGBESTELLUNG where NUTZERNRBESTANDSK="+nutzernrb;
			ResultSet rs= stmt.executeQuery(sqlbefehl);
			
			while(rs.next()) {
				int rechnungsnr= rs.getInt("Rechnungsnr");
				int bestellnr=rs.getInt("Bestellnr");
				int nutzernrbk=rs.getInt("NutzernrBestandsK");
				int nutzernrgk=rs.getInt("NutzernrGastk");
				String iban =rs.getString("iban");
				String nachname = rs.getString("Nachname");
				String vorname = rs.getString("Vorname");
				double gesamtpreis=rs.getDouble("GesamtPreis");
				int erabatt=rs.getInt("EingesetzeRabatt");
				Date datum=rs.getDate("Datum");
				String vStatus=rs.getString("VersandStatus");
				String ort = rs.getString("RechnungsOrt");
				String stra�e = rs.getString("RechnungsStra�e");
				int plz = rs.getInt("RechnungsPlz");
			
				
				if (nutzernrgk=null) {
					Connection con2= Datenbankverwaltung.VerbindungDB.erstelleConnection();
					Statement stmt2= con.createStatement();
					String sqlbefehl2 = "select EMAIL from BESTANSKUNDE where NUTZERNR="+nutzernrb;
					ResultSet rs2= stmt2.executeQuery(sqlbefehl2);
					
					while(rs2.next()) {
						String email=rs2.getString("Email");
					}
					rs2.close();
					Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con2, stmt2);
					}
				else if (nutzernrgk=null){
					Connection con3= Datenbankverwaltung.VerbindungDB.erstelleConnection();
					Statement stmt3= con.createStatement();
					String sqlbefehl3 = "select EMAIL from GASTKUNDE where NUTZERNR="+nutzernrb;
					ResultSet rs3= stmt3.executeQuery(sqlbefehl3);
					
					while(rs3.next()) {
						String email=rs3.getString("Email");
					}
					rs3.close();
					Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con3, stmt3);	
					} 
				String recipientsAddress = email;
				String subject = "Vielen Dank f�r Ihre Bestellung!";
				String text = "\r\n" + 
						"Bestellung abgeschlossen!\r\n" + 
						"Hallo" + vorname +nachname+ "vielen Dank f�r Ihre Bestellung (Bestellnr: )"+bestellnr+". Wir hoffen, das Shoppen bei uns hat Ihnen gefallen.\r\n "+ 
								"Ihr Bestellung wird innerhalb der n�chsten 3-5 Werktagen an folgende Adresse "+stra�e +ort +plz+ "gesendet"+
								"\r\n" + 
								"Sie k�nnen Artikel, die Sie nicht behalten m�chten, auch innerhalb von 2 Wochen nach Erhalt der Bestellung an uns zur�cksenden.";
				

				MailController.MailSenden.sendMail(recipientsAddress, subject, text); 
				rs.close();
				
				Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
			}
			}catch(SQLException e) {
				e.printStackTrace();
				}
		}
	
	public static void aktualisiereVStatus(int i){
		
			Bestellung b = BestellungSammlung.getBestellung(i);
		
			try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			
			String sqlbefehl = "update RechnungBestellung set versandStatus ='Versand' where bestellnr ="+i;
			
			stmt.executeQuery(sqlbefehl);
			
			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
			
			b.setVersandstatus("Zugestellt");
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			
		}
	
}


