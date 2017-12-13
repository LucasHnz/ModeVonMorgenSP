package Bestellverwaltung;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Bestellsammlung {
	HashMap<Integer, Bestellung> Bestellsammlung = new HashMap<Integer,Bestellung>();
	
	public Bestellsammlung(ResultSet rs) throws SQLException {
		 
		while (rs.next()) {
			double datum = rs.getDouble("Datum");
			int bNr = rs.getInt("bNr");
			String versandStatus= rs.getString("VersandStatus");
			double preis =rs.getDouble("Preis");
			
			
			Bestellung bBestellung = new Bestellung ();
			Bestellsammlung.put(bBestellung.getbNr(), bBestellung);
				
		}
	}
}
