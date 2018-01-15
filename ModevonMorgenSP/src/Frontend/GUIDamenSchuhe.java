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

public class GUIDamenSchuhe {

	static JButton btnAlleArtikel;
	static JButton btnHausschuhe;
	static JButton btnHighHeels;
	public JFrame frame;
	static JPanel panelMain;
	static JPanel panelDamenSchuhe;
	public static int anzahlArtikel = 0;

	/**
	 * L�dt alle Artikel
	 */
	public static void ladeArtikel() {

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select Artikelnr from Schuhe where geschlecht = 'W' ";
			ResultSet rs = stmt.executeQuery(sql);
			anzahlArtikel = 0;

			while (rs.next()) {
				int artikelnr = rs.getInt("Artikelnr");
				panelDamenSchuhe.add(GUINeuerArtikel.neuerArtikel(artikelnr));
				anzahlArtikel = anzahlArtikel + 1;

			}
			int length = anzahlArtikel / 2 * 188;
			if (anzahlArtikel % 2 == 1)
				length = length + 188;
			panelDamenSchuhe.setPreferredSize(new Dimension(549, length));
			rs.close();
			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	/**
	 * L�dt Artikel vom Typ Hausschuhe
	 * 
	 */
	public static void ladeArtikelHausschuhe() {

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select Artikelnr from Schuhe where geschlecht = 'W' and art = 'Hausschuh' ";
			ResultSet rs = stmt.executeQuery(sql);
			anzahlArtikel = 0;

			while (rs.next()) {
				int artikelnr = rs.getInt("Artikelnr");
				panelDamenSchuhe.add(GUINeuerArtikel.neuerArtikel(artikelnr));
				anzahlArtikel = anzahlArtikel + 1;

				System.out.println("Artikel ist " + artikelnr);
			}
			int length = anzahlArtikel / 2 * 188;
			if (anzahlArtikel % 2 == 1)
				length = length + 188;
			panelDamenSchuhe.setPreferredSize(new Dimension(549, length));
			rs.close();
			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * L�dt Artikel vom Typ HighHeels
	 * 
	 */
	public static void ladeArtikelHighHeels() {

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select Artikelnr from Schuhe where geschlecht = 'W' and art = 'High Heels' ";
			ResultSet rs = stmt.executeQuery(sql);
			anzahlArtikel = 0;

			while (rs.next()) {
				int artikelnr = rs.getInt("Artikelnr");
				panelDamenSchuhe.add(GUINeuerArtikel.neuerArtikel(artikelnr));
				anzahlArtikel = anzahlArtikel + 1;

				System.out.println("Artikel ist " + artikelnr);
			}
			int length = anzahlArtikel / 2 * 188;
			if (anzahlArtikel % 2 == 1)
				length = length + 188;
			panelDamenSchuhe.setPreferredSize(new Dimension(549, length));
			rs.close();
			Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Erzeugt und Liefert Frame der Klasse DamenSchuhe
	 * 
	 * @returns panelMain Frame f�r DamenSchuhe
	 */
	static JPanel getGUIDamenSchuhe() {

		panelMain = new JPanel();
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
				panelDamenSchuhe.removeAll();
				ladeArtikel();
				panelMain.revalidate();
				panelMain.repaint();
			}
		});
		panelScrollPaneLinks.add(btnAlleArtikel);

		btnHausschuhe = new JButton("Hausschuhe");
		btnHausschuhe.setFont(new Font("Dialog", Font.BOLD, 15));
		btnHausschuhe.setBackground(SystemColor.inactiveCaptionBorder);
		btnHausschuhe.setBounds(10, 87, 248, 43);
		btnHausschuhe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelDamenSchuhe.removeAll();
				ladeArtikelHausschuhe();
				panelMain.revalidate();
				panelMain.repaint();
			}
		});
		panelScrollPaneLinks.add(btnHausschuhe);

		btnHighHeels = new JButton("High Heels");
		btnHighHeels.setFont(new Font("Dialog", Font.BOLD, 15));
		btnHighHeels.setBackground(SystemColor.inactiveCaptionBorder);
		btnHighHeels.setBounds(10, 151, 248, 43);
		btnHighHeels.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelDamenSchuhe.removeAll();
				ladeArtikelHighHeels();
				panelMain.revalidate();
				panelMain.repaint();
			}
		});
		panelScrollPaneLinks.add(btnHighHeels);

		panelDamenSchuhe = new JPanel();
		panelDamenSchuhe.setBackground(Color.WHITE);
		panelDamenSchuhe.setAutoscrolls(true);

		JScrollPane scrollPaneDamenSchuhe = new JScrollPane();
		scrollPaneDamenSchuhe.setBounds(323, 97, 901, 455);
		scrollPaneDamenSchuhe.setViewportView(panelDamenSchuhe);
		scrollPaneDamenSchuhe.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		panelMain.add(scrollPaneDamenSchuhe);

		ladeArtikel();
		panelDamenSchuhe.setLayout(new GridLayout(0, 2, 0, 0));

		panelMain.setVisible(true);
		return panelMain;
	}

}