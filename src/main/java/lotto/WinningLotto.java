package lotto;

import static constants.LottoConstants.BONUS_NUMBER_ERROR;
import static lotto.Lotto.checkRange;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        checkBonusNumber(lotto, bonusNo);
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        return Rank.valueOf(countOfMatch(userLotto), matchBonus(userLotto));
    }

    private int countOfMatch(Lotto userLotto) {
        int count = 0;
        for (int number : userLotto.getNumbers()) {
            count += lotto.getNumbers().contains(number) ? 1 : 0;
        }
        return count;
    }

    private boolean matchBonus(Lotto userLotto) {
        return userLotto.getNumbers().contains(bonusNo);
    }

    private void checkBonusNumber(Lotto lotto, int bonusNo) {
        checkRange(bonusNo);
        if (lotto.getNumbers().contains(bonusNo)) {
            throw new IllegalArgumentException(BONUS_NUMBER_ERROR);
        }
    }
}
