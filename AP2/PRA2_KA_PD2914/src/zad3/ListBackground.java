package zad3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class ListBackground implements ActionListener {
	protected JTextArea supportBox;
	
    public ListBackground(JTextArea supportBox) {
        this.supportBox = supportBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem item = (JMenuItem) e.getSource();
        MyIcon icon = (MyIcon) item.getIcon();
        supportBox.setBackground(icon.getColor());
    }
}
