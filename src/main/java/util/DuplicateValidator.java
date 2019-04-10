/*
 * DuplicateValidator.java
 */
package util;

import java.util.List;

public class DuplicateValidator {

	public boolean isDuplicate(List<Integer> intList) {
		int count = (int) intList.stream().distinct().count();
		return (count != intList.size());
	}

	public boolean isDuplicate(List<Integer> intList, int bonusNum) {
		return intList.contains(bonusNum);
	}
}
