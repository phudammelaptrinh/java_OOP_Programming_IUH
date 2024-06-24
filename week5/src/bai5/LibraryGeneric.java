package bai5;

import java.util.ArrayList;
import java.util.List;

import bai5.Library.Media;

public class LibraryGeneric<E extends Media> {
	private List<E> res = new ArrayList<E>();

	public void addMedia(E x) {
		res.add(x);
	}

	public E retrieveLast() {
		int size = res.size();
		if (size > 0) {
			return res.get(size - 1);
		}
		return null;
	}

}
