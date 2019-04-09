package domain;

import java.util.EnumMap;
import java.util.List;

public class ResultInformation {
    private List<Rank> ranks;
    private EnumMap<Rank, Integer> enumMap;

    private static final int MIN_MONEY = 1000;

    public ResultInformation(List<Rank> ranks) {
        this.ranks = ranks;
        this.enumMap = createEnumMap();
    }

    private EnumMap<Rank, Integer> initialEnumMap() {
        EnumMap<Rank, Integer> initalMap = new EnumMap<>(Rank.class);

        for (Rank type : Rank.values()) {
            initalMap.put(type, 0);
        }

        return initalMap;
    }

    private EnumMap<Rank, Integer> createEnumMap() {
        EnumMap<Rank, Integer> map = initialEnumMap();
        int cnt;

        for (Rank rank : ranks) {
            cnt = map.get(rank);
            map.put(rank, ++cnt);
        }

        return map;
    }

    int getRankCount(Rank type) {
        return enumMap.get(type);
    }

    float getProfitRate() {
        int reward = 0;

        for (Rank rank : Rank.values()) {
            reward += rank.getWinningMoney() * enumMap.get(rank);
        }

        return ((float) reward / (ranks.size() * MIN_MONEY));
    }
}
