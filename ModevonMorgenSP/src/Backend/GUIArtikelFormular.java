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
 * @author Falk Maoro
 *
 */
public class GUIArtikelFormular extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFArtikelnummer;
	private JTextField txtFBezeichnung;
	private JTextField txtFArt;
	private JLabel lblGeschlecht;
	private JLabel lblHersteller;
	private JLabel lblVerfgbarkeit;
	private JTextField txtFHersteller;
	private JTextField txtFRabatt;
	private JLabel lblBestand;
	private JLabel lblLieferanten;
	private JLabel lblPreis;
	private JLabel lblRabatt;
	private JTextField txtFPreis;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblEuro;
	private JLabel lblProzent;
	private JTextField txtFVar;
	private JScrollPane scrollPane;
	private String titel, Kategorie;
	private String[] verf�gbarkeiten = {"Sofort lieferbar", "Lieferbar in 1-3 Tagen", "Lieferbar in 1-3 Wochen", "Nicht mehr Verf�gbar"};
	private String[] gr��en = {"XS", "S", "M", "L", "XL", "XXL"};
	private JComboBox<String> comboBoxVerf�gbarkeit;
	private JComboBox<String> comboBoxGr��e;
	
	/**
	 * �fnnet das Formular zum erstellen eines neuen Artikels.
	 * @param kateg Kategorie. Also Schuhe, Kleidung oder Accessoires.
	 * @see Artikelverwaltung.Artikel
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
		
		txtFArtikelnummer = new JFormattedTextField(formatter);
		if(kateg == "Schuhe")
			txtFArtikelnummer.setText(String.valueOf(Datenbankverwaltung.holeN�chsteNummer.n�chsteSchuhNr()));
		else if(kateg == "Accessoires")
			txtFArtikelnummer.setText(String.valueOf(Datenbankverwaltung.holeN�chsteNummer.n�chsteAccessNr()));
		else if(kateg == "Kleidung")
			txtFArtikelnummer.setText(String.valueOf(Datenbankverwaltung.holeN�chsteNummer.n�chsteKleidungNr()));
		txtFArtikelnummer.setToolTipText("Die Artikelnummer muss 9 Stellen haben");
		txtFArtikelnummer.setBounds(105, 12, 204, 30);
		txtFArtikelnummer.setHorizontalAlignment(SwingConstants.RIGHT);
		txtFArtikelnummer.setEditable(false);
		contentPane.add(txtFArtikelnummer);
		txtFArtikelnummer.setColumns(10);
		
		JLabel lblBezeichnung = new JLabel("Bezeichnung");
		lblBezeichnung.setBounds(5, 55, 86, 14);
		contentPane.add(lblBezeichnung);
		
		txtFBezeichnung = new JTextField();
		txtFBezeichnung.setToolTipText("Name des Artikels");
		txtFBezeichnung.setBounds(105, 52, 204, 30);
		txtFBezeichnung.setDocument(new TextDoc(26));
		contentPane.add(txtFBezeichnung);
		txtFBezeichnung.setColumns(10);
		
		JLabel lblArt = new JLabel("Art");
		lblArt.setBounds(5, 91, 86, 22);
		contentPane.add(lblArt);
		
		txtFArt = new JTextField();
		txtFArt.setToolTipText("Unterkategorie wie z.B. Laufschuhe, Sneaker, etc.");
		txtFArt.setBounds(105, 90, 204, 25);
		txtFArt.setDocument(new TextDoc(21));
		contentPane.add(txtFArt);
		txtFArt.setColumns(10);
		
		lblHersteller = new JLabel("Hersteller");
		lblHersteller.setBounds(5, 131, 86, 22);
		contentPane.add(lblHersteller);
		
		txtFHersteller = new JTextField();
		txtFHersteller.setToolTipText("Die Marke des Artikels");
		txtFHersteller.setBounds(105, 130, 204, 25);
		txtFHersteller.setDocument(new TextDoc(26));
		contentPane.add(txtFHersteller);
		txtFHersteller.setColumns(10);
		
		lblVerfgbarkeit = new JLabel("Verf\u00FCgbarkeit");
		lblVerfgbarkeit.setBounds(5, 281, 90, 22);
		contentPane.add(lblVerfgbarkeit);
		
		lblBestand = new JLabel("Bestand");
		lblBestand.setBounds(5, 321, 86, 22);
		contentPane.add(lblBestand);
		
		lblLieferanten = new JLabel("Lieferanten");
		lblLieferanten.setBounds(5, 170, 86, 22);
		contentPane.add(lblLieferanten);
		
		lblPreis = new JLabel("Preis");
		lblPreis.setBounds(5, 361, 86, 22);
		contentPane.add(lblPreis);
		
		lblRabatt = new JLabel("Rabatt");
		lblRabatt.setBounds(5, 403, 86, 22);
		contentPane.add(lblRabatt);
		
		txtFRabatt = new JFormattedTextField(rabattformatter);
		txtFRabatt.setBounds(105, 400, 86, 25);
		txtFRabatt.setToolTipText("Prozentualer Wert, der von dem Preis abgezogen wird");
		contentPane.add(txtFRabatt);
		txtFRabatt.setColumns(10);
		
		lblGeschlecht = new JLabel("Geschlecht");
		lblGeschlecht.setBounds(5, 443, 90, 22);
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
		txtFPreis = new JFormattedTextField(preisformatter);
		txtFPreis.setBounds(105, 360, 86, 25);
		contentPane.add(txtFPreis);
		txtFPreis.setColumns(10);
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnAbbrechen.setBounds(105, 471, 90, 40);
		contentPane.add(btnAbbrechen);
				
		lblEuro = new JLabel("\u20AC");
		lblEuro.setBounds(201, 365, 46, 14);
		contentPane.add(lblEuro);
		
		lblProzent = new JLabel("%");
		lblProzent.setBounds(201, 405, 46, 14);
		contentPane.add(lblProzent);
				
		comboBoxVerf�gbarkeit = new JComboBox<String>(verf�gbarkeiten);
		comboBoxVerf�gbarkeit.setBounds(105, 280, 204, 25);
	    contentPane.add(comboBoxVerf�gbarkeit);
	
		if(kateg == "Accessoires") {
			JLabel lblFarbe = new JLabel("Farbe");
			lblFarbe.setBounds(5, 245, 86, 22);
			contentPane.add(lblFarbe);
		
			txtFVar = new JTextField();
			txtFVar.setBounds(105, 242, 204, 25);	//105, 171, 204, 60
			contentPane.add(txtFVar);
			txtFVar.setDocument(new TextDoc(16));
			txtFVar.setColumns(10);
		}
		else if(kateg == "Schuhe") {
			JLabel lblSchuhgr��e = new JLabel("Schuhgr��e");
			lblSchuhgr��e.setBounds(5, 245, 86, 22);
			contentPane.add(lblSchuhgr��e);
		
			txtFVar = new JFormattedTextField(schuhformatter);
			txtFVar.setBounds(105, 242, 204, 25);
			contentPane.add(txtFVar);
			txtFVar.setColumns(10);
		}
		else if(kateg == "Kleidung") {
			JLabel lblGr��e = new JLabel("Gr��e");
			lblGr��e.setBounds(5, 245, 86, 22);
			contentPane.add(lblGr��e);
					
			comboBoxGr��e = new JComboBox<String>(gr��en);
			comboBoxGr��e.setBounds(105, 242, 204, 25);
			contentPane.add(comboBoxGr��e);
		}
		SpinnerModel model = new SpinnerNumberModel(0, 0, 99999, 1);
		final JSpinner spinnerBestand = new JSpinner(model);
		spinnerBestand.setToolTipText("Lagerbestand");
		spinnerBestand.setBounds(100, 322, 95, 30);
		contentPane.add(spinnerBestand);
		
		final JTextArea taLieferanten = new JTextArea();
		taLieferanten.setToolTipText("Hier die Lieferanten eintragen. Alle m�ssen durch ein Komma getrennt sein");
		taLieferanten.setFont(new Font("Tahoma", Font.PLAIN, 11));
		taLieferanten.setLineWrap(true);
		taLieferanten.setWrapStyleWord(true);
		taLieferanten.setDocument(new TextDoc(76));
		
		scrollPane = new JScrollPane(taLieferanten);
		scrollPane.setBounds(105, 171, 204, 60);
		contentPane.add(scrollPane);
		
		JButton btnBest�tigen = new JButton("Best�tigen");
		btnBest�tigen.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnBest�tigen.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0)  {
				int Artikelnummer = Integer.parseInt(txtFArtikelnummer.getText());			
				int Bestand = (int) spinnerBestand.getValue();
				String Bezeichnung = txtFBezeichnung.getText();
				String Art = txtFArt.getText();
				String Geschlecht;
				if(rdbtnWeiblich.isSelected())
					Geschlecht = "W";
				else 
					Geschlecht = "M";				
				String Hersteller = txtFHersteller.getText(); 
				String Verf�gbarkeit = (String) comboBoxVerf�gbarkeit.getSelectedItem();
				String Notiz = null;
				String[] Lieferanten = taLieferanten.getText().split(",");
				double Preis = Double.parseDouble(txtFPreis.getText().replace(',', '.'));
				int Rabatt = 0;
				int Schuhgr��e = 0;
				String Farbe = null;
				String Gr��e = null;
				if(Kategorie == "Schuhe")
					Schuhgr��e = Integer.parseInt(txtFVar.getText());
				else if(Kategorie == "Accessoires")
					Farbe = txtFVar.getText();
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
	 * �fnnet das Formular zum Editieren eines bestehenden Artikels.
	 * @param Artikelnummer Die Artikelnummer des zu ver�ndernden Artikels.
	 * @see Artikelverwaltung.Artikel
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
		lblArtikelnummer.setBounds(5, 11, 90, 22);
		contentPane.add(lblArtikelnummer);
		
		NumberFormat format = NumberFormat.getIntegerInstance(); 
        format.setGroupingUsed(false); 
        format.setMaximumIntegerDigits(9);
        format.setMinimumIntegerDigits(9);
        NumberFormatter formatter = new NumberFormatter(format); 
        formatter.setAllowsInvalid(false); 
		
		txtFArtikelnummer = new JFormattedTextField(formatter);
		txtFArtikelnummer.setText(String.valueOf(Artikelnummer));
		txtFArtikelnummer.setToolTipText("Die Artikelnummer muss 9 Stellen haben");
		txtFArtikelnummer.setBounds(105, 12, 204, 30);
		txtFArtikelnummer.setHorizontalAlignment(SwingConstants.RIGHT);
		txtFArtikelnummer.setEditable(false);
		contentPane.add(txtFArtikelnummer);
		txtFArtikelnummer.setColumns(10);
		
		JLabel lblBezeichnung = new JLabel("Bezeichnung");
		lblBezeichnung.setBounds(5, 51, 86, 22);
		contentPane.add(lblBezeichnung);
		
		txtFBezeichnung = new JTextField();
		txtFBezeichnung.setToolTipText("Name des Artikels");
		txtFBezeichnung.setBounds(105, 52, 204, 30);
		txtFBezeichnung.setDocument(new TextDoc(26));
		txtFBezeichnung.setText(Artikelsammlung.getArtikel(Artikelnummer).getBezeichnung());
		contentPane.add(txtFBezeichnung);
		txtFBezeichnung.setColumns(10);
		
		JLabel lblArt = new JLabel("Art");
		lblArt.setBounds(5, 91, 86, 22);
		contentPane.add(lblArt);
		
		txtFArt = new JTextField();
		txtFArt.setToolTipText("Unterkategorie wie z.B. Laufschuhe, Sneaker, etc.");
		txtFArt.setBounds(105, 90, 204, 25);
		txtFArt.setDocument(new TextDoc(21));
		txtFArt.setText(Artikelsammlung.getArtikel(Artikelnummer).getArt());
		contentPane.add(txtFArt);
		txtFArt.setColumns(10);
		
		lblHersteller = new JLabel("Hersteller");
		lblHersteller.setBounds(5, 131, 86, 22);
		contentPane.add(lblHersteller);
		
		txtFHersteller = new JTextField();
		txtFHersteller.setToolTipText("Die Marke des Artikels");
		txtFHersteller.setBounds(105, 130, 204, 25);
		txtFHersteller.setDocument(new TextDoc(26));
		txtFHersteller.setText(Artikelsammlung.getArtikel(Artikelnummer).getHersteller());
		contentPane.add(txtFHersteller);
		txtFHersteller.setColumns(10);
		
		lblVerfgbarkeit = new JLabel("Verf\u00FCgbarkeit");
		lblVerfgbarkeit.setBounds(5, 281, 90, 22);
		contentPane.add(lblVerfgbarkeit);
		
		lblBestand = new JLabel("Bestand");
		lblBestand.setBounds(5, 321, 86, 22);
		contentPane.add(lblBestand);
		
		lblLieferanten = new JLabel("Lieferanten");
		lblLieferanten.setBounds(5, 170, 86, 22);
		contentPane.add(lblLieferanten);
		
		lblPreis = new JLabel("Preis");
		lblPreis.setBounds(5, 361, 86, 22);
		contentPane.add(lblPreis);
		
		lblRabatt = new JLabel("Rabatt");
		lblRabatt.setBounds(5, 403, 86, 22);
		contentPane.add(lblRabatt);
		
		txtFRabatt = new JFormattedTextField(rabattformatter);
		txtFRabatt.setBounds(105, 400, 86, 25);
		txtFRabatt.setToolTipText("Prozentualer Wert, der von dem Preis abgezogen wird");
		txtFRabatt.setText(String.valueOf(Artikelsammlung.getArtikel(Artikelnummer).getRabatt()));
		contentPane.add(txtFRabatt);
		txtFRabatt.setColumns(10);
		
		lblGeschlecht = new JLabel("Geschlecht");
		lblGeschlecht.setBounds(5, 443, 90, 22);
		contentPane.add(lblGeschlecht);
		
		final JRadioButton rdbtnWeiblich = new JRadioButton("Weiblich");
		buttonGroup.add(rdbtnWeiblich);
		rdbtnWeiblich.setBounds(219, 441, 90, 23);
		contentPane.add(rdbtnWeiblich);
		
		
		final JRadioButton rdbtnMnnlich = new JRadioButton("M\u00E4nnlich");
		buttonGroup.add(rdbtnMnnlich);
		rdbtnMnnlich.setBounds(105, 441, 90, 23);
		contentPane.add(rdbtnMnnlich);
		
		if(Artikelsammlung.getArtikel(Artikelnummer).getGeschlecht().equals("W")) 
			rdbtnWeiblich.setSelected(true);
		else
			rdbtnMnnlich.setSelected(true);
		
        preisformatter.setAllowsInvalid(false); 
		txtFPreis = new JFormattedTextField(preisformatter);
		txtFPreis.setBounds(105, 360, 86, 25);
		txtFPreis.setText(String.valueOf(Artikelsammlung.getArtikel(Artikelnummer).getPreis()));
		contentPane.add(txtFPreis);
		txtFPreis.setColumns(10);
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnAbbrechen.setBounds(105, 471, 90, 40);
		contentPane.add(btnAbbrechen);
				
		lblEuro = new JLabel("\u20AC");
		lblEuro.setBounds(201, 365, 46, 14);
		contentPane.add(lblEuro);
		
		lblProzent = new JLabel("%");
		lblProzent.setBounds(201, 405, 46, 14);
		contentPane.add(lblProzent);
				
		comboBoxVerf�gbarkeit = new JComboBox<String>(verf�gbarkeiten);
		comboBoxVerf�gbarkeit.setBounds(105, 280, 204, 25);
		comboBoxVerf�gbarkeit.setSelectedItem(Artikelsammlung.getArtikel(Artikelnummer).getVerf�gbarkeit());
	    contentPane.add(comboBoxVerf�gbarkeit);
	    
	    
	    
		if(Artikelsammlung.getArtikel(Artikelnummer).getClass().getName() == "Artikelverwaltung.Accessoires") {
			Accessoires a = (Accessoires) Artikelsammlung.getArtikel(Artikelnummer);
			JLabel lblFarbe = new JLabel("Farbe");
			lblFarbe.setBounds(5, 245, 86, 22);
			contentPane.add(lblFarbe);
		
			txtFVar = new JTextField();
			txtFVar.setBounds(105, 242, 204, 25);
			txtFVar.setDocument(new TextDoc(16));
			txtFVar.setText(a.getFarbe());			
			contentPane.add(txtFVar);
			txtFVar.setColumns(10);
		}
		else if(Artikelsammlung.getArtikel(Artikelnummer).getClass().getName() == "Artikelverwaltung.Schuhe") {
			Schuhe a = (Schuhe)Artikelsammlung.getArtikel(Artikelnummer);
			JLabel lblSchuhgr��e = new JLabel("Schuhgr��e");
			lblSchuhgr��e.setBounds(5, 245, 86, 22);
			contentPane.add(lblSchuhgr��e);
		
			txtFVar = new JFormattedTextField(schuhformatter);
			txtFVar.setBounds(105, 242, 204, 25);
			txtFVar.setText(String.valueOf(a.getSchuhgr��e()));
			contentPane.add(txtFVar);
			txtFVar.setColumns(10);
		}
		else if(Artikelsammlung.getArtikel(Artikelnummer).getClass().getName() == "Artikelverwaltung.Kleidung") {
			Kleidung a = (Kleidung) Artikelsammlung.getArtikel(Artikelnummer);
			JLabel lblGr��e = new JLabel("Gr��e");
			lblGr��e.setBounds(5, 245, 86, 22);
			contentPane.add(lblGr��e);
					
			comboBoxGr��e = new JComboBox<String>(gr��en);
			comboBoxGr��e.setBounds(105, 242, 204, 25);
			comboBoxGr��e.setSelectedItem(a.getGr��e());
			contentPane.add(comboBoxGr��e);
		}
		SpinnerModel model = new SpinnerNumberModel(0, 0, 99999, 1);
		final JSpinner spinnerBestand = new JSpinner(model);
		spinnerBestand.setToolTipText("Lagerbestand");
		spinnerBestand.setBounds(100, 322, 95, 30);
		spinnerBestand.setValue(Artikelsammlung.getArtikel(Artikelnummer).getBestand());
		contentPane.add(spinnerBestand);
		
		final JTextArea taLieferanten = new JTextArea();
		taLieferanten.setToolTipText("Hier die Lieferanten eintragen. Alle m�ssen durch ein Komma getrennt sein");
		taLieferanten.setFont(new Font("Tahoma", Font.PLAIN, 11));
		taLieferanten.setLineWrap(true);
		taLieferanten.setWrapStyleWord(true);
		taLieferanten.setDocument(new TextDoc(76));
		String str = "";
		String[] lieferanten = Artikelsammlung.getArtikel(Artikelnummer).getLieferanten();
		for(int i=0; i< lieferanten.length; i++) {
			if(i == (lieferanten.length -1) )
				str = str + lieferanten[i];
			else
				str = str + lieferanten[i] + ",";
		}
		if(str != null)
			taLieferanten.setText(str);
		
		scrollPane = new JScrollPane(taLieferanten);
		scrollPane.setBounds(105, 171, 204, 60);
		contentPane.add(scrollPane);
		
		JButton btnBest�tigen = new JButton("Best�tigen");
		btnBest�tigen.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnBest�tigen.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0)  {
				int Artikelnummer = Integer.parseInt(txtFArtikelnummer.getText());			
				int Bestand = (int) spinnerBestand.getValue();
				String Bezeichnung = txtFBezeichnung.getText();
				String Art = txtFArt.getText();
				String Geschlecht;
				if(rdbtnWeiblich.isSelected())
					Geschlecht = "W";
				else 
					Geschlecht = "M";				
				String Hersteller = txtFHersteller.getText(); 
				String Verf�gbarkeit = (String) comboBoxVerf�gbarkeit.getSelectedItem();
				String Notiz = null;
				String[] Lieferanten = taLieferanten.getText().split(";");
				double Preis = Double.parseDouble(txtFPreis.getText().replace(',', '.'));
				int Rabatt = Artikelsammlung.getArtikel(Artikelnummer).getRabatt();
				int Schuhgr��e = 0;
				String Farbe = null;
				String Gr��e = null;
				if(Artikelsammlung.getArtikel(Artikelnummer).getClass().getName() == "Artikelverwaltung.Schuhe")
					Schuhgr��e = Integer.parseInt(txtFVar.getText());
				else if(Artikelsammlung.getArtikel(Artikelnummer).getClass().getName() == "Artikelverwaltung.Accessoires")
					Farbe = txtFVar.getText();
				else if(Artikelsammlung.getArtikel(Artikelnummer).getClass().getName() == "Artikelverwaltung.Kleidung")
					Gr��e = comboBoxGr��e.getSelectedItem().toString();
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
