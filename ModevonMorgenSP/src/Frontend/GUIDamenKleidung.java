package Frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;

public class GUIDamenKleidung implements ActionListener {
	
	JButton btnZur�ck = new JButton();
	JButton btnAnmelden = new JButton();
	

	public JFrame frame;
	JPanel panelMain = new JPanel();
 	private JTextField txtSchwarzeJacke;
	private JTextField textField_1;
	private JTextField txtGre;

	/**
	 * Create the application.
	 */
	public GUIDamenKleidung(JFrame frame) {
		System.out.println("Ausgef�hrt DK");
		this.frame = frame;
		
		initializeDamen(frame);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeDamen(JFrame frame) {
		
		panelMain = new JPanel();
		panelMain.setBackground(Color.WHITE);
		panelMain.setBounds(0, 148, 1234, 563);
		panelMain.setLayout(null);
		
		btnZur�ck = new JButton("Zur\u00FCck");
		btnZur�ck.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnZur�ck.setBackground(Color.WHITE);
		btnZur�ck.setBounds(10, 11, 89, 35);
		btnZur�ck.addActionListener(this);
		panelMain.add(btnZur�ck);
		
		
		
		JPanel panelScrollPaneLinks = new JPanel();
		panelScrollPaneLinks.setBackground(SystemColor.control);
		panelScrollPaneLinks.setLayout(null);
		
		JScrollPane scrollPaneLinks = new JScrollPane(panelScrollPaneLinks);
		scrollPaneLinks.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneLinks.setBounds(10, 97, 270, 455);
		panelMain.add(scrollPaneLinks);
		
		JPanel panelScrollPaneRechts = new JPanel();
		panelScrollPaneRechts.setLayout(new BoxLayout(panelScrollPaneRechts, BoxLayout.X_AXIS));
		JScrollPane scrollPaneRechts = new JScrollPane(panelScrollPaneRechts);
		scrollPaneRechts.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneRechts.setBounds(323, 97, 901, 455);
		panelMain.add(scrollPaneRechts);
		
		
		JButton btnNewButton = new JButton("Jacken");
		btnNewButton.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(10, 23, 248, 43);
		panelScrollPaneLinks.add(btnNewButton);
		
		JButton btnShirts = new JButton("Shirts");
		btnShirts.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnShirts.setBackground(Color.WHITE);
		btnShirts.setBounds(10, 87, 248, 43);
		panelScrollPaneLinks.add(btnShirts);
		
		JButton btnHosen = new JButton("Hosen");
		btnHosen.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnHosen.setBackground(Color.WHITE);
		btnHosen.setBounds(10, 151, 248, 43);
		panelScrollPaneLinks.add(btnHosen);
		
	
		frame.add(panelMain);
		panelMain.setVisible(true);
		frame.invalidate();
		frame.validate();
		frame.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
			if(e.getSource() == btnZur�ck) 
			{
				panelMain.setVisible(false);
				GUI.panelMain.setVisible(true);
			}
		
			
		
	}
}