package zad3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileManager {
	
	File storageBox;
	JTextArea textArea;
	JFileChooser chooserFile;
	JPanel panel;
	
		
	public FileManager(JTextArea textArea) {
		this.textArea = textArea;
		chooserFile = new JFileChooser();
		chooserFile.addChoosableFileFilter(new FileNameExtensionFilter(
				"text file", "txt"));
		panel = new JPanel();
	}


	public void read() {
		int readThis = chooserFile.showDialog(panel, "Open File");
		if (readThis == JFileChooser.APPROVE_OPTION) {
			try {
				storageBox = chooserFile.getSelectedFile();
				BufferedReader bufferReader = new BufferedReader(new FileReader(chooserFile.getSelectedFile()));
				String line;
				textArea.setText("");

				while ((line = bufferReader.readLine()) != null) {
					textArea.append(line + "\n");
				}

				bufferReader.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	public String getName() {
		return storageBox.getName();
	}
	public void save() {

		if (storageBox == null) {
			this.saveAs();
			return;
		} else {
			saveThis(storageBox);
		}
	}

	public void saveAs() {

		int ret = chooserFile.showDialog(panel, "Save ");
		if (ret == JFileChooser.APPROVE_OPTION) {
			storageBox = chooserFile.getSelectedFile();
			saveThis(chooserFile.getSelectedFile());
		}
	}

	private void saveThis(File file) {

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(storageBox));
			bw.write(textArea.getText());
			bw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

