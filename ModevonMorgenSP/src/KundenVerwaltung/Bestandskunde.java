package KundenVerwaltung;

/**
 * 
 * @author Julian
 *
 */
public class Bestandskunde {
	
	private int nutzernr;
	private String nachname;
	private String vorname;
	private String email;
	private String straﬂe;
	private String ort;
	private int plz;
	private String iban;
	private int berechtigung;
	private String passwort;
	private int pss;
/**
 * 
 * @param nutzernr Die einzigartige Nummer des Bestandskunden
 * @param nachname Der Nachname des Kunden
 * @param vorname Der Vorname des Kunden
 * @param email Die E-Mailadresse des Kunden
 * @param straﬂe Die Straﬂe in der der Kunde wohnt
 * @param ort Der Ort in dem der Kunde wohnt 
 * @param plz Die Postleitzahl des Ortes in dem der Kunde wohnt
 * @param iban Die Iban des Kontos des Kunden
 * @param berechtigung Die Berechtigung des Kunden, die er innerhalb des Shops hat
 * @param passwort Das Passwort des Kunden, das er braucht um sich im Shop anzumelden
 * @param pss Der Punktestand des Kunden 
 */
	public Bestandskunde(int nutzernr, String nachname, String vorname, String email, String straﬂe, String ort, int plz, String iban, int berechtigung, String passwort, int pss) {
		this.nutzernr = nutzernr;
		this.nachname = nachname;
		this.vorname = vorname;
		this.email = email;
		this.straﬂe = straﬂe;
		this.ort = ort;
		this.plz = plz;
		this.iban = iban;
		this.berechtigung = berechtigung;
		this.passwort = passwort;
		this.pss = pss;
	}
/**
 * Gibt die Kundennummer zur¸ck
 * @return nutzernr
 */
	public int getNutzernr() {
		return nutzernr;
	}
/**
 * Gibt den Nachnamen des Kunden zur¸ck
 * @return nachname
 */
	public String getNachname() {
		return nachname;
	}
/**
 * Legt den Nachnamen des Kunden fest
 * @param nachname
 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	/**
	 * 
	 * @return
	 */

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStraﬂe() {
		return straﬂe;
	}

	public void setStraﬂe(String straﬂe) {
		this.straﬂe = straﬂe;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public int getBerechtigung() {
		return berechtigung;
	}

	public void setBerechtigung(int berechtigung) {
		this.berechtigung = berechtigung;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public int getPss() {
		return pss;
	}

	public void setPss(int pss) {
		this.pss = pss; 
	}
	

}



