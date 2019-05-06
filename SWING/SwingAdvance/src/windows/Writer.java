package windows;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.awt.*;

class Writer extends AbstractAction  {
	 JTextComponent tc;

	  public Writer(JTextComponent t) {
	    super("write");
	    tc = t;
	  }

	  public void actionPerformed(ActionEvent e) {
	    Object src = e.getSource();
	    JComponent c = (JComponent) e.getSource();
	    String txt = (String) c.getClientProperty("text");
	    tc.replaceSelection(txt);
	  }
	}

	

