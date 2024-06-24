package bai8;

public class Student extends Person {
	private int yearMatriculated;
	private String studentID;

	public Student(String lastName, String firstName, int yearMatriculated, String studentID) {
		super(lastName, firstName);
		this.yearMatriculated = yearMatriculated;
		this.studentID = studentID;
	}

	public int getYearMatriculated() {
		return yearMatriculated;
	}

	public void setYearMatriculated(int yearMatriculated) {
		this.yearMatriculated = yearMatriculated;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

}
