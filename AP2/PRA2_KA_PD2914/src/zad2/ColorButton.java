package zad2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
class ColorButton extends JFrame {
	JButton button;
    int licznik= 0;
    Color kolorTla[] = {Color.BLUE, Color.GREEN,Color.gray,Color.CYAN, Color.ORANGE} ;	
   String kolorNapis[]= {"Blue","Green","Grey","Cyan","Orange"};
    
   ColorButton() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(300, 300));
        setLocation(200, 200);

        button = new JButton("Start !!!");
        button.setFont(new Font("Dialog", Font.BOLD, 75)); 		
        button.addActionListener(new ActionListener() {
        	
            @Override
		            public void actionPerformed(ActionEvent e) {
                if (licznik >= kolorTla.length) {
                    licznik = 0;
                }
          button.setBackground(kolorTla[licznik]);
              button.setText(kolorNapis[licznik]);  
               licznik++;
               
            }
        });
        add(button);

        pack();
        setVisible(true);
    }}

