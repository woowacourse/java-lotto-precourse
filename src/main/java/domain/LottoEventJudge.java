package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoEventJudge {

    private final WinningLotto winningLotto;

    public LottoEventJudge(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public List<Rank> judgeLottoEvent(List<Lotto> purchasedLotto) {
        List<Rank> results = new ArrayList<>();
        for (Lotto lotto : purchasedLotto) {
            Rank rank = winningLotto.match(lotto);
            results.add(rank);
        }
        return Collections.unmodifiableList(results);
    }
}
