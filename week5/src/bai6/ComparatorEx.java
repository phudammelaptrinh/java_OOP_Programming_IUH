package bai6;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class ComparatorEx {

	public static <T> T max(Collection<? extends T> coll, Comparator<? super T> cmp) {
		T candidate = coll.iterator().next();
		for (T elt : coll) {
			if (cmp.compare(candidate, elt) < 0) {
				candidate = elt;
			}
		}
		return candidate;
	}

	public static <T extends Comparable<? super T>> T max(Collection<? extends T> coll) {
		return max(coll, ComparatorEx.<T>naturalOrder());
	}

	public static <T> T min(Collection<? extends T> coll, Comparator<? super T> cmp) {
		T candidate = coll.iterator().next();
		for (T elt : coll) {
			if (cmp.compare(candidate, elt) > 0) {
				candidate = elt;
			}
		}
		return candidate;
	}

	public static <T extends Comparable<? super T>> T min(Collection<? extends T> coll) {
		return min(coll, ComparatorEx.<T>reverseOrder());
	}

	public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
		return new Comparator<T>() {
			public int compare(T o1, T o2) {
				return o1.compareTo(o2);
			}
		};
	}

	public static <T> Comparator<T> reverseOrder(final Comparator<T> cmp) {
		return new Comparator<T>() {
			public int compare(T o1, T o2) {
				return cmp.compare(o1, o2);
			}
		};
	}

	public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
		return new Comparator<T>() {
			public int compare(T o1, T o2) {
				return o2.compareTo(o1);
			}
		};
	}

	public static void main(String[] args) {
		Comparator<String> sizeOrder = new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s1.length() < s2.length() ? -1 : s1.length() > s2.length() ? 1 : s1.compareTo(s2);
			}
		};

		Collection<String> strings = Arrays.asList("AAA", "aaa", "CCC", "f");

		System.out.println(ComparatorEx.max(strings));
		System.out.println(ComparatorEx.min(strings));
		System.out.println(ComparatorEx.max(strings, sizeOrder));
		System.out.println(ComparatorEx.min(strings, sizeOrder));
	}
}
