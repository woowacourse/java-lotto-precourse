package service;

import java.util.List;

import domain.Lotto;
import domain.Money;
import domain.Rank;
import domain.WinningLotto;

/**
 * @version 1.00 2019/04/11
 * @author 조재훈
 */
public class RankCounter {
	private static final String[] STAT_LEVEL = {"6개 일치 (2000000000원)- %d개",
												"5개 일치, 보너스 볼 일치 (30000000원)- %d개",
												"5개 일치 (1500000원)- %d개",
												"4개 일치 (50000원)- %d개",
												"3개 일치 (5000원)- %d개"};
	private static final String STAT_WINNER = "\n당첨 통계\n---------";
	private static final String STAT_RESULT = "총 수익률은 %.3f입니다.";
	private Rank[] rank;
	private int[] rankCount;
	private int money;

	public RankCounter(WinningLotto winningLotto, LottoGenerator lottoGenerator, Money money) {
		this.rank = Rank.values();
		this.rankCount = new int[rank.length];
		this.money = money.getMoney();
		List<Lotto> soldLottos = lottoGenerator.getSoldLottos();
		for (int i = 0; i < soldLottos.size(); i++) {
			setRankCount(winningLotto.match(soldLottos.get(i)));
		}
	}

	private void setRankCount(Rank userRank) {
		for (int i = 0; i < rank.length; i++) {
			if (rank[i].equals(userRank)) {
				rankCount[i]++;
				return;
			}
		}
	}

	private double calResult() {
		double sum = 0;
		for (int i = 0; i < rank.length; i++) {
			sum += (rankCount[i] * rank[i].getWinningMoney());
		}
		return (sum/money);
	}

	public void printResult() {
		System.out.println(STAT_WINNER);
		for (int i = rank.length - 2; i >= 0; i--) {
			System.out.println(String.format(STAT_LEVEL[i], rankCount[i]));
		}
		System.out.println(String.format(STAT_RESULT, calResult()));
	}
}
