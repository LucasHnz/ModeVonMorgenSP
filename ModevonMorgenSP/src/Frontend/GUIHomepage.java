package Frontend;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
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
/**
 * 
 * @author Hinz

 *
 */
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
	static JLabel lblLinks;
	static JLabel lblRechts;

	/**
	 * Setzt den Zähler zurück, der dabei hilft die Artikel auf der Homepage(Startseite) auseinander zu halten         
	 */
	public static void zurücksetzenArtikel() {
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
		lblLinks.setText(Artikelsammlung.getArtikel(artNr3).getBezeichnung());

	}
	
	/**
	 * Wechselt den angezeigten Artikel auf der Startseite  
	 */
	public static void wechselOutfitDamenLinks() {
		p--;
		if (p < 0)
			p = 0;
		labelMainDamen.setIcon(new ImageIcon(img1));
		lblLinks.setText(Artikelsammlung.getArtikel(artNr1).getBezeichnung());

	}
	
	/**
	 * Wechselt den angezeigten Artikel auf der Startseite  
	 */
	public static void wechselOutfitHerrenRechts() {
		q++;
		if (q > 1)
			q = 1;
		labelMainHerren.setIcon(new ImageIcon(img4));
		lblRechts.setText(Artikelsammlung.getArtikel(artNr4).getBezeichnung());
	}
	
	/**
	 * Wechselt den angezeigten Artikel auf der Startseite  
	 */
	public static void wechselOutfitHerrenLinks() {
		q--;
		if (q < 0)
			q = 0;
		labelMainHerren.setIcon(new ImageIcon(img2));
		lblRechts.setText(Artikelsammlung.getArtikel(artNr2).getBezeichnung());
	}
	
	/**
	 * Errechnet vier Zufallszahlen und zieht mit diesen zufällige Artikel aus der Artikelsammlung, die dann 
	 * auf der Startseite angezeigt werden 
	 */
	public static void fülleArtikelStartseite() {

		HashMap<Integer, Artikel> liste = Artikelsammlung.getArtikelsammlung();
		Set<Integer> intArray = liste.keySet();
		ArrayList<Integer> ausgewählteArtikel = new ArrayList<Integer>();
		int artNr = 0;

		do {

			int random1 = (int) (Math.random() * 2) + 5;
			int random2 = (int) (Math.random() * 9) + 1;
			artNr = Integer.parseInt(String
					.valueOf(random1 + "" + 0 + "" + 0 + "" + 0 + "" + 0 + "" + 0 + "" + 0 + "" + 0 + "" + random2));

			if (intArray.contains(artNr) && !ausgewählteArtikel.contains(artNr)) {

				ausgewählteArtikel.add(artNr);
			}

		} while (ausgewählteArtikel.size() < 4);

		for (int i = 0; i < 4; i++) {
			ImageIcon icon;

			if (Artikelsammlung.getArtikel(ausgewählteArtikel.get(i)).getImage() != null) {
				icon = new ImageIcon(Artikelsammlung.getArtikel(ausgewählteArtikel.get(i)).getImage());
				img = icon.getImage().getScaledInstance(430, 430, Image.SCALE_SMOOTH);

			}
			if (Artikelsammlung.getArtikel(ausgewählteArtikel.get(i)).getImage() == null) {
				icon = new ImageIcon("src/SWP-Bilder/NoPic.gif");
				img = icon.getImage().getScaledInstance(430, 430, Image.SCALE_SMOOTH);

			}

			if (i == 0) {
				artNr1 = ausgewählteArtikel.get(i);
				img1 = img;

			}
			if (i == 1) {
				artNr2 = ausgewählteArtikel.get(i);
				img2 = img;

			}
			if (i == 2) {
				artNr3 = ausgewählteArtikel.get(i);
				img3 = img;

			}
			if (i == 3) {
				artNr4 = ausgewählteArtikel.get(i);
				img4 = img;

			}

		}

	}

	/**
	 * Erzeugt und liefert Startseite 
	 * @return panelMain Frame mit der Startseite
	 * @wbp.parser.entryPoint
	 */
	public static JPanel getHomepage() {
		fülleArtikelStartseite();
		panelMain = new JPanel();
		panelMain.setBackground(Color.WHITE);
		panelMain.setBounds(0, 0, 1248, 563);
		panelMain.setLayout(null);

		btnProduktDamen = new JButton("Zum Produkt");
		btnProduktDamen.setFont(new Font("Dialog", Font.BOLD, 15));
		btnProduktDamen.setBackground(Color.WHITE);
		btnProduktDamen.setForeground(Color.BLACK);
		btnProduktDamen.setBounds(256, 517, 165, 35);
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
		btnProduktHerren.setBounds(825, 517, 165, 35);
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

		URL leftUrl = GUI.class.getResource(
                "/Icons 32x32/back.png");
		URL rightUrl = GUI.class.getResource(
                "/Icons 32x32/next.png");
		Image leftArrow = new ImageIcon(leftUrl).getImage();
		Image rightArrow = new ImageIcon(rightUrl).getImage();

		btnProduktDamenRechts = new JButton(new ImageIcon(rightArrow));
		btnProduktDamenRechts.setContentAreaFilled(false);
		btnProduktDamenRechts.setBackground(Color.WHITE);
		btnProduktDamenRechts.setBounds(567, 230, 32, 32);
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
		btnProduktDamenLinks.setBounds(95, 230, 32, 32);
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
		btnProduktHerrenRechts.setBounds(1131, 230, 32, 32);
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
		btnProduktHerrenLinks.setBounds(647, 230, 32, 32);
		btnProduktHerrenLinks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				wechselOutfitHerrenLinks();

			}

		});
		panelMain.add(btnProduktHerrenLinks);

		labelMainDamen = new JLabel();
		labelMainDamen.setBackground(Color.WHITE);
		labelMainDamen.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, Color.GRAY, null));
		labelMainDamen.setHorizontalAlignment(SwingConstants.CENTER);
		labelMainDamen.setVerticalAlignment(SwingConstants.TOP);
		labelMainDamen.setBounds(125, 30, 430, 430);
		labelMainDamen.setIcon(new ImageIcon(img1));
		panelMain.add(labelMainDamen);

		labelMainHerren = new JLabel("");
		labelMainHerren.setBackground(Color.WHITE);
		labelMainHerren.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, Color.GRAY, null));
		labelMainHerren.setHorizontalAlignment(SwingConstants.CENTER);
		labelMainHerren.setBounds(691, 30, 430, 430);
		labelMainHerren.setIcon(new ImageIcon(img2));
		panelMain.add(labelMainHerren);
		
		lblLinks = new JLabel();
		lblLinks.setFont(new Font("Dialog", Font.BOLD, 18));
		lblLinks.setHorizontalAlignment(SwingConstants.CENTER);
		lblLinks.setBounds(135, 471, 409, 35);
		lblLinks.setText(Artikelsammlung.getArtikel(artNr1).getBezeichnung());
		panelMain.add(lblLinks);
		
		lblRechts = new JLabel();
		lblRechts.setFont(new Font("Dialog", Font.BOLD, 18));
		lblRechts.setHorizontalAlignment(SwingConstants.CENTER);
		lblRechts.setBounds(701, 471, 409, 35);
		lblRechts.setText(Artikelsammlung.getArtikel(artNr2).getBezeichnung());
		panelMain.add(lblRechts);

		return panelMain;
	}
}
