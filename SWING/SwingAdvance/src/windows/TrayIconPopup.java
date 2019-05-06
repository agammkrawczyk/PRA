package windows;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
public class TrayIconPopup  extends TrayIcon {
	 // okno potrzebna dla fokusu (dialog, aby nie bylo widoczne na pasku)
	  private static JDialog frame;
	  
	  private JPopupMenu menu = new JPopupMenu();

	  // Troch� wygodniejszy konstruktor
	  public TrayIconPopup(ImageIcon icon, String tooltip) {
	    this(icon.getImage(), tooltip);
	  }

	  // Standardowy konstruktor
	  public TrayIconPopup(Image image, String tooltip) {
	    super(image, tooltip);

	    // aby unikn�c od czasu do czasu pojawiaj�cego si� b��du z EDT
	    // spowodowanego zbyt wysokim poziomem (u nas) obs�ugi zdarze� myszki
	    System.setProperty("sun.awt.exception.handler",
	                       "traypopup.EdtUncaughtExcHandler");
	    configureMenu();
	  
	    // Pokazuje menu kontekstowe z TrayIcom
	    addMouseListener(new MouseAdapter() {

	      @Override
	      public void mouseReleased(MouseEvent e) {
	        if (e.isPopupTrigger()) {
	          if (frame == null) {
	            frame = new JDialog((Frame)null);
	            frame.setAlwaysOnTop(true);  // nie zwalczymy tym WinTaskBaru on top!
	            frame.setSize(0, 0);
	          }
	          frame.setVisible(true);
	          int shift = menu.getPreferredSize().width;
	          menu.show(frame.getContentPane(), e.getX() - shift, e.getY());
	          frame.toFront();
	        }
	      }
	    });

	  }

	  private void configureMenu() {
	    menu.setLightWeightPopupEnabled(false);
	    menu.addPopupMenuListener( new PopupMenuListener() {

	      public void popupMenuCanceled(PopupMenuEvent e) {}
	      
	      public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
	        frame.setVisible(false);
	        frame.toBack();
	      }
	      public void popupMenuWillBecomeVisible(PopupMenuEvent e) { }
	    });
	  }

	  // Dodanie do menu kontekstowegp
	  public void addToPopup(JMenuItem mi) {
	    menu.add(mi);
	  }

	  // Dodanie do menu kontesktowegp
	  public void addToPopup(Action a) {
	    menu.add(a);
	  }
	  
	  // Ustalenie innego menu kontekstowego
	  public void setPopup(JPopupMenu popup) {
	    menu = popup;
	    configureMenu();
	  }

	  // Zwraca JPopupMenu, mo�emy na nim dzia�a� dynamicznie
	  public JPopupMenu getPopup() {
	    return menu;
	  }

	  public void addToPopup(JSeparator separator) {
	    menu.add(separator);
	  }
}
