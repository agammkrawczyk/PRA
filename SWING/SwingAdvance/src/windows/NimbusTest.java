package windows;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class NimbusTest {
	 public static void main(String[] args) throws Exception {
	        UIManager.setLookAndFeel(new NimbusLookAndFeel());

	        JFrame frame = new JFrame("Nimbus test");
	        frame.add(new JScrollPane(new JTextArea(10,10)));
	        JPanel p = new JPanel();
	        p.add(new JLabel("Opis"));
	        p.add(new JTextField(10));
	        p.add(new JSlider(0, 10));
	        p.add(new JButton("Ok"));
	        p.add(new JButton("Cancel"));
	        frame.add(p, "South");
	        frame.pack();
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	    }
}
