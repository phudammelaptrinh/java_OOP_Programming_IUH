package bai6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuanLyPhongHoc {
	private List<PhongHoc> danhSachPhongHoc;

	public QuanLyPhongHoc() {
		this.danhSachPhongHoc = new ArrayList<>();
	}

	public void themPhongHoc(PhongHoc phongHoc) {
		for (PhongHoc ph : danhSachPhongHoc) {
			if (ph.getMaPhong().equals(phongHoc.getMaPhong())) {
				System.out.println("Mã phòng đã tồn tại, không thể thêm!");
				return;
			}
		}
		danhSachPhongHoc.add(phongHoc);
		System.out.println("Thêm phòng học thành công!");
	}

	public PhongHoc timKiemPhongHoc(String maPhong) {
		for (PhongHoc ph : danhSachPhongHoc) {
			if (ph.getMaPhong().equals(maPhong)) {
				return ph;
			}
		}
		return null;
	}

	public void inToanBoDanhSach() {
		for (PhongHoc ph : danhSachPhongHoc) {
			System.out.println(ph);
		}
	}

	public List<PhongHoc> inDanhSachPhongHocDatChuan() {
		List<PhongHoc> phongHocDatChuan = new ArrayList<>();
		for (PhongHoc ph : danhSachPhongHoc) {
			if (ph.kiemTraDatChuan()) {
				phongHocDatChuan.add(ph);
			}
		}
		return phongHocDatChuan;
	}

	public void sapXepTheoDayNha() {
		Collections.sort(danhSachPhongHoc, Comparator.comparing(PhongHoc::getDayNha));
	}

	public void sapXepTheoDienTichGiamDan() {
		Collections.sort(danhSachPhongHoc, Comparator.comparing(PhongHoc::getDienTich).reversed());
	}

	public void sapXepTheoSoBongDenTangDan() {
		Collections.sort(danhSachPhongHoc, Comparator.comparing(PhongHoc::getSoBongDen));
	}

	public void capNhatSoMayTinh(String maPhong, int soMayTinhMoi) {
		for (PhongHoc ph : danhSachPhongHoc) {
			if (ph instanceof PhongMayTinh && ph.getMaPhong().equals(maPhong)) {
				((PhongMayTinh) ph).setSoLuongMayTinh(soMayTinhMoi);
				System.out.println("Cập nhật số lượng máy tính thành công!");
				return;
			}
		}
		System.out.println("Không tìm thấy phòng máy tính với mã phòng này!");
	}

	public void xoaPhongHoc(String maPhong) {
		PhongHoc phongHoc = timKiemPhongHoc(maPhong);
		if (phongHoc != null) {
			danhSachPhongHoc.remove(phongHoc);
			System.out.println("Xóa phòng học thành công!");
		} else {
			System.out.println("Không tìm thấy phòng học với mã phòng này!");
		}
	}

	public int tinhTongSoPhongHoc() {
		return danhSachPhongHoc.size();
	}

	public void inDanhSachPhongMay60May() {
		for (PhongHoc ph : danhSachPhongHoc) {
			if (ph instanceof PhongMayTinh && ((PhongMayTinh) ph).getSoLuongMayTinh() >= 60) {
				System.out.println(ph);
			}
		}
	}

	public List<PhongHoc> getDanhSachPhongHoc() {
		return danhSachPhongHoc;
	}
}
