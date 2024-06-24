package bai8;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Management ql = new Management();

		Student sv = new Student("Nguyen Van A", "Ha Noi", 8, 9);
		Employee nv = new Employee("Tran Thi B", "Hai Phong", 3.5);
		Customer kh = new Customer("Le Van C", "Da Nang", "VIP");

		ql.themNguoi(sv);
		ql.themNguoi(nv);
		ql.themNguoi(kh);

		System.out.println("Danh sách:");
		ql.hienThiDanhSach();

		System.out.println("Sắp xếp theo tên:");
		ql.sapXepTheoTen();
		ql.hienThiDanhSach();

		System.out.println("Tìm kiếm theo tên:");
		System.out.println(ql.timKiemNguoi("Nguyen Van A"));

		System.out.println("Xóa người:");
		ql.xoaNguoi("Tran Thi B");
		ql.hienThiDanhSach();
	}

}
