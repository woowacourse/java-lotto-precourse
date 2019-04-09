package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LottoMachine {

	private final int LOTTO_NUM_START = 1;
	private final int LOTTO_NUM_END = 45;
	private final int LOTTO_PRICE = 1000;
	private final int ZERO_WON = 0;
	private final int LOTTO_NUM_SELECT = 6;

	public Lotto user_lotto[];
	private int lottoNum = 0;

	private boolean isFull(List<Integer> numbers) {
		return numbers.size() == LOTTO_NUM_SELECT;
	}

	private boolean isContain(List<Integer> numbers, int num) {
		return numbers.contains(num);
	}

	private int addNum(List<Integer> numbers) {
		int num = (int) (Math.random() * LOTTO_NUM_END + LOTTO_NUM_START);
		while (isContain(numbers, num)) {
			num = (int) (Math.random() * LOTTO_NUM_END + LOTTO_NUM_START);
		}
		return num;
	}

	private List<Integer> randomNumList(List<Integer> numbers) {
		do {
			numbers.add(addNum(numbers));
		} while (!isFull(numbers));
		return numbers;
	}

	private void makeLotto(int lottoNum) {
		user_lotto = new Lotto[lottoNum];
		for (int i = 0; i < lottoNum; ++i) {
			List<Integer> user_nums = new ArrayList<Integer>(LOTTO_NUM_SELECT);
			user_nums = randomNumList(user_nums);
			Collections.sort(user_nums);
			user_lotto[i] = new Lotto(user_nums); // 로또 객체 생성
			System.out.println(user_nums);
		}
	}

	private boolean isInputRight(int money) {
		if (money < ZERO_WON || money % LOTTO_PRICE != ZERO_WON) {
			System.out.println("1000원 단위로 다시 입력해 주세요.");
			return false;
		}
		return true;
	}

	public Lotto[] buyLotto() {
		Scanner in = new Scanner(System.in);
		int money;
		do {
			System.out.println("구입금액을 입력해 주세요.(1000원 단위)");
			money = in.nextInt();
		} while (!isInputRight(money));
		lottoNum = money / LOTTO_PRICE;
		System.out.println(lottoNum + "개를 구매했습니다.");
		makeLotto(lottoNum);
		return user_lotto;
	}

}
