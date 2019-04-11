package ui;

import validation.Validation;

import java.util.Scanner;

/**
 * Input 객체는 사용자로부터 데이터를 받는다.
 *
 * @author 조남균
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