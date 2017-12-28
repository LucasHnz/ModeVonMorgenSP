package AdministratorVerwaltung;
/**
 * 
 * @author julian
 *
 */
public class Administrator {
	
	private int nutzernr;
	private String nachname;
	private String vorname;
	private String email;
	private String stra�e;
	private String ort;
	private int plz;
	private String iban;
	private int gehalt;
	private int berechtigumg;
	private String passwort;

	/**
	 * Konstruktor
	 * @param nutzernr
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
	public Administrator(int nutzernr, String nachname, String vorname, String email, String stra�e, String ort, int plz, String iban, int gehalt, int berechtigung, String passwort){
		this.nutzernr = nutzernr;
		this.nachname = nachname;
		this.vorname = vorname;
		this.email = email;
		this.stra�e = stra�e;
		this.ort = ort;
		this.plz = plz;
		this.iban = iban;
		this.gehalt = gehalt;
		this.berechtigumg = berechtigung;
		this.passwort = passwort;
	}

	/**
	 * @return Administrator Values als String
	 */
	@Override
	public String toString() {
		return "Administrator [nutzernr=" + nutzernr + ", nachname=" + nachname + ", vorname=" + vorname + ", email="
				+ email + ", stra�e=" + stra�e + ", ort=" + ort + ", plz=" + plz + ", iban=" + iban + ", gehalt="
				+ gehalt + ", berechtigumg=" + berechtigumg + ", passwort=" + passwort + "]";
	}

	/**
	 * 
	 * @return nutzernr
	 */
	public int getNutzernr() {
		return nutzernr;
	}

	/**
	 * 
	 * @param nutzernr
	 * setzt die nutzernr eines Admins
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
	 * 
	 * @param nachname
	 * setzt den nachnamen eines Admins
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
	 * 
	 * @param vorname
	 * setzt den vornamen f�r einen Admin
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
	 * 
	 * @param email
	 * setzt die Email f�r einen Admin
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
	 * 
	 * @param stra�e
	 * setzt die Stra�e f�r einen Admin
	 */
	public void setStra�e(String stra�e) {
		this.stra�e = stra�e;
	}

	/**
	 * 
	 * @return ort
	 */
	public String getOrt() {
		return ort;
	}

	/**
	 * 
	 * @param ort
	 * setzt den Ort f�r einen Admin
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
	 * 
	 * @param plz
	 * setzt die PLZ f�r einen Admin
	 */
	public void setPlz(int plz) {
		this.plz = plz;
	}

	/**
	 * 
	 * @return IBAN
	 */
	public String getIban() {
		return iban;
	}

	/**
	 * 
	 * @param iban
	 * setzt die IBAN f�r einen Admin
	 */
	public void setIban(String iban) {
		this.iban = iban;
	}

	/**
	 * 
	 * @return gehalt
	 */
	public int getGehalt() {
		return gehalt;
	}

	/**
	 * 
	 * @param gehalt
	 * setzt das Gehalt f�r einen Admin
	 */
	public void setGehalt(int gehalt) {
		this.gehalt = gehalt;
	}

	/**
	 * 
	 * @return berechtigung
	 */
	public int getBerechtigumg() {
		return berechtigumg;
	}

	/**
	 * 
	 * @param berechtigumg
	 * setzt die berechtigung f�r einen Admin
	 */
	public void setBerechtigumg(int berechtigumg) {
		this.berechtigumg = berechtigumg;
	}

	/**
	 * 
	 * @return passwort
	 */
	public String getPasswort() {
		return passwort;
	}

	/**
	 * 
	 * @param passwort
	 * setzt das Passwort f�r einen Admin
	 */
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
		
}
	
