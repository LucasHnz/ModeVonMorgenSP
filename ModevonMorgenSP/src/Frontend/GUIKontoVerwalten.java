package Frontend;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.NumberFormat;
import javax.swing.*;
import javax.swing.text.NumberFormatter;
import Backend.TextDoc;
import KundenVerwaltung.Bestandskunde;
import KundenVerwaltung.BestandskundeStrg;
import Logverwaltung.LogStrg;
/**
 * 
 * @author Falk Maoro
 *
 */
public class GUIKontoVerwalten extends JPanel{
	
	private static int nutzernummer;
	
	/**
	 * Zeigt dem Nutzer seine Accountdaten an und l�sst ihn seine Daten editieren.
	 */
	public GUIKontoVerwalten() {
		setBackground(Color.DARK_GRAY);
		setBounds(0, 0, 1248, 563);
		setLayout(null);
		nutzernummer = LogStrg.getNutzerNr();
		Bestandskunde kunde = Datenbankverwaltung.HoleDatenSatz.holeKunde(nutzernummer);
			
		JButton btnKontoL�schen = new JButton("Konto L�schen");
		btnKontoL�schen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final Object optionPane = JOptionPane.showConfirmDialog(null,
						"Wollen Sie ihr Kundenkonto wirklich l�schen? \nDamit gehen s�mtliche Kundendaten verloren!", "Konto l�schen?",
						JOptionPane.YES_NO_OPTION);
				if(optionPane.equals(0)) {
					JOptionPane.showMessageDialog(null,  "Ihr Konto wurde gel�scht. Sie werden jetzt ausgeloggt.", "Information", JOptionPane.INFORMATION_MESSAGE);
					BestandskundeStrg.l�schenAccount(nutzernummer);
					LogStrg.abmelden();
				}else if(optionPane.equals(1)) {
					JOptionPane.showMessageDialog(null,  "Vorgang abgebrochen!", "Abbruch", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnKontoL�schen.setFont(new Font("Dialog", Font.BOLD, 15));
		btnKontoL�schen.setBackground(Color.WHITE);
		btnKontoL�schen.setBounds(1023, 504, 215, 48);
		add(btnKontoL�schen);
		
		
		
		JLabel lblBestandskundenNummer = new JLabel("Kunden Nummer:");
		lblBestandskundenNummer.setForeground(Color.WHITE);
		lblBestandskundenNummer.setFont(new Font("Dialog", Font.BOLD, 14));
		lblBestandskundenNummer.setBounds(460, 55, 145, 33);
		add(lblBestandskundenNummer);
	
		JLabel lblNachname = new JLabel("Nachname:");
		lblNachname.setForeground(Color.WHITE);
		lblNachname.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNachname.setBounds(460, 99, 145, 33);
		add(lblNachname);
	
		JLabel lblVorname = new JLabel("Vorname:");
		lblVorname.setForeground(Color.WHITE);
		lblVorname.setFont(new Font("Dialog", Font.BOLD, 14));
		lblVorname.setBounds(460, 143, 145, 33);
		add(lblVorname);
	
		JLabel lblEmailAdresse = new JLabel("E-Mail Adresse:");
		lblEmailAdresse.setForeground(Color.WHITE);
		lblEmailAdresse.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEmailAdresse.setBounds(460, 187, 145, 33);
		add(lblEmailAdresse);
	
		JLabel lblStra�e = new JLabel("Stra�e:");
		lblStra�e.setForeground(Color.WHITE);
		lblStra�e.setFont(new Font("Dialog", Font.BOLD, 14));
		lblStra�e.setBounds(460, 233, 145, 33);
		add(lblStra�e);
	
		JLabel lblOrt = new JLabel("Ort:");
		lblOrt.setForeground(Color.WHITE);
		lblOrt.setFont(new Font("Dialog", Font.BOLD, 14));
		lblOrt.setBounds(460, 275, 145, 33);
		add(lblOrt);
	
		JLabel lblPlz = new JLabel("PLZ:");
		lblPlz.setForeground(Color.WHITE);
		lblPlz.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPlz.setBounds(460, 319, 145, 33);
		add(lblPlz);
	
		JLabel lblIban = new JLabel("IBAN:");
		lblIban.setForeground(Color.WHITE);
		lblIban.setFont(new Font("Dialog", Font.BOLD, 14));
		lblIban.setBounds(460, 363, 145, 33);
		add(lblIban);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setForeground(Color.WHITE);
		lblPasswort.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPasswort.setBounds(460, 407, 145, 33);
		add(lblPasswort);
		
		JTextField textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField.setToolTipText("Die Kunden Nummer wurde autogeneriert");
		textField.setText(String.valueOf(kunde.getNutzernr()));
		textField.setEditable(false);
		textField.setBounds(650, 55, 161, 33);
		add(textField);
		textField.setColumns(10);
		
		JTextField textField_Nachname = new JTextField();
		textField_Nachname.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField_Nachname.setToolTipText("Hier Bitte den Nach-Namen eintragen");
		textField_Nachname.setDocument(new TextDoc(26));
		textField_Nachname.setText(kunde.getNachname());
		textField_Nachname.setColumns(10);
		textField_Nachname.setBounds(650, 99, 161, 33);
		add(textField_Nachname);
		
		JTextField textField_Vorname = new JTextField();
		textField_Vorname.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField_Vorname.setToolTipText("Hier Bitte den Vor-Namen eintragen");
		textField_Vorname.setDocument(new TextDoc(26));
		textField_Vorname.setText(kunde.getVorname());
		textField_Vorname.setColumns(10);
		textField_Vorname.setBounds(650, 143, 161, 33);
		add(textField_Vorname);
		
		JTextField textField_Mail = new JTextField();
		textField_Mail.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField_Mail.setToolTipText("Hier Bitte die EMail eintragen");
		textField_Mail.setDocument(new TextDoc(51));
		textField_Mail.setText(kunde.getEmail());
		textField_Mail.setColumns(10);
		textField_Mail.setBounds(650, 187, 161, 33);
		add(textField_Mail);
		
		JTextField textField_Stra�e = new JTextField();
		textField_Stra�e.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField_Stra�e.setToolTipText("Hier Bitte die Stra�e eintragen");
		textField_Stra�e.setDocument(new TextDoc(36));
		textField_Stra�e.setText(kunde.getStra�e());
		textField_Stra�e.setColumns(10);
		textField_Stra�e.setBounds(650, 231, 161, 33);
		add(textField_Stra�e);
		
		JTextField textField_Ort = new JTextField();
		textField_Ort.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField_Ort.setToolTipText("Hier Bitte den Wohnort eintragen");
		textField_Ort.setDocument(new TextDoc(26));
		textField_Ort.setText(kunde.getOrt());
		textField_Ort.setColumns(10);
		textField_Ort.setBounds(650, 275, 161, 33);
		add(textField_Ort);
		
		NumberFormat plzformat = NumberFormat.getNumberInstance(); 
        plzformat.setGroupingUsed(false); 
        plzformat.setMaximumIntegerDigits(5);
        plzformat.setMinimumIntegerDigits(1);
        NumberFormatter plzformatter = new NumberFormatter(plzformat);
		
		JFormattedTextField textField_PLZ = new JFormattedTextField(plzformatter);
		textField_PLZ.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField_PLZ.setToolTipText("Hier Bitte die PLZ des Wohnorts eintragen");
		textField_PLZ.setText(String.valueOf(kunde.getPlz()));
		textField_PLZ.setColumns(10);
		textField_PLZ.setBounds(650, 319, 161, 33);
		add(textField_PLZ);
		
		JTextField textField_IBAN = new JTextField();
		textField_IBAN.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField_IBAN.setToolTipText("Hier Bitte die IBAN Adresse  eintragen");
		textField_IBAN.setDocument(new TextDoc(26));
		textField_IBAN.setText(kunde.getIban());
		textField_IBAN.setColumns(10);
		textField_IBAN.setBounds(650, 363, 161, 33);
		add(textField_IBAN);
		
		
		JPasswordField textField_Passwort = new JPasswordField();
		textField_Passwort.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField_Passwort.setToolTipText("Hier Bitte das Passwort eingeben");
		textField_Passwort.setDocument(new TextDoc(16));
		textField_Passwort.setText(kunde.getPasswort());
		textField_Passwort.setColumns(10);
		textField_Passwort.setBounds(650, 407, 161, 33);
		add(textField_Passwort);
		
		URL annehmenUrl = GUI.class.getResource(
                "/Icons 64x64/checked.png");
		Image Annehmen = new ImageIcon(annehmenUrl).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		JLabel lblAnnehmen = new JLabel(new ImageIcon(Annehmen));
		lblAnnehmen.setBounds(650, 476, 40, 40);
		add(lblAnnehmen);
		
		
		JButton btnAnnehmen = new JButton("Speichern");
		btnAnnehmen.setFont(new Font("Dialog", Font.BOLD, 14));	
		btnAnnehmen.addActionListener(new ActionListener() {
		
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(textField_Nachname.getText().equals("") || textField_Vorname.getText().equals("") || textField_Mail.getText().equals("") || 
					textField_Stra�e.getText().equals("")|| textField_Ort.getText().equals("") || textField_PLZ.getText().equals("") ||
					textField_IBAN.getText().equals("") || textField_Passwort.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Alle Felder m�ssen ausgef�llt sein", "Fehler", JOptionPane.ERROR_MESSAGE);				
			}
			else {
			
				if(textField_Nachname.getText() != kunde.getNachname()) {
					KundenVerwaltung.BestandskundeStrg.aktualisiereNachname(textField_Nachname.getText(),kunde.getNutzernr());
				}
				if(textField_Vorname.getText() != kunde.getVorname())  {
					KundenVerwaltung.BestandskundeStrg.aktualisiereVorname(textField_Vorname.getText(),kunde.getNutzernr());
				}
				
				if(textField_Mail.getText() != kunde.getEmail()) {
					KundenVerwaltung.BestandskundeStrg.aktualisiereEmail(textField_Mail.getText(),kunde.getNutzernr());
				}
				
				if(textField_Stra�e.getText() != kunde.getStra�e()) {
					KundenVerwaltung.BestandskundeStrg.aktualisiereStra�e(textField_Stra�e.getText(),kunde.getNutzernr());
				}
			
				if(textField_Ort.getText() != kunde.getOrt()) {
					KundenVerwaltung.BestandskundeStrg.aktualisiereOrt(textField_Ort.getText(),kunde.getNutzernr());
				}
			
				if(textField_PLZ.getText() != String.valueOf(kunde.getPlz())) {
					KundenVerwaltung.BestandskundeStrg.aktualisierePLZ(textField_PLZ.getText(),kunde.getNutzernr());
				}
			
				if(textField_IBAN.getText() != kunde.getIban()) {
					KundenVerwaltung.BestandskundeStrg.aktualisiereIBAN(textField_IBAN.getText(),kunde.getNutzernr());
				}
				
				if(textField_Passwort.getText() != kunde.getPasswort()) {
					KundenVerwaltung.BestandskundeStrg.aktualisierePasswort(textField_Passwort.getText(),kunde.getNutzernr());
				}
			
				JOptionPane.showOptionDialog(null, "�nderungen wurden gespeichert","Bestandskunden Bearbeitung",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.WARNING_MESSAGE, null, 
						new String[]{"Ok"}, "Ok"); 	
			
				GUI.getFenster().changePanel(new GUIKontoVerwalten());
			
				}
			}
		});

		btnAnnehmen.setBounds(700, 476, 111, 40);
		add(btnAnnehmen);
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setFont(new Font("Dialog", Font.BOLD, 14));
		btnAbbrechen.setBounds(507, 476, 109, 40);
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUI.getFenster().changePanel(new GUIKontoVerwalten());
			}
		});
		
		URL abbrechenUrl = GUI.class.getResource(
                "/Icons 64x64/multiply.png");
		Image Abbrechen = new ImageIcon(abbrechenUrl).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		JLabel lblAbbrechen = new JLabel(new ImageIcon(Abbrechen));
		lblAbbrechen.setBounds(457, 476, 40, 40);
		add(lblAbbrechen);
		add(btnAbbrechen);
		 
		JLabel lblPunktestand = new JLabel("Rabattpunkte: " + kunde.getPss());
		lblPunktestand.setForeground(Color.WHITE);
		lblPunktestand.setToolTipText("Ihre gesammelten Rabattpunkte. Pro Punkt k\u00F6nnen Sie ein Prozent \nbei ihrer n\u00F6chsten Bestellung sparen.");
		lblPunktestand.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPunktestand.setBounds(1056, 54, 161, 35);
		add(lblPunktestand);
			
		setVisible(true);
		
	}
}