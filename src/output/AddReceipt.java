package output;

import java.io.File;
//import data.*;

public abstract class AddReceipt {

	protected File fileToAppend;
	protected String receiptID;
	protected String date;
	protected String kind;
	protected String sales;
	protected String items;
	protected String company;
	protected String country;
	protected String city;
	protected String street;
	protected String number;

	public abstract void appendFile();
	public abstract void setFileToAppend(File fileToAppend); 
	
	public void setReceiptID(String receiptID) {
		this.receiptID = receiptID;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public void setKind(String kind) {
		this.kind = kind;
	}



	public void setSales(String sales) {
		this.sales = sales;
	}



	public void setItems(String items) {
		this.items = items;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public void setStreet(String street) {
		this.street = street;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}

