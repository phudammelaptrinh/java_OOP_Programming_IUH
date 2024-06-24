package bai2;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinhVien sv1 = new SinhVien(123,"Ho Truong Minh Phu", 7.5f, 9.0f);
		SinhVien sv2 = new SinhVien(124,"Nguyen Van A", 10.0f,10.0f);
		SinhVien sv3 = new SinhVien();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhap thong tin cho sinh vien 3");
		System.out.println("Ma So Sinh Vien : ");
		int msv = sc.nextInt();
		sc.nextLine();
		System.out.print("Nhap Ho Ten : ");
		String hoTen = sc.nextLine();
		System.out.print("Diem LT: ");
		float diemLT = sc.nextFloat();
		System.out.print("Diem TH: ");
		float diemTH = sc.nextFloat();
		
		//
		sv3.setMsv(msv);
		sv3.setHoTen(hoTen);
		sv3.setDiemLT(diemLT);
		sv3.setDiemTH(diemTH);
		//
		 System.out.println("Danh sach sinh vien:");
	     System.out.printf("%-10s %-20s %-10s %-10s %-10s\n", "MSSV", "Ho ten", "Diem LT", "Diem TH", "Diem TB");
	     System.out.println(sv1);
	     System.out.println(sv2);
	     System.out.println(sv3);
	     
	}
}
