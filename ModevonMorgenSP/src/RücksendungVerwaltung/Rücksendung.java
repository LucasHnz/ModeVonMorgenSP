package R�cksendungVerwaltung;

/**
 * 
 * @author julian
 *
 */
public class R�cksendung {
	
	private int r�cksendenr;
	private int bestellposnr;
	private int bestellnr;
	private String datum;
	
	/**
	 * Konstruktor f�r die Erstellung einer R�cksendung
	 * @param r�cksendenr
	 * @param bestellposnr
	 * @param bestellnr
	 * @param datum
	 */
	public R�cksendung(int r�cksendenr, int bestellposnr, int bestellnr, String datum) {
		this.r�cksendenr = r�cksendenr;
		this.bestellposnr = bestellposnr;
		this.bestellnr = bestellnr;
		this.datum = datum;
	}

	/**
	 * @return r�cksendenr
	 */
	public int getR�cksendenr() {
		return r�cksendenr;
	}

	/**
	 * Setzt die R�cksendenummer
	 * @param r�cksendenr
	 */
	public void setR�cksendenr(int r�cksendenr) {
		this.r�cksendenr = r�cksendenr;
	}

	/**
	 * 
	 * @return bestellposnr
	 */
	public int getBestellposnr() {
		return bestellposnr;
	}

	/**
	 * Setzt die Bestellpositionsnummer f�r genau eine R�cksendung
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
	 * Setzt das Datum einer R�cksendung
	 * @param datum
	 */
	public void setDatum(String datum) {
		this.datum = datum;
	}
	
	

}
