/*
 * LottoResult.java
 */
package domain;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static domain.LottoConstant.LOTTO_MIN_MONEY;

public class LottoResult {
	List<Lotto> lottoList;
	WinningLotto winningLotto;

	public LottoResult(List<Lotto> lottoList, WinningLotto winningLotto) {
		this.lottoList = lottoList;
		this.winningLotto = winningLotto;
	}

	public Map<Rank, Integer> getMap() {
		Map<Rank, Integer> map = initMap();
		for (Lotto lotto : lottoList) {
			Rank rank = winningLotto.match(lotto);
			map.put(rank, map.get(rank) + 1);
		}
		return map;
	}

	private Map<Rank, Integer> initMap() {
		Map<Rank, Integer> map = new TreeMap<>();
		for (Rank rank : Rank.values()) {
			map.put(rank, 0);
		}
		return map;
	}

	public double getProfitRate() {
		return ((double) getSum() / (getCount() * LOTTO_MIN_MONEY));
	}

	public long getSum() {
		long sum = 0;
		for(Map.Entry<Rank, Integer> entry: getMap().entrySet()) {
			Rank rank = entry.getKey();
			Integer i = entry.getValue();
			sum += (rank.getWinningMoney() * i);
		}
		return sum;
	}

	public int getCount() {
		return lottoList.size();
	}
}
