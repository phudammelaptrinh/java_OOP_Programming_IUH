package bai6;

import java.time.LocalDate;

public class HoaDonTheoNgay extends HoaDon {
	private int soNgayThue;

	public HoaDonTheoNgay(String maKH, String hoTen, LocalDate ngayRaHoaDon, double donGia, int soNgayThue) {
		super(maKH, hoTen, ngayRaHoaDon, soNgayThue, donGia);
		this.soNgayThue = soNgayThue;
	}

	@Override
	public double tinhThanhTien() {
		double thanhTien = soLuong * donGia;
		if (soNgayThue > 7) {
			thanhTien *= 0.9;
		}
		return thanhTien;
	}

	@Override
	public String toString() {
		return super.toString() + String.format(" %-10d", soNgayThue);
	}
}
