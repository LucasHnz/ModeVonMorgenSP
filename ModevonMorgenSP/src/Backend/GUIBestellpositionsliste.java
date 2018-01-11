package Backend;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import Bestellverwaltung.Bestellposition;
import Bestellverwaltung.BestellpositionSammlung;

/**
 * 
 * @author julian
 *
 */
public class GUIBestellpositionsliste extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JScrollPane scrollpane;
	private String[] columnNames = { "Bestellpositions Nr.", "Bestell Nr.", "Artikel Nr.", "Preis", "Menge",
			"Getätigte Rücksendung" };

	private class myTableModel extends AbstractTableModel {

		/**
		 * 
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String[] columnNames;
		private HashMap<Integer, Bestellposition> data;

		/**
		 * FÃ¼llt die Tabelle mit Bestellpositionen
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
				} else if (columnIndex == 1) {
					return data.get(keys[rowIndex]).getBestellNr();
				}

				else if (columnIndex == 2) {
					return data.get(keys[rowIndex]).getArtikelnummer();
				}

				else if (columnIndex == 3) {
					return data.get(keys[rowIndex]).getPreis();
				} else if (columnIndex == 4) {
					return data.get(keys[rowIndex]).getaMenge();
				}

				else if (columnIndex == 5) {
					return data.get(keys[rowIndex]).getRücksendung();
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
	 * Create the frame.
	 */
	public GUIBestellpositionsliste(int i) {
		getContentPane().setBackground(Color.DARK_GRAY);

		setBackground(Color.DARK_GRAY);
		BestellpositionSammlung.fülleMitSpeziellerNummer(i);
		setBounds(200, 200, 979, 446);
		setBackground(Color.DARK_GRAY);

		table = new JTable(
				new myTableModel(BestellpositionSammlung.getBestellpositionsSammlung(), columnNames));
		table.setFillsViewportHeight(true);
		table.setDragEnabled(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(20);
		table.getColumnModel().getColumn(5).setPreferredWidth(20);

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

		getContentPane().add(scrollpane);
		// Cut
		/**
		 * Button um eine Rücksendung anzunehmen
		 */
		JButton btnRücksAnnehmen = new JButton("R\u00FCcksendung Annehmen");
		btnRücksAnnehmen.setBounds(776, 11, 177, 48);
		btnRücksAnnehmen.setFont(new Font("Dialog", Font.BOLD, 14));
		btnRücksAnnehmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				final HashMap<Integer, Bestellposition> data = BestellpositionSammlung.getBestellpositionsSammlung();
				Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
				String check = data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getRücksendung();
				System.out.println(check);
				if (check.contentEquals("Keine Rücksendung")) {

					final Object optionPane = JOptionPane.showOptionDialog(null,
							"Sie sind dabei eine Rücksendung anzunehmen! \nFortfahren ?", "Rücksendung Annehmen",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,
							new String[] { "Ok", "Abbrechen" }, "Ok");

					if (optionPane.equals(0)) {
						
						int i =data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getPosNr();
						
						System.out.println(i);
						try {
						RücksendungVerwaltung.RücksendungStrg.erstelleRücksendung(i);
						} catch (NullPointerException e) {
							System.out.println("Nullpoitner");
						}
						
							
						MailController.MailSenden.sendMail("julian-hermann@outlook.de","Bestätigung ihrer Rücksendung","Sehr geehrter Kunde, Hoffentlich finden Sie eine alternative");

						JOptionPane.showOptionDialog(null, "Rücksendung Angenommen!",
								"Rücksendung Angenommen", JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.WARNING_MESSAGE, null, new String[] { "Ok" }, "Ok");
						dispose();
					} else if (optionPane.equals(1)) {
						JOptionPane.showMessageDialog(null, "Vorgang abgebrochen!", "Abbruch",
								JOptionPane.ERROR_MESSAGE);
					}

				} else if (check.contentEquals("Rücksendung")) {

					JOptionPane.showOptionDialog(null, "Für diese Bestellposition existiert bereits eine Rücksendung!",
							"Rücksendung Existiert bereits", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.WARNING_MESSAGE, null, new String[] { "Ok" }, "Ok");
					dispose();
				}
			}
		});
		getContentPane().add(btnRücksAnnehmen);

		/**
		 * Button um eine Rücksendung abzulehnen
		 */
		JButton btnRücksAblehnen = new JButton("R\u00FCcksendung Ablehnen");
		btnRücksAblehnen.setBounds(776, 81, 177, 48);
		btnRücksAblehnen.setFont(new Font("Dialog", Font.BOLD, 14));
		btnRücksAblehnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				final Object optionPane = JOptionPane.showOptionDialog(null,
						"Sie sind dabei eine Rücksendung abzulehnen! \nFortfahren ?", "Rücksendung Ablehnen",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,
						new String[] { "Ok", "Abbrechen" }, "Ok");

				if (optionPane.equals(0)) {
					
					MailController.MailSenden.sendMail("julian-hermann@outlook.de", "Ablehnung ihrer Rücksendung",
							"Sehr geehrter Kunde, /n Hoffentlich finden Sie eine alternative");
					JOptionPane.showOptionDialog(null, "Rücksendung wurde Abgelehnt!!",
							"Rücksendung Abgelehnt", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.WARNING_MESSAGE, null, new String[] { "Ok" }, "Ok");
					dispose();
				} else if (optionPane.equals(1)) {
					JOptionPane.showMessageDialog(null, "Vorgang abgebrochen!", "Abbruch",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		getContentPane().add(btnRücksAblehnen);

		/**
		 * Button um zum Hauptfenster zurÃ¼ck zu kommen
		 */
		JButton btnZurück = new JButton("Beenden");
		btnZurück.setFont(new Font("Dialog", Font.BOLD, 14));
		btnZurück.setBounds(776, 149, 177, 48);
		btnZurück.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					dispose();
				} catch (ConcurrentModificationException e) {
					System.out.println(e.getLocalizedMessage());
					System.out.println(e.getMessage());
				}
			}
		});
		getContentPane().add(btnZurück);
		setVisible(true);

		Image Annehmen = new ImageIcon("src\\Icons 64x64\\checked.png").getImage().getScaledInstance(40, 40,
				Image.SCALE_SMOOTH);
		JLabel lblAnnehmen = new JLabel(new ImageIcon(Annehmen));
		lblAnnehmen.setBounds(720, 12, 40, 40);
		getContentPane().add(lblAnnehmen);

		Image Ablehnen = new ImageIcon("src\\Icons 64x64\\warning.png").getImage().getScaledInstance(40, 40,
				Image.SCALE_SMOOTH);
		JLabel lblAblehnen = new JLabel(new ImageIcon(Ablehnen));
		lblAblehnen.setBounds(720, 82, 40, 40);
		getContentPane().add(lblAblehnen);

		Image Zurück = new ImageIcon("src\\Icons 64x64\\down-arrow.png").getImage().getScaledInstance(40, 40,
				Image.SCALE_SMOOTH);
		JLabel lblZurück = new JLabel(new ImageIcon(Zurück));
		lblZurück.setBounds(720, 150, 40, 40);
		getContentPane().add(lblZurück);
	}

}
