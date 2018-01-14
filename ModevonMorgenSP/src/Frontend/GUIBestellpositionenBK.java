package Frontend;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Artikelverwaltung.Artikelsammlung;
import Bestellverwaltung.Bestellposition;
import Bestellverwaltung.BestellpositionSammlung;
import java.awt.Font;

/**
 * 
 * @author Falk Maoro
 *
 */
public class GUIBestellpositionenBK  extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JScrollPane scrollpane;
	private String[] columnNames = { "Bestellpositions Nr.", "Artikel Nr.", "Bezeichnung", "Preis", "Menge" };

	private class myTableModel extends AbstractTableModel {

		/**
		 * 
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String[] columnNames;
		private HashMap<Integer, Bestellposition> data;

		/**
		 * Füllt die Tabelle mit Bestellpositionen
		 * 
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
				if (columnIndex == 0) {
					return data.get(keys[rowIndex]).getPosNr();
				} 
				else if (columnIndex == 1) {
					return data.get(keys[rowIndex]).getArtikelnummer();
				}
				else if (columnIndex == 2) {
					return Artikelsammlung.getArtikel(data.get(keys[rowIndex]).getArtikelnummer()).getBezeichnung();
				}
				else if(columnIndex == 3) {
					return data.get(keys[rowIndex]).getPreis();
				} else if (columnIndex == 4) {
					return data.get(keys[rowIndex]).getaMenge();
				} else
					return null;

			} catch (NullPointerException e) {
				String a = null;
				return a;
			}
		}

		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}

	}

	/**
	 * Zeigt die Bestellpositionen einer Bestellung für den Kunden an.
	 * @param bestellnr Die Bestellnummer
	 */
	public GUIBestellpositionenBK(int bestellnr) {
		getContentPane().setBackground(Color.DARK_GRAY);

		setBackground(Color.DARK_GRAY);
		BestellpositionSammlung.fülleMitSpeziellerNummer(bestellnr);
		setBounds(200, 200, 979, 446);
		setBackground(Color.DARK_GRAY);
		setResizable(false);
		setTitle("Bestellpositionen der Bestellung: " + bestellnr);

		table = new JTable(
				new myTableModel(BestellpositionSammlung.getBestellpositionsSammlung(), columnNames));
		table.setFont(new Font("Dialog", Font.PLAIN, 13));
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
				if (o1 > o2)
					return 1;
				else if (o1 < o2)
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
		table.setBounds(30, 42, 250, 210);
		table.setVisible(true);

		scrollpane = new JScrollPane();
		scrollpane.setBounds(10, 11, 700, 390);
		scrollpane.setVisible(true);
		getContentPane().setLayout(null);
		scrollpane.setViewportView(table);
		getContentPane().add(scrollpane);

		
		
		JButton btnArtikel = new JButton("Zum Artikel");
		btnArtikel.setFont(new Font("Dialog", Font.BOLD, 13));
		btnArtikel.setBounds(776, 11, 177, 48);
		btnArtikel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				final HashMap<Integer, Bestellposition> data = BestellpositionSammlung.getBestellpositionsSammlung();
				Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
				int artnr = data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getArtikelnummer();
				GUI.getFenster().changePanel(GUIArtikel.getGUIArtikel(artnr));
				
			}
		});
		getContentPane().add(btnArtikel);

		/**
		 * Button um zum Hauptfenster zurÃ¼ck zu kommen
		 */
		JButton btnZurück = new JButton("Beenden");
		btnZurück.setFont(new Font("Dialog", Font.BOLD, 13));
		btnZurück.setBounds(776, 70, 177, 48);
		btnZurück.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					dispose();
			}
		});
		getContentPane().add(btnZurück);
		setVisible(true);

		Image Annehmen = new ImageIcon("src\\Icons 64x64\\right-chevron.png").getImage().getScaledInstance(40, 40,
				Image.SCALE_SMOOTH);
		JLabel lblArtikel = new JLabel(new ImageIcon(Annehmen));
		lblArtikel.setBounds(720, 12, 40, 40);
		getContentPane().add(lblArtikel);


		Image Zurück = new ImageIcon("src\\Icons 64x64\\logout.png").getImage().getScaledInstance(40, 40,
				Image.SCALE_SMOOTH);
		JLabel lblZurück = new JLabel(new ImageIcon(Zurück));
		lblZurück.setBounds(720, 76, 40, 40);
		getContentPane().add(lblZurück);
	}

}
