package bai11;

public class IntermediateStudent extends Student {

	public IntermediateStudent(String name, int age, String id) {
		super(name, age, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void displayInfo() {
		System.out.format("%-25s%-10d%-10s%-15s\n", name, age, id, "N/A");
	}

}
