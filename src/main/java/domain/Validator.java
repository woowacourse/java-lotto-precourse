/*
 * Validator.java
 */

package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
	private int lottoMinNum;
	private int lottoMaxNum;
	private int lottoSize;

	public Validator(int lottoMinNum, int lottoMaxNum, int lottoSize) {
		this.lottoMinNum = lottoMinNum;
		this.lottoMaxNum = lottoMaxNum;
		this.lottoSize = lottoSize;
	}

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

	public boolean isValidNumbers(List<Integer> intList) {
		if (intList.stream().allMatch(this::isValidNumber)) {
			return true;
		}
		return false;
	}

	public boolean isValidNumber(int number) {
		if ((lottoMinNum <= number) && (number <= lottoMaxNum)) {
			return true;
		}
		System.out.println("범위에 맞는 로또 번호를 입력하세요. (" + lottoMinNum + "~" + lottoMaxNum + ")");
		return false;
	}

	public boolean isValidSize(List<Integer> intList) {
		if (intList.size() == this.lottoSize) {
			return true;
		}
		System.out.println( lottoSize + "자리의 로또 번호를 입력하세요");
		return false;
	}
}
