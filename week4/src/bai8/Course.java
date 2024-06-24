package bai8;

import java.util.HashSet;
import java.util.Set;

public class Course {
	private String courseNbr;
	private String courseTitle;
	private int credits;
	private Set<Section> sections;

	public Course(String courseNbr, String courseTitle, int credits) {
		this.courseNbr = courseNbr;
		this.courseTitle = courseTitle;
		this.credits = credits;
		this.sections = new HashSet<>();
	}

	public String getCourseNbr() {
		return courseNbr;
	}

	public void setCourseNbr(String courseNbr) {
		this.courseNbr = courseNbr;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public Set<Section> getSections() {
		return sections;
	}

	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}

	public int getNbrStudents(String sectionNbr) {
		for (Section section : sections) {
			if (section.getSectionNbr().equals(sectionNbr)) {
				return section.getListEnrols().size();
			}
		}
		return 0;
	}

	public void addSection(String semester, String sectionNbr, String room, Faculty facultyMember,
			Set<Enrolment> listEnrols) {
		Section section = new Section(semester, sectionNbr, room, facultyMember, listEnrols);
		sections.add(section);
	}
}
