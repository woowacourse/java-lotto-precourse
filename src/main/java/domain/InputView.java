/*
 * InputView.java
 */

package domain;

import java.util.List;

public class InputView {
	private static final int MIN_MONEY = 1000;
	private static final int LOTTO_MIN_NUMBER = 1;
	private static final int LOTTO_MAX_NUMBER = 45;
	private static final int LOTTO_SIZE= 6;
	private static final Validator VALIDATOR = new Validator(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);

	public int getLottoCount() {
		int money = 0;
		System.out.println("구입금액을 입력해주세요.");
		do {
			money = InputMaker.getInt();
		} while (!isValidMoney(money));
		return (money / 1000);
	}

	private boolean isValidMoney(int money) {
		if (money >= MIN_MONEY) {
			return true;
		}
		System.out.println("1000원 이상의 금액을 입력해주세요.");
		return false;
	}

	public WinningLotto getWinningLotto() {
		List<Integer> numbers = getWinningLottoNums();
		int bonusNum = -1;
		do {
			bonusNum = getBonusNumber();
		} while (VALIDATOR.isDuplicate(numbers, bonusNum));
		return new WinningLotto(new Lotto(numbers), bonusNum);
	}

	public List<Integer> getWinningLottoNums() {
		List<Integer> temp = null;
		do {
			System.out.println("지난 주 당첨번호를 입력해 주세요.");
			temp = InputMaker.getIntegerList();
		} while (!VALIDATOR.isValidNumbers(temp) || !VALIDATOR.isValidSize(temp) || VALIDATOR.isDuplicate(temp));
		return temp;
	}

	public int getBonusNumber() {
		System.out.println("보너스 볼을 입력해주세요");
		return InputMaker.getInt();
	}
}
