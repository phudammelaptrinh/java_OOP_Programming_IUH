package bai4;

import java.util.Arrays;

public class PersonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person[] authors = { new Person("D", "S"), new Person("J", "C"), new Person("T", "C"), new Person("C", "S"),
				new Person("P", "C"), new Person("B", "B"), };
		Arrays.sort(authors);
		System.out.println("Sau khi sap xep :");
		for (Person author : authors) {
			System.out.println(author);
		}
		Person[] people = { new Person("C", "S"), new Person("N", "N"), new Person("T", "C"), new Person("C", "D"), };
		int index = 0;
		System.out.println("\nTim kiem :");
		for (Person person : people) {

			index = Arrays.binarySearch(authors, person);
			if (index >= 0) {
				System.out.println(person + " tai vi tri index " + index);
			} else {
				System.out.println(person + " khong tim thay . Gia tri tra ve: " + index);
			}
		}

	}

}
