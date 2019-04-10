/*
 * InputUtil.java
 */

package util;

import java.util.*;
import java.util.stream.Collectors;

public class InputUtil {
	private static final String BLANK_REGEX = "(^\\s*$)";
	private static final String NUMBER_REGEX = "(^[0-9]+$)";
	private static final String COMMA = ",";
	private static final Scanner SCANNER = new Scanner(System.in);

	public static int getInt() {
		String input;
		do {
			input = SCANNER.nextLine();
		} while (!isNumber(input));
		return Integer.parseInt(input);
	}

	private static boolean isNumber(String input) {
		if (input.trim().matches(NUMBER_REGEX)) {
			return true;
		}
		System.out.println("숫자를 입력하세요");
		return false;
	}

	public static List<Integer> getIntegerList() {
		List<String> strList;
		do {
			strList = Arrays.asList(getString().split(COMMA));
		} while (!isNumberList(strList));
		return makeIntegerList(strList);
	}

	private static boolean isNumberList(List<String> strList) {
		return strList.stream().allMatch(InputUtil::isNumber);
	}

	private static List<Integer> makeIntegerList(List<String> strList) {
		return strList.stream()
				.map(String::trim)
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}

	private static String getString() {
		String input;
		do {
			input = SCANNER.nextLine();
		} while (isBlank(input));
		return input;
	}

	private static boolean isBlank(String input) {
		if (input.matches(BLANK_REGEX)) {
			System.out.println("빈칸을 입력하셨습니다.");
			return true;
		}
		return false;
	}
}
