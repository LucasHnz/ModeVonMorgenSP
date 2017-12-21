package Rechnungsverwaltung;

import java.sql.Date;

/**
 * 
 * @author Bastian Walter
 *
 */


public class Rechnung {
	
	protected String name, nachname,straﬂe,ort,iban, vstatus;
	protected int mitgliedsID, rechnungNr, bestellNr, bestandskunde, gastkunde, plz;
	protected double gesamtpreis, zwischenpreis, eRabatt;
	protected Date datum;
	
	public Rechnung(String name, String nachname, String straﬂe, String ort, String iban, String vstatus, int mitgliedsID,
			int rechnungNr, int bestellNr, int bestandskunde, int gastkunde, int plz, double gesamtpreis,
			double zwischenpreis, double eRabatt, Date datum) {
		
		this.name = name;
		this.nachname = nachname;
		this.straﬂe=straﬂe;
		this.ort=ort;
		this.iban = iban;
		this.vstatus = vstatus;
		this.rechnungNr = rechnungNr;
		this.bestellNr = bestellNr;
		this.bestandskunde = bestandskunde;
		this.gastkunde = gastkunde;
		this.plz = plz;
		this.gesamtpreis = gesamtpreis;
		this.zwischenpreis = zwischenpreis;
		this.eRabatt = eRabatt;
		this.datum = datum;
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

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getVstatus() {
		return vstatus;
	}

	public void setVstatus(String vstatus) {
		this.vstatus = vstatus;
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

	public int getBestellNr() {
		return bestellNr;
	}

	public void setBestellNr(int bestellNr) {
		this.bestellNr = bestellNr;
	}

	public int getBestandskunde() {
		return bestandskunde;
	}

	public void setBestandskunde(int bestandskunde) {
		this.bestandskunde = bestandskunde;
	}

	public int getGastkunde() {
		return gastkunde;
	}

	public void setGastkunde(int gastkunde) {
		this.gastkunde = gastkunde;
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

	public double getZwischenpreis() {
		return zwischenpreis;
	}

	public void setZwischenpreis(double zwischenpreis) {
		this.zwischenpreis = zwischenpreis;
	}

	public double geteRabatt() {
		return eRabatt;
	}

	public void seteRabatt(double eRabatt) {
		this.eRabatt = eRabatt;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		 this.datum = new Date( datum.getTime() );
	}
	
	

}
