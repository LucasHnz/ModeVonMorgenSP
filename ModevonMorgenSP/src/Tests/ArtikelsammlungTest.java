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
		if(Artikelsammlung.getArtikelsammlung().get(500000005).getNotiz() == null)
			System.out.println("ist null");
		
		}catch(SQLException e) {
		System.out.println(e.getMessage());
		}

	}
}