package Bestellverwaltung;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.util.HashMap;

import javax.swing.JOptionPane;

import Artikelverwaltung.Artikelsammlung;
import Datenbankverwaltung.holeN�chsteNummer;
import Frontend.GUI;
import Frontend.GUIAnmelden;
import Frontend.GUIBestandskundeRegistrierung;
import Frontend.GUIGastkundeErstellen;
import Frontend.GUIHomepage;
import Frontend.GUIKontoBestellungen;
import Frontend.GUIWarenkorb;
import KundenVerwaltung.Bestandskunde;
import KundenVerwaltung.BestandskundeSammlung;
import KundenVerwaltung.Gastkunde;
import KundenVerwaltung.GastkundenSammlung;
import Logverwaltung.LogStrg;
import Warenkorbverwaltung.Warenkorb;
/**
 * 
 * @author Falk Maoro, Julian, Anna Gross
 *
 */
public class BestellStrg {

	
protected Bestellung bBestellung;
	
	//Julian
	public static void storniereBestellung(int bestellnr) {			
		int bnr=bestellnr;
		try{
			//Dadruch, dass die Reihenfolge der querys wichtig ist, wurde auf einen Batch verzichtet, erst wenn die Erste Anfrage erfolg hatte, wird die zweite aufgef�hrt
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt =  con.createStatement();
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
	
	//Julian aber funktioniert nicht so wie ich will  		
		//Wof�r der String return?
	/**
		public static String �ndereVersandstatus(String versandStatus, int bestellNr) {
			try{
				Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
				Statement stmt = con.createStatement();
				
				String sqlbefehl = "update RechnungBestellung set versandStatus ='"+versandStatus+"' where bestellNr ="+bestellNr;
				
				stmt.execute(sqlbefehl)	;
				
				Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
				
				return sqlbefehl ;
				}catch (SQLException e) {
					e.getMessage();
				}
			
			}
**/
	
	//Julian
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
	
	public static void bestellvorgang() {
		if(LogStrg.getAngemeldetStatus() == 2) {
			int nutzernr=LogStrg.getNutzerNr();
			
			try{
				Connection con1 = Datenbankverwaltung.VerbindungDB.erstelleConnection();
				Statement stmt1 = con1.createStatement();
				String sqlbefehl1 ="select pss,email from Bestandskunde where NutzerNr = '"+nutzernr+"'";
				stmt1.executeQuery(sqlbefehl1);
				ResultSet rs1= stmt1.executeQuery(sqlbefehl1);
				while(rs1.next()) {
					String email=rs1.getString("Email");
					int pss=rs1.getInt("PSS");
					if(pss>=5) {
						abfrageRabatt(pss);							
					}
					else {
						double pRabatt=0.0;
						erstelleBestellungBK(pRabatt); }						
			MailController.MailSenden.sendMail(email,"Best�tigung ihrer Bestellung","Sehr geehrter Kunde, Vielen Dank f�r ihre Bestellung. Ihre Bestellung wird in K�rze bearbeitet und in 5-7 Werktagen versandt. ");
			}
			rs1.close();
			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con1, stmt1);
			
			GUI.getFenster().changePanel(GUIHomepage.getHomepage());
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		else if(LogStrg.getAngemeldetStatus() == 0) {
			String[] options = {"Anmelden","Als Kunde registrieren", "Als Gastkunde bestellen"};
			int optionPane = JOptionPane.showOptionDialog(null, "F�r eine Bestellung m�ssen sie angemeldet sein. W�hlen sie aus, wie sie fortfahren wollen.", "Bestellvorgang",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if(optionPane == 0) {
				JOptionPane.showMessageDialog(null, "Bitte anmelden und Bestellung widerholen", "Bitte anmelden", JOptionPane.INFORMATION_MESSAGE);
				GUI.getFenster().changePanel(GUIAnmelden.getGUIAnmelden()); 										//klappt
			}
			else if(optionPane == 1) {
				GUI.getFenster().changePanel(new GUIBestandskundeRegistrierung());	//klappt		
			}
			else if(optionPane == 2) {
				GUI.getFenster().changePanel(new GUIGastkundeErstellen());						//klappt nicht
				
			}
		}
		else if(LogStrg.getAngemeldetStatus() == 3 || LogStrg.getAngemeldetStatus() == 4) {							//klappt
			JOptionPane.showMessageDialog(null, "Mitarbeiter k�nnen keine Bestellungen t�tigen", "Fehler!", JOptionPane.ERROR_MESSAGE);
		}
	}
	//Falk
	private static void erstelleBestellpositionen(int bestellnr) {
		HashMap<Integer, Integer> warenkorbMap = Warenkorb.getWarenkorb();
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			ps = con.prepareStatement("insert into Bestellposition values(?,?,?,?,?,?)");
	
			Integer[] keys = warenkorbMap.keySet().toArray(new Integer[warenkorbMap.keySet().size()]);
			int nr = holeN�chsteNummer.n�chsteBestellPosNr();
			for (int i = 0; i < keys.length; i++) {
				int artikelnummer = keys[i];
				int menge = warenkorbMap.get(keys[i]);
				double preis = Artikelsammlung.getArtikel(artikelnummer).getPreis() * (100-Artikelsammlung.getArtikel(artikelnummer).getRabatt()) * 0.01 * menge;
				String r�cksendung = "R�cksendung";
				ps.setInt(1, nr);
				ps.setInt(2, bestellnr);
				ps.setInt(3, artikelnummer);
				ps.setDouble(4, preis);
				ps.setInt(5, menge);
				ps.setString(6, r�cksendung);
				ps.addBatch();
				
				Bestellposition bp = new Bestellposition(nr, bestellnr, artikelnummer, menge, preis, r�cksendung);
				BestellpositionSammlung.hinzuf�genBestellposition(bp);
				nr = nr +1;
			}
			ps.executeBatch();       //hier der Fehler 
			JOptionPane.showMessageDialog(null, "Die Bestellung wurde erstellt", "Bestellung erstellt.", JOptionPane.INFORMATION_MESSAGE);
			errechnePunkte(bestellnr);
			Warenkorb.clearWarenkorb();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps !=null) 
					ps.close();
				if(con != null)
					con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	//Falk
	public static void erstelleBestellungBK(double pRabatt) {			//Versandstatus, Rabatt			evtl. commit und rollback, damit entweder alles, oder gar nichts gespeichert wird.
		int bestellnr = Datenbankverwaltung.holeN�chsteNummer.n�chsteBestellNr();
		Bestandskunde bk = BestandskundeSammlung.getBestandskundenSammlung().get(LogStrg.getNutzerNr());
		int nrBK = bk.getNutzernr();
		int nrGK = 0;
		String iban = bk.getIban();
		String nachname = bk.getNachname();
		String vorname = bk.getVorname();
		double rSumme=Warenkorb.getGesamtpreis()*pRabatt;
		double gesamtpreis = Warenkorb.getGesamtpreis()-rSumme;
		int erabatt = 0;
		Date datum = Date.valueOf(LocalDate.now());
		String versandstatus = "Vorbereitung";
		String rechnungsort = bk.getOrt();
		String rechnungsstrasse = bk.getStra�e();
		int rechnungsplz = bk.getPlz();

		Bestellung bestellung = new Bestellung(bestellnr, nrBK, nrGK, iban, nachname, vorname, gesamtpreis, erabatt, datum, versandstatus, rechnungsort, rechnungsstrasse, rechnungsplz);
		
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			ps = con.prepareStatement("insert into Rechnungbestellung values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, bestellnr);
			ps.setInt(2, nrBK);
			ps.setNull(3, Types.NULL);
			ps.setString(4, iban);
			ps.setString(5, nachname);
			ps.setString(6, vorname);
			ps.setDouble(7, gesamtpreis);
			ps.setInt(8, erabatt);
			ps.setDate(9, datum);
			ps.setString(10, versandstatus);
			ps.setString(11, rechnungsort);
			ps.setString(12, rechnungsstrasse);
			ps.setInt(13, rechnungsplz);
			
			ps.executeUpdate();
			BestellungSammlung.hinzuf�genBestellung(bestellung);
			erstelleBestellpositionen(bestellnr);
			int eRabatt=(int) pRabatt*100;
			aktualisiereEingRabatt(eRabatt ,bestellnr);		//geht nicht 
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps !=null) 
					ps.close();
				if(con != null)
					con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	//Falk
	public static void erstelleBestellungGK( int nutzernr) {						//GK Nummer einf�gen, Versandstatus, Rabatt
		int bestellnr = Datenbankverwaltung.holeN�chsteNummer.n�chsteBestellNr();
		Gastkunde gk = GastkundenSammlung.getGastkundenSammlung().get(nutzernr);  
		int nrGK = nutzernr;
		int nrBK = 0;
		String iban = gk.getIban();
		String nachname = gk.getNachname();
		String vorname = gk.getVorname();
		double gesamtpreis = Warenkorb.getGesamtpreis();
		int erabatt = 0;
		Date datum = Date.valueOf(LocalDate.now());
		String versandstatus = "Noch nicht versandt";
		String rechnungsort = gk.getOrt();
		String rechnungsstrasse = gk.getStra�e();
		int rechnungsplz = gk.getPlz();

		Bestellung bestellung = new Bestellung(bestellnr, nrBK, nrGK, iban, nachname, vorname, gesamtpreis, erabatt, datum, versandstatus, rechnungsort, rechnungsstrasse, rechnungsplz);
		
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			ps = con.prepareStatement("insert into Rechnunbestellung values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, bestellnr);
			ps.setInt(2, nrBK);
			ps.setInt(3, nrGK);
			ps.setString(4, iban);
			ps.setString(5, nachname);
			ps.setString(6, vorname);
			ps.setDouble(7, gesamtpreis);
			ps.setInt(8, erabatt);
			ps.setDate(9, datum);
			ps.setString(10, versandstatus);
			ps.setString(11, rechnungsort);
			ps.setString(12, rechnungsstrasse);
			ps.setInt(13, rechnungsplz);
			
			BestellungSammlung.hinzuf�genBestellung(bestellung);
			System.out.println("Bestellnr:"+bestellnr+"nutzernr:"+nutzernr);
			erstelleBestellpositionen(bestellnr);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps !=null) 
					ps.close();
				if(con != null)
					con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//Anna
	public static void errechnePunkte(int bestellnr) {  //geht nur wenn man keinen Rabatt einl�st 
		
		try {
		
			Bestellung b = BestellungSammlung.getBestellungSammlung().get(LogStrg.getNutzerNr());
			int nutzernr=LogStrg.getNutzerNr();
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		    Statement stmt = con.createStatement();
			String sqlbefehl ="select Gesamtpreis from RechnungBestellung where bestellnr = '"+bestellnr+"'";
			stmt.executeQuery(sqlbefehl);
			ResultSet rs= stmt.executeQuery(sqlbefehl);
			
			Connection con1 = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		    Statement stmt1 = con1.createStatement();
			String sqlbefehl1 ="select pss from Bestandskunde where NutzerNr = '"+nutzernr+"'";
			stmt1.executeQuery(sqlbefehl1);
			ResultSet rs1= stmt1.executeQuery(sqlbefehl1);
			while(rs.next()&&rs1.next()) {
			int pssAlt=rs1.getInt("PSS");
			double preis=rs.getDouble("Gesamtpreis");
			String nutzernr2=String.valueOf(nutzernr);
			int preis1= (int) preis;
			int pssZ= Math.round( preis1/10);
			int pssNeu= pssAlt+pssZ;
			
				
			KundenVerwaltung.BestandskundeStrg.aktualisierePSS(pssNeu, nutzernr2);
			               
			}
			rs1.close();
			rs.close();
			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con1, stmt1);
			
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//Anna                     					                   
	public static void abfrageRabatt(int pss) {
		
		int nutzernr=LogStrg.getNutzerNr();
		String nutzernr2=String.valueOf(nutzernr);
						
		String[] m�glichkeiten = {"Ja","Nein", "Abbruch"};     
		int frage1 = JOptionPane.showOptionDialog(null, "Sie haben die M�glichkeit Ihre Punkte in einen Rabatt umzutauschen. Beim Einl�sen von Punkten werden keine Punkte gesammelt! Punkte einl�sen?", "Punkte einl�sen",
					 JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, m�glichkeiten, m�glichkeiten[0]);
			
		if(frage1==0) {
			if(pss>15) {
				String[] options = {"5Punkte","10Punkte", "15 Punkte"};	
				int frage2 = JOptionPane.showOptionDialog(null, "Wie viele Punkte wollen Sie einl�sen? 1 Punkt entspricht 1% Rabatt auf die gesamte Bestellung.", "Punkte einl�sen",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					if(frage2 == 0) {
				
						double pRabatt=0.05;
																
						int pssNeu=pss-5;						
						erstelleBestellungBK(pRabatt);
						KundenVerwaltung.BestandskundeStrg.aktualisierePSS(pssNeu, nutzernr2); 
						JOptionPane.showMessageDialog(null,
							    "Preis der Bestellung wurde um 5% reduziert"
							    ,"Preis �nderung",
							    JOptionPane.INFORMATION_MESSAGE);
						
						}
					else if(frage2 == 1) {
					
						double pRabatt=0.1;
							
						int pssNeu=pss-10;			
						erstelleBestellungBK(pRabatt);
						KundenVerwaltung.BestandskundeStrg.aktualisierePSS(pssNeu, nutzernr2); 
						KundenVerwaltung.BestandskundeStrg.aktualisierePSS(pssNeu, nutzernr2);
						JOptionPane.showMessageDialog(null,
							    "Preis der Bestellung wurde um 10% reduziert"
							    ,"Preis �nderung",
							    JOptionPane.INFORMATION_MESSAGE);
						
						
						}
					else if(frage2 == 2) {
						
						double pRabatt=0.15;
						
						int pssNeu=pss-15;			
						erstelleBestellungBK(pRabatt);
						KundenVerwaltung.BestandskundeStrg.aktualisierePSS(pssNeu, nutzernr2); 
						
						JOptionPane.showMessageDialog(null,
							    "Preis der Bestellung wurde um 15% reduziert"
							    ,"Preis �nderung",
							    JOptionPane.INFORMATION_MESSAGE);
						
					
					}
					
				}
				if(pss<=15 && pss>=10) {
					String[] options = {"5Punkte","10Punkte"};
					int frage2 = JOptionPane.showOptionDialog(null, "Wie viele Punkte wollen Sie einl�sen? 1 Punkt entspricht 1% Rabatt auf die gesamte Bestellung.", "Punkte einl�sen",
							JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
						if(frage2 == 0) {
	
							double pRabatt=0.05;
							
							int pssNeu=pss-5;			
							erstelleBestellungBK(pRabatt);
							KundenVerwaltung.BestandskundeStrg.aktualisierePSS(pssNeu, nutzernr2); 
							JOptionPane.showMessageDialog(null,
								    "Preis der Bestellung wurde um 5% reduziert"
								    ,"Preis �nderung",
								    JOptionPane.INFORMATION_MESSAGE);
							
							}
						else if(frage2 == 1) {
							double pRabatt=0.1;
							
							int pssNeu=pss-10;			
							erstelleBestellungBK(pRabatt);			
							KundenVerwaltung.BestandskundeStrg.aktualisierePSS(pssNeu, nutzernr2); 
							JOptionPane.showMessageDialog(null,
								    "Preis der Bestellung wurde um 10% reduziert"
									,"Preis �nderung",
								    JOptionPane.INFORMATION_MESSAGE);
							
							}
						
				}
			
				if(pss>5&&pss<10) {
					String[] options = {"5Punkte","Abbruch"};
					int frage2 = JOptionPane.showOptionDialog(null, "Sie k�nnen nur 5Punkte einsetzten. M�chten Sie das? 1 Punkt entspricht 1% Rabatt auf die gesamte Bestellung.", "Punkte einl�sen",
							JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
						if(frage2 == 0) {
							
							double pRabatt=0.05;
							int pssNeu=pss-5;			
							erstelleBestellungBK(pRabatt);
							KundenVerwaltung.BestandskundeStrg.aktualisierePSS(pssNeu, nutzernr2); 
							JOptionPane.showMessageDialog(null,
								    "Preis der Bestellung wurde um 5% reduziert"
								    ,"Preis �nderung",
								    JOptionPane.INFORMATION_MESSAGE);
							
							}
						if(frage2==1) {
							JOptionPane.showMessageDialog(null,
								    "Vorgang wurde abgebrochen",
								    "Abbruch",
								    JOptionPane.ERROR_MESSAGE);
							GUI.getFenster().changePanel(GUIWarenkorb.getGUIWarenkorb());
						}
					}
			}

			if (frage1==1) {
				double pRabatt=0.0;
				erstelleBestellungBK(pRabatt);  
				}
			if (frage1==2) {
				JOptionPane.showMessageDialog(null,
					    "Vorgang wurde abgebrochen",
					    "Abbruch",
					    JOptionPane.ERROR_MESSAGE);
					GUI.getFenster().changePanel(GUIWarenkorb.getGUIWarenkorb());
			}
			}
			
	
	
	
		//Anna
		public static void aktualisiereEingRabatt(int eRabatt ,int bestellnr) {  // wei� noch nicht wie und wohin damit 
			
			try{
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			
			String sqlbefehl = "update RechnungBestellung set EingesetzterRabatt='"+eRabatt+"' where bestellnr ="+bestellnr;
			
			stmt.execute(sqlbefehl)	;  
			System.out.println(eRabatt);
			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
			
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
