package Bestellverwaltung;

import Artikelverwaltung.Artikel;
/**
 * 
 * @author annag
 *
 */

public class Bestellposition extends Artikel {
	
	protected int aMenge; 
	protected int posNr;
	
	/**
	 * @param posNr Die einzigartige Positionsnummer.
	 * @param aMenge Die Anzahl der Artikel der Bestellposition.
	 * 
	 */
	public Bestellposition ( Artikelnummer, Bestand, Bezeichnung, Geschlecht, Hersteller, Verfügbarkeit, Notiz, Lieferanten, Preis, Rabatt){
		
		this.aMenge=aMenge;
		this.posNr=posNr;
	}
	
	public int getaMenge() {
		return aMenge;
	}
	public void setaMenge(int aMenge) {
		this.aMenge = aMenge;
	}
	public int getPosNr() {
		return posNr;
	}
	public void setPosNr(int posNr) {
		this.posNr = posNr;
	}
	public double getPreis() {
		return this.Preis;
	}
	public void setPreis(double preis) {
		this.Preis = aArtikel.getPreis()*aMenge;
	}
	public Artikel getaArtikel() {
		return aArtikel;
	}
	public void setaArtikel(Artikel aArtikel) {
		this.aArtikel = aArtikel;
	}
	
	
	Artikel aArtikel= new Artikel(Artikelnummer, Bestand,Bezeichnung,Geschlecht,Hersteller, Verfügbarkeit, Notiz, Lieferanten,Preis,Rabatt);
	
}
