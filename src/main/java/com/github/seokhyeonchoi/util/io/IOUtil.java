package com.github.seokhyeonchoi.util.io;

import java.util.Scanner;

import com.github.seokhyeonchoi.util.conversion.StringToIntegerConverter;

public class IOUtil {
	private static final Scanner SCANNER = new Scanner(System.in);
	private static final String REGEX = "([^0-9]\\d+)|([^0-9])";

	public static void writeln(Object obj) {
		System.out.println(obj);
	}

	public static void write(Object obj) {
		System.out.print(obj);
	}
	
	public static void writeln() {
		System.out.println();
	}

	public static void write() {
	}

	public static void writef(String format, Object... args) {
		System.out.printf(format, args);
	}
	
	public static int readInt() {
		
		return StringToIntegerConverter.toInt(readLine(), REGEX);
	}

	public static String readLine() {
		return SCANNER.nextLine();
	}
}
