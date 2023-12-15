package io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddReceiptTXT extends AddReceipt {

    @Override
    public void setFileToAppend(File fileToAppend) {
        this.fileToAppend = fileToAppend;
    }

    @Override
	public void appendFileSpecific() throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileToAppend, true)) {
            fileWriter.write("\n");
            fileWriter.write("Receipt ID: " + receiptData.getReceiptId() + "\n");
            fileWriter.write("Date: " + receiptData.getDate() + "\n");
            fileWriter.write("Kind: " + kindData.getType() + "\n");
            fileWriter.write("Sales: " + receiptData.getSales() + "\n");
            fileWriter.write("Items: " + receiptData.getItems() + "\n");
            fileWriter.write("Company: " + companyData.getCompany() + "\n");
            fileWriter.write("Country: " + addressData.getCountry() + "\n");
            fileWriter.write("City: " + addressData.getCity() + "\n");
            fileWriter.write("Street: " + addressData.getStreet() + "\n");
            fileWriter.write("Number: " + addressData.getStreetNumber() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
