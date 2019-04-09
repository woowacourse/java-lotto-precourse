package domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoRankAnalyzer {

    public LottoRankCount getLottoRankCount(List<Lotto> lottos, WinningLotto winningLotto) {
        List<Rank> ranks = calculateRank(lottos, winningLotto);

        LottoRankCount lottoRankCount = new LottoRankCount();
        ranks.forEach(lottoRankCount::put);
        return lottoRankCount;
    }

    private List<Rank> calculateRank(List<Lotto> lottos, WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::match)
                .collect(Collectors.toList());
    }
}
