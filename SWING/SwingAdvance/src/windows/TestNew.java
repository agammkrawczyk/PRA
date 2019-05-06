package windows;
import java.awt.AWTException;
import java.awt.SystemTray;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.UIManager;

import com.jgoodies.looks.windows.*;

public class TestNew {
	 public static void main(String[] args) {
		    
		    // Aby menu kontekstowe wygl¹da³o ³adnie uzyjemy JGoodies
		    try {
		      UIManager.setLookAndFeel(new WindowsLookAndFeel());
		    } catch (Exception e) {
		      e.printStackTrace();
		    }

		    ImageIcon[] icons = {
		        new ImageIcon("jsbook.gif"), new ImageIcon("jsearch.gif"),
		        new ImageIcon("middle.gif"), new ImageIcon("error.gif"),
		    };
		    
		    TrayIconPopup ti = 
		      new TrayIconPopup(icons[0],  "Test JPopupMenu with TrayIcon");
		     
		    for (int i=1; i< icons.length; i++) {
		      ti.addToPopup(new JMenuItem("Element " + i, icons[i]));
		    }
		    ti.addToPopup(new JSeparator());
		    ti.addToPopup(new JMenuItem("Wykonanie operacji x"));
		    ti.addToPopup(new AbstractAction("Quit") {
		      
		    public void actionPerformed(ActionEvent e) {
		        System.exit(0);
		      }
		    });
		    
		   SystemTray tray = SystemTray.getSystemTray();
		    try {
		      tray.add(ti);
		    } catch (AWTException exc) {
		      exc.printStackTrace();
		    }
		    
		    JFrame f = new JFrame("Okno aplikacji");
		    f.add(new JButton("Mo¿e coœ robi, jest jakieœ GUI, itd. itp."));
		    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    f.setLocationRelativeTo(null);
		    f.pack();
		    f.setVisible(true);
		  }

}
