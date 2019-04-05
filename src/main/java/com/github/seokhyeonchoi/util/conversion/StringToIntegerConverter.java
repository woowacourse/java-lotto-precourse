package com.github.seokhyeonchoi.util.conversion;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringToIntegerConverter {
	public static List<Integer> toList(String inputString, String splitRegex, String removeRegex) {
		Pattern pattern = Pattern.compile(splitRegex);

		return pattern.splitAsStream(inputString.replaceAll(removeRegex, "")).map(Integer::parseInt).collect(Collectors.toList());
	}
}
