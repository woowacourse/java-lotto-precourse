package domain;

import java.util.List;
import java.util.ArrayList;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        return Rank.valueOf(getCountOfMatch(userLotto), hasMatchBonus(userLotto));
    }

    private int getCountOfMatch(Lotto userLotto) {
        List<Integer> userLottoNumbers = new ArrayList<Integer>();

        userLottoNumbers.addAll(userLotto.getLottoNumbers());
        userLottoNumbers.retainAll(this.lotto.getLottoNumbers());

        return userLottoNumbers.size();
    }

    private boolean hasMatchBonus(Lotto userLotto) {
        return userLotto.getLottoNumbers().contains(this.bonusNo);
    }
}
