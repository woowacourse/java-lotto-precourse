package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class RankResult {
    private static Map<Rank, Integer> rankHash = new HashMap<>();
    List<Lotto> userLottoList;
    WinningLotto winningLotto;

    public RankResult(List<Lotto> userLottoList, WinningLotto winningLotto) {
        this.userLottoList = userLottoList;
        this.winningLotto = winningLotto;
    }

    public void getRankResult() {
        rankHash = getRankMap();

    }

    public Map<Rank, Integer> getRankMap() {
        Map<Rank, Integer> hash = new HashMap<>();
        for (Lotto lotto : userLottoList) {
            Rank rankString = winningLotto.match(lotto);
            int rankNum = hash.get(rankString) + 1;
            hash.replace(rankString, rankNum);
        }
        return hash;
    }

}
