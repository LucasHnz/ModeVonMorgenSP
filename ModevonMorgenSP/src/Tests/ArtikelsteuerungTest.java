package Tests;

import Artikelverwaltung.ArtikelStrg;

public class ArtikelsteuerungTest {

	public static void main(String[] args) {
		ArtikelStrg.FülleArtikelsammlung();
		ArtikelStrg.entferneArtikel(700000013);
	}
}
