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

public class GUIDamenSchuhe implements ActionListener {
	
	JButton btnZurück = new JButton();
	JButton btnAnmelden = new JButton();

	public JFrame frame;
	JPanel panelMain = new JPanel();
	static JPanel panelDamenSchuhe = new JPanel();
	private JTextField txtSchwarzeJacke;
	private JTextField textField_1;
	private JTextField txtGre;
	public int anzahlArtikel = 0;
	

public  void artikelLaden() {
		

		try {
		System.out.println("1");
		Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
		Statement stmt = con.createStatement();
		String sql = "select artikelnummer from Schuhe where geschlecht = 'W' ";	
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			System.out.println("2");
			int artikelNummer = rs.getInt("Artikelnummer");
			System.out.println("Artikel + "+ artikelNummer);
            //GUINeuerArtikel.neuerArtikel(artikelNummer);
			anzahlArtikel = anzahlArtikel +1;
		}
		System.out.println(anzahlArtikel);
		rs.close();
		Datenbankverwaltung.VerbindungDB.schließeVerbindung(con, stmt);
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	
	}
	
	public GUIDamenSchuhe(JFrame frame) {
		System.out.println("Ausgeführt DS");
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
		
		
		JScrollPane scrollPaneLinks = new JScrollPane(panelScrollPaneLinks);
		scrollPaneLinks.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneLinks.setBounds(10, 97, 270, 455);
		panelMain.add(scrollPaneLinks);
		

		JButton btnHighHeels = new JButton("Jacken");
		btnHighHeels.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnHighHeels.setBackground(Color.WHITE);
		btnHighHeels.setBounds(10, 23, 248, 43);
		panelScrollPaneLinks.add(btnHighHeels);
		
		JButton btnStiefel = new JButton("Jacken");
		btnStiefel.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnStiefel.setBackground(Color.WHITE);
		btnStiefel.setBounds(10, 23, 248, 43);
		panelScrollPaneLinks.add(btnStiefel);
		
		panelDamenSchuhe = new JPanel();
		panelDamenSchuhe.setBackground(SystemColor.inactiveCaptionBorder);
		panelDamenSchuhe.setAutoscrolls(true);
		
		JScrollPane scrollPaneDamenSchuhe = new JScrollPane();
		scrollPaneDamenSchuhe.setBounds(323, 97, 901, 455);
		scrollPaneDamenSchuhe.setViewportView(panelDamenSchuhe);
		scrollPaneDamenSchuhe.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		panelMain.add(scrollPaneDamenSchuhe);
		
		artikelLaden();
		
		int length = anzahlArtikel/2 * 188;
		if(anzahlArtikel%2 == 1)
			length = length +188;
		panelDamenSchuhe.setLayout(new GridLayout(0, 2, 0, 0));
		panelDamenSchuhe.setPreferredSize(new Dimension(549, length));
	
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