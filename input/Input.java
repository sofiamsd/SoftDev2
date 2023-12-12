package input;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import data.Salesman;
import data.Kind;
import data.Receipt;

public abstract class Input {
	
	protected Salesman salesman;
	protected File inputFile;
	protected String inputFilePath;
	protected String name;
	protected String afm;
	protected int receiptID;
	protected String date;
	protected Kind kind;
	protected String clothingType;
	protected double sales;
	protected int items;
	protected String companyName;
	protected String companyCountry;
	protected String companyCity;
	protected String companyStreet;
	protected int companyStreetNumber;

	public abstract void readFile();

	public Input() {
		salesman = new Salesman();
		kind = new Kind();

	}

    protected abstract void parseLine(String line);

    protected void processFileLines(List<String> lines) {
        for (String line : lines) {
            parseLine(line);
        }
    }
	public void addSalesman() {
		salesman.setName(name);
		salesman.setAfm(afm);
	}
	
	public void addReceipt( ){
		Receipt receipt = new Receipt();			
		if(clothingType.equals("Shirts")) {
			receipt.getClothingType().setType("Shirts");

		}
		else if (clothingType.equals("Skirts")) {
			receipt.getClothingType().setType("Skirts");

		}
		else if (clothingType.equals("Trousers")) {
			receipt.getClothingType().setType("Trousers");

		}
		else if(clothingType.equals("Coats")){
			receipt.getClothingType().setType("Coats");
		}
		
		receipt.setReceiptId(receiptID);			
		receipt.setDate(date);
		receipt.setSales(sales);
		receipt.setItems(items);
		receipt.getCompany().setCompany(companyName);
		receipt.getCompany().getCompanyAddress().setCountry(companyCountry);
		receipt.getCompany().getCompanyAddress().setCity(companyCity);
		receipt.getCompany().getCompanyAddress().setStreet(companyStreet);
		receipt.getCompany().getCompanyAddress().setStreetNumber(companyStreetNumber);
		salesman.getReceipts().add(receipt);
	}
	public Salesman getSalesman() {
		return salesman;
	}
	 protected void processCommonLines(String line) {
	        if (line.startsWith("Name:")) {
	            name = (line.substring(line.indexOf(":") + 1).trim());
	        } else if (line.startsWith("AFM")) {
	            afm = (line.substring(line.indexOf(":") + 1).trim());
	            addSalesman();
	        } else if (line.startsWith("Receipts")) {
	        } else if (line.startsWith("Receipt ID")) {
	            receiptID = (Integer.parseInt(line.substring(line.indexOf(":") + 1).trim()));
	        } else if (line.startsWith("Date")) {
	            date = (line.substring(line.indexOf(":") + 1).trim());
	        } else if (line.startsWith("Kind")) {
	            clothingType = (line.substring(line.indexOf(":") + 1).trim());
	        } else if (line.startsWith("Sales")) {
	            sales = (Double.parseDouble(line.substring(line.indexOf(":") + 1).trim()));
	        } else if (line.startsWith("Items")) {
	            items = (Integer.parseInt(line.substring(line.indexOf(":") + 1).trim()));
	        } else if (line.startsWith("Company")) {
	            companyName = (line.substring(line.indexOf(":") + 1).trim());
	        } else if (line.startsWith("Country")) {
	            companyCountry = (line.substring(line.indexOf(":") + 1).trim());
	        } else if (line.startsWith("City")) {
	            companyCity = (line.substring(line.indexOf(":") + 1).trim());
	        } else if (line.startsWith("Street")) {
	            companyStreet = (line.substring(line.indexOf(":") + 1).trim());
	        } else if (line.startsWith("Number")) {
	            companyStreetNumber = (Integer.parseInt(line.substring(line.indexOf(":") + 1).trim()));
	            addReceipt();
	        }
	    }

	    protected void readFileCommon(String inputFilePath) throws IOException {
	        Path path = Paths.get(inputFilePath);
	        List<String> lines = Files.readAllLines(path);
	        processFileLines(lines);
	    }
}