package bai4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		ArrayList<GiaoDich> danhSachGiaoDich = new ArrayList<>();

		// Thêm nhiều giao dịch để kiểm tra
		danhSachGiaoDich.add(new GiaoDichDat("GD001", LocalDate.parse("15/09/2013", dateFormat), 1000, "A", 100));
		danhSachGiaoDich.add(new GiaoDichDat("GD002", LocalDate.parse("20/09/2013", dateFormat), 500, "B", 200));
		danhSachGiaoDich.add(new GiaoDichDat("GD003", LocalDate.parse("25/09/2013", dateFormat), 700, "C", 150));
		danhSachGiaoDich.add(new GiaoDichDat("GD004", LocalDate.parse("01/08/2013", dateFormat), 800, "A", 120));
		danhSachGiaoDich.add(new GiaoDichDat("GD005", LocalDate.parse("10/07/2013", dateFormat), 600, "B", 100));
		danhSachGiaoDich.add(new GiaoDichDat("GD006", LocalDate.parse("15/06/2013", dateFormat), 750, "C", 130));

		danhSachGiaoDich.add(new GiaoDichNha("GN001", LocalDate.parse("15/09/2013", dateFormat), 2000, 100, "cao cấp",
				"123 Đường A"));
		danhSachGiaoDich.add(new GiaoDichNha("GN002", LocalDate.parse("20/09/2013", dateFormat), 1000, 150, "thường",
				"456 Đường B"));
		danhSachGiaoDich.add(new GiaoDichNha("GN003", LocalDate.parse("25/09/2013", dateFormat), 3000, 200, "cao cấp",
				"789 Đường C"));
		danhSachGiaoDich.add(new GiaoDichNha("GN004", LocalDate.parse("05/08/2013", dateFormat), 1500, 180, "thường",
				"321 Đường D"));
		danhSachGiaoDich.add(new GiaoDichNha("GN005", LocalDate.parse("12/07/2013", dateFormat), 2500, 220, "cao cấp",
				"654 Đường E"));
		danhSachGiaoDich.add(new GiaoDichNha("GN006", LocalDate.parse("18/06/2013", dateFormat), 1400, 160, "thường",
				"987 Đường F"));

		int soLuongDat = 0;
		int soLuongNha = 0;
		double tongThanhTienDat = 0;

		for (GiaoDich gd : danhSachGiaoDich) {
			if (gd instanceof GiaoDichDat) {
				soLuongDat++;
				tongThanhTienDat += gd.tinhThanhTien();
			} else if (gd instanceof GiaoDichNha) {
				soLuongNha++;
			}
		}

		double trungBinhThanhTienDat = soLuongDat > 0 ? tongThanhTienDat / soLuongDat : 0;

		System.out.println("Tổng số lượng giao dịch đất: " + soLuongDat);
		System.out.println("Tổng số lượng giao dịch nhà: " + soLuongNha);
		System.out.println("Trung bình thành tiền của giao dịch đất: " + trungBinhThanhTienDat);
		System.out.println("\nCác giao dịch của tháng 9 năm 2013:");

		// In tiêu đề bảng
		System.out.println(String.format("%-10s %-12s %-10s %-10s %-15s %-7s %-10s %-20s", "Mã GD", "Ngày GD",
				"Đơn giá", "Diện tích", "Thành tiền", "Loại", "Loại nhà", "Địa chỉ"));

		// In các giao dịch của tháng 9 năm 2013
		for (GiaoDich gd : danhSachGiaoDich) {
			if (gd.getNgayGD().getMonthValue() == 9 && gd.getNgayGD().getYear() == 2013) {
				System.out.println(gd);
			}
		}
	}
}
