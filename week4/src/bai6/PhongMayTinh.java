package bai6;

public class PhongMayTinh extends PhongHoc {
	private int soLuongMayTinh;

	public PhongMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen, int soLuongMayTinh) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.soLuongMayTinh = soLuongMayTinh;
	}

	public int getSoLuongMayTinh() {
		return soLuongMayTinh;
	}

	public void setSoLuongMayTinh(int soLuongMayTinh) {
		this.soLuongMayTinh = soLuongMayTinh;
	}

	@Override
	public boolean kiemTraDatChuan() {
		return getDienTich() / 1.5 <= soLuongMayTinh && getSoBongDen() >= 1;
	}

	@Override
	public String toString() {
		return super.toString() + ", soLuongMayTinh=" + soLuongMayTinh;
	}
}
