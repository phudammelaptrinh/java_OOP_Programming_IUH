package bai9;

import java.util.ArrayList;
import java.util.List;

public class BoundedWildcard {

	public static double getAverage(List<? extends Number> numberList) {
		double total = 0.0;
		for (Number number : numberList) {
			total += number.doubleValue();
		}
		return total / numberList.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> iList = new ArrayList<Integer>();
		iList.add(3);
		iList.add(30);
		iList.add(300);
		System.out.println(getAverage(iList));
		List<Double> dList = new ArrayList<Double>();
		dList.add(3.0);
		dList.add(33.0);
		System.out.println(getAverage(dList));
	}

}
