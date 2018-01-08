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

public class GUIHerrenSchuhe {
	
	JButton btnAnmelden;
	static JButton btnAlleArtikel;
	static JButton btnOutdoor;
	static JButton btnSport;
	static JButton btnHausschuhe;
	static JButton btnStiefel;
	public String[] damenCbList;
	public String[] herrenCbList;
	public String[] anmeldenCbList;

	public JFrame frame;
	static JPanel panelMain;
	static public JPanel panelHerrenSchuhe;
	static public int anzahlArtikel = 0;

	//AGBS
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void ladeArtikel() {
		
		try {
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		String sql = "select Artikelnr from Schuhe where geschlecht = 'M' ";	
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			int artikelnr = rs.getInt("Artikelnr");
			panelHerrenSchuhe.add(GUINeuerArtikel.neuerArtikel(artikelnr));
			anzahlArtikel = anzahlArtikel +1;
			
			System.out.println("Artikel ist " + artikelnr);
		}
		rs.close();
		Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void ladeArtikelOutdoor() {
		
		try {
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		String sql = "select Artikelnr from Schuhe where geschlecht = 'M' and art = 'Outdoorschuh' ";	
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			int artikelnr = rs.getInt("Artikelnr");
			panelHerrenSchuhe.add(GUINeuerArtikel.neuerArtikel(artikelnr));
			anzahlArtikel = anzahlArtikel +1;
			
		}
		rs.close();
		Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void ladeArtikelSport() {
	
		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select Artikelnr from Schuhe where geschlecht = 'M' and art = 'Sportschuh' ";	
			ResultSet rs = stmt.executeQuery(sql);
	
			while(rs.next()) {
				int artikelnr = rs.getInt("Artikelnr");
				panelHerrenSchuhe.add(GUINeuerArtikel.neuerArtikel(artikelnr));
				anzahlArtikel = anzahlArtikel +1;
		
			}
			rs.close();
			Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
	
		}catch(SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void ladeArtikelHausschuhe() {
		
		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select Artikelnr from Schuhe where geschlecht = 'M' and art = 'Hausschuh' ";	
			ResultSet rs = stmt.executeQuery(sql);
	
			while(rs.next()) {
				int artikelnr = rs.getInt("Artikelnr");
				panelHerrenSchuhe.add(GUINeuerArtikel.neuerArtikel(artikelnr));
				anzahlArtikel = anzahlArtikel +1;
		
			}
			rs.close();
			Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
	
		}catch(SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public static void ladeArtikelStiefel() {
		
		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select Artikelnr from Schuhe where geschlecht = 'M' and art = 'Stiefel'";	
			ResultSet rs = stmt.executeQuery(sql);
	
			while(rs.next()) {
				int artikelnr = rs.getInt("Artikelnr");
				panelHerrenSchuhe.add(GUINeuerArtikel.neuerArtikel(artikelnr));
				anzahlArtikel = anzahlArtikel +1;
		
			}
			rs.close();
			Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
	
		}catch(SQLException e) {
			e.printStackTrace();
		}
	
	}
	

	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static JPanel getGUIHerrenSchuhe() {
		
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
		btnAlleArtikel.setBackground(Color.WHITE);
		btnAlleArtikel.setBounds(10, 23, 248, 43);
		btnAlleArtikel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelHerrenSchuhe.removeAll();
				ladeArtikel();
				panelMain.revalidate();
				panelMain.repaint();
			}
		});
		panelScrollPaneLinks.add(btnAlleArtikel);
		
		
		btnStiefel = new JButton("Stiefel");
		btnStiefel.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnStiefel.setBackground(SystemColor.inactiveCaptionBorder);
		btnStiefel.setBounds(10, 87, 248, 43);
		btnStiefel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelHerrenSchuhe.removeAll();
				ladeArtikelStiefel();
				panelMain.revalidate();
				panelMain.repaint();
			}
		});
		panelScrollPaneLinks.add(btnStiefel);
		
		
		btnOutdoor = new JButton("Outdoor");
		btnOutdoor.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnOutdoor.setBackground(SystemColor.inactiveCaptionBorder);
		btnOutdoor.setBounds(10, 151, 248, 43);
		btnOutdoor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelHerrenSchuhe.removeAll();
				ladeArtikelOutdoor();
				panelMain.revalidate();
				panelMain.repaint();
			}
		});
		panelScrollPaneLinks.add(btnOutdoor);
	
		
		btnSport = new JButton("Sport");
		btnSport.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnSport.setBackground(SystemColor.inactiveCaptionBorder);
		btnSport.setBounds(10, 215, 248, 43);
		btnSport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelHerrenSchuhe.removeAll();
				ladeArtikelSport();
				panelMain.revalidate();
				panelMain.repaint();
			}
		});
		panelScrollPaneLinks.add(btnSport);
		
		btnHausschuhe = new JButton("Hausschuh");
		btnHausschuhe.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnHausschuhe.setBackground(SystemColor.inactiveCaptionBorder);
		btnHausschuhe.setBounds(10, 279, 248, 43);
		btnHausschuhe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelHerrenSchuhe.removeAll();
				ladeArtikelHausschuhe();
				panelMain.revalidate();
				panelMain.repaint();
			}
		});
		panelScrollPaneLinks.add(btnHausschuhe);
		
		
		panelHerrenSchuhe = new JPanel();
		panelHerrenSchuhe.setBackground(SystemColor.inactiveCaptionBorder);
		panelHerrenSchuhe.setAutoscrolls(true);
			
		JScrollPane scrollPaneHerrenKleidung = new JScrollPane();
		scrollPaneHerrenKleidung.setBounds(323, 97, 901, 455);
		scrollPaneHerrenKleidung.setViewportView(panelHerrenSchuhe);
		scrollPaneHerrenKleidung.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		panelMain.add(scrollPaneHerrenKleidung);
		
		ladeArtikel();
		erstelleListe();
		
		panelMain.setVisible(true);
		return panelMain;
	}
	
	
	
	public static void erstelleListe() {
		int length = anzahlArtikel/2 * 188;
		if(anzahlArtikel%2 == 1)
			length = length +188;
		panelHerrenSchuhe.setLayout(new GridLayout(0, 2, 0, 0));
		panelHerrenSchuhe.setPreferredSize(new Dimension(549, length));
	}
}
