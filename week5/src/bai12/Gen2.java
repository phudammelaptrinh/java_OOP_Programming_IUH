package bai12;

public class Gen2<T> extends Gen<T> {
	Gen2(T o) {
		super(o);
	}

	T getObject() {
		System.out.println("Gen2's getObject(): ");
		return ob;
	}
}
