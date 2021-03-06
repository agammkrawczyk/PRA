package windows;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Test1 extends JFrame implements ActionListener{
	public Test1()  {
	    setLayout(new FlowLayout(0, 0, FlowLayout.LEFT));
	    ((JComponent) getContentPane()).setBorder(BorderFactory
	                                   .createEmptyBorder(10, 10, 10, 10));
	    JButton mb = new JButton("G��wny przycisk");
	    mb.setHorizontalAlignment(AbstractButton.RIGHT);
	    mb.setPreferredSize(new Dimension(200, 150));
	    mb.addActionListener(this);
	    JPanel p = new JPanel(new GridLayout(0, 1));
	    p.setBorder(BorderFactory.createLineBorder(Color.blue));
	    for (int i = 1; i <= 5; i++) {
	      JButton bb = new JButton("" + i);
	      bb.addActionListener(this);
	      p.add(bb);
	    }
	    mb.setLayout(new FlowLayout(0, 0, FlowLayout.LEFT));
	    mb.add(p);
	    add(mb);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    pack();
	    setLocationRelativeTo(null);
	    setVisible(true);
	  }

	  public void actionPerformed(ActionEvent e) {
	    System.out.println(e.getActionCommand());
	  }

	  public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	      public void run() {
	        new Test1();
	      }
	    });
	  }
}
