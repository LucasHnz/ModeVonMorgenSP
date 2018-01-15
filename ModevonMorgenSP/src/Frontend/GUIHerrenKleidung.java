package Frontend;

/**
 * 
 * @author Hinz
 *
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Artikelverwaltung.Artikelsammlung;
import Warenkorbverwaltung.Warenkorb;

public class GUIHerrenKleidung {

	static JButton btnJacken = new JButton();
	static JButton btnAlleArtikel = new JButton();
	static JButton btnHandschuhe = new JButton();
	static JButton btnHosen = new JButton();
	static JPanel panelMain = new JPanel();
	static public JPanel panelHerrenKleidung;
	static public int anzahlArtikel = 0;

	/**
	 * L�dt alle Artikel der Kategorie Herren Kleidung
	 *            
	 */
	public static void ladeArtikel() {

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select Artikelnr from Kleidung where geschlecht = 'M' ";
			ResultSet rs = stmt.executeQuery(sql);
			anzahlArtikel = 0;

			while (rs.next()) {
				int artikelnr = rs.getInt("Artikelnr");
				panelHerrenKleidung.add(GUINeuerArtikel.neuerArtikel(artikelnr));
				anzahlArtikel = anzahlArtikel + 1;

			}
			int length = anzahlArtikel / 2 * 188;
			if (anzahlArtikel % 2 == 1)
				length = length + 188;
			panelHerrenKleidung.setPreferredSize(new Dimension(549, length));
			rs.close();
			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		GUI.getFenster().revalidate();
		GUI.getFenster().repaint();
	}
	
	/**
	 * L�dt Artikel vom Typ Jacken
	 *            
	 */
	public static void ladeArtikelJacken() {

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select Artikelnr from Kleidung where geschlecht = 'M' and art = 'Jacke' ";
			ResultSet rs = stmt.executeQuery(sql);
			anzahlArtikel = 0;

			while (rs.next()) {
				int artikelnr = rs.getInt("Artikelnr");
				panelHerrenKleidung.add(GUINeuerArtikel.neuerArtikel(artikelnr));
				anzahlArtikel = anzahlArtikel + 1;
			}
			int length = anzahlArtikel / 2 * 188;
			if (anzahlArtikel % 2 == 1)
				length = length + 188;
			panelHerrenKleidung.setPreferredSize(new Dimension(549, length));
			rs.close();
			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * L�dt Artikel vom Typ Hosen
	 *      
	 */
	public static void ladeArtikelHosen() {

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select Artikelnr from Kleidung where geschlecht = 'M' and art = 'Hose' ";
			ResultSet rs = stmt.executeQuery(sql);
			anzahlArtikel = 0;

			while (rs.next()) {
				int artikelnr = rs.getInt("Artikelnr");
				panelHerrenKleidung.add(GUINeuerArtikel.neuerArtikel(artikelnr));
				anzahlArtikel = anzahlArtikel + 1;
			}
			int length = anzahlArtikel / 2 * 188;
			if (anzahlArtikel % 2 == 1)
				length = length + 188;
			panelHerrenKleidung.setPreferredSize(new Dimension(549, length));
			rs.close();
			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * L�dt und errechnet die Rabttpreise
	 * 
	 * @returns panelMain Frame der Klasse GUIHerrenKleidung
	 *            
	 */
	public static JPanel getGUIHerrenKleidung() {

		panelMain.setBackground(Color.WHITE);
		panelMain.setBounds(0, 0, 1234, 563);
		panelMain.setLayout(null);

		JPanel panelScrollPaneLinks = new JPanel();
		panelScrollPaneLinks.setBackground(SystemColor.inactiveCaptionBorder);
		panelScrollPaneLinks.setLayout(null);

		JScrollPane scrollPaneLinks = new JScrollPane(panelScrollPaneLinks);
		scrollPaneLinks.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneLinks.setBounds(10, 97, 270, 455);
		panelMain.add(scrollPaneLinks);

		btnAlleArtikel = new JButton("Alle Artikel");
		btnAlleArtikel.setFont(new Font("Dialog", Font.BOLD, 15));
		btnAlleArtikel.setBackground(SystemColor.inactiveCaptionBorder);
		btnAlleArtikel.setBounds(10, 23, 248, 43);
		btnAlleArtikel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelHerrenKleidung.removeAll();
				ladeArtikel();
				panelMain.revalidate();
				panelMain.repaint();
			}
		});
		panelScrollPaneLinks.add(btnAlleArtikel);

		btnJacken = new JButton("Jacken");
		btnJacken.setFont(new Font("Dialog", Font.BOLD, 15));
		btnJacken.setBackground(SystemColor.inactiveCaptionBorder);
		btnJacken.setBounds(10, 87, 248, 43);
		btnJacken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelHerrenKleidung.removeAll();
				ladeArtikelJacken();
				panelMain.revalidate();
				panelMain.repaint();
			}
		});
		panelScrollPaneLinks.add(btnJacken);

		btnHosen = new JButton("Hosen");
		btnHosen.setFont(new Font("Dialog", Font.BOLD, 15));
		btnHosen.setBackground(SystemColor.inactiveCaptionBorder);
		btnHosen.setBounds(10, 151, 248, 43);
		btnHosen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelHerrenKleidung.removeAll();
				ladeArtikelHosen();
				panelMain.revalidate();
				panelMain.repaint();
			}

		});
		panelScrollPaneLinks.add(btnHosen);

		btnHandschuhe = new JButton("Handschuhe");
		btnHandschuhe.setFont(new Font("Dialog", Font.BOLD, 15));
		btnHandschuhe.setBackground(SystemColor.inactiveCaptionBorder);
		btnHandschuhe.setBounds(10, 215, 248, 43);
		panelScrollPaneLinks.add(btnHandschuhe);

		panelHerrenKleidung = new JPanel();
		panelHerrenKleidung.setBackground(Color.WHITE);
		panelHerrenKleidung.setAutoscrolls(true);

		JScrollPane scrollPaneHerrenKleidung = new JScrollPane();
		scrollPaneHerrenKleidung.setBounds(323, 97, 901, 455);
		scrollPaneHerrenKleidung.setViewportView(panelHerrenKleidung);
		scrollPaneHerrenKleidung.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		panelMain.add(scrollPaneHerrenKleidung);

		ladeArtikel();
		panelHerrenKleidung.setLayout(new GridLayout(0, 2, 0, 0));

		panelMain.setVisible(true);
		return panelMain;
	}

}
