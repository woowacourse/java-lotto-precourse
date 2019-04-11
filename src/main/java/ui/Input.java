package ui;

import validation.Validation;

import java.util.Scanner;

/**
 * 게임 사용자 인터페이스의 입력을 담당하는 객체
 */
public class Input<T> {
	private final Scanner sc;
	private final String message;
	private final Validation<T> validation;

	Input(Scanner sc, String message, Validation<T> validation) {
		this.sc = sc;
		this.message = message;
		this.validation = validation;
	}

	public T ask() {
		String value;

		do {
			System.out.println(message);
			value = sc.nextLine();
		} while (!validation.check(value));

		return validation.convert(value);
	}
}