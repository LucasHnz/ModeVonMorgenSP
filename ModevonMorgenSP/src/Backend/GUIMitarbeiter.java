package Backend;

import java.awt.Color;
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

import Frontend.GUI;
import Frontend.GUIAnmelden;
import Frontend.GUIKontoBestellungen;
import Frontend.GUIKontoVerwalten;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JList;

public class GUIMitarbeiter implements ActionListener{
	
	JButton btnZur¸ck = new JButton();
	JButton btnAnmelden = new JButton();
	public JComboBox comboBoxArtikelHerren = new JComboBox();
	public JComboBox comboBoxArtikelDamen = new JComboBox();
	public JComboBox comboBoxAnmelden = new JComboBox();
	public String[] anmeldenCbList;
	public String[] damenCbList = {"Damen", "-----------------------------------", "Kleidung", "Schuhe", "Accessoires"};
	public String[] herrenCbList = {"Herren","------------------------------------", "Kleidung", "Schuhe", "Accessoires"};
	public int abstandsZahl = 170;
	public String[] mitarbeiterListe = {"Anna Gross", "Falk Maoro", "Bastian Walter", "Lucas Hinz"};
	


	private JFrame frame;


	/**
	 * Create the application.
	 */
	public GUIMitarbeiter(String[]anmeldenCbList) {
		System.out.println("Ausgef¸hrt HK");
		this.anmeldenCbList = anmeldenCbList;
		initialize(damenCbList, herrenCbList, anmeldenCbList);
		for(int i = 0; i>= mitarbeiterListe.length; i++) {
			
		}
		
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
		
		comboBoxAnmelden = new JComboBox(anmeldenCbList);
		comboBoxAnmelden.setBounds(1040, 0, 173, 50);
		comboBoxAnmelden.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		comboBoxAnmelden.setBackground(SystemColor.control);
		comboBoxAnmelden.addActionListener(this);
		panelBar.add(comboBoxAnmelden);
		
		//Hauptfenster
		JPanel panelMain = new JPanel();
		panelMain.setBackground(Color.WHITE);
		panelMain.setBounds(0, 147, 1234, 563);
		frame.getContentPane().add(panelMain);
		panelMain.setLayout(null);
		
		
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
		
		JLabel lblGroeﬂe = new JLabel("Grˆﬂe: 34");
		lblGroeﬂe.setBounds(167, 50, 78, 32);
		lblGroeﬂe.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		panel.add(lblGroeﬂe);
		
		JLabel lblPreis = new JLabel("34Ä");
		lblPreis.setBounds(402, 107, 58, 28);
		lblPreis.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		panel.add(lblPreis);

		
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btnZur¸ck) 
		{
			frame.dispose();
			new GUI();
		}
		if(e.getSource() == comboBoxArtikelDamen){
			
			String auswahl = (String) comboBoxArtikelDamen.getSelectedItem();
		    
			if(auswahl == "Kleidung"){
			
			 
		    }
		  
			if(auswahl == "Schuhe"){
			 
			  
			}
			
			if(auswahl == "Accessoires"){
				
			  
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
