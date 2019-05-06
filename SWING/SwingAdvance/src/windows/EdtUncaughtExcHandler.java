package windows;

public class EdtUncaughtExcHandler {
	public void handle(Throwable t) {
	    
	    if (t.toString()
	        .indexOf("TrayIconPopup cannot be cast to java.awt.Component") == -1) {
	      t.printStackTrace();
	    }
	}
}
