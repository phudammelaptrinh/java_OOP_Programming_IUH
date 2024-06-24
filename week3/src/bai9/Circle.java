package bai9;

public class Circle extends Shape {

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.printf("| %-15s | %-30s |\n", "Hình Tròn", "Vẽ hình tròn");
	}

	@Override
	public void erase() {
		// TODO Auto-generated method stub
		System.out.println("Xóa hình tròn");
	}

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("Di chuyển hình tròn tới (" + x + ", " + y + ")");
	}

}
