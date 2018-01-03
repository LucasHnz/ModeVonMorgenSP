package Frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import KundenVerwaltung.Bestandskunde;
import KundenVerwaltung.BestandskundeSammlung;
import KundenVerwaltung.BestandskundeStrg;
import Logverwaltung.LogStrg;
import RechnungVerwaltung.Bestellung;

public class GUIKontoVerwalten {
	
	private static int nutzernummer;
	private static JPanel panel;
	
	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public static JPanel getGUIKontoVerwalten() {
		panel = new JPanel();
		panel.setBounds(0, 0, 1248, 563);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 1228, 541);
		panel.add(tabbedPane);
		
		nutzernummer = LogStrg.getNutzerNr();
		tabbedPane.addTab("Nutzerdaten �ndern", GUIBestandskundeBearbeiten.getGUIBestandskundeBearbeiten(nutzernummer));
		tabbedPane.addTab("Bestellungen", new GUIKontoBestellungen(nutzernummer));
	
		/**
		JButton btnKontoL�schen = new JButton("Konto L�schen");
		btnKontoL�schen.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnKontoL�schen.setBackground(Color.WHITE);
		btnKontoL�schen.setBounds(976, 179, 215, 48);
		panel.add(btnKontoL�schen);
		**/
		panel.setVisible(true);
		
		return panel;
	}
}