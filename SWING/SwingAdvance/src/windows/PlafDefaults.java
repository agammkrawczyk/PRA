package windows;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class PlafDefaults {
	 public static void main(String[] args) {
		    UIDefaults defaults = UIManager.getLookAndFeel().getDefaults();;
		    for (Object key : defaults.keySet()) {
		      System.out.println(key + " = " + defaults.get(key));
		    }
		  }
}
