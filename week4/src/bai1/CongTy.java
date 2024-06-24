package bai1;

import java.util.HashSet;
import java.util.Set;

public abstract class CongTy {
	protected Set<String> danhSachNhanVien;

	public CongTy() {
		danhSachNhanVien = new HashSet<>();
	}

	public void themNhanVien(String ten) {
		danhSachNhanVien.add(ten);
	}

	public void xoaNhanVien(String ten) {
		danhSachNhanVien.add(ten);
	}

	public void hienThiBang() {

	}

}
