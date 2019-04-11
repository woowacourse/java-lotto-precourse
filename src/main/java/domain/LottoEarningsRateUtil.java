package domain;

import java.util.List;

/**
 * 수익률을 계산하는 객체
 */
class LottoEarningsRateUtil {
    private static final int PERCENT = 100;

    static double getEarningsRate(List<Lotto> lottoList, WinningLotto winningLotto) {
        int winningMoneyTotal = 0;

        for (Rank rank : Rank.values()) {
            winningMoneyTotal += getLottoCountByRank(lottoList, winningLotto, rank) * rank.getWinningMoney();
        }

        /* 당첨금액 / (로또개수 * 로또가격) * 100 */
        return (double) winningMoneyTotal / (lottoList.size() * LottoGame.LOTTO_PRICE) * PERCENT;
    }

    private static int getLottoCountByRank(List<Lotto> lottoList, WinningLotto winningLotto, Rank rank) {
        return Math.toIntExact(lottoList.stream().filter(lotto -> winningLotto.match(lotto) == rank).count());
    }

    static String getResultByRankMessage(List<Lotto> lottoList, WinningLotto winningLotto, Rank rank) {
        if (rank == Rank.SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치 (%d원)- %d개\n",
                    rank.getCountOfMatch(), rank.getWinningMoney(), getLottoCountByRank(lottoList, winningLotto, rank));
        }

        return String.format("%d개 일치 (%d원)- %d개\n",
                rank.getCountOfMatch(), rank.getWinningMoney(), getLottoCountByRank(lottoList, winningLotto, rank));
    }
}
