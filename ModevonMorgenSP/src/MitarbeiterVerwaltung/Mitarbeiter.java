package MitarbeiterVerwaltung;

/**
 * 
 * @author julian
 *
 */
public class Mitarbeiter {
	
	protected int gehalt, adminnr;
	protected String iban, passwort;
	private int nutzernr;
	private String nachname;
	private String vorname;
	private String email;
	private String stra�e;
	private String ort;
	private int plz;
	private int berechtigung;
	
	/**
	 * Konstruktor zur Mitarbeiter Erstellung
	 * @param nutzernr
	 * @param adminnr
	 * @param nachname
	 * @param vorname
	 * @param email
	 * @param stra�e
	 * @param ort
	 * @param plz
	 * @param iban
	 * @param gehalt
	 * @param berechtigung
	 * @param passwort
	 */
	public Mitarbeiter(int nutzernr,int adminnr, String nachname, String vorname, String email, String stra�e, String ort, int plz, String iban, int gehalt, int berechtigung, String passwort) {
		this.nutzernr = nutzernr;
		this.adminnr = adminnr;
		this.nachname = nachname;
		this.vorname = vorname;
		this.email = email;
		this.stra�e = stra�e;
		this.ort = ort;
		this.plz = plz;
		this.iban = iban;
		this.gehalt = gehalt;
		this.berechtigung = berechtigung;
		this.passwort = passwort;
	}

	/**
	 * 
	 * @return gehalt
	 */
	public int getGehalt() {
		return gehalt;
	}

	/**
	 * setzt das Gehalt f�r einen Mitarbeiter
	 * @param gehalt
	 */
	public void setGehalt(int gehalt) {
		this.gehalt = gehalt;
	}

	/**
	 * 
	 * @return adminnr
	 */
	public int getAdminnr() {
		return adminnr;
	}

	/**
	 * Setzt die Adminnr f�r einen Mitarbeiter
	 * @param adminnr
	 */
	public void setAdminnr(int adminnr) {
		this.adminnr = adminnr;
	}

	/**
	 * 
	 * @return IBAN
	 */
	public String getIban() {
		return iban;
	}

	/**
	 * Setzt die IBAN f�r genau einen Mitarbetier
	 * @param iban
	 */
	public void setIban(String iban) {
		this.iban = iban;
	}

	/**
	 * 
	 * @return passwort
	 */
	public String getPasswort() {
		return passwort;
	}

	/**
	 * setzt das Passwort f�r genau einen Mitarbeiter
	 * @param passwort
	 */
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	/**
	 * 
	 * @return nutzernr
	 */
	public int getNutzernr() {
		return nutzernr;
	}

	/**
	 * Setzt die Nutzernr f�r genau einen Mitarbeiter
	 * @param nutzernr
	 */
	public void setNutzernr(int nutzernr) {
		this.nutzernr = nutzernr;
	}

	/**
	 * 
	 * @return nachname
	 */
	public String getNachname() {
		return nachname;
	}

	/**
	 * Setzt den Nachnamen f�r genau einen Mitarbeiter
	 * @param nachname
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	/**
	 * 
	 * @return vorname
	 */
	public String getVorname() {
		return vorname;
	}

	/**
	 * Setzt den Vornamen f�r genau einen Mitarbeiter
	 * @param vorname
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * setzt die Email f�r genau einen Mitarbeiter
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return stra�e
	 */
	public String getStra�e() {
		return stra�e;
	}

	/**
	 * Setzt die Stra�e f�r genau einen Mitarbeiter
	 * @param stra�e
	 */
	public void setStra�e(String stra�e) {
		this.stra�e = stra�e;
	}

	/**
	 * 
	 * @return Ort
	 */
	public String getOrt() {
		return ort;
	}

	/**
	 * Setzt den Ort f�r genau einen Mitarbeiter
	 * @param ort
	 */
	public void setOrt(String ort) {
		this.ort = ort;
	}

	/**
	 * 
	 * @return plz
	 */
	public int getPlz() {
		return plz;
	}

	/**
	 * setzt die PLZ f�r genau einen Mitarbeiter
	 * @param plz
	 */
	public void setPlz(int plz) {
		this.plz = plz;
	}

	/**
	 * 
	 * @return berechtigung
	 */
	public int getBerechtigung() {
		return berechtigung;
	}

	/**
	 * Setzt die Berechtigung f�r genau einen Mitarbeiter
	 * @param berechtigung
	 */
	public void setBerechtigung(int berechtigung) {
		this.berechtigung = berechtigung;
	}


}
