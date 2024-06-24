package bai13;

public class GenericInterfaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer inums[] = { 3, 4, 5, 6, 7 };
		Character chs[] = { 'H', 'E', 'L', 'L', 'O' };
		MyClass<Integer> iob = new MyClass<Integer>(inums);
		MyClass<Character> cob = new MyClass<Character>(chs);
		System.out.println("Gia tri lon nhat trong inums : " + iob.max());
		System.out.println("Gia tri nho nhat trong inums : " + iob.min());
		System.out.println("Gia tri lon nhat in chs : " + cob.max());
		System.out.println("Gia tri nho nhat in chs : " + cob.min());

	}

}
