package bai3;

import java.util.ArrayList;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<GiaoDich> ds = new ArrayList<>();
		// Tạo ds các giao dịch
		ds.add(new GiaoDichVang("GDV01", 1500000, 10, "Vàng 9999"));
		ds.add(new GiaoDichVang("GDV02", 1000000, 5, "Vàng SJC"));
		ds.add(new GiaoDichVang("GDV03", 2000000, 5, "Vàng 24k"));
		ds.add(new GiaoDichTienTe("GDT01", new Date(), 230000000, 1000, 1.2, "USD"));
		ds.add(new GiaoDichTienTe("GDT02", new Date(), 400000000, 800, 1.1, "Euro"));
		ds.add(new GiaoDichTienTe("GDT01", new Date(), 700000000, 900, 1.5, "VND"));

		// Tính tổng số lượng cho từng loại giao dịch
		int s1 = 0;
		int s2 = 0;
		double tt = 0;

		for (GiaoDich gd : ds) {
			if (gd instanceof GiaoDichVang) {
				s1 += gd.getSoLuong();
			} else if (gd instanceof GiaoDichTienTe) {
				s2 += gd.getSoLuong();
				tt += gd.tinhThanhTien();
			}
		}
		System.out.println("Tổng số lượng giao dịch vàng :" + s1);
		System.out.println("Tổng số lượng giao dịch tiền tệ  :" + s2);
		// Tính trung bình thành tiền của giao dịch tiền
		double tb = tt / s2;
		System.out.println("Trung bình thành tiền của giao dịch tiền tệ: " + tb);
		// Xuất ra màn hình
		System.out.println("Các giao dịch có đơn giá > 1 tỷ : ");
		for (GiaoDich gd : ds) {
			if (gd.getDonGia() > 1000000000) {
				System.out.println(gd);
			}
		}
	}

}
