package domain;

import lotto.Rank;

import java.util.List;
import java.util.TreeMap;

public class State {
    public TreeMap<Rank, Long> statsLottoResult(List<Rank> ranks) {
        TreeMap<Rank, Long> stats = new TreeMap<>();

        for (Rank value : Rank.values()) {
            stats.put(value, ranks.stream().filter(rank -> rank == value).count());
        }

        return stats;
    }
}