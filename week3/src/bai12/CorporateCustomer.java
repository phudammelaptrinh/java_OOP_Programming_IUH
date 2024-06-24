package bai12;

public class CorporateCustomer extends Customer {
	private String contactPerson;

	public CorporateCustomer(String name, String address, String contactPerson) {
		super(name, address);
		// TODO Auto-generated constructor stub
		this.contactPerson = contactPerson;

	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("Contact Person: " + contactPerson);
	}

}
