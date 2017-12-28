package Frontend;

import javax.swing.JPanel;
import Artikelverwaltung.Artikel;
import Artikelverwaltung.Artikelsammlung;
import Warenkorbverwaltung.Warenkorb;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 * @author maoro
 *
 */
public class GUIWarenkorbArtikel extends JPanel implements ActionListener {
	
	JButton btnDelete;
	int ArtNr;
	double Einzelpreis;
	JLabel lblGesamtpreis;
	String Gesamtpreis;
	String EinzelpreisString;
	
	public GUIWarenkorbArtikel(int Artikelnummer, int Anzahl) {
		Artikel a = Artikelsammlung.getArtikel(Artikelnummer);
		ArtNr = Artikelnummer;
		
		Einzelpreis = a.getPreis() * (100 - a.getRabatt()) * 0.01;
		EinzelpreisString = String.format("%.2f", Einzelpreis);
		//Gesamtpreis = String.format("%.2f",Einzelpreis * (int) spinnerAnzahl.getValue() );
		Gesamtpreis = String.format("%.2f",Einzelpreis * Warenkorb.getWarenkorb().get(Artikelnummer).intValue() );
		
		setLayout(null);
		setBorder(null);
		setBackground(new Color(204, 255, 255));
		//setBounds(0, 0, 680, 99);
		setSize(new Dimension(680, 100));
		
		JSpinner spinnerAnzahl = new JSpinner();
		spinnerAnzahl.setFont(new Font("Calibri", Font.PLAIN, 13));
		spinnerAnzahl.setBounds(372, 33, 71, 35);
		spinnerAnzahl.setValue(Anzahl);
		add(spinnerAnzahl);
		
		ImageIcon icon = new ImageIcon("src\\SWP-Bilder\\Damenkleidung_4.jpg");
        Image img = icon.getImage().getScaledInstance(93, 93, Image.SCALE_SMOOTH);
		
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
		
		JLabel lblEInzelpreis = new JLabel(EinzelpreisString + "€");	//Rabatt einberechnen
		lblEInzelpreis.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblEInzelpreis.setBounds(453, 40, 80, 20);
		add(lblEInzelpreis);
		
		JLabel lblVerfügbarkeit = new JLabel(a.getVerfügbarkeit());
		lblVerfügbarkeit.setForeground(new Color(0, 204, 51));
		lblVerfügbarkeit.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblVerfügbarkeit.setBounds(116, 64, 213, 30);
		add(lblVerfügbarkeit);
		
		lblGesamtpreis = new JLabel(Gesamtpreis + "€");  //noch zu fixen
		lblGesamtpreis.setFont(new Font("Calibri", Font.BOLD, 14));
		lblGesamtpreis.setBounds(515, 40, 80, 20);
		add(lblGesamtpreis);
		
		JLabel lblHersteller = new JLabel(a.getHersteller());
		lblHersteller.setBounds(116, 39, 213, 14);
		add(lblHersteller);
		
		JButton btnZumArtikel = new JButton("Zum Artikel");
		btnZumArtikel.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnZumArtikel.setBackground(Color.WHITE);
		btnZumArtikel.setBounds(339, 67, 103, 29);
		add(btnZumArtikel);
		
		btnDelete = new JButton();		
		btnDelete.addActionListener(this);
		btnDelete.setOpaque(false);
		btnDelete.setBorder(null);
		btnDelete.setIcon(new ImageIcon("src\\Icons 32x32\\trash.png"));
		btnDelete.setBorder(BorderFactory.createEmptyBorder());
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBounds(605, 28, 44, 44);
		add(btnDelete);
		
		spinnerAnzahl.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				Warenkorb.AnzahlÄndern(Artikelnummer, (int) spinnerAnzahl.getValue());
				Gesamtpreis = String.format("%.2f",Einzelpreis * Warenkorb.getWarenkorb().get(Artikelnummer).intValue() );
				updatePreisLabel();
				GUIWarenkorb.updateGesamtpreis();
			}
		});
		
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnDelete) {
			Warenkorb.ArtikelEntfernen(Artikelsammlung.getArtikel(ArtNr).getArtikelnummer());
			GUIWarenkorb.getPanel().removeAll();
			GUIWarenkorb.BuildPanel();
			GUIWarenkorb.updateGesamtpreis();
		}
		
	}
	public void updatePreisLabel() {
		lblGesamtpreis.setText(Gesamtpreis +"€");
	}

}
