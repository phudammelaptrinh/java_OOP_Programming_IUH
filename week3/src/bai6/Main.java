package bai6;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DanhSachHoaDon dsHoaDon = new DanhSachHoaDon();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		// Thêm hóa đơn theo giờ
		dsHoaDon.themHoaDon(
				new HoaDonTheoGio("HD001", "Nguyen Van A", LocalDate.parse("10/09/2018", dateFormatter), 20000, 20));
		dsHoaDon.themHoaDon(
				new HoaDonTheoGio("HD002", "Tran Thi B", LocalDate.parse("15/09/2018", dateFormatter), 30000, 40));
		dsHoaDon.themHoaDon(
				new HoaDonTheoGio("HD003", "Le Van C", LocalDate.parse("20/09/2018", dateFormatter), 25000, 35));

		// Thêm hóa đơn theo ngày
		dsHoaDon.themHoaDon(
				new HoaDonTheoNgay("HD004", "Hoang Thi D", LocalDate.parse("05/09/2018", dateFormatter), 500000, 5));
		dsHoaDon.themHoaDon(
				new HoaDonTheoNgay("HD005", "Pham Van E", LocalDate.parse("10/09/2018", dateFormatter), 400000, 10));
		dsHoaDon.themHoaDon(
				new HoaDonTheoNgay("HD006", "Vu Thi F", LocalDate.parse("15/09/2018", dateFormatter), 450000, 7));

		// In danh sách hóa đơn theo giờ
		System.out.println("Danh sách hóa đơn theo giờ:");
		dsHoaDon.xuatHoaDonTheoGio();

		// Thống kê số lượng hóa đơn theo ngày
		System.out.println("Số lượng hóa đơn theo ngày: " + dsHoaDon.thongKeSoLuongHDTheoNgay());

		// Tính tổng thành tiền của các hóa đơn trong tháng 09 năm 2018
		System.out.println(
				"Tổng thành tiền của các hóa đơn trong tháng 09 năm 2018: " + dsHoaDon.tinhTongThanhTien(9, 2018));
	}
}
