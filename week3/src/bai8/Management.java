package bai8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Management {
	List<Person> danhSach = new ArrayList<>();

	public void themNguoi(Person p) {
		danhSach.add(p);
	}

	public void xoaNguoi(String hoTen) {
		danhSach.removeIf(p -> p.hoTen.equals(hoTen));
	}

	public Person timKiemNguoi(String hoTen) {
		for (Person p : danhSach) {
			if (p.hoTen.equals(hoTen)) {
				return p;
			}
		}
		return null;
	}

	public void hienThiDanhSach() {
		if (danhSach.isEmpty()) {
			System.out.println("Không có người nào trong danh sách");
		}
		if (danhSach.get(0) instanceof Student) {
			System.out.printf("| %-20s | %-20s | %-10s | %-10s | %-10s |\n", "Họ Tên", "Địa Chỉ", "Điểm 1", "Điểm 2",
					"Điểm TB");
		} else if (danhSach.get(0) instanceof Employee) {
			System.out.printf("| %-20s | %-20s | %-10s | %-10s |\n", "Họ Tên", "Địa Chỉ", "Hệ Số Lương", "Lương");
		} else if (danhSach.get(0) instanceof Customer) {
			System.out.printf("| %-20s | %-20s | %-15s |\n", "Họ Tên", "Địa Chỉ", "Loại KH");
		}
		for (Person p : danhSach) {
			System.out.println(p);
		}
	}

	public void sapXepTheoTen() {
		danhSach.sort(Comparator.comparing(p -> p.hoTen));
	}

}
