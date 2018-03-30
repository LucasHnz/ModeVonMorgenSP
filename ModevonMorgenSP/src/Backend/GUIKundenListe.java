package Backend;

import javax.swing.ListSelectionModel;
import javax.swing.LookAndFeel;

import java.util.Comparator;
import java.util.HashMap;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import Artikelverwaltung.Artikel;
import Artikelverwaltung.ArtikelStrg;
import Artikelverwaltung.Artikelsammlung;
import Frontend.GUI;
import KundenVerwaltung.Bestandskunde;
import KundenVerwaltung.BestandskundeSammlung;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

/**
 * 
 * @author Falk Maoro
 *
 */
public class GUIKundenListe  extends JPanel {
	
	private JTable table;
	private JScrollPane scrollpane;
	private String[] columnNames = {"Kundennummer", "Vorname", "Nachname", "Email","Straße", "PLZ", "Ort", "PSS"};
	private myTableModel model;

	Comparator<Double> doublecomp = new Comparator<Double>() {
		@Override
		public int compare(Double o1, Double o2) {
			if(o1 > o2)
				return 1;
			else if(o1 < o2)
				return -1;
			else
				return 0;
		}
	};
	Comparator<Integer> intcomp = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			if(o1 > o2)
				return 1;
			else if(o1 < o2)
				return -1;
			else
				return 0;
		}		
	};
	WindowListener formularListener = new WindowListener() {

		@Override
		public void windowActivated(WindowEvent e) {}

		@Override
		public void windowClosed(WindowEvent e) {
			model.fireTableStructureChanged();
			setStructure();
			}

		@Override
		public void windowClosing(WindowEvent e) {}

		@Override
		public void windowDeactivated(WindowEvent e) {}

		@Override
		public void windowDeiconified(WindowEvent e) {}

		@Override
		public void windowIconified(WindowEvent e) {}

		@Override
		public void windowOpened(WindowEvent e) {}
	};
	
	private class myTableModel extends AbstractTableModel{

		private String[] columnNames;
		private HashMap<Integer, Bestandskunde> data;
		/**
		 * Füllt die Tabelle mit einer Artikel-HashMap.
		 * @param kundenliste HashMap<Integer, Artikel>.
		 * @param columnNames Die Spaltennamen der Tabelle.
		 */
		public myTableModel(HashMap<Integer, Bestandskunde> kundenliste, String[] columnNames) {
			this.columnNames = columnNames;
			this.data = kundenliste;
		}
		/** 
		 * Gibt die Anzahl an Spalten aus.	
		 */
		public int getColumnCount() {
			return columnNames.length;
		}
		/**
		 * Gibt die Klasse des in der Spalte angezeigten Wertes zurück.
		 */
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public Class getColumnClass(int columnIndex){
			if(columnIndex == 0) {
				return getValueAt(0, columnIndex).getClass();
			}
			else if(columnIndex == 1) {
				return getValueAt(0, columnIndex).getClass();
			}
			else if(columnIndex == 2) {
				return getValueAt(0, columnIndex).getClass();
			}	
			else if(columnIndex == 3) {
				return getValueAt(0, columnIndex).getClass();
			}	
			else if(columnIndex == 4) {
				return getValueAt(0, columnIndex).getClass();
			}	
			else if(columnIndex == 5) {
				return getValueAt(0, columnIndex).getClass();
			}
			else if(columnIndex == 6) {
				return getValueAt(0, columnIndex).getClass();
			}
			else if(columnIndex == 7) {
				return getValueAt(0, columnIndex).getClass();
			}
			else 
				return null;
		}
		/**
		 * Gibt den Namen der Spalte zurück.
		 * @param columnIndex Die Spaltennummer.
		 */
		public String getColumnName(int columnIndex) {
			return columnNames[columnIndex].toString();
		}
		/**
		 * Gibt die Anzahl der Reihen zurück.
		 */
		public int getRowCount() {
			return data.size();
		}
		/** 
		 * Gibt den Wert der ausgewählten Zelle zurück.
		 * @param rowIndex Der Zeilenindex.
		 * @param columnIndex Der Spaltenindex.
		 */
		public Object getValueAt(int rowIndex, int columnIndex) {
			Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
			try {
				if(columnIndex == 0) {
					int i = keys[rowIndex];
					int nr = data.get(i).getNutzernr();
					return String.valueOf(nr);
				}
				else if(columnIndex == 1) {
					return data.get(keys[rowIndex]).getVorname();
				}
				else if(columnIndex == 2) {
					return data.get(keys[rowIndex]).getNachname();
				}
				else if(columnIndex == 3) {
					return data.get(keys[rowIndex]).getEmail();
				}	
				else if(columnIndex == 4) {
					return data.get(keys[rowIndex]).getStraße();
				}	
				else if(columnIndex == 5) {
					return data.get(keys[rowIndex]).getPlz();		
				}	
				else if(columnIndex == 6) {
					return data.get(keys[rowIndex]).getOrt();		
				}	
				else if(columnIndex == 7) {
					return data.get(keys[rowIndex]).getPss();		
				}	
				else
					return null;
			
			}catch(NullPointerException e) {
				String a = null;
				return a;
			}catch(ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
				return null;
			}
		}
		/**
		 * Gibt zurück, ob die Zelle bearbeitet werden darf. Ist für die gesamte Tabelle nicht erlaubt.
		 */
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;	
		}				
	}

	/**
	 * Öffnet die Artikelverwaltung, in der alle Artikel aufgelistet sind und bearbeitet werden können.
	 */
	public GUIKundenListe() {
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));		
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		setBounds(90, 100, 1200, 600);
			
		model = new myTableModel(BestandskundeSammlung.getBestandskundenSammlung(), columnNames);
		table = new JTable(model);
		table.setFont(new Font("Dialog", Font.PLAIN, 13));
		table.setFillsViewportHeight(true);
		setStructure();
		
		scrollpane = new JScrollPane();
		scrollpane.setBounds(10, 11, 900, 490);
		scrollpane.setViewportView(table);
		add(scrollpane);
				
		
		JButton btnEditiereArtikel = new JButton("Artikel editieren");
		btnEditiereArtikel.setFont(new Font("Dialog", Font.BOLD, 14));
		btnEditiereArtikel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					final HashMap<Integer, Artikel> data = Artikelsammlung.getArtikelsammlung();
					Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
					new GUIArtikelFormular(data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getArtikelnummer());
					
				}catch (ArrayIndexOutOfBoundsException e) {
					JOptionPane.showOptionDialog(null, "Bitte wählen Sie eine Zeile aus!",
							"Artikel editieren", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
							null, new String[] { "Ok"}, "Ok");
				}
			}
		});
		
	
		URL editUrl = GUI.class.getResource(
                "/Icons 64x64/repair-tools.png");
		Image ArtikelEditieren = new ImageIcon(editUrl).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		JLabel lblArtikelEditieren = new JLabel(new ImageIcon(ArtikelEditieren));
		lblArtikelEditieren.setBounds(921, 15, 40, 40);
		add(lblArtikelEditieren);
		btnEditiereArtikel.setBounds(975, 11, 215, 48);
		add(btnEditiereArtikel);
		
		JButton btnEntferneArtikel = new JButton("Artikel entfernen");
		btnEntferneArtikel.setFont(new Font("Dialog", Font.BOLD, 14));
		btnEntferneArtikel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					final HashMap<Integer, Artikel> data = Artikelsammlung.getArtikelsammlung();
					Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
				
					final Object optionPane = JOptionPane.showConfirmDialog(null,
							"Wollen Sie den Artikel: \n" + data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getBezeichnung() 
							+ "\nArtikelnummer: " + data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getArtikelnummer()
							+ "\nwirklich löschen?", "Abfrage",
							JOptionPane.YES_NO_OPTION);
					
					if(optionPane.equals(0)) {
						ArtikelStrg.entferneArtikel(data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getArtikelnummer());
						model.fireTableStructureChanged();
						setStructure();
						JOptionPane.showMessageDialog(null,  "Artikel wurde gelöscht.", "Information", JOptionPane.INFORMATION_MESSAGE);
					}else if(optionPane.equals(1)) {
						JOptionPane.showMessageDialog(null,  "Vorgang abgebrochen!", "Abbruch", JOptionPane.ERROR_MESSAGE);
					}	
					
				}catch (ArrayIndexOutOfBoundsException e) {
					JOptionPane.showOptionDialog(null, "Bitte wählen Sie eine Zeile aus!",
							"Artikel entfernen", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
							null, new String[] { "Ok"}, "Ok");
				}
			}
		});
		
		URL entfernenUrl = GUI.class.getResource(
                "/Icons 64x64/multiply.png");
		Image ArtikelEntfernen = new ImageIcon(entfernenUrl).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		JLabel lblArtikelEntfernen = new JLabel(new ImageIcon(ArtikelEntfernen));
		lblArtikelEntfernen.setBounds(921, 71, 40, 40);
		add(lblArtikelEntfernen);
		btnEntferneArtikel.setBounds(975, 70, 215, 48);
		add(btnEntferneArtikel);
		
		JButton btnRabatt = new JButton("Rabatt ändern");
		btnRabatt.setFont(new Font("Dialog", Font.BOLD, 14));
		btnRabatt.addActionListener(new ActionListener() {
			final HashMap<Integer, Artikel> data = Artikelsammlung.getArtikelsammlung();
			Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
			public void actionPerformed(ActionEvent arg0) {
				try {
					final String optionPane = (String) JOptionPane.showInputDialog(scrollpane, "Aktueller Rabatt: " 
								+ data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getRabatt() + " %", "Rabatt ändern", 
								JOptionPane.INFORMATION_MESSAGE, null, null, data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getRabatt());
					if(optionPane != null) {
						ArtikelStrg.aktualisiereRabatt(Integer.parseInt(optionPane), data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getArtikelnummer());
						JOptionPane.showMessageDialog(null,  "Rabatt wurde geändert.", "Information", JOptionPane.INFORMATION_MESSAGE);
					}else if(optionPane == null) {
						JOptionPane.showMessageDialog(null,  "Vorgang abgebrochen!", "Abbruch", JOptionPane.ERROR_MESSAGE);
					}	
				}catch (ArrayIndexOutOfBoundsException e) {
					JOptionPane.showOptionDialog(null, "Bitte wählen Sie eine Zeile aus!",
							"Rabatt ändern", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
							null, new String[] { "Ok"}, "Ok");
				}	
			}
		});
		
		URL rabattUrl = GUI.class.getResource(
                "/Icons 64x64/division.png");
		Image Rabatt = new ImageIcon(rabattUrl).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		JLabel lblRabatt = new JLabel(new ImageIcon(Rabatt));
		lblRabatt.setBounds(921, 132, 40, 40);
		add(lblRabatt);
		btnRabatt.setBounds(975, 129, 215, 48);
		add(btnRabatt);
		
			
		JButton btnBestand = new JButton("Bestand ändern");
		btnBestand.setFont(new Font("Dialog", Font.BOLD, 14));
		btnBestand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					final HashMap<Integer, Artikel> data = Artikelsammlung.getArtikelsammlung();
					Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
					final String optionPane = (String) JOptionPane.showInputDialog(scrollpane, "Aktueller Bestand: " 
							+ data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getBestand(), "Bestand ändern", 
							JOptionPane.INFORMATION_MESSAGE, null, null, data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getBestand() );
					if(optionPane != null) {
						ArtikelStrg.aktualisiereBestand(Integer.parseInt(optionPane), data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getArtikelnummer());
						JOptionPane.showMessageDialog(null,  "Bestand wurde geändert.", "Information", JOptionPane.INFORMATION_MESSAGE);
					}else if(optionPane == null) {
						JOptionPane.showMessageDialog(null,  "Vorgang abgebrochen!", "Abbruch", JOptionPane.ERROR_MESSAGE);
					}	
				}catch (ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showOptionDialog(null, "Bitte wählen Sie eine Zeile aus!",
							"Bestand ändern", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
							null, new String[] { "Ok"}, "Ok");
				}
			}
		});
		
		URL bestandUrl = GUI.class.getResource(
                "/Icons 64x64/maths.png");
		Image Bestand = new ImageIcon(bestandUrl).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		JLabel lblBestand = new JLabel(new ImageIcon(Bestand));
		lblBestand.setBounds(921, 191, 40, 40);
		add(lblBestand);
		btnBestand.setBounds(975, 188, 215, 48);
		add(btnBestand);

	
		setVisible(true);
	}
	/**
	 * Stellt die Tabellenstruktur her. Wird vor allem nach einem Update der 
	 * Zeilenanzahl genutzt.
	 */
	public void setStructure() {
		table.setDragEnabled(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(110);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(130);
		table.getColumnModel().getColumn(5).setPreferredWidth(60);
		table.getColumnModel().getColumn(6).setPreferredWidth(50);
		table.getColumnModel().getColumn(7).setPreferredWidth(30);
				
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		table.getRowSorter().toggleSortOrder(0);
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sorter.setComparator(7, intcomp);
	}
}
