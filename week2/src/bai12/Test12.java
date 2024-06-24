package bai12;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Test12 {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        QuanLyKhoaHoc quanLyKhoaHoc = new QuanLyKhoaHoc();

        // Thêm các khóa học mẫu
        quanLyKhoaHoc.themKhoaHoc(new KhoaHoc("Java Basics", DATE_FORMAT.parse("01/01/2024"), "Morning"));
        quanLyKhoaHoc.themKhoaHoc(new KhoaHoc("Advanced Java", DATE_FORMAT.parse("15/01/2024"), "Evening"));
        quanLyKhoaHoc.themKhoaHoc(new KhoaHoc("Spring Framework", DATE_FORMAT.parse("01/02/2024"), "Afternoon"));

        // Thêm học viên vào khóa học
        KhoaHoc javaBasics = quanLyKhoaHoc.timKhoaHoc("Java Basics");
        if (javaBasics != null) {
            javaBasics.themHocVien(new HocVien("Nguyen Van A", "123 Street", "0123456789"));
            javaBasics.themHocVien(new HocVien("Le Thi B", "456 Street", "0987654321"));
        }

        KhoaHoc advancedJava = quanLyKhoaHoc.timKhoaHoc("Advanced Java");
        if (advancedJava != null) {
            advancedJava.themHocVien(new HocVien("Tran Van C", "789 Street", "0987654321"));
        }

        // Hiển thị tất cả các khóa học
        System.out.println(quanLyKhoaHoc);

        // Tìm kiếm khóa học
        System.out.print("Nhập tên khóa học để tìm kiếm: ");
        String tenKhoaHoc = scanner.nextLine();
        KhoaHoc foundKhoaHoc = quanLyKhoaHoc.timKhoaHoc(tenKhoaHoc);
        if (foundKhoaHoc != null) {
            System.out.println("Khóa học tìm thấy: ");
            System.out.println(foundKhoaHoc);
        } else {
            System.out.println("Không tìm thấy khóa học.");
        }

        // Tìm các khóa học của một học viên
        System.out.print("Nhập tên học viên để tìm các khóa học: ");
        String hoTenHocVien = scanner.nextLine();
        List<KhoaHoc> khoaHocList = quanLyKhoaHoc.khoaHocCuaHocVien(hoTenHocVien);
        if (!khoaHocList.isEmpty()) {
            System.out.println("Các khóa học của " + hoTenHocVien + ":");
            for (KhoaHoc kh : khoaHocList) {
                System.out.println(kh);
            }
        } else {
            System.out.println("Không tìm thấy khóa học cho " + hoTenHocVien);
        }

        // Thêm học viên mới với kiểm tra đầu vào
        System.out.print("Nhập số lượng học viên cần thêm: ");
        int soHocVien = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < soHocVien; i++) {
            System.out.println("Nhập thông tin cho học viên thứ " + (i + 1) + ":");

            // Nhập và kiểm tra họ tên
            String hoTen;
            while (true) {
                System.out.print("Họ tên: ");
                hoTen = scanner.nextLine();
                if (validateName(hoTen)) {
                    break;
                } else {
                    System.out.println("Tên không hợp lệ. Vui lòng nhập lại.");
                }
            }

            // Nhập địa chỉ
            System.out.print("Địa chỉ: ");
            String diaChi = scanner.nextLine();

            // Nhập và kiểm tra số điện thoại
            String sdt;
            while (true) {
                System.out.print("Số điện thoại: ");
                sdt = scanner.nextLine();
                if (validatePhoneNumber(sdt)) {
                    break;
                } else {
                    System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập lại.");
                }
            }

            // Thêm học viên vào khóa học
            HocVien hocVien = new HocVien(hoTen, diaChi, sdt);
            System.out.print("Nhập tên khóa học để thêm học viên: ");
            String courseName = scanner.nextLine();
            KhoaHoc course = quanLyKhoaHoc.timKhoaHoc(courseName);
            if (course != null) {
                if (course.themHocVien(hocVien)) {
                    System.out.println("Thêm học viên thành công.");
                } else {
                    System.out.println("Thêm học viên thất bại. Khóa học có thể đã đầy.");
                }
            } else {
                System.out.println("Không tìm thấy khóa học.");
            }
        }

        // Hiển thị danh sách khóa học cập nhật
        System.out.println("Danh sách khóa học cập nhật:");
        System.out.println(quanLyKhoaHoc);
    }

    // Phương thức kiểm tra tên hợp lệ
    public static boolean validateName(String name) {
        return name != null && name.matches("^[a-zA-Z\\s]+$");
    }

    // Phương thức kiểm tra số điện thoại hợp lệ
    public static boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("^\\d{10,11}$");
    }
}