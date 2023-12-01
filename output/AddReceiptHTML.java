package output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddReceiptHTML extends AddReceipt {

    public void setFileToAppend(File fileToAppend) {
        this.fileToAppend = fileToAppend;
    }

    public void appendFile() {
        try (FileWriter fileWriter = new FileWriter(fileToAppend, true)) {
            fileWriter.write("<div class=\"receipt\">\n");
            fileWriter.write("  <p><strong>Receipt ID:</strong> " + receiptID + "</p>\n");
            fileWriter.write("  <p><strong>Date:</strong> " + date + "</p>\n");
            fileWriter.write("  <p><strong>Kind:</strong> " + kind + "</p>\n");
            fileWriter.write("  <p><strong>Sales:</strong> " + sales + "</p>\n");
            fileWriter.write("  <p><strong>Items:</strong> " + items + "</p>\n");
            fileWriter.write("  <p><strong>Company:</strong> " + company + "</p>\n");
            fileWriter.write("  <p><strong>Country:</strong> " + country + "</p>\n");
            fileWriter.write("  <p><strong>City:</strong> " + city + "</p>\n");
            fileWriter.write("  <p><strong>Street:</strong> " + street + "</p>\n");
            fileWriter.write("  <p><strong>Number:</strong> " + number + "</p>\n");
            fileWriter.write("</div>\n");
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }
}

