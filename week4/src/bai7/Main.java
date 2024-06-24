package bai7;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main {
	private static SoftwareHouse softwareHouse = new SoftwareHouse("Tech Solutions");

	public static void main(String[] args) {
		// Add test data
		addTestData();

		JFrame frame = new JFrame("Software House Management");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		JTextArea displayArea = new JTextArea();
		displayArea.setEditable(false);
		frame.add(new JScrollPane(displayArea), BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 2, 10, 10)); // Add spacing between components

		JTextField payrollField = new JTextField();
		JTextField nameField = new JTextField();
		JTextField salaryField = new JTextField();
		JTextField extraField = new JTextField();

		panel.add(new JLabel("Payroll Number:"));
		panel.add(payrollField);
		panel.add(new JLabel("Name:"));
		panel.add(nameField);
		panel.add(new JLabel("Basic Salary:"));
		panel.add(salaryField);
		panel.add(new JLabel("Language/Department:"));
		panel.add(extraField);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3, 3, 10, 10)); // Add spacing between buttons

		JButton addButton = new JButton("Add Programmer");
		addButton.addActionListener(e -> {
			int payrollNumber = Integer.parseInt(payrollField.getText());
			String name = nameField.getText();
			double salary = Double.parseDouble(salaryField.getText());
			String language = extraField.getText();
			Employee programmer = new Programmer(payrollNumber, name, salary, language);
			softwareHouse.addEmployee(programmer);
			displayArea.append("Added Programmer: " + programmer + "\n");
		});

		JButton addAdminButton = new JButton("Add Administrator");
		addAdminButton.addActionListener(e -> {
			int payrollNumber = Integer.parseInt(payrollField.getText());
			String name = nameField.getText();
			double salary = Double.parseDouble(salaryField.getText());
			String department = extraField.getText();
			Employee admin = new Administrator(payrollNumber, name, salary, department);
			softwareHouse.addEmployee(admin);
			displayArea.append("Added Administrator: " + admin + "\n");
		});

		JButton addLeaderButton = new JButton("Add Project Leader");
		addLeaderButton.addActionListener(e -> {
			int payrollNumber = Integer.parseInt(payrollField.getText());
			String name = nameField.getText();
			double salary = Double.parseDouble(salaryField.getText());
			String language = extraField.getText();
			Employee leader = new ProjectLeader(payrollNumber, name, salary, language);
			softwareHouse.addEmployee(leader);
			displayArea.append("Added Project Leader: " + leader + "\n");
		});

		JButton displayButton = new JButton("Display All Staff");
		displayButton.addActionListener(e -> {
			displayArea.append("All Staff:\n");
			for (Employee employee : softwareHouse.getListStaff()) {
				displayArea.append(employee + "\n");
			}
		});

		JButton salaryBillButton = new JButton("Display Salary Bill");
		salaryBillButton.addActionListener(e -> {
			double totalSalary = softwareHouse.getMonthlySalaryBill();
			displayArea.append("Total Monthly Salary Bill: " + totalSalary + "\n");
		});

		JButton sortButton = new JButton("Sort Staff by Name");
		sortButton.addActionListener(e -> {
			softwareHouse.sortAllStaffByName();
			displayArea.append("Staff sorted by name.\n");
		});

		JButton displayProgrammersButton = new JButton("Display Programmers");
		displayProgrammersButton.addActionListener(e -> {
			displayArea.append("Programmers:\n");
			for (Employee employee : softwareHouse.getListStaff()) {
				if (employee instanceof Programmer) {
					displayArea.append(employee + "\n");
				}
			}
		});

		JButton updateDeptButton = new JButton("Update Department");
		updateDeptButton.addActionListener(e -> {
			int payrollNumber = Integer.parseInt(payrollField.getText());
			String newDept = extraField.getText();
			if (softwareHouse.updateDepartmentForAdmin(payrollNumber, newDept)) {
				displayArea.append("Updated department for payroll number " + payrollNumber + "\n");
			} else {
				displayArea.append("Failed to update department for payroll number " + payrollNumber + "\n");
			}
		});

		JButton deleteButton = new JButton("Delete Employee");
		deleteButton.addActionListener(e -> {
			int payrollNumber = Integer.parseInt(payrollField.getText());
			if (softwareHouse.deleteEmployee(payrollNumber)) {
				displayArea.append("Deleted employee with payroll number " + payrollNumber + "\n");
			} else {
				displayArea.append("Failed to delete employee with payroll number " + payrollNumber + "\n");
			}
		});

		buttonPanel.add(addButton);
		buttonPanel.add(addAdminButton);
		buttonPanel.add(addLeaderButton);
		buttonPanel.add(displayButton);
		buttonPanel.add(salaryBillButton);
		buttonPanel.add(sortButton);
		buttonPanel.add(displayProgrammersButton);
		buttonPanel.add(updateDeptButton);
		buttonPanel.add(deleteButton);

		frame.add(panel, BorderLayout.NORTH);
		frame.add(buttonPanel, BorderLayout.SOUTH);

		frame.setVisible(true);
	}

	private static void addTestData() {
		Employee programmer1 = new Programmer(1, "Alice", 3000, "Java");
		Employee programmer2 = new Programmer(2, "Bob", 3200, "Python");
		Employee admin1 = new Administrator(3, "Charlie", 3500, "HR");
		Employee admin2 = new Administrator(4, "Dave", 3600, "Finance");
		Employee leader1 = new ProjectLeader(5, "Eve", 4000, "C++");

		softwareHouse.addEmployee(programmer1);
		softwareHouse.addEmployee(programmer2);
		softwareHouse.addEmployee(admin1);
		softwareHouse.addEmployee(admin2);
		softwareHouse.addEmployee(leader1);
	}
}
