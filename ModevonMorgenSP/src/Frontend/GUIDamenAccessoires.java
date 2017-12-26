package Frontend;

/**
 * 
 * @author Hinz
 *
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class GUIDamenAccessoires implements ActionListener {
	
	JButton btnZurück = new JButton();
	JButton btnAnmelden = new JButton();
	
	private JTextField txtSchwarzeJacke;
	private JTextField textField_1;
	private JTextField txtGre;

	public JFrame frame;
	JPanel panelMain = new JPanel();
	JPanel panelDamenAccessoires = new JPanel();
	public int anzahlArtikel = 0;

	
	public  void artikelLaden() {
		

		try {
		System.out.println("1");
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		String sql = "select bezeichnung, art, preis, verfügbarkeit from Accessoires where geschlecht = 'W' ";	
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
	
	public void neuerArtikel(String artikelBezeichnung, double artikelPreis, String artikelVerfügbarkeit, String artikelArt) {
		
		JPanel panelArtikel = new JPanel();
		panelArtikel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelArtikel.setBackground(SystemColor.inactiveCaption);
		panelArtikel.setBounds(66, 30, 680, 188);
		panelDamenAccessoires.add(panelArtikel);
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
	
	public GUIDamenAccessoires(JFrame frame) {
		System.out.println("Ausgeführt DA");
		this.frame = frame;
		initialize(frame);
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
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
		panelScrollPaneLinks.setBackground(SystemColor.control);
		panelScrollPaneLinks.setLayout(null);
		
		JScrollPane scrollPaneDamenAccessoiresLinks = new JScrollPane(panelScrollPaneLinks);
		scrollPaneDamenAccessoiresLinks.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneDamenAccessoiresLinks.setBounds(10, 97, 270, 455);
		panelMain.add(scrollPaneDamenAccessoiresLinks);
		
		JButton btnNewButton = new JButton("Jacken");
		btnNewButton.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(10, 23, 248, 43);
		panelScrollPaneLinks.add(btnNewButton);
		
		JButton btnShirts = new JButton("Shirts");
		btnShirts.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnShirts.setBackground(Color.WHITE);
		btnShirts.setBounds(10, 87, 248, 43);
		panelScrollPaneLinks.add(btnShirts);
		
		JButton btnHosen = new JButton("Hosen");
		btnHosen.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnHosen.setBackground(Color.WHITE);
		btnHosen.setBounds(10, 151, 248, 43);
		panelScrollPaneLinks.add(btnHosen);
		
		panelDamenAccessoires = new JPanel();
		panelDamenAccessoires.setBackground(SystemColor.inactiveCaptionBorder);
		panelDamenAccessoires.setAutoscrolls(true);
		
		JScrollPane scrollPaneDamenAccessoires = new JScrollPane();
		scrollPaneDamenAccessoires.setBounds(323, 97, 901, 455);
		scrollPaneDamenAccessoires.setViewportView(panelDamenAccessoires);
		scrollPaneDamenAccessoires.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		panelMain.add(scrollPaneDamenAccessoires);
		
		artikelLaden();
		
		int length = anzahlArtikel/2 * 188;
		if(anzahlArtikel%2 == 1)
			length = length +188;
		panelDamenAccessoires.setLayout(new GridLayout(0, 2, 0, 0));
		panelDamenAccessoires.setPreferredSize(new Dimension(549, length));
		
		
		frame.add(panelMain);
		panelMain.setVisible(true);
		frame.invalidate();
		frame.validate();
		frame.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btnZurück) 
		{
			panelMain.setVisible(false);
			GUI.panelMain.setVisible(true);
		}
	}

}
