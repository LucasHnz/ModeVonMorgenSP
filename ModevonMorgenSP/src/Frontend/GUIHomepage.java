package Frontend;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import Artikelverwaltung.Artikel;
import Artikelverwaltung.Artikelsammlung;

public class GUIHomepage {
	
	private static JPanel panelMain;
	public static JButton btnProduktDamenLinks = new JButton();
	public static JButton btnProduktDamenRechts = new JButton();
	public static JButton btnProduktHerrenLinks = new JButton();
	public static JButton btnProduktHerrenRechts= new JButton();
	public static JButton btnProduktDamen;
	public static JButton btnProduktHerren;
	public static JLabel labelMainDamen;
	public static JLabel labelMainHerren;
	static Image img;
	static  Image img1;
	static  Image img2;
	static  Image img3;
	static  Image img4;
	
	
	public static void wechselOutfitDamenRechts() 
	{
		labelMainDamen.setIcon(new ImageIcon(img3));
		 
	}
	
	public static void wechselOutfitDamenLinks() 
	{
		
		labelMainDamen.setIcon(new ImageIcon(img1));
		
	}
	
	public static void wechselOutfitHerrenRechts() 
	{
		
		labelMainHerren.setIcon(new ImageIcon(img4));

	}
	
	public static void wechselOutfitHerrenLinks() 
	{
		
		labelMainHerren.setIcon(new ImageIcon(img2));
		 	
	}
	
	
	public static void f�lleArtikelStartseite() {

        HashMap<Integer, Artikel> liste = Artikelsammlung.getArtikelsammlung();
        Set<Integer> intArray = liste.keySet();
        ArrayList<Integer>ausgew�hlteArtikel = new ArrayList<Integer>();
        int artNr = 0;
        int x = 0;
        
        do {

                int random1 = (int) (Math.random() * 2) + 5;
                int random2 = (int) (Math.random() * 9) + 1;
                artNr = Integer.parseInt(String.valueOf(random1+""+0+""+0+""+0+""+0+""+0+""+0+""+0+""+random2));
              

                       if(intArray.contains(artNr) && !ausgew�hlteArtikel.contains(artNr)) {
                    	   
                               ausgew�hlteArtikel.add(artNr);
                       }

            }while(ausgew�hlteArtikel.size() < 4);

       
                for(int i = 0 ; i < 4 ; i++) {
                           ImageIcon icon;

                               if(Artikelsammlung.getArtikel(ausgew�hlteArtikel.get(i)).getImage() != null) {
                                      icon = new ImageIcon(Artikelsammlung.getArtikel(ausgew�hlteArtikel.get(i)).getImage());
                                      img = icon.getImage().getScaledInstance(380, 450, Image.SCALE_SMOOTH);
                                     
                                      
                              }if(Artikelsammlung.getArtikel(ausgew�hlteArtikel.get(i)).getImage() == null) {
                                      icon = new ImageIcon("src/SWP-Bilder/NoPic.gif");
                                      img = icon.getImage().getScaledInstance(380, 450, Image.SCALE_SMOOTH);
                                     

                              }
                              
                               if(i == 0) {
                            	   img1 = img;
                            	
                               }
                               if(i == 1) {
                            	  
                            	   img2 = img;
                            	  
                               }
                               if(i == 2) {
                            	   
                            	   img3 = img;
                            	   
                               }
                               if(i == 3) {
                            	  
                            	   img4 = img;
                            	  
                               }

                  }

                             

 }
	/*
	public static Image f�lleArtikelStartseite() {
		HashMap<Integer, Artikel> liste = Artikelsammlung.getArtikelsammlung();
		
		Integer[] nummern = liste.keySet().toArray(new Integer[liste.keySet().size()]);
		Random generator = new Random();
		int rndmNummer = (int) nummern[generator.nextInt(nummern.length)];
			 
			 ImageIcon icon;
				if(Artikelsammlung.getArtikel(rndmNummer).getImage() != null) {
					icon = new ImageIcon(Artikelsammlung.getArtikel(rndmNummer).getImage());
				}
				else 
					icon = new ImageIcon("src/SWP-Bilder/NoPic.gif");
					Image img = icon.getImage().getScaledInstance(380, 450, Image.SCALE_SMOOTH);
					
					//System.out.println(artikel1+" "+artikel2+" "+artikel3+" "+artikel4);
					//System.out.println(intArray);
					return img;
		}  
	*/
	
	public static JPanel getHomepage() {
		panelMain = new JPanel();
		panelMain.setBackground(Color.WHITE);
		panelMain.setBounds(0, 0, 1248, 563);
		panelMain.setLayout(null);
		
		btnProduktDamen = new JButton("Zum Produkt");
		btnProduktDamen.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnProduktDamen.setBackground(Color.WHITE);
		btnProduktDamen.setForeground(Color.BLACK);
		btnProduktDamen.setBounds(249, 458, 165, 35);
		btnProduktDamen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUI.getFenster().changePanel(GUIArtikel.getGUIArtikel(artikelNummer));
				
			}
			
		});
		panelMain.add(btnProduktDamen);
		
		btnProduktHerren = new JButton("Zum Produkt");
		btnProduktHerren.setBackground(Color.WHITE);
		btnProduktHerren.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		btnProduktHerren.setBounds(774, 458, 165, 35);
		btnProduktHerren.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUI.getFenster().changePanel(GUIArtikel.getGUIArtikel(artikelNummer));
				
			}
			
		});
		panelMain.add(btnProduktHerren);
		
		Image leftArrow = new ImageIcon("src\\Icons 32x32\\left-arrow.png").getImage();
		Image rightArrow = new ImageIcon("src\\Icons 32x32\\right-chevron.png").getImage();

		btnProduktDamenRechts = new JButton(new ImageIcon(rightArrow));
		btnProduktDamenRechts.setContentAreaFilled(false);
		btnProduktDamenRechts.setBackground(Color.WHITE);
		btnProduktDamenRechts.setBounds(536, 260, 32, 32);
		btnProduktDamenRechts.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				wechselOutfitDamenRechts();
				
			}
			
		});
		panelMain.add(btnProduktDamenRechts);
		
		btnProduktDamenLinks = new JButton(new ImageIcon(leftArrow));
		btnProduktDamenLinks.setContentAreaFilled(false);
		btnProduktDamenLinks.setBackground(Color.WHITE);
		btnProduktDamenLinks.setBounds(100, 260, 32, 32);
		btnProduktDamenLinks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				wechselOutfitDamenLinks();
				
			}
			
		});
		panelMain.add(btnProduktDamenLinks);
		
		btnProduktHerrenRechts = new JButton(new ImageIcon(rightArrow));
		btnProduktHerrenRechts.setContentAreaFilled(false);
		btnProduktHerrenRechts.setBackground(Color.WHITE);
		btnProduktHerrenRechts.setBounds(1048, 260, 32, 32);
		btnProduktHerrenRechts.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				wechselOutfitHerrenRechts();
				
			}
			
		});
		panelMain.add(btnProduktHerrenRechts);
		
		btnProduktHerrenLinks = new JButton(new ImageIcon(leftArrow));
		btnProduktHerrenLinks.setBackground(Color.WHITE);
		btnProduktHerrenLinks.setContentAreaFilled(false);
		btnProduktHerrenLinks.setBounds(612, 260, 32, 32);
		btnProduktHerrenLinks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			wechselOutfitHerrenRechts();
				
			}
			
		});
		panelMain.add(btnProduktHerrenLinks);
		
		
		labelMainDamen = new JLabel();
		labelMainDamen.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, Color.LIGHT_GRAY, null));
		labelMainDamen.setHorizontalAlignment(SwingConstants.CENTER);
		labelMainDamen.setVerticalAlignment(SwingConstants.TOP);
		labelMainDamen.setBounds(144, 76, 380, 450);
		labelMainDamen.setIcon(new ImageIcon(img1));
		panelMain.add(labelMainDamen);
		
		labelMainHerren = new JLabel("");
		labelMainHerren.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, Color.LIGHT_GRAY, null));
		labelMainHerren.setHorizontalAlignment(SwingConstants.CENTER);
		labelMainHerren.setBounds(656, 76, 380, 450);
		labelMainHerren.setIcon(new ImageIcon(img2));
		panelMain.add(labelMainHerren);

		
		return panelMain;
	}

}
