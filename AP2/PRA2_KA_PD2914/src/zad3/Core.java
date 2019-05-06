package zad3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeSet;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class Core extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	boolean isChange = false;
    JTextArea textArea;
    String titlePrefix = "Word processor - ", titleSufix,
            titleSufixDefault = "bez tytułu";
    FileManager fileManager;
    Hashtable<String, Color> colors;
    HashMap<Integer, String> fonts;
    {
        colors = new Hashtable<String, Color>();

        colors.put("Blue", Color.BLUE);
        colors.put("Yellow", Color.YELLOW);
        colors.put("Orange", Color.ORANGE);
        colors.put("Red", Color.RED);
        colors.put("White", Color.WHITE);
        colors.put("Black", Color.BLACK);
        colors.put("Green", Color.GREEN);

        fonts = new HashMap<Integer, String>();

        fonts.put(8, "8 pts");
        fonts.put(10, "10 pts");
        fonts.put(12, "12 pts");
        fonts.put(14, "14 pts");
        fonts.put(16, "16 pts");
        fonts.put(18, "18 pts");
        fonts.put(20, "20 pts");
        fonts.put(22, "22 pts");
        fonts.put(24, "24 pts");
    }
   

    Core() {

        initElements();
        initFrame();
    }

    protected void initElements() {

        textArea = new JTextArea();
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                isChange = true;
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }
        });
        add(new JScrollPane(textArea));
        
        fileManager = new FileManager(textArea);

        
        JMenu menuFile = new JMenu("File");
        JMenuItem fileOpen = new JMenuItem("Open");
        fileOpen.setToolTipText("Otwórz plik");
        fileOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
                ActionEvent.CTRL_MASK));
        fileOpen.setDisplayedMnemonicIndex(0);
        fileOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileManager.read();
                setTitleText(fileManager.getName());
            }
        });

        JMenuItem fileSave = new JMenuItem("Save");
        fileSave.setToolTipText("Zapisz do pliku");
        fileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                ActionEvent.CTRL_MASK));
        fileSave.setDisplayedMnemonicIndex(0);
        fileSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileManager.save();
            }
        });

        JMenuItem fileSaveas = new JMenuItem("Save As");
        fileSaveas.setToolTipText("Zapisz do nowego pliku");
        fileSaveas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
                ActionEvent.CTRL_MASK));
        fileSaveas.setDisplayedMnemonicIndex(0);
        fileSaveas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileManager.saveAs();
                setTitleText(fileManager.getName());
            }
        });

        JMenuItem fileExit = new JMenuItem("Exit");
        fileExit.setToolTipText("Wyjście z programu");
        fileExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
                ActionEvent.CTRL_MASK));
        fileExit.setDisplayedMnemonicIndex(0);
        fileExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isChange == false)
                    System.exit(0);

                int choice = JOptionPane.showConfirmDialog(null,
                        "Niezapisane zmiany zostaną utracone",
                        "Exit", 2);
                if (choice == JOptionPane.OK_OPTION) {
                    System.exit(0);
                } else {
                    return;
                }
            }
        });

        menuFile.add(fileOpen);
        fileOpen.setBorder(BorderFactory.createRaisedBevelBorder());
        menuFile.add(fileSave);
        fileSave.setBorder(BorderFactory.createRaisedBevelBorder());
        menuFile.add(fileSaveas);
        fileSaveas.setBorder(BorderFactory.createRaisedBevelBorder());
        menuFile.addSeparator();
        JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL);
        sep.setBackground(Color.RED);
        menuFile.add(sep);
        menuFile.addSeparator();
        menuFile.add(fileExit);
        fileExit.setBorder(BorderFactory.createRaisedBevelBorder());

    
        JMenu menuEdit = new JMenu("Edit");
        JMenu editAddress = new JMenu("Adresy");
        editAddress.setBorder(BorderFactory.createRaisedBevelBorder());
        JMenuItem editAddressWork = new JMenuItem("Praca");
        editAddressWork.setToolTipText("Wstaw adres miejsca pracy");
        editAddressWork.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
        ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));
        editAddressWork.setDisplayedMnemonicIndex(0);
        editAddressWork.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
                textArea.insert("Silicon Valley", textArea
                        .getCaretPosition());
            }
        });

        JMenuItem editAddressHome = new JMenuItem("Dom");
        editAddressHome.setToolTipText("Wstaw adres domowy");
        editAddressHome.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));
        editAddressHome.setDisplayedMnemonicIndex(0);
        editAddressHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.insert("New York, 5th Avenue", textArea
                        .getCaretPosition());
            }
        });

        JMenuItem editAddressesSchool = new JMenuItem("Szkoła");
        editAddressesSchool.setToolTipText("Wstaw adres uczelni");
        editAddressesSchool.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_D, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));
        editAddressesSchool.setDisplayedMnemonicIndex(0);
        editAddressesSchool.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.insert("Harrvard , Massachusetts", textArea
                        .getCaretPosition());
            }
        });

        editAddress.add(editAddressWork);
        editAddressWork.setBorder(BorderFactory.createRaisedBevelBorder());
        editAddress.add(editAddressHome);
        editAddressHome.setBorder(BorderFactory.createRaisedBevelBorder());
        editAddress.add(editAddressesSchool);
        editAddressesSchool.setBorder(BorderFactory.createRaisedBevelBorder());
        menuEdit.add(editAddress);

       
        JMenu menuOptions = new JMenu("Options");
        JMenuItem menuItem;
        JMenu optionsForeground = new JMenu("Foreground");
        editAddressHome.setDisplayedMnemonicIndex(0);
        ListForeground listOfForeground = new ListForeground(textArea);
        for (String key : colors.keySet()) {
            menuItem = new JMenuItem(key, new MyIcon(colors.get(key)));
            menuItem.addActionListener(listOfForeground);
            optionsForeground.add(menuItem);
        }

        JMenu optionsBackground = new JMenu("Background");
        ListBackground listOfBackground = new ListBackground(textArea);
        for (String key : colors.keySet()) {
            menuItem = new JMenuItem(key, new MyIcon(colors.get(key)));
            menuItem.addActionListener(listOfBackground);
            optionsBackground.add(menuItem);
        }

        JMenu optionsFontsize = new JMenu("Font size");
        TreeSet<Integer> setOfFonts = new TreeSet<Integer>(
                new ArrayList<Integer>(fonts.keySet()));
        for (Object key : setOfFonts.toArray()) {
            menuItem = new JMenuItem(fonts.get(key));
            menuItem.addActionListener(new ListFontSize(textArea,
                    (Integer) key));
            optionsFontsize.add(menuItem);
        }

        menuOptions.add(optionsForeground);
        optionsForeground.setBorder(BorderFactory.createRaisedBevelBorder());
        menuOptions.add(optionsBackground);
        optionsBackground.setBorder(BorderFactory.createRaisedBevelBorder());
        menuOptions.add(optionsFontsize);
        optionsFontsize.setBorder(BorderFactory.createRaisedBevelBorder());

        JMenuBar menu = new JMenuBar();
        menu.add(menuFile);
        menu.add(menuEdit);
        menu.add(menuOptions);

        setJMenuBar(menu);
    }

    protected void initFrame() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(400, 400));
        setLocationRelativeTo(null);
        setTitle(titlePrefix + titleSufixDefault);

        setVisible(true);
    }

    protected void setTitleText(String sufix) {
        titleSufix = sufix;
        setTitle(titlePrefix + titleSufix);
    }
}
