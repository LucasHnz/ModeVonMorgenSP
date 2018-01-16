package RücksendungVerwaltung;

/**
 * 
 * @author julian
 *
 */
public class Rücksendung {
	
	private int rücksendenr;
	private int bestellposnr;
	private int bestellnr;
	private String datum;
	
	/**
	 * Konstruktor für die Erstellung einer Rücksendung
	 * @param rücksendenr
	 * @param bestellposnr
	 * @param bestellnr
	 * @param datum
	 */
	public Rücksendung(int rücksendenr, int bestellposnr, int bestellnr, String datum) {
		this.rücksendenr = rücksendenr;
		this.bestellposnr = bestellposnr;
		this.bestellnr = bestellnr;
		this.datum = datum;
	}

	/**
	 * @return rücksendenr
	 */
	public int getRücksendenr() {
		return rücksendenr;
	}

	/**
	 * Setzt die Rücksendenummer
	 * @param rücksendenr
	 */
	public void setRücksendenr(int rücksendenr) {
		this.rücksendenr = rücksendenr;
	}

	/**
	 * 
	 * @return bestellposnr
	 */
	public int getBestellposnr() {
		return bestellposnr;
	}

	/**
	 * Setzt die Bestellpositionsnummer für genau eine Rücksendung
	 * @param bestellposnr
	 */
	public void setBestellposnr(int bestellposnr) {
		this.bestellposnr = bestellposnr;
	}

	/**
	 * 
	 * @return bestellnr
	 */
	public int getBestellnr() {
		return bestellnr;
	}

	/**
	 * 
	 * @param bestellnr
	 */
	public void setBestellnr(int bestellnr) {
		this.bestellnr = bestellnr;
	}

	/**
	 * 
	 * @return datum
	 */
	public String getDatum() {
		return datum;
	}

	/**
	 * Setzt das Datum einer Rücksendung
	 * @param datum
	 */
	public void setDatum(String datum) {
		this.datum = datum;
	}
	
	

}
