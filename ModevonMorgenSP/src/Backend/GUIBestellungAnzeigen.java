package Backend;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIBestellungAnzeigen extends JFrame{
	private JTable table;
	public GUIBestellungAnzeigen(int i) {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 32, 311, 218);
		getContentPane().add(panel);
		
		JButton btnAkzeptieren = new JButton("Akzeptieren");
		btnAkzeptieren.setBounds(331, 32, 89, 23);
		getContentPane().add(btnAkzeptieren);
		btnAkzeptieren.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
			
		});
		
		JButton btnAblehnen = new JButton("Ablehnen");
		btnAblehnen.setBounds(331, 66, 89, 23);
		getContentPane().add(btnAblehnen);
		btnAblehnen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
			
		});
		
		JLabel lblNewLabel = new JLabel("Bestellpositionen von Bestellung: "+i);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 7, 311, 14);
		getContentPane().add(lblNewLabel);
		
		
	}
}
