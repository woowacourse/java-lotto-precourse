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
		return false;
	}
}
