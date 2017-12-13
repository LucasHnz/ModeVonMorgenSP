package Artikelverwaltung;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author maoro
 *
 */
public class ArtikelStrg {

	public ArtikelStrg() {
		
		
	}
	/**
	 * 
	 * @param Artikelnummer
	 */
	public static void EditiereArtikel(int Artikelnummer) {
		Artikel artikel = Artikelsammlung.getArtikel(Artikelnummer);
		//if(artikel.getKategorie() == "Accessoires")
			//GUIArtikelFormular.editiereArtikel(Artikelnummer, artikel.getKategorie());
		//else if(artikel.getKategorie() == "Schuhe")
			//GUIArtikelFormular.editiereArtikel(Artikelnummer, artikel.getKategorie());
		//else if(artikel.getKategorie() == "Kleidung")
			//GUIArtikelFormular.editiereArtikel(Artikelnummer, artikel.getKategorie());		
		
	}
	public static void main(String[] args) {
		F�lleArtikelsammlung();
	}
	/**
	 * Fordert die Artikelsammlung auf, einen neuen Artikel mit den �bergebenen Parametern hinzuzuf�gen.
	 * @param kateg Eine der drei Artikelkategorien: Schuhe, Accessoires und Kleidung.
	 * 
	 */
	public static void NeuerArtikel(String kateg, int Artikelnummer, int Bestand, String Bezeichnung, String Art, String Geschlecht,
			
			String Hersteller, String Verf�gbarkeit, String Notiz, String[] Lieferanten, double Preis,
			double Rabatt, int Schuhgr��e, String Farbe, String Gr��e) {
		
		Artikelsammlung.hinzuf�genArtikel(kateg, Artikelnummer, Bestand, Bezeichnung, Art, Geschlecht, 
				Hersteller, Verf�gbarkeit, Notiz, Lieferanten, Preis, Rabatt, Schuhgr��e, Farbe, Gr��e);
		
	}
	public static void F�lleArtikelsammlung() {
		
		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sqlbefehl1 = "select * from Accessoires";
			ResultSet rs1 = stmt.executeQuery(sqlbefehl1);
			Artikelsammlung.f�llenSammlung(rs1, "Accessoires");
			
			String sqlbefehl2 = "select * from Schuhe";
			ResultSet rs2 = stmt.executeQuery(sqlbefehl2);
			Artikelsammlung.f�llenSammlung(rs2, "Schuhe");
			
			String sqlbefehl3 = "select * from Kleidung";
			ResultSet rs3 = stmt.executeQuery(sqlbefehl3);
			Artikelsammlung.f�llenSammlung(rs3, "Kleidung");
			
			stmt.close();
			con.close();
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
	}
}
