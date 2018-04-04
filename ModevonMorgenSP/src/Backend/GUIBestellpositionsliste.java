package Backend;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
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
import Frontend.GUI;

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
			"Get�tigte R�cksendung" };

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
					return data.get(keys[rowIndex]).getR�cksendung();
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
		BestellpositionSammlung.f�lleMitSpeziellerNummer(i);
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
		scrollpane.setBounds(10, 11, 668, 390);
		scrollpane.setVisible(true);
		getContentPane().setLayout(null);
		scrollpane.setViewportView(table);
		getContentPane().add(scrollpane);

		getContentPane().add(scrollpane);
		// Cut
		/**
		 * Button um eine R�cksendung anzunehmen
		 */
		JButton btnR�cksAnnehmen = new JButton("R\u00FCcksendung Annehmen");
		btnR�cksAnnehmen.setBounds(738, 11, 215, 48);
		btnR�cksAnnehmen.setFont(new Font("Dialog", Font.BOLD, 14));
		btnR�cksAnnehmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				final HashMap<Integer, Bestellposition> data = BestellpositionSammlung.getBestellpositionsSammlung();
				Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
				String check = data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getR�cksendung();
				if (check.contentEquals("Keine R�cksendung")) {

					final Object optionPane = JOptionPane.showOptionDialog(null,
							"Sie sind dabei eine R�cksendung anzunehmen! \nFortfahren ?", "R�cksendung Annehmen",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,
							new String[] { "Ok", "Abbrechen" }, "Ok");

					if (optionPane.equals(0)) {
						
						int i =data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getPosNr();
		
						try {
						R�cksendungVerwaltung.R�cksendungStrg.erstelleR�cksendung(i);
						} catch (NullPointerException e) {
							JOptionPane.showOptionDialog(null, "Bitte w�hlen Sie eine Zeile aus!",
									"Artikel entfernen", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
									null, new String[] { "Ok"}, "Ok");
						}
						
							
						MailController.MailSenden.sendMail("julian-hermann@outlook.de","Best�tigung ihrer R�cksendung","Sehr geehrter Kunde, Hoffentlich finden Sie eine alternative");

						JOptionPane.showOptionDialog(null, "R�cksendung Angenommen!",
								"R�cksendung Angenommen", JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.WARNING_MESSAGE, null, new String[] { "Ok" }, "Ok");
						dispose();
					} else if (optionPane.equals(1)) {
						JOptionPane.showMessageDialog(null, "Vorgang abgebrochen!", "Abbruch",
								JOptionPane.ERROR_MESSAGE);
					}

				} else if (check.contentEquals("R�cksendung")) {

					JOptionPane.showOptionDialog(null, "F�r diese Bestellposition existiert bereits eine R�cksendung!",
							"R�cksendung Existiert bereits", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.WARNING_MESSAGE, null, new String[] { "Ok" }, "Ok");
					dispose();
				}}catch(ArrayIndexOutOfBoundsException g) {
					JOptionPane.showOptionDialog(null, "Bitte w�hlen Sie eine Zeile aus!",
							"Bestellung L�schen", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
							null, new String[] { "Ok" }, "Ok");
				}
			}
		});
		getContentPane().add(btnR�cksAnnehmen);

		/**
		 * Button um eine R�cksendung abzulehnen
		 */
		JButton btnR�cksAblehnen = new JButton("R\u00FCcksendung Ablehnen");
		btnR�cksAblehnen.setBounds(738, 81, 215, 48);
		btnR�cksAblehnen.setFont(new Font("Dialog", Font.BOLD, 14));
		btnR�cksAblehnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				final HashMap<Integer, Bestellposition> data = BestellpositionSammlung.getBestellpositionsSammlung();
				Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
				String check = data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getR�cksendung();
				if (check.contentEquals("Keine R�cksendung")) {
				
				final Object optionPane = JOptionPane.showOptionDialog(null,
						"Sie sind dabei eine R�cksendung abzulehnen! \nFortfahren ?", "R�cksendung Ablehnen",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,
						new String[] { "Ok", "Abbrechen" }, "Ok");

				if (optionPane.equals(0)) {
					
					MailController.MailSenden.sendMail("julian-hermann@outlook.de", "Ablehnung ihrer R�cksendung",
							"Sehr geehrter Kunde, /n Hoffentlich finden Sie eine alternative");
					JOptionPane.showOptionDialog(null, "R�cksendung wurde Abgelehnt!!",
							"R�cksendung Abgelehnt", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.WARNING_MESSAGE, null, new String[] { "Ok" }, "Ok");
					dispose();
				} else if (optionPane.equals(1)) {
					JOptionPane.showMessageDialog(null, "Vorgang abgebrochen!", "Abbruch",
							JOptionPane.ERROR_MESSAGE);
				}

			
			}
				
				else if ( check.contentEquals("R�cksendung")){
					JOptionPane.showOptionDialog(null, "F�r diese Bestellposition existiert bereits eine R�cksendung!",
							"R�cksendung Abgelehnt", JOptionPane.YES_NO_CANCEL_OPTION,
					
							JOptionPane.WARNING_MESSAGE, null, new String[] { "Ok" }, "Ok");
					dispose();
					}
				}catch(ArrayIndexOutOfBoundsException g) {
					JOptionPane.showOptionDialog(null, "Bitte w�hlen Sie eine Zeile aus!",
							"Bestellung L�schen", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
							null, new String[] { "Ok" }, "Ok");
				}
			}
			}
			
		);
		getContentPane().add(btnR�cksAblehnen);

		/**
		 * Button um zum Hauptfenster zurück zu kommen
		 */
		JButton btnZur�ck = new JButton("Beenden");
		btnZur�ck.setFont(new Font("Dialog", Font.BOLD, 14));
		btnZur�ck.setBounds(738, 149, 215, 48);
		btnZur�ck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					dispose();
				} catch (ConcurrentModificationException e) {
					e.printStackTrace();
				}
			}
		});
		getContentPane().add(btnZur�ck);
		setVisible(true);

		URL acceptUrl = GUI.class.getResource(
                "/Icons 64x64/checked.png");
		Image Annehmen = new ImageIcon(acceptUrl).getImage().getScaledInstance(40, 40,
				Image.SCALE_SMOOTH);
		JLabel lblAnnehmen = new JLabel(new ImageIcon(Annehmen));
		lblAnnehmen.setBounds(688, 11, 40, 40);
		getContentPane().add(lblAnnehmen);

		URL declineUrl = GUI.class.getResource(
                "/Icons 64x64/warning.png");
		Image Ablehnen = new ImageIcon(declineUrl).getImage().getScaledInstance(40, 40,
				Image.SCALE_SMOOTH);
		JLabel lblAblehnen = new JLabel(new ImageIcon(Ablehnen));
		lblAblehnen.setBounds(688, 81, 40, 40);
		getContentPane().add(lblAblehnen);

		URL zur�ckUrl = GUI.class.getResource(
                "/Icons 64x64/down-arrow.png");
		Image Zur�ck = new ImageIcon(zur�ckUrl).getImage().getScaledInstance(40, 40,
				Image.SCALE_SMOOTH);
		JLabel lblZur�ck = new JLabel(new ImageIcon(Zur�ck));
		lblZur�ck.setBounds(688, 149, 40, 40);
		getContentPane().add(lblZur�ck);
	}

}
