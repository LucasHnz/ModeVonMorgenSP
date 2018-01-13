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
	protected String R�cksendung;

	/**
	 * Konstruktor
	 * @param posnr
	 * @param bestellnr
	 * @param artikelnummer
	 * @param aMenge
	 * @param preis
	 * @param R�cksendung
	 **/

	public Bestellposition (int posNr,int bestellNr, int artikelnummer, int aMenge, double preis, String r�cksendung) {

		this.aMenge=aMenge;
		this.posNr = posNr;
		this.artikelnummer = artikelnummer;
		this.bestellNr = bestellNr;
		this.preis = preis;
		this.R�cksendung = r�cksendung;
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
	 * @param bestellNr
	 */
	public void setBestellNr(int bestellNr) {
		this.bestellNr = Datenbankverwaltung.holeN�chsteNummer.n�chsteBestellNr();
	}
	/**
	 * 
	 * @return R�cksendung
	 */
	public String getR�cksendung() {
		return R�cksendung;
	}
	/**
	 * 
	 * @param Status
	 */
	public void setR�cksendung(String Status){
		this.R�cksendung = Status;
	}
	
}
