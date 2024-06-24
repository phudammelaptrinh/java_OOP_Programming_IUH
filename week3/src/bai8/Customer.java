package bai8;

public class Customer extends Person {
	String loaiKhachHang;

	public Customer(String hoTen, String diaChi, String loaiKhachHang) {
		super(hoTen, diaChi);
		this.loaiKhachHang = loaiKhachHang;
	}

	@Override
	public String toString() {
		return String.format("| %-20s | %-20s | %-15s |", hoTen, diaChi, loaiKhachHang);
	}
}
