package Frontend;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import KundenVerwaltung.Bestandskunde;
import KundenVerwaltung.Gastkunde;
import MitarbeiterVerwaltung.Mitarbeiter;

import Warenkorbverwaltung.Warenkorb;



public class GUIGastkundeErstellen extends JFrame {
	
	private static final long serialVersionUID = 1L;

	
	/**
	 * Erstell ein Pop Up Fenster um einen Gastkunden zu erstellen
	 * @throws SQLException
	 */
	public GUIGastkundeErstellen() throws SQLException {
		
		setBounds(200, 100, 365, 315);
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Gastkunde erstellen Formular");
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 340, 231);
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(true);
		
		JLabel lblGastkundenNummer = new JLabel("Gastkunden Nummer:");
		lblGastkundenNummer.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGastkundenNummer.setBounds(10, 10, 126, 16);
		panel.add(lblGastkundenNummer);
		
		
		
		JLabel lblNachname = new JLabel("Nachname:");
		lblNachname.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNachname.setBounds(10, 50, 126, 16);
		panel.add(lblNachname);
		
		JLabel lblVorname = new JLabel("Vorname:");
		lblVorname.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVorname.setBounds(210, 70, 126, 16);
		panel.add(lblVorname);
		
		JLabel lblEmailAdresse = new JLabel("E-Mail Adresse:");
		lblEmailAdresse.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmailAdresse.setBounds(10, 90, 126, 16);
		panel.add(lblEmailAdresse);
		
		JLabel lblStrae = new JLabel("Stra�e:");
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
		lblIban.setBounds(10, 150, 126, 16);
		panel.add(lblIban);
		
		
		JTextField textField1 = new JTextField();
		textField1.setToolTipText("Die Gastkunden Nummer wurde autogeneriert");
		textField1.setText(String.valueOf(Datenbankverwaltung.holeN�chsteNummer.n�chsteGKundenNr()));
		textField1.setEditable(false);
		textField1.setBounds(169, 10, 161, 23);
		panel.add(textField1);
		textField1.setColumns(10);
		
		JTextField textField_2 = new JTextField();
		textField_2.setToolTipText("Hier Bitte den Nach-Namen eintragen");
		textField_2.setColumns(10);
		textField_2.setBounds(158, 50, 161, 16);
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
		textField_5.setToolTipText("Hier Bitte die Stra�e eintragen");
		textField_5.setColumns(10);
		textField_5.setBounds(158, 110, 161, 23);
		panel.add(textField_5);
		
		JTextField textField_6 = new JTextField();
		textField_6.setToolTipText("Hier Bitte den Wohnort eintragen");
		textField_6.setColumns(10);
		textField_6.setBounds(158, 130, 161, 23);
		panel.add(textField_6);
		
		JTextField textField_7 = new JTextField();
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
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
		
		/**
		 * Button hinzuf�gen aktzeptiert die Eingabe
		 */
		JButton btnHinzufgen = new JButton("Hinzuf�gen");
		btnHinzufgen.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String nutzernr =textField1.getText();
				String nachname = textField_2.getText();
				String vorname = textField_3.getText();
				String email = textField_4.getText();
				String stra�e = textField_5.getText();
				String ort = textField_6.getText();
				String plz = textField_7.getText();
				String berechtigung = "1";
				String iban= textField_8.getText();
				
				
				KundenVerwaltung.GastkundenStrg.hinzuf�genGK(nutzernr, nachname, vorname, email, stra�e, ort, plz, berechtigung,iban);
				System.out.println(nutzernr);
				textField1.setText(String.valueOf(Datenbankverwaltung.holeN�chsteNummer.n�chsteGKundenNr()));
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				
				
				JOptionPane.showOptionDialog(null, "Datensatz wurde erstellt","Gastkunden Erstellung",
		                JOptionPane.YES_NO_CANCEL_OPTION,
		                JOptionPane.WARNING_MESSAGE, null, 
		                new String[]{"Ok"}, "Ok");
				dispose();
				new GUIDaten�berpr�fenGk();
			}
			
		});
		btnHinzufgen.setBounds(52, 11, 108, 23);
		panel_1.add(btnHinzufgen);
		setVisible(true);
	

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
	
	public static void main (String[]args) throws SQLException {
		new GUIGastkundeErstellen();
	}
}


