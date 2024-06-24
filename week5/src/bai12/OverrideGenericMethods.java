package bai12;

public class OverrideGenericMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gen<Integer> intObject = new Gen<Integer>(88);
		Gen2<Long> longObject = new Gen2<Long>(99L);

		intObject.getObject();
		longObject.getObject();

	}

}
