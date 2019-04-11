package domain;

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
        int countOfMatch = 0;
        List<Integer> userLottoNumList = userLotto.getNumbers();

        for (Integer i : userLottoNumList) {
            countOfMatch += this.lotto.hasNumber(i) ? 1 : 0;
        }

        return Rank.valueOf(countOfMatch, userLotto.hasNumber(this.bonusNo));
    }
}
