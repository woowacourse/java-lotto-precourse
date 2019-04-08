/*
 * LottoResult.java
 */
package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static domain.LottoConstant.*;

public class LottoResult {
	// 한 로또 게임의 결과를 저장하고 관리하는 클래스
	List<Lotto> lottoList;
	WinningLotto winningLotto;

	public LottoResult(List<Lotto> lottoList, WinningLotto winningLotto) {
		this.lottoList = lottoList;
		this.winningLotto = winningLotto;
	}

	public void printStatResult() {
		Map<Rank, Integer> map = makeMap();
		map.forEach((key, value) -> System.out.println(key.toString() + value + "개"));
	}

	private Map<Rank, Integer> makeMap() {
		Map<Rank, Integer> map = initMap();
		for (Lotto lotto : lottoList) {
			Rank rank = winningLotto.match(lotto);
			map.put(rank, map.get(rank) + 1);
		}
		map.remove(Rank.MISS);
		return map;
	}

	private Map<Rank, Integer> initMap() {
		Map<Rank, Integer> map = new HashMap<>();
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
		for(Map.Entry<Rank, Integer> test: makeMap().entrySet()) {
			Rank rank = test.getKey();
			Integer i = test.getValue();
			sum += (rank.getWinningMoney() * i);
		}
		return sum;
	}

	public int getCount() {
		return lottoList.size();
	}
}
