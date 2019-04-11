import domain.Lotto;
import domain.Rank;
import domain.WinningLotto;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private List<Rank> lottoRanks = new ArrayList<>();

    public LottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        for(Lotto lotto : lottos) {
            lottoRanks.add(winningLotto.match(lotto));
        }
    }

    public int getMatchCount(Rank rank) {
        int matchSumCount = 0;
        for(Rank lottorank : lottoRanks) {
            if(lottorank == rank)
                matchSumCount++;
        }

        return matchSumCount;
    }

    public List<Rank> getLottoRanks() {
        return lottoRanks;
    }
} 
