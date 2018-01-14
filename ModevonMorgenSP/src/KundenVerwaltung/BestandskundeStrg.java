package KundenVerwaltung;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import AdministratorVerwaltung.AdministratorSammlung;
import Artikelverwaltung.Artikelsammlung;


public class BestandskundeStrg {
	
public static void aktualisiereNachname(String nachname, int nutzernr){
		
		try {
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Bestandskunde set nachname ='"+nachname+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
public static void aktualisiereVorname(String vorname, int nutzernr){
		
		try {
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Bestandskunde set vorname ='"+vorname+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void aktualisiereEmail(String email, int nutzernr) {
		
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Bestandskunde set email ='"+email+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void aktualisiereStraﬂe(String straﬂe, int nutzernr) {
		
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Bestandskunde set Straﬂe ='"+straﬂe+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void aktualisiereOrt(String ort, int nutzernr) {
		
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Bestandskunde set ort ='"+ort+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void aktualisierePLZ(String plz, int nutzernr) {
		
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Bestandskunde set PLZ ='"+plz+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void aktualisiereIBAN(String iban, int nutzernr) {
		
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Bestandskunde set IBAN ='"+iban+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void aktualisierePasswort(String passwort, int nutzernr) {
		
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Bestandskunde set Passwort ='"+passwort+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		
		Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Anna
public static void aktualisierePSS(int pss, int nutzernr) {
		
		try{
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		
		String sqlbefehl = "update Bestandskunde set PSS ='"+pss+"' where nutzernr ="+nutzernr;
		
		stmt.execute(sqlbefehl)	;
		BestandskundeSammlung.getBestandskunde(nutzernr).setPss(pss);
		Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}


	
	//Anna
	public static void neuerKunde(int nutzernr, String nachname, String vorname, String email, String straﬂe, String ort, int plz, String iban, int berechtigung, String passwort, int pss){
	
		
		
		try {			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();			
			Statement stmt = con.createStatement();			
			String sqlbefehl = "insert into Bestandskunde values ('"+nutzernr+"','"+nachname+"','"+vorname+"','"+email+"','"+straﬂe+"','"+ort+"','"+plz+"','"+iban+"','"+berechtigung+"','"+passwort+"','"+pss+"')";			
			stmt.executeQuery(sqlbefehl);			
			Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
			BestandskundeSammlung.hinzuf¸genBestandskunde(nutzernr, nachname, vorname, email, straﬂe, ort, plz, iban, berechtigung, passwort,pss);
			
		}catch (SQLException e) { 
			e.printStackTrace();
		}

	}

	public static void lˆschenAccount(int nutzerNr) {
		try {
			
			int kdnr = nutzerNr;
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sqlbefehel ="delete from Bestandskunde where nutzerNr = '"+kdnr+"'";
			
			stmt.executeQuery(sqlbefehel);
			Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void anzeigenPunktestand(int nutzerNr){
			int kdnr = nutzerNr;
			try {
				Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
				Statement stmt = con.createStatement();
				String sqlbefehel ="select PSS from Bestandskunde where nutzerNr = '"+kdnr+"'";
				
				stmt.executeQuery(sqlbefehel);
				Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	//Falk
	public static void F¸lleBestandskundeSammlung() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			stmt = con.createStatement();
			String sqlbefehl = "select * from Bestandskunde";
			rs = stmt.executeQuery(sqlbefehl);
			BestandskundeSammlung.f¸lleSammlung(rs);
	
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}finally {
			try {
				if(stmt !=null) 
					stmt.close();
				if(con != null)
					con.close();
				if(rs != null)
					rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
