package domain;

import domain.util.PrintScan;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class RankResult {
    List<Lotto> userLottoList;
    WinningLotto winningLotto;
    private static Map<Rank, Integer> rankHash = new HashMap<>();
    private static Rank[] rankStrings = Rank.values();
    private static int winningMoney = 0;

    public RankResult(List<Lotto> userLottoList, WinningLotto winningLotto) {
        this.userLottoList = userLottoList;
        this.winningLotto = winningLotto;
    }

    public void getRankResult() {
        getRankMap();
        printResultInformation(rankHash);
        setWinningMoney();

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
        Rank[] rankArray = {Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST};
        for (Rank rank : rankArray) {
            PrintScan.printWinning(rank, resultMap.get(rank));
        }
    }

    public void setWinningMoney() {
        for (Rank hashKey : rankHash.keySet()) {
            int winningPrice = hashKey.getWinningMoney();
            winningMoney += winningPrice * rankHash.get(hashKey);
        }
    }

    public void setEarnRate(int numberOfLotto) {
        float spendMoney = numberOfLotto * 1000;
        float earnRate = winningMoney / spendMoney;
        PrintScan.printEarnRate(earnRate);
    }
}
