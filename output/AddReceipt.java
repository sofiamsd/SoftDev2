package output;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;


public abstract class AddReceipt {

	protected File fileToAppend;
	protected String receiptID, date,kind,sales,items,company,country,city,street,number;
	
	ArrayList<String> receipt = new ArrayList<String>();

	public abstract void appendFile();
	public abstract void setFileToAppend(File fileToAppend); 
	
	public void stringAdd() {
		Collections.addAll(receipt, "ReceiptID", "Date","Kind","Sales","Items","Company","Country","City","Street","Number");
	}
	
	
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