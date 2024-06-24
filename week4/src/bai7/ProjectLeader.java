package bai7;

public class ProjectLeader extends Programmer {
	public ProjectLeader(int thePayrollNumber, String theName, double theBasicMonthlySalary, String theLanguage) {
		super(thePayrollNumber, theName, theBasicMonthlySalary, theLanguage);
	}

	@Override
	public double getMonthlySalary() {
		return getBasicMonthlySalary() * 1.6;
	}

	@Override
	public String toString() {
		return super.toString() + " ProjectLeader{}";
	}
}
