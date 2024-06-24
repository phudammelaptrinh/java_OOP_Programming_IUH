package bai6;

import java.util.ArrayList;
import java.util.List;

public class DanhSachHoaDon {
	private List<HoaDon> danhSach;

	public DanhSachHoaDon() {
		this.danhSach = new ArrayList<>();
	}

	public boolean themHoaDon(HoaDon hd) {
		if (!danhSach.contains(hd)) {
			danhSach.add(hd);
			return true;
		}
		return false;
	}

	public void xuatHoaDonTheoGio() {
		for (HoaDon hd : danhSach) {
			if (hd instanceof HoaDonTheoGio) {
				System.out.println(hd);
			}
		}
	}

	public int thongKeSoLuongHDTheoNgay() {
		int count = 0;
		for (HoaDon hd : danhSach) {
			if (hd instanceof HoaDonTheoNgay) {
				count++;
			}
		}
		return count;
	}

	public double tinhTongThanhTien(int thang, int nam) {
		double tongTien = 0;
		for (HoaDon hd : danhSach) {
			if (hd.getNgayRaHoaDon().getMonthValue() == thang && hd.getNgayRaHoaDon().getYear() == nam) {
				tongTien += hd.tinhThanhTien();
			}
		}
		return tongTien;
	}
}
