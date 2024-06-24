package bai10;

public class Truck extends Vehicle {

	public Truck(String name, double value) {
		super(name, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateTax() {
		// TODO Auto-generated method stub
		return value * 0.10 + value * 0.02;
	}

}
