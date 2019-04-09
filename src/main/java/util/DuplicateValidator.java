/*
 * DuplicateValidator.java
 */
package util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateValidator {

	public boolean isDuplicate(List<Integer> intList) {
		Set<Integer> temp = new HashSet<>(intList);
		if (temp.size() == intList.size()) {
			return false;
		}
		return true;
	}

	public boolean isDuplicate(List<Integer> intList, int bonusNum) {
		Set<Integer> temp = new HashSet<Integer>(intList);
		if (!intList.contains(bonusNum)) {
			return false;
		}
		return true;
	}
}
