package windows;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Layer extends JFrame  implements ActionListener{
	private JLayeredPane l = null;

	  public Layer() {
	    l = getLayeredPane();
	    getContentPane().setBackground(Color.white); // widzimy contentPane
	    int x = 10, y = 10;
	    for (int i = 1; i <= 5; i++) {
	      JButton b = new JButton("Przycisk " + i);
	      b.setHorizontalAlignment(JButton.CENTER);
	      b.setVerticalAlignment(JButton.TOP);
	      b.setBounds(x, y, 150, 100);
	      b.addActionListener(this);
	      l.add(b, new Integer(i));
	      x += 30;
	      y += 30;
	    }
	    JButton b = new JButton("P(5,1)");
	    b.addActionListener(this);
	    b.setHorizontalAlignment(JButton.RIGHT);
	    b.setVerticalAlignment(JButton.BOTTOM);
	    b.setBounds(x + 50, y, 100, 100);
	    b.setBackground(Color.yellow);
	    l.add(b, new Integer(5), 1);
	    setSize(400, 300);
	    setVisible(true);
	  }

	  public void actionPerformed(ActionEvent e) {
	    JComponent c = (JComponent) e.getSource();
	    l.moveToFront(c);
	  }
	  
	  public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	      public void run() {
	        new Layer();
	      }
	    });
	  }


}
