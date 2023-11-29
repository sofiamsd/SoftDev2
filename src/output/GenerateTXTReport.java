package output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import data.Salesman;


public class GenerateTXTReport extends GenerateReport{

	
	public GenerateTXTReport(Salesman a){
		salesman = a;
	}
	
	
	public void saveFile() {
        //BufferedWriter bufferedWriter = null;
        try{
        	String fullPathName = getFilePathFromUser();

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fullPathName)));
            
        	bufferedWriter.write("Name: " + salesman.getName()); 
            bufferedWriter.newLine();

            bufferedWriter.write("AFM: " + salesman.getAfm());
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.newLine();

            
            bufferedWriter.write("Total Sales: " + salesman.calculateTotalSales());
            bufferedWriter.newLine();
 
            bufferedWriter.write("Trousers Sales: " + salesman.calculateTrouserSales());
            bufferedWriter.newLine();

            bufferedWriter.write("Skirts Sales: " + salesman.calculateSkirtsSales());
            bufferedWriter.newLine();

            bufferedWriter.write("Shirts Sales: " + salesman.calculateShirtsSales());
            bufferedWriter.newLine();
            
            bufferedWriter.write("Coats Sales: " + salesman.calculateCoatsSales());
            bufferedWriter.newLine();

            bufferedWriter.write("Commission: " + salesman.calculateCommission());
            
        	bufferedWriter.close();


        }catch (IOException ex){
			JOptionPane.showMessageDialog(null,"Couldn't generate txt file ");

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
