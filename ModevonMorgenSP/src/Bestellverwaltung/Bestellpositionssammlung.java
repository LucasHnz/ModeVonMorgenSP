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


//Brauchen wir diese Klasse �berhaupt? eine Liste der Bestellpositionen ist nicht im Gebrauch ?

public class Bestellpositionssammlung {
	
	static HashMap<Integer, Bestellposition> BestellpositionsSammlung = new HashMap<Integer, Bestellposition>();
	
	public static void f�llenSammlung(ResultSet rs, String kateg) {
		try{
			while(rs.next()){
		
				int poNr = rs.getInt("PosNr");
				int aMenge = rs.getInt("ArtikelMenge");
				int bestellNr =rs.getInt("BestellNr");
				
				int artikelnummer=rs.getInt("ArtikelNr");
				Bestellposition bpos = new Bestellposition (poNr, artikelnummer, aMenge, bestellNr);
				
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
	 * F�gt der Bestellpositionssammlung einen neuen Bestellposition hinzu.
	 * @param kateg Die Kategorie des Artikels. Also Schuhe, Accessoires oder Kleidung
	 * @param Positionsnr
	 * @param Bestellnr
	 * @param ArikelMenge
	 * @param Preis
	 * @return 
	 */
	public static void hinzuf�genPosition(Artikel aArtikel,int aMenge, int posNr) {
		
		Bestellposition	bpos= new Bestellposition(aArtikel,aMenge, posNr);
			BestellpositionsSammlung.put(posNr, bpos);
	}
	
}


