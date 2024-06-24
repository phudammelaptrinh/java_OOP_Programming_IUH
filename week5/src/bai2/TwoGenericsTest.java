package bai2;

public class TwoGenericsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoGenerics<Integer, String> tgObj = new TwoGenerics<Integer, String>(88, "Generics");
		tgObj.showType();
		int v = tgObj.getOb1();
		System.out.println("Gia tri : " + v);
		String str = tgObj.getOb2();
		System.out.println("Gai tri : " + str);
	}

}
