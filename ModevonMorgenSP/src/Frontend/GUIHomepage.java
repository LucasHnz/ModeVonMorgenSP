package Frontend;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import Artikelverwaltung.Artikel;
import Artikelverwaltung.Artikelsammlung;

public class GUIHomepage {

	private static JPanel panelMain;
	public static JButton btnProduktDamenLinks = new JButton();
	public static JButton btnProduktDamenRechts = new JButton();
	public static JButton btnProduktHerrenLinks = new JButton();
	public static JButton btnProduktHerrenRechts = new JButton();
	public static JButton btnProduktDamen;
	public static JButton btnProduktHerren;
	public static JLabel labelMainDamen;
	public static JLabel labelMainHerren;
	static int p = 0;
	static int q = 0;
	static int artNr1;
	static int artNr2;
	static int artNr3;
	static int artNr4;
	static Image img;
	static Image img1;
	static Image img2;
	static Image img3;
	static Image img4;

	/**
	 * Setzt den Z�hler zur�ck, der dabei hilft die Artikel auf der Homepage(Startseite) auseinander zu halten         
	 */
	public static void zur�cksetzenArtikel() {
		p = 0;
		q = 0;
	}
	
	/**
	 * Wechselt den angezeigten Artikel auf der Startseite  
	 */
	public static void wechselOutfitDamenRechts() {
		p++;
		if (p > 1)
			p = 1;
		labelMainDamen.setIcon(new ImageIcon(img3));

	}
	
	/**
	 * Wechselt den angezeigten Artikel auf der Startseite  
	 */
	public static void wechselOutfitDamenLinks() {
		p--;
		if (p < 0)
			p = 0;
		labelMainDamen.setIcon(new ImageIcon(img1));

	}
	
	/**
	 * Wechselt den angezeigten Artikel auf der Startseite  
	 */
	public static void wechselOutfitHerrenRechts() {
		q++;
		if (q > 1)
			q = 1;
		labelMainHerren.setIcon(new ImageIcon(img4));
	}
	
	/**
	 * Wechselt den angezeigten Artikel auf der Startseite  
	 */
	public static void wechselOutfitHerrenLinks() {
		q--;
		if (q < 0)
			q = 0;
		labelMainHerren.setIcon(new ImageIcon(img2));
	}
	
	/**
	 * Errechnet vier Zufallszahlen und zieht mit diesen zuf�llige Artikel aus der Artikelsammlung, die dann 
	 * auf der Startseite angezeigt werden 
	 */
	public static void f�lleArtikelStartseite() {

		HashMap<Integer, Artikel> liste = Artikelsammlung.getArtikelsammlung();
		Set<Integer> intArray = liste.keySet();
		ArrayList<Integer> ausgew�hlteArtikel = new ArrayList<Integer>();
		int artNr = 0;
		int x = 0;

		do {

			int random1 = (int) (Math.random() * 2) + 5;
			int random2 = (int) (Math.random() * 9) + 1;
			artNr = Integer.parseInt(String
					.valueOf(random1 + "" + 0 + "" + 0 + "" + 0 + "" + 0 + "" + 0 + "" + 0 + "" + 0 + "" + random2));

			if (intArray.contains(artNr) && !ausgew�hlteArtikel.contains(artNr)) {

				ausgew�hlteArtikel.add(artNr);
			}

		} while (ausgew�hlteArtikel.size() < 4);

		for (int i = 0; i < 4; i++) {
			ImageIcon icon;

			if (Artikelsammlung.getArtikel(ausgew�hlteArtikel.get(i)).getImage() != null) {
				icon = new ImageIcon(Artikelsammlung.getArtikel(ausgew�hlteArtikel.get(i)).getImage());
				img = icon.getImage().getScaledInstance(380, 450, Image.SCALE_SMOOTH);

			}
			if (Artikelsammlung.getArtikel(ausgew�hlteArtikel.get(i)).getImage() == null) {
				icon = new ImageIcon("src/SWP-Bilder/NoPic.gif");
				img = icon.getImage().getScaledInstance(380, 450, Image.SCALE_SMOOTH);

			}

			if (i == 0) {
				artNr1 = ausgew�hlteArtikel.get(i);
				img1 = img;

			}
			if (i == 1) {
				artNr2 = ausgew�hlteArtikel.get(i);
				img2 = img;

			}
			if (i == 2) {
				artNr3 = ausgew�hlteArtikel.get(i);
				img3 = img;

			}
			if (i == 3) {
				artNr4 = ausgew�hlteArtikel.get(i);
				img4 = img;

			}

		}

	}

	/**
	 * Erzeugt und liefert Startseite 
	 * @return panelMain Frame mit der Startseite
	 */
	public static JPanel getHomepage() {
		panelMain = new JPanel();
		panelMain.setBackground(Color.WHITE);
		panelMain.setBounds(0, 0, 1248, 563);
		panelMain.setLayout(null);

		btnProduktDamen = new JButton("Zum Produkt");
		btnProduktDamen.setFont(new Font("Dialog", Font.BOLD, 15));
		btnProduktDamen.setBackground(Color.WHITE);
		btnProduktDamen.setForeground(Color.BLACK);
		btnProduktDamen.setBounds(249, 458, 165, 35);
		btnProduktDamen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (p == 0) {
					GUI.getFenster().changePanel(GUIArtikel.getGUIArtikel(artNr1));
				}
				if (p == 1) {
					GUI.getFenster().changePanel(GUIArtikel.getGUIArtikel(artNr3));
				}

			}

		});
		panelMain.add(btnProduktDamen);

		btnProduktHerren = new JButton("Zum Produkt");
		btnProduktHerren.setBackground(Color.WHITE);
		btnProduktHerren.setFont(new Font("Dialog", Font.BOLD, 15));
		btnProduktHerren.setBounds(774, 458, 165, 35);
		btnProduktHerren.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (q == 0) {
					GUI.getFenster().changePanel(GUIArtikel.getGUIArtikel(artNr2));
				}
				if (q == 1) {
					GUI.getFenster().changePanel(GUIArtikel.getGUIArtikel(artNr4));
				}

			}

		});
		panelMain.add(btnProduktHerren);

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
		panelMain.add(btnProduktDamenRechts);

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
		panelMain.add(btnProduktDamenLinks);

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
		panelMain.add(btnProduktHerrenRechts);

		btnProduktHerrenLinks = new JButton(new ImageIcon(leftArrow));
		btnProduktHerrenLinks.setBackground(Color.WHITE);
		btnProduktHerrenLinks.setContentAreaFilled(false);
		btnProduktHerrenLinks.setBounds(612, 260, 32, 32);
		btnProduktHerrenLinks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				wechselOutfitHerrenLinks();

			}

		});
		panelMain.add(btnProduktHerrenLinks);

		labelMainDamen = new JLabel();
		labelMainDamen.setBackground(Color.WHITE);
		labelMainDamen.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, Color.LIGHT_GRAY, null));
		labelMainDamen.setHorizontalAlignment(SwingConstants.CENTER);
		labelMainDamen.setVerticalAlignment(SwingConstants.TOP);
		labelMainDamen.setBounds(144, 76, 380, 450);
		labelMainDamen.setIcon(new ImageIcon(img1));
		panelMain.add(labelMainDamen);

		labelMainHerren = new JLabel("");
		labelMainHerren.setBackground(Color.WHITE);
		labelMainHerren.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, Color.LIGHT_GRAY, null));
		labelMainHerren.setHorizontalAlignment(SwingConstants.CENTER);
		labelMainHerren.setBounds(656, 76, 380, 450);
		labelMainHerren.setIcon(new ImageIcon(img2));
		panelMain.add(labelMainHerren);

		return panelMain;
	}

}
