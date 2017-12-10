package Bestellverwaltung;

import java.util.ArrayList;

import Bestellverwaltung.Bestellposition;
/**
 * 
 * @author annag
 *
 */
public class Bestellung  {
	protected double datum;
	protected int bNr;
	protected String versandStatus; 
	protected double gPreis;
	/**
	 * @param datum Eingangsdatum der Bestellung.
	 * @param bNr Die einzigartige Bestellnummer der Bestellung.
	 * @param versandStatus Der Status der Bestellung.
	 * @param gPreis Der gesammte Preis der Bestellung.
	 * 
	 */
	public Bestellung (double datum, int bNr, double gPreis, String versandStatus) {
		
		this.datum=datum;
		this.bNr=bNr;
		this.versandStatus=versandStatus;
		this.gPreis=gPreis;

		}
	Bestellposition bBestellposition= new Bestellposition();
	ArrayList<Bestellposition> test =new ArrayList<Bestellposition>();
	
	public double getDatum() {
		return datum;
	}
	public void setDatum(double datum) {
		this.datum = datum;
	}
	public int getbNr() {
		return bNr;
	}
	public void setbNr(int bNr) {
		this.bNr = bNr;
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
		int gpreis=0;
		for ( int i=0; i>test.size() ; i++){					
			gpreis=gpreis + bBestellposition.getPreis();
		}
				
	}

	
	
}
