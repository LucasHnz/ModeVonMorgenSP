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
public class GUIHerrenAccessoires {
	
	static JButton btnAlleArtikel;
	static JButton btnRinge;
	static JButton btnArmb‰nder;
	static JButton btnOhrringe;
	public JFrame frame;
	static JPanel panelMain;
	static JPanel panelHerrenAccessoires;
	static int anzahlArtikel = 0;

	/**
	 * L‰dt alle Artikel
	 */
	public static void ladeArtikel() {

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select Artikelnr from Accessoires where geschlecht = 'M' ";
			ResultSet rs = stmt.executeQuery(sql);
			anzahlArtikel = 0;

			while (rs.next()) {
				int artikelnr = rs.getInt("Artikelnr");
				panelHerrenAccessoires.add(GUINeuerArtikel.neuerArtikel(artikelnr));
				anzahlArtikel = anzahlArtikel + 1;

			}
			int length = anzahlArtikel / 2 * 188;
			if (anzahlArtikel % 2 == 1)
				length = length + 188;
			panelHerrenAccessoires.setPreferredSize(new Dimension(549, length));
			rs.close();
			Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	/**
	 * L‰dt alle Artikel vom Typ Ringe
	 */
	public static void ladeArtikelRinge() {

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select Artikelnr from Accessoires where geschlecht = 'M' and art = 'Ring' ";
			ResultSet rs = stmt.executeQuery(sql);
			anzahlArtikel = 0;

			while (rs.next()) {
				int artikelnr = rs.getInt("Artikelnr");
				panelHerrenAccessoires.add(GUINeuerArtikel.neuerArtikel(artikelnr));
				anzahlArtikel = anzahlArtikel + 1;

			}
			int length = anzahlArtikel / 2 * 188;
			if (anzahlArtikel % 2 == 1)
				length = length + 188;
			panelHerrenAccessoires.setPreferredSize(new Dimension(549, length));
			rs.close();
			Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	/**
	 * L‰dt Artikel vom Typ Armb‰nder
	 */
	public static void ladeArtikelArmb‰nder() {

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select Artikelnr from Accessoires where geschlecht = 'M' and art = 'Armband'";
			ResultSet rs = stmt.executeQuery(sql);
			anzahlArtikel = 0;

			while (rs.next()) {
				int artikelnr = rs.getInt("Artikelnr");
				panelHerrenAccessoires.add(GUINeuerArtikel.neuerArtikel(artikelnr));
				anzahlArtikel = anzahlArtikel + 1;

			}
			int length = anzahlArtikel / 2 * 188;
			if (anzahlArtikel % 2 == 1)
				length = length + 188;
			panelHerrenAccessoires.setPreferredSize(new Dimension(549, length));
			rs.close();
			Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	/**
	 * L‰dt Artikel vom Typ Ohrringe
	 */
	public static void ladeArtikelOhrringe() {

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select Artikelnr from Accessoires where geschlecht = 'M' and art = 'Ohrring' ";
			ResultSet rs = stmt.executeQuery(sql);
			anzahlArtikel = 0;

			while (rs.next()) {
				int artikelnr = rs.getInt("Artikelnr");
				panelHerrenAccessoires.add(GUINeuerArtikel.neuerArtikel(artikelnr));
				anzahlArtikel = anzahlArtikel + 1;

			}
			int length = anzahlArtikel / 2 * 188;
			if (anzahlArtikel % 2 == 1)
				length = length + 188;
			panelHerrenAccessoires.setPreferredSize(new Dimension(549, length));
			rs.close();
			Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Erzeugt und liefert das Frame f¸r Herren Accessoires
	 * 
	 * @returns panelMain Frame der Klasse GUIHerrenAccessoires
	 */
	static JPanel getGUIHerrenAccessoires() {

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
				panelHerrenAccessoires.removeAll();
				ladeArtikel();
				panelMain.revalidate();
				panelMain.repaint();
			}
		});
		panelScrollPaneLinks.add(btnAlleArtikel);

		btnRinge = new JButton("Ringe");
		btnRinge.setFont(new Font("Dialog", Font.BOLD, 15));
		btnRinge.setBackground(SystemColor.inactiveCaptionBorder);
		btnRinge.setBounds(10, 87, 248, 43);
		btnRinge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelHerrenAccessoires.removeAll();
				ladeArtikelRinge();
				panelMain.revalidate();
				panelMain.repaint();
			}
		});
		panelScrollPaneLinks.add(btnRinge);

		btnArmb‰nder = new JButton("Armb‰nder");
		btnArmb‰nder.setFont(new Font("Dialog", Font.BOLD, 15));
		btnArmb‰nder.setBackground(SystemColor.inactiveCaptionBorder);
		btnArmb‰nder.setBounds(10, 151, 248, 43);
		btnArmb‰nder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelHerrenAccessoires.removeAll();
				ladeArtikelArmb‰nder();
				panelMain.revalidate();
				panelMain.repaint();
			}
		});
		panelScrollPaneLinks.add(btnArmb‰nder);

		btnOhrringe = new JButton("Ohrringe");
		btnOhrringe.setFont(new Font("Dialog", Font.BOLD, 15));
		btnOhrringe.setBackground(SystemColor.inactiveCaptionBorder);
		btnOhrringe.setBounds(10, 215, 248, 43);
		btnOhrringe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelHerrenAccessoires.removeAll();
				ladeArtikelOhrringe();
				panelMain.revalidate();
				panelMain.repaint();
			}
		});
		panelScrollPaneLinks.add(btnOhrringe);

		panelHerrenAccessoires = new JPanel();
		panelHerrenAccessoires.setBackground(Color.WHITE);
		panelHerrenAccessoires.setAutoscrolls(true);

		JScrollPane scrollPaneHerrenSchuhe = new JScrollPane();
		scrollPaneHerrenSchuhe.setBounds(323, 97, 901, 455);
		scrollPaneHerrenSchuhe.setViewportView(panelHerrenAccessoires);
		scrollPaneHerrenSchuhe.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		panelMain.add(scrollPaneHerrenSchuhe);

		ladeArtikel();
		panelHerrenAccessoires.setLayout(new GridLayout(0, 2, 0, 0));

		panelMain.setVisible(true);
		return panelMain;
	}

}