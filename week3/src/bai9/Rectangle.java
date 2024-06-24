package bai9;

public class Rectangle extends Shape {

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.printf("| %-15s | %-30s |\n", "Hình Chữ Nhật", "Vẽ hình chữ nhật");
	}

	@Override
	public void erase() {
		// TODO Auto-generated method stub
		System.out.println("Xóa hình chữ nhật");
	}

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("Di chuyển hình chữ nhật tới (" + x + ", " + y + ")");
	}

}
