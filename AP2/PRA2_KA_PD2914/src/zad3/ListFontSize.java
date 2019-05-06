package zad3;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class ListFontSize implements ActionListener {
	
	protected JTextArea supportBox;
	 protected int fontSize;
	
	  public ListFontSize(JTextArea  supportBox, int size) {
	        this. supportBox =  supportBox;
	        this.fontSize = size;
	    }
	
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	 supportBox.setFont(new Font("Times New Roman", Font.BOLD, fontSize));
	    }
}
