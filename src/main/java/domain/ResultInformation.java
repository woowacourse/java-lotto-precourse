package domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class ResultInformation {
    private List<Rank> ranks;
    private EnumMap<Rank, Integer> enumMap;

    private static final int MIN_MONEY = 1000;

    public ResultInformation(List<Lotto> lottos, WinningLotto winningLotto) {
        this.ranks = matchLottosAndWinningLotto(lottos, winningLotto);
        this.enumMap = createEnumMap();
    }

    private List<Rank> matchLottosAndWinningLotto(List<Lotto> lottos, WinningLotto winningLotto) {
        List<Rank> rankList = new ArrayList<>();

        for (Lotto lotto : lottos) {
            rankList.add(winningLotto.match(lotto));
        }

        return rankList;
    }

    private EnumMap<Rank, Integer> initialEnumMap() {
        EnumMap<Rank, Integer> initialMap = new EnumMap<>(Rank.class);

        for (Rank type : Rank.values()) {
            initialMap.put(type, 0);
        }

        return initialMap;
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
