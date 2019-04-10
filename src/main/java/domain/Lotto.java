package domain;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 * 
 * @version 1.00 2019/04/10
 * @author 조재훈
 */
public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	// 추가 기능 구현
}
