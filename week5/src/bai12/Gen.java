package bai12;

public class Gen<T> {
	T ob;

	Gen(T o) {
		ob = o;
	}

	T getObject() {
		System.out.println("Gen's getObject(): ");
		return ob;
	}
}
