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
	
	JButton btnZur�ck = new JButton();
	JButton btnAnmelden = new JButton();
	JButton btnHinz = new JButton();
	JPanel panelMain = new JPanel();
	public JButton btnZumArtikel = new JButton();
	public JButton btnZumArtikel2 = new JButton();
	public JPanel panelHerrenKleidung = new JPanel();
	public int abstandPlus = 230;
	public int abstand = 270;
	
	
	

	public JFrame frame = new JFrame();
	static JPanel panel = new JPanel();

	/**
	 * Create the application.
	 */
	public GUIHerrenKleidung(JFrame frame) {
		System.out.println("Ausgef�hrt HK");
		this.frame = frame;
		initialize(frame);
		
	}
	
	public  void artikelLaden() {
		

		try {
		System.out.println("1");
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		String sql = "select bezeichnung, art, preis, verf�gbarkeit, bild from Kleidung where geschlecht = 'm'";
		ResultSet rs = stmt.executeQuery(sql);
		
		if(rs.next()) {
			System.out.println("2");
			String artikelBezeichnung = rs.getString("bezeichnung");
			Double artikelPreis = rs.getDouble("preis"); 
			String artikelVerf�gbarkeit = rs.getString("status"); 
			String artikelArt = rs.getString("art");
			Blob artikelBild = rs.getBlob("bild");
			System.out.println("Artikel + "+ artikelBezeichnung);
			neuerArtikel(artikelBezeichnung, artikelPreis, artikelVerf�gbarkeit, artikelArt);
		}
		
		rs.close();
		Datenbankverwaltung.VerbindungDB.schlie�eVerbindung(con, stmt);
		
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	
	}
	
	


	/**
	 * Initialize the contents of the frame.
	 */
	public void neuerArtikel(String artikelName, double artikelPreis, String artikelStatus, String artikelArt) {
		
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
		
		JLabel lblStatus = new JLabel(artikelVerf�gbarkeit);
		lblStatus.setForeground(new Color(0, 204, 51));
		lblStatus.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblStatus.setBounds(203, 41, 147, 30);
		panelArtikel.add(lblStatus);
		
		panelMain.add(panelArtikel);
		
	}
	

	private void initialize(JFrame frame) {
	
		panelMain = new JPanel();
		panelMain.setBackground(Color.WHITE);
		panelMain.setBounds(0, 148, 1234, 563);
		panelMain.setLayout(null);
		BuildPanel();
		
		JPanel panelScrollPaneBar = new JPanel();
		panelScrollPaneBar.setBackground(SystemColor.inactiveCaptionBorder);
		panelScrollPaneBar.setLayout(null);
		
		
		JScrollPane scrollPaneHerrenKleidungBar = new JScrollPane(panelScrollPaneBar);
		scrollPaneHerrenKleidungBar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneHerrenKleidungBar.setBounds(10, 97, 270, 455);
		panelMain.add(scrollPaneHerrenKleidungBar);
		
	
		panelHerrenKleidung = new JPanel();
		panelHerrenKleidung.setBackground(SystemColor.inactiveCaptionBorder);
		JScrollPane scrollPaneHerrenKleidung = new JScrollPane(panelHerrenKleidung);
		scrollPaneHerrenKleidung.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		panelHerrenKleidung.setPreferredSize(new Dimension(549, 2000));
		panelHerrenKleidung.setLayout(null);
		scrollPaneHerrenKleidung.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneHerrenKleidung.setBounds(323, 97, 901, 455);
		panelMain.add(scrollPaneHerrenKleidung);
		
		btnZur�ck = new JButton("Zur\u00FCck");
		btnZur�ck.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnZur�ck.setBackground(Color.WHITE);
		btnZur�ck.setBounds(10, 11, 89, 35);
		btnZur�ck.addActionListener(this);
		panelMain.add(btnZur�ck);
		
		JButton btnNewButton = new JButton("Jacken");
		btnNewButton.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnNewButton.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton.setBounds(10, 23, 248, 43);
		panelScrollPaneBar.add(btnNewButton);
		
		JButton btnShirts = new JButton("Shirts");
		btnShirts.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnShirts.setBackground(SystemColor.inactiveCaptionBorder);
		btnShirts.setBounds(10, 87, 248, 43);
		panelScrollPaneBar.add(btnShirts);
		
		JButton btnHosen = new JButton("Hosen");
		btnHosen.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnHosen.setBackground(SystemColor.inactiveCaptionBorder);
		btnHosen.setBounds(10, 151, 248, 43);
		panelScrollPaneBar.add(btnHosen);
		
		
		artikelLaden();
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

	
	public static void BuildPanel() {
	panel.setAutoscrolls(true);
	panel.setOpaque(false);
	panel.setBackground(SystemColor.inactiveCaptionBorder);
	
	int length = Warenkorb.getWarenkorb().size() * 100;
	panel.setPreferredSize(new Dimension(270, length));
	
	for (Map.Entry<Integer, Integer> entry : Warenkorb.getWarenkorb().entrySet()) {
	    Integer artikelnummer = entry.getKey();
	    Integer anzahl = entry.getValue();
	    panel.add(new GUIWarenkorbArtikel(artikelnummer, anzahl));
	 
	}		
	panel.setLayout(new GridLayout(0, 2, 0, 0));
	}
	

	public void hinzuf�genArtikel() {
		
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
		if(e.getSource() == btnZur�ck) 
		{
			panelMain.setVisible(false);
			GUI.panelMain.setVisible(true);
		}
       
	}
}
