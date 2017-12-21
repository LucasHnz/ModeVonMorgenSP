package Frontend;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.Dimension;
import Artikelverwaltung.ArtikelStrg;
import Artikelverwaltung.Artikelsammlung;
import Warenkorbverwaltung.Warenkorb;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.GridLayout;

public class GUIWarenkorb  {
	
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static String Gesamtpreis;
	static JLabel lblGesamtpreis;
	
	public static void main(String[] args) {
		ArtikelStrg.FülleArtikelsammlung();
		Warenkorb.ArtikelHinzufügen(Artikelsammlung.getArtikel(500000001), 3);
		Warenkorb.ArtikelHinzufügen(Artikelsammlung.getArtikel(500000002), 3);
		Warenkorb.ArtikelHinzufügen(Artikelsammlung.getArtikel(500000003), 10);
		Warenkorb.ArtikelHinzufügen(Artikelsammlung.getArtikel(500000005), 10);
		Warenkorb.ArtikelHinzufügen(Artikelsammlung.getArtikel(500000006), 10);
		try{
			UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
			//UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
			//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Throwable e) {
			e.printStackTrace();
		}

		getGUIWarenkorb();
	}
	
	public static JFrame getGUIWarenkorb() {
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0,0,1000,600);
		BuildPanel();
		JButton btnZurKasse = new JButton("Zur Kasse");
		btnZurKasse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//BestellStrg.neueBestellung(Warenkorb.getWarenkorb()); 
				// sowas in der Richtung.. Keine Ahnung, wie ihr das letztendlich schreibt
			
			}
		});
		btnZurKasse.setBounds(648, 424, 227, 46);
		frame.getContentPane().add(btnZurKasse);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(panel);
		scrollPane.setBounds(10, 11, 865, 402);
				
		frame.getContentPane().add(scrollPane);
		
		Gesamtpreis = String.format("%.2f",Warenkorb.getGesamtpreis());
		lblGesamtpreis = new JLabel("Gesamtpreis: " +Gesamtpreis + "€");
		
		lblGesamtpreis.setBackground(Color.WHITE);
		lblGesamtpreis.setFont(new Font("Calibri", Font.BOLD, 18));
		lblGesamtpreis.setBounds(415, 423, 223, 46);
		frame.getContentPane().add(lblGesamtpreis);
		frame.setVisible(true);
		
		return frame;
	}
	
	public static JPanel getPanel() {
		return panel;
	}
	
	public static void BuildPanel() {
		panel.setAutoscrolls(true);
		panel.setOpaque(false);
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		
		int length = Warenkorb.getWarenkorb().size() * 100;
		panel.setPreferredSize(new Dimension(549, length));
		
		for (Map.Entry<Integer, Integer> entry : Warenkorb.getWarenkorb().entrySet()) {
		    Integer artikelnummer = entry.getKey();
		    Integer anzahl = entry.getValue();
		    panel.add(new GUIWarenkorbArtikel(artikelnummer, anzahl));
		 
		}		
		panel.setLayout(new GridLayout(0, 1, 0, 0));
	}
	public static void updateGesamtpreis() {
		Gesamtpreis = String.format("%.2f",Warenkorb.getGesamtpreis());
		lblGesamtpreis.setText("Gesamtpreis: " +Gesamtpreis + "€");
	}
}
