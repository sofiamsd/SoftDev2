package input;


import java.io.File;


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
		kind = new Kind("");
		

	}
	public void addSalesman() {
		salesman.setName(name);
		salesman.setAfm(afm);
	}
	
	public void addReceipt( ){
		Receipt receipt = new Receipt();			
		if(clothingType.equals("Shirts")) {
			receipt.getKind().setType("Shirts");

		}
		else if (clothingType.equals("Skirts")) {
			receipt.getKind().setType("Skirts");

		}
		else if (clothingType.equals("Trousers")) {
			receipt.getKind().setType("Trousers");

		}
		else if(clothingType.equals("Coats")){
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
		salesman.getReceipts().add(receipt);
	}
	public Salesman getSalesman() {
		return salesman;
	}
}