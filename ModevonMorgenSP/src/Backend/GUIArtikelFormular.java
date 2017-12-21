package Backend;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import Artikelverwaltung.Accessoires;
import Artikelverwaltung.ArtikelStrg;
import Artikelverwaltung.Artikelsammlung;
import Artikelverwaltung.Kleidung;
import Artikelverwaltung.Schuhe;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
/**
 * 
 * @author fmaoro
 *
 */
public class GUIArtikelFormular extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldArtikelnummer;
	private JTextField textFieldBezeichnung;
	private JTextField textFieldArt;
	private JLabel lblGeschlecht;
	private JLabel lblHersteller;
	private JLabel lblVerfgbarkeit;
	private JTextField textFieldHersteller;
	private JTextField textFieldRabatt;
	private JLabel lblBestand;
	private JLabel lblLieferanten;
	private JLabel lblPreis;
	private JLabel lblRabatt;
	private JTextField textFieldPreis;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel label;
	private JLabel label_1;
	private JTextField textField_5;
	private JScrollPane scrollPane;
	private String titel, Kategorie;
	private String[] verf�gbarkeiten = {"Sofort lieferbar", "Lieferbar in 1-3 Tagen", "Lieferbar in 1-3 Wochen", "Nicht mehr Verf�gbar"};
	private String[] gr��en = {"XS", "S", "M", "L", "XL", "XXL"};
	private JComboBox<String> comboBoxVerf�gbarkeit;
	private JComboBox<String> comboBoxGr��e;
	

	public static void main(String[] args) {

		ArtikelStrg.F�lleArtikelsammlung();
		System.out.println(Artikelsammlung.getArtikel(600000010).getClass().getName());
		new GUIArtikelFormular(600000010);
	
	}
	/**
	 * �fnnet das Formular zum erstellen eines neuen Artikels.
	 * @param kateg
	 */
	public GUIArtikelFormular(String kateg) {
		Kategorie = kateg;
		if(kateg == "Schuhe")
			titel= "Neuer Schuh";
		else if(kateg == "Accessoires")
			titel= "Neues Accesoir";
		else if(kateg == "Kleidung")
			titel= "Neuer Kleidungsartikel";
		setResizable(false);
		setAlwaysOnTop(true);
		setType(Type.NORMAL);
		setTitle(titel);
		setBounds(100, 100, 327, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		NumberFormat preisformat = NumberFormat.getNumberInstance(); 
        preisformat.setGroupingUsed(false); 
        preisformat.setMaximumIntegerDigits(6);
        preisformat.setMinimumIntegerDigits(1);
        preisformat.setMaximumFractionDigits(2);
        preisformat.setMinimumFractionDigits(2);
        NumberFormatter preisformatter = new NumberFormatter(preisformat); 

        NumberFormat rabattformat = NumberFormat.getNumberInstance(); 
        rabattformat.setGroupingUsed(false); 
        rabattformat.setMaximumIntegerDigits(2);
        rabattformat.setMinimumIntegerDigits(0);
        NumberFormatter rabattformatter = new NumberFormatter(rabattformat); 
        
        NumberFormat schuhformat = NumberFormat.getIntegerInstance();
        schuhformat.setGroupingUsed(false);
        schuhformat.setMaximumIntegerDigits(2);
        schuhformat.setMinimumIntegerDigits(2);
        NumberFormatter schuhformatter = new NumberFormatter(schuhformat);
		
		JLabel lblArtikelnummer = new JLabel("Artikelnummer");
		lblArtikelnummer.setHorizontalTextPosition(SwingConstants.LEFT);
		lblArtikelnummer.setBounds(5, 15, 90, 14);
		contentPane.add(lblArtikelnummer);
		
		NumberFormat format = NumberFormat.getIntegerInstance(); 
        format.setGroupingUsed(false); 
        format.setMaximumIntegerDigits(9);
        format.setMinimumIntegerDigits(9);
        NumberFormatter formatter = new NumberFormatter(format); 
        formatter.setAllowsInvalid(false); 
		
		textFieldArtikelnummer = new JFormattedTextField(formatter);
		if(kateg == "Schuhe")
			textFieldArtikelnummer.setText(String.valueOf(Datenbankverwaltung.holeN�chsteNummer.n�chsteSchuhNr()));
		else if(kateg == "Accessoires")
			textFieldArtikelnummer.setText(String.valueOf(Datenbankverwaltung.holeN�chsteNummer.n�chsteAccessNr()));
		else if(kateg == "Kleidung")
			textFieldArtikelnummer.setText(String.valueOf(Datenbankverwaltung.holeN�chsteNummer.n�chsteKleidungNr()));
		textFieldArtikelnummer.setToolTipText("Die Artikelnummer muss 9 Stellen haben");
		textFieldArtikelnummer.setBounds(105, 12, 204, 20);
		textFieldArtikelnummer.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldArtikelnummer.setEditable(false);
		contentPane.add(textFieldArtikelnummer);
		textFieldArtikelnummer.setColumns(10);
		
		JLabel lblBezeichnung = new JLabel("Bezeichnung");
		lblBezeichnung.setBounds(5, 55, 86, 14);
		contentPane.add(lblBezeichnung);
		
		textFieldBezeichnung = new JTextField();
		textFieldBezeichnung.setToolTipText("Name des Artikels");
		textFieldBezeichnung.setBounds(105, 52, 204, 20);
		contentPane.add(textFieldBezeichnung);
		textFieldBezeichnung.setColumns(10);
		
		JLabel lblArt = new JLabel("Art");
		lblArt.setBounds(5, 95, 86, 14);
		contentPane.add(lblArt);
		
		textFieldArt = new JTextField();
		textFieldArt.setToolTipText("Unterkategorie wie z.B. Laufschuhe, Sneaker, etc.");
		textFieldArt.setBounds(105, 92, 204, 20);
		contentPane.add(textFieldArt);
		textFieldArt.setColumns(10);
		
		lblHersteller = new JLabel("Hersteller");
		lblHersteller.setBounds(5, 135, 86, 14);
		contentPane.add(lblHersteller);
		
		textFieldHersteller = new JTextField();
		textFieldHersteller.setToolTipText("Die Marke des Artikels");
		textFieldHersteller.setBounds(105, 132, 204, 20);
		contentPane.add(textFieldHersteller);
		textFieldHersteller.setColumns(10);
		
		lblVerfgbarkeit = new JLabel("Verf\u00FCgbarkeit");
		lblVerfgbarkeit.setBounds(5, 285, 90, 14);
		contentPane.add(lblVerfgbarkeit);
		
		lblBestand = new JLabel("Bestand");
		lblBestand.setBounds(5, 325, 86, 14);
		contentPane.add(lblBestand);
		
		lblLieferanten = new JLabel("Lieferanten");
		lblLieferanten.setBounds(5, 175, 86, 14);
		contentPane.add(lblLieferanten);
		
		lblPreis = new JLabel("Preis");
		lblPreis.setBounds(5, 365, 86, 14);
		contentPane.add(lblPreis);
		
		lblRabatt = new JLabel("Rabatt");
		lblRabatt.setBounds(5, 405, 86, 14);
		contentPane.add(lblRabatt);
		
		textFieldRabatt = new JFormattedTextField(rabattformatter);
		textFieldRabatt.setBounds(105, 402, 86, 20);
		textFieldRabatt.setToolTipText("Prozentualer Wert, der von dem Preis abgezogen wird");
		contentPane.add(textFieldRabatt);
		textFieldRabatt.setColumns(10);
		
		lblGeschlecht = new JLabel("Geschlecht");
		lblGeschlecht.setBounds(5, 445, 90, 14);
		contentPane.add(lblGeschlecht);
		
		final JRadioButton rdbtnWeiblich = new JRadioButton("Weiblich");
		buttonGroup.add(rdbtnWeiblich);
		rdbtnWeiblich.setBounds(219, 441, 90, 23);
		contentPane.add(rdbtnWeiblich);
		
		final JRadioButton rdbtnMnnlich = new JRadioButton("M\u00E4nnlich");
		buttonGroup.add(rdbtnMnnlich);
		rdbtnMnnlich.setBounds(105, 441, 90, 23);
		contentPane.add(rdbtnMnnlich);
		
		
        preisformatter.setAllowsInvalid(false); 
		textFieldPreis = new JFormattedTextField(preisformatter);
		textFieldPreis.setBounds(105, 362, 86, 20);
		contentPane.add(textFieldPreis);
		textFieldPreis.setColumns(10);
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnAbbrechen.setBounds(105, 471, 90, 40);
		contentPane.add(btnAbbrechen);
				
		label = new JLabel("\u20AC");
		label.setBounds(201, 365, 46, 14);
		contentPane.add(label);
		
		label_1 = new JLabel("%");
		label_1.setBounds(201, 405, 46, 14);
		contentPane.add(label_1);
				
		comboBoxVerf�gbarkeit = new JComboBox<String>(verf�gbarkeiten);
		comboBoxVerf�gbarkeit.setBounds(105, 282, 202, 20);
	    contentPane.add(comboBoxVerf�gbarkeit);
	
		if(kateg == "Accessoires") {
			JLabel lblFarbe = new JLabel("Farbe");
			lblFarbe.setBounds(5, 245, 86, 14);
			contentPane.add(lblFarbe);
		
			textField_5 = new JTextField();
			textField_5.setBounds(105, 242, 204, 20);
			contentPane.add(textField_5);
			textField_5.setColumns(10);
		}
		else if(kateg == "Schuhe") {
			JLabel lblSchuhgr��e = new JLabel("Schuhgr��e");
			lblSchuhgr��e.setBounds(5, 245, 86, 14);
			contentPane.add(lblSchuhgr��e);
		
			textField_5 = new JFormattedTextField(schuhformatter);
			textField_5.setBounds(105, 242, 204, 20);
			contentPane.add(textField_5);
			textField_5.setColumns(10);
		}
		else if(kateg == "Kleidung") {
			JLabel lblGr��e = new JLabel("Gr��e");
			lblGr��e.setBounds(5, 245, 86, 14);
			contentPane.add(lblGr��e);
					
			comboBoxGr��e = new JComboBox<String>(gr��en);
			comboBoxGr��e.setBounds(105, 242, 204, 20);
			contentPane.add(comboBoxGr��e);
		}
		SpinnerModel model = new SpinnerNumberModel(0, 0, 99999, 1);
		final JSpinner spinnerBestand = new JSpinner(model);
		spinnerBestand.setToolTipText("Lagerbestand");
		spinnerBestand.setBounds(105, 322, 86, 30);
		contentPane.add(spinnerBestand);
		
		final JTextArea taLieferanten = new JTextArea();
		taLieferanten.setToolTipText("Hier die Lieferanten eintragen. Alle m�ssen durch ein Komma getrennt sein");
		taLieferanten.setFont(new Font("Tahoma", Font.PLAIN, 11));
		taLieferanten.setLineWrap(true);
		taLieferanten.setWrapStyleWord(true);
		
		scrollPane = new JScrollPane(taLieferanten);
		scrollPane.setBounds(105, 171, 204, 60);
		contentPane.add(scrollPane);
		
		JButton btnBest�tigen = new JButton("Best�tigen");
		btnBest�tigen.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnBest�tigen.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0)  {
				int Artikelnummer = Integer.parseInt(textFieldArtikelnummer.getText());			
				int Bestand = (int) spinnerBestand.getValue();
				String Bezeichnung = textFieldBezeichnung.getText();
				String Art = textFieldArt.getText();
				String Geschlecht;
				if(rdbtnWeiblich.isSelected())
					Geschlecht = "W";
				else 
					Geschlecht = "M";				
				String Hersteller = textFieldHersteller.getText(); 
				String Verf�gbarkeit = (String) comboBoxVerf�gbarkeit.getSelectedItem();
				String Notiz = null;
				String[] Lieferanten = taLieferanten.getText().split(",");
				double Preis = Double.parseDouble(textFieldPreis.getText().replace(',', '.'));
				System.out.println(Preis);
				int Rabatt = 10;
				int Schuhgr��e = 0;
				String Farbe = null;
				String Gr��e = null;
				if(Kategorie == "Schuhe")
					Schuhgr��e = Integer.parseInt(textField_5.getText());
				else if(Kategorie == "Accessoires")
					Farbe = textField_5.getText();
				else if(Kategorie == "Kleidung")
					Gr��e = (String) comboBoxGr��e.getSelectedItem();
				ArtikelStrg.NeuerArtikel(Kategorie, Artikelnummer, Bestand, Bezeichnung, Art, Geschlecht, 
						Hersteller, Verf�gbarkeit, Notiz, Lieferanten, Preis, Rabatt, Schuhgr��e, Farbe,
						Gr��e);
				dispose();
				
		}
			 });
			
		btnBest�tigen.setBounds(219, 472, 90, 40);
		contentPane.add(btnBest�tigen);
		setVisible(true);
	};
	
	
	/**
	 * @wbp.parser.constructor
	 */
	public GUIArtikelFormular(int Artikelnummer) {
		
		setResizable(false);
		setAlwaysOnTop(true);
		setType(Type.NORMAL);
		setTitle("Artikel editieren");
		setBounds(100, 100, 327, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		NumberFormat preisformat = NumberFormat.getNumberInstance(); 
        preisformat.setGroupingUsed(false); 
        preisformat.setMaximumIntegerDigits(6);
        preisformat.setMinimumIntegerDigits(1);
        preisformat.setMaximumFractionDigits(2);
        preisformat.setMinimumFractionDigits(2);
        NumberFormatter preisformatter = new NumberFormatter(preisformat); 

        NumberFormat rabattformat = NumberFormat.getNumberInstance(); 
        rabattformat.setGroupingUsed(false); 
        rabattformat.setMaximumIntegerDigits(2);
        rabattformat.setMinimumIntegerDigits(0);
        NumberFormatter rabattformatter = new NumberFormatter(rabattformat); 
        
        NumberFormat schuhformat = NumberFormat.getIntegerInstance();
        schuhformat.setGroupingUsed(false);
        schuhformat.setMaximumIntegerDigits(2);
        schuhformat.setMinimumIntegerDigits(2);
        NumberFormatter schuhformatter = new NumberFormatter(schuhformat);
		
		JLabel lblArtikelnummer = new JLabel("Artikelnummer");
		lblArtikelnummer.setHorizontalTextPosition(SwingConstants.LEFT);
		lblArtikelnummer.setBounds(5, 15, 90, 14);
		contentPane.add(lblArtikelnummer);
		
		NumberFormat format = NumberFormat.getIntegerInstance(); 
        format.setGroupingUsed(false); 
        format.setMaximumIntegerDigits(9);
        format.setMinimumIntegerDigits(9);
        NumberFormatter formatter = new NumberFormatter(format); 
        formatter.setAllowsInvalid(false); 
		
		textFieldArtikelnummer = new JFormattedTextField(formatter);
		textFieldArtikelnummer.setText(String.valueOf(Artikelnummer));
		textFieldArtikelnummer.setToolTipText("Die Artikelnummer muss 9 Stellen haben");
		textFieldArtikelnummer.setBounds(105, 12, 204, 20);
		textFieldArtikelnummer.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldArtikelnummer.setEditable(false);
		contentPane.add(textFieldArtikelnummer);
		textFieldArtikelnummer.setColumns(10);
		
		JLabel lblBezeichnung = new JLabel("Bezeichnung");
		lblBezeichnung.setBounds(5, 55, 86, 14);
		contentPane.add(lblBezeichnung);
		
		textFieldBezeichnung = new JTextField();
		textFieldBezeichnung.setToolTipText("Name des Artikels");
		textFieldBezeichnung.setBounds(105, 52, 204, 20);
		textFieldBezeichnung.setText(Artikelsammlung.getArtikel(Artikelnummer).getBezeichnung());
		contentPane.add(textFieldBezeichnung);
		textFieldBezeichnung.setColumns(10);
		
		JLabel lblArt = new JLabel("Art");
		lblArt.setBounds(5, 95, 86, 14);
		contentPane.add(lblArt);
		
		textFieldArt = new JTextField();
		textFieldArt.setToolTipText("Unterkategorie wie z.B. Laufschuhe, Sneaker, etc.");
		textFieldArt.setBounds(105, 92, 204, 20);
		textFieldArt.setText(Artikelsammlung.getArtikel(Artikelnummer).getArt());
		contentPane.add(textFieldArt);
		textFieldArt.setColumns(10);
		
		lblHersteller = new JLabel("Hersteller");
		lblHersteller.setBounds(5, 135, 86, 14);
		contentPane.add(lblHersteller);
		
		textFieldHersteller = new JTextField();
		textFieldHersteller.setToolTipText("Die Marke des Artikels");
		textFieldHersteller.setBounds(105, 132, 204, 20);
		textFieldHersteller.setText(Artikelsammlung.getArtikel(Artikelnummer).getHersteller());
		contentPane.add(textFieldHersteller);
		textFieldHersteller.setColumns(10);
		
		lblVerfgbarkeit = new JLabel("Verf\u00FCgbarkeit");
		lblVerfgbarkeit.setBounds(5, 285, 90, 14);
		contentPane.add(lblVerfgbarkeit);
		
		lblBestand = new JLabel("Bestand");
		lblBestand.setBounds(5, 325, 86, 14);
		contentPane.add(lblBestand);
		
		lblLieferanten = new JLabel("Lieferanten");
		lblLieferanten.setBounds(5, 175, 86, 14);
		contentPane.add(lblLieferanten);
		
		lblPreis = new JLabel("Preis");
		lblPreis.setBounds(5, 365, 86, 14);
		contentPane.add(lblPreis);
		
		lblRabatt = new JLabel("Rabatt");
		lblRabatt.setBounds(5, 405, 86, 14);
		contentPane.add(lblRabatt);
		
		textFieldRabatt = new JFormattedTextField(rabattformatter);
		textFieldRabatt.setBounds(105, 402, 86, 20);
		textFieldRabatt.setToolTipText("Prozentualer Wert, der von dem Preis abgezogen wird");
		textFieldRabatt.setText(String.valueOf(Artikelsammlung.getArtikel(Artikelnummer).getRabatt()));
		contentPane.add(textFieldRabatt);
		textFieldRabatt.setColumns(10);
		
		lblGeschlecht = new JLabel("Geschlecht");
		lblGeschlecht.setBounds(5, 445, 90, 14);
		contentPane.add(lblGeschlecht);
		
		final JRadioButton rdbtnWeiblich = new JRadioButton("Weiblich");
		buttonGroup.add(rdbtnWeiblich);
		rdbtnWeiblich.setBounds(219, 441, 90, 23);
		contentPane.add(rdbtnWeiblich);
		
		
		final JRadioButton rdbtnMnnlich = new JRadioButton("M\u00E4nnlich");
		buttonGroup.add(rdbtnMnnlich);
		rdbtnMnnlich.setBounds(105, 441, 90, 23);
		contentPane.add(rdbtnMnnlich);
		
		if(Artikelsammlung.getArtikel(Artikelnummer).getGeschlecht() == "W")
			rdbtnWeiblich.setSelected(true);
		else
			rdbtnMnnlich.setSelected(true);
		
        preisformatter.setAllowsInvalid(false); 
		textFieldPreis = new JFormattedTextField(preisformatter);
		textFieldPreis.setBounds(105, 362, 86, 20);
		textFieldPreis.setText(String.valueOf(Artikelsammlung.getArtikel(Artikelnummer).getPreis()));
		contentPane.add(textFieldPreis);
		textFieldPreis.setColumns(10);
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnAbbrechen.setBounds(105, 471, 90, 40);
		contentPane.add(btnAbbrechen);
				
		label = new JLabel("\u20AC");
		label.setBounds(201, 365, 46, 14);
		contentPane.add(label);
		
		label_1 = new JLabel("%");
		label_1.setBounds(201, 405, 46, 14);
		contentPane.add(label_1);
				
		comboBoxVerf�gbarkeit = new JComboBox<String>(verf�gbarkeiten);
		comboBoxVerf�gbarkeit.setBounds(105, 282, 202, 20);
		comboBoxVerf�gbarkeit.setSelectedItem(Artikelsammlung.getArtikel(Artikelnummer).getVerf�gbarkeit());
	    contentPane.add(comboBoxVerf�gbarkeit);
	    
	    
	    
		if(Artikelsammlung.getArtikel(Artikelnummer).getClass().getName() == "Artikelverwaltung.Accessoires") {
			Accessoires a = (Accessoires) Artikelsammlung.getArtikel(Artikelnummer);
			JLabel lblFarbe = new JLabel("Farbe");
			lblFarbe.setBounds(5, 245, 86, 14);
			contentPane.add(lblFarbe);
		
			textField_5 = new JTextField();
			textField_5.setBounds(105, 242, 204, 20);
			textField_5.setText(a.getFarbe());
			contentPane.add(textField_5);
			textField_5.setColumns(10);
		}
		else if(Artikelsammlung.getArtikel(Artikelnummer).getClass().getName() == "Artikelverwaltung.Schuhe") {
			Schuhe a = (Schuhe)Artikelsammlung.getArtikel(Artikelnummer);
			JLabel lblSchuhgr��e = new JLabel("Schuhgr��e");
			lblSchuhgr��e.setBounds(5, 245, 86, 14);
			contentPane.add(lblSchuhgr��e);
		
			textField_5 = new JFormattedTextField(schuhformatter);
			textField_5.setBounds(105, 242, 204, 20);
			textField_5.setText(String.valueOf(a.getSchuhgr��e()));
			contentPane.add(textField_5);
			textField_5.setColumns(10);
		}
		else if(Artikelsammlung.getArtikel(Artikelnummer).getClass().getName() == "Artikelverwaltung.Kleidung") {
			Kleidung a = (Kleidung) Artikelsammlung.getArtikel(Artikelnummer);
			JLabel lblGr��e = new JLabel("Gr��e");
			lblGr��e.setBounds(5, 245, 86, 14);
			contentPane.add(lblGr��e);
					
			comboBoxGr��e = new JComboBox<String>(gr��en);
			comboBoxGr��e.setBounds(105, 242, 204, 20);
			comboBoxGr��e.setSelectedItem(a.getGr��e());
			contentPane.add(comboBoxGr��e);
		}
		SpinnerModel model = new SpinnerNumberModel(0, 0, 99999, 1);
		final JSpinner spinnerBestand = new JSpinner(model);
		spinnerBestand.setToolTipText("Lagerbestand");
		spinnerBestand.setBounds(105, 322, 86, 30);
		spinnerBestand.setValue(Artikelsammlung.getArtikel(Artikelnummer).getBestand());
		contentPane.add(spinnerBestand);
		
		final JTextArea taLieferanten = new JTextArea();
		taLieferanten.setToolTipText("Hier die Lieferanten eintragen. Alle m�ssen durch ein Komma getrennt sein");
		taLieferanten.setFont(new Font("Tahoma", Font.PLAIN, 11));
		taLieferanten.setLineWrap(true);
		taLieferanten.setWrapStyleWord(true);
		String str = Arrays.toString(Artikelsammlung.getArtikel(Artikelnummer).getLieferanten());
		str = str.replace("[", "");
		str = str.replace("]", "");
		taLieferanten.setText(str);
		
		scrollPane = new JScrollPane(taLieferanten);
		scrollPane.setBounds(105, 171, 204, 60);
		contentPane.add(scrollPane);
		
		JButton btnBest�tigen = new JButton("Best�tigen");
		btnBest�tigen.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnBest�tigen.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0)  {
				int Artikelnummer = Integer.parseInt(textFieldArtikelnummer.getText());			
				int Bestand = (int) spinnerBestand.getValue();
				String Bezeichnung = textFieldBezeichnung.getText();
				String Art = textFieldArt.getText();
				String Geschlecht;
				if(rdbtnWeiblich.isSelected())
					Geschlecht = "W";
				else 
					Geschlecht = "M";				
				String Hersteller = textFieldHersteller.getText(); 
				String Verf�gbarkeit = (String) comboBoxVerf�gbarkeit.getSelectedItem();
				String Notiz = null;
				String[] Lieferanten = taLieferanten.getText().split(",");
				double Preis = Double.parseDouble(textFieldPreis.getText().replace(',', '.'));
				int Rabatt = 10;
				int Schuhgr��e = 0;
				String Farbe = null;
				String Gr��e = null;
				if(Artikelsammlung.getArtikel(Artikelnummer).getClass().getName() == "Artikelverwaltung.Schuhe")
					Schuhgr��e = Integer.parseInt(textField_5.getText());
				else if(Artikelsammlung.getArtikel(Artikelnummer).getClass().getName() == "Artikelverwaltung.Accessoires")
					Farbe = textField_5.getText();
				else if(Artikelsammlung.getArtikel(Artikelnummer).getClass().getName() == "Artikelverwaltung.Kleidung")
					Gr��e = (String) comboBoxGr��e.getSelectedItem();
				ArtikelStrg.EditiereArtikel(Artikelnummer, Bestand, Bezeichnung, Art, Geschlecht, 
						Hersteller, Verf�gbarkeit, Notiz, Lieferanten, Preis, Rabatt, Schuhgr��e, Farbe,
						Gr��e);
				dispose();
				
		}
			 });
			
		btnBest�tigen.setBounds(219, 472, 90, 40);
		contentPane.add(btnBest�tigen);
		setVisible(true);
	}

}
