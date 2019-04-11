package utils;

import java.util.Comparator;

public class AscendingInteger implements Comparator<Integer> {
	@Override
	public int compare(Integer a, Integer b) {
		return a.compareTo(b);
	}
}
