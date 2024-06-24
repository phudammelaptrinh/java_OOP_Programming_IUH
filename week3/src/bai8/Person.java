package bai8;

public abstract class Person {
	String hoTen;
	String diaChi;

	public Person(String hoTen, String diaChi) {
		super();
		this.hoTen = hoTen;
		this.diaChi = diaChi;
	}

	@Override
	public String toString() {
		return String.format("| %-20s | %-20s |", hoTen, diaChi);
	}
}
