/**
 *
 *  @author KRAWCZYK AGNIESZKA PD2914
 *
 */

package zad1;

import java.awt.*;
import javax.swing.*;

public class Main  {
	public static void main(String[] args) {
		  final int number = 5; 
			 
		  String title = "Tydzieñ roboczy"; 
		  
		  LayoutManager lm = new BorderLayout();
		  
		  String gborders[] = { "West", "North", "East", "South", "Center" };
		 
		 
		    Color kolorTla[] = {Color.BLUE, Color.GREEN,Color.gray,Color.CYAN, Color.ORANGE} ;	
		    Color kolorCzcionki[] = {Color.MAGENTA,Color.YELLOW,Color.black,Color.PINK,Color.LIGHT_GRAY};
		    Color kolorRamki[]={Color.BLACK , Color.BLUE,Color.PINK,Color.GREEN, Color.YELLOW};
		    	 
		    String[] teksty = {"PONIEDZIA£EK", "WTOREK", "ŒRODA", "CZWARTEK", "PIATEK"};

		    String[] podpowiedzi = {"Pierwszy dzien pracy", "jeszcze tylko 3 dni do weekendu", "mala sobota", "jutro bedzie jutro", "to juz dzis"};
		
		    int[] rozmiarCzcionki = {10, 20, 30, 40, 50};
		    
		    JFrame frame = new JFrame(); 
		    frame.setPreferredSize(new Dimension(500,500));
		    frame.setLayout(new BorderLayout(10, 10));
		    
		    JPanel panel = new JPanel();
		      panel.setBackground(Color.white);
		      panel.setBorder(BorderFactory.createTitledBorder(title)); 
		      panel.setLayout(lm); 
		      
		      
		      for (int j = 0; j < number; j++) { 
			        
		    	  	JLabel label = new JLabel(teksty[j], SwingConstants.CENTER);
		    	  	panel.add(label, gborders[j]);
		    	  	label.setForeground(kolorCzcionki[j]);
		    	  	label.setOpaque(true);
		    	  	label.setFont(new Font("Dialog", Font.BOLD, rozmiarCzcionki[j]));
		    	  	label.setBackground(kolorTla[j]);
		    	  	label.setToolTipText(podpowiedzi[j]);
		      	  	label.setBorder(BorderFactory.createLineBorder(kolorRamki[j], 4, false));
		    	  	
		    	  	
			      }
			      frame.add(panel);
			      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				  frame.pack();
				  frame.setVisible(true);
	  			
	}
 
  }

