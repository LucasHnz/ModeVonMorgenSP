package Datenbankverwaltung;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
	
	public static void hochladenBlob(String befehl, String Dateipfad) {
		
		try {
			//Verbindungsaufbau sowie Initialisierung
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			PreparedStatement pstmt = con.prepareStatement(befehl);
			File bild = new File (Dateipfad);
			FileInputStream fis = new FileInputStream(bild);
			
			//Statement füllen und abfeuern
			pstmt.setBinaryStream(1, fis, (int) bild.length());
			pstmt.execute();
			
			
			fis.close();
			pstmt.close();
			con.close();
			
			
		}catch (Exception e) {
			e.getMessage();
		}
	}
	
	public static BufferedImage runterladenBlob(String befehl,String dateipfad) {
		
		BufferedImage bild = null;
		
		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			PreparedStatement pstmt = con.prepareStatement(befehl);
			ResultSet rs = pstmt.executeQuery(befehl);
			
			while(rs.next()) {
				File file = new File (dateipfad);
				FileOutputStream fos = new FileOutputStream (file);
				
				byte[] buffer = new byte [1];
				InputStream is = rs.getBinaryStream("Bild");
				
				while (is.read(buffer)>0) {
					fos.write(buffer);
				}
				
				fos.close();
				bild = ImageIO.read(file);
			}
			
		}catch ( Exception e) {
			e.getMessage();
		}
		return bild;
		
	}
}
