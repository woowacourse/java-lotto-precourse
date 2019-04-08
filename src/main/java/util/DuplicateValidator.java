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
		System.out.println("중복된 당첨번호를 입력했습니다.");
		return true;
	}

	public boolean isDuplicate(List<Integer> intList, int bonusNum) {
		Set<Integer> temp = new HashSet<Integer>(intList);
		if (!intList.contains(bonusNum)) {
			return false;
		}
		System.out.println("중복된 보너스 볼을 입력했습니다.");
		return true;
	}
}
