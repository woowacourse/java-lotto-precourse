package domain;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
	
	public static final int LOTTO_NUMBER_SIZE = 6;
	
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	@Override
	public String toString() {
		return numbers.toString();
	}

}
