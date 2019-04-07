package domain;

import java.util.Scanner;

public class LottoMain {

	static Scanner in = new Scanner(System.in);
	static final int LOTTO_NUM_START = 1;
	static final int LOTTO_NUM_END = 45;
	static final int LOTTO_PRICE = 1000;
	static final int ZERO_WON = 0;

	static int buyLotto() {
		while (true) {
			System.out.println("구입금액을 입력해 주세요.");
			int money = in.nextInt();
			if (money < ZERO_WON || money % LOTTO_PRICE != ZERO_WON) {
				System.out.println("1000원 단위로 다시 입력해 주세요.");
				continue;
			}
			return money / LOTTO_PRICE;
		}
	}
	
	public static void main(String[] args) {
		int lottoNum = buyLotto();
		System.out.println(lottoNum + "개를 구매했습니다.");
	}
}
