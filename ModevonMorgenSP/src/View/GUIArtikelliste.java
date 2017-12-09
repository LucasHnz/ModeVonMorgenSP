package View;

import java.awt.EventQueue;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import Artikelverwaltung.Artikel;
import Artikelverwaltung.Artikelsammlung;

public class GUIArtikelliste extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private String[] columnNames = {"ArtNr", "Bezeichung", "Hersteller", "Bestand", "Preis", "Rabatt", "Verf�gbarkeit", "Notiz"};
	private String[][] data = {	{"1", "2", "3", "4", "5", "6", "7", "8"}, 
								{"1", "2", "3", "4", "5", "6", "7", "8"},
								{"1", "2", "3", "4", "5", "6", "7", "8"},
								{"1", "2", "3", "4", "5", "6", "7", "8"},
								{"1", "2", "3", "4", "5", "6", "7", "8"},
								{"1", "2", "3", "4", "5", "6", "7", "8"},
								{"1", "2", "3", "4", "5", "6", "7", "8"},
								{"1", "2", "3", "4", "5", "6", "7", "8"},
								{"1", "2", "3", "4", "5", "6", "7", "8"},
								{"1", "2", "3", "4", "5", "6", "7", "8"},
								{"1", "2", "3", "4", "5", "6", "7", "8"},
								
	};
	private class myTableModel extends AbstractTableModel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String[] columnNames;
		private HashMap<Integer, Artikel> data;
		
		public myTableModel(HashMap<Integer, Artikel> artikelliste, String[] columnNames) {
			this.columnNames = columnNames;
			this.data=artikelliste;
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
		
		public String getValueAt(int rowIndex, int columnIndex) {
			if(columnIndex == 0) {
				return String.valueOf(data.get(rowIndex).getArtikelnummer());
			}
			else if(columnIndex == 1) {
				return data.get(rowIndex).getBezeichnung();
			}
			else if(columnIndex == 2) {
				return data.get(rowIndex).getHersteller();
			}	
			else if(columnIndex == 3) {
				return String.valueOf(data.get(rowIndex).getBestand());
			}	
			else if(columnIndex == 4) {
				return String.valueOf(data.get(rowIndex).getPreis());
			}	
			else if(columnIndex == 5) {
				return String.valueOf(data.get(rowIndex).getRabatt());
			}	
			else if(columnIndex == 6) {
				return data.get(rowIndex).getVerf�gbarkeit();
			}	
			else if(columnIndex == 7) {
				if(data.get(rowIndex).getNotiz() != null)
					return String.valueOf(true);
				else
					return String.valueOf(false);
			}	
			else
				return null;
			
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
		getContentPane().setLayout(null);
		
		table = new JTable(new myTableModel(Artikelsammlung.getArtikelsammlung(), columnNames));
		table.setFillsViewportHeight(true);
		table.setDragEnabled(false);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(30, 42, 464, 395);
		getContentPane().add(scrollPane);
		
		
		setVisible(true);

	}
}
