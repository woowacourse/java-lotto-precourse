package com.molt3nrock.lotto;

import java.util.List;
import java.util.Map;

public class Statistics {

    private Map<Rank, Integer> rankState;

    private Statistics(Map<Rank, Integer> rankState) {
        this.rankState = rankState;
    }

    public static Statistics valueOf(List<Lotto> lottoList, WinningLotto winningLotto) {
        return null;
    }
}
