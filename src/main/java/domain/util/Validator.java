package domain.util;

import java.util.regex.Pattern;

public class Validator {
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

}
