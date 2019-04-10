package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CompareNums {

	private final int LOTTO_NUM_START = 1;
	private final int LOTTO_NUM_END = 45;
	private final int LOTTO_NUM_SELECT = 6;
	private final int LOTTO_WINNING_CASE = 6;
	private final int FIRST = 0;
	private final int SECOND = 1;
	private final int THIRD = 2;
	private final int FOURTH = 3;
	private final int FIFTH = 4;
	private final int MISS = 5;

	private Lotto[] userLotto;
	private List<Integer> winNums_int = new ArrayList<Integer>(LOTTO_NUM_SELECT);

	static Scanner in = new Scanner(System.in);

	public CompareNums(Lotto[] userLotto) {
		this.userLotto = userLotto;
	}

	private boolean outOfRangeBonusBall(int bonusBall) {
		if (bonusBall < LOTTO_NUM_START || bonusBall > LOTTO_NUM_END) {
			System.out.println("범위를 벗어난 보너스 숫자 입니다. 다시 입력해 주세요.");
			return true;
		}
		return false;
	}

	private boolean bonusNumOverlap(int bonusBall) {
		if (winNums_int.contains(bonusBall)) {
			System.out.println("보너스 번호가 당첨번호와 중복됩니다.");
			return true;
		}
		return false;
	}

	private int bonusNumber() {
		int bonusBall;
		do {
			System.out.println("보너스 볼을 입력해 주세요.");
			bonusBall = in.nextInt();
		} while (outOfRangeBonusBall(bonusBall) || bonusNumOverlap(bonusBall));
		return bonusBall;
	}

	private boolean isSizeSix() {
		if (winNums_int.size() != LOTTO_NUM_SELECT) {
			System.out.println("당첨 번호는 6개입니다. 다시 입력해 주세요.");
			winNums_int.clear();
			return true;
		}
		return false;
	}

	private boolean rangeCheck(int num) {
		if (num < LOTTO_NUM_START || num > LOTTO_NUM_END) {
			System.out.println("범위를 벗어난 당첨번호 입니다. 다시 입력해 주세요.");
			winNums_int.clear();
			return true;
		}
		return false;
	}

	private boolean overlap(int num1, int num2) {
		if (num1 == num2) {
			System.out.println("중복된 번호가 있습니다. 다시 입력해 주세요.");
			winNums_int.clear();
			return true;
		}
		return false;
	}

	private boolean isOverlap() {
		boolean state = false;
		for (int i = 0; i < winNums_int.size() - 1; ++i) {
			state = state || overlap(winNums_int.get(i), winNums_int.get(i + 1));
		}
		return state;
	}

	private boolean outOfRange() {
		boolean state = false;
		for (int i = 0; i < winNums_int.size(); ++i) {
			state = state || rangeCheck(winNums_int.get(i));
		}
		return state;
	}

	private void stringToInteger(List<String> winNums_string) {
		for (String s : winNums_string) {
			winNums_int.add(Integer.parseInt(s));
		}
	}

	private boolean errorCatch(List<String> winNums_string) {
		try {
			stringToInteger(winNums_string);
		} catch (NumberFormatException e) {
			System.out.println("유효하지 않은 당첨 번호 입니다. 다시 입력해 주세요.");
			winNums_int.clear();
			return true;
		}
		return false;
	}

	private boolean isWinningNumberRight(String winNum) {
		List<String> winNums_string = new ArrayList<String>(LOTTO_NUM_SELECT);
		winNums_string = Arrays.asList(winNum.split(","));
		if (errorCatch(winNums_string))
			return false;
		if (isSizeSix())
			return false;
		return true;
	}

	private List<Integer> winningNumber() {
		String winNum;
		do {
			System.out.println("지난 주 당첨 번호를 입력해 주세요.( 6개, 쉼표(,)로 구분 )");
			winNum = in.nextLine();
		} while (!isWinningNumberRight(winNum) || outOfRange() || isOverlap());
		System.out.println(winNums_int);
		return winNums_int;
	}

	public void makeWinningLotto() {
		Lotto winning = new Lotto(winningNumber());
		WinningLotto winningLotto = new WinningLotto(winning, bonusNumber());
		int winTable[] = new int[LOTTO_WINNING_CASE];
		for (Lotto lotto : userLotto) {
			Rank rank = winningLotto.match(lotto);
			winTable[countWin(rank)]++;
		}
		Rank rank[] = { Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST };
		printStats(rank, winTable);
	}

	private int countWin(Rank rank) {
		HashMap<Rank, Integer> rankH = new HashMap<Rank, Integer>();
		rankH.put(Rank.FIRST, FIRST);
		rankH.put(Rank.SECOND, SECOND);
		rankH.put(Rank.THIRD, THIRD);
		rankH.put(Rank.FOURTH, FOURTH);
		rankH.put(Rank.FIFTH, FIFTH);
		rankH.put(Rank.MISS, MISS);

		return rankH.get(rank);
	}

	private void printStats(Rank rank[], int[] winTable) {
		System.out.println("당첨 통계\n----------");
		int winningMoney = 0;
		for (Rank r : rank) {
			winningMoney += (r.getWinningMoney() * winTable[countWin(r)]);
			System.out.println(String.format("%d개 일치%s(%d원) - %d개", r.getCountOfMatch(),
					r.equals(Rank.SECOND) ? ", 보너스 볼 일치 " : " ", r.getWinningMoney(), winTable[countWin(r)]));
		}
		double yield = (double) winningMoney / (double) (userLotto.length * 1000);
		System.out.println(String.format("총 수익률은 %.3f 입니다.", yield));
	}

}
