package Backend;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Bestellverwaltung.Bestellposition;
import Bestellverwaltung.BestellpositionSammlung;
import MitarbeiterVerwaltung.Mitarbeiter;
import MitarbeiterVerwaltung.MitarbeiterSammlung;
import RechnungVerwaltung.Bestellung;

/**
 * 
 * @author julian
 *
 */
public class GUIBestellpositionsliste extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JScrollPane scrollpane;
	private String[] columnNames = {"Bestellpositions Nr.", "Bestell Nr.","Artikel Nr.","Preis","Menge"};

	
	private class myTableModel extends AbstractTableModel{

		/**
		 * 
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String[] columnNames;
		private HashMap<Integer, Bestellposition> data;
		
		/**
		 * Füllt die Tabelle mit Bestellpositionen
		 * @param Bposliste
		 * @param columnNames
		 */
		public myTableModel(HashMap<Integer, Bestellposition> Bposliste, String[] columnNames) {
			this.columnNames = columnNames;
			this.data = Bposliste;
		}
		
		/**
		 * Holt sich die Anzahl der Spalten
		 */
		public int getColumnCount() {
			return columnNames.length;
		}
		
		public String getColumnName(int columnIndex) {
			return columnNames[columnIndex].toString();
		}
		
		/**
		 * Holt sich die Anzahl der Rows
		 */
		public int getRowCount() {
			return data.size();
		}
		
		public Object getValueAt(int rowIndex, int columnIndex) {
			Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
			try {
				if(columnIndex == 0) {
					return data.get(keys[rowIndex]).getPosNr();
				}
				else if(columnIndex == 1) {
					return data.get(keys[rowIndex]).getBestellNr();
				}
				
				else if (columnIndex ==2) {
					return data.get(keys[rowIndex]).getAnummer();
				}
				
				else if (columnIndex == 3) {
					return data.get(keys[rowIndex]).getPreis();
				}
				else if(columnIndex == 4) {
					return data.get(keys[rowIndex]).getaMenge();
				}
				else
					return null;
			
			}catch(NullPointerException e) {
				String a = null;
				return a;
			}	
		}
		
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;	
		}
					
	}

	/**
	 * Create the frame.
	 */
	public GUIBestellpositionsliste(int i){
		
		
		setBackground(Color.DARK_GRAY);
		BestellpositionSammlung.fülleMitSpeziellerNummer(i);
		getContentPane().setLayout(null);
		setBounds(200, 200, 1110, 480);
		setBackground(Color.DARK_GRAY);
		
		table = new JTable(new myTableModel(Bestellverwaltung.BestellpositionSammlung.getBestellpositionsSammlung(), columnNames));
		table.setFillsViewportHeight(true);
		table.setDragEnabled(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(20);

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
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		sorter.setComparator(1, intcomp);
		table.setRowSorter(sorter);
		table.getRowSorter().toggleSortOrder(0);
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(30,42,400, 295);
		table.setVisible(true);
		
		scrollpane = new JScrollPane();
		scrollpane.setBounds(10, 11, 900, 490);
		scrollpane.setVisible(true);
		scrollpane.setViewportView(table);
		getContentPane().add(scrollpane);
		
		getContentPane().add(scrollpane);
		// Cut
		/**
		 * Button um eine Rücksendung anzunehmen
		 */
		JButton btnRücksAnnehmen = new JButton("R\u00FCcksendung Annehmen");
		btnRücksAnnehmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Methode zum Versenden einer EMail für Bestätigung und Rücksendung erstellen
			}
		});
		btnRücksAnnehmen.setBounds(920, 11, 170, 48);
		getContentPane().add(btnRücksAnnehmen);
		
		/**
		 * Button um eine Rücksendung abzulehnen
		 */
		JButton btnRücksAblehnen = new JButton("R\u00FCcksendung Ablehnen");
		btnRücksAblehnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Methode zum Versenden einer Email für Ablehnung
			}
		});
		btnRücksAblehnen.setBounds(920,70,170,48);
		getContentPane().add(btnRücksAblehnen);
		
		
		/**
		 * Button um zum Hauptfenster zurück zu kommen
		 */
		JButton btnZurück = new JButton ("Beenden");
			btnZurück.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Bestellverwaltung.BestellpositionSammlung.entferneDatenAusListe();
					dispose();
				}
			});
			btnZurück.setBounds(920,208,170,48);
			getContentPane().add(btnZurück);
			setVisible(true);
		}
	
	

	}

