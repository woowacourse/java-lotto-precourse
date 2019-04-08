/*
 * InputView.java
 */

package domain;

import util.DuplicateValidator;
import util.NumberValidator;
import util.SizeValidator;
import util.Validator;
import java.util.List;

public class InputView {
	private static final int MIN_MONEY = 1000;
	private static final int LOTTO_MIN_NUMBER = 1;
	private static final int LOTTO_MAX_NUMBER = 45;
	private static final int LOTTO_SIZE = 6;
	private static final NumberValidator NUMBER_VALIDATOR = new NumberValidator(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER);
	private static final DuplicateValidator DUPLICATE_VALIDATOR = new DuplicateValidator();
	private static final SizeValidator SIZE_VALIDATOR = new SizeValidator(LOTTO_SIZE);

	public int getLottoCount() {
		int money;
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
		int bonusNum;
		do {
			bonusNum = getBonusNumber();
		} while (DUPLICATE_VALIDATOR.isDuplicate(numbers, bonusNum));
		return new WinningLotto(new Lotto(numbers), bonusNum);
	}

	public List<Integer> getWinningLottoNums() {
		List<Integer> temp = null;
		do {
			System.out.println("지난 주 당첨번호를 입력해 주세요.");
			temp = InputMaker.getIntegerList();
		} while (!NUMBER_VALIDATOR.isValidNumbers(temp) || !SIZE_VALIDATOR.isValidSize(temp)
				|| DUPLICATE_VALIDATOR.isDuplicate(temp));
		return temp;
	}

	public int getBonusNumber() {
		System.out.println("보너스 볼을 입력해주세요");
		return InputMaker.getInt();
	}
}
