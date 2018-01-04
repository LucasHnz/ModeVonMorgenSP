package Backend;

import java.awt.Color;
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
import AdministratorVerwaltung.Administrator;
import AdministratorVerwaltung.AdministratorSammlung;
import AdministratorVerwaltung.AdministratorStrg;

/**
 * 
 * @author julian
 *
 */
public class GUIAdministratorListe extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JScrollPane scrollpane;
	private String[] columnNames = { "Nutzer Nummer", "Nachname", "Vorname", "EMail", "Straße", "Ort", "PLZ", "IBAN",
			"Gehalt", "Passwort" };
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
		private HashMap<Integer, Administrator> data;

		/**
		 * Füllt die Tabelle mit einer Administrator Liste
		 * 
		 * @param Administratorliste
		 * @param columnNames
		 */
		public myTableModel(HashMap<Integer, Administrator> Administratorliste, String[] columnNames) {
			this.columnNames = columnNames;
			this.data = Administratorliste;
		}

		/**
		 * Holt sich die Anzahl der Spalten
		 */
		public int getColumnCount() {
			return columnNames.length;
		}

		/**
		 * Holt sich den Spaltennamen
		 */
		public String getColumnName(int columnIndex) {
			return columnNames[columnIndex].toString();
		}

		/**
		 * Holt sich die Anzahl der Reihen
		 */
		public int getRowCount() {
			System.out.println(data.size());
			return data.size();
		}

		/**
		 * Gibt den Wert der ausgewählten Zelle zurück.
		 * 
		 * @param rowIndex
		 *            Der Zeilenindex.
		 * @param columnIndex
		 *            Der Spaltenindex.
		 */
		public Object getValueAt(int rowIndex, int columnIndex) {
			Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
			try {
				if (columnIndex == 0) {
					return String.valueOf(data.get(keys[rowIndex]).getNutzernr());
				} else if (columnIndex == 1) {
					return data.get(keys[rowIndex]).getNachname();
				} else if (columnIndex == 2) {
					return data.get(keys[rowIndex]).getVorname();
				} else if (columnIndex == 3) {
					return data.get(keys[rowIndex]).getEmail();
				} else if (columnIndex == 4) {
					return data.get(keys[rowIndex]).getStraße();
				} else if (columnIndex == 5) {
					return data.get(keys[rowIndex]).getOrt();
				} else if (columnIndex == 6) {
					return data.get(keys[rowIndex]).getPlz();
				} else if (columnIndex == 7) {
					return data.get(keys[rowIndex]).getIban();
				} else if (columnIndex == 8) {
					return data.get(keys[rowIndex]).getGehalt();
				} else if (columnIndex == 9) {
					return data.get(keys[rowIndex]).getPasswort();
				} else
					return null;

			} catch (NullPointerException e) {
				e.printStackTrace();
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
	public GUIAdministratorListe() {
		AdministratorSammlung.fülleAdministratorListe();
		setLayout(null);
		setBounds(90, 100, 1200, 600);
		setBackground(Color.DARK_GRAY);

		model = new myTableModel(AdministratorSammlung.getAdminSammlung(), columnNames);
		table = new JTable(model);
		table.setFillsViewportHeight(true);
		setStructure();													//
		

		scrollpane = new JScrollPane();
		scrollpane.setBounds(10, 11, 900, 490);
		scrollpane.setVisible(true);
		scrollpane.setViewportView(table);
		add(scrollpane);

		/**
		 * Button mit Action Listener um einen Admin hinzuzufügen
		 */
		JButton btnNeuerAdministrator = new JButton("Administrator hinzufügen");
		btnNeuerAdministrator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					GUIAdministratorErstellenFormular abc = new GUIAdministratorErstellenFormular();
					abc.addWindowListener(formularListener);
					model.fireTableStructureChanged();
					setStructure();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnNeuerAdministrator.setBounds(981, 11, 209, 48);
		add(btnNeuerAdministrator);
		/**
		 * Button um einen Admin zu editieren
		 */
		JButton btnEditiereAdministrator = new JButton("Administrator editieren");
		btnEditiereAdministrator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					final HashMap<Integer, Administrator> data = AdministratorSammlung.getAdminSammlung();
					Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
					new GUIAdministratorBearbeiten(
							data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getNutzernr());
				} catch (ArrayIndexOutOfBoundsException e) {
					JOptionPane.showOptionDialog(null, "Bitte wählen Sie eine Zeile aus!",
							"Administrator Bearbeitung", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
							null, new String[] { "Ok"}, "Ok");
					System.out.println("Index Fehler, keine Zeile ausgewählt");
				}
			}
		});
		btnEditiereAdministrator.setBounds(981, 70, 209, 48);
		add(btnEditiereAdministrator);

		/**
		 * Button um einen Admin zu löschen
		 */
		JButton btnLöscheAdmin = new JButton("Administrator löschen");
		btnLöscheAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					final HashMap<Integer, Administrator> data = AdministratorSammlung.getAdminSammlung();
					Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
					int i = (data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getNutzernr());

					
					final Object optionPane = JOptionPane.showOptionDialog(null, "Sie sind dabei einen Administrator zu löschen! Fortfahren ?",
							"Administrator Löschen", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,
							new String[] { "Ok", "Abbrechen" }, "Ok");
					if(optionPane.equals(0)) {
						AdministratorStrg.entferneAdmin(
								data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getNutzernr());
						model.fireTableStructureChanged();																							//
						setStructure();
						JOptionPane.showMessageDialog(null,  "Administrator wurde gelöscht.", "Information", JOptionPane.INFORMATION_MESSAGE);
					}else if(optionPane.equals(1)) {
						JOptionPane.showMessageDialog(null,  "Vorgang abgebrochen!", "Abbruch", JOptionPane.ERROR_MESSAGE);
					}	

				} catch (ArrayIndexOutOfBoundsException e) {
					JOptionPane.showOptionDialog(null, "Bitte wählen Sie eine Zeile aus!",
							"Administrator Löschen", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
							null, new String[] { "Ok"}, "Ok");
					System.out.println("Index Fehler, keine Zeile ausgewählt");
				}
			}
		});
		btnLöscheAdmin.setBounds(981, 129, 209, 48);
		add(btnLöscheAdmin);

		Image AdminEditieren = new ImageIcon("src\\Icons 64x64\\repair-tools.png").getImage().getScaledInstance(40, 40,
				Image.SCALE_SMOOTH);
		JLabel lblAdminEditieren = new JLabel(new ImageIcon(AdminEditieren));
		lblAdminEditieren.setBounds(920, 70, 40, 40);
		add(lblAdminEditieren);

		Image AdminHinzufügen = new ImageIcon("src\\Icons 64x64\\plus.png").getImage().getScaledInstance(40, 40,
				Image.SCALE_SMOOTH);
		JLabel lblAdminHinzufügen = new JLabel(new ImageIcon(AdminHinzufügen));
		lblAdminHinzufügen.setBounds(920, 12, 40, 40);
		add(lblAdminHinzufügen);

		Image AdminLöschen = new ImageIcon("src\\Icons 64x64\\multiply.png").getImage().getScaledInstance(40, 40,
				Image.SCALE_SMOOTH);
		JLabel lblAdminLöschen = new JLabel(new ImageIcon(AdminLöschen));
		lblAdminLöschen.setBounds(920, 128, 40, 40);
		add(lblAdminLöschen);

		setVisible(true);

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
		sorter.setComparator(8, intcomp);
		table.setRowSorter(sorter);
		table.getRowSorter().toggleSortOrder(0);
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(30, 42, 800, 395);
		table.setVisible(true);
	}
}
