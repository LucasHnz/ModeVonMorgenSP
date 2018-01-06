package Bestellverwaltung2;


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
	protected String R�cksendung;

	/**
	 * @param posNr Die einzigartige Positionsnummer.
	 * @param aMenge Die Anzahl der Artikel der Bestellposition.
	 * @param preis der Preis der ganzen Bestellposition.
	 *  
	 */

	public Bestellposition (int posNr,int bestellNr, int artikelnummer, int aMenge, double preis, String r�cksendung) {

		this.aMenge=aMenge;
		this.posNr = posNr;
		this.artikelnummer = artikelnummer;
		this.bestellNr = bestellNr;
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
	public int getArtikelnummer() {
		return artikelnummer;
	}
	public void setPosNr(int posNr) {
		this.posNr = posNr;
	}
	public int getBestellNr() {
		return bestellNr;
	}
	public void setBestellNr(int bestellNr) {
		this.bestellNr = Datenbankverwaltung.holeN�chsteNummer.n�chsteBestellNr();
	}
	public String getR�cksendung() {
		return R�cksendung;
	}
	public void setR�cksendung(String Status){
		this.R�cksendung = Status;
	}
	
}
