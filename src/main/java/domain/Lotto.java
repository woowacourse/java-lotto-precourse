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

	public boolean isContainBonus(int bonus) {
		return numbers.contains(bonus);
	}

	public int getCountOfMatch(Lotto wonLotto) {
		List<Integer> winningLotto = wonLotto.getNumbers();
		int count = 0;
		for (int i = 0; i < numbers.size(); i++) {
			if (numbers.contains(winningLotto.get(i))) {
				count++;
			}
		}
		return count;
	}

	public List<Integer> getNumbers() {
		return this.numbers;
	}
}
