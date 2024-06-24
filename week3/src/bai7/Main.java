package bai7;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuanLyHangHoa ql = new QuanLyHangHoa();

		ThucPham tp = new ThucPham("TP01", "Gạo", 100, 20000, "VinMart", "01-01-2023", 12);
		HangSanhSu ss = new HangSanhSu("SS01", "Chén Bát", 50, 50000, "Vietnam", "Minh Long");
		HangDienMay dm = new HangDienMay("DM01", "Máy Lạnh", 30, 5000000, 2000, 220);

		ql.themHangHoa(tp);
		ql.themHangHoa(ss);
		ql.themHangHoa(dm);

		System.out.println("Danh sách hàng hóa:");
		ql.hienThiDanhSach();

		System.out.println("Tìm kiếm hàng hóa:");
		ql.timKiemHangHoa("Gạo");

		System.out.println("Sắp xếp hàng hóa theo tên:");
		ql.sapXepTheoTen();
		ql.hienThiDanhSach();

		System.out.println("Sắp xếp hàng hóa theo giá:");
		ql.sapXepTheoGia();
		ql.hienThiDanhSach();

		System.out.println("Cập nhật số lượng:");
		ql.capNhapSoLuong("TP01", 150);
		ql.hienThiDanhSach();

		System.out.println("Cập nhật giá:");
		ql.capNhapGia("DM01", 4500000);
		ql.hienThiDanhSach();
	}

}
