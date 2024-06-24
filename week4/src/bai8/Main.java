package bai8;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Main {
	private static Course course1;

	public static void main(String[] args) {
		// Create test data
		createTestData();

		// Set up frame
		JFrame frame = new JFrame("Course Management");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		// Panel for course info
		JPanel courseInfoPanel = new JPanel();
		courseInfoPanel.setLayout(new GridLayout(5, 1));

		JLabel courseLabel = new JLabel("Khóa học: " + course1.getCourseTitle());
		JLabel courseCodeLabel = new JLabel("Mã khóa học: " + course1.getCourseNbr());
		JLabel facultyLabel = new JLabel("Giảng viên: John Smith");
		JLabel timeLabel = new JLabel("Thời gian: Fall 2021");
		JLabel roomLabel = new JLabel("Phòng học: Room A");

		courseInfoPanel.add(courseLabel);
		courseInfoPanel.add(courseCodeLabel);
		courseInfoPanel.add(facultyLabel);
		courseInfoPanel.add(timeLabel);
		courseInfoPanel.add(roomLabel);

		frame.add(courseInfoPanel, BorderLayout.NORTH);

		// Create the table model
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("MSSV");
		model.addColumn("Họ tên");
		model.addColumn("Năm nhập học");
		model.addColumn("Trạng thái");
		model.addColumn("Điểm chữ");
		model.addColumn("Điểm số");

		for (Section section : course1.getSections()) {
			for (Enrolment enrolment : section.getListEnrols()) {
				model.addRow(new Object[] { enrolment.getStudent().getStudentID(), enrolment.getStudent().toString(),
						enrolment.getStudent().getYearMatriculated(), enrolment.getStatus(), enrolment.getGrade(),
						enrolment.getNumGrade() });
			}
		}

		// Create the table
		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		frame.add(scrollPane, BorderLayout.CENTER);

		// Panel for summary info
		JPanel summaryPanel = new JPanel();
		JLabel totalStudentsLabel = new JLabel("Tổng số sinh viên: " + model.getRowCount());
		summaryPanel.add(totalStudentsLabel);
		frame.add(summaryPanel, BorderLayout.SOUTH);

		frame.setVisible(true);
	}

	private static void createTestData() {
		Faculty faculty1 = new Faculty("Smith", "John", "Room 101", "FAC123");

		Student student1 = new Student("Johnson", "Alex", 2019, "140211");
		Student student2 = new Student("Brown", "Maria", 2020, "140311");
		Student student3 = new Student("Williams", "Emily", 2021, "140411");

		Enrolment enrolment1 = new Enrolment("Enrolled", "A", 9.5f, student1);
		Enrolment enrolment2 = new Enrolment("Enrolled", "B", 7.0f, student2);
		Enrolment enrolment3 = new Enrolment("Enrolled", "A-", 8.5f, student3);

		Set<Enrolment> enrolments = new HashSet<>();
		enrolments.add(enrolment1);
		enrolments.add(enrolment2);
		enrolments.add(enrolment3);

		course1 = new Course("CS101", "Introduction to Programming", 4);
		course1.addSection("Fall 2021", "001", "Room A", faculty1, enrolments);
	}
}
