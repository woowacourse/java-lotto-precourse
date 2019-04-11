package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.List;


/**
 * 로또 등수 검사해주는 객체
 */
public class LottoRankChecker {

    public static List<Rank> getRanks(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : purchasedLottos)
            ranks.add(winningLotto.match(lotto));
        return ranks;
    }

}
