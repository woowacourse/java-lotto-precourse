package domain;

import java.util.Set;
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
	
	public static boolean isDuplicatedNumber(Set<Integer> set) {
		if (set.size() < 6) {
			System.out.println("중복된 숫자가 있습니다.");
			return true;
		}
		return false;
	}
	
	public static boolean isValidRange(String[] userInputWithoutComma) {
		boolean validNumber = true;
		for (int i = 0; i < userInputWithoutComma.length; i++) {
			validNumber = (StringToInteger(userInputWithoutComma[i]) >= MIN_LOTTO_NUMBER
					&& StringToInteger(userInputWithoutComma[i]) <= MAX_LOTTO_NUMBER && validNumber == true) ? true : false;
		}
		if (!validNumber) {
			System.out.println("로또 번호는 1 ~ 45 사이의 수 중에서 입력해주세요.");
		}
		return validNumber;
	}
	
	public static boolean isvalidWeekNumber(String[] userInputWithoutComma) {
		boolean validNumber = true;
		for (int i = 0; i < userInputWithoutComma.length; i++) {
			validNumber = (Pattern.matches("^[0-9]*$", userInputWithoutComma[i]) && validNumber == true) ? true : false;
		}
		if (!validNumber) {
			System.out.println("0 이상의 '숫자만' 입력해주세요.");
		}
		return validNumber;
	}
	
	public static boolean isValidNumberCount(String[] userInputWithoutComma) {
		if (userInputWithoutComma.length == LOTTO_NUMBER_COUNT) {
			return true;
		}
		System.out.println("6개의 숫자를 입력해주세요.");
		return false;
	}

}
