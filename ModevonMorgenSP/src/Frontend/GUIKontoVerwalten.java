package Frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.NumberFormatter;

import Backend.TextDoc;
import BestellungVerwaltung.Bestellung;
import KundenVerwaltung.Bestandskunde;
import KundenVerwaltung.BestandskundeSammlung;
import KundenVerwaltung.BestandskundeStrg;
import Logverwaltung.LogStrg;

public class GUIKontoVerwalten extends JPanel{
	
	private static int nutzernummer;
	
	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public GUIKontoVerwalten() {
		setBounds(0, 0, 1248, 563);
		setLayout(null);
		nutzernummer = LogStrg.getNutzerNr();
		Bestandskunde kunde = Datenbankverwaltung.HoleDatenSatz.holeKunde(nutzernummer);
			
		JButton btnKontoLöschen = new JButton("Konto Löschen");
		btnKontoLöschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final Object optionPane = JOptionPane.showConfirmDialog(null,
						"Wollen Sie ihr Kundenkonto wirklich löschen? \nDamit gehen sämtliche Kundendaten verloren!", "Konto löschen?",
						JOptionPane.YES_NO_OPTION);
				if(optionPane.equals(0)) {
					JOptionPane.showMessageDialog(null,  "Ihr Konto wurde gelöscht. Sie werden jetzt ausgeloggt.", "Information", JOptionPane.INFORMATION_MESSAGE);
					BestandskundeStrg.löschenAccount(nutzernummer);
					LogStrg.abmelden();
				}else if(optionPane.equals(1)) {
					JOptionPane.showMessageDialog(null,  "Vorgang abgebrochen!", "Abbruch", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnKontoLöschen.setFont(new Font("Calibri", Font.BOLD, 15));
		btnKontoLöschen.setBackground(Color.WHITE);
		btnKontoLöschen.setBounds(1023, 504, 215, 48);
		add(btnKontoLöschen);
		
		
		
		JLabel lblBestandskundenNummer = new JLabel("Kunden Nummer:");
		lblBestandskundenNummer.setFont(new Font("Calibri", Font.BOLD, 14));
		lblBestandskundenNummer.setBounds(460, 55, 145, 33);
		add(lblBestandskundenNummer);
	
		JLabel lblNachname = new JLabel("Nachname:");
		lblNachname.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNachname.setBounds(460, 99, 145, 33);
		add(lblNachname);
	
		JLabel lblVorname = new JLabel("Vorname:");
		lblVorname.setFont(new Font("Calibri", Font.BOLD, 14));
		lblVorname.setBounds(460, 143, 145, 33);
		add(lblVorname);
	
		JLabel lblEmailAdresse = new JLabel("E-Mail Adresse:");
		lblEmailAdresse.setFont(new Font("Calibri", Font.BOLD, 14));
		lblEmailAdresse.setBounds(460, 187, 145, 33);
		add(lblEmailAdresse);
	
		JLabel lblStraße = new JLabel("Straße:");
		lblStraße.setFont(new Font("Calibri", Font.BOLD, 14));
		lblStraße.setBounds(460, 231, 145, 33);
		add(lblStraße);
	
		JLabel lblOrt = new JLabel("Ort:");
		lblOrt.setFont(new Font("Calibri", Font.BOLD, 14));
		lblOrt.setBounds(460, 275, 145, 33);
		add(lblOrt);
	
		JLabel lblPlz = new JLabel("PLZ:");
		lblPlz.setFont(new Font("Calibri", Font.BOLD, 14));
		lblPlz.setBounds(460, 319, 145, 33);
		add(lblPlz);
	
		JLabel lblIban = new JLabel("IBAN:");
		lblIban.setFont(new Font("Calibri", Font.BOLD, 14));
		lblIban.setBounds(460, 363, 145, 33);
		add(lblIban);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setFont(new Font("Calibri", Font.BOLD, 14));
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
		
		JTextField textField_Straße = new JTextField();
		textField_Straße.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField_Straße.setToolTipText("Hier Bitte die Straße eintragen");
		textField_Straße.setDocument(new TextDoc(36));
		System.out.println(kunde.getStraße());
		textField_Straße.setText(kunde.getStraße());
		textField_Straße.setColumns(10);
		textField_Straße.setBounds(650, 231, 161, 33);
		add(textField_Straße);
		
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
		
	
		JButton btnAnnehmen = new JButton("Speichern");
		btnAnnehmen.setFont(new Font("Calibri", Font.BOLD, 14));
		btnAnnehmen.addActionListener(new ActionListener() {
			
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if(textField_Nachname.getText() != kunde.getNachname()) {
				KundenVerwaltung.BestandskundeStrg.aktualisiereNachname(textField_Nachname.getText(),Integer.toString(kunde.getNutzernr()));
			}
			if(textField_Vorname.getText() != kunde.getVorname()) {
				KundenVerwaltung.BestandskundeStrg.aktualisiereVorname(textField_Vorname.getText(),Integer.toString(kunde.getNutzernr()));
			}
			
			if(textField_Mail.getText() != kunde.getEmail()) {
				KundenVerwaltung.BestandskundeStrg.aktualisiereEmail(textField_Mail.getText(),Integer.toString(kunde.getNutzernr()));
			}
			
			if(textField_Straße.getText() != kunde.getStraße()) {
				KundenVerwaltung.BestandskundeStrg.aktualisiereStraße(textField_Straße.getText(),Integer.toString(kunde.getNutzernr()));
			}
			
			if(textField_Ort.getText() != kunde.getOrt()) {
				KundenVerwaltung.BestandskundeStrg.aktualisiereOrt(textField_Ort.getText(),Integer.toString(kunde.getNutzernr()));
			}
			
			if(textField_PLZ.getText() != String.valueOf(kunde.getPlz())) {
				KundenVerwaltung.BestandskundeStrg.aktualisierePLZ(textField_PLZ.getText(),Integer.toString(kunde.getNutzernr()));
			}
			
			if(textField_IBAN.getText() != kunde.getIban()) {
				KundenVerwaltung.BestandskundeStrg.aktualisiereIBAN(textField_IBAN.getText(),Integer.toString(kunde.getNutzernr()));
			}
			
			if(textField_Passwort.getText() != kunde.getPasswort()) {
				KundenVerwaltung.BestandskundeStrg.aktualisierePasswort(textField_Passwort.getText(),Integer.toString(kunde.getNutzernr()));
			}
			
			JOptionPane.showOptionDialog(null, "Änderungen wurden gespeichert","Bestandskunden Bearbeitung",
	                JOptionPane.YES_NO_CANCEL_OPTION,
	                JOptionPane.WARNING_MESSAGE, null, 
	                new String[]{"Ok"}, "Ok"); 	
			
			GUI.getFenster().changePanel(new GUIKontoVerwalten());
			
			}
		
		});
	
		btnAnnehmen.setBounds(650, 476, 161, 40);
		add(btnAnnehmen);
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setFont(new Font("Calibri", Font.BOLD, 14));
		btnAbbrechen.setBounds(460, 476, 145, 40);
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUI.getFenster().changePanel(new GUIKontoVerwalten());
			}
		});
		add(btnAbbrechen);
		
		setVisible(true);
		
	}
}