package bai3;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TamGiac tg1 = new TamGiac(-3,4,5);
		TamGiac tg2 = new TamGiac(1,2,3);
		TamGiac tg3 = new TamGiac(3,4,5);
		TamGiac tg4 = new TamGiac(4,4,4);
		TamGiac tg5 = new TamGiac(4,4,5);
		
		 System.out.println("Danh sach tam giac:");
	     System.out.printf("%-50s %-20s %-10s %-10s\n", "Cac canh", "Kieu", "Chu vi", "Dien tich");
	     System.out.println(tg1);
	     System.out.println(tg2);
	     System.out.println(tg3);
	     System.out.println(tg4);
	     System.out.println(tg5);
	}

}
