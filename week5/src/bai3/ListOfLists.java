package bai3;

import java.util.ArrayList;
import java.util.List;

public class ListOfLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> listOfStrings = new ArrayList<String>();
		listOfStrings.add("Hello again");
		List<List<String>> listOfLists = new ArrayList<List<String>>();
		listOfLists.add(listOfStrings);
		String s = listOfLists.get(0).get(0);
		// Tu them thong tin khac
		System.out.println(s);
	}

}
