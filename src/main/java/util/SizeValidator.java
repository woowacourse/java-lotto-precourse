/*
 * SizeValidator.java
 */
package util;

import java.util.List;

public class SizeValidator {
	private int lottoSize;

	public SizeValidator(int lottoSize) {
		this.lottoSize = lottoSize;
	}

	public boolean isValidSize(List<Integer> intList) {
		if (intList.size() == this.lottoSize) {
			return true;
		}
		return false;
	}
}
