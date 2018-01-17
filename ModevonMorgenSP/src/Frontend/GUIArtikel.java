package Frontend;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import Artikelverwaltung.Accessoires;
import Artikelverwaltung.Artikel;
import Artikelverwaltung.Artikelsammlung;
import Artikelverwaltung.Kleidung;
import Artikelverwaltung.Schuhe;
import Warenkorbverwaltung.Warenkorb;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
/**
 * 
 * @author Hinz

 *
 */
public class GUIArtikel {
	
	static JLabel lblArtikelStatus;
	static JLabel lblArtikelTitel;
	static JLabel lblArtikelBild;
	static JButton btnWarenkorbHinz;
	public JPanel panelHerrenKleidung = new JPanel();
	static JLabel lblZusatz;
	static JLabel lblPreis;
	static JLabel lblRabatt;
	static String status;

	static JPanel panelMain = new JPanel();
	
	static Integer value = new Integer(1);
	static Integer min = new Integer(1);
	static Integer max = new Integer(100);
	static Integer step = new Integer(1);
	
	static SpinnerNumberModel model = new SpinnerNumberModel(value, min, max, step);
	static JSpinner spinnerMenge = new JSpinner(model);
	

	

	/**
	 * Erstellt Fenster bei Bestellung eines Artikels de nicht mehr auf Lager ist
	 */
	public static void bestellungFehlermeldung() {
		
		JOptionPane.showOptionDialog(null, "Der Artikel ist leider nicht mehr auf Lager",
				"Bestellung",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.WARNING_MESSAGE,
				null,
				new String[] {"Erneut versuchen"}, "");
		
	}

	/**
	 * Überprüft Verfügbarkeit des Artikels und setzt dementsprechen die Farbe des Textes
	 * @param artikelNummer Eindeutige Nummer des Artikels
	 * @return farbe Farbe die auskunft über Verfügbarkeit des Artikels gibt
	 */
	public static Color checkStatus(int artikelNummer) {
		status = Artikelsammlung.getArtikel(artikelNummer).getVerfügbarkeit();
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
	
	/**
	 * Überprüft Artikelkategorie und lädt dementsprechen zusätzliches Attribut 
	 * @param artikelNummer eindeutige Nummer des Artikels
	 * @return zusatz Je nach Artikelkategorie zusätzliches Attribut (Kleidungsgröße, Schuhgröße, Farbe)
	 */
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
	 * Errechnet Rabattpreis und setzt den neuen und alten Preis
	 * @param artikelNummer eindeutige Nummer des Artikels
	 */
	public static void ladeRabattPreis(int artikelNummer) {
		double rabatt = Artikelsammlung.getArtikel(artikelNummer).getRabatt();
		double preis = Artikelsammlung.getArtikel(artikelNummer).getPreis();
		preis = Math.round(preis*10)/10.0;
		double rabattPreis = rabatt / 100;
		double rabattPreis2 = preis * rabattPreis;
		double neuerPreis = preis - rabattPreis2;
		neuerPreis = Math.round(neuerPreis*10)/10.0;
		
		if(rabatt == 0) {
			lblPreis.setText(preis + " €");
		}
		if(rabatt > 0) {
			lblPreis.setText(neuerPreis + " €");
			lblRabatt.setText("Statt: " + preis + " €");
			lblRabatt.setForeground(Color.RED);
		}
		
	}
	
	
	/**
	 * Erstellt und Liefert Fenster für einen Artikel
	 * @param artikelNummer eindeutige Nummer des Artikels
	 * @return panelMain Artikelseite
	 * @wbp.parser.entryPoint
	 */
	static JPanel getGUIArtikel(int artikelNummer) {
		
		
		panelMain = new JPanel();
		panelMain.setBackground(Color.WHITE);
		panelMain.setBounds(0, 0, 1248, 570);
		panelMain.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(70, 130, 180)));
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 1228, 548);
		panelMain.add(panel);
		
		
		lblArtikelBild = new JLabel("");
		lblArtikelBild.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, Color.GRAY, null));
		lblArtikelBild.setBackground(Color.WHITE);
		lblArtikelBild.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtikelBild.setBounds(241, 161, 250, 250);
	
		ImageIcon icon;
		if(Artikelsammlung.getArtikel(artikelNummer).getImage() != null) {
			icon = new ImageIcon(Artikelsammlung.getArtikel(artikelNummer).getImage());
		}
		else {
			URL imgUrl = GUI.class.getResource(
	                "/SWP-Bilder/NoPic.gif");
			icon = new ImageIcon(imgUrl);}
        Image img = icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        lblArtikelBild.setIcon(new ImageIcon(img));
		
		panel.add(lblArtikelBild);
		
		lblArtikelTitel = new JLabel(Artikelsammlung.getArtikel(artikelNummer).getBezeichnung());
		lblArtikelTitel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblArtikelTitel.setBounds(549, 129, 514, 49);
		panel.add(lblArtikelTitel);
		
		lblArtikelStatus = new JLabel(Artikelsammlung.getArtikel(artikelNummer).getVerfügbarkeit());
		lblArtikelStatus.setBounds(549, 356, 319, 43);
		lblArtikelStatus.setForeground(checkStatus(artikelNummer));
		panel.add(lblArtikelStatus);
		lblArtikelStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblArtikelStatus.setFont(new Font("Dialog", Font.BOLD, 16));
		
		btnWarenkorbHinz = new JButton("In den Warenkorb");
		btnWarenkorbHinz.setFont(new Font("Dialog", Font.PLAIN, 21));
		btnWarenkorbHinz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(status.equals("Nicht mehr Verfügbar")) {
					bestellungFehlermeldung();
				}
				
				if(!(status.equals("Nicht mehr Verfügbar"))) {
				int anzahlArtikel = model.getNumber().intValue();
				Warenkorb.ArtikelHinzufügen(Artikelsammlung.getArtikel(artikelNummer), anzahlArtikel);
				model.setValue(1);
				}
			}																								
		});
		btnWarenkorbHinz.setBounds(617, 397, 208, 35);
		panel.add(btnWarenkorbHinz);
		btnWarenkorbHinz.setBackground(SystemColor.inactiveCaptionBorder);
		
		
		spinnerMenge.setFont(new Font("Dialog", Font.PLAIN, 15));
		spinnerMenge.setBounds(549, 397, 67, 35);
		panel.add(spinnerMenge);
		
		
		JLabel lblHersteller = new JLabel(Artikelsammlung.getArtikel(artikelNummer).getHersteller());
		lblHersteller.setFont(new Font("Dialog", Font.BOLD, 15));
		lblHersteller.setBounds(549, 180, 396, 33);
		panel.add(lblHersteller);
		
		lblZusatz = new JLabel();
		lblZusatz.setText(zusatzLaden(artikelNummer));
		lblZusatz.setFont(new Font("Dialog", Font.BOLD, 17));
		lblZusatz.setBounds(549, 210, 358, 26);
		panel.add(lblZusatz);
		
		lblPreis = new JLabel("");
		lblPreis.setFont(new Font("Dialog", Font.BOLD, 28));
		lblPreis.setBounds(549, 257, 163, 43);
		panel.add(lblPreis);
		
		lblRabatt = new JLabel("");
		lblRabatt.setForeground(Color.BLACK);
		lblRabatt.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblRabatt.setBounds(549, 298, 163, 26);
		panel.add(lblRabatt);
		
		ladeRabattPreis(artikelNummer);
		panelMain.setVisible(true);
		return panelMain;
	}
}

