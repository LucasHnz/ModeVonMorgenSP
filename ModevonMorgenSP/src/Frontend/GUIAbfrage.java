package Frontend;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logverwaltung.LogStrg;


public class GUIAbfrage extends JFrame implements ActionListener  {

	/**
	 * 
	 */
	
	//mit optionPane in klasse davor tun
	private static final long serialVersionUID = 1L;

	private JButton btnBk;
	private JButton btnGk;
	public GUIAbfrage() throws SQLException{
		
		setBounds(200, 100, 365, 315);
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("GK oder Bk");
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 340, 231);
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(true);
		
		JLabel lblÜberschrift = new JLabel("Wollen Sie als Bestands- oder Gastkunde forfahren?:");
		lblÜberschrift.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblÜberschrift.setBounds(21, 10, 126, 16);
		panel.add(lblÜberschrift);
		
		
		btnBk = new JButton("Bestandskunde");
		btnBk.addActionListener(this);
		btnBk.setBounds(185, 11, 110, 23);
		panel.add(btnBk);
		
		btnGk = new JButton("Gastkunde");
		btnGk.addActionListener(this);
		btnGk.setBounds(52, 11, 108, 23);
		panel.add(btnGk);
		
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		try {
		if (e.getSource()==btnBk) {
				//new GUIEinloggen(); changePanel(GUIAnmedelden) immer überprüfen ob LogStg einen Bestandskundehat
			}
			if(e.getSource()==btnGk) {
				new GUIGastkundeErstellen();
			}
		}catch(SQLException a) {
			System.err.println(a);
		}
		}
	}