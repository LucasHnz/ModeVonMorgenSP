package Backend;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import RechnungVerwaltung.BestellStrg;
import RechnungVerwaltung.Bestellung;
import RechnungVerwaltung.BestellungSammlung;

public class GUIBestellungListe extends JPanel {
	
	/**
	 * @author julian
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JScrollPane scrollpane;
	private String[] columnNames = {"Rechnungs Nr","Bestell Nr", "Gastkunden Nr","Bestandskunden Nr", "IBAN", "Nachname", "Vorname", "Gesamtpreis", "Rabatt", "Datum","Versandstatus", "Ort","Straße","PLZ"};

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
		
		public Object getValueAt(int rowIndex, int columnIndex) {
			Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
			try {
				if(columnIndex == 0) {
					return data.get(keys[rowIndex]).getRechnungsnr();
				}
				else if(columnIndex == 1) {
					return data.get(keys[rowIndex]).getBestellnr();
				}
				
				else if (columnIndex ==2) {
					return data.get(keys[rowIndex]).getNutzernrgk();
				}
				
				else if (columnIndex == 3) {
					return data.get(keys[rowIndex]).getNutzernrbk();
				}
				else if(columnIndex == 4) {
					return data.get(keys[rowIndex]).getIban();
				}		
				else if(columnIndex == 5) {
					return data.get(keys[rowIndex]).getNachname();
				}	
				else if(columnIndex == 6) {
					return data.get(keys[rowIndex]).getVorname();
				}	
				else if(columnIndex == 7) {
					return data.get(keys[rowIndex]).getGesamtpreis();
				}	
				else if(columnIndex == 8) {
					return data.get(keys[rowIndex]).getErabatt();
				}	
				else if(columnIndex == 9) {
					return data.get(keys[rowIndex]).getDatum();
				}
				else if (columnIndex == 10) {
					return data.get(keys[rowIndex]).getVersandstatus();
				}
				else if ( columnIndex == 11) {
					return data.get(keys[rowIndex]).getRechnungsort();
				}
				
				else if ( columnIndex == 12 ) {
					return data.get(keys[rowIndex]).getRechnungsstrasse();
				}
				
				else if ( columnIndex == 13 ) {
					return data.get(keys[rowIndex]).getRechnungsplz();
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
	public GUIBestellungListe() {
		
		
		RechnungVerwaltung.BestellungSammlung.füllenBestellungSammlung();
		setLayout(null);
		setBounds(90, 100, 1200, 600);
		setBackground(Color.DARK_GRAY);
		
		table = new JTable(new myTableModel(RechnungVerwaltung.BestellungSammlung.getBestellungSammlung(), columnNames));
		table.setFillsViewportHeight(true);
		table.setDragEnabled(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(110);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.getColumnModel().getColumn(3).setPreferredWidth(110);
		table.getColumnModel().getColumn(4).setPreferredWidth(60);
		table.getColumnModel().getColumn(5).setPreferredWidth(60);
		table.getColumnModel().getColumn(6).setPreferredWidth(60);
		table.getColumnModel().getColumn(7).setPreferredWidth(60);
		table.getColumnModel().getColumn(8).setPreferredWidth(60);
		table.getColumnModel().getColumn(9).setPreferredWidth(60);
		table.getColumnModel().getColumn(10).setPreferredWidth(60);
		table.getColumnModel().getColumn(10).setPreferredWidth(60);
		
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
		sorter.setComparator(8, intcomp);
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
		btnBestellungAnzeigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				System.out.println("Hier");
				
				final HashMap<Integer, Bestellung> data = RechnungVerwaltung.BestellungSammlung.getBestellungSammlung();
				Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
				int i = (data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getBestellnr());
				try{
					System.out.println(i);
					new GUIBestellpositionsliste(i);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnBestellungAnzeigen.setBounds(981, 11, 209, 48);
		add(btnBestellungAnzeigen);
		
		/**
		 * Button um VStatus zu ändern
		 */
		JButton btnÄndernVStatus = new JButton ("Versandstatus Ändern");
			btnÄndernVStatus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					final HashMap<Integer, Bestellung> data = RechnungVerwaltung.BestellungSammlung.getBestellungSammlung();
					Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
					int i = (data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getBestellnr());
					
					BestellStrg.aktualisiereVStatus(i);
					
				}
			});
		
			btnÄndernVStatus.setBounds(981,70,209,48);
			add(btnÄndernVStatus);
		
		setVisible(true);
		
		Image BEditieren = new ImageIcon("src\\Icons 64x64\\exchange.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		JLabel lblBEditieren = new JLabel(new ImageIcon(BEditieren));
		lblBEditieren.setBounds(920, 70, 40, 40);
		add(lblBEditieren);
		
		Image BAnzeigen = new ImageIcon("src\\Icons 64x64\\notepad.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		JLabel lblBAnzeigen = new JLabel(new ImageIcon(BAnzeigen));
		lblBAnzeigen.setBounds(920, 12, 40, 40);
		add(lblBAnzeigen);
		
		Image Blöschen = new ImageIcon("src\\Icons 64x64\\multiply.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		JLabel lblBlöschen = new JLabel(new ImageIcon(Blöschen));
		lblBlöschen.setBounds(920, 128, 40, 40);
		add(lblBlöschen);
		
		JButton btnNewButton = new JButton("Bestellung löschen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final HashMap<Integer, Bestellung> data = RechnungVerwaltung.BestellungSammlung.getBestellungSammlung();
				Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
				int i = (data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getBestellnr());
				BestellStrg.storniereBestellung(i);
				
			}
		});
		btnNewButton.setBounds(981, 129, 209, 48);
		add(btnNewButton);
		

	}
}
