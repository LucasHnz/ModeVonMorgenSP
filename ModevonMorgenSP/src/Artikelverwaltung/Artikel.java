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
	/**
	 * Gibt die Artikelnummer des Artikels zurück.
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
	 * Gibt den Bestand des Artikels zurück.
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
	 * Gibt die Bezeichnung des Artikels zurück.
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
	 * Gibt die Art des Artikels zurück.
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
	 * Gibt das Geschlecht des Artikels zurück.
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
	 * Gibt den Hersteller des Artikels zurück.
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
	 * Gibt die Artikelverfügbarkeit zurück.
	 * @return Artikelverfügbarkeit.
	 */
	public String getVerfügbarkeit() {
		return Verfügbarkeit;
	}
	/**
	 * Legt die Artikelverfügbarkeit fest.
	 * @param verfügbarkeit Artikelverfügbarkeit.
	 */
	public void setVerfügbarkeit(String verfügbarkeit) {
		Verfügbarkeit = verfügbarkeit;
	}
	/**
	 * Gibt die Notiz für einen Artikel zurück.
	 * @return Artikelnotiz.
	 */
	public String getNotiz() {
		return Notiz;
	}
	/**
	 * Legt die Notiz für einen Artikel fest.
	 * @param notiz Artikelnotiz.
	 */
	public void setNotiz(String notiz) {
		Notiz = notiz;
	}
	/** 
	 * Gibt alle Lieferanten eines Artikels in einem Array zurück.
	 * @return Lieferantenarray-
	 */
	public String[] getLieferanten() {
		return Lieferanten;
	}
	/**
	 * Legt die Lieferanten eines Artikels fest.
	 * @param lieferanten Array, das alle Lieferanten enthält.
	 */
	public void setLieferanten(String[] lieferanten) {
		Lieferanten = lieferanten;
	}
	/**
	 * Gibt den Preis eines Artikels zurück.
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
	 * Gibt den Rabatt eines Artikels zurück.
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
	 * Lädt das dem Artikel zugehörige Bild von der Datenbank runter und speichert es in der Variablen image.
	 */
	public void downloadImage() {
		String klasse = this.getClass().getName();
		klasse = klasse.substring(18);
		String befehl = "select Bild from " +klasse+ " where Artikelnr = " + this.Artikelnummer;			// Nicht mehr verwendet 
		image = Datenbankverwaltung.BlobLaden.runterladenBlob(befehl);
		
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	/**
	 * Gibt das Image des Artikels zurück.
	 * @return Artikelimage.
	 */
	public BufferedImage getImage() {
		return image;
	}
	/**
	 * 
	 * @param Dateipfad
	 */
	public void uploadImage(String Dateipfad) {
		String klasse = this.getClass().getName();
		klasse = klasse.substring(18);
		String befehl = "update " +klasse+ " set Bild = ? where Artikelnr= " + this.Artikelnummer;
		Datenbankverwaltung.BlobLaden.hochladenBlob(befehl, Dateipfad);
	}
	
}
