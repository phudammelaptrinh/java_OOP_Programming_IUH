package bai5;

import java.time.LocalDate;

public class KhachHangVietNam extends HoaDon {
	private String doiTuongKH;
	private double dinhMuc;

	public KhachHangVietNam(String maKH, String hoTen, LocalDate ngayRaHoaDon, double soLuong, double donGia,
			String doiTuongKH, double dinhMuc) {
		super(maKH, hoTen, ngayRaHoaDon, soLuong, donGia);
		this.doiTuongKH = doiTuongKH;
		this.dinhMuc = dinhMuc;
	}

	@Override
	public double tinhThanhTien() {
		if (soLuong <= dinhMuc) {
			return soLuong * donGia;
		} else {
			return (dinhMuc * donGia) + ((soLuong - dinhMuc) * donGia * 2.5);
		}
	}

	@Override
	public String toString() {
		return super.toString() + String.format(" %-10s %-10.2f", doiTuongKH, dinhMuc);
	}
}
