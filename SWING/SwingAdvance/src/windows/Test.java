package windows;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Test implements ActionListener{

		final static String MotifLF = "com.sun.java.swing.plaf.motif.MotifLookAndFeel",
		                    JavaLF  = UIManager.getCrossPlatformLookAndFeelClassName();
		JFrame frame = new JFrame();

		   public static void main(String[] args) {
		      try {
		       UIManager.setLookAndFeel(MotifLF);
		       } catch (Exception excp) {
		           System.out.println("Nie umiem ustaliæ L&F");
		           }
		       new Test();
		   }

		Test() {
		   Container cp = frame.getContentPane();
		   cp.setLayout(new FlowLayout());
		   cp.add(createButton("Motif", MotifLF));
		   cp.add(createButton("Java", JavaLF));
		   frame.pack();
		   frame.setVisible(true);
		   }

		JButton createButton(String txt, String lafClass) {
		  JButton b = new JButton(txt);
		  b.setActionCommand(lafClass);
		  b.addActionListener(this);
		  return b;
		  }

		public void actionPerformed(ActionEvent e) {
		 String laf = e.getActionCommand();
		 try {
		  UIManager.setLookAndFeel(laf);
		  } catch (Exception exc) {
		    System.out.println("Nie umiem ustaliæ L&F = "+laf);
		    }
		  SwingUtilities.updateComponentTreeUI(frame);
		  frame.pack();
		  }
}
