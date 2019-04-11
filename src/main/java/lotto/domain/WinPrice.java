package lotto.domain;

import java.util.HashMap;
import java.util.List;

/**
 * 로또 등수별 당첨 횟수를 구하는 객체
 */
public class WinPrice {
    private HashMap<Rank, Integer> winPrices;

    public WinPrice() {
        winPrices = new HashMap<>();
        for (Rank rank : Rank.values())
            winPrices.put(rank, 0);
    }

    public void addWinCount(List<Rank> ranks) {
        for (Rank rank : ranks)
            addWinCount(rank);
    }

    public void addWinCount(Rank rank) {
        winPrices.put(rank, winPrices.get(rank) + 1);
    }

    public Integer getWinCount(Rank rank) {
        return winPrices.get(rank);
    }

}