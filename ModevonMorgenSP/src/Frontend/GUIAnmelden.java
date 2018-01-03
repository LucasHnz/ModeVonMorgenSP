package Frontend;

/**
 * 
 * @author Hinz
 *
 */

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Logverwaltung.LogStrg;

public class GUIAnmelden {
	
	static JTextField anmeldenEmail = new JTextField();
	static JPasswordField anmeldenPasswort = new JPasswordField();
	static JButton btnAnmeldenEinloggen = new JButton("Einloggen");
	static JButton btnAnmeldenAbbrechen = new JButton("Abbrechen");
	static String[] anmeldenCbList;
	public static JPanel panelAnmelden;
	
	public static JPanel getGUIAnmelden() {
		panelAnmelden = new JPanel();
		panelAnmelden.setLayout(null);
		panelAnmelden.setBounds(1040, 0, 194, 118);
		panelAnmelden.setOpaque(true);
									
		
		btnAnmeldenEinloggen = new JButton("Einloggen");
		btnAnmeldenEinloggen.setBounds(0, 95, 89, 23);
		panelAnmelden.add(btnAnmeldenEinloggen);
		btnAnmeldenEinloggen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				  String pwd = new String(anmeldenPasswort.getPassword());
				  String email = anmeldenEmail.getText();					  
				  LogStrg.anmelden(pwd, email);
				  GUI.removeLogPanel();
					
			}
				
		});
		//panelAnmelden.getRootPane().setDefaultButton(btnAnmeldenEinloggen);
			
		btnAnmeldenAbbrechen = new JButton("Abbrechen");
		btnAnmeldenAbbrechen.setBounds(105, 95, 89, 23);
		btnAnmeldenAbbrechen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelAnmelden.setVisible(false);
				GUI.removeLogPanel();
			}
				
		});
		panelAnmelden.add(btnAnmeldenAbbrechen);
		anmeldenEmail = new JTextField();
		anmeldenEmail.setToolTipText("Email Adresse");
		anmeldenEmail.setBounds(10, 11, 174, 28);
		panelAnmelden.add(anmeldenEmail);
		anmeldenEmail.setColumns(10);
			
		anmeldenPasswort = new JPasswordField();
		anmeldenPasswort.setToolTipText("Passwort");
		anmeldenPasswort.setBounds(10, 45, 174, 28);
		panelAnmelden.add(anmeldenPasswort);
			
		panelAnmelden.setVisible(true);
		return panelAnmelden;
	}
	
	
	public static void anmeldenFehlermeldung() {
		
		System.out.println("OPT");
		JOptionPane.showOptionDialog(null, "Dies ist ein Optionsdialog",
				"Optionsdialog",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.WARNING_MESSAGE,
				null,
				new String[] {"A", "B", "C"},"B");
		
	}
	
}
