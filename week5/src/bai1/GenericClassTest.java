package bai1;

public class GenericClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericClass<Integer> iOb = new GenericClass<Integer>(88);
		iOb.showType();
		// Khong can ep kieu
		int v = iOb.getob();
		System.out.println("Gia tri : " + v);
		// Tao doi tuong cho GenericClass luu tru cac chuoi String
		GenericClass<String> strOb = new GenericClass<String>("Generics Test");
		String str = strOb.getob();
		System.out.println("Gia tri : " + str);
	}

}
