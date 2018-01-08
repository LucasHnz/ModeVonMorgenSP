package Frontend;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Artikelverwaltung.Accessoires;
import Artikelverwaltung.Artikel;
import Artikelverwaltung.Artikelsammlung;
import Artikelverwaltung.Kleidung;
import Artikelverwaltung.Schuhe;

public class GUINeuerArtikel {	
	
	static JLabel lblPreis;
	static JLabel lblRabattPreis;
	static JLabel lblZusatz;
	
	
	public static void ladeRabattPreis(int artikelNummer) {
		double rabatt = Artikelsammlung.getArtikel(artikelNummer).getRabatt();
		double preis = Artikelsammlung.getArtikel(artikelNummer).getPreis();
		double rabattPreis = rabatt / 100;
		double rabattPreis2 = preis * rabattPreis;
		double neuerPreis = preis - rabattPreis2;
		
		if(rabatt == 0) {
			lblPreis.setText(preis + " �");
		}
		if(rabatt > 0) {
			lblPreis.setText(neuerPreis + " �");
			lblRabattPreis.setText("Statt: " + preis + " �");
			lblRabattPreis.setForeground(Color.RED);
		}
		
	}
	
	public static String ladeZusatz(int artikelNummer) {
		String zusatz = null;
		Artikel a = Artikelsammlung.getArtikel(artikelNummer);
		
		if(a.getClass().getName().equals("Artikelverwaltung.Schuhe")) {
			Schuhe s = (Schuhe) a;
			int x = s.getSchuhgr��e();
			zusatz ="Gr��e: "+ String.valueOf(x);
		}
		if(a.getClass().getName().equals("Artikelverwaltung.Kleidung")) {
			Kleidung k = (Kleidung) a;
			String x = k.getGr��e();
			zusatz ="Gr��e: "+ x;
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
static  Component neuerArtikel(int artikelNummer) {
	
	
		JPanel panelArtikel = new JPanel();
		panelArtikel.setBorder(null);
		panelArtikel.setBackground(Color.WHITE);
		panelArtikel.setBounds(66, 30, 680, 188);
		panelArtikel.setLayout(null);
		
		
		JLabel labelArtikelBild = new JLabel("");
		labelArtikelBild.setHorizontalAlignment(SwingConstants.CENTER);
		labelArtikelBild.setVerticalAlignment(SwingConstants.TOP);
		labelArtikelBild.setBounds(10, 11, 166, 166);
		
		ImageIcon icon;
		if(Artikelsammlung.getArtikel(artikelNummer).getImage() != null) {
			icon = new ImageIcon(Artikelsammlung.getArtikel(artikelNummer).getImage());
		}
		else 
			icon = new ImageIcon("src/SWP-Bilder/NoPic.gif");
        Image img = icon.getImage().getScaledInstance(166, 166, Image.SCALE_SMOOTH);
        labelArtikelBild.setIcon(new ImageIcon(img));
		
		panelArtikel.add(labelArtikelBild);
		
		JLabel lblSchwarzeJackeDenim = new JLabel(Artikelsammlung.getArtikel(artikelNummer).getBezeichnung());
		lblSchwarzeJackeDenim.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblSchwarzeJackeDenim.setBounds(186, 11, 213, 30);
		panelArtikel.add(lblSchwarzeJackeDenim);
		
		lblPreis = new JLabel();
		lblPreis.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		lblPreis.setBounds(186, 108, 101, 30);
		panelArtikel.add(lblPreis);
		
		lblRabattPreis = new JLabel("");
		lblRabattPreis.setBounds(297, 108, 125, 30);
		panelArtikel.add(lblRabattPreis);
		
		JButton btnZumArtikel = new JButton("Zum Artikel");
		btnZumArtikel.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnZumArtikel.setBackground(Color.WHITE);
		btnZumArtikel.setBounds(186, 147, 139, 30);
		btnZumArtikel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			GUI.getFenster().changePanel(GUIArtikel.getGUIArtikel(artikelNummer));
			}
		});
		panelArtikel.add(btnZumArtikel);
		
		lblZusatz = new JLabel(ladeZusatz(artikelNummer));
		lblZusatz.setForeground(Color.BLACK);
		lblZusatz.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblZusatz.setBounds(186, 67, 213, 30);
		panelArtikel.add(lblZusatz);
		
		JLabel lblHersteller = new JLabel(Artikelsammlung.getArtikel(artikelNummer).getHersteller());
		lblHersteller.setFont(new Font("Lucida Bright", Font.BOLD, 14));
		lblHersteller.setBounds(186, 36, 213, 30);
		panelArtikel.add(lblHersteller);
		
		
		ladeRabattPreis(artikelNummer);
		return panelArtikel;
		
	}	
	

}
