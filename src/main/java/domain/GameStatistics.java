package domain;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;

/**
 * GameStatistics 객체 로또 게임결과의 통계를 담당한다.
 *
 * @author 조남균
 */
public class GameStatistics {
	private Map<Rank, Integer> rankCount;

	GameStatistics() {
		this.rankCount = new TreeMap<>(Collections.reverseOrder());

		for (Rank rank : Rank.values()) {
			rankCount.put(rank, 0);
		}
	}

	void calRankCount(GameUser gameUser, WinningLotto winningLotto) {
		int countOfLotto = gameUser.countOfLotto();

		for (int i = 0; i < countOfLotto; i++) {
			Lotto userLotto = gameUser.getLotto(i);
			Rank rank = winningLotto.match(userLotto);
			rankCount.put(rank, rankCount.get(rank) + 1);
		}
	}

	public int countOfWinningNumber(Rank rank) {
		return rankCount.get(rank);
	}

	public double getYield(GameUser gameUser) {
		LongAdder longAdder = new LongAdder();

		rankCount.entrySet().stream()
				.map(entry -> (long) (entry.getKey().getWinningMoney() * entry.getValue()))
				.collect(Collectors.toList())
				.forEach(longAdder::add);

		return longAdder.longValue() / (1.0 * gameUser.getMoney());
	}
}
