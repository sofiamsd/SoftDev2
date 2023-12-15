package output;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import data.Salesman;

import java.io.File;
import java.io.IOException;

public abstract class GenerateReport {

    protected Salesman salesman;

    public GenerateReport(Salesman a) {
        salesman = a;
    }

    public void saveFile() {
        try {
            String fullPathName = getFilePathFromUser();
            if (fullPathName != null) {
                saveReportToFile(fullPathName);
            }
       
        } catch (Exception e) {

			e.printStackTrace();
		}
    }

    protected abstract void saveReportToFile(String fullPathName) throws IOException;

    private String getFilePathFromUser() throws Exception {
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(null, "The file was created successfully ");
            return fileToSave.getAbsolutePath();
            
        } else if (userSelection == JFileChooser.CANCEL_OPTION) {
           JOptionPane.showMessageDialog(null, "Could not create a file");
        }
		return null;
    }
}
