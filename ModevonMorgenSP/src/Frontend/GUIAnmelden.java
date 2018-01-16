package Frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Logverwaltung.LogStrg;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
/**
 * 
 * @author Hinz

 *
 */
public class GUIAnmelden {
	
	static JTextField anmeldenEmail = new JTextField();
	static JPasswordField anmeldenPasswort = new JPasswordField();
	public static JButton btnAnmeldenEinloggen = new JButton("Einloggen");
	static JButton btnAnmeldenAbbrechen = new JButton("Abbrechen");
	static String[] anmeldenCbList;
	public static JPanel panelAnmelden;
	
	/**
	 * Erstellt und liefert Anmeldefenster
	 * @return panelAnmelden Anmeldefenster
	 * @wbp.parser.entryPoint
	 */
	public static JPanel getGUIAnmelden() {
		panelAnmelden = new JPanel();
		panelAnmelden.setBorder(new LineBorder(new Color(51, 204, 255), 1, true));
		panelAnmelden.setBackground(Color.WHITE);
		panelAnmelden.setLayout(null);
		panelAnmelden.setBounds(1040, 0, 194, 118);
		panelAnmelden.setOpaque(true);
									
		
		btnAnmeldenEinloggen = new JButton("Einloggen");
		btnAnmeldenEinloggen.setFont(new Font("Dialog", Font.BOLD, 11));
		btnAnmeldenEinloggen.setBounds(2, 93, 95, 23);
		panelAnmelden.add(btnAnmeldenEinloggen);
		btnAnmeldenEinloggen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				  String pwd = new String(anmeldenPasswort.getPassword());
				  String email = anmeldenEmail.getText();					  
				  LogStrg.anmelden(pwd, email);
					
			}
				
		});
			
		btnAnmeldenAbbrechen = new JButton("Abbrechen");
		btnAnmeldenAbbrechen.setFont(new Font("Dialog", Font.BOLD, 11));
		btnAnmeldenAbbrechen.setBounds(97, 93, 95, 23);
		btnAnmeldenAbbrechen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUI.getFenster().removeLogPanel();
			}
				
		});
		panelAnmelden.add(btnAnmeldenAbbrechen);
		anmeldenEmail = new JTextField();
		anmeldenEmail.setFont(new Font("Dialog", Font.PLAIN, 11));
		anmeldenEmail.setToolTipText("Email Adresse");
		anmeldenEmail.setBounds(10, 11, 174, 28);
		panelAnmelden.add(anmeldenEmail);
		anmeldenEmail.setColumns(10);
			
		anmeldenPasswort = new JPasswordField();
		anmeldenPasswort.setFont(new Font("Dialog", Font.PLAIN, 11));
		anmeldenPasswort.setToolTipText("Passwort");
		anmeldenPasswort.setBounds(10, 45, 174, 28);
		panelAnmelden.add(anmeldenPasswort);
			
		panelAnmelden.setVisible(true);
		return panelAnmelden;
	}
		
}
