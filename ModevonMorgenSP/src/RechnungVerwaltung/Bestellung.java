package RechnungVerwaltung;

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

	public int getNutzernrgk() {
		return nutzernrgk;
	}

	public void setNutzernrgk(int nutzernrgk) {
		this.nutzernrgk = nutzernrgk;
	}

	public int getRechnungsnr() {
		return rechnungsnr;
	}

	public void setRechnungsnr(int rechnungsnr) {
		this.rechnungsnr = rechnungsnr;
	}

	public int getBestellnr() {
		return bestellnr;
	}

	public void setBestellnr(int bestellnr) {
		this.bestellnr = bestellnr;
	}

	public int getNutzernrbk() {
		return nutzernrbk;
	}

	public void setNutzernrbk(int nutzernr) {
		this.nutzernrbk = nutzernr;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
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

	public int getErabatt() {
		return erabatt;
	}

	public void setErabatt(int erabatt) {
		this.erabatt = erabatt;
	}

	public double getGesamtpreis() {
		return gesamtpreis;
	}

	public void setGesamtpreis(double gesamtpreis) {
		this.gesamtpreis = gesamtpreis;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getVersandstatus() {
		return versandstatus;
	}

	public void setVersandstatus(String versandstatus) {
		this.versandstatus = versandstatus;
	}

	public String getRechnungsort() {
		return rechnungsort;
	}

	public void setRechnungsort(String rechnungsort) {
		this.rechnungsort = rechnungsort;
	}

	public String getRechnungsstrasse() {
		return rechnungsstrasse;
	}

	public void setRechnungsstrasse(String rechnungsstrasse) {
		this.rechnungsstrasse = rechnungsstrasse;
	}

	public int getRechnungsplz() {
		return rechnungsplz;
	}

	public void setRechnungsplz(int rechnungsplz) {
		this.rechnungsplz = rechnungsplz;
	}

}
