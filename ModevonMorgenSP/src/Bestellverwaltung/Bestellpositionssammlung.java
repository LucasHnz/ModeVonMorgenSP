package Bestellverwaltung;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import Artikelverwaltung.Artikel;

/**
 * 
 * @author annag
 *
 */


public class Bestellpositionssammlung {
	
	static HashMap<Integer, Bestellposition> BestellpositionsSammlung = new HashMap<Integer, Bestellposition>();
	
	public static void füllenSammlung(ResultSet rs, String kateg) {
		try{
			while(rs.next()){
		
				int poNr = rs.getInt("PosNr");
				int aMenge = rs.getInt("ArtikelMenge");
				int bestellNr =rs.getInt("BestellNr");
				double Preis = rs.getDouble("Preis");
				Artikel aArtikel=rs.getObject("Artikel");
				Bestellposition bpos = new Bestellposition (aArtikel, bestellNr, bestellNr);
				
				BestellpositionsSammlung.put(bpos.getPosNr(),bpos);
			
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static HashMap<Integer, Bestellposition> getBestellpositionssammlung(){
		return BestellpositionsSammlung;
	}
	public static void removePosition(int posNr) {
		BestellpositionsSammlung.remove(posNr);
	}
		
	
	/**
	 * Fügt der Bestellpositionssammlung einen neuen Bestellposition hinzu.
	 * @param kateg Die Kategorie des Artikels. Also Schuhe, Accessoires oder Kleidung
	 * @param Positionsnr
	 * @param Bestellnr
	 * @param ArikelMenge
	 * @param Preis
	 * @return 
	 */
	public static void hinzufügenPosition(Artikel aArtikel,int aMenge, int posNr) {
		
		Bestellposition	bpos= new Bestellposition(aArtikel,aMenge, posNr);
			BestellpositionsSammlung.put(posNr, bpos);
	}
	
}


