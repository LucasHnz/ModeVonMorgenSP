package Backend;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import AdministratorVerwaltung.Administrator;
import Datenbankverwaltung.VerbindungDB;

import javax.swing.JButton;

public class GUIAdministratorBearbeiten extends JFrame {
	
	public GUIAdministratorBearbeiten(int nutzernr) {
		
		Administrator admin = Datenbankverwaltung.HoleDatenSatz.holeAdmin(nutzernr);
		
	
		
		setBounds(200, 100, 354, 298);
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Administrator Bearbeiten Formular");
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 340, 218);
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(true);
		
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
		lblGehalt.setBounds(10, 171, 126, 16);
		panel.add(lblGehalt);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPasswort.setBounds(10, 191, 126, 16);
		panel.add(lblPasswort);
		
		JTextField textField = new JTextField();
		textField.setToolTipText("Die Admin Nummer wurde autogeneriert");
		textField.setText(String.valueOf(admin.getNutzernr()));
		textField.setEditable(false);
		textField.setBounds(158, 11, 161, 16);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextField textField_2 = new JTextField();
		textField_2.setToolTipText("Hier Bitte den Nach-Namen eintragen");
		textField_2.setText(admin.getNachname());
		textField_2.setColumns(10);
		textField_2.setBounds(158, 31, 161, 16);
		panel.add(textField_2);
		
		JTextField textField_3 = new JTextField();
		textField_3.setToolTipText("Hier Bitte den Vor-Namen eintragen");
		textField_3.setText(admin.getVorname());
		textField_3.setColumns(10);
		textField_3.setBounds(158, 51, 161, 16);
		panel.add(textField_3);
		
		JTextField textField_4 = new JTextField();
		textField_4.setToolTipText("Hier Bitte die EMail eintragen");
		textField_4.setText(admin.getEmail());
		textField_4.setColumns(10);
		textField_4.setBounds(158, 71, 161, 16);
		panel.add(textField_4);
		
		JTextField textField_5 = new JTextField();
		textField_5.setToolTipText("Hier Bitte die Stra�e eintragen");
		textField_5.setText(admin.getStra�e());
		textField_5.setColumns(10);
		textField_5.setBounds(158, 91, 161, 16);
		panel.add(textField_5);
		
		JTextField textField_6 = new JTextField();
		textField_6.setToolTipText("Hier Bitte den Wohnort eintragen");
		textField_6.setText(admin.getOrt());
		textField_6.setColumns(10);
		textField_6.setBounds(158, 111, 161, 16);
		panel.add(textField_6);
		
		JTextField textField_7 = new JTextField();
		textField_7.setToolTipText("Hier Bitte die PLZ des Wohnorts eintragen");
		textField_7.setText(String.valueOf(admin.getPlz()));
		textField_7.setColumns(10);
		textField_7.setBounds(158, 131, 161, 16);
		panel.add(textField_7);
		
		JTextField textField_8 = new JTextField();
		textField_8.setToolTipText("Hier Bitte die IBAN Adresse des Mitarbeiters eintragen");
		textField_8.setText(admin.getIban());
		textField_8.setColumns(10);
		textField_8.setBounds(158, 151, 161, 16);
		panel.add(textField_8);
		
		JTextField textField_9 = new JTextField();
		textField_9.setToolTipText("Hier bitte das Gehalt eintragen");
		textField_9.setText(String.valueOf(admin.getGehalt()));
		textField_9.setColumns(10);
		textField_9.setBounds(158, 171, 161, 16);
		panel.add(textField_9);
		
		JPasswordField textField_10 = new JPasswordField();
		textField_10.setToolTipText("Hier Bitte das Passwort eingeben");
		textField_10.setText(admin.getPasswort());
		textField_10.setColumns(10);
		textField_10.setBounds(158, 191, 161, 16);
		panel.add(textField_10);
		

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 228, 340, 43);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAnnehmen = new JButton("Annehmen");
		btnAnnehmen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(textField_2.getText() != admin.getNachname()) {
					AdministratorVerwaltung.AdministratorStrg.aktualisiereName(textField_2.getText(),admin.getNutzernr());
				}
				
				if(textField_4.getText() != admin.getVorname()) {
					AdministratorVerwaltung.AdministratorStrg.aktualisiereEmail(textField_4.getText(), admin.getNutzernr());
				}
				
				if(textField_5.getText() != admin.getStra�e()) {
					AdministratorVerwaltung.AdministratorStrg.aktualisiereStra�e(textField_5.getText(), admin.getNutzernr());
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
				
				JOptionPane.showOptionDialog(null, "Datensatz wurde bearbeitet","Administrator Bearbeitung",
		                JOptionPane.YES_NO_CANCEL_OPTION,
		                JOptionPane.WARNING_MESSAGE, null, 
		                new String[]{"Ok"}, "Ok");  
				
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
		int nutzernr = 400000001;
		new GUIAdministratorBearbeiten(nutzernr);
	}
}