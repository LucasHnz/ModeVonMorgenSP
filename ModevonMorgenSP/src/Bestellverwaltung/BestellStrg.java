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
import Datenbankverwaltung.holeNächsteNummer;
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
 * @author Falk Maoro, Julian, Anna 
 *
 */
public class BestellStrg {

	
protected Bestellung bBestellung;
	
	//Julian
	public static void storniereBestellung(int bestellnr) {			
		int bnr=bestellnr;
		try{
			//Dadruch, dass die Reihenfolge der querys wichtig ist, wurde auf einen Batch verzichtet, erst wenn die Erste Anfrage erfolg hatte, wird die zweite aufgeführt
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt =  con.createStatement();
			Statement stmt2 = con.createStatement();
			
			String Sql1 = "delete from bestellposition where bestellnr ="+bestellnr;
			String Sql2 = "delete from RechnungBestellung where bestellnr ="+bnr;
			
			stmt.executeQuery(Sql1);
			
			stmt2.executeQuery(Sql2);
			
			
			BestellungSammlung.BestellungSammlung.remove(bestellnr);
			
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
			
			}catch (SQLException e) {
				e.getMessage();
			}
		}
	
	//Julian aber funktioniert nicht so wie ich will  		
		//Wofür der String return?
	/**
		public static String ändereVersandstatus(String versandStatus, int bestellNr) {
			try{
				Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
				Statement stmt = con.createStatement();
				
				String sqlbefehl = "update RechnungBestellung set versandStatus ='"+versandStatus+"' where bestellNr ="+bestellNr;
				
				stmt.execute(sqlbefehl)	;
				
				Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
				
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
		
		Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
		
		b.setVersandstatus("Zugestellt");
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void bestellvorgang() {
		if(LogStrg.getAngemeldetStatus() == 2) {
			int nutzernr=LogStrg.getNutzerNr();
			Bestandskunde bk= BestandskundeSammlung.getBestandskundenSammlung().get(nutzernr);
			String email=bk.getEmail();
			int pRabatt=abfrageRabatt();
			erstelleBestellungBK(pRabatt);
			GUI.getFenster().changePanel(GUIWarenkorb.getGUIWarenkorb());
										
			MailController.MailSenden.sendMail(email,"Bestätigung ihrer Bestellung","Sehr geehrter Kunde, Vielen Dank für ihre Bestellung. Ihre Bestellung wird in Kürze bearbeitet und in 5-7 Werktagen versandt. ");
			}
		
		else if(LogStrg.getAngemeldetStatus() == 0) {
			String[] options = {"Anmelden","Als Kunde registrieren", "Als Gastkunde bestellen"};
			int optionPane = JOptionPane.showOptionDialog(null, "Für eine Bestellung müssen sie angemeldet sein. Wählen sie aus, wie sie fortfahren wollen.", "Bestellvorgang",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if(optionPane == 0) {
				JOptionPane.showMessageDialog(null, "Bitte anmelden und Bestellung widerholen", "Bitte anmelden", JOptionPane.INFORMATION_MESSAGE);
				GUI.getFenster().öffnenAnmeldefenster();					//klappt
			}
			else if(optionPane == 1) {
				GUI.getFenster().changePanel(new GUIBestandskundeRegistrierung());				//klappt		
			}
			else if(optionPane == 2) {
				GUI.getFenster().changePanel(new GUIGastkundeErstellen());					//klappt nicht
				
			}
		}
			else if(LogStrg.getAngemeldetStatus() == 1) {
				Gastkunde gk = GastkundenSammlung.getGastkundenSammlung().get(LogStrg.getNutzerNr());
				String email=gk.getEmail();
				erstelleBestellungGK();
				MailController.MailSenden.sendMail(email,"Bestätigung ihrer Bestellung","Sehr geehrter Kunde, Vielen Dank für ihre Bestellung. Ihre Bestellung wird in Kürze bearbeitet und in 5-7 Werktagen versandt. ");
				
			}
		
		else if(LogStrg.getAngemeldetStatus() == 3 || LogStrg.getAngemeldetStatus() == 4) {    //klappt
			JOptionPane.showMessageDialog(null, "Mitarbeiter können keine Bestellungen tätigen", "Fehler!", JOptionPane.ERROR_MESSAGE);
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
			int nr = holeNächsteNummer.nächsteBestellPosNr();
			for (int i = 0; i < keys.length; i++) {
				int artikelnummer = keys[i];
				int menge = warenkorbMap.get(keys[i]);
				double preis = Artikelsammlung.getArtikel(artikelnummer).getPreis() * (100-Artikelsammlung.getArtikel(artikelnummer).getRabatt()) * 0.01 * menge;
				String rücksendung = "Keine Rücksendung";
				ps.setInt(1, nr);
				ps.setInt(2, bestellnr);
				ps.setInt(3, artikelnummer);
				ps.setDouble(4, preis);
				ps.setInt(5, menge);
				ps.setString(6, rücksendung);
				ps.addBatch();
				
				Bestellposition bp = new Bestellposition(nr, bestellnr, artikelnummer, menge, preis, rücksendung);
				BestellpositionSammlung.hinzufügenBestellposition(bp);
				nr = nr +1;
			}
			System.out.println("Bestellnr:"+bestellnr+"posnr:"+nr);
			ps.executeBatch();       
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
	public static void erstelleBestellungBK(int pRabatt) {			//Versandstatus, Rabatt			evtl. commit und rollback, damit entweder alles, oder gar nichts gespeichert wird.
		int bestellnr = Datenbankverwaltung.holeNächsteNummer.nächsteBestellNr();
		Bestandskunde bk = BestandskundeSammlung.getBestandskundenSammlung().get(LogStrg.getNutzerNr());
		int nrBK = bk.getNutzernr();
		int nrGK = 0;
		String iban = bk.getIban();
		String nachname = bk.getNachname();
		String vorname = bk.getVorname();
		double preis = Warenkorb.getGesamtpreis();
		double gesamtpreis=preis-((pRabatt*preis)/100);
		int erabatt=pRabatt;
		Date datum = Date.valueOf(LocalDate.now());
		String versandstatus = "Vorbereitung";
		String rechnungsort = bk.getOrt();
		String rechnungsstrasse = bk.getStraße();
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
			BestellungSammlung.hinzufügenBestellung(bestellung);
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
	//Falk
	public static void erstelleBestellungGK( ) {						//GK Nummer einfügen, Versandstatus, Rabatt
		int bestellnr = Datenbankverwaltung.holeNächsteNummer.nächsteBestellNr();
		Gastkunde gk = GastkundenSammlung.getGastkundenSammlung().get(LogStrg.getNutzerNr());  
		
		int nrGK = LogStrg.getNutzerNr();
		int nrBK = 0;
		String iban = gk.getIban();
		String nachname = gk.getNachname();
		String vorname = gk.getVorname();
		double gesamtpreis = Warenkorb.getGesamtpreis();
		int erabatt = 0;
		Date datum = Date.valueOf(LocalDate.now());
		String versandstatus = "Vorbereitung";
		String rechnungsort = gk.getOrt();
		String rechnungsstrasse = gk.getStraße();
		int rechnungsplz = gk.getPlz();

		Bestellung bestellung = new Bestellung(bestellnr, nrBK, nrGK, iban, nachname, vorname, gesamtpreis, erabatt, datum, versandstatus, rechnungsort, rechnungsstrasse, rechnungsplz);
		
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			ps = con.prepareStatement("insert into Rechnungbestellung values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, bestellnr);
			ps.setInt(2, Types.NULL);
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
			
			ps.executeUpdate();				//geht nicht
			BestellungSammlung.hinzufügenBestellung(bestellung);
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
	/**
	 * 
	 * @param bestellnr
	 * berechnet die gesammelten Punkte einer Bestellung
	 */
	public static void errechnePunkte(int bestellnr) {  
		

		
			Bestellung b = BestellungSammlung.getBestellungSammlung().get(bestellnr);
			int nutzernr=LogStrg.getNutzerNr();
			Bestandskunde bk=BestandskundeSammlung.getBestandskundenSammlung().get(nutzernr);
			int pssAlt=bk.getPss();
			double preis= b.getGesamtpreis();
			
			String nutzernr2=String.valueOf(nutzernr);
			int preis1= (int) preis;
			int pssZ= Math.round( preis1/10);
			int pssNeu= pssAlt+pssZ;
			
				
			KundenVerwaltung.BestandskundeStrg.aktualisierePSS(pssNeu, nutzernr2);
			               
			
			
		
	}
	//Anna        
	/**
	 * 
	 * @param pss
	 * Wenn die Möglichkeit besteht Punkte in Rabatt einzulösen wird gefragt wie viele Punkte eingelöst werden sollen und die Punkte werden reduziert
	 */
	public static int abfrageRabatt() {
		int nutzernr=LogStrg.getNutzerNr();
		Bestandskunde bk=BestandskundeSammlung.getBestandskundenSammlung().get(nutzernr);
		int pss=bk.getPss();
		String nutzernr2=String.valueOf(nutzernr);
		int pRabatt=0;
		int pssNeu=pss;
		if (pss>5) {
		String[] möglichkeiten = {"Ja","Nein", "Abbruch"};     
		int frage1 = JOptionPane.showOptionDialog(null, "Sie haben die Möglichkeit Ihre Punkte in einen Rabatt umzutauschen. Beim Einlösen von Punkten werden keine Punkte gesammelt! Punkte einlösen?", "Punkte einlösen",
					 JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, möglichkeiten, möglichkeiten[0]);
			
		if(frage1==0) {
			if(pss>=15) {
				String[] options = {"5Punkte","10Punkte", "15 Punkte"};	
				int frage2 = JOptionPane.showOptionDialog(null, "Wie viele Punkte wollen Sie einlösen? 1 Punkt entspricht 1% Rabatt auf die gesamte Bestellung. Sie haben "+pss+" Punkte.", "Punkte einlösen",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					if(frage2 == 0) {
				
						pRabatt=5;
						pssNeu=pss-pRabatt;						
						KundenVerwaltung.BestandskundeStrg.aktualisierePSS(pssNeu, nutzernr2); 
						}
					else if(frage2 == 1) {
					
						pRabatt=10;
						pssNeu=pss-pRabatt;			
						erstelleBestellungBK(pRabatt);
						KundenVerwaltung.BestandskundeStrg.aktualisierePSS(pssNeu, nutzernr2); 

						}
					else if(frage2 == 2) {
						
						pRabatt=15;
						pssNeu=pss-pRabatt;			
						KundenVerwaltung.BestandskundeStrg.aktualisierePSS(pssNeu, nutzernr2);
						}
					JOptionPane.showMessageDialog(null,
						    "Preis der Bestellung wurde um "+pRabatt+" % reduziert.Sie haben nun noch "+pssNeu+" Punkte"
							,"Preis Änderung",
						    JOptionPane.INFORMATION_MESSAGE);
					GUI.getFenster().changePanel(GUIWarenkorb.getGUIWarenkorb());
					
				}
				if(pss<=15 && pss>=10) {
					String[] options = {"5Punkte","10Punkte"};
					int frage2 = JOptionPane.showOptionDialog(null, "Wie viele Punkte wollen Sie einlösen? 1 Punkt entspricht 1% Rabatt auf die gesamte Bestellung.Sie haben "+pss+ " Punkte.", "Punkte einlösen",
							JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
						if(frage2 == 0) {
	
							pRabatt=5;
							pssNeu=pss-pRabatt;			
							KundenVerwaltung.BestandskundeStrg.aktualisierePSS(pssNeu, nutzernr2);
							}
						else if(frage2 == 1) {
							pRabatt=10;
							pssNeu=pss-pRabatt;					
							KundenVerwaltung.BestandskundeStrg.aktualisierePSS(pssNeu, nutzernr2); 
								}
						JOptionPane.showMessageDialog(null,
							    "Preis der Bestellung wurde um "+pRabatt+" % reduziert.Sie haben nun noch "+pssNeu+" Punkte"
								,"Preis Änderung",
							    JOptionPane.INFORMATION_MESSAGE);
						GUI.getFenster().changePanel(GUIWarenkorb.getGUIWarenkorb());
						}
				
				if(pss>5&&pss<10) {
					String[] options = {"5Punkte","Abbruch"};
					int frage2 = JOptionPane.showOptionDialog(null, "Sie können nur 5Punkte einsetzten. Möchten Sie das? 1 Punkt entspricht 1% Rabatt auf die gesamte Bestellung. Sie haben "+pss+" Punkte.", "Punkte einlösen",
							JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
						if(frage2 == 0) {
							
							pRabatt=5;
							pssNeu=pss-pRabatt;			
							KundenVerwaltung.BestandskundeStrg.aktualisierePSS(pssNeu, nutzernr2); 
							JOptionPane.showMessageDialog(null,
								    "Preis der Bestellung wurde um 5% reduziert.Sie haben nun noch "+pssNeu+" Punkte."
								    ,"Preis Änderung",
								    JOptionPane.INFORMATION_MESSAGE);
							GUI.getFenster().changePanel(GUIWarenkorb.getGUIWarenkorb());
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
				pRabatt=0;
				}
			if (frage1==2) {
				JOptionPane.showMessageDialog(null,
					    "Vorgang wurde abgebrochen",
					    "Abbruch",
					    JOptionPane.ERROR_MESSAGE);
					GUI.getFenster().changePanel(GUIWarenkorb.getGUIWarenkorb());
			}
		}
		else {
		 pRabatt=0;
		}
			System.out.println(pRabatt);
			return pRabatt;
}
}
