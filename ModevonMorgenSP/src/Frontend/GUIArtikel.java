package Frontend;

/**
 * 
 * @author Hinz
 *
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

public class GUIArtikel implements ActionListener {
	
	JButton btnZurück = new JButton();
	JButton btnAnmelden = new JButton();
	public JComboBox comboBoxHerren = new JComboBox();
	public JComboBox comboBoxDamen = new JComboBox();
	public JComboBox comboBoxAnmelden = new JComboBox();
	public String[] damenCbList;
	public String[] herrenCbList;
	public String[] anmeldenCbList;
	public JPanel panelHerrenKleidung = new JPanel();
	public String[] comboBoxGrößen = {"XS", "S","M", "L", "XL", "XXL"};

	public JFrame frame;
	JPanel panelMain = new JPanel();

	

	
	public GUIArtikel(JFrame frame) {
		System.out.println("Ausgeführt Artikel");
		this.frame = frame;
		initialize(frame);
	}


	private void initialize(JFrame frame) {
		
		panelMain = new JPanel();
		panelMain.setBackground(Color.WHITE);
		panelMain.setBounds(0, 147, 1234, 563);
		frame.getContentPane().add(panelMain);
		panelMain.setLayout(null);
		
		btnZurück = new JButton("Zur\u00FCck");
		btnZurück.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnZurück.setBackground(Color.WHITE);
		btnZurück.setBounds(10, 11, 89, 35);
		btnZurück.addActionListener(this);
		panelMain.add(btnZurück);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(105, 60, 1051, 434);
		panelMain.add(panel);
		
		
		JLabel labelArtikelBild = new JLabel("");
		labelArtikelBild.setBackground(Color.WHITE);
		labelArtikelBild.setHorizontalAlignment(SwingConstants.CENTER);
		labelArtikelBild.setBounds(70, 32, 250, 250);
		labelArtikelBild.setIcon(bildAnpassen("src\\SWP-Bilder\\Damenkleidung_2.jpg"));
		panel.add(labelArtikelBild);
		
		JLabel lblArtikelTitel = new JLabel("Schwarze Jacke DENIM");
		lblArtikelTitel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblArtikelTitel.setBounds(362, 11, 319, 49);
		panel.add(lblArtikelTitel);
		
		JLabel lblArtikelStatus = new JLabel("Auf Lager");
		lblArtikelStatus.setBounds(362, 57, 110, 43);
		panel.add(lblArtikelStatus);
		lblArtikelStatus.setForeground(new Color(0, 204, 51));
		lblArtikelStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblArtikelStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnWarenkorbHinz = new JButton("In den Warenkorb");
		btnWarenkorbHinz.setBounds(361, 185, 153, 35);
		panel.add(btnWarenkorbHinz);
		btnWarenkorbHinz.setBackground(SystemColor.inactiveCaptionBorder);
		
		JTextPane txtpnArtikelBeschreibung = new JTextPane();
		txtpnArtikelBeschreibung.setBackground(SystemColor.inactiveCaptionBorder);
		txtpnArtikelBeschreibung.setText("Test dishfinsmva s");
		txtpnArtikelBeschreibung.setBounds(362, 272, 514, 132);
		panel.add(txtpnArtikelBeschreibung);
		
		JComboBox comboBoxArtikelGröße = new JComboBox(comboBoxGrößen);
		comboBoxArtikelGröße.setBounds(362, 111, 152, 35);
		comboBoxArtikelGröße.setBackground(SystemColor.inactiveCaptionBorder);
		panel.add(comboBoxArtikelGröße);
		
		
		frame.add(panelMain);
		panelMain.setVisible(true);
		frame.invalidate();
		frame.validate();
		frame.repaint();
		
	}
	
	
	public ImageIcon bildAnpassen(String imageRoot) {
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(imageRoot).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
		return imageIcon;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnZurück) 
		{
			frame.dispose();
			new GUI();
		}

	}
}

