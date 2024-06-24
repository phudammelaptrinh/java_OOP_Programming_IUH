package bai9;

public class Drawing {

	public void drawShape(Shape shape) {
		shape.draw();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Drawing drawing = new Drawing();

		Shape circle = new Circle();
		Shape quad = new Quad();
		Shape rectangle = new Rectangle();
		Shape triangle = new Triangle();
		Shape polygon = new Polygon();

		System.out.printf("| %-15s | %-30s |\n", "Loại Hình", "Hoạt Động");
		System.out.println("---------------------------------------------------");

		drawing.drawShape(circle);
		drawing.drawShape(quad);
		drawing.drawShape(rectangle);
		drawing.drawShape(triangle);
		drawing.drawShape(polygon);
	}

}
