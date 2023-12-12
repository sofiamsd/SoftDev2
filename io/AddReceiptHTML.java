package io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddReceiptHTML extends AddReceipt {

    @Override
    public void setFileToAppend(File fileToAppend) {
        this.fileToAppend = fileToAppend;
    }

    @Override
    protected void appendFileSpecific() throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileToAppend, true)) {
            fileWriter.write("<div class=\"receipt\">\n");
            fileWriter.write("  <p><strong>Receipt ID:</strong> " + receiptData.getReceiptId() + "</p>\n");
            fileWriter.write("  <p><strong>Date:</strong> " + receiptData.getDate() + "</p>\n");
            fileWriter.write("  <p><strong>Kind:</strong> " + kindData.getType() + "</p>\n");
            fileWriter.write("  <p><strong>Sales:</strong> " + receiptData.getSales() + "</p>\n");
            fileWriter.write("  <p><strong>Items:</strong> " + receiptData.getItems() + "</p>\n");
            fileWriter.write("  <p><strong>Company:</strong> " + companyData.getCompany() + "</p>\n");
            fileWriter.write("  <p><strong>Country:</strong> " + addressData.getCountry() + "</p>\n");
            fileWriter.write("  <p><strong>City:</strong> " + addressData.getCity() + "</p>\n");
            fileWriter.write("  <p><strong>Street:</strong> " + addressData.getStreet() + "</p>\n");
            fileWriter.write("  <p><strong>Number:</strong> " + addressData.getStreetNumber() + "</p>\n");
            fileWriter.write("</div>\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
