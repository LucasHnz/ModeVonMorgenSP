package Frontend;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import Artikelverwaltung.ArtikelStrg;
import Artikelverwaltung.Artikelsammlung;
import Bestellverwaltung.BestellStrg;
import Warenkorbverwaltung.Warenkorb;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Component;
/**
 * 
 * @author Falk Maoro
 *
 */
public class GUIWarenkorb {
	
	static JPanel mainPanel;
	static JPanel panel;
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
		}catch(Throwable e) {
			e.printStackTrace();
		}

		getGUIWarenkorb();
	}
	/**
	 * Zeigt dem Nutzer seinen Warenkorb an. 
	 * @return
	 */
	public static JPanel getGUIWarenkorb() {
		mainPanel = new JPanel();
		panel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBounds(0, 0, 1234, 563);
		BuildPanel();
		JButton btnZurKasse = new JButton("Bestellen");
		btnZurKasse.setFont(new Font("Dialog", Font.BOLD, 13));
		btnZurKasse.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnZurKasse.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent agr0){
				if(Warenkorb.getWarenkorb().size() >= 1) {
					BestellStrg.bestellvorgang();			
				}
				else
					JOptionPane.showMessageDialog(null, "Ihr Warenkorb ist leer. \nLegen Sie Artikel in den Warenkorb, um eine Bestellung zu tätigen.", "Fehler", JOptionPane.WARNING_MESSAGE);
			}
		});
		btnZurKasse.setBounds(1001, 478, 227, 46);
		btnZurKasse.setBorder(null);
		mainPanel.add(btnZurKasse);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(panel);
		scrollPane.setBounds(10, 11, 1218, 455);
				
		mainPanel.add(scrollPane);
		
		Gesamtpreis = String.format("%.2f",Warenkorb.getGesamtpreis());
		lblGesamtpreis = new JLabel("Gesamtpreis: " +Gesamtpreis + "€");
		
		lblGesamtpreis.setBackground(Color.WHITE);
		lblGesamtpreis.setFont(new Font("Dialog", Font.BOLD, 18));
		lblGesamtpreis.setBounds(766, 478, 223, 46);
		mainPanel.add(lblGesamtpreis);
		mainPanel.setVisible(true);
		
		return mainPanel;
	}
	/**
	 * Enfernt alle Artikel aus dem Panel.
	 */
	public static void clearPanel() {
		panel.removeAll();
	}
	/**
	 * Baut das Panel neu auf und fügt alle Artikelpanel hinzu.
	 */
	public static void BuildPanel() {
		panel.setAutoscrolls(true);
		panel.setOpaque(false);
		panel.setBackground(Color.WHITE);
		
		int length = Warenkorb.getWarenkorb().size() * 100;
		panel.setPreferredSize(new Dimension(549, length));
		
		for (Map.Entry<Integer, Integer> entry : Warenkorb.getWarenkorb().entrySet()) {
		    Integer artikelnummer = entry.getKey();
		    Integer anzahl = entry.getValue();
		    panel.add(new GUIWarenkorbArtikel(artikelnummer, anzahl));
		 
		}		
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		panel.revalidate();
		panel.repaint();
	}
	/**
	 * Aktualisiert das JLabel für die Anzeige des Gesamtpreises im Warenkorb.
	 */
	public static void updateGesamtpreis() {
		Gesamtpreis = String.format("%.2f",Warenkorb.getGesamtpreis());
		lblGesamtpreis.setText("Gesamtpreis: " +Gesamtpreis + "€");
	}
}
