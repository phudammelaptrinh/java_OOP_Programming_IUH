package bai11;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> students = new ArrayList<>();

		// Tạo danh sách các sinh viên
		students.add(new IntermediateStudent("Nguyen Van A", 18, "IT001"));
		students.add(new CollegeStudent("Le Thi B", 20, "C002"));
		students.add(new UniversityStudent("Tran Van C", 22, "U003"));
		students.add(new InternationalStudent("John Doe", 21, "INT004", "Australia"));

		// In tiêu đề bảng
		System.out.format("%-25s%-10s%-10s%-15s\n", "Name", "Age", "ID", "Country");
		System.out.println("--------------------------------------------------------------");

		// Hiển thị thông tin sinh viên
		for (Student student : students) {
			student.displayInfo();
		}
	}

}
