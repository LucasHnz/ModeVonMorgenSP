package Datenbankverwaltung;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;


/**
 * 
 * @author Falk Maoro
 *
 */

public class BlobLaden {
	
	/**
	 * Lädt ein Bild von der Festplatte in die Datenbank hoch.
	 * @param befehl Der SQL Befehl um einen BLOB Wert in die Datenbank hochzuladen.
	 * @param Dateipfad Der lokale Pfad des Bildes.
	 */
	public static void hochladenBlob(String befehl, String Dateipfad) throws NullPointerException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		InputStream photoStream = null;
		
		try {
	
			con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			pstmt = con.prepareStatement(befehl);
			photoStream = new BufferedInputStream( new FileInputStream(Dateipfad));
			
			pstmt.setBinaryStream(1, photoStream, photoStream.available());		
			pstmt.execute();
			
			JOptionPane.showMessageDialog(null, "Bild erfolgreich hochgeladen", "Bild hochladen", JOptionPane.INFORMATION_MESSAGE);
		}catch (IOException e) {
			e.printStackTrace();
		}catch(SQLException s) {
			s.printStackTrace();
		}		
		finally {
			try {
				if(con != null)
					con.close();
				if(pstmt != null)
					pstmt.close();
				if(photoStream != null)
					photoStream.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
