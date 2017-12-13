package Bestellverwaltung;

import java.util.ArrayList;
import java.util.Date;

import Bestellverwaltung.Bestellposition;
/**
 * 
 * @author annag
 *
 */
public class Bestellung  {
	protected date datum;
	protected int nutzerNrBestandsK;
	protected int nutzerNrGastK;
	protected int bestellNr;
	protected String versandStatus; 
	protected double gPreis;
	/**
	 * @param datum Eingangsdatum der Bestellung.
	 * @param nutzerNrBestandK Die Nummer des Bestandskundes der die Bestellung tätigt. Kann auch null sein.
	 * @param nutzerNrGastK Die Nummer des Gastkundes der die Bestellung tätigt. Kann auch null sein.
	 * @param bestellNr Die einzigartige Nummer der Bestellung
	 * @param versandStatus Der Status der Bestellung.
	 * @param gPreis Der gesammte Preis der Bestellung.
	 * 
	 */
	public Bestellung (date datum,int nutzerNrBestandsK,int nutzerNrGastK, int bestellNr, double gPreis, String versandStatus) {
		
		this.datum=datum;
		this.nutzerNrBestandsK=nutzerNrBestandsK;
		this.nutzerNrGastK=nutzerNrGastK;
		this.bestellNr=bestellNr;
		this.versandStatus=versandStatus;
		this.gPreis=gPreis;

		}
	Bestellposition bBestellposition= new Bestellposition();
	ArrayList<Bestellposition> test = new ArrayList<Bestellposition>();
	
	
	public date getDatum() {
		return datum;
	}
	public void setDatum(date datum) {
		this.datum = datum;
	}
	public int getNutzerNrBestandsK() {
		return nutzerNrBestandsK;
	}
	public void setNutzerNrBestandsK(int nutzerNrBestandsK) {
		this.nutzerNrBestandsK = nutzerNrBestandsK;
	}
	public int getNutzerNrGastK() {
		return nutzerNrGastK;
	}
	public void setNutzerNrGastK(int nutzerNrGastK) {
		this.nutzerNrGastK = nutzerNrGastK;
	}
	public int getBestellNr() {
		return bestellNr;
	}
	public void setBestellNr(int bestellNr) {
		this.bestellNr = bestellNr;
	}
	public String getVersandStatus() {
		return versandStatus;
	}
	public void setVersandStatus(String versandStatus) {
		this.versandStatus = versandStatus;
	}
	public double getgPreis() {
		return gPreis;
	}
	public void setgPreis(double gPreis) {
		double gpreis=0;
		for ( int i=0; i>test.size() ; i++){				
			gpreis=gpreis+ bBestellposition.getPreis();
		}
				
	}
// Bestellung mit bestellpositionen füllen ?
	// das mit dem Datum bearbeiten/erarbeiten
	
	
	
}
