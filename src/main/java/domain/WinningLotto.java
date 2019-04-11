package domain;

import java.util.ArrayList;
import java.util.List;

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
        return null;
    }

    private List<Integer> compare(final Lotto userLotto) {
        List<Integer> ret = new ArrayList<>(2);
        for (int i = 0; i < Lotto.LOTTO_NUM_CNT; ++i) {
            if (userLotto.isContainNumber(lotto.getEleNumber(i))) {
                ret.add(ret.get(0) + 1);
            }
        }
        return ret;
    }
}
