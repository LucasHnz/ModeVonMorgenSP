package Frontend;

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
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import Logverwaltung.LogStrg;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;

import Artikelverwaltung.ArtikelStrg;
import Artikelverwaltung.Artikelsammlung;

import javax.swing.border.BevelBorder;
import javax.swing.JLayeredPane;

    public class GUI {
	
	
	public static String[] damenCbList = {"Damen", "-----------------------------------", "Kleidung", "Schuhe", "Accessoires"};
	public static String[] herrenCbList = {"Herren","------------------------------------", "Kleidung", "Schuhe", "Accessoires"};
	public static String[] anmeldenCbList = {"Anmelden", "Meine Bestellungen", "Konto verwalten", "Abmelden"};
    static JFrame frame;
	public int rotierung = 1;
	public static String[] outfitsDamenListe = {"C:\\\\Users\\\\hinzl\\\\Desktop\\\\SWP-Bilder\\\\frau1.jpg","C:\\\\Users\\\\hinzl\\\\Desktop\\\\SWP-Bilder\\\\frau2.jpg"};
	static JTextField anmeldenEmail = new JTextField();
	static JPasswordField anmeldenPasswort = new JPasswordField();
	static JButton btnAnmeldenEinloggen = new JButton("Einloggen");
	static JButton btnAnmeldenAbbrechen = new JButton("Abbrechen");
	static JPanel panelMain = new JPanel();
	private static JPanel panelMain_1;
	public static JPanel panelAnmelden;
	
	public static JButton btnProduktDamenLinks = new JButton();
	public static JButton btnProduktDamenRechts = new JButton();
	public static JButton btnProduktHerrenLinks = new JButton();
	public static JButton btnProduktHerrenRechts= new JButton();
	public static JButton btnProduktDamen;
	public static JButton btnProduktHerren;
	public static JButton btnWarenkorb;
	public static JButton btnHome;
	public static JLabel labelMainDamen = new JLabel();
	public static JLabel labelMainHerren = new JLabel();
	public static JLabel lblRechte;
	public static JComboBox comboBoxHerren = new JComboBox();
	public static JComboBox comboBoxDamen = new JComboBox();
	public static JComboBox comboBoxAnmelden = new JComboBox();
	public static JButton btnZurück = new JButton();
    public static JPanel varPanel;
	public static JPanel WarenkorbPanel;
    private static JLayeredPane layeredPane = new JLayeredPane();
	
	
	public static void changePanel(JPanel newPanel) {
		if(varPanel != null) {
			layeredPane.remove(varPanel);
			varPanel = null;
		}
		varPanel = newPanel;
		layeredPane.add(varPanel, JLayeredPane.DEFAULT_LAYER);
		frame.revalidate();
		frame.repaint();
	}
	
	public static void fensterSchließen() {
		frame.dispose();
	}
	
	
	public static void setRechteAnzeigen(String recht) {
		lblRechte.setText(recht);
		frame.revalidate();
		frame.repaint();
	}
	
	
	
	public static void öffnenAnmeldefenster() {
		
        panelAnmelden = new JPanel();
		panelAnmelden.setLayout(null);
		panelAnmelden.setBounds(1040, 0, 194, 118);
		panelAnmelden.setOpaque(true);
						
		layeredPane.add(panelAnmelden, JLayeredPane.POPUP_LAYER);		
	
		btnAnmeldenEinloggen = new JButton("Einloggen");
		btnAnmeldenEinloggen.setBounds(0, 95, 89, 23);
		panelAnmelden.add(btnAnmeldenEinloggen);
		btnAnmeldenEinloggen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				  String pwd = new String(anmeldenPasswort.getPassword());
				  String email = anmeldenEmail.getText();
				  
				  LogStrg.anmelden(pwd, email);
				  panelAnmelden.setVisible(false);
				
			}
			
		});
		panelAnmelden.getRootPane().setDefaultButton(btnAnmeldenEinloggen);
		
		btnAnmeldenAbbrechen = new JButton("Abbrechen");
		btnAnmeldenAbbrechen.setBounds(105, 95, 89, 23);
		btnAnmeldenAbbrechen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelAnmelden.setVisible(false);
			}
			
		});
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
		
		panelAnmelden.setVisible(true);
	}
	
	
	public static ImageIcon bildAnpassen(String imageRoot) {
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(imageRoot).getImage().getScaledInstance(380, 450, Image.SCALE_SMOOTH));
		return imageIcon;
	}
	
	
	public static void anmeldenFehlermeldung() {
		
		System.out.println("OPT");
		JOptionPane.showOptionDialog(null, "Email und Passwort stimmen nicht überein",
				"Anmeldung",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.WARNING_MESSAGE,
				null,
				new String[] {"Erneut versuchen"}, "");
		
	}
	
	public static void wechselOutfitDamenRechts() 
	{
		
		labelMainDamen.setIcon(bildAnpassen("src\\SWP-Bilder\\Damenkleidung_6.jpg"));
		 
	}
	
	public static void wechselOutfitDamenLinks() 
	{
		
		labelMainDamen.setIcon(bildAnpassen("src\\SWP-Bilder\\Damenkleidung_2.jpg"));
		
	}
	
	public static void wechselOutfitHerrenRechts() 
	{
		
		labelMainHerren.setIcon(bildAnpassen("src\\SWP-Bilder\\Herrenkleidung_1.jpg"));

	}
	
	public static void wechselOutfitHerrenLinks() 
	{
		
		labelMainHerren.setIcon(bildAnpassen("src\\SWP-Bilder\\Herrenjacke_6.jpg"));
		 	
	}

	
	public static void main(String[] args) 
	{
		try {
			//UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
			UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");

			//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			//UIManager.setLookAndFeel( "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel" );
		} catch (Throwable e) {
			e.printStackTrace();
		}
		ArtikelStrg.FülleArtikelsammlung();
		setzeArtikelStartseite();
		new GUI();
		
		//Artikelsammlung.loadAllImages();
		//System.out.println("Images geladen");
	}
	
	public static void setzeArtikelStartseite(){
		//for (int n : ArtikelStrg.Artikelsammlung)
	}
	
	
	
	public GUI() {
		initializeMain();
	}
	
	
	
	private static void initializeMain() {
		
		layeredPane.setSize(1248, 563);
		layeredPane.setLocation(0, 148);
		frame = new JFrame();
		frame.getContentPane().add(layeredPane);
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
		
		lblRechte = new JLabel("");
		lblRechte.setBounds(1040, 68, 172, 20);
		panelLogo.add(lblRechte);
		lblRechte.setText(LogStrg.getRechte());
		lblRechte.setForeground(Color.BLUE);
		lblRechte.setHorizontalAlignment(SwingConstants.CENTER);
		lblRechte.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel labelLogo = new JLabel("");
		labelLogo.setBounds(59, 0, 1248, 99);
		labelLogo.setIcon(new ImageIcon("src\\SWP-Bilder\\Logo.jpg"));
		panelLogo.add(labelLogo);
		
		JPanel panelBar = new JPanel();
		panelBar.setBackground(SystemColor.control);
		panelBar.setBounds(0, 98, 1248, 50);
		frame.getContentPane().add(panelBar);
		panelBar.setLayout(null);
		
		comboBoxDamen = new JComboBox(damenCbList);
		comboBoxDamen.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		comboBoxDamen.setBackground(SystemColor.control);
		comboBoxDamen.setBounds(10, 2, 250, 48);
		comboBoxDamen.addActionListener(new ActionListener(){
			
				public void actionPerformed(ActionEvent arg0) {
					
					  String auswahl = (String) comboBoxDamen.getSelectedItem();
						
						if(auswahl == "Kleidung"){
							
							changePanel(GUIDamenKleidung.getGUIDamenKleidung());
							new GUIDamenKleidung();	
						    }
						  
							if(auswahl == "Schuhe"){
								changePanel(GUIDamenSchuhe.getGUIDamenSchuhe());
								new GUIDamenSchuhe();	
							}
							
							if(auswahl == "Accessoires"){
								changePanel(GUIDamenAccessoires.getGUIDamenAccessoires());
								new GUIDamenAccessoires();		
							}
					
				}
		
		});
		panelBar.add(comboBoxDamen);
		
		comboBoxHerren = new JComboBox(herrenCbList);
		comboBoxHerren.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		comboBoxHerren.setBackground(SystemColor.control);
		comboBoxHerren.setBounds(270, 2, 250, 48);
		comboBoxHerren.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == comboBoxHerren){
					
					String auswahl = (String) comboBoxHerren.getSelectedItem();
				    
					if(auswahl == "Kleidung"){
						changePanel(GUIHerrenKleidung.getGUIHerrenKleidung());
						new GUIHerrenKleidung();			 
				    }
				  
					if(auswahl == "Schuhe"){
						changePanel(GUIHerrenSchuhe.getGUIHerrenSchuhe());
						new GUIHerrenSchuhe();			 			  
					}
					
					if(auswahl == "Accessoires"){
						changePanel(GUIHerrenAccessoires.getGUIHerrenAccessoires());
						new GUIHerrenAccessoires();	
					  
					}
				}
				
			}
			
		});
		panelBar.add(comboBoxHerren);
		
		comboBoxAnmelden = new JComboBox(anmeldenCbList);
		comboBoxAnmelden.setBounds(1040, 2, 173, 48);
		comboBoxAnmelden.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		comboBoxAnmelden.setBackground(SystemColor.control);
		comboBoxAnmelden.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

					String auswahl = (String) comboBoxAnmelden.getSelectedItem();
					
					if(auswahl == "Anmelden") {
						öffnenAnmeldefenster();
						
					}

				    if(auswahl == "Meine Bestellungen" && LogStrg.getAngemeldetStatus() == 2) {
					   //new GUIKontoBestellungen(frame);
					}
				    if(auswahl == "Meine Bestellungen" && LogStrg.getAngemeldetStatus() == 0) {
				    	öffnenAnmeldefenster();
				    }
				    
				    if(auswahl == "Konto verwalten" && LogStrg.getAngemeldetStatus() == 2) {
					    //new GUIKontoVerwalten(frame);
					}
				    if(auswahl == "Konto verwalten" && LogStrg.getAngemeldetStatus() == 0) {
				    	öffnenAnmeldefenster();
				    }
				    if(auswahl == "Abmelden") {
				    	System.out.println("DADA");
				    	LogStrg.abmelden();
				    }
				}
				
			
			
		});
		panelBar.add(comboBoxAnmelden);
		
		Image warenkorb = new ImageIcon("src\\Icons 64x64\\shopping-cart.png").getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
		btnWarenkorb = new JButton(new ImageIcon(warenkorb));
		btnWarenkorb.setContentAreaFilled(false);
		btnWarenkorb.setToolTipText("Warenkorb");
		btnWarenkorb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			  changePanel(GUIWarenkorb.getGUIWarenkorb());
			}
			
		});
		btnWarenkorb.setBounds(936, 2, 48, 48);
		panelBar.add(btnWarenkorb);
		
		
		Image homebutton = new ImageIcon("src\\Icons 64x64\\house.png").getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
		btnHome = new JButton(new ImageIcon(homebutton));
		btnHome.setContentAreaFilled(false);
		btnHome.setToolTipText("Home");
		btnHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel(getPanelMain());
				
			}
			
		});
		btnHome.setBounds(876, 2, 48, 48);
		panelBar.add(btnHome);
		
	
		
		varPanel = getPanelMain();
		layeredPane.add(varPanel, JLayeredPane.DEFAULT_LAYER);
		
		
		
		JLabel labelMainHintergrund = new JLabel();
		labelMainHintergrund.setBounds(0, 0, 1234, 711);
		panelMain.add(labelMainHintergrund);
		
	
	
		frame.setVisible(true);
	
	}
	
	public static JPanel getPanelMain() {
		panelMain_1 = new JPanel();
		panelMain_1.setBackground(Color.WHITE);
		panelMain_1.setBounds(0, 0, 1248, 563);
		panelMain_1.setLayout(null);
		
		btnProduktDamen = new JButton("Zum Produkt");
		btnProduktDamen.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnProduktDamen.setBackground(Color.WHITE);
		btnProduktDamen.setForeground(Color.BLACK);
		btnProduktDamen.setBounds(249, 458, 165, 35);
		btnProduktDamen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
			
		});
		panelMain_1.add(btnProduktDamen);
		
		btnProduktHerren = new JButton("Zum Produkt");
		btnProduktHerren.setBackground(Color.WHITE);
		btnProduktHerren.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnProduktHerren.setBounds(774, 458, 165, 35);
		btnProduktHerren.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
			
		});
		panelMain_1.add(btnProduktHerren);
		
		Image leftArrow = new ImageIcon("src\\Icons 32x32\\left-arrow.png").getImage();
		Image rightArrow = new ImageIcon("src\\Icons 32x32\\right-chevron.png").getImage();

		btnProduktDamenRechts = new JButton(new ImageIcon(rightArrow));
		btnProduktDamenRechts.setContentAreaFilled(false);
		btnProduktDamenRechts.setBackground(Color.WHITE);
		btnProduktDamenRechts.setBounds(536, 260, 32, 32);
		btnProduktDamenRechts.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				wechselOutfitDamenRechts();
				
			}
			
		});
		panelMain_1.add(btnProduktDamenRechts);
		
		btnProduktDamenLinks = new JButton(new ImageIcon(leftArrow));
		btnProduktDamenLinks.setContentAreaFilled(false);
		btnProduktDamenLinks.setBackground(Color.WHITE);
		btnProduktDamenLinks.setBounds(100, 260, 32, 32);
		btnProduktDamenLinks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				wechselOutfitDamenLinks();
				
			}
			
		});
		panelMain_1.add(btnProduktDamenLinks);
		
		btnProduktHerrenRechts = new JButton(new ImageIcon(rightArrow));
		btnProduktHerrenRechts.setContentAreaFilled(false);
		btnProduktHerrenRechts.setBackground(Color.WHITE);
		btnProduktHerrenRechts.setBounds(1048, 260, 32, 32);
		btnProduktHerrenRechts.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				wechselOutfitHerrenRechts();
				
			}
			
		});
		panelMain_1.add(btnProduktHerrenRechts);
		
		btnProduktHerrenLinks = new JButton(new ImageIcon(leftArrow));
		btnProduktHerrenLinks.setBackground(Color.WHITE);
		btnProduktHerrenLinks.setContentAreaFilled(false);
		btnProduktHerrenLinks.setBounds(612, 260, 32, 32);
		btnProduktHerrenLinks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			wechselOutfitHerrenRechts();
				
			}
			
		});
		panelMain_1.add(btnProduktHerrenLinks);
		
		
		labelMainDamen = new JLabel();
		labelMainDamen.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, Color.LIGHT_GRAY, null));
		labelMainDamen.setHorizontalAlignment(SwingConstants.CENTER);
		labelMainDamen.setVerticalAlignment(SwingConstants.TOP);
		labelMainDamen.setBounds(144, 76, 380, 450);
		labelMainDamen.setIcon(bildAnpassen("src\\SWP-Bilder\\Damenkleidung_2.jpg"));
		panelMain_1.add(labelMainDamen);
		
		labelMainHerren = new JLabel("");
		labelMainHerren.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, Color.LIGHT_GRAY, null));
		labelMainHerren.setHorizontalAlignment(SwingConstants.CENTER);
		labelMainHerren.setBounds(656, 76, 380, 450);
		labelMainHerren.setIcon(bildAnpassen("src\\SWP-Bilder\\Herrenjacke_6.jpg"));
		panelMain_1.add(labelMainHerren);

		
		return panelMain_1;
	}
	
}
