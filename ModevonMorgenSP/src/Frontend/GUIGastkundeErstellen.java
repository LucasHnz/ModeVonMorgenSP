package Frontend;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import Backend.TextDoc;
import Bestellverwaltung.BestellStrg;




public class GUIGastkundeErstellen extends JPanel {
	/**
	 * @author annag
	 */
	
	
	
	/**
	 * Anmeldemaske f�r GK
	 * @return 
	 * 
	 */
	public  GUIGastkundeErstellen()  {
		
		setBounds(0, 0, 1248, 563);
		setLayout(null);
		 
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
	
		JLabel lblStra�e = new JLabel("Stra�e:");
		lblStra�e.setFont(new Font("Calibri", Font.BOLD, 14));
		lblStra�e.setBounds(460, 231, 145, 33);
		add(lblStra�e);
	
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
		
		
		JFormattedTextField textField = new JFormattedTextField();
		textField.setToolTipText("Die Gastkundennummer wurde autogeneriert");
		textField.setText(String.valueOf(Datenbankverwaltung.holeN�chsteNummer.n�chsteGKundenNr()));
		textField.setEditable(false);
		textField.setBounds(650, 55, 161, 33); 
		add(textField);
		textField.setColumns(10);
		
		JTextField textField_Nachname = new JTextField();
		textField_Nachname.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField_Nachname.setToolTipText("Hier Bitte den Nach-Namen eintragen");
		textField_Nachname.setDocument(new TextDoc(26));
		textField_Nachname.setColumns(10);
		textField_Nachname.setBounds(650, 99, 161, 33);
		add(textField_Nachname);
		
		JTextField textField_Vorname = new JTextField();
		textField_Vorname.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField_Vorname.setToolTipText("Hier Bitte den Vor-Namen eintragen");
		textField_Vorname.setDocument(new TextDoc(26));
		textField_Vorname.setColumns(10);
		textField_Vorname.setBounds(650, 143, 161, 33);
		add(textField_Vorname);
		
		JTextField textField_Mail = new JTextField();
		textField_Mail.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField_Mail.setToolTipText("Hier Bitte die EMail eintragen");
		textField_Mail.setDocument(new TextDoc(51));
		textField_Mail.setColumns(10);
		textField_Mail.setBounds(650, 187, 161, 33);
		add(textField_Mail);
		
		JTextField textField_Stra�e = new JTextField();
		textField_Stra�e.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField_Stra�e.setToolTipText("Hier Bitte die Stra�e eintragen");
		textField_Stra�e.setDocument(new TextDoc(36));
		textField_Stra�e.setColumns(10);
		textField_Stra�e.setBounds(650, 231, 161, 33);
		add(textField_Stra�e);
		
		JTextField textField_Ort = new JTextField();
		textField_Ort.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField_Ort.setToolTipText("Hier Bitte den Wohnort eintragen");
		textField_Ort.setDocument(new TextDoc(26));
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
		textField_PLZ.setColumns(10);
		textField_PLZ.setBounds(650, 319, 161, 33);
		add(textField_PLZ);
		
		JTextField textField_IBAN = new JTextField();
		textField_IBAN.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField_IBAN.setToolTipText("Hier Bitte die IBAN Adresse  eintragen");
		textField_IBAN.setDocument(new TextDoc(26));
		textField_IBAN.setColumns(10);
		textField_IBAN.setBounds(650, 363, 161, 33);
		add(textField_IBAN);
		
		
		
		/**
		 * Button hinzuf�gen aktzeptiert die Eingabe
		 */
		JButton btnBestellen = new JButton("Registrieren");
		btnBestellen.setFont(new Font("Calibri", Font.BOLD, 14));
		btnBestellen.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String nutzernr= textField.getText();
				String nachname = textField_Nachname.getText();
				String vorname = textField_Vorname.getText();
				String email = textField_Mail.getText();
				String stra�e = textField_Stra�e.getText();
				String ort = textField_Ort.getText();
				String plz = textField_PLZ.getText();
				String iban= textField_IBAN.getText();
				String berechtigung = "1";
				
				
				KundenVerwaltung.GastkundenStrg.hinzuf�genGK(nutzernr, nachname, vorname, email, stra�e, ort, plz, berechtigung,iban);
				System.out.println(nutzernr);
				textField.setText(String.valueOf(Datenbankverwaltung.holeN�chsteNummer.n�chsteGKundenNr()));
				textField_Nachname.setText("");
				textField_Vorname.setText("");
				textField_Mail.setText("");
				textField_Stra�e.setText("");
				textField_Ort.setText("");
				textField_PLZ.setText("");
				textField_IBAN.setText("");
				
				
				JOptionPane.showOptionDialog(null, "Gastkunde erstellt. ","Best�tigung",
		                JOptionPane.YES_NO_CANCEL_OPTION,
		                JOptionPane.INFORMATION_MESSAGE, null, 
		                new String[]{"Ok"}, "Ok"); 
				
				int nutzernr2=Integer.parseInt(nutzernr);	
				System.out.println("Nutzernr="+nutzernr2);
				BestellStrg.erstelleBestellungGK(nutzernr2);  //Methode fixen ; muss irgendwie angemeldet bleiben
				
				MailController.MailSenden.sendMail(email,"Best�tigung ihrer Bestellung","Sehr geehrter Kunde, Vielen Dank f�r ihre Bestellung. Ihre Bestellung wird in K�rze bearbeitet und in 5-7 Werktagen versand. ");
				GUI.getFenster().changePanel(GUIHomepage.getHomepage()); 
				;
			}
			
		});
		btnBestellen.setBounds(650, 476, 161, 40);
		add(btnBestellen);
		
		
	
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setFont(new Font("Calibri", Font.BOLD, 14));
		btnAbbrechen.setBounds(460, 476, 145, 40);
		btnAbbrechen.addActionListener(new ActionListener() {
		
		
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(null,
				    "Vorgang wurde abgebrochen",
				    "Abbruch",
				    JOptionPane.ERROR_MESSAGE);
			GUI.getFenster().changePanel(GUIWarenkorb.getGUIWarenkorb());					
		}	
	});
	add(btnAbbrechen);
	setVisible(true);
	}
	
	
	public static void main (String[]args) throws SQLException {
		new GUIGastkundeErstellen();
	}
}
