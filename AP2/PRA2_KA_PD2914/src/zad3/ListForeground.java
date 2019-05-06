package zad3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class ListForeground implements ActionListener{
	 protected JTextArea  supportBox;
		
	    public ListForeground(JTextArea  supportBox) {
	        this. supportBox =  supportBox;
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        JMenuItem item = (JMenuItem) e.getSource();
	        MyIcon icon = (MyIcon) item.getIcon();
	        supportBox.setForeground(icon.getColor());
	    }
	}

