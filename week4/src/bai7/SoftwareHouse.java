package bai7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SoftwareHouse {
	private String theName;
	private List<Employee> listStaff;

	public SoftwareHouse(String theName) {
		this.theName = theName;
		this.listStaff = new ArrayList<>();
	}

	public boolean addEmployee(Employee employee) {
		return listStaff.add(employee);
	}

	public void displayAllStaff() {
		for (Employee employee : listStaff) {
			System.out.println(employee);
		}
	}

	public double getMonthlySalaryBill() {
		double total = 0;
		for (Employee employee : listStaff) {
			total += employee.getMonthlySalary();
		}
		return total;
	}

	public void sortAllStaffByName() {
		Collections.sort(listStaff, Comparator.comparing(Employee::getName));
	}

	public void displayListProgrammers() {
		for (Employee employee : listStaff) {
			if (employee instanceof Programmer) {
				System.out.println(employee);
			}
		}
	}

	public boolean updateDepartmentForAdmin(int payrollNo, String newDept) {
		for (Employee employee : listStaff) {
			if (employee instanceof Administrator && employee.toString().contains("PayrollNumber=" + payrollNo)) {
				((Administrator) employee).setTheDepartment(newDept);
				return true;
			}
		}
		return false;
	}

	public boolean deleteEmployee(int payrollNo) {
		return listStaff.removeIf(employee -> employee.toString().contains("PayrollNumber=" + payrollNo));
	}

	public List<Employee> getListStaff() {
		return listStaff;
	}
}
