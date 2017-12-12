package Rechnungsverwaltung;

/**
 * 
 * @author Bastian Walter
 *
 */


public class Rechnung {
	
	protected String name, nachname, ort, straﬂe, iban;
	protected int mitgliedsID, rechnungNr, plz;
	protected double gesamtpreis, bRabatt;
	
	
	public Rechnung(String name, String nachname, String ort, String straﬂe, String iban, int mitgliedsID,
			int rechnungNr, int plz, double gesamtpreis, double bRabatt) {
		
		this.name = name;
		this.nachname = nachname;
		this.ort = ort;
		this.straﬂe = straﬂe;
		this.iban = iban;
		this.mitgliedsID = mitgliedsID;
		this.rechnungNr = rechnungNr;
		this.plz = plz;
		this.gesamtpreis = gesamtpreis;
		this.bRabatt = bRabatt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getStraﬂe() {
		return straﬂe;
	}

	public void setStraﬂe(String straﬂe) {
		this.straﬂe = straﬂe;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public int getMitgliedsID() {
		return mitgliedsID;
	}

	public void setMitgliedsID(int mitgliedsID) {
		this.mitgliedsID = mitgliedsID;
	}

	public int getRechnungNr() {
		return rechnungNr;
	}

	public void setRechnungNr(int rechnungNr) {
		this.rechnungNr = rechnungNr;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public double getGesamtpreis() {
		return gesamtpreis;
	}

	public void setGesamtpreis(double gesamtpreis) {
		this.gesamtpreis = gesamtpreis;
	}

	public double getbRabatt() {
		return bRabatt;
	}

	public void setbRabatt(double bRabatt) {
		this.bRabatt = bRabatt;
	}

}
