/*
 * Parser.java
 */

package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
	private static final String COMMA = ",";

	public static List<String> getStringList(String input) {
		return Arrays.asList(input.split(COMMA)).stream()
				.map(String::trim)
				.collect(Collectors.toList());
	}
}
