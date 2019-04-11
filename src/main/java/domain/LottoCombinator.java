package domain;

import validation.LottoValidation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoCombinator {
	private static final int MIN_NUMBER = LottoValidation.MIN_NUMBER;
	private static final int MAX_NUMBER = LottoValidation.MAX_NUMBER;
	private static final int NUMBER_CNT = LottoValidation.NUMBER_CNT;
	private Stack<Integer> lottoNumbers;

	public LottoCombinator() {
		lottoNumbers = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
				.boxed()
				.collect(Collectors.toCollection(Stack::new));
	}

	public Lotto getLotto() {
		List<Integer> numbers = new ArrayList<>();

		for (int i = 0; i < NUMBER_CNT; i++) {
			shuffle();
			numbers.add(pop());
		}
		Collections.sort(numbers);

		return new Lotto(numbers);
	}

	private void shuffle() {
		Collections.shuffle(lottoNumbers);
	}

	private int pop() {
		return lottoNumbers.pop();
	}
}
