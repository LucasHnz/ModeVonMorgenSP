package Frontend;

import java.awt.EventQueue;

/**
 * 
 * @author Hinz
 *
 */

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import Logverwaltung.LogStrg;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;


//ABC


    public class GUI implements ActionListener {
	
	
	public String[] damenCbList = {"Damen", "-----------------------------------", "Kleidung", "Schuhe", "Accessoires"};
	public String[] herrenCbList = {"Herren","------------------------------------", "Kleidung", "Schuhe", "Accessoires"};
	public static String[] anmeldenCbList = {"Anmelden", "Meine Bestellungen", "Konto verwalten", "Abmelden"};
    static JFrame frame;
	public static boolean angemeldet = false;
	public int rotierung = 1;
	public String[] outfitsDamenListe = {"C:\\\\Users\\\\hinzl\\\\Desktop\\\\SWP-Bilder\\\\frau1.jpg","C:\\\\Users\\\\hinzl\\\\Desktop\\\\SWP-Bilder\\\\frau2.jpg"};
	JTextField anmeldenEmail = new JTextField();
	JPasswordField anmeldenPasswort = new JPasswordField();
	JButton btnAnmeldenEinloggen = new JButton("Einloggen");
	JButton btnAnmeldenAbbrechen = new JButton("Abbrechen");
	JPanel panelMain = new JPanel();
	
	public JButton btnProduktDamenLinks = new JButton();
	public JButton btnProduktDamenRechts = new JButton();
	public JButton btnProduktHerrenLinks = new JButton();
	public JButton btnProduktHerrenRechts= new JButton();
	public JButton btnProduktDamen;
	public JButton btnProduktHerren;
	public JLabel labelMainDamen = new JLabel();
	public JLabel labelMainHerren = new JLabel();
	public JComboBox comboBoxHerren = new JComboBox();
	public JComboBox comboBoxDamen = new JComboBox();
	public JComboBox comboBoxAnmelden = new JComboBox();
	public JButton btnZurück = new JButton();
	private JTextField textFieldEmail;
	private JPasswordField passwordField;
	//public static JButton btnAnmelden = new JButton();
	public JPanel panelAnmelden = new JPanel();
	
	
	
	
	public static void fensterSchließen() {
		frame.dispose();
	}
	
	public void öffnenAnmeldefenster() {
		
        System.out.println("ANMD");
        panelAnmelden = new JPanel();
		panelAnmelden.setLayout(null);
		panelAnmelden.setBounds(1040, 0, 194, 118);
		panelMain.add(panelAnmelden);
		
		btnAnmeldenEinloggen = new JButton("Einloggen");
		btnAnmeldenEinloggen.setBounds(0, 95, 89, 23);
		panelAnmelden.add(btnAnmeldenEinloggen);
		btnAnmeldenEinloggen.addActionListener(this);
		panelAnmelden.getRootPane().setDefaultButton(btnAnmeldenEinloggen);
	
		
		btnAnmeldenAbbrechen = new JButton("Abbrechen");
		btnAnmeldenAbbrechen.setBounds(105, 95, 89, 23);
		btnAnmeldenAbbrechen.addActionListener(this);
		panelAnmelden.add(btnAnmeldenAbbrechen);
		
		anmeldenEmail = new JTextField();
		anmeldenEmail.setToolTipText("Email Adresse");
		anmeldenEmail.setBounds(10, 11, 174, 28);
		panelAnmelden.add(anmeldenEmail);
		anmeldenEmail.setColumns(10);
		
		anmeldenPasswort = new JPasswordField();
		anmeldenPasswort.setToolTipText("Passwort");
		anmeldenPasswort.setBounds(10, 45, 174, 28);
		panelAnmelden.add(anmeldenPasswort);
		
		frame.invalidate();
		frame.validate();
		frame.repaint();
	}
	
	public ImageIcon bildAnpassen(String imageRoot) {
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(imageRoot).getImage().getScaledInstance(380, 450, Image.SCALE_DEFAULT));
		return imageIcon;
	}
	
	
		static void anmeldenFehlermeldung() {
		
		System.out.println("OPT");
		JOptionPane.showOptionDialog(null, "Dies ist ein Optionsdialog",
				"Optionsdialog",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.WARNING_MESSAGE,
				null,
				new String[] {"A", "B", "C"},"B");
		
	}
	
	public void wechselOutfitDamenRechts() 
	{
		
		labelMainDamen.setIcon(bildAnpassen("src\\SWP-Bilder\\Damenkleidung_6.jpg"));
		 
	}
	
	public void wechselOutfitDamenLinks() 
	{
		
		labelMainDamen.setIcon(bildAnpassen("src\\SWP-Bilder\\Damenkleidung_2.jpg"));
		
	}
	
	public void wechselOutfitHerrenRechts() 
	{
		
		labelMainHerren.setIcon(bildAnpassen("src\\SWP-Bilder\\Herrenkleidung_1.jpg"));

	}
	
	public void wechselOutfitHerrenLinks() 
	{
		
		labelMainHerren.setIcon(bildAnpassen("src\\SWP-Bilder\\Herrenjacke_6.jpg"));
		 	
	}

	
	public static void main(String[] args) 
	{
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
			//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			//UIManager.setLookAndFeel( "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel" );
		} catch (Throwable e) {
			e.printStackTrace();
		}
		new GUI();
	}
	
	/**
	 * Create the application.
	 */
	
	public GUI() {
		System.out.println("Ausgeführt Main");
		initializeMain();
	}
	
	public GUI(String[] anmeldenCbList) {
		this.anmeldenCbList = anmeldenCbList;
		angemeldet = true;
		initializeMain();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initializeMain() {
		
		frame = new JFrame();
		
		frame.setBounds(20, 20, 1250, 750);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelLogo = new JPanel();
		panelLogo.setBackground(Color.WHITE);
		panelLogo.setBounds(0, 0, 1234, 99);
		frame.getContentPane().add(panelLogo);
		panelLogo.setLayout(null);
		
		JLabel labelLogo = new JLabel("");
		labelLogo.setBounds(56, 0, 1226, 99);
		labelLogo.setIcon(new ImageIcon("src\\SWP-Bilder\\Logo.jpg"));
		panelLogo.add(labelLogo);
		

		JPanel panelBar = new JPanel();
		panelBar.setBackground(SystemColor.control);
		panelBar.setBounds(0, 98, 1234, 50);
		frame.getContentPane().add(panelBar);
		panelBar.setLayout(null);
		
		comboBoxDamen = new JComboBox(damenCbList);
		comboBoxDamen.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		comboBoxDamen.setBackground(SystemColor.control);
		comboBoxDamen.setBounds(10, 0, 250, 50);
		comboBoxDamen.addActionListener(this);
		panelBar.add(comboBoxDamen);
		
		comboBoxHerren = new JComboBox(herrenCbList);
		comboBoxHerren.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		comboBoxHerren.setBackground(SystemColor.control);
		comboBoxHerren.setBounds(270, 0, 250, 50);
		comboBoxHerren.addActionListener(this);
		panelBar.add(comboBoxHerren);
		
		comboBoxAnmelden = new JComboBox(anmeldenCbList);
		comboBoxAnmelden.setBounds(1040, 0, 173, 50);
		comboBoxAnmelden.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		comboBoxAnmelden.setBackground(SystemColor.control);
		comboBoxAnmelden.addActionListener(this);
		panelBar.add(comboBoxAnmelden);
		
		JLabel lblPunktestand = new JLabel("1224 Punkte");
		lblPunktestand.setForeground(Color.BLUE);
		lblPunktestand.setBounds(947, 15, 89, 20);
		panelBar.add(lblPunktestand);
		
		panelMain = new JPanel();
		panelMain.setBackground(Color.WHITE);
		panelMain.setBounds(0, 148, 1234, 563);
		frame.getContentPane().add(panelMain);
		panelMain.setLayout(null);
		
		btnProduktDamen = new JButton("Zum Produkt");
		btnProduktDamen.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnProduktDamen.setBackground(Color.WHITE);
		btnProduktDamen.setForeground(Color.BLACK);
		btnProduktDamen.setBounds(249, 458, 165, 35);
		btnProduktDamen.addActionListener(this);
		panelMain.add(btnProduktDamen);
		
		btnProduktHerren = new JButton("Zum Produkt");
		btnProduktHerren.setBackground(Color.WHITE);
		btnProduktHerren.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnProduktHerren.setBounds(774, 458, 165, 35);
		btnProduktHerren.addActionListener(this);
		panelMain.add(btnProduktHerren);
		
		btnProduktDamenRechts = new JButton(">");
		btnProduktDamenRechts.setBackground(Color.WHITE);
		btnProduktDamenRechts.setBounds(483, 191, 41, 70);
		btnProduktDamenRechts.addActionListener(this);
		panelMain.add(btnProduktDamenRechts);
		
		btnProduktDamenLinks = new JButton("<");
		btnProduktDamenLinks.setBackground(Color.WHITE);
		btnProduktDamenLinks.setBounds(144, 191, 41, 70);
		btnProduktDamenLinks.addActionListener(this);
		panelMain.add(btnProduktDamenLinks);
		
		btnProduktHerrenRechts = new JButton(">");
		btnProduktHerrenRechts.setBackground(Color.WHITE);
		btnProduktHerrenRechts.setBounds(995, 191, 41, 70);
		btnProduktHerrenRechts.addActionListener(this);
		panelMain.add(btnProduktHerrenRechts);
		
		btnProduktHerrenLinks = new JButton("<");
		btnProduktHerrenLinks.setBackground(Color.WHITE);
		btnProduktHerrenLinks.setBounds(656, 191, 41, 70);
		btnProduktHerrenLinks.addActionListener(this);
		panelMain.add(btnProduktHerrenLinks);
		
		
		labelMainDamen = new JLabel();
		labelMainDamen.setHorizontalAlignment(SwingConstants.CENTER);
		labelMainDamen.setVerticalAlignment(SwingConstants.TOP);
		labelMainDamen.setBounds(144, 76, 380, 450);
		labelMainDamen.setIcon(bildAnpassen("src\\SWP-Bilder\\Damenkleidung_2.jpg"));
		panelMain.add(labelMainDamen);
		
		labelMainHerren = new JLabel("");
		labelMainHerren.setHorizontalAlignment(SwingConstants.CENTER);
		labelMainHerren.setBounds(656, 76, 380, 450);
		labelMainHerren.setIcon(bildAnpassen("src\\SWP-Bilder\\Herrenjacke_6.jpg"));
		panelMain.add(labelMainHerren);
		
		JLabel labelMainHintergrund = new JLabel();
		labelMainHintergrund.setBounds(0, 0, 1234, 711);
		panelMain.add(labelMainHintergrund);
		
	
		frame.setVisible(true);
	
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnAnmeldenAbbrechen) {
			panelAnmelden.setVisible(false);
		}
		
		
		  if(e.getSource() == btnAnmeldenEinloggen) {
		
			  String pwd = new String(anmeldenPasswort.getPassword());
			  String email = anmeldenEmail.getText();
			  
			  LogStrg.anmelden(pwd, email, anmeldenCbList);
			  panelAnmelden.setVisible(false);
				
		  }
		
		if(e.getSource() == btnProduktDamen) 
		{
			frame.dispose();
			//Seite des Produktes
			
		}
		
		if(e.getSource() == btnProduktHerren) 
		{
			frame.dispose();
			//Seite des Produktes
			
		}
		
		if (e.getSource() == btnProduktDamenRechts){
			
			wechselOutfitDamenRechts();
		}
		
		if (e.getSource() == btnProduktDamenLinks){
			
			wechselOutfitDamenLinks();
		}
		
		if (e.getSource() == btnProduktHerrenRechts){
			
			wechselOutfitHerrenRechts();
		}
		
		if (e.getSource() == btnProduktHerrenLinks){
			
			wechselOutfitHerrenLinks();
		}
		
		if(e.getSource() == comboBoxHerren){
			
			String auswahl = (String) comboBoxHerren.getSelectedItem();
		    
			if(auswahl == "Kleidung"){
				frame.dispose();
			  new GUIHerrenKleidung(damenCbList, herrenCbList, anmeldenCbList);
			 
		    }
		  
			if(auswahl == "Schuhe"){
			  frame.dispose();
			  new GUIHerrenSchuhe(damenCbList, herrenCbList, anmeldenCbList);
			  
			}
			
			if(auswahl == "Accessoires"){
				frame.dispose();
			  new GUIHerrenAccessoires(damenCbList, herrenCbList, anmeldenCbList);
			  
			}
		}
		
		if(e.getSource() == comboBoxDamen){
			
			String auswahl = (String) comboBoxDamen.getSelectedItem();
			
			if(auswahl == "Kleidung"){
				 frame.dispose();
				 new GUIDamenKleidung(damenCbList, herrenCbList, anmeldenCbList);
			    }
			  
				if(auswahl == "Schuhe"){
					frame.dispose();
				  new GUIDamenSchuhe(damenCbList, herrenCbList, anmeldenCbList);
				 
				}
				
				if(auswahl == "Accessoires"){
					frame.dispose();
				  new GUIDamenAccessoires(damenCbList, herrenCbList, anmeldenCbList);
				  
				}
				
		}
		
		if (e.getSource() == comboBoxAnmelden) {
			
			String auswahl = (String) comboBoxAnmelden.getSelectedItem();
			
			if(auswahl == "Anmelden") {
				 öffnenAnmeldefenster();
				
			}

		    if(auswahl == "Meine Bestellungen" && angemeldet == true) {
			    new GUIKontoBestellungen(damenCbList, herrenCbList, anmeldenCbList);
			}
		    if(auswahl == "Meine Bestellungen" && angemeldet == false) {
		    	 öffnenAnmeldefenster();
		    }
		    
		    if(auswahl == "Konto verwalten" && angemeldet == true) {
			    new GUIKontoVerwalten(damenCbList, herrenCbList, anmeldenCbList);
			}
		    if(auswahl == "Konto verwalten" && angemeldet == false) {
		    	 öffnenAnmeldefenster();
		    }
		    if(auswahl == "Abmelden") {
		    	System.out.println("DADA");
		    	 LogStrg.abmelden(anmeldenCbList);
		    	 angemeldet = false;
		    }
		}
	
		
	}
}
