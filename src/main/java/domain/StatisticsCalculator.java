package domain;

import java.util.List;

public class StatisticsCalculator {

    private static final int RANK_ARRAY_SIZE = 8;
    private static final int NUMBER_FOR_PERCENTAGE_CONVERSION = 100;

    public Rank[] rankArray = new Rank[]{Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST};
    public int[] countWins;
    public static double profitRate;

    public void calculateStatistics(List<Lotto> lottos, WinningLotto winningLotto, long validAmount) {
        long totalWinningMoney = 0;
        int fifthToFirst = 3;
        countWins = new int[RANK_ARRAY_SIZE];  /*5등은 3개를 맞추었으니 3번 인덱스에 wins를 기록 -> 1등은 7번 인덱스*/
        for (Lotto userLotto : lottos) {
            calculateHowManyWins(winningLotto, userLotto);
        }
        for (Rank r : rankArray) {
            totalWinningMoney += countWins[fifthToFirst++] * r.getWinningMoney();
        }
        profitRate = ((double) totalWinningMoney / validAmount) * NUMBER_FOR_PERCENTAGE_CONVERSION;
    }

    public void calculateHowManyWins(WinningLotto winningLotto, Lotto userLotto) {
        for (Rank r : rankArray) {
            fillCountWins(r, winningLotto, userLotto);
        }
    }

    public void fillCountWins(Rank r, WinningLotto winningLotto, Lotto userLotto) {
        if (winningLotto.match(userLotto) == r) {
            countWins[r.getCountOfMatch()]++;
            return;
        }
    }


}
