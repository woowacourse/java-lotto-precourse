package domain;

import java.util.List;
import java.util.stream.Collectors;

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

	public int getCount(Lotto lotto) {
		return numbers.stream()
				.filter(number -> lotto.contains(number))
				.collect(Collectors.toList())
				.size();
	}

	public boolean contains(int number) {
		return numbers.contains(number);
	}
}
