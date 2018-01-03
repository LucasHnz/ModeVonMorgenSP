package Backend;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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


import Bestellverwaltung.Bestellposition;
import Bestellverwaltung.BestellpositionSammlung;

import RechnungVerwaltung.Bestellung;
import RücksendungVerwaltung.Rücksendung;
import RücksendungVerwaltung.RücksendungSammlung;

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
		setBounds(200, 200, 979, 446);
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
		table.setBounds(30,42,250, 210);
		table.setVisible(true);
		
		scrollpane = new JScrollPane();
		scrollpane.setBounds(10, 11, 700, 390);
		scrollpane.setVisible(true);
		getContentPane().setLayout(null);
		scrollpane.setViewportView(table);
		getContentPane().add(scrollpane);
		
		getContentPane().add(scrollpane);
		// Cut
		/**
		 * Button um eine Rücksendung anzunehmen
		 */
		JButton btnRücksAnnehmen = new JButton("R\u00FCcksendung Annehmen");
		btnRücksAnnehmen.setBounds(776, 11, 177, 48);
		btnRücksAnnehmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				JOptionPane.showOptionDialog(null, "Sie sind dabei eine Rücksendung anzunehmen! \nFortfahren ?","Rücksendung Annehmen",
		                JOptionPane.YES_NO_CANCEL_OPTION,
		                JOptionPane.WARNING_MESSAGE, null, 
		                new String[]{"Ok", "Abbrechen"}, "Ok");
				
				final HashMap<Integer, Bestellposition> data = BestellpositionSammlung.getBestellpositionsSammlung();
				Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
				
				int i =data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getPosNr();
				
				System.out.println(i);
				
				RücksendungVerwaltung.RücksendungStrg.erstelleRücksendung(i);
				
				MailController.MailSenden.sendMail("julian-hermann@outlook.de","Bestätigung ihrer Rücksendung","Sehr geehrter Kunde, /n Hoffentlich finden Sie eine alternative");
			}});
		getContentPane().add(btnRücksAnnehmen);
		
		/**
		 * Button um eine Rücksendung abzulehnen
		 */
		JButton btnRücksAblehnen = new JButton("R\u00FCcksendung Ablehnen");
		btnRücksAblehnen.setBounds(776, 81, 177, 48);
		btnRücksAblehnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					MailController.MailSenden.sendMail("julian-hermann@outlook.de","Ablehnung ihrer Rücksendung","Sehr geehrter Kunde, /n Hoffentlich finden Sie eine alternative");
			
				
			}
		});
		getContentPane().add(btnRücksAblehnen);
		
		
		/**
		 * Button um zum Hauptfenster zurück zu kommen
		 */
		JButton btnZurück = new JButton ("Beenden");
		btnZurück.setBounds(776, 149, 177, 48);
			btnZurück.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
					Bestellverwaltung.BestellpositionSammlung.entferneDatenAusListe();
					dispose();
				}catch(ConcurrentModificationException e) {
					System.out.println(e.getLocalizedMessage());
					System.out.println(e.getMessage());
					}}
			}
			);
			getContentPane().add(btnZurück);
			setVisible(true);
			
			Image Annehmen = new ImageIcon("src\\Icons 64x64\\checked.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
			JLabel lblAnnehmen = new JLabel(new ImageIcon(Annehmen));
			lblAnnehmen.setBounds(720, 12, 40, 40);
			getContentPane().add(lblAnnehmen);
			
			Image Ablehnen = new ImageIcon("src\\Icons 64x64\\warning.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
			JLabel lblAblehnen = new JLabel(new ImageIcon(Ablehnen));
			lblAblehnen.setBounds(720, 82, 40, 40);
			getContentPane().add(lblAblehnen);
			
			Image Zurück = new ImageIcon("src\\Icons 64x64\\down-arrow.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
			JLabel lblZurück = new JLabel(new ImageIcon(Zurück));
			lblZurück.setBounds(720, 150, 40, 40);
			getContentPane().add(lblZurück);
		}
	
	
	
	

	}

