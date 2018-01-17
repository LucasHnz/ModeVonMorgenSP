package KundenVerwaltung;

/**
 * 
 * @author Julian
 *
 */
public class Gastkunde {
	
	private int nutzernr;
	private String nachname;
	private String vorname;
	private String email;
	private String stra�e;
	private String ort;
	private int plz;
	private int berechtigung;
	private String iban;


	/**
	 * Konstruktor f�r einen Gastkunden
	 * @param nutzernr
	 * @param nachname
	 * @param vorname
	 * @param email
	 * @param stra�e
	 * @param ort
	 * @param plz
	 * @param berechtigung
	 * @param iban
	 */
	public Gastkunde(int nutzernr, String nachname, String vorname, String email, String stra�e, String ort, int plz, int berechtigung, String iban) {
		this.nutzernr = nutzernr;
		this.nachname = nachname;
		this.vorname = vorname;
		this.email = email;
		this.stra�e = stra�e;
		this.ort = ort;
		this.plz = plz;
		this.berechtigung = berechtigung;
		this.iban= iban;
	}

	@Override
	public String toString() {
		return "Gastkunde [nutzernr=" + nutzernr + ", nachname=" + nachname + ", vorname=" + vorname + ", email="
				+ email + ", stra�e=" + stra�e + ", ort=" + ort + ", plz=" + plz + ", berechtigung=" + berechtigung
				+ ", iban=" + iban + "]";
	}

	public int getNutzernr() {
		return nutzernr;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public void setNutzernr(int nutzernr) {
		this.nutzernr =Datenbankverwaltung.holeN�chsteNummer.n�chsteGKundenNr();
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

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

	public String getStra�e() {
		return stra�e;
	}

	public void setStra�ee(String stra�e) {
		this.stra�e =stra�e;
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

	public int getBerechtigung() {
		return berechtigung;
	}

	/**
	 * E-Mail mit betreff "Bier" an hinz.lucas@gmx.de, f�r einen Kasten Bier!
	 * @param berechtigung
	 */
	public void setBerechtigung(int berechtigung) {
		this.berechtigung = berechtigung;
	}

}
