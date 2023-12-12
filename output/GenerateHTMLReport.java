package output;

import data.Salesman;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateHTMLReport extends GenerateReport {

    public GenerateHTMLReport(Salesman salesman) {
        super(salesman);
    }

    protected void saveReportToFile(String fullPathName) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fullPathName + ".html")))) {
            //StringBuilder htmlContent = new StringBuilder();
            bufferedWriter.append("<!DOCTYPE html>")
                    .append("<html lang=\"en\">")
                    .append("<head>")
                    .append("    <meta charset=\"UTF-8\">")
                    .append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">")
                    .append("    <title>Sales Report</title>")
                    .append("</head>")
                    .append("<body>")
                    .append("<h1>Sales Report</h1>")
                    .append("<h2>Personal Information:</h2>")
                    .append("<p><strong>Name:</strong> ").append(salesman.getName()).append("</p>")
                    .append("<p><strong>AFM:</strong> ").append(salesman.getAfm()).append("</p>")
                    .append("<h3>Sales Details:</h3>");

            writeSalesDetails(bufferedWriter);

            bufferedWriter.append("</body>")
                    .append("</html>");

            //bufferedWriter.write(bufferedWriter.toString());
        }
    }

    private void writeSalesDetails(BufferedWriter bufferedWriter) throws IOException {
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
    }
}
