package Tests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Artikelverwaltung.*;
public class ArtikelsammlungTest {

	public static void main(String[] args) {
		
		try {
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		String sqlbefehl1 = "select * from Accessoires";
		ResultSet rs1 = stmt.executeQuery(sqlbefehl1);
		
		Artikelsammlung.füllenSammlung(rs1, "Accessoires");
		System.out.println(Artikelsammlung.getArtikelsammlung().get(500000001).getBezeichnung());
		
		}catch(SQLException e) {
		
		}

	}
}