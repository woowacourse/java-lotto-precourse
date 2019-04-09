package domain;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.EnumMap;
import java.util.Collections;
import java.util.List;

public class LottoEventJudge {

    private final WinningLotto winningLotto;

    public LottoEventJudge(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public Map<Rank, Integer> judgeLottoEvent(List<Lotto> purchasedLotto) {
        List<Rank> results = new ArrayList<>();
        for (Lotto lotto : purchasedLotto) {
            Rank rank = winningLotto.match(lotto);
            results.add(rank);
        }
        return countEachRankOfEventResult(results);
    }

    public Map<Rank, Integer> countEachRankOfEventResult(List<Rank> lottoEventResult) {
        Map<Rank, Integer> countResult = new EnumMap<>(Rank.class);
        List<Rank> ranks = Arrays.asList(Rank.FIRST, Rank.SECOND,
                Rank.THIRD, Rank.FOURTH, Rank.FIFTH);

        for (Rank rank : ranks) {
            int rankCount = countRank(lottoEventResult, rank);
            countResult.put(rank, rankCount);
        }
        return Collections.unmodifiableMap(countResult);
    }

    private int countRank(List<Rank> lottoEventResult, Rank rank) {
        return (int) lottoEventResult.stream()
                .filter((result) -> result == rank)
                .count();
    }
}
