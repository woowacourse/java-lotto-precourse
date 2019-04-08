package domain;

import org.junit.Test;
import util.Validator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ValidatorTest {
	private static final int LOTTO_MIN_NUMBER = 1;
	private static final int LOTTO_MAX_NUMBER = 45;
	private static final int LOTTO_SIZE= 6;
	private static final Validator VALIDATOR = new Validator(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);

	@Test
	public void isValidNumbers() {
		List<Integer> intList = new ArrayList<>();
		for (int i = 1; i <= LOTTO_MAX_NUMBER + 1; i++) {
			intList.add(i);
		}
		assertFalse(VALIDATOR.isValidNumbers(intList));
		intList.remove(LOTTO_MAX_NUMBER);
		assertTrue(VALIDATOR.isValidNumbers(intList));
	}

	@Test
	public void isValidNumber() {
		assertFalse(VALIDATOR.isValidNumber(LOTTO_MIN_NUMBER - 1));
		for (int i = 1; i <= LOTTO_MAX_NUMBER; i++) {
			assertTrue(VALIDATOR.isValidNumber(i));
		}
		assertFalse(VALIDATOR.isValidNumber(LOTTO_MAX_NUMBER + 1));
	}
}