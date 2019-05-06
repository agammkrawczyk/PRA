package windows;

import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class TrayDemo1 implements ActionListener {
	//Ikonka aplikacji
	  private TrayIcon ticon;
	  // Menu kontekstowe
	  private PopupMenu pm = new PopupMenu();
	  // Obszar powiadomie� (tray)
	  private SystemTray tray = SystemTray.getSystemTray();
	  // W�tek przeszukiwania
	  private volatile Thread finderThread;
	  
	  // Wynik przezukiwania
	  private String result;
	  
	  // Zadanie wykonywane w w�tku przeszukiwania
	  // (symulacja przeszukiwania dysku)
	  Runnable finder = new Runnable() {
	    
	    String[] msg = { "Search finished.\nClick to view results.",
	                      "Search canceled.\nClick to view partial results."
	                    };

	    public void run() {
	      int mnr = 0, k;
	      for (k=0; k<1000; k+=100) {  // tu winno by� pzreszukiwanie
	        try {                      // symulujemy p�tl� ze sleepem
	          Thread.sleep(1000);
	        } catch (InterruptedException exc) {
	          mnr = 1;
	          break;
	        }
	        ticon.setToolTip(k + " files searched.");  // aktualne info  
	      }
	      // Po zako�czeniu przeszukiwania
	      result = (k-1) + " files found";   // wynik
	      ticon.setToolTip("Search files");  // przywracamy oryginalny tooltip
	      
	      // Pokazujemy dymek z info, �e szukanie zako�czone
	      ticon.displayMessage("Finder", msg[mnr], TrayIcon.MessageType.INFO);

	      finderThread = null;
	    }
	  };
	  
	  
	  public TrayDemo1() {
	    
	    // Ustalenie menu kontekstowego
	    String[] cmds = { "Suspend", "Cancel", "Start new search", "Exit" };
	    for (int i = 0; i < cmds.length; i++) {
	      MenuItem mi = new MenuItem(cmds[i]);
	      mi.addActionListener(this);
	      pm.add(mi);
	    }  
	    
	    // Stworzenie ikonki aplikacji
	    ticon = new TrayIcon(new ImageIcon("jsearch.gif").getImage(),
	                         "Search files",
	                         pm);
	    ticon.setImageAutoSize(true);
	    
	    // Reakcja na klikni�cie w "balon"
	    ticon.addActionListener( new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        JOptionPane.showMessageDialog(null, result);
	      }
	    });

	    // Dodanie ikonki do obszaru powiadomie�
	    try {
	      tray.add(ticon);
	    } catch (AWTException exc) {
	      exc.printStackTrace();
	    }
	    
	    // Start w�tku przeszukiwania
	    finderThread = new Thread(finder);
	    finderThread.start();
	    
	  }

	  // Obs�uga wybor�w z menu kontekstowego
	  public void actionPerformed(ActionEvent e) {
	    String cmd = e.getActionCommand();
	    if (cmd.equals("Exit")) System.exit(0);
	    else if (cmd.equals("Cancel")) {
	      if (finderThread != null) {
	        finderThread.interrupt();  // zako�czenie w�tku
	        finderThread = null;
	      }
	    }
	    else if (cmd.equals("Start new search")) {
	      if (finderThread == null) {
	        finderThread = new Thread(finder);
	        finderThread.start();
	      }
	    }
	    else {
	      System.out.println("Command not implemented.");
	    }
	  }


	  public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	      public void run() {
	        new TrayDemo1();      }
	    });
	  }
}
