package bai11;

public abstract class Student {
	protected String name;
	protected int age;
	protected String id;

	public Student(String name, int age, String id) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
	}

	public abstract void displayInfo();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
