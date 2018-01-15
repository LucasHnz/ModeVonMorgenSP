package Backend;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import javax.swing.JPanel;
import Logverwaltung.LogStrg;
import javax.swing.JTabbedPane;
/**
 * 
 * @author Falk Maoro
 *
 */
public class GUIMitarbeiter{
	
	private static JPanel panel;
	
	/**
	 * Gibt das JPanel für die Mitarbeiterverwaltung zurück. Das Panel hat
	 * je nachdem, ob ein Administrator oder ein Mitarbeiter eingeloggt ist, 
	 * angepasste Möglichkeiten.  
	 * @wbp.parser.entryPoint
	 */
	public static JPanel getGUIMitarbeiter() {
		panel = new JPanel();
		panel.setBounds(0, 0, 1250, 750);
		
		panel.setLayout(null);
		
		JPanel panelMain = new JPanel();
		panelMain.setBackground(Color.DARK_GRAY);
		panelMain.setBounds(10, 2, 1224, 570);
		panelMain.setLayout(null);
		panel.add(panelMain);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Dialog", Font.BOLD, 13));
		tabbedPane.setBounds(10, 11, 1204, 541);
		panelMain.add(tabbedPane);
		
		tabbedPane.addTab("Artikelverwaltung", new GUIArtikelliste() );
		tabbedPane.addTab("Bestellungen", new GUIBestellungListe());
		
		if(LogStrg.getAngemeldetStatus() == 4) {
			tabbedPane.addTab("Administratoren", new GUIAdministratorListe());
			try {
				tabbedPane.addTab("Mitarbeiter", new GUIMitarbeiterListe());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		panel.setVisible(true);
		
		return panel;
	}
}
