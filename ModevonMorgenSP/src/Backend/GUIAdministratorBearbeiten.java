package Backend;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import AdministratorVerwaltung.Administrator;
import AdministratorVerwaltung.AdministratorSammlung;
import Datenbankverwaltung.VerbindungDB;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
/**
 * 
 * @author julian
 *
 */
public class GUIAdministratorBearbeiten extends JFrame {
	
	/**
	 * Erstell das GUI "Pop Up" Fenster um einen bestenhenden Admin zu bearbeiten
	 * @param nutzernr
	 */
	public GUIAdministratorBearbeiten(int nutzernr) {
		
		Administrator admin = Datenbankverwaltung.HoleDatenSatz.holeAdmin(nutzernr);
		
		System.out.println(admin.getNachname());
	
		
		setBounds(200, 100, 365, 299);
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Administrator Bearbeiten Formular");
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 340, 223);
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(true);
		
		NumberFormat gehaltformat = NumberFormat.getNumberInstance(); 
		gehaltformat.setGroupingUsed(false); 
		gehaltformat.setMaximumIntegerDigits(8);
		gehaltformat.setMinimumIntegerDigits(1);
        NumberFormatter gehaltformatter = new NumberFormatter(gehaltformat);
        
        NumberFormat plzformat = NumberFormat.getNumberInstance(); 
        plzformat.setGroupingUsed(false); 
        plzformat.setMaximumIntegerDigits(5);
        plzformat.setMinimumIntegerDigits(1);
        NumberFormatter plzformatter = new NumberFormatter(plzformat);
		
		JLabel lblMitarbeiterNummer = new JLabel("Administrator Nummer:");
		lblMitarbeiterNummer.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMitarbeiterNummer.setBounds(10, 11, 138, 16);
		panel.add(lblMitarbeiterNummer);
		
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
		
		JLabel lblStrae = new JLabel("Stra\u00DFe:");
		lblStrae.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStrae.setBounds(10, 91, 126, 16);
		panel.add(lblStrae);
		
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
		
		JLabel lblGehalt = new JLabel("Gehalt:");
		lblGehalt.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGehalt.setBounds(10, 174, 126, 16);
		panel.add(lblGehalt);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPasswort.setBounds(10, 194, 126, 16);
		panel.add(lblPasswort);
		
		JTextField textField = new JTextField();
		textField.setToolTipText("Die Admin Nummer wurde autogeneriert");
		textField.setText(String.valueOf(admin.getNutzernr()));
		textField.setEditable(false);
		textField.setBounds(158, 11, 161, 23);
		panel.add(textField);
		textField.setColumns(10);
		
		System.out.println(admin.getNachname());
		JTextField textField_2 = new JTextField();

		textField_2.setText(admin.getNachname());
		textField_2.setToolTipText("Hier Bitte den Nach-Namen eintragen");
		textField_2.setDocument(new TextDoc(26));
		textField_2.setText(admin.getNachname());
		textField_2.setColumns(10);
		textField_2.setBounds(158, 31, 161, 23);
		panel.add(textField_2);
		
		JTextField textField_3 = new JTextField();
		textField_3.setToolTipText("Hier Bitte den Vor-Namen eintragen");
		textField_3.setDocument(new TextDoc(26));
		textField_3.setText(admin.getVorname());
		textField_3.setColumns(10);
		textField_3.setBounds(158, 51, 161, 23);
		panel.add(textField_3);
		
		JTextField textField_4 = new JTextField();
		textField_4.setToolTipText("Hier Bitte die EMail eintragen");
		textField_4.setDocument(new TextDoc(51));
		textField_4.setText(admin.getEmail());
		textField_4.setColumns(10);
		textField_4.setBounds(158, 71, 161, 23);
		panel.add(textField_4);
		
		JTextField textField_5 = new JTextField();
		textField_5.setToolTipText("Hier Bitte die Straﬂe eintragen");
		textField_5.setDocument(new TextDoc(36));
		textField_5.setText(admin.getStraﬂe());
		textField_5.setColumns(10);
		textField_5.setBounds(158, 91, 161, 23);
		panel.add(textField_5);
		
		JTextField textField_6 = new JTextField();
		textField_6.setToolTipText("Hier Bitte den Wohnort eintragen");
		textField_6.setDocument(new TextDoc(26));
		textField_6.setText(admin.getOrt());
		textField_6.setColumns(10);
		textField_6.setBounds(158, 111, 161,23);
		panel.add(textField_6);
		
		JFormattedTextField textField_7 = new JFormattedTextField(plzformatter);
		plzformatter.setAllowsInvalid(false);
		textField_7.setToolTipText("Hier Bitte die PLZ des Wohnorts eintragen");
		textField_7.setText(String.valueOf(admin.getPlz()));
		textField_7.setColumns(10);
		textField_7.setBounds(158, 131, 161, 23);
		panel.add(textField_7);
		
		JTextField textField_8 = new JTextField();
		textField_8.setToolTipText("Hier Bitte die IBAN Adresse des Mitarbeiters eintragen");
		textField_8.setDocument(new TextDoc(26));
		textField_8.setText(admin.getIban());
		textField_8.setColumns(10);
		textField_8.setBounds(158, 151, 161, 23);
		panel.add(textField_8);
		
		JFormattedTextField textField_9 = new JFormattedTextField(gehaltformatter);
		gehaltformatter.setAllowsInvalid(false);
		textField_9.setToolTipText("Hier bitte das Gehalt eintragen");
		textField_9.setText(String.valueOf(admin.getGehalt()));
		textField_9.setColumns(10);
		textField_9.setBounds(158, 171, 161, 23);
		panel.add(textField_9);
		
		JPasswordField textField_10 = new JPasswordField();
		textField_10.setToolTipText("Hier Bitte das Passwort eingeben");
		textField_10.setDocument(new TextDoc(16));
		textField_10.setText(admin.getPasswort());
		textField_10.setColumns(10);
		textField_10.setBounds(158, 191, 161, 23);
		panel.add(textField_10);
		
	
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 231, 340, 44);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 270, 340, 34);
		panel_2.setVisible(false);
		getContentPane().add(panel_2);
		setVisible(true);
		panel_2.setLayout(null);
		JProgressBar progressBar = new JProgressBar(10,100);
		progressBar.setBounds(41, 5, 240, 18);
		panel_2.add(progressBar);
		
		JButton btnAnnehmen = new JButton("Annehmen");
		btnAnnehmen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				setBounds(200, 100, 365,  333);
				panel_2.setVisible(true);
				
				if(textField_2.getText() != admin.getNachname()) {
					AdministratorVerwaltung.AdministratorStrg.aktualisiereName(textField_2.getText(),admin.getNutzernr());
				}
				
				if(textField_4.getText() != admin.getVorname()) {
					AdministratorVerwaltung.AdministratorStrg.aktualisiereEmail(textField_4.getText(), admin.getNutzernr());
				}
				
				if(textField_5.getText() != admin.getStraﬂe()) {
					AdministratorVerwaltung.AdministratorStrg.aktualisiereStraﬂe(textField_5.getText(), admin.getNutzernr());
				}
				
				if(textField_6.getText() != admin.getOrt()) {
					AdministratorVerwaltung.AdministratorStrg.aktualisiereOrt(textField_6.getText(), admin.getNutzernr());
				}
				
				if(textField_7.getText() != String.valueOf(admin.getPlz())) {
					AdministratorVerwaltung.AdministratorStrg.aktualisierePLZ(textField_7.getText(), admin.getNutzernr());
				}
				
				if(textField_8.getText() != admin.getIban()) {
					AdministratorVerwaltung.AdministratorStrg.aktualisiereIBAN(textField_8.getText(), admin.getNutzernr());
				}
				
				if(textField_9.getText() != String.valueOf(admin.getGehalt())) {
					AdministratorVerwaltung.AdministratorStrg.aktualisiereGehalt(textField_9.getText(), admin.getNutzernr());
				}
				
				if(textField_10.getText() != admin.getPasswort()) {
					AdministratorVerwaltung.AdministratorStrg.aktualisierePasswort(textField_10.getText(), admin.getNutzernr());
				}
				
				Runnable runnable = new Runnable(){
					public void run(){
						
						for (int i = 0; i <= 100; i++) {
							
							if (i == 100) {
								JOptionPane.showOptionDialog(null, "Datensatz wurde erstellt","Administrator Erstellung",
						                JOptionPane.YES_NO_CANCEL_OPTION,
						                JOptionPane.WARNING_MESSAGE, null, 
						                new String[]{"Ok"}, "Ok");
									dispose();
							}
							
							try {
								Thread.sleep(10);
							} catch (InterruptedException ex) {
							}
							progressBar.setValue(i);
							progressBar.setStringPainted(true);

						}
					}
				};
				
				Thread t = new Thread(runnable);
				t.start();
				
		
				
				String nutzernr =textField.getText();
				String nachname = textField_2.getText();
				String vorname = textField_3.getText();
				String email = textField_4.getText();
				String straﬂe = textField_5.getText();
				String ort = textField_6.getText();
				String plz = textField_7.getText();
				String iban = textField_8.getText();
				String gehalt = textField_9.getText();
				String berechtigung = "4";
				String passwort = textField_10.getText();
				
				
				
				Administrator admin = new Administrator(Integer.parseInt(nutzernr), nachname, vorname, email, straﬂe, ort,Integer.parseInt( plz), iban, Integer.parseInt(gehalt), Integer.parseInt(berechtigung), passwort);
				//AdministratorSammlung.put(Integer.parseInt(nutzernr),admin);
				
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
	
	/**
	 * Test
	 * @param args
	 */
	public static void main(String[]args) {
		int nutzernr = 400000003;
		new GUIAdministratorBearbeiten(nutzernr);
	}
}
