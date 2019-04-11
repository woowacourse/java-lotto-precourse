package ui;

import validation.MoneyValidation;
import validation.Validation;

import java.util.Scanner;

public class GameUI {
	public void run() {
		try(Scanner sc = new Scanner(System.in)) {
			int money = askMoney(sc);
		}
	}

	private int askMoney(Scanner sc) {
		String message = "구입금액을 입력해 주세요.";
		Validation<Integer> validation = new MoneyValidation();

		Input<Integer> input = new Input<>(sc, message, validation);

		return input.ask();
	}
}
