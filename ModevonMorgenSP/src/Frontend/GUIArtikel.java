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
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

import Artikelverwaltung.Artikelsammlung;

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
	public String[] comboBoxGr��en = {"XS", "S","M", "L", "XL", "XXL"};

	public JFrame frame;
	static JPanel panelMain = new JPanel();

	

	
	

	/**
	 * @wbp.parser.entryPoint
	 */
	static JPanel getGUIArtikel(int artikelNummer) {
		
		panelMain = new JPanel();
		panelMain.setBackground(Color.WHITE);
		panelMain.setBounds(0, 0, 1234, 563);
		panelMain.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(42, 44, 1150, 491);
		panelMain.add(panel);
		
		
		JLabel labelArtikelBild = new JLabel("");
		labelArtikelBild.setBackground(Color.WHITE);
		labelArtikelBild.setHorizontalAlignment(SwingConstants.CENTER);
		labelArtikelBild.setBounds(54, 32, 250, 250);
	
		ImageIcon icon;
		if(Artikelsammlung.getArtikel(artikelNummer).getImage() != null) {
			icon = new ImageIcon(Artikelsammlung.getArtikel(artikelNummer).getImage());
		}
		else 
			icon = new ImageIcon("src/SWP-Bilder/NoPic.gif");
        Image img = icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        labelArtikelBild.setIcon(new ImageIcon(img));
		
		panel.add(labelArtikelBild);
		
		JLabel lblArtikelTitel = new JLabel(Artikelsammlung.getArtikel(artikelNummer).getBezeichnung());
		lblArtikelTitel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblArtikelTitel.setBounds(362, 11, 319, 49);
		panel.add(lblArtikelTitel);
		
		JLabel lblArtikelStatus = new JLabel(Artikelsammlung.getArtikel(artikelNummer).getVerf�gbarkeit());
		lblArtikelStatus.setBounds(362, 57, 319, 43);
		panel.add(lblArtikelStatus);
		lblArtikelStatus.setForeground(new Color(0, 204, 51));
		lblArtikelStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblArtikelStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnWarenkorbHinz = new JButton("In den Warenkorb");
		btnWarenkorbHinz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Hinzuf�gen
			}
		});
		btnWarenkorbHinz.setBounds(361, 185, 153, 35);
		panel.add(btnWarenkorbHinz);
		btnWarenkorbHinz.setBackground(SystemColor.inactiveCaptionBorder);
		
		JTextPane txtpnArtikelBeschreibung = new JTextPane();
		txtpnArtikelBeschreibung.setBackground(SystemColor.inactiveCaptionBorder);
		txtpnArtikelBeschreibung.setText("Test dishfinsmva s");
		txtpnArtikelBeschreibung.setBounds(362, 272, 514, 132);
		panel.add(txtpnArtikelBeschreibung);
		
		JComboBox comboBoxArtikelGr��e = new JComboBox();
		comboBoxArtikelGr��e.setBounds(362, 111, 152, 35);
		comboBoxArtikelGr��e.setBackground(SystemColor.inactiveCaptionBorder);
		panel.add(comboBoxArtikelGr��e);
		
		
		panelMain.setVisible(true);
		return panelMain;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnZur�ck) 
		{
			frame.dispose();
			new GUI();
		}

	}
}

