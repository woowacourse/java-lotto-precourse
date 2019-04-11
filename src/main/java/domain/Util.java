package domain;

import java.util.regex.Pattern;

public class Util {
	private static final int LOTTO_NUMBER_COUNT = 6;
	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;
	private static final int PRICE_OF_ONE_LOTTO = 1000;

	public static boolean isValidNumber(String userInput) {
		if (Pattern.matches("^[0-9]*$", userInput)) {
			return true;
		}
		System.out.println("0 이상의 '숫자만' 입력해주세요.");
		return false;
	}

	public static int StringToInteger(String userInput) {
		return Integer.parseInt(userInput);
	}

	public static boolean isDividedByOneThousand(String userInput) {
		if (StringToInteger(userInput) % PRICE_OF_ONE_LOTTO == 0) {
			return true;
		}
		System.out.println("로또 1게임당 구입 가격은 1000원입니다.");
		return false;
	}

}
