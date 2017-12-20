package Frontend;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.ComponentOrientation;

import javax.swing.ScrollPaneConstants;
import java.awt.SystemColor;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.border.LineBorder;
import javax.swing.text.html.HTMLDocument.Iterator;

import Artikelverwaltung.Artikel;
import Artikelverwaltung.ArtikelStrg;
import Artikelverwaltung.Artikelsammlung;
import Warenkorbverwaltung.Warenkorb;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import javax.swing.JSpinner;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;

public class GUIWarenkorb extends JFrame {
	
	public static void main(String[] args) {
		ArtikelStrg.FülleArtikelsammlung();
		Warenkorb.ArtikelHinzufügen(Artikelsammlung.getArtikel(500000001), 3);
		Warenkorb.ArtikelHinzufügen(Artikelsammlung.getArtikel(500000002), 3);
		Warenkorb.ArtikelHinzufügen(Artikelsammlung.getArtikel(500000003), 10);
		new GUIWarenkorb();
	}
	public GUIWarenkorb() {
		setResizable(false);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(0,0,1000,600);
		
		JButton btnZurKasse = new JButton("Zur Kasse");
		btnZurKasse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnZurKasse.setBounds(648, 424, 227, 46);
		getContentPane().add(btnZurKasse);
		
		JPanel panel = new JPanel();
		panel.setAutoscrolls(true);
		panel.setOpaque(false);
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		
		int length = Warenkorb.getWarenkorb().size() * 100;
		panel.setPreferredSize(new Dimension(549, length));
		
		for (Map.Entry<Integer, Integer> entry : Warenkorb.getWarenkorb().entrySet()) {
		    Integer artikelnummer = entry.getKey();
		    Integer anzahl = entry.getValue();
		    panel.add(new GUIWarenkorbArtikel(artikelnummer, anzahl));
		}
				
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(panel);
		scrollPane.setBounds(10, 11, 865, 402);
				
		getContentPane().add(scrollPane);
		
		String Gesamtpreis = String.format("%.2f",Warenkorb.getGesamtpreis());
		JLabel lblGesamtpreis = new JLabel("Gesamtpreis: " +Gesamtpreis + "€");
		lblGesamtpreis.setBackground(Color.WHITE);
		lblGesamtpreis.setFont(new Font("Calibri", Font.BOLD, 18));
		lblGesamtpreis.setBounds(415, 423, 223, 46);
		getContentPane().add(lblGesamtpreis);
		setVisible(true);
	}
}
