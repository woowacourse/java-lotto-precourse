/*
 * Class : Lotto	(로또 한장을 의미하는 객체)
 * 
 * Version : 1.0.0
 * 
 * 2019-4-10
 * 
 * Jeongho Park
 */

package domain;

import java.util.List;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return this.numbers;
	}

}
