package Artikelverwaltung;

import java.awt.image.BufferedImage;

/**
 * 
 * @author maoro
 *
 */
public abstract class Artikel implements Comparable<Artikel> {

	protected int Artikelnummer, Bestand, Rabatt;
	protected String Bezeichnung, Art, Geschlecht, Hersteller, Verfügbarkeit, Notiz, Kategorie;
	protected String[] Lieferanten;
	protected double Preis;
	protected BufferedImage image;
	
	/**
	 * 
	 * @param artnr Die einzigartige Artikelnummer.
	 * @param bestand Der aktuelle Lagerbestand.
	 * @param Bezeichnung Name des Artikels.
	 * @param Geschlecht Gibt an, ob der Artikel für Frauen oder Männer gedacht ist.
	 * @param Hersteller Die MArke des Artikels.
	 * @param Verfügbarkeit Die Lieferbarkeit.
	 * @param Notiz Eine nur in der Artikelverwaltung sichtbare Notiz.
	 * @param Lieferanten Die Namen aller Lieferanten, die einen Artikel liefern.
	 * @param Preis Der Preis des Artikels.
	 * @param Rabatt Temporäre Preisvergünstigung.
	 */
	public Artikel(int artnr, int bestand, String Bezeichnung, String Art, String Geschlecht, String Hersteller, String Verfügbarkeit, String Notiz, String[]  Lieferanten, double Preis, int Rabatt) {

		this.Artikelnummer=artnr;
		this.Bestand=bestand;
		this.Bezeichnung=Bezeichnung;
		this.Art=Art;
		this.Geschlecht=Geschlecht;
		this.Hersteller=Hersteller;
		this.Verfügbarkeit=Verfügbarkeit;
		this.Notiz=Notiz;
		this.Lieferanten=Lieferanten;
		this.Preis=Preis;
		this.Rabatt=Rabatt;
	}
	
	public int getArtikelnummer() {
		return Artikelnummer;
	}
	public void setArtikelnummer(int artikelnummer) {
		Artikelnummer = artikelnummer;
	}
	public int getBestand() {
		return Bestand;
	}
	public void setBestand(int bestand) {
		Bestand = bestand;
	}
	public String getBezeichnung() {
		return Bezeichnung;
	}
	public void setBezeichnung(String bezeichnung) {
		Bezeichnung = bezeichnung;
	}
	public String getArt() {
		return Art;
	}
	public void setArt(String art) {
		Art = art;
	}
	public String getGeschlecht() {
		return Geschlecht;
	}
	public void setGeschlecht(String geschlecht) {
		Geschlecht = geschlecht;
	}
	public String getHersteller() {
		return Hersteller;
	}
	public void setHersteller(String hersteller) {
		Hersteller = hersteller;
	}
	public String getVerfügbarkeit() {
		return Verfügbarkeit;
	}
	public void setVerfügbarkeit(String verfügbarkeit) {
		Verfügbarkeit = verfügbarkeit;
	}
	public String getNotiz() {
		return Notiz;
	}
	public void setNotiz(String notiz) {
		Notiz = notiz;
	}
	public String[] getLieferanten() {
		return Lieferanten;
	}
	public void setLieferanten(String[] lieferanten) {
		Lieferanten = lieferanten;
	}
	public double getPreis() {
		return Preis;
	}
	public void setPreis(double preis) {
		Preis = preis;
	}
	public int getRabatt() {
		return Rabatt;
	}
	public void setRabatt(int rabatt) {
		Rabatt = rabatt;
	}
	public String getKategorie() {
		return Kategorie;
	}
	public int compareTo(Artikel a) {
		if (this.Artikelnummer < a.getArtikelnummer())
			return -1;
		else 
			return 1;
		
	}
	public void downloadImage() {
		String klasse = this.getClass().getName();
		klasse = klasse.substring(18);
		String befehl = "select Bild from " +klasse+ " where Artikelnr = " + this.Artikelnummer;;
		image = Datenbankverwaltung.BlobLaden.runterladenBlob(befehl);
		
	}
	
	public BufferedImage getImage() {
		return image;
	}

	public void uploadImage(String Dateipfad) {
		String klasse = this.getClass().getName();
		klasse = klasse.substring(18);
		String befehl = "update " +klasse+ " set Bild = ? where Artikelnr= " + this.Artikelnummer;
		Datenbankverwaltung.BlobLaden.hochladenBlob(befehl, Dateipfad);
	}
	
}
