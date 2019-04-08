package domain;

import java.util.Scanner;

public class LottoMachine {
	static Scanner in = new Scanner(System.in);

	private final int LOTTO_NUM_START = 1;
	private final int LOTTO_NUM_END = 45;
	private final int LOTTO_PRICE = 1000;
	private final int ZERO_WON = 0;

	private boolean isInputRight(int money) {
		if (money < ZERO_WON || money % LOTTO_PRICE != ZERO_WON) {
			System.out.println("1000원 단위로 다시 입력해 주세요.");
			return false;
		}
		return true;
	}

	public int buyLotto() {
		int money;
		do {
			System.out.println("구입금액을 입력해 주세요.(1000원 단위)");
			money = in.nextInt();
		} while (!isInputRight(money));
		int lottoNum = money / LOTTO_PRICE;
		System.out.println(lottoNum + "개를 구매했습니다.");
		return lottoNum;
	}

}
