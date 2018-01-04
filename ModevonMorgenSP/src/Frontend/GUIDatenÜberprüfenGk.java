package Frontend;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import KundenVerwaltung.Bestandskunde;
import KundenVerwaltung.Gastkunde;

public class GUIDaten‹berpr¸fenGk {
	public static JPanel panel;

	/**
	 * @wbp.parser.entryPoint
	 */
	public static JPanel getGUIDaten‹berpr¸fenGK(int nutzernummer) {
		Gastkunde kunde = Datenbankverwaltung.HoleDatenSatz.holeGKunde(nutzernummer);
		
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1248, 520);
		panel.setLayout(null);
		panel.setLayout(null);
		panel.setVisible(true);

		
		JLabel lbl‹berschrift= new JLabel("Bitte Daten ¸berpr¸fen und ggf. bearbeiten");
		lbl‹berschrift.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl‹berschrift.setBounds(451,137,154,33);
		panel.add(lbl‹berschrift);

		JLabel lblGastkundenNummer = new JLabel("Kunden Nummer:");
		lblGastkundenNummer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGastkundenNummer.setBounds(451, 11, 145, 33);
		panel.add(lblGastkundenNummer);
	
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
		
	
		JTextField textField = new JTextField();
		textField.setToolTipText("Die Kunden Nummer wurde autogeneriert");
		//textField.setText(String.valueOf(kunde.getNutzernr()));
		textField.setEditable(false);
		textField.setBounds(641, 11, 161, 33);
		panel.add(textField);
		textField.setColumns(10);
		
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
		
		
	
		
	
		JButton btnAnnehmen = new JButton("Speichern ");
		btnAnnehmen.addActionListener(new ActionListener() {
			
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			
			
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
			
			
			
			JOptionPane.showOptionDialog(null, "ƒnderungen wurden gespeichert","Rechnungsdaten wurden bearbeitet.",
	                JOptionPane.YES_NO_CANCEL_OPTION,
	                JOptionPane.WARNING_MESSAGE, null, 
	                new String[]{"Ok"}, "Ok"); 	
			
			GUI.getFenster().changePanel(GUIKontoVerwalten.getGUIKontoVerwalten());
			
			}
		
		});
	
	
		btnAnnehmen.setBounds(641, 432, 161, 40);
		panel.add(btnAnnehmen);
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setBounds(451, 432, 145, 40);
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUI.getFenster().changePanel(GUIWarenkorb.getGUIWarenkorb());
			}
		});
		panel.add(btnAbbrechen);
		panel.setVisible(true);
		
		return panel;
		
		JButton btnWeiter = new JButton("Weiter");
		btnWeiter.setBounds(251, 432, 145, 40);
		btnWeiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUI.getFenster().changePanel();  //weiter die bestellung anzeigen aus dem warenkorb 
			}
		});
		panel.add(btnWeiter);
	}
}




