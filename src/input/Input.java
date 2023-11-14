package input;


import java.io.File;

import data.Agent;
import data.Kind;
import data.Receipt;


public abstract class Input {
	
	protected Agent agent;
	protected File inputFile;
	protected String inputFilePath;
	protected String name;
	protected String afm;
	protected int receiptID;
	protected String date;
	protected String shirt ;
	protected String skirt;
	protected String trousers;
	protected String coat ;
	protected Kind kind ;
	protected double sales;
	protected int items;
	protected String companyName;
	protected String companyCountry;
	protected String companyCity;
	protected String companyStreet;
	protected int companyStreetNumber;

	public abstract void readFile();

	
	public Input() {
		agent = new Agent();
		kind  = new Kind();
	}
	

	
	public void addAgent() {
		agent.setName(name);
		agent.setAfm(afm);
	}
	
	public void addReceipt( ){
		Receipt receipt = null;			
			if(kind.equals("Shirts")) {
				receipt.getKind().setShirt(shirt);

			}
			else if (kind.equals("Skirts")) {
				receipt.getKind().setSkirt(skirt);

			}
			else if (kind.equals("Trousers")) {
				receipt.getKind().setTrousers(trousers);

			}
			else {
				receipt.getKind().setCoat(coat);
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
	public Agent getAgent() {
		return agent;
	}

	
}
