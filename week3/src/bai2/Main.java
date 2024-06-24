package bai2;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Sach> dsSach = new ArrayList<>();
		// tạo ds các sách
		dsSach.add(new SachGiaoKhoa("GK01", new Date(), 20000, 10, "NXB A", "mới"));
		dsSach.add(new SachGiaoKhoa("GK02", new Date(), 15000, 5, "NXB B", "cũ"));
		dsSach.add(new SachGiaoKhoa("GK03", new Date(), 18000, 8, "NXB A", "mới"));

		dsSach.add(new SachThamKhao("TK01", new Date(), 30000, 7, "NXB C", 5000));
		dsSach.add(new SachThamKhao("TK02", new Date(), 25000, 6, "NXB D", 3000));
		dsSach.add(new SachThamKhao("TK03", new Date(), 28000, 4, "NXB C", 7000));
		// Tính tổng thành tiền cho từng loại sách
		double s1 = 0;
		double s2 = 0;
		double s3 = 0;
		int soLuongSachThamKhao = 0;
		for (Sach s : dsSach) {
			if (s instanceof SachGiaoKhoa) {
				s1 += s.tinhThanhTien();
			} else if (s instanceof SachThamKhao) {
				s2 += s.tinhThanhTien();
				s3 += s.getDonGia();
				soLuongSachThamKhao++;
			}
		}
		System.out.println("Tổng thành tiền sách giáo khoa: " + s1);
		System.out.println("Tổng thành tiền sách tham khảo: " + s2);
		// Tính trung bình cộng đơn giá của các sách tham khảo :
		double tb = s1 / soLuongSachThamKhao;
		System.out.println("Trung bình cộng đơn giá của các sách tham khảo: " + tb);
		// Xuất ra màn hình
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập tên nhà xuất bản K : ");
		String nxb = sc.nextLine();
		System.out.print("Các sách giáo khoa của nhà xuất bản" + nxb + ":");
		for (Sach s : dsSach) {
			if (s instanceof SachGiaoKhoa && s.getNhaXuatBan().equalsIgnoreCase(nxb)) {
				System.out.println(s);
			}
		}
		sc.close();
	}

}
