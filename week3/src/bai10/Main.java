package bai10;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle bicycle = new Bicycle("Bicycle", 100);
		Vehicle motorcycle = new Motorcycle("Motorcycle", 1000);
		Vehicle carSmall = new Car("Small Car", 20000, 4);
		Vehicle carLarge = new Car("Large Car", 30000, 6);
		Vehicle truck = new Truck("Truck", 50000);
		// In tiêu đề bảng
		System.out.format("%-15s%-15s%-15s%-15s\n", "Vehicle", "Value", "Seats", "Tax");
		System.out.println("-------------------------------------------------------------");

		// In thông tin từng loại xe
		printVehicleInfo(bicycle, "-");
		printVehicleInfo(motorcycle, "-");
		printVehicleInfo(carSmall, "4");
		printVehicleInfo(carLarge, "6");
		printVehicleInfo(truck, "-");
	}

	// Hàm in thông tin xe
	public static void printVehicleInfo(Vehicle vehicle, String seats) {
		System.out.format("%-15s%-15.2f%-15s%-15.2f\n", vehicle.getName(), vehicle.getValue(), seats,
				vehicle.calculateTax());
	}
}
