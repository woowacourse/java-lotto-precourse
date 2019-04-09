package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    Map<Rank, Integer> rankMap;

    public LottoResult (List<Lotto> lottos, WinningLotto winningLotto) {
        initializeRankMap();
        for(Lotto lotto : lottos) {
            incrementValueIfMapHasKey(winningLotto.match(lotto));
        }
    }

    private void initializeRankMap() {
        rankMap = new HashMap<>();
        for ( Rank rank : Rank.values()
             ) {
            rankMap.put(rank, 0);
        }
    }

    private void incrementValueIfMapHasKey(Rank rank) {
        int oldValue = rankMap.get(rank);
        rankMap.put(rank, oldValue + 1);
    }
    /*
    calculateProfit() {

    }

    showProfit() {

    }
    */

    @Override
    public String toString() {
        return rankMap.toString();
    }
}
