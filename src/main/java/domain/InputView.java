/*
 * InputView.java
 */

package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
	private static final int MIN_MONEY = 1000;

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

	public List<Integer> getWinningLotto() {
		System.out.println("지난 주 당첨번호를 입력해 주세요.");
		return Parser.getStringList(InputMaker.getString())
				.stream()
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}

	public int getBonusNumber() {
		System.out.println("보너스 볼을 입력해주세요");
		return InputMaker.getInt();
	}
}
