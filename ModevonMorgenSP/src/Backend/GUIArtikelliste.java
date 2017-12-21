package Backend;

import java.awt.EventQueue;
import javax.swing.ListSelectionModel;
import java.util.Comparator;
import java.util.HashMap;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import Artikelverwaltung.Artikel;
import Artikelverwaltung.ArtikelStrg;
import Artikelverwaltung.Artikelsammlung;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.Icon;

public class GUIArtikelliste extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JScrollPane scrollpane;
	private String[] columnNames = {"ArtNr", "Bezeichung", "Hersteller", "Bestand", "Preis: €", "Rabatt: %", "Verfügbarkeit", "Notiz"};

	private class myTableModel extends AbstractTableModel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String[] columnNames;
		private HashMap<Integer, Artikel> data;
		
		
		public myTableModel(HashMap<Integer, Artikel> artikelliste, String[] columnNames) {
			this.columnNames = columnNames;
			this.data = artikelliste;
		}
			
		public int getColumnCount() {
			return columnNames.length;
		}
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public Class getColumnClass(int columnIndex){
			if(columnIndex == 0) {
				return getValueAt(0, columnIndex).getClass();
			}
			else if(columnIndex == 1) {
				return getValueAt(0, columnIndex).getClass();
			}
			else if(columnIndex == 2) {
				return getValueAt(0, columnIndex).getClass();
			}	
			else if(columnIndex == 3) {
				return getValueAt(0, columnIndex).getClass();
			}	
			else if(columnIndex == 4) {
				return getValueAt(0, columnIndex).getClass();
			}	
			else if(columnIndex == 5) {
				return getValueAt(0, columnIndex).getClass();
			}	
			else if(columnIndex == 6) {
				return getValueAt(0, columnIndex).getClass();
			}	
			else if(columnIndex == 7) {
				return getValueAt(0, columnIndex).getClass();
			}
			else 
				return null;
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
					return String.valueOf(data.get(keys[rowIndex]).getArtikelnummer());
				}
				else if(columnIndex == 1) {
					return data.get(keys[rowIndex]).getBezeichnung();
				}
				else if(columnIndex == 2) {
					return data.get(keys[rowIndex]).getHersteller();
				}	
				else if(columnIndex == 3) {
					return data.get(keys[rowIndex]).getBestand();
				}	
				else if(columnIndex == 4) {
					return data.get(keys[rowIndex]).getPreis();
				}	
				else if(columnIndex == 5) {
					return data.get(keys[rowIndex]).getRabatt();
				}	
				else if(columnIndex == 6) {
					return data.get(keys[rowIndex]).getVerfügbarkeit();
				}	
				else if(columnIndex == 7) {
					if(data.get(keys[rowIndex]).getNotiz() != null && data.get(keys[rowIndex]).getNotiz() != "")
						return new ImageIcon("src\\Icons 16x16\\exclamation-mark.png");
					else
						return new ImageIcon();				
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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArtikelStrg.FülleArtikelsammlung();
					GUIArtikelliste frame = new GUIArtikelliste();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIArtikelliste() {
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		ArtikelStrg.FülleArtikelsammlung();
		
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		setBounds(90, 100, 1200, 600);
			
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
		
		table = new JTable(new myTableModel(Artikelsammlung.getArtikelsammlung(), columnNames));
		table.setFillsViewportHeight(true);
		table.setDragEnabled(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(32);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(30);
		table.getColumnModel().getColumn(4).setPreferredWidth(30);
		table.getColumnModel().getColumn(5).setPreferredWidth(30);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(10);
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		table.getRowSorter().toggleSortOrder(0);
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sorter.setComparator(3, intcomp);
		sorter.setComparator(4, doublecomp);
		sorter.setComparator(5, intcomp);
		
		scrollpane = new JScrollPane();
		scrollpane.setBounds(10, 11, 900, 490);
		scrollpane.setViewportView(table);
		add(scrollpane);
		
		JButton btnNeuerSchuhartikel = new JButton();
		btnNeuerSchuhartikel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GUIArtikelFormular("Schuhe");
			}
		});
		Image schuhe = new ImageIcon("src\\Icons 64x64\\shoe.png").getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
		btnNeuerSchuhartikel.setIcon(new ImageIcon(schuhe));
		btnNeuerSchuhartikel.setBounds(1105, 51, 86, 48);
		btnNeuerSchuhartikel.setBorder(BorderFactory.createEmptyBorder());
		btnNeuerSchuhartikel.setContentAreaFilled(false);
		add(btnNeuerSchuhartikel);
		
		Image kleidung = new ImageIcon("src\\Icons 64x64\\t-shirt.png").getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
		JButton btnNeuerKleidungsartikel = new JButton(new ImageIcon(kleidung));
		btnNeuerKleidungsartikel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUIArtikelFormular("Kleidung");
			}
		});
		btnNeuerKleidungsartikel.setBounds(1013, 51, 86, 48);
		btnNeuerKleidungsartikel.setBorder(BorderFactory.createEmptyBorder());
		btnNeuerKleidungsartikel.setContentAreaFilled(false);
		add(btnNeuerKleidungsartikel);
		
		Image accessoires = new ImageIcon("src\\Icons 64x64\\glasses.png").getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
		JButton btnNeuesAccessoir = new JButton(new ImageIcon(accessoires));
		btnNeuesAccessoir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUIArtikelFormular("Accessoires");
			}
		});
		btnNeuesAccessoir.setBounds(921, 51, 86, 48);
		btnNeuesAccessoir.setBorder(BorderFactory.createEmptyBorder());
		btnNeuesAccessoir.setContentAreaFilled(false);
		add(btnNeuesAccessoir);
		
		JButton btnEditiereArtikel = new JButton("Artikel editieren");
		btnEditiereArtikel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final HashMap<Integer, Artikel> data = Artikelsammlung.getArtikelsammlung();
				Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
				new GUIArtikelFormular(data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getArtikelnummer());
			}
		});
		btnEditiereArtikel.setBounds(976, 120, 215, 48);
		add(btnEditiereArtikel);
		
		JButton btnEntferneArtikel = new JButton("Artikel entfernen");
		btnEntferneArtikel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final HashMap<Integer, Artikel> data = Artikelsammlung.getArtikelsammlung();
				Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
				
				final Object optionPane = JOptionPane.showConfirmDialog(null,
						"Wollen Sie den Artikel: \n" + data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getBezeichnung() 
						+ "\nArtikelnummer: " + data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getArtikelnummer()
						+ "\nwirklich löschen?", "Abfrage",
						JOptionPane.YES_NO_OPTION);
					
				if(optionPane.equals(0)) {
					ArtikelStrg.entferneArtikel(data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getArtikelnummer());
					JOptionPane.showMessageDialog(null,  "Artikel wurde gelöscht.", "Information", JOptionPane.INFORMATION_MESSAGE);
				}else if(optionPane.equals(1)) {
					JOptionPane.showMessageDialog(null,  "Vorgang abgebrochen!", "Abbruch", JOptionPane.ERROR_MESSAGE);
				}			
			}
		});
		btnEntferneArtikel.setBounds(976, 179, 215, 48);
		add(btnEntferneArtikel);
		
		JButton btnRabatt = new JButton("Rabatt ändern");
		btnRabatt.addActionListener(new ActionListener() {
			final HashMap<Integer, Artikel> data = Artikelsammlung.getArtikelsammlung();
			Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
			public void actionPerformed(ActionEvent arg0) {
				final String optionPane = (String) JOptionPane.showInputDialog(scrollpane, "Aktueller Rabatt: " 
							+ data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getRabatt() + " %", "Rabatt ändern", 
							JOptionPane.INFORMATION_MESSAGE, null, null, data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getRabatt());
				if(optionPane != null) {
					ArtikelStrg.aktualisiereRabatt(Integer.parseInt(optionPane), data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getArtikelnummer());
					JOptionPane.showMessageDialog(null,  "Rabatt wurde geändert.", "Information", JOptionPane.INFORMATION_MESSAGE);
				}else if(optionPane == null) {
					JOptionPane.showMessageDialog(null,  "Vorgang abgebrochen!", "Abbruch", JOptionPane.ERROR_MESSAGE);
				}		
			}
		});
		btnRabatt.setBounds(921, 238, 270, 48);
		add(btnRabatt);
				
		JButton btnNotiz = new JButton("Notiz ändern");
		btnNotiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final HashMap<Integer, Artikel> data = Artikelsammlung.getArtikelsammlung();
				Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
				final String optionPane = (String) JOptionPane.showInputDialog(scrollpane, "Aktuelle Notiz:\n" 
						+ data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getNotiz(), "Notiz ändern", 
						JOptionPane.INFORMATION_MESSAGE, null, null, data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getNotiz());
				if(optionPane != null) {
					ArtikelStrg.aktualisiereNotiz(optionPane, data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getArtikelnummer());
					JOptionPane.showMessageDialog(null,  "Notiz wurde geändert.", "Information", JOptionPane.INFORMATION_MESSAGE);
				}else if(optionPane == null) {
					JOptionPane.showMessageDialog(null,  "Vorgang abgebrochen!", "Abbruch", JOptionPane.ERROR_MESSAGE);
				}		
			}
		});
		btnNotiz.setBounds(921, 356, 270, 48);
		add(btnNotiz);
			
		JButton btnBestand = new JButton("Bestand ändern");
		btnBestand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final HashMap<Integer, Artikel> data = Artikelsammlung.getArtikelsammlung();
				Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
				final String optionPane = (String) JOptionPane.showInputDialog(scrollpane, "Aktueller Bestand: " 
						+ data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getBestand(), "Bestand ändern", 
						JOptionPane.INFORMATION_MESSAGE, null, null, data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getBestand() );
				if(optionPane != null) {
					ArtikelStrg.aktualisiereBestand(Integer.parseInt(optionPane), data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getArtikelnummer());
					JOptionPane.showMessageDialog(null,  "Bestand wurde geändert.", "Information", JOptionPane.INFORMATION_MESSAGE);
				}else if(optionPane == null) {
					JOptionPane.showMessageDialog(null,  "Vorgang abgebrochen!", "Abbruch", JOptionPane.ERROR_MESSAGE);
				}		
			}
		});
		btnBestand.setBounds(921, 297, 270, 48);
		add(btnBestand);
		
		JButton btnArtikelbildHochladen = new JButton("Artikelbild hochladen");
		btnArtikelbildHochladen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final HashMap<Integer, Artikel> data = Artikelsammlung.getArtikelsammlung();
				Integer[] keys = data.keySet().toArray(new Integer[data.keySet().size()]);
				GUIFileChooser chooser = new GUIFileChooser(data.get(keys[table.convertRowIndexToModel(table.getSelectedRow())]).getArtikelnummer());
				
				
			}
		});
		btnArtikelbildHochladen.setBounds(921, 415, 270, 48);
		add(btnArtikelbildHochladen);
		
		JLabel lblNeuerArtikel = new JLabel("Neuer Artikel");
		lblNeuerArtikel.setForeground(Color.WHITE);
		lblNeuerArtikel.setIgnoreRepaint(true);
		lblNeuerArtikel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNeuerArtikel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNeuerArtikel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNeuerArtikel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNeuerArtikel.setBackground(Color.LIGHT_GRAY);
		lblNeuerArtikel.setBounds(920, 12, 270, 35);
		add(lblNeuerArtikel);
		
		Image ArtikelEntfernen = new ImageIcon("src\\Icons 64x64\\multiply.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		JLabel lblArtikelEntfernen = new JLabel(new ImageIcon(ArtikelEntfernen));
		lblArtikelEntfernen.setBounds(922, 180, 40, 40);
		add(lblArtikelEntfernen);
		
		Image ArtikelEditieren = new ImageIcon("src\\Icons 64x64\\repair-tools.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		JLabel lblArtikelEditieren = new JLabel(new ImageIcon(ArtikelEditieren));
		lblArtikelEditieren.setBounds(922, 124, 40, 40);
		add(lblArtikelEditieren);
		
		setVisible(true);
		//Artikelsammlung.loadImages();
	}
}
