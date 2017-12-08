package Datenbankverwaltung;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
			
			Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
			
			
			
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
			
			Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
			
			
			
		}catch (SQLException e) {
			e.getMessage();
		}
		
		
	}
	
	public static void bearbeiteBestandskundeDaten(String Spalte, String Value, String PK) {
		
		
		try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			PreparedStatement stmt = con.prepareStatement("update Bestandskunde set ? = '?' where Nutzernr = ? ");
			

				if ((Spalte == "Plz")) {
				int plz = Integer.parseInt(Value);
				stmt.setString(1, Spalte);
				stmt.setInt(2,plz);
				stmt.setString(3, PK);
				System.out.println("1");
				stmt.execute();
				
			}else {
				
				Value = "'"+Value+"'";
				
				stmt.setString(1, Spalte);
				stmt.setString(2,Value);
				stmt.setString(3, PK);
				System.out.println("2");
				stmt.execute();
				
			}
				
				Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
			
			
			
		}catch (SQLException e) {
			e.getMessage();
		}
		
		
	}

	public static void aktualisiereName(String name, String nutzernr) throws SQLException {
		
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Bestandskunde set nachname ='"+name+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
	}
}
