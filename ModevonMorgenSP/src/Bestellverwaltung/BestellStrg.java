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
import Datenbankverwaltung.holeN�chsteNummer;
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
	public static void storniereBestellung(HashMap<Integer, Bestellung> bestellungen, int bestellnr) {
		int bnr = bestellnr;
		try {
			// Dadruch, dass die Reihenfolge der querys wichtig ist, wurde auf einen Batch
			// verzichtet, erst wenn die Erste Anfrage erfolg hatte, wird die zweite
			// aufgeführt
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			Statement stmt2 = con.createStatement();

			String Sql1 = "delete from bestellposition where bestellnr =" + bestellnr;
			String Sql2 = "delete from RechnungBestellung where bestellnr =" + bnr;

			stmt.executeQuery(Sql1);

			stmt2.executeQuery(Sql2);

			bestellungen.remove(bestellnr);

			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Julian
	public static void aktualisiereVStatus(int i) {

		Bestellung b = BestellungSammlung.getBestellung(i);

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();

			String sqlbefehl = "update RechnungBestellung set versandStatus ='Versand' where bestellnr =" + i;

			stmt.executeQuery(sqlbefehl);

			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);

			b.setVersandstatus("Versandt");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Falk Maoro, Anna Gross
	 * Initialisiert den Bestellvorgang, indem gepr�ft wird, welche Art von Nutzer eingeloggt ist. 
	 * Der Nutzer bekommt die M�glichkeit, sich als Gast- oder Bestandskunde zu registrieren, oder sich anzumelden.
	 * Nur ein angemeldeter Kunde kann schlie�lich bestellen. Bestandskunden bekommen zus�tzlich die 
	 * M�glichkeit, ihre Rabattpunkte einzusetzten.
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
			MailController.MailSenden.sendMail(email, "Best�tigung ihrer Bestellung",
					"Sehr geehrter Kunde, Vielen Dank f�r ihre Bestellung. Ihre Bestellung wird in K�rze bearbeitet und in 5-7 Werktagen versandt. ");
		}

		else if (LogStrg.getAngemeldetStatus() == 0) {
			String[] options = { "Anmelden", "Als Kunde registrieren", "Als Gastkunde bestellen" };
			int optionPane = JOptionPane.showOptionDialog(null,
					"F�r eine Bestellung m�ssen sie angemeldet sein. W�hlen sie aus, wie sie fortfahren wollen.",
					"Bestellvorgang", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
					options[0]);
			if (optionPane == 0) {
				JOptionPane.showMessageDialog(null, "Bitte anmelden und Bestellung wiederholen", "Bitte anmelden",
						JOptionPane.INFORMATION_MESSAGE);
				GUI.getFenster().�ffnenAnmeldefenster(); 
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
			MailController.MailSenden.sendMail(email, "Best�tigung ihrer Bestellung",
					"Sehr geehrter Kunde, Vielen Dank f�r ihre Bestellung. Ihre Bestellung wird in K�rze bearbeitet und in 5-7 Werktagen versandt. ");

		}

		else if (LogStrg.getAngemeldetStatus() == 3 || LogStrg.getAngemeldetStatus() == 4) { // klappt
			JOptionPane.showMessageDialog(null, "Mitarbeiter k�nnen keine Bestellungen t�tigen", "Fehler!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Falk Maoro
	 * Erstellt die Bestellpositionen zu einer vorher angelegten Bestellung. Dazu werden die Artikel und 
	 * deren Anzahl aus dem Warenkorb in Bestellpositionen in der Datenbank gespeichert.
	 * @param bestellnr Die Bestellnummer der zugeh�rigen Bestellung.
	 */
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
				double preis = Artikelsammlung.getArtikel(artikelnummer).getPreis()
						* (100 - Artikelsammlung.getArtikel(artikelnummer).getRabatt()) * 0.01 * menge;
				String r�cksendung = "Keine R�cksendung";
				ps.setInt(1, nr);
				ps.setInt(2, bestellnr);
				ps.setInt(3, artikelnummer);
				ps.setDouble(4, preis);
				ps.setInt(5, menge);
				ps.setString(6, r�cksendung);
				ps.addBatch();

				Bestellposition bp = new Bestellposition(nr, bestellnr, artikelnummer, menge, preis, r�cksendung);
				BestellpositionSammlung.hinzuf�genBestellposition(bp);
				nr = nr + 1;
				Artikel a = Artikelsammlung.getArtikelsammlung().get(artikelnummer);
				int nBestand = a.getBestand() - menge;
				ArtikelStrg.aktualisiereBestand(nBestand, artikelnummer);
			}
			ps.executeBatch();
			JOptionPane.showMessageDialog(null, "Die Bestellung wurde erstellt", "Bestellung erstellt.",
					JOptionPane.INFORMATION_MESSAGE);
			Warenkorb.clearWarenkorb();
		} catch (SQLException e) {
			e.printStackTrace();
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
	 * Erstellt eine Bestellung f�r einen Bestandskunden. Dazu werden die Nutzerdaten aus der Bestandskundensammlung
	 * und die Bestelldaten aus dem Warenkorb verwendet. Im Anschluss daran werden die Bestellpositionen erstellt.
	 * @param pRabatt Der Bestandskunde hat vor Abschluss der Bestellung die M�glichkeit, seine Rabattpunkte einzusetzten.
	 * Diese werden in den Gesamtpreis der Bestellung mit einberechnet.
	 */
	public static void erstelleBestellungBK(int pRabatt) {  
		
		int bestellnr = Datenbankverwaltung.holeN�chsteNummer.n�chsteBestellNr();
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
		String rechnungsstrasse = bk.getStra�e();
		int rechnungsplz = bk.getPlz();

		Bestellung bestellung = new Bestellung(bestellnr, nrBK, nrGK, iban, nachname, vorname, gesamtpreis, erabatt,
				datum, versandstatus, rechnungsort, rechnungsstrasse, rechnungsplz);

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

		} catch (SQLException e) {
			e.printStackTrace();
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
	 * Erstellt eine Bestellung f�r einen Gastkunden. Dazu werden die Nutzerdaten aus der Gastkundensammlung
	 * und die Bestelldaten aus dem Warenkorb verwendet. Im Anschluss daran werden die Bestellpositionen erstellt.
	 */
	public static void erstelleBestellungGK() { 
		int bestellnr = Datenbankverwaltung.holeN�chsteNummer.n�chsteBestellNr();
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
		String rechnungsstrasse = gk.getStra�e();
		int rechnungsplz = gk.getPlz();

		Bestellung bestellung = new Bestellung(bestellnr, nrBK, nrGK, iban, nachname, vorname, gesamtpreis, erabatt,
				datum, versandstatus, rechnungsort, rechnungsstrasse, rechnungsplz);
		
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
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
			BestellungSammlung.hinzuf�genBestellung(bestellung);
			erstelleBestellpositionen(bestellnr);

		} catch (SQLException e) {
			e.printStackTrace();
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

	// Anna
	/**
	 * 
	 * @param bestellnr
	 *            berechnet die gesammelten Punkte einer Bestellung
	 */
	public static void errechnePunkte(double preis, int pRabatt) {
		int nutzernr = LogStrg.getNutzerNr();
		Bestandskunde bk = BestandskundeSammlung.getBestandskundenSammlung().get(nutzernr);
		int pss = bk.getPss();
		double preisZ = preis / 10;
		int pssZ = (int) preisZ;
		int pssNeu = pss + pssZ - pRabatt;
		BestandskundeStrg.aktualisierePSS(pssNeu, nutzernr);

	}

	
	// Anna
	/**
	 * 
	 * @return pRabatt Wenn die M�glichkeit besteht Punkte in Rabatt einzul�sen wird
	 *         gefragt wie viele Punkte eingel�st werden sollen und die Punkte
	 *         werden reduziert
	 */
	public static int abfrageRabatt() {
		int nutzernr = LogStrg.getNutzerNr();
		Bestandskunde bk = BestandskundeSammlung.getBestandskundenSammlung().get(nutzernr);
		int pssAkt = bk.getPss();       														   
		int pRabatt = 0;
		boolean pr�fen = true;
		if(pssAkt>0) {
		while(pr�fen) {

			String eingabe = JOptionPane.showInputDialog(null,
					"Sie haben die M�glichkeit Punkte in Rabatt einzul�sen. Sie haben" + pssAkt
							+ "Punkte. Sie k�nnen nicht mehr als 20 Punkte einl�sen.");

			if(eingabe !=  null)
				pRabatt = Integer.parseInt(eingabe);
			else
				pRabatt = 0;

			if (pRabatt > 20 && pRabatt > pssAkt) {

				JOptionPane.showMessageDialog(null,
						"Sie haben keinen g�ltigen Wert eingegeben.", "Fehler",
						JOptionPane.ERROR_MESSAGE);

			}
			else if ( pRabatt > pssAkt) {

				JOptionPane.showMessageDialog(null,
						"Sie haben nicht genug Punkte ! W�hlen Sie eine andere Anzahl von Punkten, die Sie eintauschen m�chten.",
						"Fehler", JOptionPane.ERROR_MESSAGE);

			}
			else if (pRabatt>20) {
				JOptionPane.showMessageDialog(null,
						"Sie k�nnen nicht mehr als 20 Punkte einl�sen ! W�hlen Sie eine andere Anzahl von Punkten, die Sie eintauschen m�chten.",
						"Fehler", JOptionPane.ERROR_MESSAGE);

			}
			else if (pRabatt <= 20 && pRabatt <= pssAkt) {
				int pNeu = pssAkt - pRabatt;
				BestandskundeStrg.aktualisierePSS(pNeu, nutzernr);
				JOptionPane.showMessageDialog(
						null, "Der Preis Ihrer Bestellung wurde um " + pRabatt
								+ " % reduziert. " ,
						"Reduzierung", JOptionPane.INFORMATION_MESSAGE);
				pr�fen = false;

			}
			else {
				pRabatt=0;
			}

			
		}
		}
		return pRabatt;
	}
}
