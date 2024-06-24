package bai4;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle xe1 = new Vehicle("Ho Truong Minh","Honda",3000.0,90);
		Vehicle xe2 = new Vehicle("Ho Truong Minh Phu","Huynda",3500.0,120);
		Vehicle xe3 = new Vehicle();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap thong tin cho xe3: ");
		System.out.print("Chu Xe: ");
		String chuXe = sc.nextLine();
		System.out.print("Loai Xe: ");
		String loaiXe = sc.nextLine();
		System.out.print("Tri Gia: ");
		double triGia = sc.nextDouble();
		System.out.print("Dung Tich Xy Lanh : ");
		int dungTichXyLanh = sc.nextInt();
		 // Setting information for xe3 using setters
        xe3.setChuXe(chuXe);
        xe3.setLoaiXe(loaiXe);
        xe3.setTriGia(triGia);
        xe3.setDungTichXyLanh(dungTichXyLanh);

        // Printing the list of vehicles and their tax
        System.out.println("Danh sach xe va thue truoc ba:");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", "Chu xe", "Loai xe", "Tri gia", "Dung tich xy lanh", "Thue truoc ba");
        System.out.println(xe1);
        System.out.println(xe2);
        System.out.println(xe3);
	}

}
