package windows;
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import javax.swing.border.*; 
public class Opaq {
	public static void main(String[] args) { 
	     JFrame f = new JFrame(); 
	     f.setDefaultCloseOperation(3); 
	     JLabel img = new JLabel(
	                                 new ImageIcon("slon.jpg")); 
	     f.getContentPane().add(img); 
	     JButton b = new JButton("Zr�b co�"); 
	     b.setFont(new Font("Dialog", Font.BOLD, 16)); 
	     b.setForeground(Color.red); 
	     b.setOpaque(false); 
	     b.setBounds(10,10, 100, 50); 

	     Border rbevel = BorderFactory.createRaisedBevelBorder(), 
	            lbevel = BorderFactory.createLoweredBevelBorder(); 

	     

	      b.setBorder(BorderFactory.createCompoundBorder(rbevel,lbevel)); 
	     f.getLayeredPane().add(b); 
	     f.pack(); 
	     f.setVisible(true); 
	     
	     Component g = f.getGlassPane(); 
	     g.setVisible(true); // w tej chwili szyba oddziela nas od okna.
	    } 
}
