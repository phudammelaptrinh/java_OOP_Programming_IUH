package bai7;

public abstract class HangHoa {
	String maHang;
	String tenHang;
	int soLuongTon;
	double donGia;

	public HangHoa(String maHang, String tenHang, int soLuongTon, double donGia) {
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.soLuongTon = soLuongTon;
		this.donGia = donGia;
	}

	public abstract void hienThiThongTin();

}
