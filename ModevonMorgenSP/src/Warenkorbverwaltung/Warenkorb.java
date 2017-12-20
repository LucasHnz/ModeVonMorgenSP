package Warenkorbverwaltung;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Artikelverwaltung.Artikel;
import Artikelverwaltung.ArtikelStrg;
import Artikelverwaltung.Artikelsammlung;
/**
 * 
 * @author maoro
 *
 */
public class Warenkorb {

	private static HashMap<Integer, Integer> Artikelmap = new HashMap<Integer, Integer>();
	
	private static double Gesamtpreis = 0;
	
	public static void main(String[] args) {
		ArtikelStrg.FülleArtikelsammlung();
		ArtikelHinzufügen(Artikelsammlung.getArtikel(500000001), 2);
	}
		
	public static void ArtikelHinzufügen(Artikel artikel, int anzahl) {
		Artikelmap.put(artikel.getArtikelnummer(), anzahl);
		
	}
	
	public static void ArtikelEntfernen(Artikel artikel) {
		Artikelmap.remove(artikel.getArtikelnummer());
	}
	
	public static void ArtikelEntfernen(int artikelnummer) {
		Artikelmap.remove(artikelnummer);
	}
	
	public static double getGesamtpreis() {
		double temp;
		for (Map.Entry<Integer, Integer> entry : Artikelmap.entrySet()) {
			temp= Artikelsammlung.getArtikel(entry.getKey()).getPreis() * (100 - Artikelsammlung.getArtikel(entry.getKey()).getRabatt()) *0.01;
			temp = temp * entry.getValue();
			Gesamtpreis = Gesamtpreis + temp;		
			}
		return Gesamtpreis;
	}
	
	public static HashMap<Integer, Integer> getWarenkorb(){
		return Artikelmap;
	}
}
