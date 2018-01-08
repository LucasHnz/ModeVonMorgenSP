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

import Bestellverwaltung.BestellStrg;
import KundenVerwaltung.Bestandskunde;
import KundenVerwaltung.Gastkunde;
import KundenVerwaltung.GastkundenStrg;
import Logverwaltung.LogStrg;
import MitarbeiterVerwaltung.Mitarbeiter;

import Warenkorbverwaltung.Warenkorb;



public class GUIGastkundeErstellen  {
	/**
	 * @author annag
	 */
	
	private static JPanel panelmain;
	
	/**
	 * Anmeldemaske für GK
	 * @return 
	 * 
	 */
	public  static JPanel getGUIGastkundeErstellen()  {
		
		panelmain = new JPanel();
		panelmain.setBounds(0, 0, 1250, 750);
		
		panelmain.setLayout(null);
		 
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 13, 340, 231);
		panelmain.add(panel);
		panel.setLayout(null);
		panel.setVisible(true);
		
		  NumberFormat plzformat = NumberFormat.getNumberInstance(); 
	        plzformat.setGroupingUsed(false); 
	        plzformat.setMaximumIntegerDigits(5);
	        plzformat.setMinimumIntegerDigits(1);
	        NumberFormatter plzformatter = new NumberFormatter(plzformat);
		
		JLabel lblGastkundenNummer = new JLabel("Gastkunden Nummer:");
		lblGastkundenNummer.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGastkundenNummer.setBounds(10, 6, 126, 16);
		panel.add(lblGastkundenNummer);
		
		
		
		JLabel lblNachname = new JLabel("Nachname:");
		lblNachname.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNachname.setBounds(10, 50, 126, 16);
		panel.add(lblNachname);
		
		JLabel lblVorname = new JLabel("Vorname:");
		lblVorname.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVorname.setBounds(10, 70, 126, 16);
		panel.add(lblVorname);
		
		JLabel lblEmailAdresse = new JLabel("E-Mail Adresse:");
		lblEmailAdresse.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmailAdresse.setBounds(10, 90, 126, 16);
		panel.add(lblEmailAdresse);
		
		JLabel lblStrae = new JLabel("Straße:");
		lblStrae.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStrae.setBounds(10, 110, 126, 16);
		panel.add(lblStrae);
		
		JLabel lblOrt = new JLabel("Ort:");
		lblOrt.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOrt.setBounds(10, 130, 126, 16);
		panel.add(lblOrt);
		
		JLabel lblPlz = new JLabel("PLZ:");
		lblPlz.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPlz.setBounds(10, 150, 126, 16);
		panel.add(lblPlz);
		
		JLabel lblIban = new JLabel("Iban:");
		lblIban.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIban.setBounds(10, 170, 126, 16);
		panel.add(lblIban);
		
		JFormattedTextField textField1 = new JFormattedTextField();
		textField1.setToolTipText("Die Gastkundennummer wurde autogeneriert");
		textField1.setText(String.valueOf(Datenbankverwaltung.holeNächsteNummer.nächsteGKundenNr()));
		textField1.setEditable(false);
		textField1.setBounds(158, 30, 161, 23);
		panel.add(textField1);
		textField1.setColumns(10);
		
		JTextField textField_2 = new JTextField();
		textField_2.setToolTipText("Hier Bitte den Nach-Namen eintragen");
		textField_2.setColumns(10);
		textField_2.setBounds(158, 50, 161, 23);
		panel.add(textField_2);
		
		JTextField textField_3 = new JTextField();
		textField_3.setToolTipText("Hier Bitte den Vor-Namen eintragen");
		textField_3.setColumns(10);
		textField_3.setBounds(158, 70, 161, 23);
		panel.add(textField_3);
		
		JTextField textField_4 = new JTextField();
		textField_4.setToolTipText("Hier Bitte die EMail eintragen");
		textField_4.setColumns(10);
		textField_4.setBounds(158, 90, 161, 23);
		panel.add(textField_4);
		
		JTextField textField_5 = new JTextField();
		textField_5.setToolTipText("Hier Bitte die Straße eintragen");
		textField_5.setColumns(10);
		textField_5.setBounds(158, 110, 161, 23);
		panel.add(textField_5);
		
		JTextField textField_6 = new JTextField();
		textField_6.setToolTipText("Hier Bitte den Wohnort eintragen");
		textField_6.setColumns(10);
		textField_6.setBounds(158, 130, 161, 23);
		panel.add(textField_6);
		
		plzformatter.setAllowsInvalid(false);
		JFormattedTextField textField_7 = new JFormattedTextField(plzformatter);
		textField_7.setToolTipText("Hier Bitte die PLZ des Wohnorts eintragen");
		textField_7.setColumns(10);
		textField_7.setBounds(158, 150, 161, 23);
		panel.add(textField_7);
		
		JTextField textField_8= new JTextField();
		textField_8.setToolTipText("Hier Bitte die Iban eintragen");
		textField_8.setColumns(10);
		textField_8.setBounds(158, 170, 161, 23);
		panel.add(textField_8);
		

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 231, 340, 44);
		panelmain.add(panel_1);
		panel_1.setLayout(null);
		
		
		
		/**
		 * Button hinzufügen aktzeptiert die Eingabe
		 */
		JButton btnBestellen = new JButton("Bestellen");
		btnBestellen.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String nutzernr =textField1.getText();
				String nachname = textField_2.getText();
				String vorname = textField_3.getText();
				String email = textField_4.getText();
				String straße = textField_5.getText();
				String ort = textField_6.getText();
				String plz = textField_7.getText();
				String berechtigung = "1";
				String iban= textField_8.getText();
				
				
				KundenVerwaltung.GastkundenStrg.hinzufügenGK(nutzernr, nachname, vorname, email, straße, ort, plz, berechtigung,iban);
				System.out.println(nutzernr);
				textField1.setText(String.valueOf(Datenbankverwaltung.holeNächsteNummer.nächsteGKundenNr()));
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				
				JOptionPane.showOptionDialog(null, "Gastkunde erstellt. ","Bestätigung",
		                JOptionPane.YES_NO_CANCEL_OPTION,
		                JOptionPane.INFORMATION_MESSAGE, null, 
		                new String[]{"Ok"}, "Ok"); 
				
				
				//LogStrg.setAnmeldeStatus(1);
				
				BestellStrg.erstelleBestellungGK(nutzernr);  //Methode fixen 
				
				MailController.MailSenden.sendMail(email,"Bestätigung ihrer Bestellung","Sehr geehrter Kunde, Vielen Dank für ihre Bestellung. Ihre Bestellung wird in Kürze bearbeitet und in 5-7 Werktagen versand. ");
				GUI.getFenster().changePanel(GUIHomepage.getHomepage()); 
				;
			}
			
		});
		btnBestellen.setBounds(52, 11, 108, 23);
		panel_1.add(btnBestellen);
		panelmain.setVisible(true);
	

	JButton btnAbbrechen = new JButton("Abbrechen");
	btnAbbrechen.setBounds(169, 11, 106, 23);
	btnAbbrechen.addActionListener(new ActionListener() {
		
		
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(null,
				    "Vorgang wurde abgebrochen",
				    "Abbruch",
				    JOptionPane.ERROR_MESSAGE);
				GUI.getFenster().changePanel(GUIWarenkorb.getGUIWarenkorb());
		}
		
		
	});
	panel_1.add(btnAbbrechen);
	panelmain.setVisible(true);
	
	return panelmain;
	
	}
	
	
	public static void main (String[]args) throws SQLException {
		new GUIGastkundeErstellen();
	}
}
