package R�cksendungVerwaltung;

public class R�cksendung {
	
	private int r�cksendenr;
	private int bestellposnr;
	private int bestellnr;
	private String datum;
	
	public R�cksendung(int r�cksendenr, int bestellposnr, int bestellnr, String datum) {
		this.r�cksendenr = r�cksendenr;
		this.bestellposnr = bestellposnr;
		this.bestellnr = bestellnr;
		this.datum = datum;
	}

	public int getR�cksendenr() {
		return r�cksendenr;
	}

	public void setR�cksendenr(int r�cksendenr) {
		this.r�cksendenr = r�cksendenr;
	}

	public int getBestellposnr() {
		return bestellposnr;
	}

	public void setBestellposnr(int bestellposnr) {
		this.bestellposnr = bestellposnr;
	}

	public int getBestellnr() {
		return bestellnr;
	}

	public void setBestellnr(int bestellnr) {
		this.bestellnr = bestellnr;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}
	
	

}
