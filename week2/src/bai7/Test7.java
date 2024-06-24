package bai7;

public class Test7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ToaDo tam = new ToaDo("0",5.0f, 5.0f);
		HinhTron ht = new HinhTron(tam,10.5);
		
		System.out.println(ht.toString());
		System.out.println("Dien tich  " +ht.tinhDienTich());
		System.out.println("Chu Vi : " + ht.tinhChuVi());
	}

}
