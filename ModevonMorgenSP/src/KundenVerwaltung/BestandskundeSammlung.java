package KundenVerwaltung;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * 
 * @author annag
 *
 */
public class BestandskundeSammlung {

	static HashMap<Integer, Bestandskunde> BestandskundenSammlung = new HashMap<Integer, Bestandskunde>();
	static HashMap<Integer, Gastkunde> GastkundenListe = new HashMap<Integer, Gastkunde>();

	/**
	 * Füllt die Bestandskundensammlung mit einem übergebenen ResultSet
	 * @param rs
	 *            Das ResultSet, das den zu vorhandenen Bestandskunden enthält.
	 */
	public static void fülleSammlung(ResultSet rs) {
		try {
			while (rs.next()) {
				int nutzernr = rs.getInt("Nutzernr");
				String nachname = rs.getString("Nachname");
				String vorname = rs.getString("Vorname");
				String email = rs.getString("Email");
				String straße = rs.getString("Straße");
				String ort = rs.getString("Ort");
				int plz = rs.getInt("Plz");
				String iban = rs.getString("IBAN");
				int berechtigung = rs.getInt("Berechtigung");
				String passwort = rs.getString("passwort");
				int pss = rs.getInt("PSS");

				Bestandskunde bkunde = new Bestandskunde(nutzernr, nachname, vorname, email, straße, ort, plz, iban,
						berechtigung, passwort, pss);
				BestandskundenSammlung.put(bkunde.getNutzernr(), bkunde);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Holt genau einen Bestandskunden aus der Liste
	 * @param nutzernr
	 *            Die Nutzernummer des Bestandskunden
	 * @return BestandskundenSammlung
	 */
	public static Bestandskunde getBestandskunde(int nutzernr) {
		return BestandskundenSammlung.get(nutzernr);
	}

	/**
	 * Gibt die in einer HashMap gespeicherte BestandskundenSammlung zurück
	 * @return BestandskundenSammlung
	 */
	public static HashMap<Integer, Bestandskunde> getBestandskundenSammlung() {
		return BestandskundenSammlung;
	}

	/**
	 * Löscht den Bestandskunden aus der Sammlung
	 * @param nutzernr
	 */
	public static void removeArtikel(int nutzernr) {
		BestandskundenSammlung.remove(nutzernr);
	}

	/**
	 * Fügt der Datenbank einen neuen Bestandskunden hinzu
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
	public static void hinzufügenBestandskunde(int nutzernr, String nachname, String vorname, String email,
			String straße, String ort, int plz, String iban, int berechtigung, String passwort, int pss) {
		Bestandskunde bBestandskunde = new Bestandskunde(nutzernr, nachname, vorname, email, straße, ort, plz, iban,
				berechtigung, passwort, pss);
		BestandskundenSammlung.put(nutzernr, bBestandskunde);
	}
}
