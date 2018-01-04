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
<<<<<<< HEAD
	protected boolean Rücksendung;
=======
	protected String Rücksendung;
>>>>>>> branch 'master' of https://github.com/LucasHnz/ModeVonMorgenSP.git
	
	

	/**
	 * @param posNr Die einzigartige Positionsnummer.
	 * @param aMenge Die Anzahl der Artikel der Bestellposition.
	 * @param preis der Preis der ganzen Bestellposition.
	 *  
	 */
<<<<<<< HEAD
	public Bestellposition (int posNr,int bestellNr, int artikelnummer, int aMenge, double preis, boolean rücksendung) {
=======
	public Bestellposition (int posNr,int bestellNr, int artikelnummer, int aMenge, double preis, String rücksendung) {
>>>>>>> branch 'master' of https://github.com/LucasHnz/ModeVonMorgenSP.git
		this.aMenge=aMenge;
		this.posNr = posNr;
		this.artikelnummer = artikelnummer;
		this.bestellNr = bestellNr;
		//this.preis = Artikelsammlung.getArtikel(artikelnummer).getPreis() * (100 - Artikelsammlung.getArtikel(artikelnummer).getRabatt()  *0.01);
		this.preis = preis;
		this.Rücksendung = rücksendung;
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
<<<<<<< HEAD
	public boolean getRücksendung(){
=======
	public String getRücksendung(){
>>>>>>> branch 'master' of https://github.com/LucasHnz/ModeVonMorgenSP.git
		return Rücksendung;
	}
	
<<<<<<< HEAD
	public void setRücksendung(){
		this.Rücksendung = true;
=======
	public void setRücksendung(String Status){
		this.Rücksendung = Status;
>>>>>>> branch 'master' of https://github.com/LucasHnz/ModeVonMorgenSP.git
	}

	public void setBestellNr(int bestellNr) {
		this.bestellNr = Datenbankverwaltung.holeNächsteNummer.nächsteBestellNr();
	}
	
		
}
