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
		if (value == null || value.length() == 0) {
			return false;
		}
		if (!Pattern.matches(NUMBER_PATTERN, value)) {
			return false;
		}
		if (Integer.parseInt(value) < 0) {
			return false;
		}
		return true;
	}

	public static boolean isValidInputtedNumbers(String input, int drawCount) {
		System.out.println("잘 못 입력하였습니다.");
		if (input == null || input.length() == 0) {
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
			.map(stringNumber -> Integer.parseInt(stringNumber))
			.collect(Collectors.toSet());

		if (refinedNumber.size() != drawCount) {
			return false;
		}
		return true;
	}

	public static boolean isIncludeLottoNumber(String value) {
		if (!isNaturalNumber(value)) {
			return false;
		}
		int number = Integer.parseInt(value);
		if (number < MIN_NUMBER || number > MAX_NUMBER) {
			return false;
		}
		return true;
	}
}
