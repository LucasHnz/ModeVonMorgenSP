package Bestellverwaltung;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;


public class Bestellpositionssammlung {
	protected Bestellposition bBestellposition;

	HashMap<Integer,Bestellposition> Bestellpositionssammlung = new HashMap<Integer,Bestellposition>();
	
	public Bestellpositionssammlung(ResultSet rs) throws SQLException {
		while (rs.next()) {
			int aMenge = rs.getInt("Menge");
			int posNr = rs.getInt("PosNr");
			
		
			Bestellpositionssammlung.put(bBestellposition.getPosNr(), bBestellposition);
			
		}
		
	}
}
