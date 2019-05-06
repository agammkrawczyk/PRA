package windows;

import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class HotelView extends JFrame implements ActionListener{
	// Obiekt klasy Dekstop
	  private static Desktop desk;
	  
	  public HotelView() {
	    // Teksty na przyciskach
	    String[] txt = { "<html><center>Informacja<br>o hotelu</center></html>", 
	                     "Broszura", "Film", "Web", "Mail" };

	    // ActionCommand przycisków
	    String[] cmd = { "Details", "roband.pdf", "45sec.mpg", 
	                     "http://oberoibali.com/", 
	                     "mailto:oberoi@bali.com" };
	    // Ikony na przyciskach
	    Icon[] icon = {
	        new ImageIcon("oberoi.jpg"), new ImageIcon("pdf_icon.gif"),
	        new ImageIcon("player.jpg"), new ImageIcon("firefox.png"), 
	        new ImageIcon("Email3.gif") 
	       };
	    
	    setLayout((LayoutManager) new FlowLayout(FlowLayout.LEFT));

	    for (int i = 0; i < icon.length; i++) {
	      JButton b = new JButton(txt[i], icon[i]);
	      b.setActionCommand(cmd[i]);
	      b.setVerticalTextPosition(SwingConstants.BOTTOM);
	      b.setHorizontalTextPosition(SwingConstants.CENTER);
	      b.addActionListener(this);
	      add(b);
	    }
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    pack();
	    setVisible(true);
	  }
	  
	  // Obs³uga przycisków
	  public void actionPerformed(ActionEvent e) {
	    String cmd = e.getActionCommand();
	    if (cmd.equals("Details")) {
	      showDetails();
	    } else if (!cmd.startsWith("http:") && ! cmd.startsWith("mailto:")) {
	        try {
	          desk.open(new File(cmd));  // otwarcie aplikacji skojarzonej z plikiem
	        } catch (IOException exc) {
	          exc.printStackTrace();
	        }
	    } else try {  // przegl¹darka lub poczta
	          URI uri = new URI(cmd);
	          if (cmd.startsWith("http:")) 
	            desk.browse(new URI(cmd)); // przegl¹darka z podanym adresem
	          else desk.mail(uri);         // klient pocztowego z podanym mailto:
	        } catch (IOException exc) {
	          exc.printStackTrace();
	        } catch (URISyntaxException exc) {
	          exc.printStackTrace();
	        }
	  }

	  private void showDetails() {
	    // ...
	  }

	  public static void main(String[] args) {
	    if (!Desktop.isDesktopSupported()) {
	      System.out.println("Aplikacja nie dzia³a na tej platformie");
	      System.exit(1);
	    }
	    desk = Desktop.getDesktop();
	    SwingUtilities.invokeLater(new Runnable() {
	      public void run() {
	        new HotelView();
	      }
	    });

	  }
}
