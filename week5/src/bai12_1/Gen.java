package bai12_1;

public class Gen<T> {
	T ob;

	Gen(T o) {
		ob = o;
	}

	T getObject() {
		return ob;
	}
}
