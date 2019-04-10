package domain;

import domain.util.PrintScan;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class RankResult {
    private static Map<Rank, Integer> rankHash = new HashMap<>();
    private static Rank[] rankStrings = Rank.values();

    List<Lotto> userLottoList;
    WinningLotto winningLotto;

    public RankResult(List<Lotto> userLottoList, WinningLotto winningLotto) {
        this.userLottoList = userLottoList;
        this.winningLotto = winningLotto;
    }

    public void getRankResult() {
        getRankMap();
        printResultInformation(rankHash);
    }

    public void getRankMap() {
        initHash();
        for (Lotto lotto : userLottoList) {
            Rank rankString = winningLotto.match(lotto);
            int rankNum = rankHash.get(rankString) + 1;
            rankHash.replace(rankString, rankNum);
        }
    }

    public static void initHash() {
        for (int i = 0; i < rankStrings.length; i++) {
            rankHash.put(rankStrings[i], new Integer(0));
        }
    }

    public static void printResultInformation(Map<Rank, Integer> resultMap) {
        PrintScan.printResult();
        Rank[] rankArray = {Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST};
        for (Rank rank : rankArray) {
            PrintScan.printWinning(rank, resultMap.get(rank));
        }
    }

    public void getWinningMoney() {

    }


}
