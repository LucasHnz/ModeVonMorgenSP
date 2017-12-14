package Backend;

import java.awt.EventQueue;
import javax.swing.ListSelectionModel;
import java.util.Comparator;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Artikelverwaltung.Artikel;
import Artikelverwaltung.ArtikelStrg;
import Artikelverwaltung.Artikelsammlung;

public class GUIArtikelliste extends JScrollPane {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private String[] columnNames = {"ArtNr", "Bezeichung", "Hersteller", "Bestand", "Preis: €", "Rabatt: %", "Verfügbarkeit", "Notiz"};

	private class myTableModel extends AbstractTableModel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String[] columnNames;
		private HashMap<Integer, Artikel> data;
		
		public myTableModel(HashMap<Integer, Artikel> artikelliste, String[] columnNames) {
			this.columnNames = columnNames;
			this.data = artikelliste;
		}
			
		public int getColumnCount() {
			return columnNames.length;
		}
		
		public String getColumnName(int columnIndex) {
			return columnNames[columnIndex].toString();
		}
		
		public int getRowCount() {
			return data.size();
		}
		
		public Object getValueAt(int rowIndex, int columnIndex) {
			Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
			try {
			if(columnIndex == 0) {
				return data.get(keys[rowIndex]).getArtikelnummer();
			}
			else if(columnIndex == 1) {
				return data.get(keys[rowIndex]).getBezeichnung();
			}
			else if(columnIndex == 2) {
				return data.get(keys[rowIndex]).getHersteller();
			}	
			else if(columnIndex == 3) {
				return data.get(keys[rowIndex]).getBestand();
			}	
			else if(columnIndex == 4) {
				return data.get(keys[rowIndex]).getPreis();
			}	
			else if(columnIndex == 5) {
				return data.get(keys[rowIndex]).getRabatt();
			}	
			else if(columnIndex == 6) {
				return data.get(keys[rowIndex]).getVerfügbarkeit();
			}	
			else if(columnIndex == 7) {
				//if(data.get(rowIndex).getNotiz() != null)
				//	return String.valueOf(true);
				//else
				//	return String.valueOf(false);
				//return "test";	
				return data.get(keys[rowIndex]).getNotiz();
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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArtikelStrg.FülleArtikelsammlung();
					GUIArtikelliste frame = new GUIArtikelliste();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIArtikelliste() {
		setBounds(100, 100, 878, 518);
		//getContentPane().setLayout(null);
		setLayout(null);

		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		table = new JTable(new myTableModel(Artikelsammlung.getArtikelsammlung(), columnNames));
		table.setFillsViewportHeight(true);
		table.setDragEnabled(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(38);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(30);
		table.getColumnModel().getColumn(4).setPreferredWidth(30);
		table.getColumnModel().getColumn(5).setPreferredWidth(30);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(10);
			
		Comparator<Double> preiscomp = new Comparator<Double>() {
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
		
		Comparator<Integer> bestandcomp = new Comparator<Integer>() {
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
		sorter.setComparator(3, bestandcomp);
		sorter.setComparator(4, preiscomp);
		sorter.setComparator(5, preiscomp);
		table.setRowSorter(sorter);
		table.getRowSorter().toggleSortOrder(0);
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(30, 42, 800, 395);
		//getContentPane().add(scrollPane);
		add(scrollPane);
		setVisible(true);

	}
}
