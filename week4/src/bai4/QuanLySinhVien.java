package bai4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuanLySinhVien {
	private List<SinhVien> danhSachSinhVien;

	public QuanLySinhVien() {
		danhSachSinhVien = new ArrayList<>();
	}

	public void themSinhVien(SinhVien sv) {
		danhSachSinhVien.add(sv);
	}

	public void xoaSinhVien(String ma) {
		danhSachSinhVien.removeIf(sv -> sv.getMa().equals(ma));
	}

	public void suaThongTinSinhVien(String ma, String hoTenMoi, int namSinhMoi) {
		for (SinhVien sv : danhSachSinhVien) {
			if (sv.getMa().equals(ma)) {
				sv.setHoTen(hoTenMoi);
				sv.setNamSinh(namSinhMoi);
				break;
			}
		}
	}

	public SinhVien timKiemTheoMa(String ma) {
		for (SinhVien sv : danhSachSinhVien) {
			if (sv.getMa().equals(ma)) {
				return sv;

			}
		}
		return null;
	}

	public List<SinhVien> timKiemTheoTen(String hoTen) {
		List<SinhVien> ketqua = new ArrayList<>();
		for (SinhVien sv : danhSachSinhVien) {
			if (sv.getHoTen().equalsIgnoreCase(hoTen)) {
				ketqua.add(sv);
			}
		}
		return null;
	}

	public void sapXepTheoMaTangDan() {
		Collections.sort(danhSachSinhVien, Comparator.comparing(SinhVien::getMa));

	}

	public List<SinhVien> getDanhSachSinhVien() {
		return danhSachSinhVien;
	}
}
