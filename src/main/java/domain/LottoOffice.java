package domain;

import java.util.HashMap;
import java.util.ArrayList;
import domain.Rank;

public class LottoOffice {
	private static final String STATS_MESSAGE = "\n당첨 통계\n---------";
	private static final String RANK_MESSAGE = "%d개 일치%s(%d원)- %d개\n";
	private static final String BONUS_BALL_MESSAGE = ", 보너스 볼 일치";
	private static final String EARNING_RATE_MESSAGE = "총 수익률은 %.3f입니다.";
	private static final int INDEX_FIFTH_RANK = 4;

	private HashMap<Rank, Integer> rankStats;

	public LottoOffice(WinningLotto winningLotto, ArrayList<Lotto> lottoList) {
		createRankStats();
		updateRankStats(winningLotto, lottoList);
	}

	private void createRankStats() {
		rankStats = new HashMap<Rank, Integer>();
		for (Rank rank : Rank.values()) {
			rankStats.put(rank, 0);
		}
	}

	private void updateRankStats(WinningLotto winningLotto, ArrayList<Lotto> lottoList) {
		for (Lotto lotto : lottoList) {
			Rank matchedRank = winningLotto.match(lotto);
			rankStats.replace(matchedRank, rankStats.get(matchedRank) + 1);
		}
	}

	public void printRankStats() {
		System.out.println(STATS_MESSAGE);

		for (int index = INDEX_FIFTH_RANK; index >= 0; index--) {
			Rank rank = Rank.values()[index];
			String matchBonus = (rank == Rank.SECOND) ? BONUS_BALL_MESSAGE : " ";
			System.out.printf(RANK_MESSAGE, rank.getCountOfMatch(), matchBonus, rank.getWinningMoney(),
					rankStats.get(rank));
		}
	}

	public void printEarningRate(int purchasePrice) {
		Long sum = 0L;
		for (Rank rank : Rank.values()) {
			sum += rankStats.get(rank) * rank.getWinningMoney();
		}

		double earningRate = sum / (double) purchasePrice;
		System.out.printf(EARNING_RATE_MESSAGE, earningRate);
	}
}
