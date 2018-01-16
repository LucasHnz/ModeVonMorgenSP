package KundenVerwaltung;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author annag
 *
 */

public class GastkundenStrg {
	/**
	 ** F�gt der Liste sowie der Datenbank einen neuen Gastkunden hinzu
	 * @param nutzernr
	 *            Die einzigartige Nummer des Gastkunden
	 * @param nachname
	 *            Der Nachname des Kunden
	 * @param vorname
	 *            Der Vorname des Kunden
	 * @param email
	 *            Die E-Mailadresse des Kunden
	 * @param stra�e
	 *            Die Stra�e in der der Kunde wohnt
	 * @param ort
	 *            Der Ort in dem der Kunde wohnt
	 * @param plz
	 *            Die Postleitzahl des Ortes in dem der Kunde wohnt
	 * @param iban
	 *            Die Iban des Kontos des Kunden
	 * @param berechtigung
	 *            Die Berechtigung des Kunden, die er innerhalb des Shops hat
	 */
	public static void hinzuf�genGK(int nutzernr, String nachname, String vorname, String email, String stra�e,
			String ort, int plz, int berechtigung, String iban) {

		try {

			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();

			Statement stmt = con.createStatement();

			String sqlbefehl = "insert into Gastkunde values (" + nutzernr + ",'" + nachname + "','" + vorname + "','"
					+ email + "','" + stra�e + "','" + ort + "'," + plz + "," + berechtigung + ",'" + iban + "')";

			stmt.executeQuery(sqlbefehl);

			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
			GastkundenSammlung.hinzuf�genGastkunde(nutzernr, nachname, vorname, email, stra�e, ort, plz, berechtigung,
					iban);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
