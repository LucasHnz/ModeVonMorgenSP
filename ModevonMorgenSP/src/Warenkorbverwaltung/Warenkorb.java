package Warenkorbverwaltung;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Artikelverwaltung.Artikel;
import Artikelverwaltung.ArtikelStrg;
import Artikelverwaltung.Artikelsammlung;
/**
 * 
 * @author Falk Maoro
 *
 */
public class Warenkorb {

	private static HashMap<Integer, Integer> Artikelmap = new HashMap<Integer, Integer>();
	
	private static double Gesamtpreis;
	/**
	 * Fügt dem Warenkorb einen Artikel hinzu.	
	 * @param artikel Der hinzuzufügende Artikel.
	 * @param anzahl Die Anzahl, die im Warenkorb sein soll.
	 */
	public static void ArtikelHinzufügen(Artikel artikel, int anzahl) {
		Artikelmap.put(artikel.getArtikelnummer(), anzahl);
		
	}
	/**
	 * Entfernt einen Artikel aus dem Warenkorb.
	 * @param artikel der zu entfernende Artikel.
	 */
	public static void ArtikelEntfernen(Artikel artikel) {
		Artikelmap.remove(artikel.getArtikelnummer());
	}
	/**
	 * Entfernt einen Artikel anhand der Artikelnummer aus dem Warenkorb.
	 * @param artikelnummer
	 */
	public static void ArtikelEntfernen(int artikelnummer) {
		Artikelmap.remove(artikelnummer);
	}
	/**
	 * Ändert die Anzahl eines Artikels im Warenkorb.
	 * @param Artikelnummer Artikelnummer des Artikels.
	 * @param Anzahl Anzahl.
	 */
	public static void AnzahlÄndern(int Artikelnummer, int Anzahl) {
		Artikelmap.put(Artikelnummer, Anzahl);
	}
	/** 
	 * Gibt den Gesamtpreis des Warenkorbs zurpck.
	 * @return Gesamtpreis.
	 */
	public static double getGesamtpreis() {
		double temp;
		Gesamtpreis = 0;
		for (Map.Entry<Integer, Integer> entry : Artikelmap.entrySet()) {
			temp= Artikelsammlung.getArtikel(entry.getKey()).getPreis() * (100 - Artikelsammlung.getArtikel(entry.getKey()).getRabatt()) *0.01;
			temp = temp * entry.getValue();
			Gesamtpreis = Gesamtpreis + temp;		
			}
		return Gesamtpreis;
	}
	/** 
	 * Gibt den Warenkorb als HashMap<Integer, Integer> zurück. Der Key ist die Artikelnummer. Der Wer die Anzahl.
	 * @return Warenkorb.
	 */
	public static HashMap<Integer, Integer> getWarenkorb(){
		return Artikelmap;
	}
	public static void clearWarenkorb() {
		Artikelmap = new HashMap<Integer, Integer>(); 
	}
}
