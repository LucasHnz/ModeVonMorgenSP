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
	public static void storniereBestellung(int bestellnr) {
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

			BestellungSammlung.BestellungSammlung.remove(bestellnr);

			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);

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

			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);

			b.setVersandstatus("Zugestellt");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void bestellvorgang() {
		if (LogStrg.getAngemeldetStatus() == 2) {				//klappt wenn man nur eine Bestellung durch führt, wenn man zwei mal hintereinander eine bestellung durch führt, werden falsche punkte benutzt

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
				GUI.getFenster().öffnenAnmeldefenster(); // klappt
			} else if (optionPane == 1) {
				GUI.getFenster().changePanel(new GUIBestandskundeRegistrierung()); // klappt
			} else if (optionPane == 2) {
				GUI.getFenster().changePanel(new GUIGastkundeErstellen()); // klappt nicht

			}
		} else if (LogStrg.getAngemeldetStatus() == 1) {			//klappt nicht
			Gastkunde gk = GastkundenSammlung.getGastkundenSammlung().get(LogStrg.getNutzerNr());
			String email = gk.getEmail();
			erstelleBestellungGK();
			MailController.MailSenden.sendMail(email, "Bestätigung ihrer Bestellung",
					"Sehr geehrter Kunde, Vielen Dank für ihre Bestellung. Ihre Bestellung wird in Kürze bearbeitet und in 5-7 Werktagen versandt. ");

		}

		else if (LogStrg.getAngemeldetStatus() == 3 || LogStrg.getAngemeldetStatus() == 4) { // klappt
			JOptionPane.showMessageDialog(null, "Mitarbeiter können keine Bestellungen tätigen", "Fehler!",
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
				System.out.println("Bestandsänderung auf " + nBestand);
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
		int bestellnr = Datenbankverwaltung.holeNächsteNummer.nächsteBestellNr();
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
		String rechnungsstrasse = bk.getStraße();
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
			BestellungSammlung.hinzufügenBestellung(bestellung);
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
	public static void erstelleBestellungGK() { // GK Nummer einfügen, Versandstatus, Rabatt
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

			ps.executeUpdate(); 						//GEHT NICHT wieso auch immer, fülle auch die sammlung in der Gui aber will trz nicht 
			BestellungSammlung.hinzufügenBestellung(bestellung);
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
	 * @return pRabatt Wenn die Möglichkeit besteht Punkte in Rabatt einzulösen wird
	 *         gefragt wie viele Punkte eingelöst werden sollen und die Punkte
	 *         werden reduziert
	 */
	public static int abfrageRabatt() {
		int nutzernr = LogStrg.getNutzerNr();
		String nutzernr2 = String.valueOf(nutzernr);
		Bestandskunde bk = BestandskundeSammlung.getBestandskundenSammlung().get(nutzernr);
		int pssAkt = bk.getPss();          //wenn man eine zweite bestellung durchführt, nimmt er den wert der vor der ersten Bestellung war und nicht den aktuellen aus der DB.
		int pRabatt = 0;

		boolean prüfen = true;
		while(prüfen) {

			String eingabe = JOptionPane.showInputDialog(null,
					"Sie haben die Möglichkeit Punkte in Rabatt einzulösen. Sie haben" + pssAkt
							+ "Punkte. Sie können nicht mehr als 20 Punkte einlösen.",
					"Eingabe");

			pRabatt = Integer.parseInt(eingabe);

			if (pRabatt > 20 && pRabatt > pssAkt) {

				JOptionPane.showMessageDialog(null,
						"Sie haben keinen gültigen Wert eingegeben.", "Fehler",
						JOptionPane.ERROR_MESSAGE);

			}
			if ( pRabatt > pssAkt) {

				JOptionPane.showMessageDialog(null,
						"Sie haben nicht genug Punkte ! Wählen Sie eine andere Anzahl von Punkten, die Sie eintauschen möchten.",
						"Fehler", JOptionPane.ERROR_MESSAGE);

			}
			if (pRabatt>20) {
				JOptionPane.showMessageDialog(null,
						"Sie können nicht mehr als 20 Punkte einlösen ! Wählen Sie eine andere Anzahl von Punkten, die Sie eintauschen möchten.",
						"Fehler", JOptionPane.ERROR_MESSAGE);

			}
			if (pRabatt <= 20 && pRabatt <= pssAkt) {
				JOptionPane.showMessageDialog(
						null, "Der Preis Ihrer Bestellung wurde um " + pRabatt
								+ " % reduziert. " ,
						"Reduzierung", JOptionPane.INFORMATION_MESSAGE);
				prüfen = false;

			}

			
		}

		return pRabatt;
	}
}
