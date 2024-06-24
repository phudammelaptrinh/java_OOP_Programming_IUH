package bai12;

public class RegularCustomer extends Customer {
	private double discount;

	public RegularCustomer(String name, String address, double discount) {
		super(name, address);
		this.discount = discount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("Discount: " + discount + "%");
	}
}
