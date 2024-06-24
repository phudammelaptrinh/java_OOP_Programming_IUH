package bai9;

public class Triangle extends Shape {

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.printf("| %-15s | %-30s |\n", "Hình Tam Giác", "Vẽ hình tam giác");
	}

	@Override
	public void erase() {
		// TODO Auto-generated method stub
		System.out.println("Xóa hình tam giác");
	}

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("Di chuyển hình tam giác tới (" + x + ", " + y + ")");
	}

}
