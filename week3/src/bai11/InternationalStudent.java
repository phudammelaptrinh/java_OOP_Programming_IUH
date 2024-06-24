package bai11;

class InternationalStudent extends Student {
	private String country;

	public InternationalStudent(String name, int age, String id, String country) {
		super(name, age, id);
		this.country = country;
	}

	@Override
	public void displayInfo() {
		System.out.format("%-25s%-10d%-10s%-15s\n", name, age, id, country);
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
