/*
 * NumberValidator.java
 */
package util;

import java.util.List;

public class NumberValidator {
	private int lottoMinNum;
	private int lottoMaxNum;

	public NumberValidator(int lottoMinNum, int lottoMaxNum) {
		this.lottoMinNum = lottoMinNum;
		this.lottoMaxNum = lottoMaxNum;
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
}
