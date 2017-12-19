package Backend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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
import Rechnungsverwaltung.Rechnung;
import Rechnungsverwaltung.RechnungsSammlung;
/**
 * 
 * @author annag
 *
 */

public class GUIRechnungBestesllungsliste extends JPanel{

private static final long serialVersionUID = 1L;
private JTable table;
private JScrollPane scrollpane;
private String[] columnNames = {"Nutzernr","BestellNr ","GesamterPreis","Straße", "Ort", "PLZ","VersandStatus"};

private class myTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] columnNames;
	private HashMap<Integer, Rechnung> data;
	
	public myTableModel(HashMap<Integer, Rechnung> RechnungBestellungsliste, String[] columnNames) {
		this.columnNames = columnNames;
		this.data = RechnungBestellungsliste;
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
				return data.get(keys[rowIndex]).getMitgliedsID();
			}
			else if(columnIndex == 1) {
				return data.get(keys[rowIndex]).getBestellNr();
			}
			else if(columnIndex == 2) {
				return data.get(keys[rowIndex]).getGesamtpreis();
			}		
			else if(columnIndex == 3) {
				return data.get(keys[rowIndex]).getStraße();
			}	
			else if(columnIndex == 4) {
				return data.get(keys[rowIndex]).getOrt();
			}	
			else if(columnIndex == 5) {
				return data.get(keys[rowIndex]).getPlz();
			}	
			else if(columnIndex == 6) {
				return data.get(keys[rowIndex]).getVstatus();
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
	public GUIRechnungBestesllungsliste() {
	//RechnungSammlung.fülleRechnungsliste();
	setLayout(null);
	setBounds(90, 100, 1200, 600);
	setBackground(Color.DARK_GRAY);
	
	table = new JTable(new myTableModel(RechnungsSammlung.getRechnungsSammlung(), columnNames));
	table.setFillsViewportHeight(true);
	table.setDragEnabled(false);
	table.getColumnModel().getColumn(0).setPreferredWidth(60);
	table.getColumnModel().getColumn(1).setPreferredWidth(80);
	table.getColumnModel().getColumn(2).setPreferredWidth(60);
	table.getColumnModel().getColumn(3).setPreferredWidth(120);
	table.getColumnModel().getColumn(4).setPreferredWidth(100);
	table.getColumnModel().getColumn(5).setPreferredWidth(80);
	table.getColumnModel().getColumn(6).setPreferredWidth(35);

	
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
	table.setBounds(30,42,800,395);
	table.setVisible(true);
	
	scrollpane = new JScrollPane();
	scrollpane.setBounds(10, 11, 900, 490);
	scrollpane.setVisible(true);
	scrollpane.setViewportView(table);
	add(scrollpane);
	
	
	JButton btnAnzeigenBestellungBK = new JButton("BestandskundenBestellungen");
	btnAnzeigenBestellungBK.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			//methode aufrufen
		}
	});
	btnAnzeigenBestellungBK.setBounds(920, 11, 270, 48);
	add(btnAnzeigenBestellungBK);
	
	JButton btnAnzeigenBestellungGK = new JButton("");
	btnAnzeigenBestellungGK.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
	//methode aufrufen
		}
	});
	
	btnAnzeigenBestellungGK.setBounds(920,70,270,48);
	add(btnAnzeigenBestellungGK);
	
	
}
}
