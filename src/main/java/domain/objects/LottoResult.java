/*
 * Lotto Class
 *
 * @version 1.1
 *
 * @date 2019-04-11
 *
 * Copyright (c) 2019. JIhun oh
 * All rights reserved.
 */
package domain.objects;

import java.util.HashMap;
import java.util.Map;

import static domain.objects.Rank.FIRST;
import static domain.objects.Rank.SECOND;

public class LottoResult {
    private Map<Rank, Integer> content;

    public LottoResult() {
        content = new HashMap<>();
        for (Rank rank : Rank.values()) {
            content.put(rank, 0);
        }
    }

    public void put(Rank rank) {
        content.put(rank, content.get(rank) + 1);
    }

    public Integer getRankCount(Rank rank) {
        return content.get(rank);
    }

    public long getTotalYield() {
        long totalMoney = 0;
        for (Rank rank : Rank.values()) {
            totalMoney += (long) rank.getWinningMoney() * content.get(rank);
        }
        return totalMoney;
    }

    public int getLottoCount(){
        int count =0;
        for(Rank rank :Rank.values()){
            count += content.get(rank);
        }
        return count;
    }

    public double getYieldRate() {
        long totalMoney = getTotalYield();
        int lottoCount = getLottoCount();

        return (double) totalMoney / (lottoCount*Lotto.UNIT_PRICE);
    }
}
