package service;

import domain.Money;
import utils.Util;

/**
 * @version 1.00 2019/04/10
 * @author 조재훈
 */
public class InputPurchasingMoney {
	private static final String INPUT_GUIDE_MESSAGE = "구입금액을 입력해주세요.";
	private static final String NUMBER_FORMAT_ERROR_MESSAGE = "잘못된 입력 형식입니다";
	private static final int LOTTO_PRICE = 1000;

	public Money getMoney() {
		int inputNumber = 0;
		do {
			System.out.println(INPUT_GUIDE_MESSAGE);
			inputNumber = getUserInput();
		} while (!isInputValid(inputNumber));
		System.out.println();
		return new Money(inputNumber, inputNumber / LOTTO_PRICE);
	}

	private int getUserInput() {
		int userInput = -1;
		try {
			userInput = Integer.valueOf(Util.scanner.nextLine().trim());
		} catch (NumberFormatException e) {
			System.out.println(NUMBER_FORMAT_ERROR_MESSAGE);
		}
		return userInput;
	}

	private boolean isInputValid(int inputNumber) {
		if ((inputNumber > 0) && ((inputNumber % LOTTO_PRICE) == 0)) {
			return true;
		}
		return false;
	}
}
