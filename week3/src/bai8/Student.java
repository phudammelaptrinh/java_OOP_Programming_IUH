package bai8;

public class Student extends Person {
	int diemMonHoc1;
	int diemMonHoc2;

	public Student(String hoTen, String diaChi, int diemMonHoc1, int diemMonHoc2) {
		super(hoTen, diaChi);
		this.diemMonHoc1 = diemMonHoc1;
		this.diemMonHoc2 = diemMonHoc2;
	}

	public double tinhDiemTrungBinh() {
		return (diemMonHoc1 + diemMonHoc2) / 2.0;
	}

	@Override
	public String toString() {
		return String.format("| %-20s | %-20s | %-10d | %-10d | %-10.2f |", hoTen, diaChi, diemMonHoc1, diemMonHoc2,
				tinhDiemTrungBinh());
	}
}
