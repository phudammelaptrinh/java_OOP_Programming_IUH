package bai5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		ArrayList<HoaDon> danhSachHoaDon = new ArrayList<>();

		danhSachHoaDon.add(new KhachHangVietNam("KH001", "Nguyen Van A", LocalDate.parse("15/09/2018", dateFormat), 100,
				2000, "sinh hoạt", 50));
		danhSachHoaDon.add(new KhachHangVietNam("KH002", "Tran Thi B", LocalDate.parse("20/09/2018", dateFormat), 150,
				1800, "kinh doanh", 100));
		danhSachHoaDon.add(new KhachHangVietNam("KH003", "Le Van C", LocalDate.parse("25/09/2018", dateFormat), 200,
				2200, "sản xuất", 150));

		// Thêm khách hàng nước ngoài
		danhSachHoaDon.add(new KhachHangNuocNgoai("KH004", "John Doe", LocalDate.parse("15/09/2018", dateFormat), 100,
				2500, "USA"));
		danhSachHoaDon.add(new KhachHangNuocNgoai("KH005", "Jane Smith", LocalDate.parse("20/09/2018", dateFormat), 150,
				2400, "UK"));
		danhSachHoaDon.add(new KhachHangNuocNgoai("KH006", "Alice Johnson", LocalDate.parse("25/09/2018", dateFormat),
				200, 2300, "Canada"));

		int nVN = 0;
		int nNN = 0;
		double sum = 0;

		for (HoaDon hd : danhSachHoaDon) {
			if (hd instanceof KhachHangVietNam) {
				nVN++;
			} else if (hd instanceof KhachHangNuocNgoai) {
				nNN++;
				sum += hd.tinhThanhTien();
			}
		}

		double trungBinhThanhTienKhachHangNuocNgoai = nNN > 0 ? sum / nNN : 0;

		System.out.println("Tổng số lượng khách hàng Việt Nam: " + nVN);
		System.out.println("Tổng số lượng khách hàng nước ngoài: " + nNN);
		System.out.println("Trung bình thành tiền của khách hàng nước ngoài: " + trungBinhThanhTienKhachHangNuocNgoai);
		System.out.println("\nCác hóa đơn của tháng 09 năm 2018:");

		// In tiêu đề bảng
		System.out.println(String.format("%-10s %-20s %-12s %-10s %-10s %-15s %-10s %-10s", "Mã KH", "Họ Tên",
				"Ngày HĐ", "Số lượng", "Đơn giá", "Thành tiền", "Đối tượng", "Định mức/Quốc tịch"));

		// In các hóa đơn của tháng 09 năm 2018
		for (HoaDon hd : danhSachHoaDon) {
			if (hd.getNgayRaHoaDon().getMonthValue() == 9 && hd.getNgayRaHoaDon().getYear() == 2018) {
				System.out.println(hd);
			}
		}
	}
}
