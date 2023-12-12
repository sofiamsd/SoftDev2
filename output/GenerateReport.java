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
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Couldn't generate report file");
        }
    }

    protected abstract void saveReportToFile(String fullPathName) throws IOException;

    private String getFilePathFromUser() {
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            return fileToSave.getAbsolutePath();
        } else {
            return null;
        }
    }
}
