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
		return (this.lottoSize == intList.size());
	}
}
