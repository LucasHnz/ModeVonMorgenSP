package Frontend;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Logverwaltung.LogStrg;


public class GUIKaufvorgang {
	//noch unbenennen und in andere Klasse
	
	public static void angemedelt�berpr�fung() {
		try {
		LogStrg.getAngemeldetStatus();
		if (LogStrg.getAngemeldetStatus()== 0 ) {
		new GUIAbfrage();
		}
		if(LogStrg.getAngemeldetStatus()==2) {
			new GUIDaten�berpr�fen();
		}
		else { 
			JOptionPane.showMessageDialog(null, "Angestellte k�nnen nichts bestellen!","Fehler",
					JOptionPane.ERROR_MESSAGE);
			
		}
		} catch(SQLException a) {
			System.err.println(a);
			
		}
	}

	
	
}
