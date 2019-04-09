package com.molt3nrock.lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Statistics {

    private Map<Rank, Integer> rankState;

    private Statistics(Map<Rank, Integer> rankState) {
        this.rankState = rankState;
    }

    static Statistics valueOf(List<Lotto> lottoList, WinningLotto winningLotto) {
        HashMap<Rank, Integer> hashMap = new HashMap<>();
        Arrays.asList(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH, Rank.MISS)
            .forEach(rank -> hashMap.putIfAbsent(rank, 0));
        Statistics statistics = new Statistics(hashMap);
        lottoList.forEach(lotto -> statistics.classifyLotto(lotto, winningLotto));
        return statistics;
    }

    int numberOfRank(Rank rank) {
        assert(rankState.containsKey(rank));
        return rankState.get(rank);
    }

    private void classifyLotto(Lotto lotto, WinningLotto winningLotto) {
        Rank rank = winningLotto.match(lotto);
        rankState.computeIfPresent(rank, (rankKey, count) -> count + 1);
    }

}
