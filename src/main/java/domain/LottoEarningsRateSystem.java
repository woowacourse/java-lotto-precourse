package domain;

import java.util.List;

/**
 * 수익률을 계산하는 객체
 */
class LottoEarningsRateSystem {
    private static final int PERCENT = 100;

    double getEarningsRate(List<Lotto> lottoList, WinningLotto winningLotto) {
        return (double) getWinningMoneyTotal(lottoList, winningLotto) / (lottoList.size() * LottoGameSystem.LOTTO_PRICE) * PERCENT;
    }

    private int getWinningMoneyTotal(List<Lotto> lottoList, WinningLotto winningLotto) {
        int winningMoneyTotal = 0;

        for (Rank rank : Rank.values()) {
            winningMoneyTotal += getWinningMoneyTotalByRank(lottoList, winningLotto, rank);
        }

        return winningMoneyTotal;
    }

    private int getWinningMoneyTotalByRank(List<Lotto> lottoList, WinningLotto winningLotto, Rank rank) {
        return getLottoCountByRank(lottoList, winningLotto, rank) * rank.getWinningMoney();
    }

    private int getLottoCountByRank(List<Lotto> lottoList, WinningLotto winningLotto, Rank rank) {
        return Math.toIntExact(lottoList.stream().filter(lotto -> winningLotto.match(lotto) == rank).count());
    }

    void printResultByRank(List<Lotto> lottoList, WinningLotto winningLotto, Rank rank) {
        if (rank == Rank.SECOND) {
            System.out.println(String.format("%d개 일치, 보너스 볼 일치 (%d원)- %d개",
                    rank.getCountOfMatch(), rank.getWinningMoney(), getLottoCountByRank(lottoList, winningLotto, rank)));

            return;
        }
        System.out.println(String.format("%d개 일치 (%d원)- %d개",
                rank.getCountOfMatch(), rank.getWinningMoney(), getLottoCountByRank(lottoList, winningLotto, rank)));
    }
}
