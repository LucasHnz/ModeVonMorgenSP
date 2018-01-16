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
	 * @param Rücksendung
	 *            Der Status, ob eine Bestellung zurück gesendet wurde oder nicht
	 **/

	public Bestellposition(int posNr, int bestellNr, int artikelnummer, int aMenge, double preis, String rücksendung) {

		this.aMenge = aMenge;
		this.posNr = posNr;
		this.artikelnummer = artikelnummer;
		this.bestellNr = bestellNr;
		this.preis = preis;
		this.Rücksendung = rücksendung;
	}

	/**
	 * gibt die Menge der Artikel zurück
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
	 * Gibt die Positionsnummer zurück
	 * @return posnr
	 */
	public int getPosNr() {
		return posNr;
	}

	/**
	 * Gibt den Preis zurück
	 * @return preis
	 */
	public double getPreis() {
		return this.preis;
	}

	/**
	 * Gibt die Artikelnummer zurück
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
	 * Gibt die Bestellnummer zurück
	 * @return bestellnr
	 */
	public int getBestellNr() {
		return bestellNr;
	}

	/**
	 * Gibt den Rücksende-Status zurück
	 * @return Rücksendung
	 */
	public String getRücksendung() {
		return Rücksendung;
	}

	/**
	 * Legt den Rücksende-Status fest
	 * @param Status
	 */
	public void setRücksendung(String Status) {
		this.Rücksendung = Status;
	}

}
