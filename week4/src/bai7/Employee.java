package bai7;

public abstract class Employee {
	private final int thePayrollNumber;
	private String theName;
	private double theBasicMonthlySalary;

	public Employee(int thePayrollNumber, String theName, double theBasicMonthlySalary) {
		this.thePayrollNumber = thePayrollNumber;
		this.theName = theName;
		this.theBasicMonthlySalary = theBasicMonthlySalary;
	}

	public String getName() {
		return theName;
	}

	public double getBasicMonthlySalary() {
		return theBasicMonthlySalary;
	}

	public abstract double getMonthlySalary();

	@Override
	public String toString() {
		return "Employee{" + "PayrollNumber=" + thePayrollNumber + ", Name='" + theName + '\'' + ", BasicMonthlySalary="
				+ theBasicMonthlySalary + '}';
	}
}
