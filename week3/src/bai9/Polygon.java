package bai9;

public class Polygon extends Shape {

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.printf("| %-15s | %-30s |\n", "Hình Đa Giác", "Vẽ hình đa giác");
	}

	@Override
	public void erase() {
		// TODO Auto-generated method stub
		System.out.println("Xóa hình đa giác");
	}

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("Di chuyển hình đa giác tới (" + x + ", " + y + ")");
	}

}
