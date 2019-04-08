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
		System.out.println( lottoSize + "자리의 로또 번호를 입력하세요");
		return false;
	}
}
