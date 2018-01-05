package Backend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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

import AdministratorVerwaltung.AdministratorSammlung;
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
	private String[] columnNames = { "Nutzer Nummer", "Vorgesetzter", "Nachname", "Vorname", "E-Mail", "Straße", "Ort",
			"PLZ", "IBAN", "Gehalt", "Berechtigung", "Passwort" };
	
	private myTableModel model;										//

	Comparator<Integer> intcomp = new Comparator<Integer>() {		//
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

	WindowListener formularListener = new WindowListener() {			//

		@Override
		public void windowActivated(WindowEvent e) {}

		@Override
		public void windowClosed(WindowEvent e) {
			model.fireTableStructureChanged();
			setStructure();
			}

		@Override
		public void windowClosing(WindowEvent e) {}

		@Override
		public void windowDeactivated(WindowEvent e) {}

		@Override
		public void windowDeiconified(WindowEvent e) {}

		@Override
		public void windowIconified(WindowEvent e) {}

		@Override
		public void windowOpened(WindowEvent e) {}
	};

	private class myTableModel extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String[] columnNames;
		private HashMap<Integer, Mitarbeiter> data;

		/**
		 * Füllt die Tabelle mit einer Mitarbeiter HashMap
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
					return data.get(keys[rowIndex]).getStraße();
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
		
		model = new myTableModel(MitarbeiterSammlung.getMitarbeitersammlung(), columnNames);
		table = new JTable(model);
		table.setFillsViewportHeight(true);
		setStructure();	

		scrollpane = new JScrollPane();
		scrollpane.setBounds(10, 11, 900, 490);
		scrollpane.setVisible(true);
		scrollpane.setViewportView(table);
		add(scrollpane);


		/**
		 * erstell das Pop Up Fenster für eine Mitarbeiter Hinzufügen Operation
		 */
		JButton btnNeuerMitarbeiter = new JButton("Mitarbeiter hinzufügen");
		btnNeuerMitarbeiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					GUIMitarbeiterErstellenFormular abc = new GUIMitarbeiterErstellenFormular();
					abc.addWindowListener(formularListener);
					model.fireTableStructureChanged();
					setStructure();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		});
		btnNeuerMitarbeiter.setBounds(981, 11, 209, 48);
		add(btnNeuerMitarbeiter);

		/**
		 * Erstellt ein Pop Up Fenster um einen ausgewählten Mitarbeiter zu editieren
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
					JOptionPane.showOptionDialog(null, "Bitte wählen Sie eine Zeile aus!",
							"Mitarbeiter Bearbeiten", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
							null, new String[] { "Ok"}, "Ok");
					System.out.println("Index Fehler, keine Zeile ausgewählt");
				}
			}
		});
		btnEditiereMitarbeiter.setBounds(981, 70, 209, 48);
		add(btnEditiereMitarbeiter);

		/**
		 * löscht einen ausgewählten Mitarbeiter
		 */
		JButton btnLöscheMitarbeiter = new JButton("Mitarbeiter löschen");
		btnLöscheMitarbeiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					final HashMap<Integer, Mitarbeiter> data = MitarbeiterSammlung.getMitarbeitersammlung();
					Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
					int i = (data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getNutzernr());

					final Object optionPane = JOptionPane.showOptionDialog(null, "Sie sind dabei einen Mitarbeiter zu löschen! Fortfahren ?",
							"Mitarbeiter Löschen", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,
							new String[] { "Ok", "Abbrechen" }, "Ok");

					
					
					if(optionPane.equals(0)) {
						MitarbeiterVerwaltung.MitarbeiterStrg.entferneMitarbeiter(i);
						model.fireTableStructureChanged();																							//
						setStructure();
						JOptionPane.showMessageDialog(null,  "Mitarbeiter wurde gelöscht.", "Information", JOptionPane.INFORMATION_MESSAGE);
					}else if(optionPane.equals(1)) {
						JOptionPane.showMessageDialog(null,  "Vorgang abgebrochen!", "Abbruch", JOptionPane.ERROR_MESSAGE);
					}			

				} catch (ArrayIndexOutOfBoundsException e) {
					JOptionPane.showOptionDialog(null, "Bitte wählen Sie eine Zeile aus!",
							"Mitarbeiter Löschen", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,
							new String[] { "Ok"}, "Ok");
					System.out.println("Index Fehler, keine Zeile ausgewählt");
				}
			}
		});
		btnLöscheMitarbeiter.setBounds(981, 129, 209, 48);
		add(btnLöscheMitarbeiter);
		setVisible(true);

		Image MAEditieren = new ImageIcon("src\\Icons 64x64\\repair-tools.png").getImage().getScaledInstance(40, 40,
				Image.SCALE_SMOOTH);
		JLabel lblMAEditieren = new JLabel(new ImageIcon(MAEditieren));
		lblMAEditieren.setBounds(920, 70, 40, 40);
		add(lblMAEditieren);

		Image MAHinzufügen = new ImageIcon("src\\Icons 64x64\\plus.png").getImage().getScaledInstance(40, 40,
				Image.SCALE_SMOOTH);
		JLabel lblMAHinzufügen = new JLabel(new ImageIcon(MAHinzufügen));
		lblMAHinzufügen.setBounds(920, 12, 40, 40);
		add(lblMAHinzufügen);

		Image MALöschen = new ImageIcon("src\\Icons 64x64\\multiply.png").getImage().getScaledInstance(40, 40,
				Image.SCALE_SMOOTH);
		JLabel lblMALöschen = new JLabel(new ImageIcon(MALöschen));
		lblMALöschen.setBounds(920, 128, 40, 40);
		add(lblMALöschen);
		
		

	}
	
	public void setStructure() {					//
		table.setDragEnabled(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(110);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(80);
		table.getColumnModel().getColumn(5).setPreferredWidth(80);
		table.getColumnModel().getColumn(6).setPreferredWidth(80);
		table.getColumnModel().getColumn(7).setPreferredWidth(80);
		table.getColumnModel().getColumn(8).setPreferredWidth(80);
		table.getColumnModel().getColumn(9).setPreferredWidth(80);

		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		table.getRowSorter().toggleSortOrder(0);
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
}
