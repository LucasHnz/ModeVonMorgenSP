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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
	
	public GUIMitarbeiterBearbeiten() throws SQLException {
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
			}
		});
		btnNewButton.setBounds(31, 11, 126, 23);
		panel_1.add(btnNewButton);
		
		JButton button = new JButton("Abbrechen");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(189, 11, 126, 23);
		panel_1.add(button);
		

		setVisible(true);
		
	}

}
