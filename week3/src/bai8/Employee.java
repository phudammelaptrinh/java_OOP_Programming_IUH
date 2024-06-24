package bai8;

public class Employee extends Person {
	double heSoLuong;

	public Employee(String hoTen, String diaChi, double heSoLuong) {
		super(hoTen, diaChi);
		this.heSoLuong = heSoLuong;
	}

	public double tinhLuong() {
		return heSoLuong * 3000000;
	}

	@Override
	public String toString() {
		return String.format("| %-20s | %-20s | %-10.2f | %-10.2f |", hoTen, diaChi, heSoLuong, tinhLuong());
	}
}
