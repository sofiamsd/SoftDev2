package output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddReceiptTXT extends AddReceipt{

	public  void setFileToAppend(File fileToAppend) {
		
		this.fileToAppend = fileToAppend;
		
	}

	public void appendFile(){

		try {
			
			FileWriter fileWriter = new FileWriter(fileToAppend,true);		
			fileWriter.write("\n");
			fileWriter.write("Receipt ID: ");
			fileWriter.write(receiptID);
			fileWriter.write("\n");

			fileWriter.write("Date: ");
			fileWriter.write(date);
			fileWriter.write("\n");

			fileWriter.write("Kind: ");
			fileWriter.write(kind);
			fileWriter.write("\n");

			fileWriter.write("Sales: ");
			fileWriter.write(sales);
			fileWriter.write("\n");

			fileWriter.write("Items: ");
			fileWriter.write(items);
			fileWriter.write("\n");

			fileWriter.write("Company: ");
			fileWriter.write(company);
			fileWriter.write("\n");


			fileWriter.write("Country: ");
			fileWriter.write(country);
			fileWriter.write("\n");
			
			fileWriter.write("City: ");
			fileWriter.write(city);
			fileWriter.write("\n");

			fileWriter.write("Street: ");
			fileWriter.write(street);
			fileWriter.write("\n");

			fileWriter.write("Number: ");
			fileWriter.write(number);
			fileWriter.write("\n");

			fileWriter.close();
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
