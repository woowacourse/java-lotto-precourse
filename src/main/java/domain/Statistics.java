package domain;

import static domain.Constants.*;

class Statistics {
    private long winningMoney = 0;
    private int[] winningCount = new int[NUM_OF_RANK];
    private double rateOfReturn;

    void printStatistics() {
        System.out.printf("\n당첨 통계\n");
        System.out.printf("---------\n");
        System.out.printf("%d개 일치 (%d원)- %d개\n", Rank.FIFTH.getCountOfMatch(), Rank.FIFTH.getWinningMoney(), winningCount[Rank.FIFTH.ordinal()]);
        System.out.printf("%d개 일치 (%d원)- %d개\n", Rank.FOURTH.getCountOfMatch(), Rank.FOURTH.getWinningMoney(), winningCount[Rank.FOURTH.ordinal()]);
        System.out.printf("%d개 일치 (%d원)- %d개\n", Rank.THIRD.getCountOfMatch(), Rank.THIRD.getWinningMoney(), winningCount[Rank.THIRD.ordinal()]);
        System.out.printf("%d개 일치, 보너스 볼 일치 (%d원)- %d개\n", Rank.SECOND.getCountOfMatch(), Rank.SECOND.getWinningMoney(), winningCount[Rank.SECOND.ordinal()]);
        System.out.printf("%d개 일치 (%d원)- %d개\n", Rank.FIRST.getCountOfMatch(), Rank.FIRST.getWinningMoney(), winningCount[Rank.FIRST.ordinal()]);
        System.out.printf("총 수익률은 %.3f입니다.\n", rateOfReturn);
    }

    void compileStatistics(Lotto[] lotto, WinningLotto winningLotto) {
        for (int i = 0; i < lotto.length; i++) {
            Rank rank = winningLotto.match(lotto[i]);
            winningMoney += rank.getWinningMoney();
            winningCount[rank.ordinal()]++;
        }
    }

    void setRateOfReturn(int numOfLotto) {
        rateOfReturn = (double) winningMoney / (numOfLotto * MIN_UNIT);
    }
}