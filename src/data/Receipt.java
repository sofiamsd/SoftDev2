package data;



public class Receipt {
	protected int receiptId;
	protected String date;
	protected double sales;
	protected int items;
	protected Company company;
	protected Kind kind;
	
		
	
	public Receipt(){
		company  = new Company();
		kind = new Kind("");
	}
	


	public Company getCompany(){
		
		return company;
	}

	
	public Kind getKind() {
		return kind;
	}
	 

	
	public double getSales() {
		return sales;
	}

	public Receipt(int receiptId, String date, double sales, int items, Company company, Kind kind) {
		super();
		this.receiptId = receiptId;
		this.date = date;
		this.sales = sales;
		this.items = items;
		this.company = company;
		this.kind = kind;
	}



	public void setSales(double sales) {

		this.sales = sales;
	}

	
	public void setItems(int items) {
		this.items = items;
	}

	
	public int getItems() {
		return this.items;
	}

	
	public void setReceiptID(int id) {
		this.receiptId = id;		
		
	}

	
	public int getReceiptID() {
		return receiptId;
	}

	
	public void setDate(String date) {
		this.date = date;
	}

	
	public String getDate() {
		return date;			
	}
	
	
	
}
