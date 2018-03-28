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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
/**
 * 
 * @author Falk Maoro
 *
 */
public class GUIWarenkorbArtikel extends JPanel implements ActionListener {
	
	JButton btnDelete;
	JButton btnZumArtikel;
	int ArtNr;
	double Einzelpreis;
	JLabel lblGesamtpreis;
	String Gesamtpreis;
	String EinzelpreisString;
	
	/**
	 * Stellt ein JPanel für einen Artikel im Warenkorb zur Verfügung.
	 * @param Artikelnummer Die Artikelnummer des Artikels.
	 * @param Anzahl Die Anzahl des Artikels im Warenkorb.
	 */
	public GUIWarenkorbArtikel(int Artikelnummer, int Anzahl) {
		Artikel a = Artikelsammlung.getArtikel(Artikelnummer);
		ArtNr = Artikelnummer;
		
		Einzelpreis = a.getPreis() * (100 - a.getRabatt()) * 0.01;
		EinzelpreisString = String.format("%.2f", Einzelpreis);
		Gesamtpreis = String.format("%.2f",Einzelpreis * Warenkorb.getWarenkorb().get(Artikelnummer).intValue() );
		
		setLayout(null);
		setBorder(null);
		setBackground(Color.WHITE);
		setSize(new Dimension(1124, 100));
		
		Integer value = new Integer(1);
		Integer min = new Integer(1);
		Integer max = new Integer(100);
		Integer step = new Integer(1);		
		SpinnerNumberModel model = new SpinnerNumberModel(value, min, max, step);
		JSpinner spinnerAnzahl = new JSpinner(model);
		spinnerAnzahl.setFont(new Font("Dialog", Font.PLAIN, 13));
		spinnerAnzahl.setBounds(606, 33, 71, 35);
		spinnerAnzahl.setValue(Anzahl);
		add(spinnerAnzahl);
		
		ImageIcon icon = new ImageIcon("src/SWP-Bilder/NoPic.gif");		
		if(a.getImage() != null)
			icon = new ImageIcon(a.getImage());	
		else {
			URL imgUrl = GUI.class.getResource(
	                "/SWP-Bilder/NoPic.gif");
			icon = new ImageIcon(imgUrl);
		}	
		Image img = icon.getImage().getScaledInstance(93, 93, Image.SCALE_SMOOTH);
		
		JLabel lblImage = new JLabel();
		lblImage.setIcon(new ImageIcon(img));
		lblImage.setVerticalAlignment(SwingConstants.TOP);
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(3, 3, 93, 93);
		add(lblImage);
		
		JLabel lblBezeichnung = new JLabel(a.getBezeichnung());
		lblBezeichnung.setFont(new Font("Dialog", Font.BOLD, 15));
		lblBezeichnung.setBounds(165, 11, 213, 19);
		add(lblBezeichnung);
		
		JLabel lblEInzelpreis = new JLabel(EinzelpreisString + "€");	
		lblEInzelpreis.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblEInzelpreis.setBounds(687, 40, 80, 20);
		add(lblEInzelpreis);
		
		JLabel lblVerfügbarkeit = new JLabel(a.getVerfügbarkeit());
		String verfügbarkeit = a.getVerfügbarkeit();
		switch(verfügbarkeit) {
			case "Sofort lieferbar": 		lblVerfügbarkeit.setForeground(Color.GREEN);		
											break;
			case "Lieferbar in 1-3 Tagen":	lblVerfügbarkeit.setForeground(Color.BLUE);		
											break;
			case "Lieferbar in 1-3 Wochen": lblVerfügbarkeit.setForeground(Color.BLUE);		
											break;
			case "Nicht mehr Verfügbar":	lblVerfügbarkeit.setForeground(Color.RED);
											break;
		}
		lblVerfügbarkeit.setFont(new Font("Dialog", Font.BOLD, 14));
		lblVerfügbarkeit.setBounds(165, 66, 213, 30);
		add(lblVerfügbarkeit);
		
		lblGesamtpreis = new JLabel(Gesamtpreis + "€");  
		lblGesamtpreis.setFont(new Font("Dialog", Font.BOLD, 14));
		lblGesamtpreis.setBounds(749, 40, 80, 20);
		add(lblGesamtpreis);
		
		JLabel lblHersteller = new JLabel(a.getHersteller());
		lblHersteller.setBounds(165, 41, 213, 14);
		add(lblHersteller);
		
		btnZumArtikel = new JButton("Zum Artikel");
		btnZumArtikel.setFont(new Font("Dialog", Font.BOLD, 13));
		btnZumArtikel.setBackground(Color.WHITE);
		btnZumArtikel.setBounds(573, 67, 103, 29);
		btnZumArtikel.addActionListener(this);
		add(btnZumArtikel);
		
		btnDelete = new JButton();		
		btnDelete.addActionListener(this);
		btnDelete.setOpaque(false);
		btnDelete.setBorder(null);
		URL deleteUrl = GUI.class.getResource(
                "/Icons 64x64/trash.png");
		Image icon2 = new ImageIcon(deleteUrl).getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
		btnDelete.setIcon(new ImageIcon(icon2));
		btnDelete.setBorder(BorderFactory.createEmptyBorder());
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBounds(949, 26, 45, 45);
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
			GUIWarenkorb.clearPanel();
			GUIWarenkorb.BuildPanel();
			GUIWarenkorb.updateGesamtpreis();
		}
		if(e.getSource() == btnZumArtikel)
			GUI.getFenster().changePanel(GUIArtikel.getGUIArtikel(ArtNr));
		
	}
	/**
	 * Akualisiert das Label für den Preis des Artikels multipliziert mit der Anzahl.
	 */
	public void updatePreisLabel() {
		lblGesamtpreis.setText(Gesamtpreis +"€");
	}

}
