package Frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

public class GUIArtikel implements ActionListener {
	
	JButton btnZur�ck = new JButton();
	JButton btnAnmelden = new JButton();
	public JComboBox comboBoxHerren = new JComboBox();
	public JComboBox comboBoxDamen = new JComboBox();
	public JComboBox comboBoxAnmelden = new JComboBox();
	public String[] damenCbList;
	public String[] herrenCbList;
	public String[] anmeldenCbList;
	public JPanel panelHerrenKleidung = new JPanel();
	public String[] comboBoxGr��en = {"XS, S, M, L, XL, XXL"};

	private JFrame frame;

	

	
	public GUIArtikel(String[]damenCbList, String[]herrenCbList, String[]anmeldenCbList) {
		System.out.println("Ausgef�hrt Artikel");
		this.damenCbList = damenCbList;
		this.herrenCbList = herrenCbList;
		this.anmeldenCbList = anmeldenCbList;
		initialize(damenCbList, herrenCbList, anmeldenCbList);
	}


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
		
		JPanel panelMain = new JPanel();
		panelMain.setBackground(Color.WHITE);
		panelMain.setBounds(0, 147, 1234, 563);
		frame.getContentPane().add(panelMain);
		panelMain.setLayout(null);
		
		btnZur�ck = new JButton("Zur\u00FCck");
		btnZur�ck.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnZur�ck.setBackground(Color.WHITE);
		btnZur�ck.setBounds(10, 11, 89, 35);
		btnZur�ck.addActionListener(this);
		panelMain.add(btnZur�ck);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(105, 60, 1051, 434);
		panelMain.add(panel);
		
		
		JLabel labelArtikelBild = new JLabel("");
		labelArtikelBild.setBackground(Color.WHITE);
		labelArtikelBild.setHorizontalAlignment(SwingConstants.CENTER);
		labelArtikelBild.setBounds(70, 32, 250, 250);
		labelArtikelBild.setIcon(new ImageIcon("C:\\Users\\hinzl\\Desktop\\Softwareprojekt\\SWP-Bilder\\Herrenjacke_6.jpg"));
		panel.add(labelArtikelBild);
		
		JLabel lblArtikelTitel = new JLabel("Schwarze Jacke DENIM");
		lblArtikelTitel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblArtikelTitel.setBounds(362, 11, 319, 49);
		panel.add(lblArtikelTitel);
		
		JLabel lblArtikelStatus = new JLabel("Auf Lager");
		lblArtikelStatus.setBounds(362, 57, 110, 43);
		panel.add(lblArtikelStatus);
		lblArtikelStatus.setForeground(new Color(0, 204, 51));
		lblArtikelStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblArtikelStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnWarenkorbHinz = new JButton("In den Warenkorb");
		btnWarenkorbHinz.setBounds(361, 185, 153, 35);
		panel.add(btnWarenkorbHinz);
		btnWarenkorbHinz.setBackground(SystemColor.inactiveCaptionBorder);
		
		JTextPane txtpnArtikelBeschreibung = new JTextPane();
		txtpnArtikelBeschreibung.setBackground(SystemColor.inactiveCaptionBorder);
		txtpnArtikelBeschreibung.setText("Test dishfinsmva s");
		txtpnArtikelBeschreibung.setBounds(362, 272, 514, 132);
		panel.add(txtpnArtikelBeschreibung);
		
		JComboBox comboBoxArtikelGr��e = new JComboBox(comboBoxGr��en);
		comboBoxArtikelGr��e.setBounds(362, 111, 152, 35);
		comboBoxArtikelGr��e.setBackground(SystemColor.inactiveCaptionBorder);
		panel.add(comboBoxArtikelGr��e);
		
		
		frame.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnZur�ck) 
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

	}
}

