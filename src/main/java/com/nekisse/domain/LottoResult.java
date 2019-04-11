package com.nekisse.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private Map<Rank, Integer> lottoResults;

    public LottoResult(WinningLotto winningLotto, UserLottos userLottos) {
        this.lottoResults = initLottoResults();
        saveLotteryResult(winningLotto, userLottos);
    }

    public Map<Rank, Integer> getLottoResults() {
        return lottoResults;
    }

    private Map<Rank, Integer> initLottoResults() {
        lottoResults = new HashMap<>();
        for (Rank rank : Rank.values()) {
            lottoResults.put(rank, 0);
        }
        return lottoResults;
    }

    private void saveLotteryResult(WinningLotto winningLotto, UserLottos userLottos) {
        for (Lotto userLotto : userLottos.getUserLottos()) {
            Rank rank = winningLotto.match(userLotto);
            lottoResults.put(rank, lottoResults.get(rank) + 1);
        }
    }
}
