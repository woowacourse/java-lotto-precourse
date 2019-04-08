package util;

import org.junit.Test;

import static org.junit.Assert.*;

public class RandomNumberMakerTest {
	private static final int LOTTO_MIN_NUMBER = 1;
	private static final int LOTTO_MAX_NUMBER = 45;

	RandomNumberMaker randomMaker = new RandomNumberMaker(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER);
	NumberValidator NUMBER_VALIDATOR = new NumberValidator(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER);

	@Test
	public void getRandomNumber() {
		for (int i = 0; i < 10000; i++) {
			int temp = randomMaker.getRandomNumber();
			assertTrue(NUMBER_VALIDATOR.isValidNumber(temp));
			System.out.println(temp);
		}
	}
}