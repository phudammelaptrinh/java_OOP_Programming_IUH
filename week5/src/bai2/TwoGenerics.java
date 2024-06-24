package bai2;

public class TwoGenerics<T, V> {
	T ob1;
	V ob2;

	public TwoGenerics(T o1, V o2) {
		super();
		this.ob1 = o1;
		this.ob2 = o2;
	}

	void showType() {
		System.out.println("Loai cua T la " + ob1.getClass().getName());
		System.out.println("Loai cua T la " + ob2.getClass().getName());
	}

	public T getOb1() {
		return ob1;
	}

	public V getOb2() {
		return ob2;
	}

}
