package domain.lotto;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
	public static final int DRAWS_COUNT = 6;
	
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
	
	public boolean contains(int number) {
		return numbers.contains(number);
	}

	@Override
	public String toString() {
		return numbers.toString();
	}
}
