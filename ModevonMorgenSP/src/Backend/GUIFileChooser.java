package Backend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import Artikelverwaltung.Artikelsammlung;

import javax.swing.JTextField;
import java.awt.Font;
/**
 * 
 * @author Falk Maoro
 *
 */
public class GUIFileChooser extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JFileChooser chooser;
	private FileNameExtensionFilter filter = new FileNameExtensionFilter(
			"JPEG file", "jpg", "jpeg");
	private JButton btnDurchsuchen;
	private JButton btnAbbrechen;
	private JTextField tfDatei;
	private String fileName;
	private JButton btnHochladen;
	private int Artikelnummer;

	/**
	 * Öffnet das Auswahlfenster zum Hochladen eines neuen Artikelbilds.
	 * @param Artikelnummer Die zugehörige Artikelnummer.
	 */
	public GUIFileChooser(int Artikelnummer) {
		this.Artikelnummer=Artikelnummer;
		setTitle("Bild ausw\u00E4hlen");
				
		chooser = new JFileChooser();
		chooser.addChoosableFileFilter(filter);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 360, 120);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnDurchsuchen = new JButton("Durchsuchen...");
		btnDurchsuchen.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnDurchsuchen.setBounds(235, 11, 107, 23);
		contentPane.add(btnDurchsuchen);
		btnDurchsuchen.addActionListener(this);

		btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnAbbrechen.setBounds(235, 47, 107, 23);
		contentPane.add(btnAbbrechen);
		btnAbbrechen.addActionListener(this);
		
		tfDatei = new JTextField();
		tfDatei.setFont(new Font("Dialog", Font.PLAIN, 11));
		tfDatei.setBounds(47, 12, 178, 20);
		contentPane.add(tfDatei);
		tfDatei.setColumns(10);
		
		JLabel lblDatei = new JLabel("Datei:");
		lblDatei.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblDatei.setBounds(10, 15, 46, 14);
		contentPane.add(lblDatei);
		
		btnHochladen = new JButton("Hochladen");
		btnHochladen.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnHochladen.setBounds(136, 47, 89, 23);
		btnHochladen.addActionListener(this);
		contentPane.add(btnHochladen);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnDurchsuchen) {
			
			JFrame frame = new JFrame();			
			int returnVal = chooser.showOpenDialog(frame);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = chooser.getSelectedFile();
				tfDatei.setText(file.toString());
				this.fileName = file.toString();
			}
		}
		if(e.getSource() == btnAbbrechen){
			dispose();
		}
		if(e.getSource() == btnHochladen) {
			try {
				Artikelsammlung.getArtikel(Artikelnummer).uploadImage(fileName);
			}catch(NullPointerException n) {
				JOptionPane.showOptionDialog(null, "Bitte wählen Sie eine Datei aus!",
						"Fehler", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,
						new String[] { "Ok"}, "Ok");
			}
		}
	}
}
