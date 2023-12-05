package input;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;

public class HTMLInput extends Input {



    public HTMLInput(File receiptFileHTML) {
        this.inputFile = receiptFileHTML;
        inputFilePath = inputFile.getAbsolutePath();
    }

    @Override
    public void readFile() {
    	try {
    		Path path = Paths.get(inputFilePath);
    		List<String> lines = Files.readAllLines(path);
    		
    		for(String line: lines) {
    			line = line.replaceAll("<[^>]*>", "").trim();
    			
    			if(line.contains("Name")){
					
					name = (line.substring(line.indexOf(":") + 1).trim());
					continue;
				}	
						
				if(line.contains("AFM")){
					afm = (line.substring(line.indexOf(":") + 1).trim());
					addSalesman();
					continue;
				}
						
				if(line.contains("Receipts")){
	
					continue;
				}
							
				if(line.contains("Receipt ID")){
					receiptID = (Integer.parseInt(line.substring
					(line.indexOf(":") + 1).trim()));
					continue;
				}
							
				if(line.contains("Date")){
								
					date = (line.substring(line.indexOf(":") + 1).trim());
					continue;
				}
							
				if(line.contains("Kind")){
								
					clothingType = (line.substring(line.indexOf(":") + 1).trim());
					continue;
				}
						
				if(line.contains("Sales")){
								
					sales = (Double.parseDouble(line.substring
					(line.indexOf(":") + 1).trim()));
					continue;
				}
							
				if(line.contains("Items")){
								
					items = (Integer.parseInt(line.substring
					(line.indexOf(":") + 1).trim()));
					continue;
				}
							
													
				if(line.contains("Company")){
					companyName = (line.substring
					(line.indexOf(":") + 1).trim());
					continue;
				}
							
				if(line.contains("Country")){
					companyCountry =  (line.substring
					(line.indexOf(":") + 1).trim());
					continue;
				}
							
				if(line.contains("City")){
					companyCity =  (line.substring
					(line.indexOf(":") + 1).trim());
					continue;
				}
						
				if(line.contains("Street")){
					companyStreet =  (line.substring
					(line.indexOf(":") + 1).trim());
					continue;
				}
							
				if(line.contains("Number")){
					companyStreetNumber =  (Integer.parseInt
					(line.substring(line.indexOf(":") + 1).trim()));
					addReceipt();
					continue;
				}
    			
    		}
    		
    	} catch (IOException e) {
			e.printStackTrace();
    	}
    	
    }
}
