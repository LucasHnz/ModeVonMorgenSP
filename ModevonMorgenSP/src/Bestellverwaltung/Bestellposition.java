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
	protected String Rücksendung;

	/**
	 * Konstruktor
	 * @param posnr
	 * @param bestellnr
	 * @param artikelnummer
	 * @param aMenge
	 * @param preis
	 * @param Rücksendung
	 **/

	public Bestellposition (int posNr,int bestellNr, int artikelnummer, int aMenge, double preis, String rücksendung) {

		this.aMenge=aMenge;
		this.posNr = posNr;
		this.artikelnummer = artikelnummer;
		this.bestellNr = bestellNr;
		this.preis = preis;
		this.Rücksendung = rücksendung;
	}
	
	/**
	 * 
	 * @return aMenge
	 */
	
	public int getaMenge() {
		return aMenge;
	}
	
	/**
	 * 
	 * @param aMenge
	 */
	public void setaMenge(int aMenge) {
		this.aMenge = aMenge;
	}
	/**
	 * @return posnr
	 */
	public int getPosNr(){
		return posNr;
	}
	/**
	 * 
	 * @return preis
	 */
	public double getPreis() {
		return this.preis;
	}
	/**
	 * 
	 * @return artikelnummer
	 */
	public int getArtikelnummer() {
		return artikelnummer;
	}
	/**
	 * 
	 * @param posNr
	 */
	public void setPosNr(int posNr) {
		this.posNr = posNr;
	}
	/**
	 * 
	 * @return bestellnr
	 */
	public int getBestellNr() {
		return bestellNr;
	}
	/**
	 * 
	 * @return Rücksendung
	 */
	public String getRücksendung() {
		return Rücksendung;
	}
	/**
	 * 
	 * @param Status
	 */
	public void setRücksendung(String Status){
		this.Rücksendung = Status;
	}
	
}
