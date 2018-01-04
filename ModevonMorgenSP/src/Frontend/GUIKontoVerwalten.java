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

import BestellungVerwaltung.Bestellung;
import KundenVerwaltung.Bestandskunde;
import KundenVerwaltung.BestandskundeSammlung;
import KundenVerwaltung.BestandskundeStrg;
import Logverwaltung.LogStrg;

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
		tabbedPane.addTab("Nutzerdaten ändern", GUIBestandskundeBearbeiten.getGUIBestandskundeBearbeiten(nutzernummer));
		tabbedPane.addTab("Bestellungen", new GUIKontoBestellungen(nutzernummer));
	
		/**
		JButton btnKontoLöschen = new JButton("Konto Löschen");
		btnKontoLöschen.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnKontoLöschen.setBackground(Color.WHITE);
		btnKontoLöschen.setBounds(976, 179, 215, 48);
		panel.add(btnKontoLöschen);
		**/
		panel.setVisible(true);
		
		return panel;
	}
}