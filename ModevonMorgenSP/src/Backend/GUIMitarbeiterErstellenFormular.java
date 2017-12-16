package Backend;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;

import MitarbeiterVerwaltung.Mitarbeiter;

import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class GUIMitarbeiterErstellenFormular extends JFrame{
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
	
	public GUIMitarbeiterErstellenFormular() throws SQLException {
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
		textField.setText(String.valueOf(Datenbankverwaltung.holeN‰chsteNummer.n‰chsteMaNr()));
		textField.setEditable(false);
		textField.setBounds(169, 10, 161, 16);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("Hier Bitte den Nach-Namen eintragen");
		textField_2.setColumns(10);
		textField_2.setBounds(169, 50, 161, 16);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("Hier Bitte den Vor-Namen eintragen");
		textField_3.setColumns(10);
		textField_3.setBounds(169, 70, 161, 16);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("Hier Bitte die EMail eintragen");
		textField_4.setColumns(10);
		textField_4.setBounds(169, 90, 161, 16);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setToolTipText("Hier Bitte die Straﬂe eintragen");
		textField_5.setColumns(10);
		textField_5.setBounds(169, 110, 161, 16);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setToolTipText("Hier Bitte den Wohnort eintragen");
		textField_6.setColumns(10);
		textField_6.setBounds(169, 130, 161, 16);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setToolTipText("Hier Bitte die PLZ des Wohnorts eintragen");
		textField_7.setColumns(10);
		textField_7.setBounds(169, 150, 161, 16);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField.setToolTipText("Hier Bitte die IBAN Adresse des Mitarbeiters eintragen");
		textField_8.setColumns(10);
		textField_8.setBounds(169, 170, 161, 16);
		panel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setToolTipText("Hier bitte das Gehalt eintragen");
		textField_9.setColumns(10);
		textField_9.setBounds(169, 190, 161, 16);
		panel.add(textField_9);
		
		textField_10 = new JPasswordField();
		textField_10.setToolTipText("Hier Bitte das Passwort eingeben");
		textField_10.setColumns(10);
		textField_10.setBounds(169, 210, 161, 16);
		panel.add(textField_10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(169, 30, 161, 16);
		
		ResultSet rs = Datenbankverwaltung.HoleAlleNummernAdmin.AdminNummern();
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
		
		//Button Abbrechen
		JButton btnNewButton = new JButton("Abbrechen");
		btnNewButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();				
			}
			
			
		});
		btnNewButton.setBounds(185, 11, 110, 23);
		panel_1.add(btnNewButton);
		
		//Button Hinzuf¸gen
		JButton btnHinzufgen = new JButton("Hinzuf\u00FCgen");
		btnHinzufgen.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				
				String nutzernr =textField.getText();
				String adminnr = String.valueOf(comboBox.getSelectedIndex());
				String nachname = textField_2.getText();
				String vorname = textField_3.getText();
				String email = textField_4.getText();
				String straﬂe = textField_5.getText();
				String ort = textField_6.getText();
				String plz = textField_7.getText();
				String iban = textField_8.getText();
				String gehalt = textField_9.getText();
				String berechtigung = "3";
				String passwort = textField_10.getText();
				
				MitarbeiterVerwaltung.MitarbeiterStrg.hinzuf¸genMA(nutzernr, adminnr, nachname, vorname, email, straﬂe, ort, plz, iban, gehalt, berechtigung, passwort);
				
				/*try {
					
					Connection con = Datenbankverwaltung.VerbindungDB.erstelleConnection();
					
					Statement stmt = con.createStatement();
					
					String sqlbefehl = "insert into Mitarbeiter values ('"+nutzernr+"','"+adminnr+"','"+nachname+"','"+vorname+"','"+email+"','"+straﬂe+"','"+ort+"','"+plz+"','"+iban+"','"+gehalt+"','"+berechtigung+"','"+passwort+"')";
					
					stmt.executeQuery(sqlbefehl);
					
					Datenbankverwaltung.VerbindungDB.schlieﬂeVerbindung(con, stmt);
					
					
				}catch (SQLException e2) {
					e2.getMessage();
				}*/
				textField.setText(String.valueOf(Datenbankverwaltung.holeN‰chsteNummer.n‰chsteMaNr()));
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				textField_9.setText("");
				textField_10.setText("");
			}
			
		});
		btnHinzufgen.setBounds(52, 11, 108, 23);
		panel_1.add(btnHinzufgen);
		setVisible(true);
		
	}
	
	public static void main (String[]args) throws SQLException {
		new GUIMitarbeiterErstellenFormular();
	}
}
