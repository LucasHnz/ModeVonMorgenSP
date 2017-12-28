package Datenbankverwaltung;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;


/**
 * 
 * @author julian
 *
 */

public class BlobLaden {
	
	/**
	 * Läd ein Bild als Blob hoch
	 * @param befehl
	 * @param Dateipfad
	 */
	public static void hochladenBlob(String befehl, String Dateipfad) {
		
		try {
			//Verbindungsaufbau sowie Initialisierung
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			PreparedStatement pstmt = con.prepareStatement(befehl);
			//File bild = new File (Dateipfad);
			InputStream photoStream = new BufferedInputStream( new FileInputStream(Dateipfad));
			//FileInputStream fis = new FileInputStream(bild);
			
			//Statement füllen und abfeuern
			pstmt.setBinaryStream(1, photoStream, photoStream.available());		
			pstmt.execute();
			
			
			photoStream.close();
			pstmt.close();
			con.close();
			System.out.println("erfolgreich hochgeladen");
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Läd ein Blob herunter
	 * @param befehl
	 * @return
	 */
	public static BufferedImage runterladenBlob(String befehl) {
		
		BufferedImage bild = null;
		
		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			PreparedStatement pstmt = con.prepareStatement(befehl);
			ResultSet rs = pstmt.executeQuery(befehl);
			
			while(rs.next()) {																					// Methode nicht mehr verwendet 
				//File file = new File (dateipfad);
				//FileOutputStream fos = new FileOutputStream (file);
				BufferedInputStream bis = new BufferedInputStream( rs.getBinaryStream(1) );
				bild = ImageIO.read(bis)  ;
				bis.close();
			}
			
		}catch ( Exception e) {
			e.printStackTrace();
		}
		return bild;
		
	}
}
