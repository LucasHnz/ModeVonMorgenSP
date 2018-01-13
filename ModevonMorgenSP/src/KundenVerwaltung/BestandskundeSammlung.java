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
	
	static HashMap<Integer, Bestandskunde> BestandskundenSammlung = new HashMap<Integer,Bestandskunde>();
	static HashMap<Integer, Gastkunde> GastkundenListe = new HashMap<Integer, Gastkunde>();
	/**
	 * Füllt die Static HashMap BestandskundenSammlung mit den Werten aus der Datenbank
	 * 
	 */
	public static void fülleSammlung(ResultSet rs)  {
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
			
			Bestandskunde bkunde = new Bestandskunde(nutzernr, nachname, vorname, email, straße, ort, plz, iban, berechtigung, passwort, pss);
			BestandskundenSammlung.put(bkunde.getNutzernr(), bkunde);
			
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Holt genau einen Gastkunden aus der Liste
	 * @param Gastkundennr
	 * @return Gastkunde
	 */
	public static Bestandskunde getBestandskunde(int nutzernr) {
			return BestandskundenSammlung.get(nutzernr);
		}
	/**
	 * 
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
	 * Fügt der Datenbank einen neuen Gastkunde hinzu
	 * 
	 * @param nutzernr
	 * @param nachname
	 * @param vorname
	 * @param email
	 * @param straße
	 * @param ort
	 * @param plz
	 * @param iban
	 * @param berechtigung
	 * @param passwort
	 * @param pss
	 */
	public static void hinzufügenBestandskunde(int nutzernr, String nachname, String vorname,String email, String straße,String ort, int plz, String iban, int berechtigung, String passwort, int pss) {
		Bestandskunde bBestandskunde= new Bestandskunde(nutzernr,nachname,vorname,email,straße,ort,plz,iban,berechtigung,passwort,pss);
		BestandskundenSammlung.put(nutzernr, bBestandskunde);
	}
}
