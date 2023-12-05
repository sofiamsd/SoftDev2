package output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import data.Salesman;

public class GenerateHTMLReport extends GenerateReport {

    public GenerateHTMLReport(Salesman salesman) {
        this.salesman = salesman;
    }

    public void saveFile() {
        try {
            String fullPathName = getFilePathFromUser();

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fullPathName)));

            bufferedWriter.write("<!DOCTYPE html>");
            bufferedWriter.newLine();
            bufferedWriter.write("<html lang=\"en\">");
            bufferedWriter.newLine();
            bufferedWriter.write("<head>");
            bufferedWriter.newLine();
            bufferedWriter.write("    <meta charset=\"UTF-8\">");
            bufferedWriter.newLine();
            bufferedWriter.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            bufferedWriter.newLine();
            bufferedWriter.write("    <title>Sales Report</title>");
            bufferedWriter.newLine();
            bufferedWriter.write("</head>");
            bufferedWriter.newLine();
            bufferedWriter.write("<body>");
            bufferedWriter.newLine();
            bufferedWriter.newLine();

            bufferedWriter.write("<h1>Sales Report</h1>");
            bufferedWriter.newLine();

            bufferedWriter.write("<h2>Personal Information:</h2>");
            bufferedWriter.newLine();
            bufferedWriter.write("<p><strong>Name:</strong> " + salesman.getName() + "</p>");
            bufferedWriter.newLine();
            bufferedWriter.write("<p><strong>AFM:</strong> " + salesman.getAfm() + "</p>");
            bufferedWriter.newLine();
            bufferedWriter.newLine();

            bufferedWriter.write("<h2>Sales Details:</h2>");
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

            bufferedWriter.write("</body>");
            bufferedWriter.newLine();
            bufferedWriter.write("</html>");

            bufferedWriter.close();
            //JOptionPane.showMessageDialog(null, "HTML report generated successfully!");

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Couldn't generate HTML file");
        }
    }


    private String getFilePathFromUser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");

        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            return fileToSave.getAbsolutePath() + ".html"; 
        } else {
           
            return null;
        }
    }
}
