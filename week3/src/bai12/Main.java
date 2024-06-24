package bai12;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer regular = new RegularCustomer("Nguyen Van A", "123 Le Loi, HCM", 10.0);
		Customer corporate = new CorporateCustomer("Cong ty ABC", "456 Nguyen Hue, HCM", "Le Thi B");

		// In tiêu đề bảng
		System.out.format("%-20s%-30s%-10s%-20s\n", "Name", "Address", "Discount", "Contact Person");
		System.out.println("----------------------------------------------------------------------------");

		// Hiển thị thông tin khách hàng
		printCustomerInfo(regular);
		printCustomerInfo(corporate);
	}

	// Hàm in thông tin khách hàng
	public static void printCustomerInfo(Customer customer) {
		if (customer instanceof RegularCustomer) {
			RegularCustomer rc = (RegularCustomer) customer;
			System.out.format("%-20s%-30s%-10.2f%-20s\n", rc.getName(), rc.getAddress(), rc.getDiscount(), "N/A");
		} else if (customer instanceof CorporateCustomer) {
			CorporateCustomer cc = (CorporateCustomer) customer;
			System.out.format("%-20s%-30s%-10s%-20s\n", cc.getName(), cc.getAddress(), "N/A", cc.getContactPerson());
		}
	}

}
