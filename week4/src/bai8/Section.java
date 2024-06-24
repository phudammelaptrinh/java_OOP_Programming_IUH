package bai8;

import java.util.Set;

public class Section {
	private String semester;
	private String sectionNbr;
	private String room;
	private Faculty facultyMember;
	private Set<Enrolment> listEnrols;

	public Section(String semester, String sectionNbr, String room, Faculty facultyMember, Set<Enrolment> listEnrols) {
		this.semester = semester;
		this.sectionNbr = sectionNbr;
		this.room = room;
		this.facultyMember = facultyMember;
		this.listEnrols = listEnrols;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getSectionNbr() {
		return sectionNbr;
	}

	public void setSectionNbr(String sectionNbr) {
		this.sectionNbr = sectionNbr;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public Faculty getFacultyMember() {
		return facultyMember;
	}

	public void setFacultyMember(Faculty facultyMember) {
		this.facultyMember = facultyMember;
	}

	public Set<Enrolment> getListEnrols() {
		return listEnrols;
	}

	public void setListEnrols(Set<Enrolment> listEnrols) {
		this.listEnrols = listEnrols;
	}

}
