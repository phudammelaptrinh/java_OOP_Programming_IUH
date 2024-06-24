package bai10;

public abstract class Vehicle {
	protected String name;
	protected double value;

	public Vehicle(String name, double value) {

		this.name = name;
		this.value = value;
	}

	public abstract double calculateTax();

	public String getName() {
		return name;
	}

	public double getValue() {
		return value;
	}

}
