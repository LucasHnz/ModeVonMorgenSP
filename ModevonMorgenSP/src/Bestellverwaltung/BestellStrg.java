package Bestellverwaltung;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.util.HashMap;

import javax.swing.JOptionPane;

import Artikelverwaltung.Artikel;
import Artikelverwaltung.ArtikelStrg;
import Artikelverwaltung.Artikelsammlung;
import Datenbankverwaltung.holeNächsteNummer;
import Frontend.GUI;
import Frontend.GUIBestandskundeRegistrierung;
import Frontend.GUIGastkundeErstellen;
import Frontend.GUIWarenkorb;
import KundenVerwaltung.Bestandskunde;
import KundenVerwaltung.BestandskundeSammlung;
import KundenVerwaltung.BestandskundeStrg;
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

	// Julian
	/**
	 * Julian Hermann
	 * Storniert eine Bestellung.
	 * @param bestellungen mit bestellungen gefüllte HashMap.
	 * @param bestellnr Die zu stornierende Bestellnummer.
	 */
	public static void storniereBestellung(HashMap<Integer, Bestellung> bestellungen, int bestellnr) {
		int bnr = bestellnr;
		try {
			// Dadruch, dass die Reihenfolge der querys wichtig ist, wurde auf einen Batch
			// verzichtet, erst wenn die Erste Anfrage erfolg hatte, wird die zweite
			// aufgefÃ¼hrt
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			Statement stmt2 = con.createStatement();

			String Sql1 = "delete from bestellposition where bestellnr =" + bestellnr;
			String Sql2 = "delete from RechnungBestellung where bestellnr =" + bnr;

			stmt.executeQuery(Sql1);

			stmt2.executeQuery(Sql2);

			bestellungen.remove(bestellnr);

			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Julian
	/**
	 * Aktualisiert den Versandstatus einer Bestellung auf 'Versandt'.
	 * @param bestellNr Die Bestellnr der Bestellung.
	 */
	public static void aktualisiereVStatus(int bestellNr) {

		Bestellung b = BestellungSammlung.getBestellung(bestellNr);

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();

			String sqlbefehl = "update RechnungBestellung set versandStatus ='Versandt' where bestellnr =" + bestellNr;

			stmt.executeQuery(sqlbefehl);

			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);

			b.setVersandstatus("Versandt");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Falk Maoro, Anna Gross
	 * Initialisiert den Bestellvorgang, indem geprüft wird, welche Art von Nutzer eingeloggt ist. 
	 * Der Nutzer bekommt die Möglichkeit, sich als Gast- oder Bestandskunde zu registrieren, oder sich anzumelden.
	 * Nur ein angemeldeter Kunde kann schließlich bestellen. Bestandskunden bekommen zusätzlich die 
	 * Möglichkeit, ihre Rabattpunkte einzusetzten.
	 * 
	 */
	public static void bestellvorgang() {
		if (LogStrg.getAngemeldetStatus() == 2) {				

			int nutzernr = LogStrg.getNutzerNr();
			Bestandskunde bk = BestandskundeSammlung.getBestandskundenSammlung().get(nutzernr);
			String email = bk.getEmail();
			int pRabatt = abfrageRabatt();
			double preis = Warenkorb.getGesamtpreis();
			erstelleBestellungBK(pRabatt);
			errechnePunkte(preis, pRabatt);
			
			GUI.getFenster().changePanel(GUIWarenkorb.getGUIWarenkorb());
			MailController.MailSenden.sendMail(email, "Bestätigung ihrer Bestellung",
					"Sehr geehrter Kunde, Vielen Dank für ihre Bestellung. Ihre Bestellung wird in Kürze bearbeitet und in 5-7 Werktagen versandt. ");
		}

		else if (LogStrg.getAngemeldetStatus() == 0) {
			String[] options = { "Anmelden", "Als Kunde registrieren", "Als Gastkunde bestellen" };
			int optionPane = JOptionPane.showOptionDialog(null,
					"Für eine Bestellung müssen sie angemeldet sein. Wählen sie aus, wie sie fortfahren wollen.",
					"Bestellvorgang", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
					options[0]);
			if (optionPane == 0) {
				JOptionPane.showMessageDialog(null, "Bitte anmelden und Bestellung wiederholen", "Bitte anmelden",
						JOptionPane.INFORMATION_MESSAGE);
				GUI.getFenster().öffnenAnmeldefenster(); 
			} else if (optionPane == 1) {
				JOptionPane.showMessageDialog(null, "Bitte registrieren und Bestellung wiederholen", "Bitte anmelden",
						JOptionPane.INFORMATION_MESSAGE);
				GUI.getFenster().changePanel(new GUIBestandskundeRegistrierung()); 
			} else if (optionPane == 2) {
				GUI.getFenster().changePanel(new GUIGastkundeErstellen()); 

			}
		} else if (LogStrg.getAngemeldetStatus() == 1) {			
			Gastkunde gk = GastkundenSammlung.getGastkundenSammlung().get(LogStrg.getNutzerNr());
			String email = gk.getEmail();
			erstelleBestellungGK();
			MailController.MailSenden.sendMail(email, "Bestätigung ihrer Bestellung",
					"Sehr geehrter Kunde, Vielen Dank für ihre Bestellung. Ihre Bestellung wird in Kürze bearbeitet und in 5-7 Werktagen versandt. ");
			GUI.getFenster().changePanel(GUIWarenkorb.getGUIWarenkorb());

		}

		else if (LogStrg.getAngemeldetStatus() == 3 || LogStrg.getAngemeldetStatus() == 4) { 
			JOptionPane.showMessageDialog(null, "Mitarbeiter können keine Bestellungen tätigen", "Fehler!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Falk Maoro
	 * Erstellt die Bestellpositionen zu einer vorher angelegten Bestellung. Dazu werden die Artikel und 
	 * deren Anzahl aus dem Warenkorb in Bestellpositionen in der Datenbank gespeichert. Der commit wird 
	 * mit der aufrufenden erstelleBestellung-Methode ausgeführt, damit keine Fehler in den Datensätzen 
	 * auftreten.
	 * @param bestellnr Die Bestellnummer der zugehörigen Bestellung.
	 * @param con Das zu der Bestellung gehörende Connection Objekt.
	 */
	private static void erstelleBestellpositionen(Connection con, int bestellnr) throws SQLException {
		HashMap<Integer, Integer> warenkorbMap = Warenkorb.getWarenkorb();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("insert into Bestellposition values(?,?,?,?,?,?)");

			Integer[] keys = warenkorbMap.keySet().toArray(new Integer[warenkorbMap.keySet().size()]);
			int nr = holeNächsteNummer.nächsteBestellPosNr();
			for (int i = 0; i < keys.length; i++) {
				int artikelnummer = keys[i];
				int menge = warenkorbMap.get(keys[i]);
				double preis = Artikelsammlung.getArtikel(artikelnummer).getPreis()
						* (100 - Artikelsammlung.getArtikel(artikelnummer).getRabatt()) * 0.01 * menge;
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
				nr = nr + 1;
				Artikel a = Artikelsammlung.getArtikelsammlung().get(artikelnummer);
				int nBestand = a.getBestand() - menge;
				ArtikelStrg.aktualisiereBestand(nBestand, artikelnummer);
			}
			ps.executeBatch();
			JOptionPane.showMessageDialog(null, "Die Bestellung wurde erstellt", "Bestellung erstellt.",
					JOptionPane.INFORMATION_MESSAGE);
			Warenkorb.clearWarenkorb();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Falk Maoro
	 * Erstellt eine Bestellung für einen Bestandskunden. Dazu werden die Nutzerdaten aus der Bestandskundensammlung
	 * und die Bestelldaten aus dem Warenkorb verwendet. Im Anschluss daran werden die Bestellpositionen erstellt.
	 * @param pRabatt Der Bestandskunde hat vor Abschluss der Bestellung die Möglichkeit, seine Rabattpunkte einzusetzten.
	 * Diese werden in den Gesamtpreis der Bestellung mit einberechnet.
	 */
	public static void erstelleBestellungBK(int pRabatt) {  
		
		int bestellnr = Datenbankverwaltung.holeNächsteNummer.nächsteBestellNr();
		Bestandskunde bk = BestandskundeSammlung.getBestandskundenSammlung().get(LogStrg.getNutzerNr());
		int nrBK = bk.getNutzernr();
		int nrGK = 0;
		String iban = bk.getIban();
		String nachname = bk.getNachname();
		String vorname = bk.getVorname();
		double preis = Warenkorb.getGesamtpreis();
		double gesamtpreis = preis - ((pRabatt * preis) / 100);				
		int erabatt = pRabatt;												
		Date datum = Date.valueOf(LocalDate.now());
		String versandstatus = "Vorbereitung";
		String rechnungsort = bk.getOrt();
		String rechnungsstrasse = bk.getStraße();
		int rechnungsplz = bk.getPlz();

		Bestellung bestellung = new Bestellung(bestellnr, nrBK, nrGK, iban, nachname, vorname, gesamtpreis, erabatt,
				datum, versandstatus, rechnungsort, rechnungsstrasse, rechnungsplz);

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			con.setAutoCommit(false);
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
			erstelleBestellpositionen(con, bestellnr);
			con.commit();
			BestellungSammlung.hinzufügenBestellung(bestellung);
		} catch (SQLException e) {
			e.printStackTrace();
			try{
				con.rollback();
			}catch(SQLException s) {
				s.printStackTrace();
			}
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Falk Maoro
	 * Erstellt eine Bestellung für einen Gastkunden. Dazu werden die Nutzerdaten aus der Gastkundensammlung
	 * und die Bestelldaten aus dem Warenkorb verwendet. Im Anschluss daran werden die Bestellpositionen erstellt.
	 */
	public static void erstelleBestellungGK() { 
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

		Bestellung bestellung = new Bestellung(bestellnr, nrBK, nrGK, iban, nachname, vorname, gesamtpreis, erabatt,
				datum, versandstatus, rechnungsort, rechnungsstrasse, rechnungsplz);
		
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement("insert into Rechnungbestellung values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, bestellnr);
			ps.setNull(2, Types.NULL);
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

			ps.executeUpdate(); 						
			BestellungSammlung.hinzufügenBestellung(bestellung);
			erstelleBestellpositionen(con, bestellnr);

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			}catch(SQLException s) {
				e.printStackTrace();
			}
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	
	/**
	 * Anna Gross
	 * 
	 * Berechnet die aktuelle Anzahl an Punkten, die ein Bestandskunde nach einer Bestellung hat. Der Kunde bekommt Punkte pro 
	 * Bestellung gut geschrieben und die Punkte die er für eine Bestellung eingesetzt hat werden abgezogen.
	 *
	 * @param preis  Der Preis der Bestellung, der benötigt wird um die Punkte zu berechnen, die dem Kunden gutgeschrieben werden
	 * @param pRabatt	Der Rabatt der vom Kunden eingelöst wird
	 * 
	 */
	public static void errechnePunkte(double preis, int pRabatt) {
		int nutzernr = LogStrg.getNutzerNr();
		Bestandskunde bk = BestandskundeSammlung.getBestandskundenSammlung().get(nutzernr);
		int pss = bk.getPss();
		double preisZ = (preis - (preis * pRabatt)/100) / 10;
		int pssZ = (int) preisZ;
		int pssNeu = pss + pssZ; 
		BestandskundeStrg.aktualisierePSS(pssNeu, nutzernr);

	}

	
	
	/**
	 * Anna Gross
	 * Wenn die Möglichkeit besteht Punkte in Rabatt einzulösen wird
	 * gefragt wie viele Punkte eingelöst werden sollen.
	 * @return pRabatt  Der Rabatt der von Kunden eingelöst werden soll
	 * 
	 */
	public static int abfrageRabatt() {
		int nutzernr = LogStrg.getNutzerNr();
		Bestandskunde bk = BestandskundeSammlung.getBestandskundenSammlung().get(nutzernr);
		int pssAkt = bk.getPss();       														   
		int pRabatt = 0;
		boolean prüfen = true;
		if(pssAkt>0) {
		while(prüfen) {

			String eingabe = JOptionPane.showInputDialog(null,
					"Sie haben die Möglichkeit Punkte in Rabatt einzulösen. Sie haben " + pssAkt
							+ " Punkte. Sie können nicht mehr als 20 Punkte einlösen.");

			if(eingabe !=  null)
				pRabatt = Integer.parseInt(eingabe);
			else
				pRabatt = 0;

			
			if (pRabatt > 20 && pRabatt > pssAkt) {

				JOptionPane.showMessageDialog(null,
						"Sie haben keinen gültigen Wert eingegeben.", "Fehler",
						JOptionPane.ERROR_MESSAGE);

			}
			else if ( pRabatt > pssAkt) {

				JOptionPane.showMessageDialog(null,
						"Sie haben nicht genug Punkte ! Wählen Sie eine andere Anzahl von Punkten, die Sie eintauschen möchten.",
						"Fehler", JOptionPane.ERROR_MESSAGE);

			}
			else if (pRabatt>20) {
				JOptionPane.showMessageDialog(null,
						"Sie können nicht mehr als 20 Punkte einlösen ! Wählen Sie eine andere Anzahl von Punkten, die Sie eintauschen möchten.",
						"Fehler", JOptionPane.ERROR_MESSAGE);

			}
			else if (pRabatt <= 20 && pRabatt <= pssAkt) {
				int pNeu = pssAkt - pRabatt;
				BestandskundeStrg.aktualisierePSS(pNeu, nutzernr);
				JOptionPane.showMessageDialog(
						null, "Der Preis Ihrer Bestellung wurde um " + pRabatt
								+ " % reduziert. " ,
						"Reduzierung", JOptionPane.INFORMATION_MESSAGE);
				prüfen = false;

			}
			else {
				pRabatt=0;
			}

			
		}
		}
		return pRabatt;
	}
}
