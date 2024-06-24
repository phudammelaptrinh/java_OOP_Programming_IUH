package bai10;

public class PhoneBookEntry {
	private String name;
	private String address;
	private String phoneNumber;

	public PhoneBookEntry(String name, String address, String phoneNumber) {
		super();
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", Address: " + address + ", Phone: " + phoneNumber;
	}
}
