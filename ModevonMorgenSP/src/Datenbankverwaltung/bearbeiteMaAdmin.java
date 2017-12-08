package Datenbankverwaltung;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class bearbeiteMaAdmin {
	
	/**
	 * 
	 * @author Julian
	 */
	
	public static void bearbeiteMitarbeiterDaten(String Spalte, String Value, String PK) {
		
		
		try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			PreparedStatement stmt = con.prepareStatement("update Mitarbeiter set ? = ? where Nutzernr = ? ");
			
			int pk = Integer.parseInt(PK);
			
			if ((Spalte == "Nutzernr")) {
				int nummer = Integer.parseInt(Value);
				
				stmt.setString(1, Spalte);
				stmt.setInt(2,nummer);
				stmt.setInt(3, pk);
				
				stmt.execute();
				
				
			}else if ((Spalte =="Adminnr")) {
				int nummer = Integer.parseInt(Value);
				
				stmt.setString(1, Spalte);
				stmt.setInt(2,nummer);
				stmt.setInt(3, pk);
				
				stmt.execute();
				
			}else if ((Spalte == "Gehalt")) {
				int gehalt = Integer.parseInt(Value);
				
				stmt.setString(1, Spalte);
				stmt.setInt(2,gehalt);
				stmt.setInt(3, pk);
				
				stmt.execute();
				
			}else if ((Spalte == "Plz")) {
				int plz = Integer.parseInt(Value);
				
				stmt.setString(1, Spalte);
				stmt.setInt(2,plz);
				stmt.setInt(3, pk);
				
				stmt.execute();
				
			}else {
				
				stmt.setString(1, Spalte);
				stmt.setString(2,Value);
				stmt.setInt(3, pk);
				
				stmt.execute();
				
			}
			
			
			
		}catch (SQLException e) {
			e.getMessage();
		}
		
		
	}
	
	public static void bearbeiteAdministratorDaten(String Spalte, String Value, String PK) {
		
		
		try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			PreparedStatement stmt = con.prepareStatement("update Administrator set ? = ? where Nutzernr = ? ");
			
			int pk = Integer.parseInt(PK);
			
			if ((Spalte == "Nutzernr")) {
				int nummer = Integer.parseInt(Value);
				
				stmt.setString(1, Spalte);
				stmt.setInt(2,nummer);
				stmt.setInt(3, pk);
				
				stmt.execute();
				
			}else if ((Spalte == "Gehalt")) {
				int gehalt = Integer.parseInt(Value);
				
				stmt.setString(1, Spalte);
				stmt.setInt(2,gehalt);
				stmt.setInt(3, pk);
				
				stmt.execute();
				
			}else if ((Spalte == "Plz")) {
				int plz = Integer.parseInt(Value);
				
				stmt.setString(1, Spalte);
				stmt.setInt(2,plz);
				stmt.setInt(3, pk);
				
				stmt.execute();
				
			}else {
				
				stmt.setString(1, Spalte);
				stmt.setString(2,Value);
				stmt.setInt(3, pk);
				
				stmt.execute();
				
			}
			
			
			
		}catch (SQLException e) {
			e.getMessage();
		}
		
		
	}
	
	public static void bearbeiteBestandskundeDaten(String Spalte, String Value, String PK) {
		
		
		try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			PreparedStatement stmt = con.prepareStatement("update Bestandskunde set ? = ? where Nutzernr = ? ");
			
			int pk = Integer.parseInt(PK);

				if ((Spalte == "Plz")) {
				int plz = Integer.parseInt(Value);
				
				stmt.setString(1, Spalte);
				stmt.setInt(2,plz);
				stmt.setInt(3, pk);
				
				stmt.execute();
				
			}else {
				
				stmt.setString(1, Spalte);
				stmt.setString(2,Value);
				stmt.setInt(3, pk);
				
				stmt.execute();
				
			}
			
			
			
		}catch (SQLException e) {
			e.getMessage();
		}
		
		
	}
}
