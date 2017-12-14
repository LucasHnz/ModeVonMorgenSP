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
	 * @param preis der Preis der ganzen Bestellposition.
	 *   ..
	 */
<<<<<<< HEAD
	public Bestellposition (int artnr, int bestand, String Bezeichnung, String Art, String Geschlecht, String Hersteller, String Verfï¿½gbarkeit, String Notiz, String[]  Lieferanten, double Preis, double Rabatt, int aMenge, int posNr){
		super(artnr, bestand, Bezeichnung, Art, Geschlecht, Hersteller, Verfï¿½gbarkeit,Notiz, Lieferanten, Preis, Rabatt);
=======
	public Bestellposition (Artikel aArtikel,int posNr,int aMenge) {
>>>>>>> branch 'master' of https://github.com/LucasHnz/ModeVonMorgenSP.git
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
	
<<<<<<< HEAD
	
	Artikel aArtikel= new Artikel(Artikelnummer, Bestand,Bezeichnung,Geschlecht,Hersteller, Verfï¿½gbarkeit, Notiz, Lieferanten,Preis,Rabatt);
	
=======
		
>>>>>>> branch 'master' of https://github.com/LucasHnz/ModeVonMorgenSP.git
}
