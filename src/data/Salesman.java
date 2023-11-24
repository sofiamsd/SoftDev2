package data;

import java.util.ArrayList;
import output.*;
//import java.util.Vector;

public class Salesman {
	private String name;
	private String afm;
	private ArrayList<Receipt> allReceipts;
	private AddReceipt fileAppender;
	
	
	public Salesman(){
		allReceipts = new ArrayList<Receipt>();
	}
	
	
	public void setFileType(String fileType) {
		if(fileType.equals("TXT")){
			fileAppender = new AddReceiptTXT();
		}	
		else{
			fileAppender = new AddReceiptXML();
		}	
	}
	public ArrayList<Receipt> getReceipts(){
		return allReceipts;

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAfm() {
		return afm;
	}
	public void setAfm(String afm) {
		this.afm = afm;
	}

	public double calculateTotalSales(){
		double sumSales = 0;
		for(int i = 0; i< allReceipts.size(); i++){
			sumSales += allReceipts.get(i).getSales();
		}
		return sumSales;
	}
	

	public int calculateTotalItems(){
		int sumItems = 0;
		for(int i = 0; i< allReceipts.size(); i++){
			sumItems += allReceipts.get(i).getItems();
		}
		return sumItems;
	}
	
	public float calculateSkirtsSales(){
		float skirtSum = 0;
		for (int i = 0; i< allReceipts.size(); i++){
			if(allReceipts.get(i).kind.getType().equals("Skirts")){
				skirtSum += allReceipts.get(i).getItems();
			}
		}
		return skirtSum;
	}

	public float calculateCoatsSales(){
		float coatsSum = 0;
		for (int i = 0; i< allReceipts.size(); i++){
				if(allReceipts.get(i).kind.getType().equals("Coat")){
					coatsSum += allReceipts.get(i).getItems();
				}
		}		
		return coatsSum;
	}
	
	public float calculateTrouserSales(){
		float trousersSum = 0;
		for (int i = 0; i< allReceipts.size(); i++){
			if(allReceipts.get(i).kind.getType().equals("Trousers")){
				trousersSum += allReceipts.get(i).getItems();
			}	
		}
		return trousersSum;
	}
	
	public float calculateShirtsSales(){
		float shirtSum = 0;
		for (int i = 0; i< allReceipts.size(); i++){
			if(allReceipts.get(i).kind.getType().equals("Shirts")){
				shirtSum += allReceipts.get(i).getItems();
			}	
		}
		return shirtSum;
	}
	
	public double calculateCommission(){
		double commission = 0;
		if( this.calculateTotalSales() > 6000 && this.calculateTotalSales()<= 10000){
			commission = 0.1*(calculateTotalSales()-6000);
		}
		else if(this.calculateTotalSales() > 10000 && this.calculateTotalSales() <= 40000 ){
			commission = (((calculateTotalSales() - 10000) * 0.15) + (10000*0.1));			
		}
		else if(this.calculateTotalSales() > 40000 ) {
			commission = 10000*0.1 + 30000*0.15 + (calculateTotalSales() - 40000)*0.2;			
		}
		return commission;
	}


	public AddReceipt getFileAppender() {
		return fileAppender;
	}


}
