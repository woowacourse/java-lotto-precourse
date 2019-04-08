/*
 * InputView.java
 */

package logic;

import domain.Lotto;
import domain.WinningLotto;
import util.DuplicateValidator;
import util.InputUtil;
import util.NumberValidator;
import util.SizeValidator;

import java.util.List;

import static domain.LottoConstant.*;

class InputView {
	private static final NumberValidator NUMBER_VALIDATOR = new NumberValidator(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER);
	private static final DuplicateValidator DUPLICATE_VALIDATOR = new DuplicateValidator();
	private static final SizeValidator SIZE_VALIDATOR = new SizeValidator(LOTTO_SIZE);

	public int getLottoCount() {
		int money;
		System.out.println("구입금액을 입력해주세요.");
		do {
			money = InputUtil.getInt();
		} while (!isValidMoney(money));
		return (money / LOTTO_MIN_MONEY);
	}

	private boolean isValidMoney(int money) {
		if (money >= LOTTO_MIN_MONEY) {
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
		} while (DUPLICATE_VALIDATOR.isDuplicate(numbers, bonusNum) || !NUMBER_VALIDATOR.isValidNumber(bonusNum));
		return new WinningLotto(new Lotto(numbers), bonusNum);
	}

	public List<Integer> getWinningLottoNums() {
		List<Integer> temp = null;
		do {
			System.out.println("지난 주 당첨번호를 입력해 주세요.");
			temp = InputUtil.getIntegerList();
		} while (!NUMBER_VALIDATOR.isValidNumbers(temp) || !SIZE_VALIDATOR.isValidSize(temp)
				|| DUPLICATE_VALIDATOR.isDuplicate(temp));
		return temp;
	}

	public int getBonusNumber() {
		System.out.println("보너스 볼을 입력해주세요");
		return InputUtil.getInt();
	}
}
