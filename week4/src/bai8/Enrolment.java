package bai8;

public class Enrolment {
	private String status;
	private String grade;
	private float numGrade;
	private Student student;

	public Enrolment(String status, String grade, float numGrade, Student student) {
		this.status = status;
		this.grade = grade;
		this.numGrade = numGrade;
		this.student = student;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public float getNumGrade() {
		return numGrade;
	}

	public void setNumGrade(float numGrade) {
		this.numGrade = numGrade;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
