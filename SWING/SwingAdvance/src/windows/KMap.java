package windows;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.awt.*;
public class KMap extends JFrame  {
	String[] txt = { "Pies", "Kot", "Tygrys" };
	  String[] keys = { "control P", "control K", "control T" };

	  ActionMap amap = new ActionMap();

	  public KMap() {
	    JTextArea ta = new JTextArea(20, 20);
	    add(new JScrollPane(ta));
	    amap.put("write", new Writer(ta));
	    add(new JScrollPane(ta));
	    JPanel p = new JPanel();
	    p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
	    p.setBorder(BorderFactory.createLineBorder(Color.blue));

	    for (int i = 0; i < txt.length; i++) {
	      JLabel l = createLabel(txt[i], keys[i]);
	      l.putClientProperty("text", txt[i]);
	      l.setAlignmentX(JLabel.RIGHT);
	      p.add(l);
	      JSeparator js = new JSeparator();
	      js.setMaximumSize(new Dimension(1200, 7));
	      p.add(js);
	    }

	    add(p, "West");
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    pack();
	    setLocationRelativeTo(null);
	    setVisible(true);
	  }

	  JLabel createLabel(String txt, String key) {
	    JLabel l = new JLabel(txt + "  ");
	    l.setPreferredSize(new Dimension(100, 50));
	    l.setToolTipText("Wciœnij : ");
	    InputMap imap = l.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	    imap.put(KeyStroke.getKeyStroke(key), "write");
	    l.setActionMap(amap);
	    return l;
	  }

	  public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	      public void run() {
	        new KMap();
	      }
	    });
	  }
}
