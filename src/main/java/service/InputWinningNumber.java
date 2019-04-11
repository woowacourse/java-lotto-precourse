package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.Lotto;
import domain.WinningLotto;
import utils.AscendingInteger;
import utils.Util;

/**
 * @version 1.00 2019/04/10
 * @author 조재훈
 */
public class InputWinningNumber {
	private static final String REQ_WINNER_NUMBER = "\n지난 주 당첨 번호를 입력해 주세요.";
	private static final String REQ_WINNER_BONUS = "보너스 볼을 입력해 주세요.";
	public static final int LOTTO_NUMBER_COUNT = 6;
	public static final int LOTTO_NUMBER_LIMIT = 45;
	private List<Integer> winningNumber = new ArrayList<>();
	private int bonusNumber;

	public WinningLotto getWinner() {
		makeWinningNumber();
		makeBonusBall();
		return new WinningLotto(new Lotto(winningNumber), bonusNumber);
	}

	private void makeWinningNumber() {
		receivingStringArray();
		Collections.sort(winningNumber, new AscendingInteger());
	}

	private void receivingStringArray() {
		do {
			winningNumber.clear();
			System.out.println(REQ_WINNER_NUMBER);
		} while (!isValidStringArray());
	}

	private boolean isValidStringArray() {
		boolean checker = false;
		String[] winningInputString = Util.scanner.nextLine().split(",", -1);
		if (winningInputString.length == LOTTO_NUMBER_COUNT) {
			checker = isValidString(winningInputString);
		}
		return checker;
	}

	private boolean isValidString(String[] winningInputString) {
		int i = 0;
		while ((winningNumber.size() < LOTTO_NUMBER_COUNT) && addWinningNumber(winningInputString[i].trim())) {
			i++;
		}
		return (winningNumber.size() < LOTTO_NUMBER_COUNT ? false : true);
	}

	private boolean addWinningNumber(String lottoChar) {
		int convertedInt = isValidInteger(lottoChar);
		if (convertedInt < 0) {
			return false;
		}
		winningNumber.add(convertedInt);
		return true;
	}

	private int isValidInteger(String lottoChar) {
		int result = -1;
		try {
			result = Integer.valueOf(lottoChar);
		} catch (NumberFormatException e) {
			return -1;
		}
		return (isValidScope(result) ? result : -1);
	}

	private boolean isValidScope(int number) {
		if (number > 0 && number <= LOTTO_NUMBER_LIMIT && !winningNumber.contains(number)) {
			return true;
		}
		return false;
	}

	public void makeBonusBall() {
		do {
			System.out.println(REQ_WINNER_BONUS);
		} while (!isValidBonusInput());
	}

	private boolean isValidBonusInput() {
		return isValidBonus(Util.scanner.nextLine().trim());
	}

	private boolean isValidBonus(String bonusString) {
		try {
			bonusNumber = Integer.valueOf(bonusString);
		} catch (NumberFormatException e) {
			return false;
		}
		return isValidScope(bonusNumber);
	}
}
