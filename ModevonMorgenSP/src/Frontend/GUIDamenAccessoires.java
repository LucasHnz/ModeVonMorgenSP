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

public class GUIDamenAccessoires {
	
	JButton btnAnmelden = new JButton();
	static JButton btnAlleArtikel;
	static JButton btnKopfschmuck;
	static JButton btnKetten;
	static JButton btnOhrringe;
	static JButton btnArmb‰nder;
	static JButton btnRinge;
	
	private JTextField txtSchwarzeJacke;
	private JTextField textField_1;
	private JTextField txtGre;

	public JFrame frame;
	static JPanel panelMain = new JPanel();
	static JPanel panelDamenAccessoires = new JPanel();
	public static int anzahlArtikel = 0;

	
public static void ladeArtikel() {
		
		try {
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		String sql = "select Artikelnr from Accessoires where geschlecht = 'W' ";	
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			int artikelnr = rs.getInt("Artikelnr");
			panelDamenAccessoires.add(GUINeuerArtikel.neuerArtikel(artikelnr));
			anzahlArtikel = anzahlArtikel +1;
			
		}
		rs.close();
		Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
public static void ladeArtikelKopfschmuck() {
	
	try {
	Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
	Statement stmt = con.createStatement();
	String sql = "select Artikelnr from Accessoires where geschlecht = 'W' and art = 'Kopfschmuck'";	
	ResultSet rs = stmt.executeQuery(sql);
	
	while(rs.next()) {
		int artikelnr = rs.getInt("Artikelnr");
		panelDamenAccessoires.add(GUINeuerArtikel.neuerArtikel(artikelnr));
		anzahlArtikel = anzahlArtikel +1;
	}
	System.out.println(anzahlArtikel);
	rs.close();
	Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
	
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
	GUI.getFenster().revalidate();
	GUI.getFenster().repaint();
}

public static void ladeArtikelKetten() {

try {
Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
Statement stmt = con.createStatement();
String sql = "select Artikelnr from Accessoires where geschlecht = 'W' and art = 'Kette'";	
ResultSet rs = stmt.executeQuery(sql);

while(rs.next()) {
	int artikelnr = rs.getInt("Artikelnr");
	panelDamenAccessoires.add(GUINeuerArtikel.neuerArtikel(artikelnr));
	anzahlArtikel = anzahlArtikel +1;
}
System.out.println(anzahlArtikel);
rs.close();
Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);

}catch(SQLException e) {
	e.printStackTrace();
}

GUI.getFenster().revalidate();
GUI.getFenster().repaint();
}

	public static void ladeArtikelOhrringe() {

		try {
			Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
			Statement stmt = con.createStatement();
			String sql = "select Artikelnr from Accessoires where geschlecht = 'W' and art = 'Ohrring'";	
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
			int artikelnr = rs.getInt("Artikelnr");
			panelDamenAccessoires.add(GUINeuerArtikel.neuerArtikel(artikelnr));
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

public static void ladeArtikelArmb‰nder() {

try {
System.out.println("1");
Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
Statement stmt = con.createStatement();
String sql = "select Artikelnr from Accessoires where geschlecht = 'W' and art = 'Armband'";	
ResultSet rs = stmt.executeQuery(sql);

while(rs.next()) {
	int artikelnr = rs.getInt("Artikelnr");
	panelDamenAccessoires.add(GUINeuerArtikel.neuerArtikel(artikelnr));
	anzahlArtikel = anzahlArtikel +1;
}
System.out.println(anzahlArtikel);
rs.close();
Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);

}catch(SQLException e) {
	e.printStackTrace();
}

GUI.getFenster().revalidate();
GUI.getFenster().repaint();
}

public static void ladeArtikelRinge() {

try {
System.out.println("1");
Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
Statement stmt = con.createStatement();
String sql = "select Artikelnr from Accessoires where geschlecht = 'W' and art = 'Ring'";	
ResultSet rs = stmt.executeQuery(sql);

while(rs.next()) {
	int artikelnr = rs.getInt("Artikelnr");
	panelDamenAccessoires.add(GUINeuerArtikel.neuerArtikel(artikelnr));
	anzahlArtikel = anzahlArtikel +1;
}
System.out.println(anzahlArtikel);
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
		scrollPaneDamenAccessoiresLinks.setBounds(10, 97, 270, 455);
		panelMain.add(scrollPaneDamenAccessoiresLinks);
		
		btnAlleArtikel = new JButton("Alle Artikel");
		btnAlleArtikel.setFont(new Font("Lucida Bright", Font.BOLD, 15));
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
		btnKopfschmuck.setFont(new Font("Lucida Bright", Font.BOLD, 15));
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
		btnKetten.setFont(new Font("Lucida Bright", Font.BOLD, 15));
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
		btnOhrringe.setFont(new Font("Lucida Bright", Font.BOLD, 15));
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
		
		btnArmb‰nder = new JButton("Armb‰nder");
		btnArmb‰nder.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnArmb‰nder.setBackground(SystemColor.inactiveCaptionBorder);
		btnArmb‰nder.setBounds(10, 279, 248, 43);
		btnArmb‰nder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelDamenAccessoires.removeAll();
				ladeArtikelArmb‰nder();
				panelMain.revalidate();
				panelMain.repaint();
			}
		});
		panelScrollPaneLinks.add(btnArmb‰nder);
		
		btnRinge = new JButton("Ringe");
		btnRinge.setFont(new Font("Lucida Bright", Font.BOLD, 15));
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
		scrollPaneDamenAccessoires.setBounds(323, 97, 901, 455);
		scrollPaneDamenAccessoires.setViewportView(panelDamenAccessoires);
		scrollPaneDamenAccessoires.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		panelMain.add(scrollPaneDamenAccessoires);
		
		ladeArtikel();
		
		int length = anzahlArtikel/2 * 188;
		if(anzahlArtikel%2 == 1)
			length = length +188;
		panelDamenAccessoires.setLayout(new GridLayout(0, 2, 0, 0));
		panelDamenAccessoires.setPreferredSize(new Dimension(549, length));
		
		panelMain.setVisible(true);
		return panelMain;
	}
	
	
}
