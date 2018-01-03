package Backend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import AdministratorVerwaltung.Administrator;
import AdministratorVerwaltung.AdministratorSammlung;
import Artikelverwaltung.Artikel;
import Artikelverwaltung.ArtikelStrg;
import Artikelverwaltung.Artikelsammlung;
import MitarbeiterVerwaltung.Mitarbeiter;
import MitarbeiterVerwaltung.MitarbeiterSammlung;

/**
 * 
 * @author julian
 *
 */
public class GUIMitarbeiterListe extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JScrollPane scrollpane;
	private String[] columnNames = { "Nutzer Nummer", "Vorgesetzter", "Nachname", "Vorname", "E-Mail", "Stra�e", "Ort",
			"PLZ", "IBAN", "Gehalt", "Berechtigung", "Passwort" };

	private class myTableModel extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String[] columnNames;
		private HashMap<Integer, Mitarbeiter> data;

		/**
		 * F�llt die Tabelle mit einer Mitarbeiter HashMap
		 * 
		 * @param mitarbeiterliste
		 * @param columnNames
		 */
		public myTableModel(HashMap<Integer, Mitarbeiter> mitarbeiterliste, String[] columnNames) {
			this.columnNames = columnNames;
			this.data = mitarbeiterliste;
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
					return data.get(keys[rowIndex]).getNutzernr();
				} else if (columnIndex == 1) {
					return data.get(keys[rowIndex]).getAdminnr();
				} else if (columnIndex == 2) {
					return data.get(keys[rowIndex]).getNachname();
				} else if (columnIndex == 3) {
					return data.get(keys[rowIndex]).getVorname();
				} else if (columnIndex == 4) {
					return data.get(keys[rowIndex]).getEmail();
				} else if (columnIndex == 5) {
					return data.get(keys[rowIndex]).getStra�e();
				} else if (columnIndex == 6) {
					return data.get(keys[rowIndex]).getOrt();
				} else if (columnIndex == 7) {

					return data.get(keys[rowIndex]).getPlz();
				}

				else if (columnIndex == 8) {

					return data.get(keys[rowIndex]).getIban();
				} else if (columnIndex == 9) {

					return data.get(keys[rowIndex]).getGehalt();
				}

				else if (columnIndex == 10) {

					return data.get(keys[rowIndex]).getBerechtigung();
				} else if (columnIndex == 11) {

					return data.get(keys[rowIndex]).getPasswort();
				}

				else
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
	public GUIMitarbeiterListe() throws SQLException {
		setBackground(Color.DARK_GRAY);
		MitarbeiterSammlung.mitarbeiterSammlung();
		setLayout(null);
		setBounds(90, 100, 1200, 600);

		Comparator<Double> doublecomp = new Comparator<Double>() {
			@Override
			public int compare(Double o1, Double o2) {
				if (o1 > o2)
					return 1;
				else if (o1 < o2)
					return -1;
				else
					return 0;
			}
		};

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

		scrollpane = new JScrollPane();
		// scrollpane.setLayout(null);
		scrollpane.setBounds(10, 11, 900, 490);

		table = new JTable(new myTableModel(MitarbeiterSammlung.getMitarbeitersammlung(), columnNames));
		scrollpane.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.setDragEnabled(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(110);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(80);
		table.getColumnModel().getColumn(5).setPreferredWidth(80);
		table.getColumnModel().getColumn(6).setPreferredWidth(80);
		table.getColumnModel().getColumn(7).setPreferredWidth(80);

		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		table.getRowSorter().toggleSortOrder(0);
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sorter.setComparator(3, intcomp);
		sorter.setComparator(4, doublecomp);
		sorter.setComparator(5, intcomp);

		add(scrollpane);

		/**
		 * erstell das Pop Up Fenster f�r eine Mitarbeiter Hinzuf�gen Operation
		 */
		JButton btnNeuerMitarbeiter = new JButton("Mitarbeiter hinzuf�gen");
		btnNeuerMitarbeiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new GUIMitarbeiterErstellenFormular();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		});
		btnNeuerMitarbeiter.setBounds(981, 11, 209, 48);
		add(btnNeuerMitarbeiter);

		/**
		 * Erstellt ein Pop Up Fenster um einen ausgew�hlten Mitarbeiter zu editieren
		 */
		JButton btnEditiereMitarbeiter = new JButton("Mitarbeiter editieren");
		btnEditiereMitarbeiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					final HashMap<Integer, Mitarbeiter> data = MitarbeiterSammlung.getMitarbeitersammlung();
					Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
					try {
						new GUIMitarbeiterBearbeiten(
								data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getNutzernr());

					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					JOptionPane.showOptionDialog(null, "Bitte w�hlen Sie eine Zeile aus!",
							"Mitarbeiter Bearbeiten", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
							null, new String[] { "Ok"}, "Ok");
					System.out.println("Index Fehler, keine Zeile ausgew�hlt");
				}
			}
		});
		btnEditiereMitarbeiter.setBounds(981, 70, 209, 48);
		add(btnEditiereMitarbeiter);

		/**
		 * l�scht einen ausgew�hlten Mitarbeiter
		 */
		JButton btnL�scheMitarbeiter = new JButton("Mitarbeiter l�schen");
		btnL�scheMitarbeiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					final HashMap<Integer, Mitarbeiter> data = MitarbeiterSammlung.getMitarbeitersammlung();
					Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
					int i = (data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getNutzernr());

					final Object optionPane = JOptionPane.showOptionDialog(null, "Sie sind dabei einen Mitarbeiter zu l�schen! Fortfahren ?",
							"Mitarbeiter L�schen", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,
							new String[] { "Ok", "Abbrechen" }, "Ok");

					
					
					if(optionPane.equals(0)) {
						MitarbeiterVerwaltung.MitarbeiterStrg.entferneMitarbeiter(i);
						JOptionPane.showMessageDialog(null,  "Mitarbeiter wurde gel�scht.", "Information", JOptionPane.INFORMATION_MESSAGE);
					}else if(optionPane.equals(1)) {
						JOptionPane.showMessageDialog(null,  "Vorgang abgebrochen!", "Abbruch", JOptionPane.ERROR_MESSAGE);
					}			

				} catch (ArrayIndexOutOfBoundsException e) {
					JOptionPane.showOptionDialog(null, "Bitte w�hlen Sie eine Zeile aus!",
							"Mitarbeiter L�schen", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,
							new String[] { "Ok"}, "Ok");
					System.out.println("Index Fehler, keine Zeile ausgew�hlt");
				}
			}
		});
		btnL�scheMitarbeiter.setBounds(981, 129, 209, 48);
		add(btnL�scheMitarbeiter);
		setVisible(true);

		Image MAEditieren = new ImageIcon("src\\Icons 64x64\\repair-tools.png").getImage().getScaledInstance(40, 40,
				Image.SCALE_SMOOTH);
		JLabel lblMAEditieren = new JLabel(new ImageIcon(MAEditieren));
		lblMAEditieren.setBounds(920, 70, 40, 40);
		add(lblMAEditieren);

		Image MAHinzuf�gen = new ImageIcon("src\\Icons 64x64\\plus.png").getImage().getScaledInstance(40, 40,
				Image.SCALE_SMOOTH);
		JLabel lblMAHinzuf�gen = new JLabel(new ImageIcon(MAHinzuf�gen));
		lblMAHinzuf�gen.setBounds(920, 12, 40, 40);
		add(lblMAHinzuf�gen);

		Image MAL�schen = new ImageIcon("src\\Icons 64x64\\multiply.png").getImage().getScaledInstance(40, 40,
				Image.SCALE_SMOOTH);
		JLabel lblMAL�schen = new JLabel(new ImageIcon(MAL�schen));
		lblMAL�schen.setBounds(920, 128, 40, 40);
		add(lblMAL�schen);

	}
}
