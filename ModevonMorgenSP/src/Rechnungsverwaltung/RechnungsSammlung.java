package Rechnungsverwaltung;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import java.sql.Date;
/**
 * 
 * @author annag
 *
 */

public class RechnungsSammlung {
	
public static HashMap<Integer, Rechnung> RechnungsSammlung = new HashMap<Integer,Rechnung>();
	
	public RechnungsSammlung(ResultSet rs) throws SQLException {
		try {
		while (rs.next()) {
			String nachname = rs.getString("Nachname");
			String name = rs.getString("name");
			String straﬂe = rs.getString("Straﬂe");
			String ort = rs.getString("Ort");
			String iban = rs.getString("IBAN");
			String vstatus=rs.getString("Versandstatus");
			
			//Wird nicht funktionieren, MitgliedsID gibt es nicht
			int mitgliedsID=rs.getInt("MitgliedsID");
			int rechnungNr=rs.getInt("RechnungsNr");
			int bestellNr=rs.getInt("BestellNr");
			int bestandskunde=rs.getInt("Bestandskunde");
			int gastkunde=rs.getInt("Gastkunde");
			int plz = rs.getInt("Plz");
			double gesamtpreis=rs.getDouble("GesamtPreis");
			double zwischenpreis=rs.getDouble("ZwischenPreis");
			double eRabatt=rs.getDouble("Rabatt");
			Date datum=rs.getDate("Datum");
			Rechnung rRechnung = new Rechnung(name, nachname, straﬂe, ort, iban, vstatus,mitgliedsID,rechnungNr, bestellNr,
					bestandskunde, gastkunde,  plz, gesamtpreis,zwischenpreis, eRabatt, datum );
			RechnungsSammlung.put(rRechnung.getRechnungNr(), rRechnung);
			
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	
	public static HashMap<Integer, Rechnung> getRechnungsSammlung() {
		return RechnungsSammlung;
	}

	public static void removeArtikel(int rechnungNr) {
		RechnungsSammlung.remove(rechnungNr);
	}
	public static void hinzuf¸genRechnung(String name, String nachname, String straﬂe, String ort, String iban, String vstatus, int mitgliedsID,
			int rechnungNr, int bestellNr, int bestandskunde, int gastkunde, int plz, double gesamtpreis,double zwischenpreis, double eRabatt, Date datum) {
		
		Rechnung rRechnung= new Rechnung(name, nachname, straﬂe, ort, iban, vstatus,mitgliedsID,rechnungNr, bestellNr,
				bestandskunde, gastkunde,  plz, gesamtpreis,zwischenpreis, eRabatt, datum);
		RechnungsSammlung.put(rRechnung.getRechnungNr(),rRechnung);
	}
}


