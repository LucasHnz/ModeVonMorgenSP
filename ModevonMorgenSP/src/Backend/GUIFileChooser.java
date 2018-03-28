package Backend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import Artikelverwaltung.Artikelsammlung;
import Frontend.GUI;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
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
	private File img = null;
	private BufferedImage buffImg = null;
	private JLabel lblImage;

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
		setBounds(100, 100, 423, 184);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnDurchsuchen = new JButton("Durchsuchen...");
		btnDurchsuchen.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnDurchsuchen.setBounds(47, 60, 206, 23);
		contentPane.add(btnDurchsuchen);
		btnDurchsuchen.addActionListener(this);
		
		URL SearchUrl = GUI.class.getResource(
                "/Icons 64x64/search.png");
		Image SearchImg = new ImageIcon(SearchUrl).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		JLabel SearchLbl = new JLabel(new ImageIcon(SearchImg));
		SearchLbl.setBounds(10, 55, 33, 33);
		contentPane.add(SearchLbl);

		btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnAbbrechen.setBounds(146, 121, 107, 23);
		contentPane.add(btnAbbrechen);
		btnAbbrechen.addActionListener(this);
		
		tfDatei = new JTextField();
		tfDatei.setFont(new Font("Dialog", Font.PLAIN, 11));
		tfDatei.setBounds(47, 12, 206, 37);
		contentPane.add(tfDatei);
		tfDatei.setColumns(10);
		
		JLabel lblDatei = new JLabel("Datei:");
		lblDatei.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblDatei.setBounds(10, 11, 46, 38);
		contentPane.add(lblDatei);
		
		lblImage = new JLabel("");
		lblImage.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, Color.GRAY, null));
		lblImage.setBackground(Color.WHITE);
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(268, 12, 132, 132);
		updateImage(Artikelsammlung.getArtikel(Artikelnummer).getImage());
		contentPane.add(lblImage);
				
		btnHochladen = new JButton("Hochladen");
		btnHochladen.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnHochladen.setBounds(47, 121, 89, 23);
		btnHochladen.addActionListener(this);
		contentPane.add(btnHochladen);
		
		URL UploadUrl = GUI.class.getResource(
                "/Icons 64x64/search.png");
		Image UploadImg = new ImageIcon(UploadUrl).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		JLabel UploadLbl = new JLabel(new ImageIcon(SearchImg));
		UploadLbl.setBounds(10, 116, 33, 33);
		contentPane.add(UploadLbl);
		
		setVisible(true);
	}
	private void updateImage(BufferedImage image) {
		ImageIcon icon;
		if(image != null) {
			icon = new ImageIcon(image);
		}
		else {
			URL imgUrl = GUI.class.getResource(
	                "/SWP-Bilder/NoPic.gif");
			icon = new ImageIcon(imgUrl);}
        Image img = icon.getImage().getScaledInstance(132, 132, Image.SCALE_SMOOTH);
        lblImage.setIcon(new ImageIcon(img));
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnDurchsuchen) {
			
			JFrame frame = new JFrame();			
			int returnVal = chooser.showOpenDialog(frame);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = chooser.getSelectedFile();
				tfDatei.setText(file.toString());
				this.fileName = file.toString();
				try {
					img = new File(fileName);
					buffImg = ImageIO.read(img);
					updateImage(buffImg);
				}catch(IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		if(e.getSource() == btnAbbrechen){
			dispose();
		}
		if(e.getSource() == btnHochladen) {
			if(fileName.endsWith(".jpg") || fileName.endsWith(".JPG")){
				try {
					Artikelsammlung.getArtikel(Artikelnummer).uploadImage(fileName);
					Artikelsammlung.getArtikel(Artikelnummer).setImage(buffImg);
				}catch(NullPointerException n) {
					JOptionPane.showOptionDialog(null, "Bitte wählen Sie eine Datei aus!",
							"Fehler", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,
							new String[] { "Ok"}, "Ok");
				}
			}
			else
				JOptionPane.showOptionDialog(null, "Bitte wählen Sie eine JPG-Datei aus!",
						"Fehler", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,
						new String[] { "Ok"}, "Ok");
		}
	}
}
