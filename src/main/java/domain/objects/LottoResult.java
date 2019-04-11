/*
 * Lotto Class
 *
 * @version 2
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

/**
 * 로또 결과를 의미하는 객체
 * 번호 비교 결과인 Rank 를 Rank 마다 카운트한다.
 */
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

    private long getTotalMoney() {
        long totalMoney = 0;

        for (Rank rank : Rank.values()) {
            totalMoney += (long) rank.getWinningMoney() * content.get(rank);
        }
        return totalMoney;
    }

    private int getTotalLottoCount() {
        int count = 0;

        for (Rank rank : Rank.values()) {
            count += content.get(rank);
        }
        return count;
    }

    public double getYieldRate() {
        long totalMoney = getTotalMoney();
        int totalLotCount = getTotalLottoCount();

        return (double) totalMoney / (totalLotCount * Lotto.UNIT_PRICE);
    }
}
