/*
 * Lotto
 * 
 * version 1.0
 * 
 * 2019. 4. 6
 * 
 * Created by Wongeun Song
 */

package edu.yk1028;

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

	public boolean hasNumber(int number) {
		return numbers.contains(number);
	}

	public int matchCount(Lotto anotherLotto) {
		int count = 0;

		for (int number : numbers) {
			count += anotherLotto.checkMatch(number);
		}
		return count;
	}
	
	private int checkMatch(int number) {
		if(numbers.contains(number)) {
			return 1;
		}
		return 0;
	}

	public void printNumbers() {
		String message = numbers.stream().map(n -> n.toString()).collect(Collectors.joining(", "));

		System.out.println("[" + message + "]");
	}
}
