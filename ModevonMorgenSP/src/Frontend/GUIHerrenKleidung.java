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
	
	static JButton btnZurück = new JButton();
	static JButton btnAnmelden = new JButton();
	static JButton btnJacken = new JButton();
	static JButton btnHandschuhe = new JButton();
	static JButton btnHosen = new JButton();
	static JButton btnHinz = new JButton();
	static JPanel panelMain = new JPanel();
	static public JButton btnZumArtikel = new JButton();
	static public JButton btnZumArtikel2 = new JButton();
	static public JPanel panelHerrenKleidung;
	static public int abstandPlus = 230;
	static public int abstand = 270;
	static public int anzahlArtikel = 0;
	

	/**
	 * Create the application.
	 */
	
	public static void ladeArtikel() {
	
		try {
		System.out.println("1");
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		String sql = "select Artikelnr, bezeichnung, art, preis, verfügbarkeit from Kleidung where geschlecht = 'W' ";	
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			System.out.println("2");
			int artikelnr = rs.getInt("Artikelnr");
			String artikelBezeichnung = rs.getString("Bezeichnung");
			Double artikelPreis = rs.getDouble("Preis"); 
			String artikelVerfügbarkeit = rs.getString("Verfügbarkeit"); 
			String artikelArt = rs.getString("Art");
			//Blob artikelBild = rs.getBlob("bild");
			System.out.println("Artikel + "+ artikelBezeichnung);
			neuerArtikel(artikelnr, artikelBezeichnung, artikelPreis, artikelVerfügbarkeit, artikelArt);
			anzahlArtikel = anzahlArtikel +1;
		}
		System.out.println(anzahlArtikel);
		rs.close();
		Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void ladeArtikelJacken() {
		
		try {
			System.out.println("1");
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select Artikelnr, bezeichnung, art, preis, verfügbarkeit from Kleidung where geschlecht = 'W' and art = 'Jacke' ";	
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("2");
				int artikelnr = rs.getInt("Artikelnr");
				String artikelBezeichnung = rs.getString("Bezeichnung");
				Double artikelPreis = rs.getDouble("Preis"); 
				String artikelVerfügbarkeit = rs.getString("Verfügbarkeit"); 
				String artikelArt = rs.getString("Art");
				//Blob artikelBild = rs.getBlob("bild");
				System.out.println("Artikel + "+ artikelBezeichnung);
				neuerArtikel(artikelnr, artikelBezeichnung, artikelPreis, artikelVerfügbarkeit, artikelArt);
				anzahlArtikel = anzahlArtikel +1;
			}
			System.out.println(anzahlArtikel);
			rs.close();
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static void ladeArtikelHosen() {
		
		try {
			System.out.println("1");
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select Artikelnr, bezeichnung, art, preis, verfügbarkeit from Kleidung where geschlecht = 'W' and art = 'Hose' ";	
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("2");
				int artikelnr = rs.getInt("Artikelnr");
				String artikelBezeichnung = rs.getString("Bezeichnung");
				Double artikelPreis = rs.getDouble("Preis"); 
				String artikelVerfügbarkeit = rs.getString("Verfügbarkeit"); 
				String artikelArt = rs.getString("Art");
				//Blob artikelBild = rs.getBlob("bild");
				System.out.println("Artikel + "+ artikelBezeichnung);
				neuerArtikel(artikelnr, artikelBezeichnung, artikelPreis, artikelVerfügbarkeit, artikelArt);
				anzahlArtikel = anzahlArtikel +1;
			}
			System.out.println(anzahlArtikel);
			rs.close();
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public static void neuerArtikel(int artikelnummer, String artikelBezeichnung, double artikelPreis, String artikelVerfügbarkeit, String artikelArt) {
		
		JPanel panelArtikel = new JPanel();
		panelArtikel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelArtikel.setBackground(SystemColor.inactiveCaption);
		panelArtikel.setBounds(66, 30, 680, 188);
		panelHerrenKleidung.add(panelArtikel);
		panelArtikel.setLayout(null);
		
		
		JLabel labelArtikelBild = new JLabel("");
		labelArtikelBild.setHorizontalAlignment(SwingConstants.CENTER);
		labelArtikelBild.setVerticalAlignment(SwingConstants.TOP);
		labelArtikelBild.setBounds(10, 11, 166, 166);
		
		ImageIcon icon;
		if(Artikelsammlung.getArtikel(artikelnummer).getImage() != null) {
			icon = new ImageIcon(Artikelsammlung.getArtikel(artikelnummer).getImage());
		}
		else 
			icon = new ImageIcon("src/SWP-Bilder/NoPic.gif");
        Image img = icon.getImage().getScaledInstance(166, 166, Image.SCALE_SMOOTH);
        labelArtikelBild.setIcon(new ImageIcon(img));
		
		panelArtikel.add(labelArtikelBild);
		
		JLabel lblSchwarzeJackeDenim = new JLabel(artikelBezeichnung);
		lblSchwarzeJackeDenim.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblSchwarzeJackeDenim.setBounds(186, 11, 213, 30);
		panelArtikel.add(lblSchwarzeJackeDenim);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText(String.valueOf(artikelPreis) + "€");
		lblNewLabel.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		lblNewLabel.setBounds(186, 108, 101, 30);
		panelArtikel.add(lblNewLabel);
		
		JButton btnZumArtikel = new JButton("Zum Artikel");
		btnZumArtikel.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnZumArtikel.setBackground(Color.WHITE);
		btnZumArtikel.setBounds(186, 147, 139, 30);
		btnZumArtikel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
		panelArtikel.add(btnZumArtikel);
		
		JLabel lblStatus = new JLabel(artikelVerfügbarkeit);
		lblStatus.setForeground(new Color(0, 204, 51));
		lblStatus.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblStatus.setBounds(186, 67, 213, 30);
		panelArtikel.add(lblStatus);
		
		JLabel lblHersteller = new JLabel(Artikelsammlung.getArtikel(artikelnummer).getHersteller());
		lblHersteller.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblHersteller.setBounds(186, 40, 213, 30);
		panelArtikel.add(lblHersteller);
		
	}
	

	public static JPanel getGUIHerrenKleidung() {
	
		
		System.out.println("Das hier wird ausgeführt");
		panelMain.setBackground(Color.WHITE);
		panelMain.setBounds(0, 0, 1234, 563);
		panelMain.setLayout(null);
		
		btnZurück = new JButton("Zur\u00FCck");
		btnZurück.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnZurück.setBackground(Color.WHITE);
		btnZurück.setBounds(10, 11, 89, 35);
		btnZurück.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//GUI.changePanel(GUI.getPanelMain());
				
						}
		});
		panelMain.add(btnZurück);
		
		JPanel panelScrollPaneLinks = new JPanel();
		panelScrollPaneLinks.setBackground(SystemColor.inactiveCaptionBorder);
		panelScrollPaneLinks.setLayout(null);
		
		
		JScrollPane scrollPaneLinks = new JScrollPane(panelScrollPaneLinks);
		scrollPaneLinks.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneLinks.setBounds(10, 97, 270, 455);
		panelMain.add(scrollPaneLinks);
		
		btnJacken = new JButton("Jacken");
		btnJacken.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnJacken.setBackground(SystemColor.inactiveCaptionBorder);
		btnJacken.setBounds(10, 23, 248, 43);
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
		btnHosen.setFont(new Font("Lucida Bright", Font.BOLD, 15));
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
		btnHandschuhe.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnHandschuhe.setBackground(SystemColor.inactiveCaptionBorder);
		btnHandschuhe.setBounds(10, 87, 248, 43);
		panelScrollPaneLinks.add(btnHandschuhe);
		
		panelHerrenKleidung = new JPanel();
		panelHerrenKleidung.setBackground(SystemColor.inactiveCaptionBorder);
		panelHerrenKleidung.setAutoscrolls(true);
			
		JScrollPane scrollPaneHerrenKleidung = new JScrollPane();
		scrollPaneHerrenKleidung.setBounds(323, 97, 901, 455);
		scrollPaneHerrenKleidung.setViewportView(panelHerrenKleidung);
		scrollPaneHerrenKleidung.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		panelMain.add(scrollPaneHerrenKleidung);
		
		ladeArtikel();
		
		int length = anzahlArtikel/2 * 188;
		if(anzahlArtikel%2 == 1)
			length = length +188;
		panelHerrenKleidung.setLayout(new GridLayout(0, 2, 0, 0));
		panelHerrenKleidung.setPreferredSize(new Dimension(549, length));
		
		
		panelMain.setVisible(true);
		return panelMain;
	}
	
	
	public static ImageIcon bildAnpassen(String imageRoot) {
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(imageRoot).getImage().getScaledInstance(133, 135, Image.SCALE_DEFAULT));
		return imageIcon;
	}	
}
