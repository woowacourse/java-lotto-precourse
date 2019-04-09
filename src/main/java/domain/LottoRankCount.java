package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoRankCount {
    private Map<Rank, Integer> rankCount;

    LottoRankCount() {
        rankCount = new HashMap<>();
        Arrays.stream(Rank.values()).forEach(rank -> rankCount.put(rank, 0));
    }

    void put(Rank rank) {
        rankCount.put(rank, rankCount.get(rank) + 1);
    }

    public int getCount(Rank rank) {
        return rankCount.get(rank);
    }
}
