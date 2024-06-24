package bai10;

public class Car extends Vehicle {
	private int numberOfSeats;

	public Car(String name, double value, int numberOfSeats) {
		super(name, value);
		// TODO Auto-generated constructor stub
		this.numberOfSeats = numberOfSeats;
	}

	@Override
	public double calculateTax() {
		// TODO Auto-generated method stub
		double specialTaxRate = numberOfSeats < 5 ? 0.30 : 0.50;
		return value * specialTaxRate + value * 0.10 + value * 0.20;
	}

}
