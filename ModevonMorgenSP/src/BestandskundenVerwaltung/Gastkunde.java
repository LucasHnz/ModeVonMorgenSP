package BestandskundenVerwaltung;

public class Gastkunde {
	
	private int nutzernr;
	private String nachname;
	private String vorname;
	private String email;
	private String straße;
	private String ort;
	private int plz;
	private int berechtigung;

	public Gastkunde(int nutzernr, String nachname, String vorname, String email, String straße, String ort, int plz, int berechtigung) {
		this.nutzernr = nutzernr;
		this.nachname = nachname;
		this.vorname = vorname;
		this.email = email;
		this.straße = straße;
		this.ort = ort;
		this.plz = plz;
		this.berechtigung = berechtigung;
	}

	@Override
	public String toString() {
		return "Gastkunde [nutzernr=" + nutzernr + ", nachname=" + nachname + ", vorname=" + vorname + ", email="
				+ email + ", straße=" + straße + ", ort=" + ort + ", plz=" + plz + ", berechtigung=" + berechtigung
				+ "]";
	}

	public int getNutzernr() {
		return nutzernr;
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

	public String getStraße() {
		return straße;
	}

	public void setStraße(String straße) {
		this.straße =straße;
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

	public void setBerechtigung(int berechtigung) {
		this.berechtigung = berechtigung;
	}

}
