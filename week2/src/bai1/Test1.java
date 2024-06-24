package bai1;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ToaDo toado1 = new ToaDo();
		System.out.println(toado1.toString());
		
		ToaDo toado2 = new ToaDo();
		System.out.println(toado2.toString());
		
		toado1.setX(3);
		toado1.setY(4);
		toado1.setTen("B");
		System.out.println("ToaDo 1 - X:"+toado1.getX()+",y: "+ toado1.getY()+", ten: "+toado1.getTen());
		System.out.println(toado1.toString());
	}

}
