package Frontend;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import Backend.GUIBestellpositionsliste;
import Bestellverwaltung.BestellStrg;
import Bestellverwaltung.Bestellung;
import Bestellverwaltung.BestellungSammlung;
import Logverwaltung.LogStrg;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
/**
 * 
 * @author Falk Maoro
 *
 */
public class GUIKontoBestellungen extends JPanel{
	
	private String[] columnNames = {"Bestell Nr", "Datum", "Gesamtpreis", "Rabatt", "Versandstatus"};
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
						return data.get(keys[rowIndex]).getBestellnr();
					}
					else if(columnIndex == 1) {
						return data.get(keys[rowIndex]).getDatum();
					}
					else if(columnIndex == 2) {
						return data.get(keys[rowIndex]).getGesamtpreis();
					}
					else if(columnIndex == 3) {
						return data.get(keys[rowIndex]).getErabatt();
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
	 * Stellt ein JPanel zur Verf�gung, in dem alle Bestellungen eines Kunde angezeigt werden k�nnen.
	 */
	public GUIKontoBestellungen() {
		
		int nutzernummer = LogStrg.getNutzerNr();
		setBounds(10, 11, 1226, 552);
		setLayout(null);
		setBackground(Color.DARK_GRAY);
		
		myTableModel model = new myTableModel(BestellungSammlung.getBestellungSammlung(nutzernummer), columnNames);
		table = new JTable(model);
		table.setRowHeight(18);
		table.setFont(new Font("Dialog", Font.PLAIN, 14));
		table.setFillsViewportHeight(true);
		table.setDragEnabled(false);
		setStructure();
	
		scrollpane = new JScrollPane();
		scrollpane.setBounds(10, 11, 949, 530);
		scrollpane.setVisible(true);
		scrollpane.setViewportView(table);
		add(scrollpane);
		
		Image Storno = new ImageIcon("src\\Icons 64x64\\multiply.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		JLabel lblStorno = new JLabel(new ImageIcon(Storno));
		lblStorno.setBounds(971, 76, 40, 40);
		add(lblStorno);
		
		JButton btnStoniereBestellung = new JButton("Bestellung stornieren");
		btnStoniereBestellung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
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
				}catch (ArrayIndexOutOfBoundsException b) {
					JOptionPane.showOptionDialog(null, "Bitte w�hlen Sie eine Zeile aus!",
							"Bestellung stornieren", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,
							new String[] { "Ok"}, "Ok");
					System.out.println("Index Fehler, keine Zeile ausgew�hlt");
				}
				
				
			}
		});
		
		btnStoniereBestellung.setFont(new Font("Dialog", Font.BOLD, 14));
		btnStoniereBestellung.setBackground(Color.WHITE);
		btnStoniereBestellung.setBounds(1029, 70, 187, 48);
		add(btnStoniereBestellung);
	
		Image Anzeigen = new ImageIcon("src\\Icons 64x64\\notepad.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		JLabel lblAnzeigen = new JLabel(new ImageIcon(Anzeigen));
		lblAnzeigen.setBounds(971, 16, 40, 40);
		add(lblAnzeigen);
		
		JButton btnBestellpos = new JButton("Bestellung anzeigen");
		btnBestellpos.setFont(new Font("Dialog", Font.BOLD, 14));
		btnBestellpos.setBounds(1029, 11, 187, 48);
		btnBestellpos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final HashMap<Integer, Bestellung> data = BestellungSammlung.getBestellungSammlung(nutzernummer);
				Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
				int i = (data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getBestellnr());
				try{
					new GUIBestellpositionenBK(i);
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

		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		table.getRowSorter().toggleSortOrder(1);
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sorter.setComparator(0, intcomp);
		sorter.setComparator(2, doublecomp);
		sorter.setComparator(3, intcomp);
	}

}
