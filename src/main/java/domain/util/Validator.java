package domain.util;

public class Validator {
	public static boolean isNaturalNumber(String value) {
		// TODO ADD more exception!
		if (value == null || value.length() == 0) {
			return false;
		}
		return true;
	}
}
