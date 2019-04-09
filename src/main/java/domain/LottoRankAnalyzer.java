package domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoRankAnalyzer {
    private WinningLotto winningLotto;

    public LottoRankAnalyzer(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public LottoRankCount getLottoRankCount(List<Lotto> lottos) {
        List<Rank> ranks = calculateRank(lottos);

        LottoRankCount lottoRankCount = new LottoRankCount();
        ranks.forEach(lottoRankCount::put);
        return lottoRankCount;
    }

    private List<Rank> calculateRank(List<Lotto> lottos) {
        return lottos.stream()
                .map(winningLotto::match)
                .collect(Collectors.toList());
    }

    public EarningRate getEarningRate(List<Lotto> lottos, int money) {
        List<Rank> ranks = calculateRank(lottos);
        long winningMoney = getWinningMoney(ranks);
        return new EarningRate(winningMoney / (double) money);
    }

    private long getWinningMoney(List<Rank> ranks) {
        return ranks.stream()
                .mapToInt(Rank::getWinningMoney)
                .sum();
    }
}
