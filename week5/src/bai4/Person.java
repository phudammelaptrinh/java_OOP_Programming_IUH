package bai4;

public class Person implements Comparable<Person> {
	private String firstName;
	private String surName;

	public Person(String firstName, String surName) {
		super();
		this.firstName = firstName;
		this.surName = surName;
	}

	@Override
	public String toString() {
		return firstName + "" + surName;
	}

	public int compareTo(Person person) {
		int ketqua = surName.compareTo(person.surName);
		return ketqua == 0 ? firstName.compareTo(((Person) person).firstName) : ketqua;
	}
}
