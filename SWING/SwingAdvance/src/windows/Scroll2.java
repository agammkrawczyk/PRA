package windows;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Scroll2 extends JFrame implements ActionListener {
	int cellW = 50, cellH = 20, rows = 30, cols = 26; 
	  JPanel cont = new JPanel(new GridLayout(rows, cols, 0, 0)); 
	  JPanel colHead = new JPanel(new GridLayout(1, cols, 0, 0)); 
	  JPanel rowHead = new JPanel(new GridLayout(rows, 1, 0, 0)); 

	Scroll2() { 
	  Color lYellow = new Color(255,255,240), 
	        lBlue   = new Color(219,232,255); 
	  String[] lit = new String[cols+1]; 
	  JLabel l = null; 
	  for (int j = 1; j <=cols; j++) { 
	      lit[j] = "" + (char) ('A'+(j-1)); 
	      l = createLabel(lit[j], Color.black, cellW, cellH); 
	      colHead.add(createLabel(lit[j], Color.black, cellW, cellH)); 
	      } 
	  for (int i = 1; i<=rows; i++) { 
	      rowHead.add(createLabel(""+i, Color.black, cellH, cellH)); 
	      for (int j = 1; j<=cols; j++) 
	          cont.add(createLabel(lit[j]+i, Color.blue, cellW, cellH)); 
	      } 
	   JScrollPane sp = new JScrollPane(); 
	   cont.setBackground(lYellow); 
	   sp.setViewportView(cont); 
	   rowHead.setBackground(lBlue); 
	   sp.setRowHeaderView(rowHead); 
	   colHead.setBackground(lBlue); 
	   sp.setColumnHeaderView(colHead); 
	   ImageIcon up = new ImageIcon("Up16.gif"); 
	   JButton leftUp = new JButton(up); 
	   leftUp.addActionListener(this); 
	   JButton rightUp = new JButton(up); 
	   rightUp.addActionListener(this); 
	   sp.setCorner(JScrollPane.UPPER_LEFT_CORNER, leftUp); 
	   sp.setCorner(JScrollPane.UPPER_RIGHT_CORNER, rightUp); 
	   JComponent cp = (JComponent) getContentPane(); 
	   cp.add(sp); 
	   cp.setPreferredSize(new Dimension(300,300)); 
	   pack(); 
	   setVisible(true); 
	} 

	JLabel createLabel(String s, Color c, int w, int h) { 
	  JLabel l = new JLabel(s, JLabel.CENTER); 
	  l.setBorder(BorderFactory.createLineBorder(c)); 
	  l.setPreferredSize(new Dimension(w, h)); 
	  l.setOpaque(false); 
	  return l; 
	} 

	public void actionPerformed(ActionEvent e) { 
	 cont.scrollRectToVisible(new Rectangle(0,0,cellW,cellH)); 
	} 
}
