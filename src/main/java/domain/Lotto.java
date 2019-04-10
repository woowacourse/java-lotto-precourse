package domain;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	// 추가 기능 구현
	public String toString() {
		return numbers.toString();
	}

	public int getCount(Lotto compareLotto) {
		return (int) numbers.stream()
				.filter(number -> compareLotto.contains(number))
				.count();
	}

	public boolean contains(int number) {
		return numbers.contains(number);
	}
}
