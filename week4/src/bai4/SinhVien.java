package bai4;

public class SinhVien {
	private String ma;
	private String hoTen;
	private int namSinh;

	public SinhVien(String ma, String hoTen, int namSinh) {
		super();
		this.ma = ma;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	@Override
	public String toString() {
		return String.format("%-10s %-20s %-10d", ma, hoTen, namSinh);
	}

}
