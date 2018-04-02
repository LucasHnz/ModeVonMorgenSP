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
		scrollpane.setBounds(10, 11, 1180, 490);
		scrollpane.setViewportView(table);
		add(scrollpane);
		
	
		URL editUrl = GUI.class.getResource(
                "/Icons 64x64/repair-tools.png");
		Image ArtikelEditieren = new ImageIcon(editUrl).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		
		URL entfernenUrl = GUI.class.getResource(
                "/Icons 64x64/multiply.png");
		Image ArtikelEntfernen = new ImageIcon(entfernenUrl).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		
		URL rabattUrl = GUI.class.getResource(
                "/Icons 64x64/division.png");
		Image Rabatt = new ImageIcon(rabattUrl).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		
		URL bestandUrl = GUI.class.getResource(
                "/Icons 64x64/maths.png");
		Image Bestand = new ImageIcon(bestandUrl).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);

	
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
