package output;

import data.Salesman;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateTXTReport extends GenerateReport {

    public GenerateTXTReport(Salesman a) {
        super(a);
    }

    @Override
    protected void saveReportToFile(String fullPathName) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fullPathName + ".txt")))) {
            bufferedWriter.write("Name: " + salesman.getName());
            bufferedWriter.newLine();
            bufferedWriter.write("AFM: " + salesman.getAfm());
            bufferedWriter.newLine();
            bufferedWriter.newLine();

            writeSalesDetails(bufferedWriter);

            // JOptionPane.showMessageDialog(null, "TXT file generated successfully!");
        }
        catch (Exception ex) {
            ex.printStackTrace();
            throw new IOException("Could not generate TXT file");
        }
    }

    private void writeSalesDetails(BufferedWriter bufferedWriter) throws IOException {
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
    }
}
