package bai6;

import java.time.LocalDate;

public class HoaDonTheoGio extends HoaDon {
	private int soGioThue;

	public HoaDonTheoGio(String maKH, String hoTen, LocalDate ngayRaHoaDon, double donGia, int soGioThue) {
		super(maKH, hoTen, ngayRaHoaDon, soGioThue, donGia);
		this.soGioThue = soGioThue;
	}

	@Override
	public double tinhThanhTien() {
		double thanhTien = soLuong * donGia;
		if (soGioThue > 30) {
			thanhTien *= 0.8;
		}
		return thanhTien;
	}

	@Override
	public String toString() {
		return super.toString() + String.format(" %-10d", soGioThue);
	}
}
