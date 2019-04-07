package domain.util;

import java.util.Arrays;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Validator {
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;
	private static final String NUMBER_PATTERN = "^[0-9]*$";

	public static boolean isNaturalNumber(String value) {
		if (value == null || value.length() == 0 ||
			!Pattern.matches(NUMBER_PATTERN, value) ||
			Integer.parseInt(value.trim()) < 0) {
			printWrongInput();
			return false;
		}
		return true;
	}

	public static boolean isValidInputtedNumbers(String input, int drawCount) {
		if (input == null || input.length() == 0 ||
			!isSameCount(input, drawCount)) {
			printWrongInput();
			return false;
		}
		if (!isSameCount(input, drawCount)) {
			return false;
		}
		return true;
	}

	public static boolean isSameCount(String input, int drawCount) {
		Set<Integer> refinedNumber = Arrays.stream(input.split(","))
			.filter(stringNumber -> isIncludeLottoNumber(stringNumber))
			.map(stringNumber -> Integer.parseInt(stringNumber.trim()))
			.collect(Collectors.toSet());

		if (refinedNumber.size() != drawCount) {
			printWrongInput();
			return false;
		}
		return true;
	}

	public static boolean isIncludeLottoNumber(String value) {
		value = value.trim();
		int number = Integer.parseInt(value);
		if (!isNaturalNumber(value) ||
			number < MIN_NUMBER || number > MAX_NUMBER) {
			printWrongInput();
			return false;
		}
		return true;
	}

	public static void printWrongInput() {
		System.out.println("잘 못 입력했습니다.");
	}
}
