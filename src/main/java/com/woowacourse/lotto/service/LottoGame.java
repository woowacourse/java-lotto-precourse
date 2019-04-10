/*
 *  클래스 이름 : LottoGame.java
 *
 *  버전 정보 : 1.0.0
 *
 *  날짜 : 2019-04-07
 *
 *  저작권 : 이예지
 */
package com.woowacourse.lotto.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.woowacourse.lotto.domain.Lotto;
import com.woowacourse.lotto.domain.LottoFactory;
import com.woowacourse.lotto.domain.Rank;
import com.woowacourse.lotto.domain.WinningLotto;

public class LottoGame {
	static final String PRINT_USER_LOTTO_COUNT = "%s개를 구매하셨습니다.\n";
	static final String PRINT_RANK_RESULT =
			"당첨 통계\n-------\n\n3개 일치 (5000원)- %d개\n4개 일치 (50000원)- %d개\n" +
					"5개 일치 (1500000원)-%d개\n5개 일치, 보너스 볼 일치 (30000000원)-%d개\n" +
					"6개 일치 (2000000000원)-%d개";

	private List<Lotto> lottoList;
	private LottoFactory lottoFactory;
	private UserInput userInput;

	public LottoGame() {
		lottoFactory = new LottoFactory();
		userInput = new UserInput();
	}

	private void getLottoList() {
		int lottoAmount = userInput.getPurchasingAmount();
		this.lottoList = lottoFactory.createLottoList(lottoAmount);
	}

	private void printLottoList() {
		System.out.printf(PRINT_USER_LOTTO_COUNT, lottoList.size());
		for (Lotto lotto : lottoList) {
			System.out.println(lotto);
		}
	}

	private WinningLotto getWinningLotto() {
		Lotto lotto = new Lotto(new ArrayList<>(userInput.getWinningNumber()));
		WinningLotto winningLotto = new WinningLotto(lotto, userInput.getBonusBall(lotto));
		return winningLotto;
	}

	private void getRankList(WinningLotto winningLotto) {
		List<Rank> rankResult = new ArrayList<>();
		for (Lotto lotto : lottoList) {
			rankResult.add(winningLotto.match(lotto));
		}
		printRankResult(rankResult);
	}

	private Map<Rank, Integer> getRankMap() {
		Map<Rank, Integer> rankMap = new HashMap<>();
		rankMap.put(Rank.FIRST, 0);
		rankMap.put(Rank.SECOND, 0);
		rankMap.put(Rank.THIRD, 0);
		rankMap.put(Rank.FOURTH, 0);
		rankMap.put(Rank.FIFTH, 0);
		rankMap.put(Rank.MISS, 0);
		return rankMap;
	}

	private void printRankResult(List<Rank> rankResult) {
		Map<Rank, Integer> rankCountMap = getRankMap();

		for (Rank rank : rankResult) {
			countRank(rank, rankCountMap);
		}
		System.out.printf(PRINT_RANK_RESULT, rankCountMap.get(Rank.FIFTH), rankCountMap.get(Rank.FOURTH), rankCountMap.get(Rank.THIRD),
				rankCountMap.get(Rank.SECOND), rankCountMap.get(Rank.FIRST));
	}

	private void countRank(Rank rank, Map<Rank, Integer> rankCountMap) {
		int count = rankCountMap.get(rank);
		rankCountMap.put(rank, ++count);
	}

	public void start() {
		getLottoList();
		printLottoList();
		getRankList(getWinningLotto());
	}
}
