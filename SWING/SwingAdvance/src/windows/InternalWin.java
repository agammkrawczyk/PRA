package windows;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.*;

public class InternalWin extends JFrame implements ActionListener  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -421009104361317763L;
	private static ImageIcon toFront = 
	          new ImageIcon(InternalWin.class.getResource("arrow1.gif"));
	  private static ImageIcon toBack = 
	          new ImageIcon(InternalWin.class.getResource("arrow2.gif"));

	  private JDesktopPane desk = new JDesktopPane();
	  private Component glass;
	  private final int MAXC = 4;

	  InternalWin() {
	    super("Desktop");

	    // Menu kontekstowe b�dziemy dynamicznie tworzy� tuz przed pokazaniem 
	    desk.addMouseListener(new MouseAdapter() {
	      
	      public void mousePressed(MouseEvent e) {
	        createAndShowPopup(e);
	      }

	      public void mouseReleased(MouseEvent e) {
	        createAndShowPopup(e);
	      }
	      
	      void createAndShowPopup(MouseEvent e) {
	        if (e.isPopupTrigger()) {
	          int x = e.getX(), y = e.getY();
	          JPopupMenu pm = makePopup(x, y);
	          pm.show(e.getComponent(), x, y);
	        }
	      }
	    });
	    
	    // Tworzymy okna wewn�trzne
	    int x = 0, y = 0;
	    for (int i = 0; i < MAXC; i++) {
	      x += 50;
	      y += 50;
	      makeInternalWindow(i, x, y);
	    }
	    
	    // Szyba
	    glass = getGlassPane();
	    glass.addMouseListener(new MouseAdapter() {

	      public void mousePressed(MouseEvent e) {
	        if (e.isMetaDown()) {
	          glass.setVisible(false);
	          desk.revalidate();
	        } else {
	          Graphics glassGraphics = glass.getGraphics();
	          glassGraphics.setColor(Color.red);
	          glassGraphics.fillOval(e.getX() - 25, e.getY() - 25, 50, 50);
	          desk.revalidate();
	        }
	      }
	    });

	    add(desk);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    setSize(600, 600);
	    setLocationRelativeTo(null);
	    setVisible(true);
	  }

	  public void actionPerformed(ActionEvent e) {
	    JButton c = (JButton) e.getSource();
	    JRootPane rp = c.getRootPane();
	    JInternalFrame w = (JInternalFrame) rp.getParent();
	    final String cmd = e.getActionCommand();
	    if (cmd.equals("To front")) {
	      desk.setLayer(w, desk.highestLayer());
	      w.toFront();
	    } else if (cmd.equals("To back")) {
	      desk.setLayer(w, desk.lowestLayer());
	      w.toBack();
	    } else {
	      glass.setVisible(true);
	      JOptionPane
	          .showMessageDialog(desk,
	              "Next mouse press will draw red oval, use right button to exit this mode");
	    }
	  }

	  private JPopupMenu makePopup(final int x, final int y) {
	    JPopupMenu pm = new JPopupMenu();
	    JPanel p = new JPanel(new BorderLayout());
	    JLabel lab = new JLabel(
	        "<html><center><b>Window list</b><br>Select one to close/open<br>"
	            + "or add new window option</center></html>");
	    lab.setBackground(Color.yellow);
	    lab.setOpaque(true);
	    p.add(lab);
	    p.setBorder(BorderFactory.createLineBorder(Color.blue, 5));
	    pm.add(p);
	    final JInternalFrame[] jif = desk.getAllFrames();
	    for (int i = 0; i < jif.length; i++) {
	      JMenuItem mi = new JMenuItem(jif[i].getTitle());
	      pm.add(mi);
	      mi.putClientProperty("WinToClose", jif[i]);
	      mi.addActionListener(new ActionListener() {

	        public void actionPerformed(ActionEvent e) {
	          JComponent c = (JComponent) e.getSource();
	          JInternalFrame wclo = (JInternalFrame) c
	              .getClientProperty("WinToClose");
	          if (!wclo.isVisible())
	            wclo.setVisible(true);
	          else
	            wclo.doDefaultCloseAction();
	        }
	      });
	    }
	    pm.addSeparator();
	    JMenuItem mi = new JMenuItem("Add new window");
	    mi.addActionListener(new ActionListener() {

	      public void actionPerformed(ActionEvent e) {
	        makeInternalWindow(jif.length, x, y);
	      }
	    });
	    pm.add(mi);
	    return pm;
	  }

	  void makeInternalWindow(int i, int x, int y) {
	    JInternalFrame w = new JInternalFrame("Okienko " + i, true, true, true,
	        true);
	    
	    w.setLayout(new BorderLayout(5, 5));
	    JPanel controls = new JPanel();
	    controls.setBorder(BorderFactory.createRaisedBevelBorder());
	    JButton b = new JButton("To front", toFront);
	    b.addActionListener(this);
	    controls.add(b);
	    b = new JButton("To back", toBack);
	    b.addActionListener(this);
	    controls.add(b);
	    w.add(controls, "North");
	    b = new JButton("<html><center><b><font color=red>Active</font><br>"
	        + "<font color=blue>GLASS</font><br>"
	        + "<b>will prevent interaction</b></center></html>");
	    b.addActionListener(this);
	    w.add(b, "Center");
	    w.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
	    w.pack();
	    desk.add(w, i);
	    w.setLocation(x, y);
	    w.setVisible(true);
	  }

	  public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	      public void run() {
	        new InternalWin();
	      }
	    });
	  }

}
