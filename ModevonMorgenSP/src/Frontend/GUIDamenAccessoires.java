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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
/**
 * 
 * @author Hinz

 *
 */
public class GUIDamenAccessoires {

	static JButton btnAlleArtikel;
	static JButton btnKopfschmuck;
	static JButton btnKetten;
	static JButton btnOhrringe;
	static JButton btnArmbänder;
	static JButton btnRinge;
	static JPanel panelMain;
	static JPanel panelDamenAccessoires;
	public static int anzahlArtikel = 0;

	/**
	 * Lädt alle Artikel
	 */
	public static void ladeArtikel() {

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select Artikelnr from Accessoires where geschlecht = 'W' ";
			ResultSet rs = stmt.executeQuery(sql);
			anzahlArtikel = 0;

			while (rs.next()) {
				int artikelnr = rs.getInt("Artikelnr");
				panelDamenAccessoires.add(GUINeuerArtikel.neuerArtikel(artikelnr));
				anzahlArtikel = anzahlArtikel + 1;
			}
			int length = anzahlArtikel / 2 * 188;
			if (anzahlArtikel % 2 == 1)
				length = length + 188;
			panelDamenAccessoires.setPreferredSize(new Dimension(549, length));

			rs.close();
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	/**
	 * Lädt Artikel vom Typ Kopfschmuck
	 */
	public static void ladeArtikelKopfschmuck() {

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select Artikelnr from Accessoires where geschlecht = 'W' and art = 'Kopfschmuck'";
			ResultSet rs = stmt.executeQuery(sql);
			anzahlArtikel = 0;

			while (rs.next()) {
				int artikelnr = rs.getInt("Artikelnr");
				panelDamenAccessoires.add(GUINeuerArtikel.neuerArtikel(artikelnr));
				anzahlArtikel = anzahlArtikel + 1;
			}
			int length = anzahlArtikel / 2 * 188;
			if (anzahlArtikel % 2 == 1)
				length = length + 188;
			panelDamenAccessoires.setPreferredSize(new Dimension(549, length));
			rs.close();
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		GUI.getFenster().revalidate();
		GUI.getFenster().repaint();
	}

	/**
	 * Lädt Artikel vom Typ Ketten
	 */
	public static void ladeArtikelKetten() {

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select Artikelnr from Accessoires where geschlecht = 'W' and art = 'Kette'";
			ResultSet rs = stmt.executeQuery(sql);
			anzahlArtikel = 0;

			while (rs.next()) {
				int artikelnr = rs.getInt("Artikelnr");
				panelDamenAccessoires.add(GUINeuerArtikel.neuerArtikel(artikelnr));
				anzahlArtikel = anzahlArtikel + 1;
			}
			int length = anzahlArtikel / 2 * 188;
			if (anzahlArtikel % 2 == 1)
				length = length + 188;
			panelDamenAccessoires.setPreferredSize(new Dimension(549, length));
			rs.close();
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		GUI.getFenster().revalidate();
		GUI.getFenster().repaint();
	}

	/**
	 * Lädt Artikel vom Typ Ohrringe
	 */
	public static void ladeArtikelOhrringe() {

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select Artikelnr from Accessoires where geschlecht = 'W' and art = 'Ohrring'";
			ResultSet rs = stmt.executeQuery(sql);
			anzahlArtikel = 0;

			while (rs.next()) {
				int artikelnr = rs.getInt("Artikelnr");
				panelDamenAccessoires.add(GUINeuerArtikel.neuerArtikel(artikelnr));
				anzahlArtikel = anzahlArtikel + 1;
				}
			int length = anzahlArtikel / 2 * 188;
			if (anzahlArtikel % 2 == 1)
				length = length + 188;
			panelDamenAccessoires.setPreferredSize(new Dimension(549, length));
			rs.close();
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		GUI.getFenster().revalidate();
		GUI.getFenster().repaint();
	}

	/**
	 * Lädt Artikel vom Typ Armbänder
	 */
	public static void ladeArtikelArmbänder() {

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select Artikelnr from Accessoires where geschlecht = 'W' and art = 'Armband'";
			ResultSet rs = stmt.executeQuery(sql);
			anzahlArtikel = 0;

			while (rs.next()) {
				int artikelnr = rs.getInt("Artikelnr");
				panelDamenAccessoires.add(GUINeuerArtikel.neuerArtikel(artikelnr));
				anzahlArtikel = anzahlArtikel + 1;
				
			}
			int length = anzahlArtikel / 2 * 188;
			if (anzahlArtikel % 2 == 1)
				length = length + 188;
			panelDamenAccessoires.setPreferredSize(new Dimension(549, length));
			rs.close();
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		GUI.getFenster().revalidate();
		GUI.getFenster().repaint();
	}

	/**
	 * Lädt Artikel vom Typ Ringe
	 */
	public static void ladeArtikelRinge() {

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select Artikelnr from Accessoires where geschlecht = 'W' and art = 'Ring'";
			ResultSet rs = stmt.executeQuery(sql);
			anzahlArtikel = 0;

			while (rs.next()) {
				int artikelnr = rs.getInt("Artikelnr");
				panelDamenAccessoires.add(GUINeuerArtikel.neuerArtikel(artikelnr));
				anzahlArtikel = anzahlArtikel + 1;
			}
			int length = anzahlArtikel / 2 * 188;
			if (anzahlArtikel % 2 == 1)
				length = length + 188;
			panelDamenAccessoires.setSize(new Dimension(549, length));
			rs.close();
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		GUI.getFenster().revalidate();
		GUI.getFenster().repaint();
	}

	/**
	 * Erstellt und Liefert Fenster für DamenAccessoires
	 * @return panelMain Frame für DamenAccessoires
	 * @wbp.parser.entryPoint
	 */
	static JPanel getGUIDamenAccessoires() {

		panelMain = new JPanel();
		panelMain.setBackground(Color.WHITE);
		panelMain.setBounds(0, 0, 1234, 563);
		panelMain.setLayout(null);

		JPanel panelScrollPaneLinks = new JPanel();
		panelScrollPaneLinks.setBackground(SystemColor.inactiveCaptionBorder);
		panelScrollPaneLinks.setLayout(null);

		JScrollPane scrollPaneDamenAccessoiresLinks = new JScrollPane(panelScrollPaneLinks);
		scrollPaneDamenAccessoiresLinks.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneDamenAccessoiresLinks.setBounds(10, 11, 270, 541);
		panelMain.add(scrollPaneDamenAccessoiresLinks);

		btnAlleArtikel = new JButton("Alle Artikel");
		btnAlleArtikel.setFont(new Font("Dialog", Font.BOLD, 15));
		btnAlleArtikel.setBackground(SystemColor.inactiveCaptionBorder);
		btnAlleArtikel.setBounds(10, 23, 248, 43);
		btnAlleArtikel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelDamenAccessoires.removeAll();
				ladeArtikel();
				panelMain.revalidate();
				panelMain.repaint();
			}
		});
		panelScrollPaneLinks.add(btnAlleArtikel);

		btnKopfschmuck = new JButton("Kopfschmuck");
		btnKopfschmuck.setFont(new Font("Dialog", Font.BOLD, 15));
		btnKopfschmuck.setBackground(SystemColor.inactiveCaptionBorder);
		btnKopfschmuck.setBounds(10, 87, 248, 43);
		btnKopfschmuck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelDamenAccessoires.removeAll();
				ladeArtikelKopfschmuck();
				panelMain.revalidate();
				panelMain.repaint();
			}
		});
		panelScrollPaneLinks.add(btnKopfschmuck);

		btnKetten = new JButton("Ketten");
		btnKetten.setFont(new Font("Dialog", Font.BOLD, 15));
		btnKetten.setBackground(SystemColor.inactiveCaptionBorder);
		btnKetten.setBounds(10, 151, 248, 43);
		btnKetten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelDamenAccessoires.removeAll();
				ladeArtikelKetten();
				panelMain.revalidate();
				panelMain.repaint();
			}
		});
		panelScrollPaneLinks.add(btnKetten);

		btnOhrringe = new JButton("Ohrringe");
		btnOhrringe.setFont(new Font("Dialog", Font.BOLD, 15));
		btnOhrringe.setBackground(SystemColor.inactiveCaptionBorder);
		btnOhrringe.setBounds(10, 215, 248, 43);
		btnOhrringe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelDamenAccessoires.removeAll();
				ladeArtikelOhrringe();
				panelMain.revalidate();
				panelMain.repaint();
			}
		});
		panelScrollPaneLinks.add(btnOhrringe);

		btnArmbänder = new JButton("Armbänder");
		btnArmbänder.setFont(new Font("Dialog", Font.BOLD, 15));
		btnArmbänder.setBackground(SystemColor.inactiveCaptionBorder);
		btnArmbänder.setBounds(10, 279, 248, 43);
		btnArmbänder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelDamenAccessoires.removeAll();
				ladeArtikelArmbänder();
				panelMain.revalidate();
				panelMain.repaint();
			}
		});
		panelScrollPaneLinks.add(btnArmbänder);

		btnRinge = new JButton("Ringe");
		btnRinge.setFont(new Font("Dialog", Font.BOLD, 15));
		btnRinge.setBackground(SystemColor.inactiveCaptionBorder);
		btnRinge.setBounds(10, 343, 248, 43);
		btnRinge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelDamenAccessoires.removeAll();
				ladeArtikelRinge();
				panelMain.revalidate();
				panelMain.repaint();
			}
		});
		panelScrollPaneLinks.add(btnRinge);

		panelDamenAccessoires = new JPanel();
		panelDamenAccessoires.setBackground(Color.WHITE);
		panelDamenAccessoires.setAutoscrolls(true);

		JScrollPane scrollPaneDamenAccessoires = new JScrollPane();
		scrollPaneDamenAccessoires.setBounds(323, 11, 901, 541);
		scrollPaneDamenAccessoires.setViewportView(panelDamenAccessoires);
		scrollPaneDamenAccessoires.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		panelMain.add(scrollPaneDamenAccessoires);

		ladeArtikel();
		panelDamenAccessoires.setLayout(new GridLayout(0, 2, 0, 0));
		
		panelMain.setVisible(true);
		return panelMain;
	}

}
