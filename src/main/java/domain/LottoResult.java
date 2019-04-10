/*
 * LottoResult.java
 */

package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static domain.LottoConstant.LOTTO_MIN_MONEY;

public class LottoResult {
	private static final int ZERO = 0;

	private List<Lotto> lottoList;
	private WinningLotto winningLotto;

	public LottoResult(List<Lotto> lottoList, WinningLotto winningLotto) {
		this.lottoList = lottoList;
		this.winningLotto = winningLotto;
	}

	public double getProfitRate() {
		return ((double) getSum() / (getCount() * LOTTO_MIN_MONEY));
	}

	private long getSum() {
		long sum = 0;
		for (Map.Entry<Rank, Integer> entry : getMap().entrySet()) {
			Rank rank = entry.getKey();
			Integer buyCount = entry.getValue();
			sum += (rank.getWinningMoney() * buyCount);
		}
		return sum;
	}

	private int getCount() {
		return lottoList.size();
	}

	public Map<Rank, Integer> getMap() {
		Map<Rank, Integer> map = initMap();
		for (Lotto lotto : lottoList) {
			Rank rank = winningLotto.match(lotto);
			map.computeIfPresent(rank, (Rank key, Integer value) -> ++value);
		}
		return map;
	}

	private Map<Rank, Integer> initMap() {
		Map<Rank, Integer> map = new HashMap<>();
		for (Rank rank : Rank.values()) {
			map.putIfAbsent(rank, ZERO);
		}
		return map;
	}
}
