package Backend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import Frontend.GUI;
import Frontend.GUIAnmelden;
import Frontend.GUIKontoBestellungen;
import Frontend.GUIKontoVerwalten;
import Logverwaltung.LogStrg;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JTabbedPane;

public class GUIMitarbeiter{
	
	JButton btnZurück = new JButton();
	JButton btnAnmelden = new JButton();
	public JComboBox comboBoxArtikelHerren = new JComboBox();
	public JComboBox comboBoxArtikelDamen = new JComboBox();
	public JComboBox comboBoxAnmelden = new JComboBox();
	public String[] anmeldenCbList = {"Anmelden", "Meine Bestellungen", "Konto verwalten", "Abmelden"};
	public String[] damenCbList = {"Damen", "-----------------------------------", "Kleidung", "Schuhe", "Accessoires"};
	public String[] herrenCbList = {"Herren","------------------------------------", "Kleidung", "Schuhe", "Accessoires"};
	public int abstandsZahl = 170;
	public static JLabel lblRechte;
	
	


	private static JFrame frame;


	public GUIMitarbeiter() {
		initialize();
		//for(int i = 0; i>= mitarbeiterListe.length; i++) {
		//
		//}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(20, 20, 1250, 750);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelLogo = new JPanel();
		panelLogo.setBackground(Color.WHITE);
		panelLogo.setBounds(0, 0, 1248, 99);
		frame.getContentPane().add(panelLogo);
		panelLogo.setLayout(null);
		
		JLabel labelLogo = new JLabel("");
		labelLogo.setBounds(59, 0, 1248, 99);
		labelLogo.setIcon(new ImageIcon("src\\SWP-Bilder\\Logo.jpg"));
		panelLogo.add(labelLogo);
		
		JPanel panelBar = new JPanel();
		panelBar.setBackground(SystemColor.control);
		panelBar.setBounds(0, 98, 1248, 50);
		frame.getContentPane().add(panelBar);
		panelBar.setLayout(null);
		
		comboBoxAnmelden = new JComboBox(anmeldenCbList);
		comboBoxAnmelden.setBounds(1040, 0, 173, 50);
		comboBoxAnmelden.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		comboBoxAnmelden.setBackground(SystemColor.control);
		comboBoxAnmelden.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
		
					String auswahl = (String) comboBoxAnmelden.getSelectedItem();
					
					if(auswahl == "Anmelden") {
						
						
					}

				    if(auswahl == "Meine Bestellungen" && LogStrg.getAngemeldetStatus() == 2) {
					   //new GUIKontoBestellungen(frame);
					}
				    if(auswahl == "Meine Bestellungen" && LogStrg.getAngemeldetStatus() == 0) {
				    	
				    }
				    
				    if(auswahl == "Konto verwalten" && LogStrg.getAngemeldetStatus() == 2) {
					    //new GUIKontoVerwalten(frame);
					}
				    if(auswahl == "Konto verwalten" && LogStrg.getAngemeldetStatus() == 0) {
				    
				    }
				    if(auswahl == "Abmelden") {
				    	frame.dispose();
				    	new GUI();
				    	LogStrg.abmelden();
				    }
				}
				
			
				
			
		});
		panelBar.add(comboBoxAnmelden);
		
		lblRechte = new JLabel("");
		lblRechte.setBounds(1040, 68, 172, 20);
		panelLogo.add(lblRechte);
		lblRechte.setText(LogStrg.getRechte());
		lblRechte.setForeground(Color.BLUE);
		lblRechte.setHorizontalAlignment(SwingConstants.CENTER);
		lblRechte.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnZurück = new JButton("Zur\u00FCck");
		btnZurück.setBounds(10, 8, 89, 35);
		panelBar.add(btnZurück);
		btnZurück.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnZurück.setBackground(Color.WHITE);
		btnZurück.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new GUI();
				
			}
			
		});
		
		//Hauptfenster
		JPanel panelMain = new JPanel();
		panelMain.setBackground(Color.DARK_GRAY);
		panelMain.setBounds(10, 147, 1224, 563);
		frame.getContentPane().add(panelMain);
		panelMain.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 1204, 541);
		panelMain.add(tabbedPane);
		
		tabbedPane.addTab("Artikelverwaltung", new GUIArtikelliste() );
		tabbedPane.addTab("Bestellungs Liste", new GUIBestellungListe());
		
		if(anmeldenCbList[0] == "Admin")
			tabbedPane.addTab("Administrator Liste", new GUIAdministratorListe());
		if(anmeldenCbList[0] == "Admin")
			try {
				tabbedPane.addTab("Mitarbeiter Liste", new GUIMitarbeiterListe());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
				
		
		frame.setVisible(true);
	}
	
	public void anzeigenArtikel() {
		
		System.out.println("anzeige");
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(22, 50, 470, 146);
		panel.setLayout(null);
		
		JLabel lblBild = new JLabel("");
		lblBild.setBounds(10, 11, 124, 124);
		lblBild.setVerticalAlignment(SwingConstants.TOP);
		lblBild.setHorizontalAlignment(SwingConstants.CENTER);
		lblBild.setIcon(new ImageIcon("C:\\Users\\hinzl\\Desktop\\SWP-Bilder\\mann_jacke1.jpg"));
		panel.add(lblBild);
		
		JLabel lblTitel = new JLabel("Jacke");
		lblTitel.setBounds(167, 11, 242, 28);
		lblTitel.setFont(new Font("Lucida Bright", Font.BOLD, 17));
		panel.add(lblTitel);
		
		JLabel lblGröße = new JLabel("Grï¿½ï¿½e: 34");
		lblGröße.setBounds(167, 50, 78, 32);
		lblGröße.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		panel.add(lblGröße);
		
		JLabel lblPreis = new JLabel("34ï¿½");
		lblPreis.setBounds(402, 107, 58, 28);
		lblPreis.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		panel.add(lblPreis);

		
	}
	
}
