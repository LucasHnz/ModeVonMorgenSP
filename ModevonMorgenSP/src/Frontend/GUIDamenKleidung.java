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

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;

public class GUIDamenKleidung {
	

	JButton btnAnmelden = new JButton();
	static JButton btnAlleArtikel;
	static JButton btnSchaals;
	static JButton btnHosen;
	


	public JFrame frame;
	static JPanel panelMain = new JPanel();
	static JPanel panelDamenKleidung = new JPanel();
 	private JTextField txtSchwarzeJacke;
	private JTextField textField_1;
	private JTextField txtGre;
	static int anzahlArtikel = 0;

	public static void ladeArtikel() {
		
		try {
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		String sql = "select Artikelnr from Kleidung where geschlecht = 'M'";	
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			int artikelnr = rs.getInt("Artikelnr");
			panelDamenKleidung.add(GUINeuerArtikel.neuerArtikel(artikelnr));
			anzahlArtikel = anzahlArtikel +1;
		}
		rs.close();
		Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		GUI.getFenster().revalidate();
		GUI.getFenster().repaint();
	}
	
public static void ladeArtikelSchaals() {
		
		try {
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		String sql = "select Artikelnr from Kleidung where geschlecht = 'M' and art = 'Schaal'";	
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			int artikelnr = rs.getInt("Artikelnr");
			panelDamenKleidung.add(GUINeuerArtikel.neuerArtikel(artikelnr));
			anzahlArtikel = anzahlArtikel +1;
		}
		rs.close();
		Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		GUI.getFenster().revalidate();
		GUI.getFenster().repaint();
	}

public static void ladeArtikelHosen() {
	
	try {
	Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
	Statement stmt = con.createStatement();
	String sql = "select Artikelnr from Kleidung where geschlecht = 'M' and art = 'Hose'";	
	ResultSet rs = stmt.executeQuery(sql);
	
	while(rs.next()) {
		int artikelnr = rs.getInt("Artikelnr");
		panelDamenKleidung.add(GUINeuerArtikel.neuerArtikel(artikelnr));
		anzahlArtikel = anzahlArtikel +1;
	}
	rs.close();
	Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
	
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
	GUI.getFenster().revalidate();
	GUI.getFenster().repaint();
}

	
	/**
	 * Initialize the contents of the frame.
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
		scrollPaneLinks.setBounds(10, 97, 270, 455);
		panelMain.add(scrollPaneLinks);
		
		
		btnAlleArtikel = new JButton("Alle Artikel");
		btnAlleArtikel.setFont(new Font("Lucida Bright", Font.BOLD, 15));
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
		
		btnSchaals = new JButton("Schaals");
		btnSchaals.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnSchaals.setBackground(SystemColor.inactiveCaptionBorder);
		btnSchaals.setBounds(10, 87, 248, 43);
		btnSchaals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelDamenKleidung.removeAll();
				ladeArtikelSchaals();
				panelMain.revalidate();
				panelMain.repaint();
			}
		});
		panelScrollPaneLinks.add(btnSchaals);
		
		btnHosen = new JButton("Hosen");
		btnHosen.setFont(new Font("Lucida Bright", Font.BOLD, 15));
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
		scrollPaneDamenKleidung.setBounds(323, 97, 901, 455);
		scrollPaneDamenKleidung.setViewportView(panelDamenKleidung);
		scrollPaneDamenKleidung.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		panelMain.add(scrollPaneDamenKleidung);
		
		ladeArtikel();
		
		int length = anzahlArtikel/2 * 188;
		if(anzahlArtikel%2 == 1)
			length = length +188;
		panelDamenKleidung.setLayout(new GridLayout(0, 2, 0, 0));
		panelDamenKleidung.setPreferredSize(new Dimension(549, length));
	
		
		panelMain.setVisible(true);
		return panelMain;
	}
	
	
}