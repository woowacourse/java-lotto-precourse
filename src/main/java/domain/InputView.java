/*
 * InputView.java
 */

package domain;

public class InputView {
	private static final int MIN_MONEY = 1000;

	public int getMoney() {
		int money = 0;
		System.out.println("구입금액을 입력해주세요");
		do {
			money = InputMaker.getInt();
		} while (!isValidMoney(money));
		return money;
	}

	private boolean isValidMoney(int money) {
		if (money >= MIN_MONEY) {
			return true;
		}
		System.out.println("1000원 이상의 금액을 입력해주세요");
		return false;
	}
}
