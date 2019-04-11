/*
 * Result
 * 
 * version 1.0
 * 
 * 2019. 4. 9
 * 
 * Created by Wongeun Song
 */
package edu.yk1028;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 당첨 결과를 저장하는 객체
 * 
 * @author wongeunsong
 *
 */
public class Result {
	private final String WINNING_RESULT = "\n당첨 통계\n---------";
	private final String TOTAL_YIELD = "총 수익률은 %.3f입니다.";

	private long totalCount;
	private Map<Rank, Long> count = new TreeMap<Rank, Long>(Comparator.reverseOrder());

	public Result() {
		totalCount = 0L;
		count.put(Rank.FIRST, 0L);
		count.put(Rank.SECOND, 0L);
		count.put(Rank.THIRD, 0L);
		count.put(Rank.FOURTH, 0L);
		count.put(Rank.FIFTH, 0L);
	}

	public void add(Rank rank) {
		totalCount++;
		if (rank != Rank.MISS) {
			count.put(rank, count.get(rank) + 1);
		}
	}

	public double calculateYield() {
		double yield = 0;
		for (Rank rank : count.keySet()) {
			yield += rank.getWinningMoney() * (count.get(rank) / (double) totalCount) 
					/ LottoConstant.LOTTO_PRICE;
		}
		return yield;
	}

	public void print() {
		System.out.println(WINNING_RESULT);
		for (Rank rank : count.keySet()) {
			rank.print();
			System.out.println(count.get(rank) + "개");
		}
		System.out.println(String.format(TOTAL_YIELD, calculateYield()));
	}

}
