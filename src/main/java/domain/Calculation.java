package domain;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Calculation {

    /*
     * 구입 금액을 받아서 금액에 맞는 로또 개수 계산
     */
    public static int calcLottoCount(int price) {
        return (price/1000);
    }

    /*
     * 1개 등수에 대한 총 금액을 구하기 위한 메소드
     */
    public static int calcYieldOneRank(List<Rank> rankList,  int countOfMatch, boolean matchBonus) {
        Rank currentRank = Rank.valueOf(countOfMatch, matchBonus);
        int rankCount = Collections.frequency(rankList, currentRank);
        return (rankCount * currentRank.getWinningMoney());
    }

    /*
     * 전체 로또 구매 개수에 대한 수익률 계산을 위한 메소드
     */
    public static double calcYield(List<Rank> rankList, int lottoCount) {
        int totalWinning = 0;
        totalWinning += calcYieldOneRank(rankList, Rank.FIFTH.getCountOfMatch(), false);
        totalWinning += calcYieldOneRank(rankList, Rank.FOURTH.getCountOfMatch(), false);
        totalWinning += calcYieldOneRank(rankList, Rank.THIRD.getCountOfMatch(), false);
        totalWinning += calcYieldOneRank(rankList, Rank.SECOND.getCountOfMatch(), true);
        totalWinning += calcYieldOneRank(rankList, Rank.FIRST.getCountOfMatch(), false);
        return ((double)totalWinning / (lottoCount * 1000));
    }

}
