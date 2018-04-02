package Backend;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Comparator;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import Bestellverwaltung.BestellStrg;
import Bestellverwaltung.Bestellung;
import Bestellverwaltung.BestellungSammlung;
import Frontend.GUI;

public class GUIBestellungListe extends JPanel {
	
	/**
	 * @author julian
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JScrollPane scrollpane;
	private String[] columnNames = {"Bestell Nr", "Kundennummer", "Nachname", "Vorname", "Preis (€)", "Rabatt (%)", "Datum", "Status", "Ort", "Straße","PLZ"};
	TableRowSorter<TableModel> sorter = null;

	private class myTableModel extends AbstractTableModel{

	
		private static final long serialVersionUID = 1L;
		private String[] columnNames;
		private HashMap<Integer, Bestellung> data;
		
		/**
		 * Füllt die Tabelle mit einer Bestellung-HashMap
		 * @param Rechnungsliste
		 * @param columnNames
		 */
		public myTableModel(HashMap<Integer, Bestellung> Rechnungsliste, String[] columnNames) {
			this.columnNames = columnNames;
			this.data = Rechnungsliste;
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
			else if(columnIndex == 8) {
				return getValueAt(0, columnIndex).getClass();
			}
			else if(columnIndex == 9) {
				return getValueAt(0, columnIndex).getClass();
			}
			else if(columnIndex == 10) {
				return getValueAt(0, columnIndex).getClass();
			}
			else 
				return null;
		}
		
		public Object getValueAt(int rowIndex, int columnIndex) {
			Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
			try {
				if(columnIndex == 0) {
					return data.get(keys[rowIndex]).getBestellnr();
				}
				
				else if (columnIndex ==1) {
					if(data.get(keys[rowIndex]).getNutzernrgk() != 0)
						return data.get(keys[rowIndex]).getNutzernrgk();
					else
						return data.get(keys[rowIndex]).getNutzernrbk();
				}		
				else if(columnIndex == 2) {
					return data.get(keys[rowIndex]).getNachname();
				}	
				else if(columnIndex == 3) {
					return data.get(keys[rowIndex]).getVorname();
				}	
				else if(columnIndex == 4) {
					return data.get(keys[rowIndex]).getGesamtpreis();
				}	
				else if(columnIndex == 5) {
					return data.get(keys[rowIndex]).getErabatt();
				}	
				else if(columnIndex == 6) {
					return data.get(keys[rowIndex]).getDatum();
				}
				else if (columnIndex == 7) {
					return data.get(keys[rowIndex]).getVersandstatus();
				}
				else if ( columnIndex == 8) {
					return data.get(keys[rowIndex]).getRechnungsort();
				}
				
				else if ( columnIndex == 9 ) {
					return data.get(keys[rowIndex]).getRechnungsstrasse();
				}
				
				else if ( columnIndex == 10 ) {
					return data.get(keys[rowIndex]).getRechnungsplz();
				}
				else
					return null;
			
			}catch(NullPointerException e) {
				String a = null;
				return a;
			}catch (ArrayIndexOutOfBoundsException r) {
				return null;
			}
		}
		
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;	
		}
					
	}

	/**
	 * Create the frame.
	 */
	public GUIBestellungListe() {
		
		
		BestellungSammlung.füllenBestellungSammlung();
		setLayout(null);
		setBounds(90, 100, 1200, 600);
		setBackground(Color.DARK_GRAY);
		
		table = new JTable(new myTableModel(BestellungSammlung.getBestellungSammlung(), columnNames));
		table.setFillsViewportHeight(true);
		table.setDragEnabled(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(68);
		table.getColumnModel().getColumn(3).setPreferredWidth(68);
		table.getColumnModel().getColumn(4).setPreferredWidth(55);
		table.getColumnModel().getColumn(5).setPreferredWidth(62);
		table.getColumnModel().getColumn(6).setPreferredWidth(80);
		table.getColumnModel().getColumn(7).setPreferredWidth(80);
		table.getColumnModel().getColumn(8).setPreferredWidth(80);
		table.getColumnModel().getColumn(9).setPreferredWidth(60);
		table.getColumnModel().getColumn(10).setPreferredWidth(40);
		
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
		
		sorter = new TableRowSorter<TableModel>(table.getModel());
		sorter.setComparator(4, doublecomp);
		sorter.setComparator(5, intcomp);
		sorter.setComparator(10, intcomp);
		table.setRowSorter(sorter);
		table.getRowSorter().toggleSortOrder(0);
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(30,42,800, 395);
		table.setVisible(true);
		
		scrollpane = new JScrollPane();
		scrollpane.setBounds(10, 11, 900, 490);
		scrollpane.setVisible(true);
		scrollpane.setViewportView(table);
		add(scrollpane);
		
		/**
		 * Button, der die Bestellpositionsübersicht zu einer speziellen Bestellung anzeigt
		 */
		JButton btnBestellungAnzeigen = new JButton("Bestellung anzeigen");
		btnBestellungAnzeigen.setFont(new Font("Dialog", Font.BOLD, 14));
		btnBestellungAnzeigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				try {
				final HashMap<Integer, Bestellung> data = BestellungSammlung.getBestellungSammlung();
				Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
				int i = (data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getBestellnr());
					new GUIBestellpositionsliste(i);
				}catch(ArrayIndexOutOfBoundsException q) {
						JOptionPane.showOptionDialog(null, "Bitte wählen Sie eine Zeile aus!",
								"Bestellung Anzeigen", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
								null, new String[] { "Ok"}, "Ok");
				}
			}
		});
		btnBestellungAnzeigen.setBounds(981, 11, 209, 48);
		add(btnBestellungAnzeigen);
		
		/**
		 * Button um VStatus zu ändern
		 */
		JButton btnÄndernVStatus = new JButton ("Versandstatus Ändern");
		btnÄndernVStatus.setFont(new Font("Dialog", Font.BOLD, 14));
			btnÄndernVStatus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
					final HashMap<Integer, Bestellung> data = BestellungSammlung.getBestellungSammlung();
					Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
					int i = (data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getBestellnr());
					
					BestellStrg.aktualisiereVStatus(i);
					
				}catch(ArrayIndexOutOfBoundsException e) {
					JOptionPane.showOptionDialog(null, "Bitte wählen Sie eine Zeile aus!",
							"Bestellung VersandStatus ändern", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
							null, new String[] { "Ok"}, "Ok");
				}
			}});
		
			btnÄndernVStatus.setBounds(981,70,209,48);
			add(btnÄndernVStatus);
		
		setVisible(true);
		
		URL editUrl = GUI.class.getResource(
                "/Icons 64x64/exchange.png");
		Image BEditieren = new ImageIcon(editUrl).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		JLabel lblBEditieren = new JLabel(new ImageIcon(BEditieren));
		lblBEditieren.setBounds(920, 70, 40, 40);
		add(lblBEditieren);
		
		URL anzeigenUrl = GUI.class.getResource(
                "/Icons 64x64/notepad.png");
		Image BAnzeigen = new ImageIcon(anzeigenUrl).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		JLabel lblBAnzeigen = new JLabel(new ImageIcon(BAnzeigen));
		lblBAnzeigen.setBounds(920, 12, 40, 40);
		add(lblBAnzeigen);
		
		URL löschenUrl = GUI.class.getResource(
                "/Icons 64x64/multiply.png");
		Image Blöschen = new ImageIcon(löschenUrl).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		JLabel lblBlöschen = new JLabel(new ImageIcon(Blöschen));
		lblBlöschen.setBounds(920, 128, 40, 40);
		add(lblBlöschen);
		
		JButton btnNewButton = new JButton("Bestellung löschen");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				final HashMap<Integer, Bestellung> data = BestellungSammlung.getBestellungSammlung();
				Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
				int i = (data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getBestellnr());
	
				final Object optionPane = JOptionPane.showOptionDialog(null, "Sie sind dabei eine Bestellung zu löschen!/n Fortfahren ?",
						"Bestellung Stornieren", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,
						new String[] { "Ok", "Abbrechen" }, "Ok");
				
				if(optionPane.equals(0)) {
					BestellStrg.storniereBestellung(BestellungSammlung.getBestellungSammlung(), i);
					JOptionPane.showMessageDialog(null,  "Bestellung wurde storniert", "Information", JOptionPane.INFORMATION_MESSAGE);
				}else if(optionPane.equals(1)) {
					JOptionPane.showMessageDialog(null,  "Vorgang abgebrochen!", "Abbruch", JOptionPane.ERROR_MESSAGE);
				}			

				
			}catch(ArrayIndexOutOfBoundsException g) {
				JOptionPane.showOptionDialog(null, "Bitte wählen Sie eine Zeile aus!",
						"Bestellung Löschen", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
						null, new String[] { "Ok" }, "Ok");
			}}
		});
		btnNewButton.setBounds(981, 129, 209, 48);
		add(btnNewButton);
		

	}
}
