package Bestellverwaltung;

import Artikelverwaltung.Artikel;
/**
 * 
 * @author annag
 *
 */

public class Bestellposition {
	protected double preis;
	protected int aMenge; 
	protected int posNr;
	protected int bestellNr;
	protected Artikel aArtikel;
	
	

	/**
	 * @param posNr Die einzigartige Positionsnummer.
	 * @param aMenge Die Anzahl der Artikel der Bestellposition.
	 * @param preis der Preis der ganzen Bestellposition
	 *   ..
	 */
	public Bestellposition (Artikel aArtikel,int posNr,int aMenge) {
		this.aMenge=aMenge;
		this.posNr=posNr;
		this.aArtikel=aArtikel;
		
	}
	
	public int getaMenge() {
		return aMenge;
	}
	public void setaMenge(int aMenge) {
		this.aMenge = aMenge;
	}
	public int getPosNr(){
		return posNr;
	}
	public void setPosNr(int posNr) {
		this.posNr = Datenbankverwaltung.holeNächsteNummer.nächsteBestellPosNr();
	}
	public double getPreis() {
		return this.preis;
	}
	public void setPreis(double preis) {
		this.preis = aArtikel.getPreis()*aMenge;
	}

	public int getBestellNr() {
		return bestellNr;
	}

	public void setBestellNr(int bestellNr) {
		this.bestellNr = Datenbankverwaltung.holeNächsteNummer.nächsteBestellNr();
	}
	
		
}
