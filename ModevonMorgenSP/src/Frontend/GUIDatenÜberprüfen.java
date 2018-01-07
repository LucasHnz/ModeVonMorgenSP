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

import Bestellverwaltung.BestellStrg;
import KundenVerwaltung.Bestandskunde;
import Logverwaltung.LogStrg;

public class GUIDaten�berpr�fen  {
	
	public static JPanel panel;

	/**
	 * @wbp.parser.entryPoint
	 */
	public static JPanel getGUIDaten�berpr�fen(int nutzernummer) {
		Bestandskunde kunde = Datenbankverwaltung.HoleDatenSatz.holeKunde(nutzernummer);
		
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1248, 520);
		panel.setLayout(null);
		panel.setLayout(null);
		panel.setVisible(true);

		JButton btnWeiter;
	
		JLabel lblBestandskundenNummer = new JLabel("Kunden Nummer:");
		lblBestandskundenNummer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBestandskundenNummer.setBounds(451, 11, 145, 33);
		panel.add(lblBestandskundenNummer);
	
	
	
	
		JLabel lblStra�e = new JLabel("Stra�e:");
		lblStra�e.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStra�e.setBounds(451, 187, 145, 33);
		panel.add(lblStra�e);
	
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
		
	
		JTextField textField = new JTextField();
		textField.setToolTipText("Die Kunden Nummer wurde autogeneriert");
		//textField.setText(String.valueOf(kunde.getNutzernr()));
		textField.setEditable(false);
		textField.setBounds(641, 11, 161, 33);
		panel.add(textField);
		textField.setColumns(10);
		
		
		
		
		JTextField textField_Stra�e = new JTextField();
		textField_Stra�e.setToolTipText("Hier Bitte die Stra�e eintragen");
		//textField_5.setText(kunde.getStra�e());
		textField_Stra�e.setColumns(10);
		textField_Stra�e.setBounds(641, 187, 161, 33);
		panel.add(textField_Stra�e);
		
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
		
		
	
		
	
		JButton btnAnnehmen = new JButton("Speichern ");
		btnAnnehmen.addActionListener(new ActionListener() {
			
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			
			
			if(textField_Stra�e.getText() != kunde.getStra�e()) {
				KundenVerwaltung.BestandskundeStrg.aktualisiereStra�e(textField_Stra�e.getText(),Integer.toString(kunde.getNutzernr()));
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
			
			
			
			JOptionPane.showOptionDialog(null, "�nderungen wurden gespeichert","Rechnungsdaten wurden bearbeitet.",
	                JOptionPane.YES_NO_CANCEL_OPTION,
	                JOptionPane.INFORMATION_MESSAGE, null, 
	                new String[]{"Ok"}, "Ok"); 	
			
		
			
			}
		
		});
	
	
		btnAnnehmen.setBounds(641, 432, 145, 40);
		panel.add(btnAnnehmen);
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setBounds(851, 432, 145, 40);
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUI.getFenster().changePanel(GUIWarenkorb.getGUIWarenkorb());
			}
		});
		panel.add(btnAbbrechen);
		panel.setVisible(true);
		
		return panel;
		
		btnWeiter =new JButton ("Bestellung aufgeben");
		btnWeiter.setBounds(409, 432, 176, 40);
		btnWeiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			BestellStrg.erstelleBestellungBK();
			JOptionPane.showMessageDialog(null,
				    "Erfolgreicher Eingang Ihrer Bestellung.");
			
		//	MailController.MailSenden.sendMail("Email","Best�tigung ihrer Bestellung","Sehr geehrter Kunde, Vielen Dank f�r ihre Bestellung. Ihre Bestellung wird in K�rze bearbeitet und in 5-7 Werktagen versand. ");
			GUI.getFenster().changePanel(GUIHomepage.getHomepage());
			}
		});
		panel.add(btnWeiter);
	}
}
