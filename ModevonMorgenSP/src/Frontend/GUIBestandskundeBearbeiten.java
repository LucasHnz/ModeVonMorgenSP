package Frontend;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import KundenVerwaltung.Bestandskunde;

public class GUIBestandskundeBearbeiten  {
	
	public static JPanel panel;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static JPanel getGUIBestandskundeBearbeiten(int nutzernummer) {
		Bestandskunde kunde = Datenbankverwaltung.HoleDatenSatz.holeKunde(nutzernummer);
		
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1248, 520);
		panel.setLayout(null);
		panel.setLayout(null);
		panel.setVisible(true);
	
		JLabel lblBestandskundenNummer = new JLabel("Kunden Nummer:");
		lblBestandskundenNummer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBestandskundenNummer.setBounds(451, 11, 145, 33);
		panel.add(lblBestandskundenNummer);
	
		JLabel lblNachname = new JLabel("Nachname:");
		lblNachname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNachname.setBounds(451, 55, 145, 33);
		panel.add(lblNachname);
	
		JLabel lblVorname = new JLabel("Vorname:");
		lblVorname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVorname.setBounds(451, 99, 145, 33);
		panel.add(lblVorname);
	
		JLabel lblEmailAdresse = new JLabel("E-Mail Adresse:");
		lblEmailAdresse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmailAdresse.setBounds(451, 143, 145, 33);
		panel.add(lblEmailAdresse);
	
		JLabel lblStraﬂe = new JLabel("Straﬂe:");
		lblStraﬂe.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStraﬂe.setBounds(451, 187, 145, 33);
		panel.add(lblStraﬂe);
	
		JLabel lblOrt = new JLabel("Ort:");
		lblOrt.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOrt.setBounds(451, 231, 145, 33);
		panel.add(lblOrt);
	
		JLabel lblPlz = new JLabel("PLZ:");
		lblPlz.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPlz.setBounds(451, 275, 145, 33);
		panel.add(lblPlz);
	
		JLabel lblIban = new JLabel("IBAN:");
		lblIban.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIban.setBounds(451, 319, 145, 33);
		panel.add(lblIban);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPasswort.setBounds(451, 363, 145, 33);
		panel.add(lblPasswort);
		
		JTextField textField = new JTextField();
		textField.setToolTipText("Die Kunden Nummer wurde autogeneriert");
		//textField.setText(String.valueOf(kunde.getNutzernr()));
		textField.setEditable(false);
		textField.setBounds(641, 11, 161, 33);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextField textField_Nachname = new JTextField();
		textField_Nachname.setToolTipText("Hier Bitte den Nach-Namen eintragen");
		//textField_2.setText(kunde.getNachname());
		textField_Nachname.setColumns(10);
		textField_Nachname.setBounds(641, 55, 161, 33);
		panel.add(textField_Nachname);
		
		JTextField textField_Vorname = new JTextField();
		textField_Vorname.setToolTipText("Hier Bitte den Vor-Namen eintragen");
		//textField_3.setText(kunde.getVorname());
		textField_Vorname.setColumns(10);
		textField_Vorname.setBounds(641, 99, 161, 33);
		panel.add(textField_Vorname);
		
		JTextField textField_Mail = new JTextField();
		textField_Mail.setToolTipText("Hier Bitte die EMail eintragen");
		//textField_4.setText(kunde.getEmail());
		textField_Mail.setColumns(10);
		textField_Mail.setBounds(641, 143, 161, 33);
		panel.add(textField_Mail);
		
		JTextField textField_Straﬂe = new JTextField();
		textField_Straﬂe.setToolTipText("Hier Bitte die Straﬂe eintragen");
		//textField_5.setText(kunde.getStraﬂe());
		textField_Straﬂe.setColumns(10);
		textField_Straﬂe.setBounds(641, 187, 161, 33);
		panel.add(textField_Straﬂe);
		
		JTextField textField_Ort = new JTextField();
		textField_Ort.setToolTipText("Hier Bitte den Wohnort eintragen");
		//textField_6.setText(kunde.getOrt());
		textField_Ort.setColumns(10);
		textField_Ort.setBounds(641, 231, 161, 33);
		panel.add(textField_Ort);
		
		JTextField textField_PLZ = new JTextField();
		textField_PLZ.setToolTipText("Hier Bitte die PLZ des Wohnorts eintragen");
		//textField_7.setText(String.valueOf(kunde.getPlz()));
		textField_PLZ.setColumns(10);
		textField_PLZ.setBounds(641, 275, 161, 33);
		panel.add(textField_PLZ);
		
		JTextField textField_IBAN = new JTextField();
		textField_IBAN.setToolTipText("Hier Bitte die IBAN Adresse  eintragen");
		//textField_8.setText(kunde.getIban());
		textField_IBAN.setColumns(10);
		textField_IBAN.setBounds(641, 319, 161, 33);
		panel.add(textField_IBAN);
		
		
		JPasswordField textField_Passwort = new JPasswordField();
		textField_Passwort.setToolTipText("Hier Bitte das Passwort eingeben");
		//textField_9.setText(kunde.getPasswort());
		textField_Passwort.setColumns(10);
		textField_Passwort.setBounds(641, 363, 161, 33);
		panel.add(textField_Passwort);
		
	
		
		JButton btnAnnehmen = new JButton("Speichern");
		btnAnnehmen.addActionListener(new ActionListener() {
			
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if(textField_Nachname.getText() != kunde.getNachname()) {
				KundenVerwaltung.BestandskundeStrg.aktualisiereNachname(textField_Nachname.getText(),Integer.toString(kunde.getNutzernr()));
			}
			if(textField_Vorname.getText() != kunde.getVorname()) {
				KundenVerwaltung.BestandskundeStrg.aktualisiereVorname(textField_Nachname.getText(),Integer.toString(kunde.getNutzernr()));
			}
			
			if(textField_Mail.getText() != kunde.getEmail()) {
				KundenVerwaltung.BestandskundeStrg.aktualisiereEmail(textField_Mail.getText(),Integer.toString(kunde.getNutzernr()));
			}
			
			if(textField_Straﬂe.getText() != kunde.getStraﬂe()) {
				KundenVerwaltung.BestandskundeStrg.aktualisiereStraﬂe(textField_Straﬂe.getText(),Integer.toString(kunde.getNutzernr()));
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
			
			JOptionPane.showOptionDialog(null, "ƒnderungen wurden gespeichert","Bestandskunden Bearbeitung",
	                JOptionPane.YES_NO_CANCEL_OPTION,
	                JOptionPane.WARNING_MESSAGE, null, 
	                new String[]{"Ok"}, "Ok"); 	
			
			GUI.changePanel(GUIKontoVerwalten.getGUIKontoVerwalten());
			}
	
		
		});
	
		btnAnnehmen.setBounds(641, 432, 161, 40);
		panel.add(btnAnnehmen);
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setBounds(451, 432, 145, 40);
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUI.changePanel(GUIKontoVerwalten.getGUIKontoVerwalten());
			}
		});
		panel.add(btnAbbrechen);
		panel.setVisible(true);
		
		return panel;
	}
}


