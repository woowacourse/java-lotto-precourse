/*
 * Class: WinningLotto.java
 * Version: 1.0
 * Date: 2019-04-09
 * Author: Kibaek Yoo
 */

package domain;

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
        int countOfMatch = userLotto.getCountOfMatch(this.lotto.getNumbers());
        boolean isBonusContain = userLotto.checkNumberContain(this.bonusNo);

        return Rank.valueOf(countOfMatch, isBonusContain);
    }


}
