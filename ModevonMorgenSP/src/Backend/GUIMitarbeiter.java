package Backend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import Frontend.GUI;
import Frontend.GUIAnmelden;
import Frontend.GUIKontoBestellungen;
import Frontend.GUIKontoVerwalten;
import Logverwaltung.LogStrg;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JList;
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
