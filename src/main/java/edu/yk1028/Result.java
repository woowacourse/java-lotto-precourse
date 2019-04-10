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
	private final String TOTAL_YIELD = "총 수익률은 %.1f입니다.";

	private int totalCount;
	private Map<Rank, Integer> count = new TreeMap<Rank, Integer>(Comparator.reverseOrder());

	public Result() {
		totalCount = 0;
		count.put(Rank.FIRST, 0);
		count.put(Rank.SECOND, 0);
		count.put(Rank.THIRD, 0);
		count.put(Rank.FOURTH, 0);
		count.put(Rank.FIFTH, 0);
	}

	public void add(Rank rank) {
		totalCount++;
		if (rank != Rank.MISS) {
			count.put(rank, count.get(rank) + 1);
		}
	}

	public double calculateYield() {
		return (double) calculateTotalMoney() / (double) (totalCount * LottoConstant.LOTTO_PRICE);
	}

	private long calculateTotalMoney() {
		long money = 0;
		
		for (Rank rank : count.keySet()) {
			money += count.get(rank) * rank.getWinningMoney();
		}
		return money;
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
