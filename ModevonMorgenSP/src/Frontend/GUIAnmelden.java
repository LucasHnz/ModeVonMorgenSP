package Frontend;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Logverwaltung.LogStrg;

public class GUIAnmelden implements ActionListener {
	
	JTextField anmeldenEmail = new JTextField();
	JPasswordField anmeldenPasswort = new JPasswordField();
	JButton btnAnmeldenEinloggen = new JButton("Einloggen");
	JButton btnAnmeldenAbbrechen = new JButton("Abbrechen");
	String[] anmeldenCbList;

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public GUIAnmelden() {
		initialize();
	}
	
	public GUIAnmelden(String[]anmeldenCbList) {
		this.anmeldenCbList = anmeldenCbList;
		System.out.println("Ausgeführt Anmelden");
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(1312, 320, 260, 90);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.setLayout(new GridLayout(3,2));
		
	    frame.add(new JLabel("Email"));
	    frame.add(anmeldenEmail);
	    frame.add(new JLabel("Passwort"));
	    frame.add(anmeldenPasswort);
	    frame.add(btnAnmeldenAbbrechen);
	    btnAnmeldenAbbrechen.setBackground(SystemColor.control);
	    btnAnmeldenAbbrechen.addActionListener(this);
	    frame.add(btnAnmeldenEinloggen);
	    btnAnmeldenEinloggen.setBackground(SystemColor.control);
	    btnAnmeldenEinloggen.addActionListener(this);
	    
	    frame.getRootPane().setDefaultButton(btnAnmeldenEinloggen);
	    
	  
	    frame.setVisible(true);
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


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnAnmeldenAbbrechen) {
			frame.dispose();
		}
		
		
		  if(e.getSource() == btnAnmeldenEinloggen) {
		
			  String pwd = new String(anmeldenPasswort.getPassword());
			  String email = anmeldenEmail.getText();
			  
			  LogStrg.anmelden(pwd, email, anmeldenCbList);
			  frame.dispose();
				
		  }
	}
}