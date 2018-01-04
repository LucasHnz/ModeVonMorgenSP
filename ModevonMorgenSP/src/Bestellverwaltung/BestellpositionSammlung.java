package Bestellverwaltung;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;


import Artikelverwaltung.Artikelsammlung;
import Warenkorbverwaltung.Warenkorb;
/**
 * 
 * @author annag, Julian
 *
 */


public class BestellpositionSammlung {
public static HashMap<Integer,Integer> BestellpositionsSammlung = new HashMap<Integer, Integer>();
	
	public static void f�llenBestellpositionsSammlung(){
		
		try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select * from BESTELLPOSITION";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int posNr = rs.getInt("BestellpositionsNr");
				int bestellNr = rs.getInt("Bestellnr");
				int artikelnummer= rs.getInt("ArtikelNr");
				int aMenge =rs.getInt("Artikel Anzahl");
				double preis = rs.getDouble("Preis");
				boolean checkR�cksendung = rs.getBoolean("R�cksendung");
				
				
				Bestellposition b = new Bestellposition (posNr,bestellNr, artikelnummer, aMenge, preis, checkR�cksendung);
				
				BestellpositionsSammlung.put(b.getPosNr(), b.getBestellNr());
				
			}
			
		}catch (SQLException e ) {
			e.printStackTrace();
		}
		
		}

	public static HashMap<Integer, Integer> getBestellpositionsSammlung(){
		return BestellpositionsSammlung;
	}
	
	public static void f�lleMitSpeziellerNummer(int i) {
	try {
			
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select * from BESTELLPOSITION where Bestellnr = '"+i+"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int posNr = rs.getInt("Bestellposnr");
				int bestellNr = rs.getInt("Bestellnr");
				int artikelnummer= rs.getInt("ArtikelNr");
				int aMenge =rs.getInt("Menge");
				double preis =Artikelsammlung.getArtikel(artikelnummer).getPreis() * (100 - Artikelsammlung.getArtikel(artikelnummer).getRabatt()  *0.01);
				preis= rs.getDouble("Preis");
				boolean checkR�cksendung = rs.getBoolean("R�cksendung");
				
				Bestellposition b = new Bestellposition (posNr,bestellNr, artikelnummer, aMenge, preis, checkR�cksendung);
				
				BestellpositionsSammlung.put(b.getPosNr(), b.getBestellNr());
				
			}
			
		}catch (SQLException e ) {
			e.printStackTrace();
		}
		
	}
	public static void erstellenBestellposAusWarenkorb (int artikelnummer ,int anzahl) {
		
		try {
			int artikelnr= Warenkorb.getWarenkorb().get(artikelnummer);
			int aMenge=Warenkorb.getWarenkorb().get(anzahl);
			double preis= Warenkorb.getGesamtpreis();
			int posNr= Datenbankverwaltung.holeN�chsteNummer.n�chsteBestellPosNr();
			int bestellNr=Datenbankverwaltung.holeN�chsteNummer.n�chsteBestellNr();
			boolean r�cksendung= true;
			
	
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql="insert into BESTELLPOSITION values ('"+posNr+"',"+bestellNr+"','"+artikelnr+"','"+aMenge+"','"+preis+"','"+r�cksendung+" ')";
			ResultSet rs = stmt.executeQuery(sql);
			 
			Bestellposition bpos= new Bestellposition(posNr,bestellNr,artikelnr,aMenge,preis,r�cksendung);
			BestellpositionsSammlung.put(bpos.getPosNr(), bpos.getBestellNr());
			
			rs.close();
			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void entferneDatenAusListe() {
		
		for(Iterator<Integer> it = BestellpositionsSammlung.keySet().iterator(); it.hasNext();) {
			Integer s = it.next();
			BestellpositionsSammlung.remove(s);
			}
		}
	}
	
	

	

