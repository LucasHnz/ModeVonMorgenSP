package Frontend;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import Artikelverwaltung.ArtikelStrg;
import Backend.GUIMitarbeiter;
import KundenVerwaltung.BestandskundeStrg;
import javax.swing.JLayeredPane;
/**
 * 
 * @author Hinz
 *
 */

public class GUI extends JFrame {
	
	static JFrame fenster;
	static GUI gui;
	
	public JFrame frame;	
	public JPanel varPanel;
    public JLayeredPane layeredPane = new JLayeredPane();
	public JPanel panelAnmelden;
	
	public JButton btnWarenkorb;
	public JButton btnHome;
	public JLabel lblAngemeldet;
	public JComboBox comboBoxHerren = new JComboBox();
	public JComboBox comboBoxDamen = new JComboBox();
	public static JComboBox comboBoxAnmelden = new JComboBox();
    
    public String[] damenCbList = {"Damen", "-----------------------------------", "Kleidung", "Schuhe", "Accessoires"};
	public String[] herrenCbList = {"Herren","------------------------------------", "Kleidung", "Schuhe", "Accessoires"};
	static String[] array = {"Anmelden", "Registrieren"};
	
	

	
	public static void main(String[] args) 
	{
		try {
			UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		ArtikelStrg.FülleArtikelsammlung();
		GUIHomepage.fülleArtikelStartseite();
		BestandskundeStrg.FülleBestandskundeSammlung();
		gui = new GUI();
		fenster = gui;
		
	}
	
	
	/**
	 * Gibt das Fenster der Klasse zurück
	 * @return (GUI) fenster Fester der Klasse 
	 */
	public static GUI getFenster() {
		return (GUI) fenster;
	}
    
	public void changePanel(JPanel newPanel) {
		if(varPanel != null) {
			layeredPane.remove(varPanel);
			varPanel = null;
		}
		varPanel = newPanel;
		layeredPane.add(varPanel, JLayeredPane.DEFAULT_LAYER);
		frame.revalidate();
		frame.repaint();
	}
	
	
	/**
	 * Checkt die Brechtigung des angemeldeten Nutzers und fällt dementsprechend die ComboBox
	 */
	public static void comboBoxAbfrage() {
		int status = LogStrg.getAngemeldetStatus();
		String[] arrayNeu;
		
		if(status == 0) {
			//Abgemeldet
			String item1 = "Anmelden";
			String item2 = "Registrieren";
			comboBoxAnmelden.removeAllItems();
			comboBoxAnmelden.addItem(item1);
			comboBoxAnmelden.addItem(item2);
		}
		
		if(status == 1) {
			//Gastkunde
			String item1 = "Gastkunde";
			String item2 = "Abmelden";
			comboBoxAnmelden.removeAllItems();
			comboBoxAnmelden.addItem(item1);
			comboBoxAnmelden.addItem(item2);
		}
		
		if(status == 2) {
			//Bestandskunde
			String item1 = "Meine Bestellungen";
			String item2 = "Konto verwalten";
			String item3 = "Abmelden";
			comboBoxAnmelden.removeAllItems();
			comboBoxAnmelden.addItem(item1);
			comboBoxAnmelden.addItem(item2);
			comboBoxAnmelden.addItem(item3);
		}
		
		if(status == 3) {
			//Mitarbeiter
			String item1 = "Verwaltung";
			String item2 = "Abmelden";
			comboBoxAnmelden.removeAllItems();
			comboBoxAnmelden.addItem(item1);
			comboBoxAnmelden.addItem(item2);
		}
		
		if(status == 4) {
			//Admin
			String item1 = "Verwaltung";
			String item2 = "Abmelden";
			comboBoxAnmelden.removeAllItems();
			comboBoxAnmelden.addItem(item1);
			comboBoxAnmelden.addItem(item2);
		}
		
	}
	
	
	/**
	 * Schließt das Fenster der Klasse
	 */
	public static void fensterSchließen() {
		gui.dispose();
	}
	/**
	 * Zerlegt das Fenster und erstellt es anschließend Neu
	 */
	public static void fensterRestart() {
		gui.dispose();
		fenster = new GUI();
	}
	/**
	 * Setzt Text um anzuzeigen welche Rechte man besitzt
	 * @param recht Bestimmt welche Funktionen und Rechte hat
	 */
	public void setAngemeldet(String name) {
		if(name != null) {
			lblAngemeldet.setText("Hallo " +name);
		}
		else 
			lblAngemeldet.setText("");
		frame.revalidate();
		frame.repaint();
	}
	/**
	 * Öffnet das Anmeldefenster
	 */
	public void öffnenAnmeldefenster() {
		removeLogPanel();
		panelAnmelden = GUIAnmelden.getGUIAnmelden();
		layeredPane.add(panelAnmelden, JLayeredPane.POPUP_LAYER);
		frame.getRootPane().setDefaultButton(GUIAnmelden.btnAnmeldenEinloggen);
	}
	/**
	 * Entfernt Anmeldefenster
	 */
	public void removeLogPanel() {
		try {
			layeredPane.remove(panelAnmelden);
			frame.revalidate();
			frame.repaint();
		}catch(NullPointerException e) {
			/* Dient nur zum Abfangen der Exception. Der Fehler hat keinen Einfluss
			 * auf den Nutzer.
			 */
		}
	}
	/**
	 * Öffnet Fenster mit Fehlermeldung
	 */
	public void anmeldenFehlermeldung() {
		JOptionPane.showOptionDialog(null, "Email und Passwort stimmen nicht überein",
				"Anmeldung",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.WARNING_MESSAGE,
				null,
				new String[] {"Erneut versuchen"}, "");
		
	}
	/**
	 * Erstellt Hauptfenster des Programms
	 */
	public GUI() {
		layeredPane.setBackground(Color.WHITE);
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
		
		lblAngemeldet = new JLabel("");
		lblAngemeldet.setBounds(1046, 73, 172, 20);
		panelLogo.add(lblAngemeldet);
		lblAngemeldet.setText(LogStrg.getRechte());
		lblAngemeldet.setForeground(Color.BLACK);
		lblAngemeldet.setHorizontalAlignment(SwingConstants.LEFT);
		lblAngemeldet.setFont(new Font("Dialog", Font.BOLD, 15));
		
		URL logoUrl = GUI.class.getResource(
                "/SWP-Bilder/Logo.jpg");
		JLabel labelLogo = new JLabel();
		Image logo = new ImageIcon(logoUrl).getImage();
		labelLogo.setBounds(59, 0, 1248, 99);
		labelLogo.setIcon(new ImageIcon(logo));
		panelLogo.add(labelLogo);
		
		JPanel panelBar = new JPanel();
		panelBar.setBackground(SystemColor.control);
		panelBar.setBounds(0, 98, 1248, 50);
		frame.getContentPane().add(panelBar);
		panelBar.setLayout(null);
		
		comboBoxDamen = new JComboBox(damenCbList);
		comboBoxDamen.setFont(new Font("Dialog", Font.BOLD, 15));
		comboBoxDamen.setBackground(SystemColor.control);
		comboBoxDamen.setBounds(10, 2, 250, 48);
		comboBoxDamen.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
					
				String auswahl = (String) comboBoxDamen.getSelectedItem();
						
					if(auswahl == "Kleidung"){
						changePanel(GUIDamenKleidung.getGUIDamenKleidung());
						comboBoxHerren.setSelectedIndex(0);
					}
						  
					if(auswahl == "Schuhe"){
						changePanel(GUIDamenSchuhe.getGUIDamenSchuhe());
						comboBoxHerren.setSelectedIndex(0);
					}
							
					if(auswahl == "Accessoires"){
						changePanel(GUIDamenAccessoires.getGUIDamenAccessoires());
						comboBoxHerren.setSelectedIndex(0);
					}
				}
		
		});
		panelBar.add(comboBoxDamen);
		
		comboBoxHerren = new JComboBox(herrenCbList);
		comboBoxHerren.setFont(new Font("Dialog", Font.BOLD, 15));
		comboBoxHerren.setBackground(SystemColor.control);
		comboBoxHerren.setBounds(270, 2, 250, 48);
		comboBoxHerren.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == comboBoxHerren){
					
					String auswahl = (String) comboBoxHerren.getSelectedItem();
				    
					if(auswahl == "Kleidung"){
						changePanel(GUIHerrenKleidung.getGUIHerrenKleidung()); 
						comboBoxDamen.setSelectedIndex(0);
				    }
				  
					if(auswahl == "Schuhe"){
						changePanel(GUIHerrenSchuhe.getGUIHerrenSchuhe());
						comboBoxDamen.setSelectedIndex(0);
					}
					
					if(auswahl == "Accessoires"){
						changePanel(GUIHerrenAccessoires.getGUIHerrenAccessoires());
						comboBoxDamen.setSelectedIndex(0);
					}
				}
				
			}
			
		});
		panelBar.add(comboBoxHerren);
		
		comboBoxAnmelden = new JComboBox(array);
		comboBoxAnmelden.setBounds(1040, 2, 191, 48);
		comboBoxAnmelden.setFont(new Font("Dialog", Font.BOLD, 15));
		comboBoxAnmelden.setBackground(SystemColor.control);
		
		comboBoxAnmelden.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

					String auswahl = (String) comboBoxAnmelden.getSelectedItem();
					
					if(auswahl == "Anmelden") {
						öffnenAnmeldefenster();
					}

				    if(auswahl == "Meine Bestellungen") {
					   changePanel(new GUIKontoBestellungen());
					}
				 
				    if(auswahl == "Konto verwalten") {
				    	changePanel(new GUIKontoVerwalten());
					}
				   
				    if(auswahl == "Abmelden") {
				    	LogStrg.abmelden();
				    }
				    
				    if(auswahl == "Verwaltung") {
				    	changePanel(GUIMitarbeiter.getGUIMitarbeiter());
				    }
				    if(auswahl == "Registrieren") {
				    	changePanel(new GUIBestandskundeRegistrierung());
				    }
				}
		});
		panelBar.add(comboBoxAnmelden);
		
		URL warenkorbUrl = GUI.class.getResource(
                "/Icons 64x64/shopping-cart.png");
		Image warenkorb = new ImageIcon(warenkorbUrl).getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
		btnWarenkorb = new JButton(new ImageIcon(warenkorb));
		btnWarenkorb.setContentAreaFilled(false);
		btnWarenkorb.setToolTipText("Warenkorb");
		btnWarenkorb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				comboBoxDamen.setSelectedIndex(0);
				comboBoxHerren.setSelectedIndex(0);
				changePanel(GUIWarenkorb.getGUIWarenkorb());
			}
			
		});
		btnWarenkorb.setBounds(936, 2, 48, 48);
		panelBar.add(btnWarenkorb);
		
		URL homeUrl = GUI.class.getResource(
                "/Icons 64x64/house.png");
		Image homebutton = new ImageIcon(homeUrl).getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
		btnHome = new JButton(new ImageIcon(homebutton));
		btnHome.setContentAreaFilled(false);
		btnHome.setToolTipText("Home");
		btnHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				comboBoxDamen.setSelectedIndex(0);
				comboBoxHerren.setSelectedIndex(0);
				GUIHomepage.zurücksetzenArtikel();
				changePanel(GUIHomepage.getHomepage());
				
			}
			
		});
		btnHome.setBounds(876, 2, 48, 48);
		panelBar.add(btnHome);
		
		varPanel = GUIHomepage.getHomepage();
		layeredPane.add(varPanel, JLayeredPane.DEFAULT_LAYER);
		
		JLabel labelMainHintergrund = new JLabel();
		labelMainHintergrund.setBounds(0, 0, 1234, 711);
		frame.getContentPane().add(labelMainHintergrund);
	
		frame.setVisible(true);
	
	}
	
	
	
}
