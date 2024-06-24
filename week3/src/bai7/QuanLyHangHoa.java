package bai7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QuanLyHangHoa {
	List<HangHoa> danhSachHangHoa = new ArrayList<>();

	public void themHangHoa(HangHoa hangHoa) {
		danhSachHangHoa.add(hangHoa);
	}

	public void hienThiDanhSach() {
		if (danhSachHangHoa.isEmpty()) {
			System.out.println("Không có hàng hóa nào trong danh sách !");
			return;

		}
		if (danhSachHangHoa.get(0) instanceof ThucPham) {
			System.out.printf("| %-10s | %-20s | %-10s | %-10s | %-15s | %-12s | %-10s |\n", "Mã Hàng", "Tên Hàng",
					"Số Lượng", "Đơn Giá", "Nhà Cung Cấp", "Ngày SX", "Hạn BQ");
		} else if (danhSachHangHoa.get(0) instanceof HangSanhSu) {
			System.out.printf("| %-10s | %-20s | %-10s | %-10s | %-15s | %-15s |\n", "Mã Hàng", "Tên Hàng", "Số Lượng",
					"Đơn Giá", "Xuất Xứ", "Nhà Sản Xuất");
		} else if (danhSachHangHoa.get(0) instanceof HangDienMay) {
			System.out.printf("| %-10s | %-20s | %-10s | %-10s | %-10s | %-10s |\n", "Mã Hàng", "Tên Hàng", "Số Lượng",
					"Đơn Giá", "Công Suất", "Điện Áp");
		}
		for (HangHoa hangHoa : danhSachHangHoa) {
			hangHoa.hienThiThongTin();
		}
	}

	public void timKiemHangHoa(String tenHang) {
		for (HangHoa hangHoa : danhSachHangHoa) {
			if (hangHoa.tenHang.contains(tenHang)) {
				hangHoa.hienThiThongTin();
			}
		}
	}

	public void sapXepTheoTen() {
		danhSachHangHoa.sort(Comparator.comparing(h -> h.tenHang));
	}

	public void sapXepTheoGia() {
		danhSachHangHoa.sort(Comparator.comparingDouble(h -> h.donGia));
	}

	public void capNhapSoLuong(String maHang, int soLuongMoi) {
		for (HangHoa hangHoa : danhSachHangHoa) {
			if (hangHoa.maHang.equals(maHang)) {
				hangHoa.soLuongTon = soLuongMoi;
			}
		}
	}

	public void capNhapGia(String maHang, double giaMoi) {
		for (HangHoa hangHoa : danhSachHangHoa) {
			if (hangHoa.maHang.equals(maHang)) {
				hangHoa.donGia = giaMoi;
			}
		}
	}

}
