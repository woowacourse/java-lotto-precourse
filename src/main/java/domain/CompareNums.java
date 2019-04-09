package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CompareNums {

	private final int LOTTO_NUM_SELECT = 6;
	private final int LOTTO_WINNING_CASE = 6;
	private final int FIRST = 0;
	private final int SECOND = 1;
	private final int THIRD = 2;
	private final int FOURTH = 3;
	private final int FIFTH = 4;
	private final int MISS = 5;

	private Lotto[] userLotto;
	private List<Integer> winNums_int; // 당첨번호

	static Scanner in = new Scanner(System.in);

	public CompareNums(Lotto[] userLotto) {
		this.userLotto = userLotto;
	}

	public boolean isBonusNumberRight(int bonusBall) {
		if (bonusBall < 1 || bonusBall > 45) {
			System.out.println("유효하지 않은 보너스 숫자 입니다. 다시 입력해 주세요.");
			return false;
		}
		return true;
	}

	public int bonusNumber() {
		int bonusBall;
		do {
			System.out.println("보너스 볼을 입력해 주세요.");
			bonusBall = in.nextInt();
		} while (!isBonusNumberRight(bonusBall));
		return bonusBall;
	}

	public List<Integer> winningNumber() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.( 6개, 쉼표(,)로 구분 )");
		List<String> winNums_string = new ArrayList<String>(LOTTO_NUM_SELECT);
		String winNum = in.nextLine();
		winNums_string = Arrays.asList(winNum.split(","));
		winNums_int = new ArrayList<Integer>(LOTTO_NUM_SELECT);
		for (String s : winNums_string)
			winNums_int.add(Integer.parseInt(s));
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

	public int countWin(Rank rank) {
		HashMap<Rank, Integer> rankH = new HashMap<Rank, Integer>();
		rankH.put(Rank.FIRST, FIRST);
		rankH.put(Rank.SECOND, SECOND);
		rankH.put(Rank.THIRD, THIRD);
		rankH.put(Rank.FOURTH, FOURTH);
		rankH.put(Rank.FIFTH, FIFTH);
		rankH.put(Rank.MISS, MISS);

		return rankH.get(rank);
	}

	public void printStats(Rank rank[], int[] winTable) {
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
