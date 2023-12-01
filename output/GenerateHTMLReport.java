package output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import data.Salesman;

public class GenerateHTMLReport extends GenerateReport {

    public GenerateHTMLReport(Salesman a) {
        salesman = a;
    }

    public void saveFile() {
        //BufferedWriter bufferedWriter = null;
        try {
        	String fullPathName = getFilePathFromUser();

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fullPathName)));

            // Writing HTML structure
            bufferedWriter.write("<html>");
            bufferedWriter.newLine();
            bufferedWriter.write("<head>");
            bufferedWriter.newLine();
            bufferedWriter.write("<title>Sales Report</title>");
            bufferedWriter.newLine();
            bufferedWriter.write("</head>");
            bufferedWriter.newLine();
            bufferedWriter.write("<body>");
            bufferedWriter.newLine();

            // Writing agent information
            bufferedWriter.write("<h1>Agent Information</h1>");
            bufferedWriter.newLine();
            bufferedWriter.write("<p><strong>Name:</strong> " + salesman.getName() + "</p>");
            bufferedWriter.newLine();
            bufferedWriter.write("<p><strong>AFM:</strong> " + salesman.getAfm() + "</p>");
            bufferedWriter.newLine();
            bufferedWriter.newLine();

            // Writing sales information
            bufferedWriter.write("<h2>Sales Information</h2>");
            bufferedWriter.newLine();
            bufferedWriter.write("<p><strong>Total Sales:</strong> " + salesman.calculateTotalSales() + "</p>");
            bufferedWriter.newLine();
            bufferedWriter.write("<p><strong>Trousers Sales:</strong> " + salesman.calculateTrouserSales() + "</p>");
            bufferedWriter.newLine();
            bufferedWriter.write("<p><strong>Skirts Sales:</strong> " + salesman.calculateSkirtsSales() + "</p>");
            bufferedWriter.newLine();
            bufferedWriter.write("<p><strong>Shirts Sales:</strong> " + salesman.calculateShirtsSales() + "</p>");
            bufferedWriter.newLine();
            bufferedWriter.write("<p><strong>Coats Sales:</strong> " + salesman.calculateCoatsSales() + "</p>");
            bufferedWriter.newLine();
            bufferedWriter.write("<p><strong>Commission:</strong> " + salesman.calculateCommission() + "</p>");
            bufferedWriter.newLine();

            // Closing HTML structure
            bufferedWriter.write("</body>");
            bufferedWriter.newLine();
            bufferedWriter.write("</html>");

            JOptionPane.showMessageDialog(null, "HTML file generated successfully!");

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: Couldn't generate HTML file. " + ex.getMessage());
//        } finally {
//            try {
//                if (bufferedWriter != null) {
//                    bufferedWriter.close();
//                }
//            } catch (IOException ex) {
//                JOptionPane.showMessageDialog(null, "Error: Couldn't close the BufferedWriter. " + ex.getMessage());
//            }
        }
    }
    // Helper method to get file path from the user using JFileChooser
    private String getFilePathFromUser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");
        
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            return fileToSave.getAbsolutePath();
        } else {
            // User canceled the operation
            return null;
        }
    }
}

