package Tests;


import Artikelverwaltung.Artikelsammlung;

public class BlobTest {

	public static void main(String[] args) {
		Artikelverwaltung.ArtikelStrg.F�lleArtikelsammlung();
		Object image = Artikelsammlung.getArtikel(500000001).getImage();
		
	}
}
