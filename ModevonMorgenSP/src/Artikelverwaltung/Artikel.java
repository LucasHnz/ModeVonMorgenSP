package Artikelverwaltung;

import java.awt.image.BufferedImage;

/**
 * 
 * @author Falk Maoro
 *
 */
public abstract class Artikel implements Comparable<Artikel> {

	protected int Artikelnummer, Bestand, Rabatt;
	protected String Bezeichnung, Art, Geschlecht, Hersteller, Verf�gbarkeit, Notiz, Kategorie;
	protected String[] Lieferanten;
	protected double Preis;
	protected BufferedImage image;
	
	/**
	 * Konstruktor.
	 * @param artnr Die einzigartige Artikelnummer.
	 * @param bestand Der aktuelle Lagerbestand.
	 * @param Bezeichnung Name des Artikels.
	 * @param Geschlecht Gibt an, ob der Artikel f�r Frauen oder M�nner gedacht ist.
	 * @param Hersteller Die MArke des Artikels.
	 * @param Verf�gbarkeit Die Lieferbarkeit.
	 * @param Notiz Eine nur in der Artikelverwaltung sichtbare Notiz.
	 * @param Lieferanten Die Namen aller Lieferanten, die einen Artikel liefern.
	 * @param Preis Der Preis des Artikels.
	 * @param Rabatt Tempor�re Preisverg�nstigung.
	 */
	public Artikel(int artnr, int bestand, String Bezeichnung, String Art, String Geschlecht,
			String Hersteller, String Verf�gbarkeit, String Notiz, String[]  Lieferanten,
			double Preis, int Rabatt) {

		this.Artikelnummer=artnr;
		this.Bestand=bestand;
		this.Bezeichnung=Bezeichnung;
		this.Art=Art;
		this.Geschlecht=Geschlecht;
		this.Hersteller=Hersteller;
		this.Verf�gbarkeit=Verf�gbarkeit;
		this.Notiz=Notiz;
		this.Lieferanten=Lieferanten;
		this.Preis=Preis;
		this.Rabatt=Rabatt;
	}
	/**
	 * Gibt die Artikelnummer des Artikels zur�ck.
	 * @return Artikelnummer des Artikels.
	 */
	public int getArtikelnummer() {
		return Artikelnummer;
	}
	/**
	 * Legt die Variable Artikelnummer fest.
	 * @param artikelnummer 
	 */
	public void setArtikelnummer(int artikelnummer) {
		Artikelnummer = artikelnummer;
	}
	/**
	 * Gibt den Bestand des Artikels zur�ck.
	 * @return Bestand des Artikels
	 */
	public int getBestand() {
		return Bestand;
	}
	/**
	 * Legt den Bestand eines Artikels fest.
	 * @param bestand Bestand des Artikels.
	 */
	public void setBestand(int bestand) {
		Bestand = bestand;
	}
	/**
	 * Gibt die Bezeichnung des Artikels zur�ck.
	 * @return Bezeichnung des Artikels.
	 */
	public String getBezeichnung() {
		return Bezeichnung;
	}
	/**
	 * Legt die Bezeichnung des Artikels fest.
	 * @param bezeichnung Bezeichnung des Artikels.
	 */
	public void setBezeichnung(String bezeichnung) {
		Bezeichnung = bezeichnung;
	}
	/**
	 * Gibt die Art des Artikels zur�ck.
	 * @return Art des Artikels.
	 */
	public String getArt() {
		return Art;
	}
	/**
	 * Legt die Art des Artikels fest.
	 * @param art Art des Artikels.
	 */
	public void setArt(String art) {
		Art = art;
	}
	/**
	 * Gibt das Geschlecht des Artikels zur�ck.
	 * @return Geschlecht des Artikels.
	 */
	public String getGeschlecht() {
		return Geschlecht;
	}
	/**
	 * Legt das Geschlecht des Artikels fest.
	 * @param geschlecht Geschlecht des Artikels.
	 */
	public void setGeschlecht(String geschlecht) {
		Geschlecht = geschlecht;
	}
	/**
	 * Gibt den Hersteller des Artikels zur�ck.
	 * @return Hersteller des Artikels.
	 */
	public String getHersteller() {
		return Hersteller;
	}
	/**
	 * Legt den Hersteller des Artikels fest.
	 * @param hersteller Hersteller des Artikels.
	 */
	public void setHersteller(String hersteller) {
		Hersteller = hersteller;
	}
	/**
	 * Gibt die Artikelverf�gbarkeit zur�ck.
	 * @return Artikelverf�gbarkeit.
	 */
	public String getVerf�gbarkeit() {
		return Verf�gbarkeit;
	}
	/**
	 * Legt die Artikelverf�gbarkeit fest.
	 * @param verf�gbarkeit Artikelverf�gbarkeit.
	 */
	public void setVerf�gbarkeit(String verf�gbarkeit) {
		Verf�gbarkeit = verf�gbarkeit;
	}
	/**
	 * Gibt die Notiz f�r einen Artikel zur�ck.
	 * @return Artikelnotiz.
	 */
	public String getNotiz() {
		return Notiz;
	}
	/**
	 * Legt die Notiz f�r einen Artikel fest.
	 * @param notiz Artikelnotiz.
	 */
	public void setNotiz(String notiz) {
		Notiz = notiz;
	}
	/** 
	 * Gibt alle Lieferanten eines Artikels in einem Array zur�ck.
	 * @return Lieferantenarray-
	 */
	public String[] getLieferanten() {
		return Lieferanten;
	}
	/**
	 * Legt die Lieferanten eines Artikels fest.
	 * @param lieferanten Array, das alle Lieferanten enth�lt.
	 */
	public void setLieferanten(String[] lieferanten) {
		Lieferanten = lieferanten;
	}
	/**
	 * Gibt den Preis eines Artikels zur�ck.
	 * @return Preis.
	 */
	public double getPreis() {
		return Preis;
	}
	/**
	 * Leht den Preis eines Artikels fest.
	 * @param preis Preis eines Artikels.
	 */
	public void setPreis(double preis) {
		Preis = preis;
	}
	/**
	 * Gibt den Rabatt eines Artikels zur�ck.
	 * @return Artikelrabatt.
	 */
	public int getRabatt() {
		return Rabatt;
	}
	/**
	 * Legt den Rabatt eines Artikels fest.
	 * @param rabatt Artikelrabatt.
	 */
	public void setRabatt(int rabatt) {
		Rabatt = rabatt;
	}
	/**
	 * Vergleicht zwei Artikelobjekte anhand derer Artikelnummern.
	 */
	public int compareTo(Artikel a) {
		if (this.Artikelnummer < a.getArtikelnummer())
			return -1;
		else 
			return 1;
	}
	/**
	 * L�dt das dem Artikel zugeh�rige Bild von der Datenbank runter und speichert es in der Variablen image.
	 */
	public void downloadImage() {
		String klasse = this.getClass().getName();
		klasse = klasse.substring(18);
		String befehl = "select Bild from " +klasse+ " where Artikelnr = " + this.Artikelnummer;			// Nicht mehr verwendet 
		image = Datenbankverwaltung.BlobLaden.runterladenBlob(befehl);
		
	}
	/**
	 * Legt das Produktbild fest.
	 * @param image Das Produktbild als BufferedImage.
	 */
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	/**
	 * Gibt das Image des Artikels zur�ck.
	 * @return Artikelimage.
	 */
	public BufferedImage getImage() {
		return image;
	}
	/**
	 * L�dt ein neues Artikelbild in die Datenbank hoch und aktualisiert es in der Artikelsammlung.
	 * @param Dateipfad Der lokale Pfad des Bildes.
	 */
	public void uploadImage(String Dateipfad) {
		String klasse = this.getClass().getName();
		klasse = klasse.substring(18);
		String befehl = "update " +klasse+ " set Bild = ? where Artikelnr= " + this.Artikelnummer;
		Datenbankverwaltung.BlobLaden.hochladenBlob(befehl, Dateipfad);
		downloadImage();
	}
	
}
