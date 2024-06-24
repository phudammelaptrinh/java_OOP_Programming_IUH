package bai1;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ChuyenXe> ds = new ArrayList<>();
		// Tạo danh sách các chuyến xe
		ds.add(new ChuyenXeNoiThanh("NT01", "Nguyen Van A", "79A-12345", 1, 50, 1000000));
		ds.add(new ChuyenXeNoiThanh("NT02", "Le Thi B", "79A-54321", 2, 30, 800000));
		ds.add(new ChuyenXeNgoaiThanh("NG01", "Tran Van C", "79B-12345", "Da Nang", 3, 3000000));
		ds.add(new ChuyenXeNgoaiThanh("NG02", "Pham Thi D", "79B-54321", "Hue", 2, 2500000));
		// Tính tổng doanh thu cho tất cả các chuyến xe
		double sum = 0;
		for (ChuyenXe cx : ds) {
			sum += cx.getDoanhThu();
		}
		System.out.println("Tổng doanh thu cho tất cả các chuyến xe : " + sum);

		// tính tổng doanh thu cho từng loại chuyến xe
		double s1 = 0;
		double s2 = 0;
		for (ChuyenXe cx : ds) {
			if (cx instanceof ChuyenXeNoiThanh) {
				s1 += cx.getDoanhThu();
			} else if (cx instanceof ChuyenXeNgoaiThanh) {
				s2 += cx.getDoanhThu();
			}
		}
		System.out.println("Tổng doanh thu cho các chuyến xe nội thành : " + s1);
		System.out.println("Tổng doanh thu cho các chuyến xe ngoại thành : " + s2);

	}

}
