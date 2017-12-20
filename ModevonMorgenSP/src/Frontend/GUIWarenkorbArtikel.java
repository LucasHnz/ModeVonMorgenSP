package Frontend;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

import Artikelverwaltung.Artikel;
import Artikelverwaltung.Artikelsammlung;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSpinner;

public class GUIWarenkorbArtikel extends JPanel {
	public GUIWarenkorbArtikel(int Artikelnummer, int Anzahl) {
		Artikel a = Artikelsammlung.getArtikel(Artikelnummer);
		
		setLayout(null);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(SystemColor.inactiveCaption);
		//setBounds(0, 0, 680, 99);
		setSize(new Dimension(680, 100));
		
		JSpinner spinnerAnzahl = new JSpinner();
		spinnerAnzahl.setFont(new Font("Calibri", Font.PLAIN, 13));
		spinnerAnzahl.setBounds(398, 37, 45, 26);
		spinnerAnzahl.setValue(Anzahl);
		add(spinnerAnzahl);
		
		ImageIcon icon = new ImageIcon("src\\SWP-Bilder\\Damenkleidung_4.jpg");
        Image img = icon.getImage().getScaledInstance(93, 93, Image.SCALE_FAST);
		
		JLabel lblImage = new JLabel("image");		//new ImageIcon(a.getImage())
		lblImage.setIcon(new ImageIcon(img));
		lblImage.setVerticalAlignment(SwingConstants.TOP);
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(3, 3, 93, 93);
		add(lblImage);
		
		JLabel lblBezeichnung = new JLabel(a.getBezeichnung());
		lblBezeichnung.setFont(new Font("Calibri", Font.BOLD, 15));
		lblBezeichnung.setBounds(116, 9, 213, 19);
		add(lblBezeichnung);
		
		Double Preis = a.getPreis() * (100 - a.getRabatt()) * 0.01;
		String Einzelpreis = String.format("%.2f", Preis);
		JLabel lblEInzelpreis = new JLabel(Einzelpreis + "€");	//Rabatt einberechnen
		lblEInzelpreis.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblEInzelpreis.setBounds(453, 40, 80, 20);
		add(lblEInzelpreis);
		
		JLabel lblVerfügbarkeit = new JLabel(a.getVerfügbarkeit());
		lblVerfügbarkeit.setForeground(new Color(0, 204, 51));
		lblVerfügbarkeit.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblVerfügbarkeit.setBounds(116, 64, 213, 30);
		add(lblVerfügbarkeit);
		
		String Gesamtpreis = String.format("%.2f",Preis * (int) spinnerAnzahl.getValue() );
		JLabel lblGesamtpreis = new JLabel(Gesamtpreis + "€");  //noch zu fixen
		lblGesamtpreis.setFont(new Font("Calibri", Font.BOLD, 14));
		lblGesamtpreis.setBounds(515, 40, 80, 20);
		add(lblGesamtpreis);
		
		JLabel lblHersteller = new JLabel(a.getHersteller());
		lblHersteller.setBounds(116, 39, 213, 14);
		add(lblHersteller);
		
		JButton btnZumArtikel = new JButton("Zum Artikel");
		btnZumArtikel.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnZumArtikel.setBackground(Color.WHITE);
		btnZumArtikel.setBounds(339, 67, 103, 19);
		add(btnZumArtikel);
		
		JButton btnDelete = new JButton("");
		btnDelete.setOpaque(false);
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setBorder(null);
		btnDelete.setBorderPainted(false);
		btnDelete.setIcon(new ImageIcon(GUIWarenkorbArtikel.class.getResource("/Icons/rubbish-bin.png")));
		btnDelete.setBounds(605, 28, 44, 44);
		add(btnDelete);
		
		
		
		setVisible(true);
	}

}
