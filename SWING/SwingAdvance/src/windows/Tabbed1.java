package windows;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Tabbed1  extends JFrame implements ActionListener, Constants{
	JTabbedPane tp = new JTabbedPane(); 

	Tabbed1() { 
	 Color[] back = { BLUE, YELLOW, RED, WHITE, BLACK }; 
	 Color[] fore = { WHITE, BLACK, YELLOW, BLACK, WHITE }; 
	 String[] txt = { "Top", "Left", "Right", "Bottom", "Default" }; 
	 String[] loc = { "North", "West", "East", "South", "Center" }; 
	 int[] place = { TOP, LEFT, RIGHT, BOTTOM, TOP }; 
	 JButton b = null; 
	 JPanel  p = null; 
	 for (int i=0; i<back.length; i++) { 
	     p = new JPanel(new BorderLayout()); 
	     for (int j=0; j<txt.length; j++) { 
	         b = new JButton(txt[j]); 
	         b.addActionListener(this); 
	         b.putClientProperty("Place", new Integer(place[j])); 
	         p.add(b, loc[j]); 
	         } 
	     tp.addTab("Tab"+(i+1), p); 
	     tp.setBackgroundAt(i, back[i]); 
	     tp.setForegroundAt(i, fore[i]); 
	     } 
	 getContentPane().add(tp); 
	 setSize(300, 200); 
	 setVisible(true); 
}
}
