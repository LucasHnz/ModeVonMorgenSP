package Backend;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
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

import AdministratorVerwaltung.AdministratorSammlung;

/**
 * 
 * @author julian
 *
 */
public class GUIAdministratorErstellenFormular extends JFrame {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Erstell ein Pop Up Fenster um einen Administrator zu Erstellen
	 * @throws SQLException
	 */
	public GUIAdministratorErstellenFormular() throws SQLException {
		setBounds(200, 100, 366, 312);
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Administrator Erstellen Formular");
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 340, 218);
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(true);
		
		NumberFormat gehaltformat = NumberFormat.getNumberInstance(); 
		gehaltformat.setGroupingUsed(false); 
		gehaltformat.setMaximumIntegerDigits(8);
		gehaltformat.setMinimumIntegerDigits(1);
		gehaltformat.setMaximumFractionDigits(2);
		gehaltformat.setMinimumFractionDigits(2);
        NumberFormatter gehaltformatter = new NumberFormatter(gehaltformat);
        
        NumberFormat plzformat = NumberFormat.getNumberInstance(); 
        plzformat.setGroupingUsed(false); 
        plzformat.setMaximumIntegerDigits(5);
        plzformat.setMinimumIntegerDigits(1);
        NumberFormatter plzformatter = new NumberFormatter(plzformat);
		
		JLabel lblMitarbeiterNummer = new JLabel("Administrator Nummer:");
		lblMitarbeiterNummer.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMitarbeiterNummer.setBounds(21, 12, 138, 16);
		panel.add(lblMitarbeiterNummer);
		
		JLabel lblNachname = new JLabel("Nachname:");
		lblNachname.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNachname.setBounds(21, 32, 126, 16);
		panel.add(lblNachname);
		
		JLabel lblVorname = new JLabel("Vorname:");
		lblVorname.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVorname.setBounds(21, 52, 126, 16);
		panel.add(lblVorname);
		
		JLabel lblEmailAdresse = new JLabel("E-Mail Adresse:");
		lblEmailAdresse.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmailAdresse.setBounds(21, 72, 126, 16);
		panel.add(lblEmailAdresse);
		
		JLabel lblStrae = new JLabel("Stra\u00DFe:");
		lblStrae.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStrae.setBounds(21, 92, 126, 16);
		panel.add(lblStrae);
		
		JLabel lblOrt = new JLabel("Ort:");
		lblOrt.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOrt.setBounds(21, 112, 126, 16);
		panel.add(lblOrt);
		
		JLabel lblPlz = new JLabel("PLZ:");
		lblPlz.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPlz.setBounds(21, 132, 126, 16);
		panel.add(lblPlz);
		
		JLabel lblIban = new JLabel("IBAN:");
		lblIban.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIban.setBounds(21, 152, 126, 16);
		panel.add(lblIban);
		
		JLabel lblGehalt = new JLabel("Gehalt:");
		lblGehalt.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGehalt.setBounds(21, 172, 126, 16);
		panel.add(lblGehalt);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPasswort.setBounds(21, 192, 126, 16);
		panel.add(lblPasswort);
		
		JTextField textField = new JTextField();
		textField.setToolTipText("Die Admin Nummer wurde autogeneriert");
		textField.setText(String.valueOf(Datenbankverwaltung.holeNächsteNummer.nächsteAdminNr()));
		textField.setEditable(false);
		textField.setBounds(169, 12, 161, 23);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextField textField_2 = new JTextField();
		textField_2.setToolTipText("Hier Bitte den Nach-Namen eintragen");
		textField_2.setDocument(new TextDoc(26));
		textField_2.setColumns(10);
		textField_2.setBounds(169, 32, 161, 23);
		panel.add(textField_2);
		
		JTextField textField_3 = new JTextField();
		textField_3.setToolTipText("Hier Bitte den Vor-Namen eintragen");
		textField_3.setDocument(new TextDoc(26));
		textField_3.setColumns(10);
		textField_3.setBounds(169, 52, 161, 23);
		panel.add(textField_3);
		
		JTextField textField_4 = new JTextField();
		textField_4.setToolTipText("Hier Bitte die EMail eintragen");
		textField_4.setDocument(new TextDoc(51));
		textField_4.setColumns(10);
		textField_4.setBounds(169, 72, 161, 23);
		panel.add(textField_4);
		
		JTextField textField_5 = new JTextField();
		textField_5.setToolTipText("Hier Bitte die Straße eintragen");
		textField_5.setDocument(new TextDoc(36));
		textField_5.setColumns(10);
		textField_5.setBounds(169, 92, 161, 23);
		panel.add(textField_5);
		
		JTextField textField_6 = new JTextField();
		textField_6.setToolTipText("Hier Bitte den Wohnort eintragen");
		textField_6.setDocument(new TextDoc(26));
		textField_6.setColumns(10);
		textField_6.setBounds(169, 112, 161, 23);
		panel.add(textField_6);
		
		JFormattedTextField textField_7 = new JFormattedTextField(plzformatter);
		plzformatter.setAllowsInvalid(false);
		textField_7.setToolTipText("Hier Bitte die PLZ des Wohnorts eintragen");
		textField_7.setColumns(10);
		textField_7.setBounds(169, 132, 161, 23);
		panel.add(textField_7);
		
		JTextField textField_8 = new JTextField();
		textField.setToolTipText("Hier Bitte die IBAN Adresse des Mitarbeiters eintragen");
		textField_8.setDocument(new TextDoc(26));
		textField_8.setColumns(10);
		textField_8.setBounds(169, 152, 161, 23);
		panel.add(textField_8);
		
		JFormattedTextField textField_9 = new JFormattedTextField(gehaltformatter);
		gehaltformatter.setAllowsInvalid(false);
		textField_9.setToolTipText("Hier bitte das Gehalt eintragen");
		textField_9.setColumns(10);
		textField_9.setBounds(169, 172, 161, 23);
		panel.add(textField_9);
		
		JPasswordField textField_10 = new JPasswordField();
		textField_10.setToolTipText("Hier Bitte das Passwort eingeben");
		textField_10.setDocument(new TextDoc(16));
		textField_10.setColumns(10);
		textField_10.setBounds(169, 192, 161, 23);
		panel.add(textField_10);
		

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 228, 340, 43);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		//Button Abbrechen
		JButton btnNewButton = new JButton("Abbrechen");
		btnNewButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();				
			}
			
			
		});
		btnNewButton.setBounds(174, 12, 110, 23);
		panel_1.add(btnNewButton);
		
		//Button Hinzufügen
		JButton btnHinzufgen = new JButton("Hinzuf\u00FCgen");
		btnHinzufgen.addActionListener(new ActionListener() {

			
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				String nutzernr =textField.getText();
				String nachname = textField_2.getText();
				String vorname = textField_3.getText();
				String email = textField_4.getText();
				String straße = textField_5.getText();
				String ort = textField_6.getText();
				String plz = textField_7.getText();
				String iban = textField_8.getText();
				String gehalt = textField_9.getText();
				String berechtigung = "4";
				String passwort = textField_10.getText();
				
				//AdministratorSammlung.hinzufügenAdmin(Integer.parseInt(nutzernr), nachname, vorname, email, straße, ort,Integer.parseInt( plz), iban, Integer.parseInt(gehalt), Integer.parseInt(berechtigung), passwort);
				AdministratorVerwaltung.AdministratorStrg.hinzufügenAdmin(nutzernr, nachname, vorname, email, straße, ort, plz, iban, gehalt, berechtigung, passwort);
				System.out.println(nutzernr);
				textField.setText(String.valueOf(Datenbankverwaltung.holeNächsteNummer.nächsteAdminNr()));
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				textField_9.setText("");
				textField_10.setText("");
				
				JOptionPane.showOptionDialog(null, "Datensatz wurde erstellt","Administrator Erstellung",
		                JOptionPane.YES_NO_CANCEL_OPTION,
		                JOptionPane.WARNING_MESSAGE, null, 
		                new String[]{"Ok"}, "Ok");
				
				dispose();
				
			}
			
		});
		btnHinzufgen.setBounds(39, 12, 108, 23);
		panel_1.add(btnHinzufgen);
		setVisible(true);
		
	}
	
	public static void main (String[]args) throws SQLException {
		new GUIAdministratorErstellenFormular();
	}
	
	

}
