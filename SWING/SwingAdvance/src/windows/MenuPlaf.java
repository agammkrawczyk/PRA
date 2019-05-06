package windows;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.plaf.*;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.plaf.*;
public class MenuPlaf extends JFrame  {
	public MenuPlaf() {

	    JMenu menu = new JMenu("File");

	    String[] labels = { "New", "Open", "Save", "Save as..", "Properties" };
	    for (int i=0; i<labels.length; i++) {
	      JMenuItem mi = new JMenuItem(labels[i]);
	      menu.add(mi);
	    }

	    JMenuBar mbar = new JMenuBar();
	    mbar.add(menu);

	    String[] addMenus = { "Edit", "View", "Tools" };
	    for (int i=0; i<addMenus.length; i++) {
	      menu = new JMenu(addMenus[i]);
	      mbar.add(menu);
	    }


	    setJMenuBar(mbar);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(200, 100);
	    setLocationRelativeTo(null);
	  }

	  public static void main(String[] args) {
	    ColorUIResource selBack = new ColorUIResource(Color.black);
	    ColorUIResource selFore = new ColorUIResource(Color.white);
	    UIManager.put("Menu.selectionBackground", selBack);
	    UIManager.put("Menu.selectionForeground", selFore);
	    UIManager.put("Menu.font",
	                   new FontUIResource(new Font("Dialog", Font.BOLD, 20)));
	    UIManager.put("MenuItem.selectionBackground", selBack);
	    UIManager.put("MenuItem.selectionForeground", selFore);

	    SwingUtilities.invokeLater(new Runnable() {
	      public void run() {
	        new MenuPlaf().setVisible(true);
	        new MenuPlaf().setVisible(true);
	      }
	    });
	  }
}
