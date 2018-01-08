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
import javax.swing.JSpinner;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

import Artikelverwaltung.Accessoires;
import Artikelverwaltung.Artikel;
import Artikelverwaltung.Artikelsammlung;
import Artikelverwaltung.Kleidung;
import Artikelverwaltung.Schuhe;
import Warenkorbverwaltung.Warenkorb;

public class GUIArtikel implements ActionListener {
	
	
	JButton btnZurück = new JButton();
	JButton btnAnmelden = new JButton();
	public JComboBox comboBoxHerren = new JComboBox();
	public JComboBox comboBoxDamen = new JComboBox();
	public JComboBox comboBoxAnmelden = new JComboBox();
	public String[] damenCbList;
	public String[] herrenCbList;
	public String[] anmeldenCbList;
	static JLabel lblArtikelStatus;
	static JLabel lblArtikelTitel;
	static JLabel lblArtikelBild;
	static JButton btnWarenkorbHinz;
	public JPanel panelHerrenKleidung = new JPanel();
	static JLabel lblZusatz;

	public JFrame frame;
	static JPanel panelMain = new JPanel();
	
	static Integer value = new Integer(0);
	static Integer min = new Integer(0);
	static Integer max = new Integer(100);
	static Integer step = new Integer(1);
	
	static SpinnerNumberModel model = new SpinnerNumberModel(value, min, max, step);
	static JSpinner spinnerMenge = new JSpinner(model);
	private static JLabel label;
	private static JLabel lblNewLabel;
	

	

	/**
	 * @return 
	 * 
	 */
	public static Color checkStatus(int artikelNummer) {
		String status = Artikelsammlung.getArtikel(artikelNummer).getVerfügbarkeit();
		Color farbe = null;
		
		if(status.equals("Sofort lieferbar")){
			farbe = Color.GREEN;
		}
		if(status.equals("Lieferbar in 1-3 Tagen")) {
			farbe = Color.ORANGE;
		}
		if(status.equals("Lieferbar in 1-3 Wochen")) {
			farbe = Color.ORANGE;
		}
		if(status.equals("Nicht mehr Verfügbar")) {
			farbe = Color.RED;
		}
		return farbe;
	}
	
	public static String zusatzLaden(int artikelNummer) {
		String zusatz = null;
		Artikel a = Artikelsammlung.getArtikel(artikelNummer);
		
		if(a.getClass().getName().equals("Artikelverwaltung.Schuhe")) {
			Schuhe s = (Schuhe) a;
			int x = s.getSchuhgröße();
			zusatz ="Größe: "+ String.valueOf(x);
		}
		if(a.getClass().getName().equals("Artikelverwaltung.Kleidung")) {
			Kleidung k = (Kleidung) a;
			String x = k.getGröße();
			zusatz ="Größe: "+ x;
		};
		if(a.getClass().getName().equals("Artikelverwaltung.Accessoires")) {
			Accessoires ac = (Accessoires) a;
			String x = ac.getFarbe();
			zusatz = "Farbe: "+ x;
		};
		
		return zusatz;
	}
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	static JPanel getGUIArtikel(int artikelNummer) {
		
		panelMain = new JPanel();
		panelMain.setBackground(Color.WHITE);
		panelMain.setBounds(0, 0, 1234, 563);
		panelMain.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(42, 44, 1150, 491);
		panelMain.add(panel);
		
		
		lblArtikelBild = new JLabel("");
		lblArtikelBild.setBackground(Color.WHITE);
		lblArtikelBild.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtikelBild.setBounds(54, 32, 250, 250);
	
		ImageIcon icon;
		if(Artikelsammlung.getArtikel(artikelNummer).getImage() != null) {
			icon = new ImageIcon(Artikelsammlung.getArtikel(artikelNummer).getImage());
			}
			else 
			icon = new ImageIcon("src/SWP-Bilder/NoPic.gif");
        	Image img = icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        lblArtikelBild.setIcon(new ImageIcon(img));
		
		panel.add(lblArtikelBild);
		
		lblArtikelTitel = new JLabel(Artikelsammlung.getArtikel(artikelNummer).getBezeichnung());
		lblArtikelTitel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblArtikelTitel.setBounds(362, 11, 319, 49);
		panel.add(lblArtikelTitel);
		
		lblArtikelStatus = new JLabel(Artikelsammlung.getArtikel(artikelNummer).getVerfügbarkeit());
		lblArtikelStatus.setBounds(372, 229, 319, 43);
		lblArtikelStatus.setForeground(checkStatus(artikelNummer));
		panel.add(lblArtikelStatus);
		lblArtikelStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblArtikelStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnWarenkorbHinz = new JButton("In den Warenkorb");
		btnWarenkorbHinz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int anzahlArtikel = model.getNumber().intValue();
				Warenkorb.ArtikelHinzufügen(Artikelsammlung.getArtikel(artikelNummer), anzahlArtikel);
				model.setValue(0);
			}																								
		});
		btnWarenkorbHinz.setBounds(430, 268, 153, 35);
		panel.add(btnWarenkorbHinz);
		btnWarenkorbHinz.setBackground(SystemColor.inactiveCaptionBorder);
		
		
		spinnerMenge.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spinnerMenge.setBounds(362, 270, 58, 35);
		panel.add(spinnerMenge);
		
		
		JLabel lblHersteller = new JLabel(Artikelsammlung.getArtikel(artikelNummer).getHersteller());
		lblHersteller.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHersteller.setBounds(362, 51, 183, 33);
		panel.add(lblHersteller);
		
		lblZusatz = new JLabel();
		lblZusatz.setText(zusatzLaden(artikelNummer));
		lblZusatz.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblZusatz.setBounds(362, 81, 221, 26);
		panel.add(lblZusatz);
		
		JLabel lblPreis = new JLabel(String.valueOf(Artikelsammlung.getArtikel(artikelNummer).getPreis())+ "€");
		lblPreis.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblPreis.setBounds(362, 128, 163, 43);
		panel.add(lblPreis);
		
		JLabel lblRabatt = new JLabel(String.valueOf(Artikelsammlung.getArtikel(artikelNummer).getRabatt())+ "%");
		lblRabatt.setForeground(Color.RED);
		lblRabatt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRabatt.setBounds(362, 169, 92, 26);
		panel.add(lblRabatt);
		
		
		panelMain.setVisible(true);
		return panelMain;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnZurück) 
		{
			frame.dispose();
			new GUI();
		}

	}
}

