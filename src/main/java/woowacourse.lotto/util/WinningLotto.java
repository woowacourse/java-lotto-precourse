package woowacourse.lotto.util;

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
        boolean matchBonus = userLotto.hasNumber(bonusNo);
        return Rank.valueOf(lotto.countMatch(userLotto), matchBonus);
    }
}
