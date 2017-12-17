package Warenkorbverwaltung;

import java.util.ArrayList;

import Artikelverwaltung.Artikel;
/**
 * 
 * @author maoro
 *
 */
public class Warenkorb {

	private ArrayList<Artikel> Artikelliste;
	private double Gesamtpreis = 0;
	
	public Warenkorb() {
		
	}
	public void ArtikelHinzufügen(Artikel artikel, int anzahl) {
		for(int i = 0; i <= anzahl; i++) {
			Artikelliste.add(artikel);
		}
	}
	public void ArtikelEntfernen(Artikel artikel) {
		Artikelliste.remove(artikel);
	}
	public double getGesamtpreis() {
		double temp;
		for(Artikel a : Artikelliste) {
			temp = a.getPreis() * (100 - a.getRabatt()) * 0.01;
			Gesamtpreis = Gesamtpreis + temp;
		}
		return Gesamtpreis;
	}
}
