package bai8;

public class Faculty extends Person {
	private String office;
	private String facultyID;

	public Faculty(String lastName, String firstName, String office, String facultyID) {
		super(lastName, firstName);
		this.office = office;
		this.facultyID = facultyID;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getFacultyID() {
		return facultyID;
	}

	public void setFacultyID(String facultyID) {
		this.facultyID = facultyID;
	}

}
