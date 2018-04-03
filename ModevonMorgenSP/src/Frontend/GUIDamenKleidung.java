package Frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
/**
 * 
 * @author Hinz

 *
 */
public class GUIDamenKleidung {

	static JButton btnAlleArtikel;
	static JButton btnSchals;
	static JButton btnHosen;
	public JFrame frame;
	static JPanel panelMain;
	static JPanel panelDamenKleidung;
	static int anzahlArtikel = 0;

	/**
	 * Lädt alle Artikel
	 */
	public static void ladeArtikel() {

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select Artikelnr from Kleidung where geschlecht = 'W'";
			ResultSet rs = stmt.executeQuery(sql);
			anzahlArtikel = 0;

			while (rs.next()) {
				int artikelnr = rs.getInt("Artikelnr");
				panelDamenKleidung.add(GUINeuerArtikel.neuerArtikel(artikelnr));
				anzahlArtikel = anzahlArtikel + 1;
			}
			int length = anzahlArtikel / 2 * 188;
			if (anzahlArtikel % 2 == 1)
				length = length + 188;
			panelDamenKleidung.setPreferredSize(new Dimension(549, length));
			rs.close();
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		GUI.getFenster().revalidate();
		GUI.getFenster().repaint();
	}
	
	/**
	 * Lädt und Artikel vom Typ Schals
	 * 
	 */
	public static void ladeArtikelSchals() {

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select Artikelnr from Kleidung where geschlecht = 'W' and art = 'Schaal'";
			ResultSet rs = stmt.executeQuery(sql);
			anzahlArtikel = 0;

			while (rs.next()) {
				int artikelnr = rs.getInt("Artikelnr");
				panelDamenKleidung.add(GUINeuerArtikel.neuerArtikel(artikelnr));
				anzahlArtikel = anzahlArtikel + 1;
			}
			int length = anzahlArtikel / 2 * 188;
			if (anzahlArtikel % 2 == 1)
				length = length + 188;
			panelDamenKleidung.setPreferredSize(new Dimension(549, length));
			rs.close();
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		GUI.getFenster().revalidate();
		GUI.getFenster().repaint();
	}
	
	/**
	 * Lädt Artikel vom Typ Hosen
	 * 
	 */
	public static void ladeArtikelHosen() {

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select Artikelnr from Kleidung where geschlecht = 'W' and art = 'Hose'";
			ResultSet rs = stmt.executeQuery(sql);
			anzahlArtikel = 0;

			while (rs.next()) {
				int artikelnr = rs.getInt("Artikelnr");
				panelDamenKleidung.add(GUINeuerArtikel.neuerArtikel(artikelnr));
				anzahlArtikel = anzahlArtikel + 1;
			}
			int length = anzahlArtikel / 2 * 188;
			if (anzahlArtikel % 2 == 1)
				length = length + 188;
			panelDamenKleidung.setPreferredSize(new Dimension(549, length));
			rs.close();
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		GUI.getFenster().revalidate();
		GUI.getFenster().repaint();
	}

	/**
	 * Erzeugt und liefert das Frame für DamenKleidung
	 * @returns panelMain Fenster für DamenKleidung
	 * @wbp.parser.entryPoint
	 */
	static JPanel getGUIDamenKleidung() {

		panelMain = new JPanel();
		panelMain.setBackground(Color.WHITE);
		panelMain.setBounds(0, 0, 1234, 563);
		panelMain.setLayout(null);

		JPanel panelScrollPaneLinks = new JPanel();
		panelScrollPaneLinks.setBackground(SystemColor.inactiveCaptionBorder);
		panelScrollPaneLinks.setLayout(null);

		JScrollPane scrollPaneLinks = new JScrollPane(panelScrollPaneLinks);
		scrollPaneLinks.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneLinks.setBounds(10, 11, 270, 541);
		panelMain.add(scrollPaneLinks);

		btnAlleArtikel = new JButton("Alle Artikel");
		btnAlleArtikel.setFont(new Font("Dialog", Font.BOLD, 15));
		btnAlleArtikel.setBackground(SystemColor.inactiveCaptionBorder);
		btnAlleArtikel.setBounds(10, 23, 248, 43);
		btnAlleArtikel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelDamenKleidung.removeAll();
				ladeArtikel();
				panelMain.revalidate();
				panelMain.repaint();
			}
		});
		panelScrollPaneLinks.add(btnAlleArtikel);

		btnSchals = new JButton("Schals");
		btnSchals.setFont(new Font("Dialog", Font.BOLD, 15));
		btnSchals.setBackground(SystemColor.inactiveCaptionBorder);
		btnSchals.setBounds(10, 87, 248, 43);
		btnSchals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelDamenKleidung.removeAll();
				ladeArtikelSchals();
				panelMain.revalidate();
				panelMain.repaint();
			}
		});
		panelScrollPaneLinks.add(btnSchals);

		btnHosen = new JButton("Hosen");
		btnHosen.setFont(new Font("Dialog", Font.BOLD, 15));
		btnHosen.setBackground(SystemColor.inactiveCaptionBorder);
		btnHosen.setBounds(10, 151, 248, 43);
		btnHosen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelDamenKleidung.removeAll();
				ladeArtikelHosen();
				panelMain.revalidate();
				panelMain.repaint();
			}
		});
		panelScrollPaneLinks.add(btnHosen);

		panelDamenKleidung = new JPanel();
		panelDamenKleidung.setBackground(Color.WHITE);
		panelDamenKleidung.setAutoscrolls(true);

		JScrollPane scrollPaneDamenKleidung = new JScrollPane();
		scrollPaneDamenKleidung.setBounds(323, 11, 901, 541);
		scrollPaneDamenKleidung.setViewportView(panelDamenKleidung);
		scrollPaneDamenKleidung.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		panelMain.add(scrollPaneDamenKleidung);

		ladeArtikel();
		panelDamenKleidung.setLayout(new GridLayout(0, 2, 0, 0));

		panelMain.setVisible(true);
		return panelMain;
	}

}