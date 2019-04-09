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

import java.util.HashMap;
import java.util.Map;

/**
 * 당첨 결과를 저장하는 객체
 * 
 * @author wongeunsong
 *
 */
public class Result {
	private int totalCount;
	private Map<Rank, Integer> count = new HashMap<Rank, Integer>();

	public Result() {
		totalCount = 0;
		count.put(Rank.FIRST, 0);
		count.put(Rank.SECOND, 0);
		count.put(Rank.THIRD, 0);
		count.put(Rank.FOURTH, 0);
		count.put(Rank.FIFTH, 0);
		count.put(Rank.MISS, 0);
	}

	public void add(Rank rank) {
		totalCount++;
		count.put(rank, count.get(rank) + 1);
	}
}
