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
	/**
	 * Fordert die Artikelsammlung auf, einen neuen Artikel mit den übergebenen Parametern hinzuzufügen.
	 * @param kateg Eine der drei Artikelkategorien: Schuhe, Accessoires und Kleidung.
	 * 
	 */
	public static void NeuerArtikel(String kateg, int Artikelnummer, int Bestand, String Bezeichnung, String Art, String Geschlecht,
			
			String Hersteller, String Verfügbarkeit, String Notiz, String[] Lieferanten, double Preis,
			double Rabatt, int Schuhgröße, String Farbe, String Größe) {
		
		Artikelsammlung.hinzufügenArtikel(kateg, Artikelnummer, Bestand, Bezeichnung, Art, Geschlecht, 
				Hersteller, Verfügbarkeit, Notiz, Lieferanten, Preis, Rabatt, Schuhgröße, Farbe, Größe);
		
	}
	public static void FülleArtikelsammlung() {
		
		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sqlbefehl1 = "select * from Accessoires";
			ResultSet rs1 = stmt.executeQuery(sqlbefehl1);
			Artikelsammlung.füllenSammlung(rs1, "Accessoires");
			
			String sqlbefehl2 = "select * from Schuhe";
			ResultSet rs2 = stmt.executeQuery(sqlbefehl2);
			Artikelsammlung.füllenSammlung(rs2, "Schuhe");
			
			String sqlbefehl3 = "select * from Kleidung";
			ResultSet rs3 = stmt.executeQuery(sqlbefehl3);
			Artikelsammlung.füllenSammlung(rs3, "Kleidung");
			
			stmt.close();
			con.close();
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
	}
}
