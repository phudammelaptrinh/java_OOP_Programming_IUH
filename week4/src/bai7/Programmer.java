package bai7;

public class Programmer extends Employee {
	private String theLanguage;

	public Programmer(int thePayrollNumber, String theName, double theBasicMonthlySalary, String theLanguage) {
		super(thePayrollNumber, theName, theBasicMonthlySalary);
		this.theLanguage = theLanguage;
	}

	@Override
	public double getMonthlySalary() {
		return getBasicMonthlySalary() * 1.2;
	}

	@Override
	public String toString() {
		return super.toString() + " Programmer{" + "Language='" + theLanguage + '\'' + '}';
	}
}
