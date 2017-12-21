package Frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class GUIHerrenKleidung implements ActionListener{
	
	JButton btnZurück = new JButton();
	JButton btnAnmelden = new JButton();
	JButton btnHinz = new JButton();
	public JComboBox comboBoxHerren = new JComboBox();
	public JComboBox comboBoxDamen = new JComboBox();
	public JComboBox comboBoxAnmelden = new JComboBox();
	JPanel panelMain = new JPanel();
	public String[] damenCbList;
	public String[] herrenCbList;
	public String[] anmeldenCbList;
	public JButton btnZumArtikel = new JButton();
	public JButton btnZumArtikel2 = new JButton();
	public JPanel panelHerrenKleidung = new JPanel();
	public int abstandPlus = 230;
	public int abstand = 270;

	private JFrame frame;


	/**
	 * Create the application.
	 */
	public GUIHerrenKleidung(String[]damenCbList, String[]herrenCbList, String[]anmeldenCbList) {
		System.out.println("Ausgeführt HK");
		this.damenCbList = damenCbList;
		this.herrenCbList = herrenCbList;
		this.anmeldenCbList = anmeldenCbList;
		initialize(damenCbList, herrenCbList, anmeldenCbList);
		
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String[]damenCbList, String[]herrenCbList, String[]anmeldenCbList) {
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
		
		JLabel labelLogo = new JLabel("New label");
		labelLogo.setBounds(56, 0, 1226, 99);
		labelLogo.setIcon(new ImageIcon("C:\\Users\\hinzl\\Desktop\\SWP-Bilder\\modeLogo.jpg"));
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
		
		panelMain = new JPanel();
		panelMain.setBackground(Color.WHITE);
		panelMain.setBounds(0, 147, 1234, 563);
		frame.getContentPane().add(panelMain);
		panelMain.setLayout(null);
		
		JPanel panelScrollPaneBar = new JPanel();
		panelScrollPaneBar.setBackground(SystemColor.inactiveCaptionBorder);
		panelScrollPaneBar.setLayout(null);
		
		JScrollPane scrollPaneHerrenKleidungBar = new JScrollPane(panelScrollPaneBar);
		scrollPaneHerrenKleidungBar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneHerrenKleidungBar.setBounds(10, 97, 270, 455);
		panelMain.add(scrollPaneHerrenKleidungBar);
		
	
		panelHerrenKleidung = new JPanel();
		panelHerrenKleidung.setBackground(SystemColor.inactiveCaptionBorder);
		JScrollPane scrollPaneHerrenKleidung = new JScrollPane(panelHerrenKleidung);
		scrollPaneHerrenKleidung.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		panelHerrenKleidung.setPreferredSize(new Dimension(549, 2000));
		panelHerrenKleidung.setLayout(null);
		scrollPaneHerrenKleidung.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneHerrenKleidung.setBounds(323, 97, 901, 455);
		panelMain.add(scrollPaneHerrenKleidung);
		
		
		
		//Artikelbeispiel
		
		JPanel panelArtikel = new JPanel();
		panelArtikel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelArtikel.setBackground(SystemColor.inactiveCaption);
		panelArtikel.setBounds(66, 30, 680, 188);
		panelHerrenKleidung.add(panelArtikel);
		panelArtikel.setLayout(null);
		
		
		ImageIcon icon = new ImageIcon("src\\SWP-Bilder\\Logo.jpg");
        int width = icon.getIconHeight() / 2;
        int height = icon.getIconWidth() / 2;
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_FAST);
		
		JLabel labelArtikelBild = new JLabel("");
		labelArtikelBild.setHorizontalAlignment(SwingConstants.CENTER);
		labelArtikelBild.setVerticalAlignment(SwingConstants.TOP);
		labelArtikelBild.setIcon(new ImageIcon(img));
		labelArtikelBild.setBounds(33, 25, 133, 135);
		panelArtikel.add(labelArtikelBild);
		
		JLabel lblSchwarzeJackeDenim = new JLabel("Schwarze Jacke DENIM");
		lblSchwarzeJackeDenim.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblSchwarzeJackeDenim.setBounds(203, 11, 213, 30);
		panelArtikel.add(lblSchwarzeJackeDenim);
		
		JLabel lblNewLabel = new JLabel("Preis: 24\u20AC");
		lblNewLabel.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		lblNewLabel.setBounds(203, 71, 101, 47);
		panelArtikel.add(lblNewLabel);
		
		btnZumArtikel = new JButton("Zum Artikel");
		btnZumArtikel.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnZumArtikel.setBackground(Color.WHITE);
		btnZumArtikel.setBounds(198, 130, 139, 30);
		btnZumArtikel.addActionListener(this);
		panelArtikel.add(btnZumArtikel);
		
		JLabel lblStatus = new JLabel("Auf Lager");
		lblStatus.setForeground(new Color(0, 204, 51));
		lblStatus.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblStatus.setBounds(203, 41, 147, 30);
		panelArtikel.add(lblStatus);
		
		
		btnZurück = new JButton("Zur\u00FCck");
		btnZurück.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnZurück.setBackground(Color.WHITE);
		btnZurück.setBounds(10, 11, 89, 35);
		btnZurück.addActionListener(this);
		panelMain.add(btnZurück);
		
		JButton btnNewButton = new JButton("Jacken");
		btnNewButton.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnNewButton.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton.setBounds(10, 23, 248, 43);
		panelScrollPaneBar.add(btnNewButton);
		
		JButton btnShirts = new JButton("Shirts");
		btnShirts.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnShirts.setBackground(SystemColor.inactiveCaptionBorder);
		btnShirts.setBounds(10, 87, 248, 43);
		panelScrollPaneBar.add(btnShirts);
		
		JButton btnHosen = new JButton("Hosen");
		btnHosen.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnHosen.setBackground(SystemColor.inactiveCaptionBorder);
		btnHosen.setBounds(10, 151, 248, 43);
		panelScrollPaneBar.add(btnHosen);
		 /////
		
		/////
		
		btnHinz = new JButton("Hinz");
		btnHinz.setBounds(355, 48, 89, 23);
		btnHinz.addActionListener(this);
		panelMain.add(btnHinz);
		
		frame.setVisible(true);
	}
	
	
public ImageIcon bildAnpassen(String imageRoot) {
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(imageRoot).getImage().getScaledInstance(133, 135, Image.SCALE_DEFAULT));
		return imageIcon;
	}
	

public void hinzufügenArtikel() {
		
		System.out.println("HINZ");
		
		JPanel panelArtikel2 = new JPanel();
		panelArtikel2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelArtikel2.setBackground(SystemColor.inactiveCaption);
		panelArtikel2.setBounds(66, abstand, 680, 188);
		panelArtikel2.setLayout(null);
		
		
		ImageIcon icon2 = new ImageIcon("src\\SWP-Bilder\\Herrenjacke_6.jpg");
        int width2 = icon2.getIconHeight() / 2;
        int height2 = icon2.getIconWidth() / 2;
        Image img2 = icon2.getImage().getScaledInstance(width2, height2, Image.SCALE_FAST);
		
		JLabel labelArtikelBild2 = new JLabel("");
		labelArtikelBild2.setHorizontalAlignment(SwingConstants.CENTER);
		labelArtikelBild2.setVerticalAlignment(SwingConstants.TOP);
		labelArtikelBild2.setIcon(bildAnpassen("src\\SWP-Bilder\\Herrenjacke_6.jpg"));
		labelArtikelBild2.setBounds(33, 25, 133, 135);
		panelArtikel2.add(labelArtikelBild2);
		
		JLabel lblSchwarzeJackeDenim2 = new JLabel("Schwarze Jacke DENIM");
		lblSchwarzeJackeDenim2.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblSchwarzeJackeDenim2.setBounds(203, 11, 213, 30);
		panelArtikel2.add(lblSchwarzeJackeDenim2);
		
		JLabel lblNewLabel2 = new JLabel("Preis: 24\u20AC");
		lblNewLabel2.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		lblNewLabel2.setBounds(203, 71, 101, 47);
		panelArtikel2.add(lblNewLabel2);
		
		btnZumArtikel2 = new JButton("Zum Artikel");
		btnZumArtikel2.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnZumArtikel2.setBackground(Color.WHITE);
		btnZumArtikel2.setBounds(198, 130, 139, 30);
		btnZumArtikel2.addActionListener(this);
		panelArtikel2.add(btnZumArtikel2);
		
		JLabel lblStatus2 = new JLabel("Auf Lager");
		lblStatus2.setForeground(new Color(0, 204, 51));
		lblStatus2.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblStatus2.setBounds(203, 41, 147, 30);
		panelArtikel2.add(lblStatus2);
		
		
		panelHerrenKleidung.add(panelArtikel2);		
		frame.invalidate();
		frame.validate();
		frame.repaint();
		abstand = abstand + abstandPlus; 
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btnZurück) 
		{
			frame.dispose();
			new GUI();
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
				new GUIAnmelden();
			}

		    if(auswahl == "Meine Bestellungen") {
			    new GUIKontoBestellungen(damenCbList, herrenCbList, anmeldenCbList);
			}
		    
		    if(auswahl == "Konto verwalten") {
			    new GUIKontoVerwalten(damenCbList, herrenCbList, anmeldenCbList);
			}
		}
		if(e.getSource() == btnZumArtikel) {
			System.out.println("Hier");
			new GUIArtikel(damenCbList, herrenCbList, anmeldenCbList);
		}
		
		if(e.getSource() == btnHinz) {
			hinzufügenArtikel();
		}
	}
}
