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
	 * 
	 * @param posnr
	 *            Die einzigartige Nummer der Position
	 * @param bestellnr
	 *            Die Nummer der Bestellung in der die Posistion enthalten ist
	 * @param artikelnummer
	 *            Die Nummer des Artikels der in der Bestellposition gespeichert ist
	 * @param aMenge
	 *            Die Anzahl eines Artikels der in der Bestellposition ist
	 * @param preis
	 *            Der preis einer Bestellposition
	 * @param R�cksendung
	 *            Der Status, ob eine Bestellung zur�ck gesendet wurde oder nicht
	 **/

	public Bestellposition(int posNr, int bestellNr, int artikelnummer, int aMenge, double preis, String r�cksendung) {

		this.aMenge = aMenge;
		this.posNr = posNr;
		this.artikelnummer = artikelnummer;
		this.bestellNr = bestellNr;
		this.preis = preis;
		this.R�cksendung = r�cksendung;
	}

	/**
	 * gibt die Menge der Artikel zur�ck
	 * @return aMenge
	 */

	public int getaMenge() {
		return aMenge;
	}

	/**
	 * Legt die Menge fest
	 * @param aMenge
	 */
	public void setaMenge(int aMenge) {
		this.aMenge = aMenge;
	}

	/**
	 * Gibt die Positionsnummer zur�ck
	 * @return posnr
	 */
	public int getPosNr() {
		return posNr;
	}

	/**
	 * Gibt den Preis zur�ck
	 * @return preis
	 */
	public double getPreis() {
		return this.preis;
	}

	/**
	 * Gibt die Artikelnummer zur�ck
	 * @return artikelnummer
	 */
	public int getArtikelnummer() {
		return artikelnummer;
	}

	/**
	 * Legt die Positionsnummer fest
	 * @param posNr
	 */
	public void setPosNr(int posNr) {
		this.posNr = posNr;
	}

	/**
	 * Gibt die Bestellnummer zur�ck
	 * @return bestellnr
	 */
	public int getBestellNr() {
		return bestellNr;
	}

	/**
	 * Gibt den R�cksende-Status zur�ck
	 * @return R�cksendung
	 */
	public String getR�cksendung() {
		return R�cksendung;
	}

	/**
	 * Legt den R�cksende-Status fest
	 * @param Status
	 */
	public void setR�cksendung(String Status) {
		this.R�cksendung = Status;
	}

}
