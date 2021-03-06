package KundenVerwaltung;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BestandskundeStrg {

	public static void aktualisiereNachname(String nachname, int nutzernr) {

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();

			String sqlbefehl = "update Bestandskunde set nachname ='" + nachname + "' where nutzernr =" + nutzernr;

			stmt.execute(sqlbefehl);

			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void aktualisiereVorname(String vorname, int nutzernr) {

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();

			String sqlbefehl = "update Bestandskunde set vorname ='" + vorname + "' where nutzernr =" + nutzernr;

			stmt.execute(sqlbefehl);

			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void aktualisiereEmail(String email, int nutzernr) {

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();

			String sqlbefehl = "update Bestandskunde set email ='" + email + "' where nutzernr =" + nutzernr;

			stmt.execute(sqlbefehl);

			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void aktualisiereStraße(String straße, int nutzernr) {

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();

			String sqlbefehl = "update Bestandskunde set Straße ='" + straße + "' where nutzernr =" + nutzernr;

			stmt.execute(sqlbefehl);

			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void aktualisiereOrt(String ort, int nutzernr) {

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();

			String sqlbefehl = "update Bestandskunde set ort ='" + ort + "' where nutzernr =" + nutzernr;

			stmt.execute(sqlbefehl);

			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void aktualisierePLZ(String plz, int nutzernr) {

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();

			String sqlbefehl = "update Bestandskunde set PLZ ='" + plz + "' where nutzernr =" + nutzernr;

			stmt.execute(sqlbefehl);

			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void aktualisiereIBAN(String iban, int nutzernr) {

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();

			String sqlbefehl = "update Bestandskunde set IBAN ='" + iban + "' where nutzernr =" + nutzernr;

			stmt.execute(sqlbefehl);

			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void aktualisierePasswort(String passwort, int nutzernr) {

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();

			String sqlbefehl = "update Bestandskunde set Passwort ='" + passwort + "' where nutzernr =" + nutzernr;

			stmt.execute(sqlbefehl);

			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Anna
	public static void aktualisierePSS(int pss, int nutzernr) {

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();

			String sqlbefehl = "update Bestandskunde set PSS ='" + pss + "' where nutzernr =" + nutzernr;

			stmt.execute(sqlbefehl);
			BestandskundeSammlung.getBestandskunde(nutzernr).setPss(pss);
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Fügt einen neuen Bestandskunden in die Datenbank ein
	 * @param nutzernr
	 *            Die einzigartige Nummer des Bestandskunden
	 * @param nachname
	 *            Der Nachname des Kunden
	 * @param vorname
	 *            Der Vorname des Kunden
	 * @param email
	 *            Die E-Mailadresse des Kunden
	 * @param straße
	 *            Die Straße in der der Kunde wohnt
	 * @param ort
	 *            Der Ort in dem der Kunde wohnt
	 * @param plz
	 *            Die Postleitzahl des Ortes in dem der Kunde wohnt
	 * @param iban
	 *            Die Iban des Kontos des Kunden
	 * @param berechtigung
	 *            Die Berechtigung des Kunden, die er innerhalb des Shops hat
	 * @param passwort
	 *            Das Passwort des Kunden, das er braucht um sich im Shop anzumelden
	 * @param pss
	 *            Der Punktestand des Kunden
	 */
	public static void neuerKunde(int nutzernr, String nachname, String vorname, String email, String straße,
			String ort, int plz, String iban, int berechtigung, String passwort, int pss) {

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sqlbefehl = "insert into Bestandskunde values ('" + nutzernr + "','" + nachname + "','" + vorname
					+ "','" + email + "','" + straße + "','" + ort + "','" + plz + "','" + iban + "','" + berechtigung
					+ "','" + passwort + "','" + pss + "')";
			stmt.executeQuery(sqlbefehl);
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
			BestandskundeSammlung.hinzufügenBestandskunde(nutzernr, nachname, vorname, email, straße, ort, plz, iban,
					berechtigung, passwort, pss);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void löschenAccount(int nutzerNr) {
		try {

			int kdnr = nutzerNr;
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sqlbefehel = "delete from Bestandskunde where nutzerNr = '" + kdnr + "'";

			stmt.executeQuery(sqlbefehel);
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void anzeigenPunktestand(int nutzerNr) {
		int kdnr = nutzerNr;
		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sqlbefehel = "select PSS from Bestandskunde where nutzerNr = '" + kdnr + "'";

			stmt.executeQuery(sqlbefehel);
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Falk
	public static void FülleBestandskundeSammlung() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			stmt = con.createStatement();
			String sqlbefehl = "select * from Bestandskunde";
			rs = stmt.executeQuery(sqlbefehl);
			BestandskundeSammlung.fülleSammlung(rs);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
