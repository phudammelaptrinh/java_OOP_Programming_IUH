package bai2;

import java.util.Date;

public class SachThamKhao extends Sach {
	private double thue;

	public SachThamKhao(String maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan, double thue) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
		this.thue = thue;
	}

	@Override
	public double tinhThanhTien() {
		return soLuong * donGia + thue;
	}

	@Override
	public String toString() {
		return super.toString() + ", Thuế: " + thue;
	}
}
