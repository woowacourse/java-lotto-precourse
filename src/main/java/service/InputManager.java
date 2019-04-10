package service;

import java.util.Scanner;

/**
 * @version 1.00 2019/04/10
 * @author 조재훈
 */
public class InputManager {
	private static final String INPUT_GUIDE_MESSAGE = "구입금액을 입력해주세요.";
	private static final String NUMBER_FORMAT_ERROR_MESSAGE = "잘못된 입력 형식입니다";
	private static final int LOTTO_PRICE = 1000;
	private Scanner scanner;

	public InputManager() {
		this.scanner = new Scanner(System.in);
	}

	public int getMoney() {
		int inputNumber = 0;
		do {
			System.out.println(INPUT_GUIDE_MESSAGE);
			inputNumber = getUserInput();
		} while (!isInputValid(inputNumber));

		scanner.close();
		return inputNumber;
	}

	private int getUserInput() {
		int userInput = -1;
		try {
			userInput = Integer.valueOf(scanner.nextLine().trim());
		} catch (NumberFormatException e) {
			System.out.println(NUMBER_FORMAT_ERROR_MESSAGE);
		}
		return userInput;
	}

	private static boolean isInputValid(int inputNumber) {
		if ((inputNumber > 0) && ((inputNumber % LOTTO_PRICE) == 0))
			return true;
		return false;
	}
}
