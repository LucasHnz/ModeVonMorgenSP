package BestellungVerwaltung;

import java.sql.Date;


/**
 * 
 * @author julian
 *
 */
public class Bestellung {
	
	private int rechnungsnr;
	private int bestellnr;
	private int nutzernrbk;
	private int nutzernrgk;
	private String iban;
	private String nachname;
	private String vorname;
	private int erabatt;
	private double gesamtpreis;
	private Date datum;
	private String versandstatus;
	private String rechnungsort;
	private String rechnungsstrasse;
	private int rechnungsplz;

	/**
	 * Konstruktor für die Erstellung einer Bestellung
	 * @param rechnungsnr
	 * @param bestellnr
	 * @param nutzernrbk
	 * @param nutzernrgk
	 * @param iban
	 * @param nachname
	 * @param vorname
	 * @param gesamtpreis
	 * @param erabatt
	 * @param datum
	 * @param versandstatus
	 * @param Rechnungsort
	 * @param Rechnungsstrasse
	 * @param Rechnungsplz
	 */
	public Bestellung(int rechnungsnr, int bestellnr, int nutzernrbk,int nutzernrgk, String iban, String nachname, String vorname, double gesamtpreis, int erabatt, Date datum, String versandstatus, String Rechnungsort, String Rechnungsstrasse, int Rechnungsplz) {
		this.rechnungsnr = rechnungsnr;
		this.bestellnr = bestellnr;
		this.nutzernrbk = nutzernrbk;
		this.nutzernrgk = nutzernrgk;
		this.iban = iban;
		this.nachname = nachname;
		this.vorname = vorname;
		this.gesamtpreis = gesamtpreis;
		this.erabatt = erabatt;
		this.datum = datum;
		this.versandstatus = versandstatus;
		this.rechnungsort = Rechnungsort;
		this.rechnungsstrasse = Rechnungsstrasse;
		this.rechnungsplz = Rechnungsplz;
	}

	/**
	 * 
	 * @return nutzernrgk
	 */
	public int getNutzernrgk() {
		return nutzernrgk;
	}

	/**
	 * setzt die NutzernrGK für eine Bestellung
	 * @param nutzernrgk
	 */
	public void setNutzernrgk(int nutzernrgk) {
		this.nutzernrgk = nutzernrgk;
	}

	/**
	 * 
	 * @return rechnungsnr
	 */
	public int getRechnungsnr() {
		return rechnungsnr;
	}

	/**
	 * setzt die Rechnungsnr für genau eine Bestellung
	 * @param rechnungsnr
	 */
	public void setRechnungsnr(int rechnungsnr) {
		this.rechnungsnr = rechnungsnr;
	}

	/**
	 * 
	 * @return bestellnr
	 */
	public int getBestellnr() {
		return bestellnr;
	}

	/**
	 * Setzt die Bestellnr für genau eine Bestellung
	 * @param bestellnr
	 */
	public void setBestellnr(int bestellnr) {
		this.bestellnr = bestellnr;
	}

	/**
	 * 
	 * @return nutuzernrbk
	 */
	public int getNutzernrbk() {
		return nutzernrbk;
	}

	/**
	 * setzt die Nutzernrbk für genau eine Bestellung
	 * @param nutzernr
	 */
	public void setNutzernrbk(int nutzernr) {
		this.nutzernrbk = nutzernr;
	}

	/**
	 * 
	 * @return iban
	 */
	public String getIban() {
		return iban;
	}

	/**
	 * 
	 * @param iban
	 */
	public void setIban(String iban) {
		this.iban = iban;
	}

	/**
	 * 
	 * @return nachname
	 */
	public String getNachname() {
		return nachname;
	}

	/**
	 * setzt den Nachnamen für genau eine Bestellung
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
	 * Setzt den Vornamen für genau eine Bestellung
	 * @param vorname
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * 
	 * @return Erabatt
	 */
	public int getErabatt() {
		return erabatt;
	}

	/**
	 * setzt den eingesetzten Rabatt für genau eine Bestellung
	 * @param erabatt
	 */
	public void setErabatt(int erabatt) {
		this.erabatt = erabatt;
	}

	/**
	 * 
	 * @return gesamtpreis
	 */
	public double getGesamtpreis() {
		return gesamtpreis;
	}

	/**
	 * Setzt den Gesamtpreis für eine Bestellung
	 * @param gesamtpreis
	 */
	public void setGesamtpreis(double gesamtpreis) {
		this.gesamtpreis = gesamtpreis;
	}

	/**
	 * 
	 * @return datum
	 */
	public Date getDatum() {
		return datum;
	}

	/**
	 * Setzt das Datum für genau eine Bestellung
	 * @param datum
	 */
	public void setDatum(Date datum) {
		this.datum = datum;
	}

	/**
	 * 
	 * @return versandstatus
	 */
	public String getVersandstatus() {
		return versandstatus;
	}

	/**
	 * setzt den Versandstatus für genau eine Bestellung
	 * @param versandstatus
	 */
	public void setVersandstatus(String versandstatus) {
		this.versandstatus = versandstatus;
	}

	/**
	 * 
	 * @return rechnungsort
	 */
	public String getRechnungsort() {
		return rechnungsort;
	}

	/**
	 * Setzt den Rechnungsort für genau eine Bestellung
	 * @param rechnungsort
	 */
	public void setRechnungsort(String rechnungsort) {
		this.rechnungsort = rechnungsort;
	}

	/**
	 * 
	 * @return rechnungsstrasse
	 */
	public String getRechnungsstrasse() {
		return rechnungsstrasse;
	}

	/**
	 * Setzt die Rechnungsstrasse
	 * @param rechnungsstrasse
	 */
	public void setRechnungsstrasse(String rechnungsstrasse) {
		this.rechnungsstrasse = rechnungsstrasse;
	}

	/**
	 * 
	 * @return rechnungsplz
	 */
	public int getRechnungsplz() {
		return rechnungsplz;
	}

	/**
	 * Setzt die Rechnungsplz für genau eine Bestellung
	 * @param rechnungsplz
	 */
	public void setRechnungsplz(int rechnungsplz) {
		this.rechnungsplz = rechnungsplz;
	}

}
