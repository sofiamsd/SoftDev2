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
			System.out.print(fileToAppend);
			String filename = fileToAppend.getName();
			String extension = filename.substring(filename.lastIndexOf(".") + 1, filename.length());
			String txt = "txt";
			String xml = "xml";
			String html = "html";
			
			if(extension.equals(txt)) {
				System.out.print("\n it's a txt");
			}else if(extension.equals(xml)) {
				System.out.print("\n it's an xml");
			}else if(extension.equals(html)) {
				System.out.print("\n it's an html");
			}
			
			FileWriter fileWriter = new FileWriter(fileToAppend,true);

            fileWriter.write("\n");
            fileWriter.write("Receipt ID: " + receiptID + "\n");
            fileWriter.write("Date: " + date + "\n");
            fileWriter.write("Kind: " + kind + "\n");
            fileWriter.write("Sales: " + sales + "\n");
            fileWriter.write("Items: " + items + "\n");
            fileWriter.write("Company: " + company + "\n");
            fileWriter.write("Country: " + country + "\n");
            fileWriter.write("City: " + city + "\n");
            fileWriter.write("Street: " + street + "\n");
            fileWriter.write("Number: " + number + "\n");
			
			fileWriter.close();
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
