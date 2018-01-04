package Bestellverwaltung;


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
	protected int artikelnummer;
	protected boolean R�cksendung;
	
	

	/**
	 * @param posNr Die einzigartige Positionsnummer.
	 * @param aMenge Die Anzahl der Artikel der Bestellposition.
	 * @param preis der Preis der ganzen Bestellposition.
	 *  
	 */
	public Bestellposition (int posNr,int bestellNr, int artikelnummer, int aMenge, double preis, boolean r�cksendung) {
		this.aMenge=aMenge;
		this.posNr = posNr;
		this.artikelnummer = artikelnummer;
		this.bestellNr = bestellNr;
		//this.preis = Artikelsammlung.getArtikel(artikelnummer).getPreis() * (100 - Artikelsammlung.getArtikel(artikelnummer).getRabatt()  *0.01);
		this.preis = preis;
		this.R�cksendung = r�cksendung;
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
	public double getPreis() {
		return this.preis;
	}
	
	public int getAnummer() {
		return artikelnummer;
	}

	public int getBestellNr() {
		return bestellNr;
	}
	public boolean getR�cksendung(){
		return R�cksendung;
	}
	
	public void setR�cksendung(){
		this.R�cksendung = true;
	}

	public void setBestellNr(int bestellNr) {
		this.bestellNr = Datenbankverwaltung.holeN�chsteNummer.n�chsteBestellNr();
	}
	
		
}
