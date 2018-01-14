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
	public static void storniereBestellung(int bestellnr) {
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

			BestellungSammlung.BestellungSammlung.remove(bestellnr);

			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);

		} catch (SQLException e) {
			e.getMessage();
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

			b.setVersandstatus("Zugestellt");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void bestellvorgang() {
		if (LogStrg.getAngemeldetStatus() == 2) {				//klappt wenn man nur eine Bestellung durch f�hrt, wenn man zwei mal hintereinander eine bestellung durch f�hrt, werden falsche punkte benutzt

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
				GUI.getFenster().�ffnenAnmeldefenster(); // klappt
			} else if (optionPane == 1) {
				GUI.getFenster().changePanel(new GUIBestandskundeRegistrierung()); // klappt
			} else if (optionPane == 2) {
				GUI.getFenster().changePanel(new GUIGastkundeErstellen()); // klappt nicht

			}
		} else if (LogStrg.getAngemeldetStatus() == 1) {			//klappt nicht
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

	// Falk
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
				System.out.println("Bestands�nderung auf " + nBestand);
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

	// Falk
	public static void erstelleBestellungBK(int pRabatt) { // Versandstatus, Rabatt evtl. commit und rollback, damit
															// entweder alles, oder gar nichts gespeichert wird.
		int bestellnr = Datenbankverwaltung.holeN�chsteNummer.n�chsteBestellNr();
		Bestandskunde bk = BestandskundeSammlung.getBestandskundenSammlung().get(LogStrg.getNutzerNr());
		int nrBK = bk.getNutzernr();
		int nrGK = 0;
		String iban = bk.getIban();
		String nachname = bk.getNachname();
		String vorname = bk.getVorname();
		double preis = Warenkorb.getGesamtpreis();
		double gesamtpreis = preis - ((pRabatt * preis) / 100);				//klappt
		int erabatt = pRabatt;												//klappt
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

	// Falk
	public static void erstelleBestellungGK() { // GK Nummer einf�gen, Versandstatus, Rabatt
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

			ps.executeUpdate(); 						//GEHT NICHT wieso auch immer, f�lle auch die sammlung in der Gui aber will trz nicht 
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
		String nutzernr2 = String.valueOf(nutzernr);
		Bestandskunde bk = BestandskundeSammlung.getBestandskundenSammlung().get(nutzernr);

		int pss = bk.getPss();
		double preisZ = preis / 10;
		int pssZ = (int) preisZ;
		int pssNeu = pss + pssZ - pRabatt;
		System.out.println("Alter wert: " + pss + " neuer Wert: " + pssNeu);
		BestandskundeStrg.aktualisierePSS(pssNeu, nutzernr2);

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
		int pssAkt = bk.getPss();       														   //wenn man eine zweite Bestellung durchf�hrt, nimmt er den Wert ,der vor der ersten Bestellung war und nicht den aktuellen aus der DB.
		int pRabatt = 0;
		boolean pr�fen = true;
		if(pssAkt>0) {
		while(pr�fen) {

			String eingabe = JOptionPane.showInputDialog(null,
					"Sie haben die M�glichkeit Punkte in Rabatt einzul�sen. Sie haben" + pssAkt
							+ "Punkte. Sie k�nnen nicht mehr als 20 Punkte einl�sen.",
					"Eingabe");

			pRabatt = Integer.parseInt(eingabe);

			if (pRabatt > 20 && pRabatt > pssAkt) {

				JOptionPane.showMessageDialog(null,
						"Sie haben keinen g�ltigen Wert eingegeben.", "Fehler",
						JOptionPane.ERROR_MESSAGE);

			}
			if ( pRabatt > pssAkt) {

				JOptionPane.showMessageDialog(null,
						"Sie haben nicht genug Punkte ! W�hlen Sie eine andere Anzahl von Punkten, die Sie eintauschen m�chten.",
						"Fehler", JOptionPane.ERROR_MESSAGE);

			}
			if (pRabatt>20) {
				JOptionPane.showMessageDialog(null,
						"Sie k�nnen nicht mehr als 20 Punkte einl�sen ! W�hlen Sie eine andere Anzahl von Punkten, die Sie eintauschen m�chten.",
						"Fehler", JOptionPane.ERROR_MESSAGE);

			}
			if (pRabatt <= 20 && pRabatt <= pssAkt) {
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
