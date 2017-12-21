package Backend;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import MitarbeiterVerwaltung.Mitarbeiter;
import MitarbeiterVerwaltung.MitarbeiterSammlung;

public class GUIMitarbeiterBearbeiten extends JFrame{
	
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private int[] AdminNummern;
	
	public GUIMitarbeiterBearbeiten(int nutzernr) throws SQLException {
		
		Mitarbeiter ma = Datenbankverwaltung.HoleDatenSatz.holeMitarbeiter(nutzernr);
		
		setBounds(200, 100, 365, 315);
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Mitarbeiter Erstellen Formular");
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 340, 231);
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(true);
		
		JLabel lblMitarbeiterNummer = new JLabel("Mitarbeiter Nummer:");
		lblMitarbeiterNummer.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMitarbeiterNummer.setBounds(21, 10, 126, 16);
		panel.add(lblMitarbeiterNummer);
		
		JLabel lblAdminNummer = new JLabel("Admin Nummer:");
		lblAdminNummer.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdminNummer.setBounds(21, 30, 126, 16);
		panel.add(lblAdminNummer);
		
		JLabel lblNachname = new JLabel("Nachname:");
		lblNachname.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNachname.setBounds(21, 50, 126, 16);
		panel.add(lblNachname);
		
		JLabel lblVorname = new JLabel("Vorname:");
		lblVorname.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVorname.setBounds(21, 70, 126, 16);
		panel.add(lblVorname);
		
		JLabel lblEmailAdresse = new JLabel("E-Mail Adresse:");
		lblEmailAdresse.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmailAdresse.setBounds(21, 90, 126, 16);
		panel.add(lblEmailAdresse);
		
		JLabel lblStrae = new JLabel("Stra\u00DFe:");
		lblStrae.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStrae.setBounds(21, 110, 126, 16);
		panel.add(lblStrae);
		
		JLabel lblOrt = new JLabel("Ort:");
		lblOrt.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOrt.setBounds(21, 130, 126, 16);
		panel.add(lblOrt);
		
		JLabel lblPlz = new JLabel("PLZ:");
		lblPlz.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPlz.setBounds(21, 150, 126, 16);
		panel.add(lblPlz);
		
		JLabel lblIban = new JLabel("IBAN:");
		lblIban.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIban.setBounds(21, 170, 126, 16);
		panel.add(lblIban);
		
		JLabel lblGehalt = new JLabel("Gehalt:");
		lblGehalt.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGehalt.setBounds(21, 190, 126, 16);
		panel.add(lblGehalt);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPasswort.setBounds(21, 210, 126, 16);
		panel.add(lblPasswort);
		
		textField = new JTextField();
		textField.setToolTipText("Die Mitarbeiter Nummer wurde autogeneriert");
		textField.setText(String.valueOf(ma.getNutzernr()));
		textField.setEditable(false);
		textField.setBounds(169, 10, 161, 16);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("Hier Bitte den Nach-Namen eintragen");
		textField_2.setText(ma.getNachname());
		textField_2.setColumns(10);
		textField_2.setBounds(169, 50, 161, 16);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("Hier Bitte den Vor-Namen eintragen");
		textField_3.setText(ma.getVorname());
		textField_3.setColumns(10);
		textField_3.setBounds(169, 70, 161, 16);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("Hier Bitte die EMail eintragen");
		textField_4.setText(ma.getEmail());
		textField_4.setColumns(10);
		textField_4.setBounds(169, 90, 161, 16);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setToolTipText("Hier Bitte die Straﬂe eintragen");
		textField_5.setText(ma.getStraﬂe());
		textField_5.setColumns(10);
		textField_5.setBounds(169, 110, 161, 16);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setToolTipText("Hier Bitte den Wohnort eintragen");
		textField_6.setText(ma.getOrt());
		textField_6.setColumns(10);
		textField_6.setBounds(169, 130, 161, 16);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setToolTipText("Hier Bitte die PLZ des Wohnorts eintragen");
		textField_7.setText(String.valueOf(ma.getPlz()));
		textField_7.setColumns(10);
		textField_7.setBounds(169, 150, 161, 16);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setToolTipText("Hier Bitte die IBAN Adresse des Mitarbeiters eintragen");
		textField_8.setText(ma.getIban());
		textField_8.setColumns(10);
		textField_8.setBounds(169, 170, 161, 16);
		panel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setToolTipText("Hier bitte das Gehalt eintragen");
		textField_9.setText(String.valueOf(ma.getGehalt()));
		textField_9.setColumns(10);
		textField_9.setBounds(169, 190, 161, 16);
		panel.add(textField_9);
		
		textField_10 = new JPasswordField();
		textField_10.setToolTipText("Hier Bitte das Passwort eingeben");
		textField_10.setText(ma.getPasswort());
		textField_10.setColumns(10);
		textField_10.setBounds(169, 210, 161, 16);
		panel.add(textField_10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(169, 30, 161, 16);
		
		ResultSet rs = Datenbankverwaltung.HoleDatenSatz.AdminNummern();
		while(rs.next()) {
			int i = rs.getInt("Nutzernr");
			comboBox.addItem(i);
		}
		rs.close();
		
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 241, 340, 46);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Annehmen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(textField_2.getText() != ma.getNachname()) {
				
					MitarbeiterVerwaltung.MitarbeiterStrg.aktualisiereName(textField_2.getText(),ma.getNutzernr());
				}
				
				if(textField_3.getText() != ma.getVorname()) {
					MitarbeiterVerwaltung.MitarbeiterStrg.aktualisiereVorname(textField_3.getText(), ma.getNutzernr());
				}
				
				if(textField_4.getText() != ma.getEmail()) {
					MitarbeiterVerwaltung.MitarbeiterStrg.aktualisiereEmail(textField_4.getText(), ma.getNutzernr());
					
				}
				
				if(textField_5.getText() != ma.getStraﬂe()) {
					MitarbeiterVerwaltung.MitarbeiterStrg.aktualisiereStraﬂe(textField_5.getText(), ma.getNutzernr());
				}
				
				if(textField_6.getText() !=ma.getOrt()) {
					MitarbeiterVerwaltung.MitarbeiterStrg.aktualisiereOrt(textField_6.getText(), ma.getNutzernr());
				}
				
				if(textField_7.getText() != String.valueOf(ma.getPlz())) {
					MitarbeiterVerwaltung.MitarbeiterStrg.aktualisierePLZ(textField_7.getText(), ma.getNutzernr());
				}
				
				if(textField_8.getText() != ma.getIban()) {
					MitarbeiterVerwaltung.MitarbeiterStrg.aktualisiereIBAN(textField_8.getText(), ma.getNutzernr());
				}
				
				if(textField_9.getText() != String.valueOf(ma.getGehalt())) {
					MitarbeiterVerwaltung.MitarbeiterStrg.aktualisiereGehalt(textField_9.getText(), ma.getNutzernr());
				}
				
				if(textField_10.getText() != ma.getPasswort()) {
					MitarbeiterVerwaltung.MitarbeiterStrg.aktualisierePasswort(textField_10.getText(), ma.getNutzernr());
				}
				
				JOptionPane.showOptionDialog(null, "Datensatz wurde bearbeitet","Mitarbeiter Bearbeitung",
		                JOptionPane.YES_NO_CANCEL_OPTION,
		                JOptionPane.WARNING_MESSAGE, null, 
		                new String[]{"Ok"}, "Ok");  
				
				dispose();
				
				
			}
		});
		btnNewButton.setBounds(31, 11, 126, 23);
		panel_1.add(btnNewButton);
		
		JButton button = new JButton("Abbrechen");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		button.setBounds(189, 11, 126, 23);
		panel_1.add(button);
		

		setVisible(true);
		
	}
	
	public static void main (String []args) throws SQLException {
		int i = 300000001;
		new GUIMitarbeiterBearbeiten(i);
	}

}
