package data;
public class Company {

		private String company;
		private Address companyAddress;
		
		
		public Company(){
			companyAddress = new Address();
		}
		
		public String getCompany() {
			return company;
		}
		
		public void setCompany(String company) {
			this.company = company;
		}
		
		
		public Address getCompanyAddress(){
			
			return companyAddress;
		}


}
