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
	
	private static JFrame Fenster;
	
	public static String[] damenCbList = {"Damen", "-----------------------------------", "Kleidung", "Schuhe", "Accessoires"};
	public static String[] herrenCbList = {"Herren","------------------------------------", "Kleidung", "Schuhe", "Accessoires"};
	public static String[] anmeldenCbList = {"Anmelden", "Meine Bestellungen", "Konto verwalten", "Abmelden"};
    static JFrame frame;	
	static JTextField anmeldenEmail = new JTextField();
	static JPasswordField anmeldenPasswort = new JPasswordField();
	static JButton btnAnmeldenEinloggen = new JButton("Einloggen");
	static JButton btnAnmeldenAbbrechen = new JButton("Abbrechen");
	static JPanel panelMain = new JPanel();
	public static JPanel panelAnmelden;
	public static JButton btnWarenkorb;
	public static JButton btnHome;
	public static JLabel lblRechte;
	public static JComboBox comboBoxHerren = new JComboBox();
	public static JComboBox comboBoxDamen = new JComboBox();
	public static JComboBox comboBoxAnmelden = new JComboBox();
	public static JButton btnZurück = new JButton();
    public static JPanel varPanel;
    private static JLayeredPane layeredPane = new JLayeredPane();
	
	
	public static void main(String[] args) 
	{
		try {
			UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		ArtikelStrg.FülleArtikelsammlung();
		setzeArtikelStartseite();
		getGUI();
		
	}
    
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
	public static void fensterRestart() {
		frame.dispose();
		getGUI();
	}
	
	public static void setRechteAnzeigen(String recht) {
		lblRechte.setText(recht);
		frame.revalidate();
		frame.repaint();
	}

	public static void öffnenAnmeldefenster() {	
		panelAnmelden = GUIAnmelden.getGUIAnmelden();
		layeredPane.add(panelAnmelden, JLayeredPane.POPUP_LAYER);		
	}
	public static void removeLogPanel() {
		layeredPane.remove(panelAnmelden);
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
	
	public static void setzeArtikelStartseite(){
		//for (int n : ArtikelStrg.Artikelsammlung)
	}
	
	public static JFrame getGUI() {
				
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
						    }
						  
						if(auswahl == "Schuhe"){
							changePanel(GUIDamenSchuhe.getGUIDamenSchuhe());
							}
							
						if(auswahl == "Accessoires"){
							changePanel(GUIDamenAccessoires.getGUIDamenAccessoires());		
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
				    }
				  
					if(auswahl == "Schuhe"){
						changePanel(GUIHerrenSchuhe.getGUIHerrenSchuhe());			 			  
					}
					
					if(auswahl == "Accessoires"){
						changePanel(GUIHerrenAccessoires.getGUIHerrenAccessoires());
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
				    	changePanel(GUIKontoVerwalten.getGUIKontoVerwalten());
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
				changePanel(GUIHomepage.getHomepage());
				
			}
			
		});
		btnHome.setBounds(876, 2, 48, 48);
		panelBar.add(btnHome);
		
		varPanel = GUIHomepage.getHomepage();
		layeredPane.add(varPanel, JLayeredPane.DEFAULT_LAYER);
		
		JLabel labelMainHintergrund = new JLabel();
		labelMainHintergrund.setBounds(0, 0, 1234, 711);
		panelMain.add(labelMainHintergrund);
	
		frame.setVisible(true);
	
		return frame;
	}
	
	
	
}
