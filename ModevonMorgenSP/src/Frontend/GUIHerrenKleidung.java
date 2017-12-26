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

import Warenkorbverwaltung.Warenkorb;
//HSG
public class GUIHerrenKleidung implements ActionListener{
	
	JButton btnZurück = new JButton();
	JButton btnAnmelden = new JButton();
	JButton btnJacken = new JButton();
	JButton btnHinz = new JButton();
	JPanel panelMain = new JPanel();
	public JButton btnZumArtikel = new JButton();
	public JButton btnZumArtikel2 = new JButton();
	public JPanel panelHerrenKleidung;
	public int abstandPlus = 230;
	public int abstand = 270;
	public int anzahlArtikel = 0;
	
	
	

	public JFrame frame = new JFrame();
	static JPanel panel = new JPanel();

	/**
	 * Create the application.
	 */
	public GUIHerrenKleidung(JFrame frame) {
		System.out.println("Ausgeführt HK");
		this.frame = frame;
		initialize(frame);
		
	}
	
	public  void ladeArtikel() {
		

		try {
		System.out.println("1");
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		String sql = "select bezeichnung, art, preis, verfügbarkeit from Kleidung where geschlecht = 'W' ";	
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			System.out.println("2");
			String artikelBezeichnung = rs.getString("Bezeichnung");
			Double artikelPreis = rs.getDouble("Preis"); 
			String artikelVerfügbarkeit = rs.getString("Verfügbarkeit"); 
			String artikelArt = rs.getString("Art");
			//Blob artikelBild = rs.getBlob("bild");
			System.out.println("Artikel + "+ artikelBezeichnung);
			neuerArtikel(artikelBezeichnung, artikelPreis, artikelVerfügbarkeit, artikelArt);
			anzahlArtikel = anzahlArtikel +1;
		}
		System.out.println(anzahlArtikel);
		rs.close();
		Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	
	}
	
	public void ladeArtikelJacken() {
		
		try {
			System.out.println("1");
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select bezeichnung, art, preis, verfügbarkeit from Kleidung where geschlecht = 'W' and art = 'Jacke' ";	
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("2");
				String artikelBezeichnung = rs.getString("Bezeichnung");
				Double artikelPreis = rs.getDouble("Preis"); 
				String artikelVerfügbarkeit = rs.getString("Verfügbarkeit"); 
				String artikelArt = rs.getString("Art");
				//Blob artikelBild = rs.getBlob("bild");
				System.out.println("Artikel + "+ artikelBezeichnung);
				neuerArtikel(artikelBezeichnung, artikelPreis, artikelVerfügbarkeit, artikelArt);
				anzahlArtikel = anzahlArtikel +1;
			}
			System.out.println(anzahlArtikel);
			rs.close();
			Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
		frame.invalidate();
		frame.validate();
		frame.repaint();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void neuerArtikel(String artikelBezeichnung, double artikelPreis, String artikelVerfügbarkeit, String artikelArt) {
		
		JPanel panelArtikel = new JPanel();
		panelArtikel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelArtikel.setBackground(SystemColor.inactiveCaption);
		panelArtikel.setBounds(66, 30, 680, 188);
		panelHerrenKleidung.add(panelArtikel);
		panelArtikel.setLayout(null);
		
		/*
		ImageIcon icon = new ImageIcon(artikelBild);
        int width = icon.getIconHeight() / 2;
        int height = icon.getIconWidth() / 2;
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_FAST);
		*/
		
		JLabel labelArtikelBild = new JLabel("");
		labelArtikelBild.setHorizontalAlignment(SwingConstants.CENTER);
		labelArtikelBild.setVerticalAlignment(SwingConstants.TOP);
		//labelArtikelBild.setIcon(new ImageIcon(img));
		labelArtikelBild.setBounds(33, 25, 133, 135);
		panelArtikel.add(labelArtikelBild);
		
		JLabel lblSchwarzeJackeDenim = new JLabel(artikelBezeichnung);
		lblSchwarzeJackeDenim.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblSchwarzeJackeDenim.setBounds(203, 11, 213, 30);
		panelArtikel.add(lblSchwarzeJackeDenim);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText(String.valueOf(artikelPreis));
		lblNewLabel.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		lblNewLabel.setBounds(203, 71, 101, 47);
		panelArtikel.add(lblNewLabel);
		
		JButton btnZumArtikel = new JButton("Zum Artikel");
		btnZumArtikel.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnZumArtikel.setBackground(Color.WHITE);
		btnZumArtikel.setBounds(198, 130, 139, 30);
		btnZumArtikel.addActionListener(this);
		panelArtikel.add(btnZumArtikel);
		
		JLabel lblStatus = new JLabel(artikelVerfügbarkeit);
		lblStatus.setForeground(new Color(0, 204, 51));
		lblStatus.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblStatus.setBounds(203, 41, 147, 30);
		panelArtikel.add(lblStatus);
		
		
		
	}
	

	private void initialize(JFrame frame) {
	
		panelMain = new JPanel();
		panelMain.setBackground(Color.WHITE);
		panelMain.setBounds(0, 148, 1234, 563);
		panelMain.setLayout(null);
		
		btnZurück = new JButton("Zur\u00FCck");
		btnZurück.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnZurück.setBackground(Color.WHITE);
		btnZurück.setBounds(10, 11, 89, 35);
		btnZurück.addActionListener(this);
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
		btnJacken.addActionListener(this);
		panelScrollPaneLinks.add(btnJacken);
		
		JButton btnHandschuhe = new JButton("Shirts");
		btnHandschuhe.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnHandschuhe.setBackground(SystemColor.inactiveCaptionBorder);
		btnHandschuhe.setBounds(10, 87, 248, 43);
		panelScrollPaneLinks.add(btnHandschuhe);
		
		JButton btnHosen = new JButton("Hosen");
		btnHosen.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnHosen.setBackground(SystemColor.inactiveCaptionBorder);
		btnHosen.setBounds(10, 151, 248, 43);
		panelScrollPaneLinks.add(btnHosen);
		
		
		
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
		
		
		
		
		frame.add(panelMain);
		panelMain.setVisible(true);
		frame.invalidate();
		frame.validate();
		frame.repaint();
	}
	
	
	public ImageIcon bildAnpassen(String imageRoot) {
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(imageRoot).getImage().getScaledInstance(133, 135, Image.SCALE_DEFAULT));
		return imageIcon;
	}	

	public void hinzufügenArtikel() {
		
		System.out.println("HINZ");
		
		JPanel panelArtikel2 = new JPanel();
		panelArtikel2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelArtikel2.setBackground(SystemColor.inactiveCaption);
		panelArtikel2.setBounds(66, abstand, 680, 188);
		panelArtikel2.setLayout(null);
		
		
		ImageIcon icon2 = new ImageIcon("src\\SWP-Bilder\\Herrenjacke_6.jpg");
        int width2 = icon2.getIconHeight() / 2;
        int height2 = icon2.getIconWidth() / 2;
        Image img2 = icon2.getImage().getScaledInstance(width2, height2, Image.SCALE_FAST);
		
		JLabel labelArtikelBild2 = new JLabel("");
		labelArtikelBild2.setHorizontalAlignment(SwingConstants.CENTER);
		labelArtikelBild2.setVerticalAlignment(SwingConstants.TOP);
		labelArtikelBild2.setIcon(bildAnpassen("src\\SWP-Bilder\\Herrenjacke_6.jpg"));
		labelArtikelBild2.setBounds(33, 25, 133, 135);
		panelArtikel2.add(labelArtikelBild2);
		
		JLabel lblSchwarzeJackeDenim2 = new JLabel("Schwarze Jacke DENIM");
		lblSchwarzeJackeDenim2.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblSchwarzeJackeDenim2.setBounds(203, 11, 213, 30);
		panelArtikel2.add(lblSchwarzeJackeDenim2);
		
		JLabel lblNewLabel2 = new JLabel("Preis: 24\u20AC");
		lblNewLabel2.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		lblNewLabel2.setBounds(203, 71, 101, 47);
		panelArtikel2.add(lblNewLabel2);
		
		btnZumArtikel2 = new JButton("Zum Artikel");
		btnZumArtikel2.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnZumArtikel2.setBackground(Color.WHITE);
		btnZumArtikel2.setBounds(198, 130, 139, 30);
		btnZumArtikel2.addActionListener(this);
		panelArtikel2.add(btnZumArtikel2);
		
		JLabel lblStatus2 = new JLabel("Auf Lager");
		lblStatus2.setForeground(new Color(0, 204, 51));
		lblStatus2.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblStatus2.setBounds(203, 41, 147, 30);
		panelArtikel2.add(lblStatus2);
		
		
		panelHerrenKleidung.add(panelArtikel2);		
		frame.invalidate();
		frame.validate();
		frame.repaint();
		abstand = abstand + abstandPlus; 
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btnZurück) 
		{
			panelMain.setVisible(false);
			GUI.panelMain.setVisible(true);
		}
		if(e.getSource() == btnJacken) {
			panelHerrenKleidung.removeAll();
			ladeArtikelJacken();
		}
       
	}
}
