package bai5;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private List res = new ArrayList();

	public void addMedia(Media x) {
		res.add(x);
	}

	public Media retrieveLast() {
		int size = res.size();
		if (size > 0) {
			return (Media) res.get(size - 1);
		}
		return null;
	}

	interface Media {

	}

	interface Book extends Media {

	}

	interface Video extends Media {

	}

	interface Newspaper extends Media {

	}
}
