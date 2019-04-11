package domain;

import validation.MoneyValidation;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;

public class Game {
	GameUser gameUser;
	WinningLotto winningLotto;

	public void setMoney(int money) {
		this.gameUser = new GameUser(money);
		int countOfLotto = money / MoneyValidation.MONEY_UNIT;

		for (int i = 0; i < countOfLotto; i++) {
			LottoCombinator lottoCombinator = new LottoCombinator();
			Lotto lotto = lottoCombinator.getLotto();

			this.gameUser.addLotto(lotto);
		}
	}

	public String getLotto() {
		StringBuilder sb = new StringBuilder();
		int countOfLotto = gameUser.countOfLottos();

		sb.append(String.format("%d개를 구매했습니다.\n", countOfLotto));
		for (int i = 0; i < countOfLotto; i++) {
			sb.append(gameUser.getLotto(i).toString()).append("\n");
		}

		return sb.toString();
	}

	public void setWinningLotto(List<Integer> numbers, int bonusNo) {
		Lotto lotto = new Lotto(numbers);
		winningLotto = new WinningLotto(lotto, bonusNo);
	}

	public String getResult() {
		StringBuilder sb = new StringBuilder();
		Map<Rank, Integer> rankCount = calRankCount(initRankCount());

		sb.append("당첨 통계").append("\n")
				.append("---------").append("\n")
				.append(getMatchResult(rankCount))
				.append(String.format("총 수익률은 %.3f 입니다.", getYield(rankCount)))
				.append("\n");

		return sb.toString();
	}

	private Map<Rank, Integer> initRankCount() {
		Map<Rank, Integer> rankCount = new TreeMap<>(Collections.reverseOrder());

		for (Rank rank : Rank.values()) {
			rankCount.put(rank, 0);
		}

		return rankCount;
	}

	private Map<Rank, Integer> calRankCount(Map<Rank, Integer> rankCount) {
		int countOfLotto = gameUser.countOfLottos();

		for (int i = 0; i < countOfLotto; i++) {
			Lotto userLotto = gameUser.getLotto(i);
			Rank rank = winningLotto.match(userLotto);
			rankCount.put(rank, rankCount.get(rank) + 1);
		}

		return rankCount;
	}

	private String getMatchResult(Map<Rank, Integer> rankCount) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("%d개 일치(%d원)-%d개\n", Rank.FIFTH.getCountOfMatch(), Rank.FIFTH.getWinningMoney(), rankCount.get(Rank.FIFTH)));
		sb.append(String.format("%d개 일치(%d원)-%d개\n", Rank.FOURTH.getCountOfMatch(), Rank.FOURTH.getWinningMoney(), rankCount.get(Rank.FOURTH)));
		sb.append(String.format("%d개 일치(%d원)-%d개\n", Rank.THIRD.getCountOfMatch(), Rank.THIRD.getWinningMoney(), rankCount.get(Rank.THIRD)));
		sb.append(String.format("%d개 일치, 보너스 볼 일치(%d원)-%d개\n", Rank.SECOND.getCountOfMatch(), Rank.SECOND.getWinningMoney(), rankCount.get(Rank.SECOND)));
		sb.append(String.format("%d개 일치(%d원)-%d개\n", Rank.FIRST.getCountOfMatch(), Rank.FIRST.getWinningMoney(), rankCount.get(Rank.FIRST)));

		return sb.toString();
	}

	private double getYield(Map<Rank, Integer> rankCount) {
		LongAdder longAdder = new LongAdder();

		rankCount.entrySet().stream()
				.map(entry -> (entry.getKey().getWinningMoney() * entry.getValue()))
				.collect(Collectors.toList())
				.forEach(longAdder::add);

		double yield = longAdder.longValue() / (1.0 * gameUser.getMoney());

		return yield;
	}
}
