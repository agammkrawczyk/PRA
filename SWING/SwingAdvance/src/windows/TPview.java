import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.synth.SynthLookAndFeel;

import org.jvnet.lafwidget.*;
import org.jvnet.lafwidget.tabbed.*;
import org.jvnet.substance.*;
import org.jvnet.substance.theme.*;

public class TPview extends JFrame {

  public TPview() {
    super("Przegl�d zak�adek");

    Color[] c = { Color.BLUE, Color.RED, Color.YELLOW };

    JTabbedPane tp = new JTabbedPane();
    for (int i = 0; i < c.length; i++) {
      JPanel p = new JPanel();
      p.setBackground(c[i]);
      int n = i + 1;
      p.add(new JButton("Przycisk " + n));
      tp.add("Tab " + n, p);
    }

    add(tp, BorderLayout.CENTER);

    // Ustalenie podgl�du zak�adek
    tp.putClientProperty(LafWidget.TABBED_PANE_PREVIEW_PAINTER,
        new DefaultTabPreviewPainter());

    setSize(500, 300);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
  }

  public static void main(String[] args) throws Exception {
    UIManager.setLookAndFeel(new SynthLookAndFeel());
    SynthLookAndFeel.setCurrentTheme(new SubstanceSteelBlueTheme());
     SwingUtilities.invokeLater( new Runnable() {
        public void run() {
         new TPview();
        }
     });
  }
}