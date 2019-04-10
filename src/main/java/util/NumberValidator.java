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
		return intList.stream().allMatch(this::isValidNumber);
	}

	public boolean isValidNumber(int number) {
		return ((lottoMinNum <= number) && (number <= lottoMaxNum));
	}
}
