package bai7;

public class PrintArrGeneric {

	public static <E> void printArr(E[] inputArr) {
		for (E element : inputArr)
			System.out.printf("%s", element);
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] iArr = { 1, 2, 3, 4, 5 };
		Double[] dArr = { 1.1, 2.2, 3.3, 4.4, 5.5 };
		Character[] cArr = { 'H', 'E', 'L', 'L', 'O' };
		System.out.println("Mang so nguyen : ");
		printArr(iArr);
		System.out.println("\nMang double co noi dung : ");
		printArr(dArr);
		System.out.println("\nMang chuoi co noi dung : ");
		printArr(cArr);
	}

}
