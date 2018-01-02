package Frontend;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import BestandskundenVerwaltung.Bestandskunde;

/**
 * 
 * @author annag
 *
 */


public class GUIBestandskundeBearbeiten  extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String berechtigung;
	public String pss;
	

	public GUIBestandskundeBearbeiten  (int nutzernr) {
	Bestandskunde kunde = Datenbankverwaltung.HoleDatenSatz.holeKunde(nutzernr);
	
	setBounds(200, 100, 354, 298);
	setResizable(false);
	setAlwaysOnTop(true);
	setTitle("Bestandskunde Bearbeiten Formular");
	getContentPane().setLayout(null);
	
	JPanel panel = new JPanel();
	panel.setBounds(10, 11, 340, 218);
	getContentPane().add(panel);
	panel.setLayout(null);
	panel.setVisible(true);
	
	JLabel lblBestandskundenNummer = new JLabel("Kunden Nummer:");
	lblBestandskundenNummer.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblBestandskundenNummer.setBounds(10, 11, 138, 16);
	panel.add(lblBestandskundenNummer);
	
	JLabel lblNachname = new JLabel("Nachname:");
	lblNachname.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblNachname.setBounds(10, 31, 126, 16);
	panel.add(lblNachname);
	
	JLabel lblVorname = new JLabel("Vorname:");
	lblVorname.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblVorname.setBounds(10, 51, 126, 16);
	panel.add(lblVorname);
	
	JLabel lblEmailAdresse = new JLabel("E-Mail Adresse:");
	lblEmailAdresse.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblEmailAdresse.setBounds(10, 71, 126, 16);
	panel.add(lblEmailAdresse);
	
	JLabel lblStraﬂe = new JLabel("Straﬂe:");
	lblStraﬂe.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblStraﬂe.setBounds(10, 91, 126, 16);
	panel.add(lblStraﬂe);
	
	JLabel lblOrt = new JLabel("Ort:");
	lblOrt.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblOrt.setBounds(10, 111, 126, 16);
	panel.add(lblOrt);
	
	JLabel lblPlz = new JLabel("PLZ:");
	lblPlz.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblPlz.setBounds(10, 131, 126, 16);
	panel.add(lblPlz);
	
	JLabel lblIban = new JLabel("IBAN:");
	lblIban.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblIban.setBounds(10, 151, 126, 16);
	panel.add(lblIban);
	
	JLabel lblPasswort = new JLabel("Passwort:");
	lblPasswort.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblPasswort.setBounds(10, 191, 126, 16);
	panel.add(lblPasswort);
	
	JTextField textField = new JTextField();
	textField.setToolTipText("Die Kunden Nummer wurde autogeneriert");
	textField.setText(String.valueOf(kunde.getNutzernr()));
	textField.setEditable(false);
	textField.setBounds(158, 11, 161, 16);
	panel.add(textField);
	textField.setColumns(10);
	
	JTextField textField_2 = new JTextField();
	textField_2.setToolTipText("Hier Bitte den Nach-Namen eintragen");
	textField_2.setText(kunde.getNachname());
	textField_2.setColumns(10);
	textField_2.setBounds(158, 31, 161, 16);
	panel.add(textField_2);
	
	JTextField textField_3 = new JTextField();
	textField_3.setToolTipText("Hier Bitte den Vor-Namen eintragen");
	textField_3.setText(kunde.getVorname());
	textField_3.setColumns(10);
	textField_3.setBounds(158, 51, 161, 16);
	panel.add(textField_3);
	
	JTextField textField_4 = new JTextField();
	textField_4.setToolTipText("Hier Bitte die EMail eintragen");
	textField_4.setText(kunde.getEmail());
	textField_4.setColumns(10);
	textField_4.setBounds(158, 71, 161, 16);
	panel.add(textField_4);
	
	JTextField textField_5 = new JTextField();
	textField_5.setToolTipText("Hier Bitte die Straﬂe eintragen");
	textField_5.setText(kunde.getStraﬂe());
	textField_5.setColumns(10);
	textField_5.setBounds(158, 91, 161, 16);
	panel.add(textField_5);
	
	JTextField textField_6 = new JTextField();
	textField_6.setToolTipText("Hier Bitte den Wohnort eintragen");
	textField_6.setText(kunde.getOrt());
	textField_6.setColumns(10);
	textField_6.setBounds(158, 111, 161, 16);
	panel.add(textField_6);
	
	JTextField textField_7 = new JTextField();
	textField_7.setToolTipText("Hier Bitte die PLZ des Wohnorts eintragen");
	textField_7.setText(String.valueOf(kunde.getPlz()));
	textField_7.setColumns(10);
	textField_7.setBounds(158, 131, 161, 16);
	panel.add(textField_7);
	
	JTextField textField_8 = new JTextField();
	textField_8.setToolTipText("Hier Bitte die IBAN Adresse  eintragen");
	textField_8.setText(kunde.getIban());
	textField_8.setColumns(10);
	textField_8.setBounds(158, 151, 161, 16);
	panel.add(textField_8);
	
	JPasswordField textField_9= new JPasswordField();
	textField_9.setToolTipText("Hier Bitte das Passwort eingeben");
	textField_9.setText(kunde.getPasswort());
	textField_9.setColumns(10);
	textField_9.setBounds(158, 191, 161, 16);
	panel.add(textField_9);
	

	JPanel panel_1 = new JPanel();
	panel_1.setBounds(10, 228, 340, 43);
	getContentPane().add(panel_1);
	panel_1.setLayout(null);
	
	JButton btnAnnehmen = new JButton("Speichern");
	btnAnnehmen.addActionListener(new ActionListener() {

		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if(textField_2.getText() != kunde.getNachname()) {
				BestandskundenVerwaltung.BestandskundeStrg.aktualisiereNachname(textField_2.getText(),Integer.toString(kunde.getNutzernr()));
			}
			if(textField_3.getText() != kunde.getVorname()) {
				BestandskundenVerwaltung.BestandskundeStrg.aktualisiereVorname(textField_2.getText(),Integer.toString(kunde.getNutzernr()));
			}
			
			if(textField_4.getText() != kunde.getEmail()) {
				BestandskundenVerwaltung.BestandskundeStrg.aktualisiereEmail(textField_4.getText(),Integer.toString(kunde.getNutzernr()));
			}
			
			if(textField_5.getText() != kunde.getStraﬂe()) {
				BestandskundenVerwaltung.BestandskundeStrg.aktualisiereStraﬂe(textField_5.getText(),Integer.toString(kunde.getNutzernr()));
			}
			
			if(textField_6.getText() != kunde.getOrt()) {
				BestandskundenVerwaltung.BestandskundeStrg.aktualisiereOrt(textField_6.getText(),Integer.toString(kunde.getNutzernr()));
			}
			
			if(textField_7.getText() != String.valueOf(kunde.getPlz())) {
				BestandskundenVerwaltung.BestandskundeStrg.aktualisierePLZ(textField_7.getText(),Integer.toString(kunde.getNutzernr()));
			}
			
			if(textField_8.getText() != kunde.getIban()) {
				BestandskundenVerwaltung.BestandskundeStrg.aktualisiereIBAN(textField_8.getText(),Integer.toString(kunde.getNutzernr()));
			}
			
			if(textField_9.getText() != kunde.getPasswort()) {
				BestandskundenVerwaltung.BestandskundeStrg.aktualisierePasswort(textField_9.getText(),Integer.toString(kunde.getNutzernr()));
			}
			
			JOptionPane.showOptionDialog(null, "Datensatz wurde bearbeitet","Bestandskunden Bearbeitung",
	                JOptionPane.YES_NO_CANCEL_OPTION,
	                JOptionPane.WARNING_MESSAGE, null, 
	                new String[]{"Ok"}, "Ok");  
			
			String nutzernr =textField.getText();
			String nachname = textField_2.getText();
			String vorname = textField_3.getText();
			String email = textField_4.getText();
			String straﬂe = textField_5.getText();
			String ort = textField_6.getText();
			String plz = textField_7.getText();
			String iban = textField_8.getText();
			String passwort = textField_9.getText();
			
		
			Bestandskunde kunde = new Bestandskunde(Integer.parseInt(nutzernr), nachname, vorname, email, straﬂe, ort,Integer.parseInt( plz), iban,  Integer.parseInt(berechtigung), passwort, Integer.parseInt(pss));
			
			dispose();
			
		}
	
	});
	
	btnAnnehmen.setBounds(35, 11, 106, 23);
	panel_1.add(btnAnnehmen);
	
	JButton btnAbbrechen = new JButton("Abbrechen");
	btnAbbrechen.setBounds(169, 11, 106, 23);
	btnAbbrechen.addActionListener(new ActionListener() {
		
		
		public void actionPerformed(ActionEvent arg0) {
			
			dispose();				
		}
		
		
	});
	panel_1.add(btnAbbrechen);
	setVisible(true);
	
}

	public static void main(String[]args) {
		int nutzernr = 200000001;
		new GUIBestandskundeBearbeiten(nutzernr);
	}


}

