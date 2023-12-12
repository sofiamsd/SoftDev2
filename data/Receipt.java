package data;



public class Receipt {
	protected int receiptId;
	protected Receipt receipt;
	protected String date;
	protected double sales;
	protected int items;
	protected Company company;
	protected Kind clothingType;
	protected Address address ;
	
		
	
	public Receipt(){
		company  = new Company();
		clothingType = new Kind();
		address= new Address();
	
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public int getReceiptId() {
		return receiptId;
	}



	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}



	public Receipt getReceipt() {
		return receipt;
	}



	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public double getSales() {
		return sales;
	}



	public void setSales(double sales) {
		this.sales = sales;
	}



	public int getItems() {
		return items;
	}



	public void setItems(int items) {
		this.items = items;
	}



	public Company getCompany() {
		return company;
	}



	public void setName(String company) {
		this.company = new Company();
	}



	public Kind getClothingType() {
		return clothingType;
	}



	
	
}
