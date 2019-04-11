/*
 * StatsCalculationTest.java
 * version 1.0
 * 2019.04.11
 * Copyright (c) 2019 Hyunji Choi
 * This program is made available under the terms of the MIT License.
 */

package woowacourse.lotto.util;

import java.util.ArrayList;
import java.util.List;

public class StatsCalculationTest extends DefaultTest {

    /**
     * @param args [0] count of Rank 5, 4, 3, 2, 1
     *             [1] mock of total price user paid
     *             [2] expected yield
     */
    @Override
    public void test(String[] args) {
        ArrayList<Rank> matchedRanks = new ArrayList<>();
        saveRankCount(matchedRanks, args[0]);
        Stats stats = new Stats();
        stats.printRankCount(matchedRanks);
        stats.calYield(Integer.valueOf(args[1]));
        String yield = String.format("%.3f", stats.yield);
        if (yield.equals(args[2])) {
            correctAnswer++;
        }
        testCount++;
    }

    private void saveRankCount(ArrayList<Rank> matchedRanks, String args) {
        List<Integer> rankCountInt = new ArrayList<>();
        String[] rankCount = args.split("\\,");
        for (String s : rankCount) {
            rankCountInt.add(Integer.valueOf(s));
        }
        addRank(matchedRanks, rankCountInt.get(0), Rank.FIFTH);
        addRank(matchedRanks, rankCountInt.get(1), Rank.FOURTH);
        addRank(matchedRanks, rankCountInt.get(2), Rank.THIRD);
        addRank(matchedRanks, rankCountInt.get(3), Rank.SECOND);
        addRank(matchedRanks, rankCountInt.get(4), Rank.FIRST);
    }

    private void addRank(ArrayList<Rank> matchedRanks, int times, Rank type) {
        for (int i = 0; i < times; i++) {
            matchedRanks.add(type);
        }
    }
}
