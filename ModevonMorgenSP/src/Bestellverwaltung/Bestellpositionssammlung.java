package Bestellverwaltung;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;


public class Bestellpositionssammlung {

	HashMap<Integer, Bestellposition> Bestellpositionssammlung = new HashMap<Integer,Bestellposition>();
	
	public Bestellpositionssammlung(ResultSet rs) throws SQLException {
		 
		while (rs.next()) {
			int aMenge = rs.getInt("Menge");
			int posNr = rs.getInt("PosNr");
			
			Bestellposition bBestellposition = new Bestellposition();
			Bestellpositionssammlung.put(bBestellposition.getPosNr(), bBestellposition);
			
		}
		
	}
}
