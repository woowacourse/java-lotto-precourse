/*
 * InputMaker.java
 */

package domain;

import java.util.*;
import java.util.stream.Collectors;

public class InputMaker {
	private static final String BLANK_REGEX = "(^\\s*$)";
	private static final String NUMBER_REGEX = "(^[0-9]+$)";
	private static final Scanner SCANNER = new Scanner(System.in);

	public static int getInt() {
		String input = null;
		do {
			input = SCANNER.nextLine();
		} while (!isNumber(input));
		return Integer.parseInt(input);
	}

	private static boolean isNumber(String input) {
		if (input.matches(NUMBER_REGEX)) {
			return true;
		}
		System.out.println("숫자를 입력하세요");
		return false;
	}

	public static String getString() {
		String input = null;
		do {
			input = SCANNER.nextLine();
		} while (isBlank(input));
		return input;
	}

	private static boolean isBlank(String input) {
		if (input.matches(BLANK_REGEX)) {
			System.out.println("빈칸 입력하지 마세요.");
			return true;
		}
		return false;
	}
}
