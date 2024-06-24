package bai8;

import java.util.ArrayList;
import java.util.List;

public class GenericParameter {
	public static void printList(List<?> list) {
		for (Object element : list) {
			System.out.println(element);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> l1 = new ArrayList<String>();
		l1.add("Hello");
		l1.add("World");
		printList(l1);
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(100);
		l2.add(200);
		printList(l2);
	}

}
