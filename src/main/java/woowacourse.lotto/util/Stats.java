/*
 * Stats.java
 * version 1.0
 * 2019.04.11
 * Copyright (c) 2019 Hyunji Choi
 * This program is made available under the terms of the MIT License.
 */

package woowacourse.lotto.util;

import java.util.ArrayList;
import java.util.HashMap;

public class Stats {
    private static final String RANK_FORMAT_STRING =
            "당첨 통계\n"
            + "---------\n"
            + "3개 일치 (5000원)- %d개\n"
            + "4개 일치 (50000원)- %d개\n"
            + "5개 일치 (1500000원)- %d개\n"
            + "5개 일치, 보너스 볼 일치(30000000원) - %d개\n"
            + "6개 일치 (2000000000원)- %d개\n";
    private static final String YIELD_FORMAT_STRING =
            "총 수익률은 %.3f입니다.\n";
    private HashMap<Rank, Integer> countOfRank = new HashMap<>();

    void printRankCount(ArrayList<Rank> matchedRanks) {
        updateRankCount(matchedRanks);
        System.out.format(RANK_FORMAT_STRING,
                countOfRank.get(Rank.FIFTH),
                countOfRank.get(Rank.FOURTH),
                countOfRank.get(Rank.THIRD),
                countOfRank.get(Rank.SECOND),
                countOfRank.get(Rank.FIRST));
    }

    private void updateRankCount(ArrayList<Rank> matchedRanks) {
        for(Rank type : Rank.values()) {
            countOfRank.put(type, 0);
        }
        for(Rank r : matchedRanks) {
            countOfRank.put(r, countOfRank.get(r) + 1);
        }
    }

    void calYield(int totalPrice) {
        double yield = calTotalWinningMoney() / totalPrice;
        System.out.format(YIELD_FORMAT_STRING, yield);
    }

    private long calTotalWinningMoney() {
        long totalWinningMoney = 0;
        for(Rank type : Rank.values()) {
            totalWinningMoney += countOfRank.get(type)
                    * type.getWinningMoney();
        }
        return totalWinningMoney;
    }
}
