package AdministratorVerwaltung;

public class Administrator {
	
	private int nutzernr;
	private String nachname;
	private String vorname;
	private String email;
	private String straße;
	private String ort;
	private int plz;
	private String iban;
	private int gehalt;
	private int berechtigumg;
	private String passwort;

	public Administrator(int nutzernr, String nachname, String vorname, String email, String straße, String ort, int plz, String iban, int gehalt, int berechtigung, String passwort){
		this.nutzernr = nutzernr;
		this.nachname = nachname;
		this.vorname = vorname;
		this.email = email;
		this.straße = straße;
		this.ort = ort;
		this.plz = plz;
		this.iban = iban;
		this.gehalt = gehalt;
		this.berechtigumg = berechtigung;
		this.passwort = passwort;
	}

	@Override
	public String toString() {
		return "Administrator [nutzernr=" + nutzernr + ", nachname=" + nachname + ", vorname=" + vorname + ", email="
				+ email + ", straße=" + straße + ", ort=" + ort + ", plz=" + plz + ", iban=" + iban + ", gehalt="
				+ gehalt + ", berechtigumg=" + berechtigumg + ", passwort=" + passwort + "]";
	}

	public int getNutzernr() {
		return nutzernr;
	}

	public void setNutzernr(int nutzernr) {
		this.nutzernr = nutzernr;
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

	public String getStraße() {
		return straße;
	}

	public void setStraße(String straße) {
		this.straße = straße;
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

	public int getGehalt() {
		return gehalt;
	}

	public void setGehalt(int gehalt) {
		this.gehalt = gehalt;
	}

	public int getBerechtigumg() {
		return berechtigumg;
	}

	public void setBerechtigumg(int berechtigumg) {
		this.berechtigumg = berechtigumg;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
		
}
	
