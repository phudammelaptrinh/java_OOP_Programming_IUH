package bai9;

public class Quad extends Shape {

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.printf("| %-15s | %-30s |\n", "Hình Tứ Giác", "Vẽ hình tứ giác");
	}

	@Override
	public void erase() {
		// TODO Auto-generated method stub
		System.out.println("Xóa hình tứ giác");
	}

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("Di chuyển hình tứ giác tới (" + x + ", " + y + ")");
	}

}
