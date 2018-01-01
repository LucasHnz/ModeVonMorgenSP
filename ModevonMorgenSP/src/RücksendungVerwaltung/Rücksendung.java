package RücksendungVerwaltung;

public class Rücksendung {
	
	private int rücksendenr;
	private int bestellposnr;
	private int bestellnr;
	private String datum;
	
	public Rücksendung(int rücksendenr, int bestellposnr, int bestellnr, String datum) {
		this.rücksendenr = rücksendenr;
		this.bestellposnr = bestellposnr;
		this.bestellnr = bestellnr;
		this.datum = datum;
	}

	public int getRücksendenr() {
		return rücksendenr;
	}

	public void setRücksendenr(int rücksendenr) {
		this.rücksendenr = rücksendenr;
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
