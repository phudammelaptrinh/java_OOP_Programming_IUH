package bai12;

public class Customer {
	private String name;
	private String address;

	public Customer(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void displayInfo() {
		System.out.println("Name: " + name);
		System.out.println("Address: " + address);
	}
}
