package input;


import java.io.File;


import data.Salesman;
import data.Kind;
import data.Receipt;

public abstract class Input {
	
	protected Salesman agent;
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
		agent = new Salesman();
		kind = new Kind("");
		

	}
	

	
	public void addAgent() {
		agent.setName(name);
		agent.setAfm(afm);
	}
	
	public void addReceipt( ){
		Receipt receipt = new Receipt();			
		if(kind.equals("Shirts")) {
			receipt.getKind().setType("Shirts");

		}
		else if (kind.equals("Skirts")) {
			receipt.getKind().setType("Skirts");

		}
		else if (kind.equals("Trousers")) {
			receipt.getKind().setType("Trousers");

		}
		else {
			receipt.getKind().setType("Coats");
		}
		
		receipt.setReceiptID(receiptID);			
		receipt.setDate(date);
		receipt.setSales(sales);
		receipt.setItems(items);
		receipt.getCompany().setName(companyName);
		receipt.getCompany().getCompanyAddress().setCountry(companyCountry);
		receipt.getCompany().getCompanyAddress().setCity(companyCity);
		receipt.getCompany().getCompanyAddress().setStreet(companyStreet);
		receipt.getCompany().getCompanyAddress().setStreetNumber(companyStreetNumber);
		agent.getReceipts().add(receipt);
	}
	public Salesman getAgent() {
		return agent;
	}

	
}
