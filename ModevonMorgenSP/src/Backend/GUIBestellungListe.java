package Backend;

import java.awt.Color;
import java.awt.Font;
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

import Bestellverwaltung.BestellStrg;
import Bestellverwaltung.Bestellung;
import Bestellverwaltung.BestellungSammlung;

public class GUIBestellungListe extends JPanel {
	
	/**
	 * @author julian
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JScrollPane scrollpane;
	private String[] columnNames = {"Bestell Nr", "Gastkunden Nr","Bestandskunden Nr", "IBAN", "Nachname", "Vorname", "Gesamtpreis", "Rabatt", "Datum","Versandstatus", "Ort","Stra�e","PLZ"};

	private class myTableModel extends AbstractTableModel{

	
		private static final long serialVersionUID = 1L;
		private String[] columnNames;
		private HashMap<Integer, Bestellung> data;
		
		/**
		 * F�llt die Tabelle mit einer Bestellung-HashMap
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
					return data.get(keys[rowIndex]).getBestellnr();
				}
				
				else if (columnIndex ==1) {
					return data.get(keys[rowIndex]).getNutzernrgk();
				}
				
				else if (columnIndex == 2) {
					return data.get(keys[rowIndex]).getNutzernrbk();
				}
				else if(columnIndex == 3) {
					return data.get(keys[rowIndex]).getIban();
				}		
				else if(columnIndex == 4) {
					return data.get(keys[rowIndex]).getNachname();
				}	
				else if(columnIndex == 5) {
					return data.get(keys[rowIndex]).getVorname();
				}	
				else if(columnIndex == 6) {
					return data.get(keys[rowIndex]).getGesamtpreis();
				}	
				else if(columnIndex == 7) {
					return data.get(keys[rowIndex]).getErabatt();
				}	
				else if(columnIndex == 8) {
					return data.get(keys[rowIndex]).getDatum();
				}
				else if (columnIndex == 9) {
					return data.get(keys[rowIndex]).getVersandstatus();
				}
				else if ( columnIndex == 10) {
					return data.get(keys[rowIndex]).getRechnungsort();
				}
				
				else if ( columnIndex == 11 ) {
					return data.get(keys[rowIndex]).getRechnungsstrasse();
				}
				
				else if ( columnIndex == 12 ) {
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
		
		
		BestellungSammlung.f�llenBestellungSammlung();
		setLayout(null);
		setBounds(90, 100, 1200, 600);
		setBackground(Color.DARK_GRAY);
		
		table = new JTable(new myTableModel(BestellungSammlung.getBestellungSammlung(), columnNames));
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
		 * Button, der die Bestellpositions�bersicht zu einer speziellen Bestellung anzeigt
		 */
		JButton btnBestellungAnzeigen = new JButton("Bestellung anzeigen");
		btnBestellungAnzeigen.setFont(new Font("Dialog", Font.BOLD, 14));
		btnBestellungAnzeigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				try {
				final HashMap<Integer, Bestellung> data = BestellungSammlung.getBestellungSammlung();
				Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
				int i = (data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getBestellnr());
					System.out.println(i);
					new GUIBestellpositionsliste(i);
				}catch(ArrayIndexOutOfBoundsException q) {
						JOptionPane.showOptionDialog(null, "Bitte w�hlen Sie eine Zeile aus!",
								"Bestellung Anzeigen", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
								null, new String[] { "Ok"}, "Ok");
						System.out.println("Index Fehler, keine Zeile ausgew�hlt");
				}
			}
		});
		btnBestellungAnzeigen.setBounds(981, 11, 209, 48);
		add(btnBestellungAnzeigen);
		
		/**
		 * Button um VStatus zu �ndern
		 */
		JButton btn�ndernVStatus = new JButton ("Versandstatus �ndern");
		btn�ndernVStatus.setFont(new Font("Dialog", Font.BOLD, 14));
			btn�ndernVStatus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
					final HashMap<Integer, Bestellung> data = BestellungSammlung.getBestellungSammlung();
					Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
					int i = (data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getBestellnr());
					
					BestellStrg.aktualisiereVStatus(i);
					
				}catch(ArrayIndexOutOfBoundsException e) {
					JOptionPane.showOptionDialog(null, "Bitte w�hlen Sie eine Zeile aus!",
							"Bestellung VersandStatus �ndern", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
							null, new String[] { "Ok"}, "Ok");
					System.out.println("Index Fehler, keine Zeile ausgew�hlt");
				}
			}});
		
			btn�ndernVStatus.setBounds(981,70,209,48);
			add(btn�ndernVStatus);
		
		setVisible(true);
		
		Image BEditieren = new ImageIcon("src\\Icons 64x64\\exchange.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		JLabel lblBEditieren = new JLabel(new ImageIcon(BEditieren));
		lblBEditieren.setBounds(920, 70, 40, 40);
		add(lblBEditieren);
		
		Image BAnzeigen = new ImageIcon("src\\Icons 64x64\\notepad.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		JLabel lblBAnzeigen = new JLabel(new ImageIcon(BAnzeigen));
		lblBAnzeigen.setBounds(920, 12, 40, 40);
		add(lblBAnzeigen);
		
		Image Bl�schen = new ImageIcon("src\\Icons 64x64\\multiply.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		JLabel lblBl�schen = new JLabel(new ImageIcon(Bl�schen));
		lblBl�schen.setBounds(920, 128, 40, 40);
		add(lblBl�schen);
		
		JButton btnNewButton = new JButton("Bestellung l�schen");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				final HashMap<Integer, Bestellung> data = BestellungSammlung.getBestellungSammlung();
				Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
				int i = (data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getBestellnr());
	
				final Object optionPane = JOptionPane.showOptionDialog(null, "Sie sind dabei eine Bestellung zu l�schen!/n Fortfahren ?",
						"Bestellung Stornieren", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,
						new String[] { "Ok", "Abbrechen" }, "Ok");
				
				if(optionPane.equals(0)) {
					BestellStrg.storniereBestellung(i);
					JOptionPane.showMessageDialog(null,  "Bestellung wurde storniert", "Information", JOptionPane.INFORMATION_MESSAGE);
				}else if(optionPane.equals(1)) {
					JOptionPane.showMessageDialog(null,  "Vorgang abgebrochen!", "Abbruch", JOptionPane.ERROR_MESSAGE);
				}			

				
			}catch(ArrayIndexOutOfBoundsException g) {
				JOptionPane.showOptionDialog(null, "Bitte w�hlen Sie eine Zeile aus!",
						"Bestellung L�schen", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
						null, new String[] { "Ok" }, "Ok");
				System.out.println("Index Fehler, keine Zeile ausgew�hlt");
			}}
		});
		btnNewButton.setBounds(981, 129, 209, 48);
		add(btnNewButton);
		

	}
}
