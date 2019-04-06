package com.github.seokhyeonchoi.util.conversion;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringToIntegerConverter {
	public static List<Integer> toList(String inputString, String splitRegex, String removeRegex) {
		Pattern pattern = Pattern.compile(splitRegex);
		try {
			List<Integer> list = pattern.splitAsStream(inputString.replaceAll(removeRegex, "")).map(Integer::parseInt).collect(Collectors.toList());
			return list;
		} catch(NumberFormatException e){
			return new ArrayList<>();
		}
	}
	
	public static Integer toInt(String inputString, String removeRegex) {
		String replacedString = inputString.replaceAll(removeRegex, "");
		if(replacedString.equals("")) {
			return 0;
		}
		
		return Integer.parseInt(replacedString);
	}
}
