package Frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Artikelverwaltung.Artikel;
import Artikelverwaltung.ArtikelStrg;
import Artikelverwaltung.Artikelsammlung;
import Backend.GUIArtikelFormular;
import Backend.GUIBestellpositionsliste;
import Bestellverwaltung.BestellStrg;
import Bestellverwaltung.Bestellung;
import Bestellverwaltung.BestellungSammlung;
import Logverwaltung.LogStrg;
/**
 * 
 * @author Falk Maoro
 *
 */
public class GUIKontoBestellungen extends JPanel{
	
	private String[] columnNames = {"Rechnungs Nr", "IBAN", "Gesamtpreis", "Rabatt", "Datum", "Versandstatus"};
	private JTable table;
	private JScrollPane scrollpane;
	
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
	
	private class myTableModel extends AbstractTableModel{
			
		private String[] columnNames;
		private HashMap<Integer, Bestellung> data;

		public myTableModel(HashMap<Integer, Bestellung> Bestellungsliste, String[] columnNames) {
			this.data = Bestellungsliste;
			this.columnNames = columnNames;
			}
			public int getColumnCount() {
				return columnNames.length;
			}
			public int getRowCount() {
				return data.size();
			}
			public Object getValueAt(int rowIndex, int columnIndex) {
				Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
				try {
					if(columnIndex == 0) {
						return data.get(keys[rowIndex]).getIban();
					}
					else if(columnIndex == 1) {
						return data.get(keys[rowIndex]).getGesamtpreis();
					}
					else if(columnIndex == 2) {
						return data.get(keys[rowIndex]).getErabatt();
					}
					else if(columnIndex == 3) {
						return data.get(keys[rowIndex]).getDatum();
					}
					else if (columnIndex == 4) {
						return data.get(keys[rowIndex]).getVersandstatus();
					}
					else 
						return null;
				
				}catch(NullPointerException e) {
					String a = null;
					return a;
				}	
				
			}
			public String getColumnName(int columnIndex) {
				return columnNames[columnIndex].toString();
			}
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;	
			}
		}
	/**
	 * Stellt ein JPanel zur Verfügung, in dem alle Bestellungen eines Kunde angezeigt werden können.
	 */
	public GUIKontoBestellungen() {
		
		int nutzernummer = LogStrg.getNutzerNr();
		setBounds(10, 11, 1226, 552);
		setLayout(null);
		setBackground(Color.DARK_GRAY);
		
		myTableModel model = new myTableModel(BestellungSammlung.getBestellungSammlung(nutzernummer), columnNames);
		table = new JTable(model);
		table.setFillsViewportHeight(true);
		table.setDragEnabled(false);
		setStructure();
	
		scrollpane = new JScrollPane();
		scrollpane.setBounds(10, 11, 949, 530);
		scrollpane.setVisible(true);
		scrollpane.setViewportView(table);
		add(scrollpane);
		
		JButton btnStoniereBestellung = new JButton("Bestellung stornieren");
		btnStoniereBestellung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final HashMap<Integer, Bestellung> data = BestellungSammlung.getBestellungSammlung(nutzernummer);
				Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
				int bestellnr = data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getBestellnr();
				
				final Object optionPane = JOptionPane.showConfirmDialog(null,
						"Wollen Sie die Bestellung: \n" + data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getBestellnr() 
						+ "\nwirklich stornieren?", "Abfrage",
						JOptionPane.YES_NO_OPTION);
					
				if(optionPane.equals(0)) {
					BestellStrg.storniereBestellung(bestellnr);
					model.fireTableStructureChanged();
					setStructure();
					JOptionPane.showMessageDialog(null,  "Bestellung wurde storniert!", "Information", JOptionPane.INFORMATION_MESSAGE);
				}else if(optionPane.equals(1)) {
					JOptionPane.showMessageDialog(null,  "Vorgang abgebrochen!", "Abbruch", JOptionPane.ERROR_MESSAGE);
				}			
				
			}
		});
		btnStoniereBestellung.setFont(new Font("Calibri", Font.BOLD, 15));
		btnStoniereBestellung.setBackground(Color.WHITE);
		btnStoniereBestellung.setBounds(983, 70, 209, 48);
		//btnStoniereBestellung.addActionListener(this);
		add(btnStoniereBestellung);
		
		JButton btnBestellpos = new JButton("Bestellung anzeigen");
		btnBestellpos.setFont(new Font("Calibri", Font.BOLD, 15));
		btnBestellpos.setBounds(983, 11, 209, 48);
		btnBestellpos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final HashMap<Integer, Bestellung> data = BestellungSammlung.getBestellungSammlung(nutzernummer);
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
		add(btnBestellpos);
	
		setVisible(true);
		

	}
	/**
	 * Baut das JTable neu auf. 
	 */
	public void setStructure() {
		table.setDragEnabled(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		table.getColumnModel().getColumn(4).setPreferredWidth(30);
		table.getColumnModel().getColumn(5).setPreferredWidth(30);

		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		table.getRowSorter().toggleSortOrder(0);
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sorter.setComparator(0, intcomp);
		sorter.setComparator(2, doublecomp);
		sorter.setComparator(3, intcomp);
	}

}