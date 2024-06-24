package bai11;

import java.util.Scanner;

public class Test11 {
    private static final String[] MON_HOC = {
        "Nhap mon lap trinh", 
        "Ky thuat Lap trinh", 
        "OOP", 
        "Phat trien ung dung", 
        "Cong nghe moi"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DanhSachHocVien dshv = new DanhSachHocVien();

        System.out.print("Nhap so luong hoc vien: ");
        int soHocVien = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < soHocVien; i++) {
            System.out.println("Nhap thong tin hoc vien thu " + (i + 1) + ":");
            System.out.print("Ho ten: ");
            String hoTen = scanner.nextLine();
            System.out.print("Nam sinh: ");
            int namSinh = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            HocVien hv = new HocVien(hoTen, namSinh);
            
            for (int j = 0; j < 5; j++) {
                System.out.print("Vui long nhap diem cho mon " + MON_HOC[j] + ": ");
                double diem = scanner.nextDouble();
                hv.setDiemMonHoc(j, diem);
            }
            scanner.nextLine(); // Consume newline

            dshv.themHocVien(hv);
        }

        System.out.println("Thong tin hoc vien:");
        dshv.xuatThongTinHocVien();

        System.out.println("So hoc vien lam luan van: " + dshv.soHocVienLamLuanVan());
        System.out.println("So hoc vien thi tot nghiep: " + dshv.soHocVienThiTotNghiep());
        System.out.println("So hoc vien thi lai: " + dshv.soHocVienThiLai());
    }
}